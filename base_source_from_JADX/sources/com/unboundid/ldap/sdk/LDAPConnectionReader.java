package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.util.Debug;
import com.unboundid.util.DebugType;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.WakeableSleeper;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

@InternalUseOnly
final class LDAPConnectionReader extends Thread {
    private static final int DEFAULT_INPUT_BUFFER_SIZE = 4096;
    private final ConcurrentHashMap<Integer, ResponseAcceptor> acceptorMap;
    private volatile ASN1StreamReader asn1StreamReader;
    private volatile boolean closeRequested;
    private final LDAPConnection connection;
    private volatile InputStream inputStream = new BufferedInputStream(this.socket.getInputStream(), 4096);
    private volatile Socket socket;
    private volatile SSLContext sslContext;
    private volatile Exception startTLSException;
    private volatile OutputStream startTLSOutputStream;
    private final WakeableSleeper startTLSSleeper;
    private volatile Thread thread;

    LDAPConnectionReader(LDAPConnection lDAPConnection, LDAPConnectionInternals lDAPConnectionInternals) {
        this.connection = lDAPConnection;
        setName(constructThreadName(lDAPConnectionInternals));
        setDaemon(true);
        this.socket = lDAPConnectionInternals.getSocket();
        this.asn1StreamReader = new ASN1StreamReader(this.inputStream, lDAPConnection.getConnectionOptions().getMaxMessageSize());
        this.acceptorMap = new ConcurrentHashMap<>();
        this.closeRequested = false;
        this.sslContext = null;
        this.startTLSException = null;
        this.startTLSOutputStream = null;
        this.startTLSSleeper = new WakeableSleeper();
        if (!lDAPConnectionInternals.synchronousMode()) {
            int connectTimeoutMillis = lDAPConnection.getConnectionOptions().getConnectTimeoutMillis();
            if (connectTimeoutMillis > 0) {
                if (Debug.debugEnabled()) {
                    Level level = Level.INFO;
                    DebugType debugType = DebugType.CONNECT;
                    Debug.debug(level, debugType, "Setting SO_TIMEOUT to connect timeout of " + connectTimeoutMillis + "ms in LDAPConnectionReader constructor");
                }
                this.socket.setSoTimeout(connectTimeoutMillis);
            } else {
                if (Debug.debugEnabled()) {
                    Debug.debug(Level.INFO, DebugType.CONNECT, "Setting SO_TIMEOUT to 0ms in LDAPConnectionReader constructor");
                }
                this.socket.setSoTimeout(0);
            }
            if (this.socket instanceof SSLSocket) {
                ((SSLSocket) this.socket).startHandshake();
            }
        }
    }

    private void closeInternal(boolean z, String str) {
        ConnectionClosedResponse connectionClosedResponse;
        InputStream inputStream2 = this.inputStream;
        this.inputStream = null;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (Exception e) {
                Debug.debugException(e);
            }
        }
        if (z) {
            this.connection.setClosed();
        }
        Iterator<Integer> it = this.acceptorMap.keySet().iterator();
        while (it.hasNext()) {
            ResponseAcceptor responseAcceptor = this.acceptorMap.get(Integer.valueOf(it.next().intValue()));
            if (str == null) {
                try {
                    DisconnectType disconnectType = this.connection.getDisconnectType();
                    if (disconnectType == null) {
                        connectionClosedResponse = new ConnectionClosedResponse(ResultCode.SERVER_DOWN, (String) null);
                    } else {
                        responseAcceptor.responseReceived(new ConnectionClosedResponse(disconnectType.getResultCode(), this.connection.getDisconnectMessage()));
                        it.remove();
                    }
                } catch (Exception e2) {
                    Debug.debugException(e2);
                }
            } else {
                connectionClosedResponse = new ConnectionClosedResponse(ResultCode.SERVER_DOWN, str);
            }
            responseAcceptor.responseReceived(connectionClosedResponse);
            it.remove();
        }
    }

    private String constructThreadName(LDAPConnectionInternals lDAPConnectionInternals) {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection reader for connection ");
        sb.append(this.connection.getConnectionID());
        sb.append(' ');
        String connectionName = this.connection.getConnectionName();
        if (connectionName != null) {
            sb.append('\'');
            sb.append(connectionName);
            sb.append("' ");
        }
        String connectionPoolName = this.connection.getConnectionPoolName();
        if (connectionPoolName != null) {
            sb.append("in pool '");
            sb.append(connectionPoolName);
            sb.append("' ");
        }
        if (lDAPConnectionInternals == null) {
            sb.append("(not connected)");
        } else {
            sb.append("to ");
            sb.append(lDAPConnectionInternals.getHost());
            sb.append(':');
            sb.append(lDAPConnectionInternals.getPort());
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void close(boolean z) {
        this.closeRequested = true;
        int i = 0;
        while (true) {
            if (i >= 5) {
                break;
            }
            try {
                Thread thread2 = this.thread;
                if (thread2 == null || thread2 == Thread.currentThread()) {
                    break;
                } else if (!thread2.isAlive()) {
                    break;
                } else {
                    thread2.interrupt();
                    thread2.join(100);
                    i++;
                }
            } catch (Exception e) {
                Debug.debugException(e);
            }
        }
        closeInternal(z, (String) null);
    }

    /* access modifiers changed from: package-private */
    public void deregisterResponseAcceptor(int i) {
        this.acceptorMap.remove(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public OutputStream doStartTLS(SSLContext sSLContext) {
        SSLSocket sSLSocket;
        if (this.connection.synchronousMode()) {
            try {
                int connectTimeoutMillis = this.connection.getConnectionOptions().getConnectTimeoutMillis();
                if (connectTimeoutMillis > 0) {
                    if (Debug.debugEnabled()) {
                        Level level = Level.INFO;
                        DebugType debugType = DebugType.CONNECT;
                        Debug.debug(level, debugType, "Setting SO_TIMEOUT to connect timeout of " + connectTimeoutMillis + "ms in " + "LDAPConnectionReader.doStartTLS while performing " + "StartTLS processing.");
                    }
                    this.socket.setSoTimeout(connectTimeoutMillis);
                } else {
                    if (Debug.debugEnabled()) {
                        Debug.debug(Level.INFO, DebugType.CONNECT, "Setting SO_TIMEOUT to 0ms in LDAPConnectionReader.doStartTLS while performing StartTLS processing.");
                    }
                    this.socket.setSoTimeout(0);
                }
                SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                synchronized (socketFactory) {
                    sSLSocket = (SSLSocket) socketFactory.createSocket(this.socket, this.connection.getConnectedAddress(), this.socket.getPort(), true);
                    sSLSocket.startHandshake();
                }
                this.inputStream = new BufferedInputStream(sSLSocket.getInputStream(), 4096);
                this.asn1StreamReader = new ASN1StreamReader(this.inputStream, this.connection.getConnectionOptions().getMaxMessageSize());
                this.startTLSOutputStream = sSLSocket.getOutputStream();
                this.socket = sSLSocket;
                OutputStream outputStream = this.startTLSOutputStream;
                this.startTLSOutputStream = null;
                return outputStream;
            } catch (Exception e) {
                Debug.debugException(e);
                this.connection.setDisconnectInfo(DisconnectType.SECURITY_PROBLEM, StaticUtils.getExceptionMessage(e), e);
                this.startTLSException = e;
                this.closeRequested = true;
                closeInternal(true, StaticUtils.getExceptionMessage(e));
                throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONNREADER_STARTTLS_FAILED.get(StaticUtils.getExceptionMessage(e)), e);
            }
        } else {
            this.sslContext = sSLContext;
            while (this.startTLSOutputStream == null) {
                if (this.thread != null) {
                    this.startTLSSleeper.sleep(10);
                } else if (this.startTLSException == null) {
                    throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_CONNREADER_STARTTLS_FAILED_NO_EXCEPTION.get());
                } else {
                    Exception exc = this.startTLSException;
                    this.startTLSException = null;
                    throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_CONNREADER_STARTTLS_FAILED.get(StaticUtils.getExceptionMessage(exc)), exc);
                }
            }
            OutputStream outputStream2 = this.startTLSOutputStream;
            this.startTLSOutputStream = null;
            return outputStream2;
        }
    }

    /* access modifiers changed from: package-private */
    public int getActiveOperationCount() {
        return this.acceptorMap.size();
    }

    /* access modifiers changed from: package-private */
    public Thread getReaderThread() {
        return this.thread;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00be, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bf, code lost:
        com.unboundid.util.Debug.debugException(r10);
        r4 = java.util.logging.Level.SEVERE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        if ((r10 instanceof java.io.IOException) != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        r9.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.IO_ERROR, (java.lang.String) null, r10);
        r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_IO_EXCEPTION.get(r9.connection.getHostPort(), com.unboundid.util.StaticUtils.getExceptionMessage(r10));
        r4 = java.util.logging.Level.WARNING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ea, code lost:
        if ((r10 instanceof com.unboundid.asn1.ASN1Exception) != false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ec, code lost:
        r9.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR, (java.lang.String) null, r10);
        r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_ASN1_EXCEPTION;
        r1 = new java.lang.Object[]{r9.connection.getHostPort(), com.unboundid.util.StaticUtils.getExceptionMessage(r10)};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0106, code lost:
        r9.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.LOCAL_ERROR, (java.lang.String) null, r10);
        r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_EXCEPTION;
        r1 = new java.lang.Object[]{r9.connection.getHostPort(), com.unboundid.util.StaticUtils.getExceptionMessage(r10)};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011f, code lost:
        r0 = r0.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0123, code lost:
        com.unboundid.util.Debug.debug(r4, com.unboundid.util.DebugType.LDAP, r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0132, code lost:
        if (r9.connection.getConnectionOptions().autoReconnect() == false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0138, code lost:
        r9.connection.reconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013e, code lost:
        r9.closeRequested = true;
        closeInternal(true, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x014a, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(com.unboundid.ldap.sdk.ResultCode.SERVER_DOWN, r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x014b, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014c, code lost:
        com.unboundid.util.Debug.debugException(r10);
        r0 = r10.getCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0153, code lost:
        if (r0 == null) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0165, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(com.unboundid.ldap.sdk.ResultCode.TIMEOUT, r10.getMessage(), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0166, code lost:
        r4 = java.util.logging.Level.SEVERE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0168, code lost:
        if (r0 == null) goto L_0x016a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016a, code lost:
        r9.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR, r10.getMessage(), r0);
        r1 = r10.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0179, code lost:
        r4 = java.util.logging.Level.WARNING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017e, code lost:
        if ((r0 instanceof java.io.IOException) != false) goto L_0x0180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0180, code lost:
        r9.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.IO_ERROR, r10.getMessage(), r0);
        r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_IO_EXCEPTION.get(r9.connection.getHostPort(), com.unboundid.util.StaticUtils.getExceptionMessage(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a4, code lost:
        if ((r0 instanceof com.unboundid.asn1.ASN1Exception) != false) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a6, code lost:
        r9.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR, r10.getMessage(), r0);
        r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_ASN1_EXCEPTION;
        r1 = new java.lang.Object[]{r9.connection.getHostPort(), com.unboundid.util.StaticUtils.getExceptionMessage(r0)};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c4, code lost:
        r9.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.LOCAL_ERROR, r10.getMessage(), r0);
        r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_EXCEPTION;
        r1 = new java.lang.Object[]{r9.connection.getHostPort(), com.unboundid.util.StaticUtils.getExceptionMessage(r0)};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01e1, code lost:
        r1 = r5.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e5, code lost:
        com.unboundid.util.Debug.debug(r4, com.unboundid.util.DebugType.LDAP, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01f4, code lost:
        if (r9.connection.getConnectionOptions().autoReconnect() == false) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01fa, code lost:
        r9.connection.reconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0200, code lost:
        r9.closeRequested = true;
        closeInternal(true, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0205, code lost:
        throw r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x014b A[ExcHandler: LDAPException (r10v1 'e' com.unboundid.ldap.sdk.LDAPException A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.unboundid.ldap.protocol.LDAPResponse readResponse(int r10) {
        /*
            r9 = this;
        L_0x0000:
            r0 = 0
            r1 = 2
            r2 = 0
            r3 = 1
            com.unboundid.asn1.ASN1StreamReader r4 = r9.asn1StreamReader     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.schema.Schema r5 = r5.getCachedSchema()     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.protocol.LDAPResponse r4 = com.unboundid.ldap.protocol.LDAPMessage.readLDAPResponseFrom(r4, r2, r5)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r4 != 0) goto L_0x001a
            com.unboundid.ldap.sdk.ConnectionClosedResponse r10 = new com.unboundid.ldap.sdk.ConnectionClosedResponse     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.ResultCode r4 = com.unboundid.ldap.sdk.ResultCode.SERVER_DOWN     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            r10.<init>(r4, r0)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            return r10
        L_0x001a:
            int r5 = r4.getMessageID()     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r5 != r10) goto L_0x0021
            return r4
        L_0x0021:
            boolean r5 = r4 instanceof com.unboundid.ldap.sdk.ExtendedResult     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r5 == 0) goto L_0x00a1
            int r5 = r4.getMessageID()     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r5 != 0) goto L_0x00a1
            r5 = r4
            com.unboundid.ldap.sdk.ExtendedResult r5 = (com.unboundid.ldap.sdk.ExtendedResult) r5     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.String r6 = r5.getOID()     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.String r7 = "1.3.6.1.4.1.1466.20036"
            boolean r7 = r7.equals(r6)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r7 == 0) goto L_0x004b
            com.unboundid.ldap.sdk.extensions.NoticeOfDisconnectionExtendedResult r6 = new com.unboundid.ldap.sdk.extensions.NoticeOfDisconnectionExtendedResult     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            r6.<init>(r5)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.DisconnectType r7 = com.unboundid.ldap.sdk.DisconnectType.SERVER_CLOSED_WITH_NOTICE     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.String r8 = r6.getDiagnosticMessage()     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            r5.setDisconnectInfo(r7, r8, r0)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            goto L_0x0073
        L_0x004b:
            java.lang.String r7 = "1.3.6.1.4.1.30221.2.6.5"
            boolean r6 = r7.equals(r6)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r6 == 0) goto L_0x0072
            java.lang.String r6 = "com.unboundid.ldap.sdk.unboundidds.extensions.InteractiveTransactionAbortedExtendedResult"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            java.lang.Class<com.unboundid.ldap.sdk.ExtendedResult> r8 = com.unboundid.ldap.sdk.ExtendedResult.class
            r7[r2] = r8     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            r7[r2] = r5     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            com.unboundid.ldap.sdk.ExtendedResult r6 = (com.unboundid.ldap.sdk.ExtendedResult) r6     // Catch:{ Exception -> 0x006e, LDAPException -> 0x014b }
            goto L_0x0073
        L_0x006e:
            r6 = move-exception
            com.unboundid.util.Debug.debugException(r6)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
        L_0x0072:
            r6 = r5
        L_0x0073:
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r5 = r5.getConnectionOptions()     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.UnsolicitedNotificationHandler r5 = r5.getUnsolicitedNotificationHandler()     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r5 != 0) goto L_0x009a
            com.unboundid.util.DebugType r5 = com.unboundid.util.DebugType.LDAP     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            boolean r5 = com.unboundid.util.Debug.debugEnabled(r5)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r5 == 0) goto L_0x0000
            java.util.logging.Level r5 = java.util.logging.Level.WARNING     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.util.DebugType r6 = com.unboundid.util.DebugType.LDAP     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.LDAPMessages r7 = com.unboundid.ldap.sdk.LDAPMessages.WARN_READER_UNHANDLED_UNSOLICITED_NOTIFICATION     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            r8[r2] = r4     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.String r4 = r7.get(r8)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
        L_0x0095:
            com.unboundid.util.Debug.debug(r5, r6, r4)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            goto L_0x0000
        L_0x009a:
            com.unboundid.ldap.sdk.LDAPConnection r4 = r9.connection     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            r5.handleUnsolicitedNotification(r4, r6)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            goto L_0x0000
        L_0x00a1:
            com.unboundid.util.DebugType r5 = com.unboundid.util.DebugType.LDAP     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            boolean r5 = com.unboundid.util.Debug.debugEnabled(r5)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            if (r5 == 0) goto L_0x0000
            java.util.logging.Level r5 = java.util.logging.Level.WARNING     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.util.DebugType r6 = com.unboundid.util.DebugType.LDAP     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            com.unboundid.ldap.sdk.LDAPMessages r7 = com.unboundid.ldap.sdk.LDAPMessages.WARN_READER_DISCARDING_UNEXPECTED_RESPONSE     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            r8[r2] = r4     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            r8[r3] = r4     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            java.lang.String r4 = r7.get(r8)     // Catch:{ LDAPException -> 0x014b, Exception -> 0x00be }
            goto L_0x0095
        L_0x00be:
            r10 = move-exception
            com.unboundid.util.Debug.debugException(r10)
            java.util.logging.Level r4 = java.util.logging.Level.SEVERE
            boolean r5 = r10 instanceof java.io.IOException
            if (r5 == 0) goto L_0x00e8
            com.unboundid.ldap.sdk.LDAPConnection r4 = r9.connection
            com.unboundid.ldap.sdk.DisconnectType r5 = com.unboundid.ldap.sdk.DisconnectType.IO_ERROR
            r4.setDisconnectInfo(r5, r0, r10)
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_IO_EXCEPTION
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.unboundid.ldap.sdk.LDAPConnection r4 = r9.connection
            java.lang.String r4 = r4.getHostPort()
            r1[r2] = r4
            java.lang.String r2 = com.unboundid.util.StaticUtils.getExceptionMessage(r10)
            r1[r3] = r2
            java.lang.String r0 = r0.get(r1)
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            goto L_0x0123
        L_0x00e8:
            boolean r5 = r10 instanceof com.unboundid.asn1.ASN1Exception
            if (r5 == 0) goto L_0x0106
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR
            r5.setDisconnectInfo(r6, r0, r10)
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_ASN1_EXCEPTION
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection
            java.lang.String r5 = r5.getHostPort()
            r1[r2] = r5
            java.lang.String r2 = com.unboundid.util.StaticUtils.getExceptionMessage(r10)
            r1[r3] = r2
            goto L_0x011f
        L_0x0106:
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.LOCAL_ERROR
            r5.setDisconnectInfo(r6, r0, r10)
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_EXCEPTION
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection
            java.lang.String r5 = r5.getHostPort()
            r1[r2] = r5
            java.lang.String r2 = com.unboundid.util.StaticUtils.getExceptionMessage(r10)
            r1[r3] = r2
        L_0x011f:
            java.lang.String r0 = r0.get(r1)
        L_0x0123:
            com.unboundid.util.DebugType r1 = com.unboundid.util.DebugType.LDAP
            com.unboundid.util.Debug.debug(r4, r1, r0, r10)
            com.unboundid.ldap.sdk.LDAPConnection r1 = r9.connection
            com.unboundid.ldap.sdk.LDAPConnectionOptions r1 = r1.getConnectionOptions()
            boolean r1 = r1.autoReconnect()
            if (r1 == 0) goto L_0x013e
            boolean r1 = r9.closeRequested
            if (r1 != 0) goto L_0x013e
            com.unboundid.ldap.sdk.LDAPConnection r1 = r9.connection
            r1.reconnect()
            goto L_0x0143
        L_0x013e:
            r9.closeRequested = r3
            r9.closeInternal(r3, r0)
        L_0x0143:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.SERVER_DOWN
            r1.<init>(r2, r0, r10)
            throw r1
        L_0x014b:
            r10 = move-exception
            com.unboundid.util.Debug.debugException(r10)
            java.lang.Throwable r0 = r10.getCause()
            if (r0 == 0) goto L_0x0166
            boolean r4 = r0 instanceof java.net.SocketTimeoutException
            if (r4 != 0) goto L_0x015a
            goto L_0x0166
        L_0x015a:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.TIMEOUT
            java.lang.String r2 = r10.getMessage()
            r0.<init>(r1, r2, r10)
            throw r0
        L_0x0166:
            java.util.logging.Level r4 = java.util.logging.Level.SEVERE
            if (r0 != 0) goto L_0x017c
            com.unboundid.ldap.sdk.LDAPConnection r1 = r9.connection
            com.unboundid.ldap.sdk.DisconnectType r2 = com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR
            java.lang.String r4 = r10.getMessage()
            r1.setDisconnectInfo(r2, r4, r0)
            java.lang.String r1 = r10.getMessage()
        L_0x0179:
            java.util.logging.Level r4 = java.util.logging.Level.WARNING
            goto L_0x01e5
        L_0x017c:
            boolean r5 = r0 instanceof java.io.IOException
            if (r5 == 0) goto L_0x01a2
            com.unboundid.ldap.sdk.LDAPConnection r4 = r9.connection
            com.unboundid.ldap.sdk.DisconnectType r5 = com.unboundid.ldap.sdk.DisconnectType.IO_ERROR
            java.lang.String r6 = r10.getMessage()
            r4.setDisconnectInfo(r5, r6, r0)
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_IO_EXCEPTION
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection
            java.lang.String r5 = r5.getHostPort()
            r1[r2] = r5
            java.lang.String r2 = com.unboundid.util.StaticUtils.getExceptionMessage(r0)
            r1[r3] = r2
            java.lang.String r1 = r4.get(r1)
            goto L_0x0179
        L_0x01a2:
            boolean r5 = r0 instanceof com.unboundid.asn1.ASN1Exception
            if (r5 == 0) goto L_0x01c4
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR
            java.lang.String r7 = r10.getMessage()
            r5.setDisconnectInfo(r6, r7, r0)
            com.unboundid.ldap.sdk.LDAPMessages r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_ASN1_EXCEPTION
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.unboundid.ldap.sdk.LDAPConnection r6 = r9.connection
            java.lang.String r6 = r6.getHostPort()
            r1[r2] = r6
            java.lang.String r2 = com.unboundid.util.StaticUtils.getExceptionMessage(r0)
            r1[r3] = r2
            goto L_0x01e1
        L_0x01c4:
            com.unboundid.ldap.sdk.LDAPConnection r5 = r9.connection
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.LOCAL_ERROR
            java.lang.String r7 = r10.getMessage()
            r5.setDisconnectInfo(r6, r7, r0)
            com.unboundid.ldap.sdk.LDAPMessages r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_EXCEPTION
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.unboundid.ldap.sdk.LDAPConnection r6 = r9.connection
            java.lang.String r6 = r6.getHostPort()
            r1[r2] = r6
            java.lang.String r2 = com.unboundid.util.StaticUtils.getExceptionMessage(r0)
            r1[r3] = r2
        L_0x01e1:
            java.lang.String r1 = r5.get(r1)
        L_0x01e5:
            com.unboundid.util.DebugType r2 = com.unboundid.util.DebugType.LDAP
            com.unboundid.util.Debug.debug(r4, r2, r1, r0)
            com.unboundid.ldap.sdk.LDAPConnection r0 = r9.connection
            com.unboundid.ldap.sdk.LDAPConnectionOptions r0 = r0.getConnectionOptions()
            boolean r0 = r0.autoReconnect()
            if (r0 == 0) goto L_0x0200
            boolean r0 = r9.closeRequested
            if (r0 != 0) goto L_0x0200
            com.unboundid.ldap.sdk.LDAPConnection r0 = r9.connection
            r0.reconnect()
            goto L_0x0205
        L_0x0200:
            r9.closeRequested = r3
            r9.closeInternal(r3, r1)
        L_0x0205:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.LDAPConnectionReader.readResponse(int):com.unboundid.ldap.protocol.LDAPResponse");
    }

    /* access modifiers changed from: package-private */
    public void registerResponseAcceptor(int i, ResponseAcceptor responseAcceptor) {
        if (this.acceptorMap.putIfAbsent(Integer.valueOf(i), responseAcceptor) != null) {
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_CONNREADER_MSGID_IN_USE.get());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r10.connection.unbindRequestSent() != false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r10.connection.getConnectionOptions().autoReconnect() == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r10.closeRequested = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r10.thread == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r4 = r10.thread;
        r4.setName(r10.thread.getName() + " (closed)");
        r10.thread = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        closeInternal(true, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r10.connection.setDisconnectInfo(com.unboundid.ldap.sdk.DisconnectType.SERVER_CLOSED_WITHOUT_NOTICE, (java.lang.String) null, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r10.closeRequested != false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02be A[Catch:{ Exception -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02bf A[Catch:{ Exception -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02ce A[Catch:{ Exception -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02e0 A[Catch:{ Exception -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x035f A[Catch:{ Exception -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0361 A[Catch:{ Exception -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e3 A[Catch:{ Exception -> 0x01a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017a A[SYNTHETIC, Splitter:B:71:0x017a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r10.thread = r0
        L_0x0006:
            boolean r0 = r10.closeRequested
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0428
            r0 = 2
            com.unboundid.asn1.ASN1StreamReader r4 = r10.asn1StreamReader     // Catch:{ LDAPException -> 0x01ac }
            com.unboundid.ldap.sdk.LDAPConnection r5 = r10.connection     // Catch:{ LDAPException -> 0x01ac }
            com.unboundid.ldap.sdk.schema.Schema r5 = r5.getCachedSchema()     // Catch:{ LDAPException -> 0x01ac }
            com.unboundid.ldap.protocol.LDAPResponse r4 = com.unboundid.ldap.protocol.LDAPMessage.readLDAPResponseFrom(r4, r3, r5)     // Catch:{ LDAPException -> 0x01ac }
            if (r4 != 0) goto L_0x0065
            com.unboundid.ldap.sdk.LDAPConnection r4 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r5 = com.unboundid.ldap.sdk.DisconnectType.SERVER_CLOSED_WITHOUT_NOTICE     // Catch:{ Exception -> 0x01a9 }
            r4.setDisconnectInfo(r5, r2, r2)     // Catch:{ Exception -> 0x01a9 }
            boolean r4 = r10.closeRequested     // Catch:{ Exception -> 0x01a9 }
            if (r4 != 0) goto L_0x003d
            com.unboundid.ldap.sdk.LDAPConnection r4 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            boolean r4 = r4.unbindRequestSent()     // Catch:{ Exception -> 0x01a9 }
            if (r4 != 0) goto L_0x003d
            com.unboundid.ldap.sdk.LDAPConnection r4 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r4 = r4.getConnectionOptions()     // Catch:{ Exception -> 0x01a9 }
            boolean r4 = r4.autoReconnect()     // Catch:{ Exception -> 0x01a9 }
            if (r4 == 0) goto L_0x003d
            goto L_0x03fe
        L_0x003d:
            r10.closeRequested = r3     // Catch:{ Exception -> 0x01a9 }
            java.lang.Thread r4 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            if (r4 == 0) goto L_0x0061
            java.lang.Thread r4 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a9 }
            r5.<init>()     // Catch:{ Exception -> 0x01a9 }
            java.lang.Thread r6 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x01a9 }
            r5.append(r6)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r6 = " (closed)"
            r5.append(r6)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x01a9 }
            r4.setName(r5)     // Catch:{ Exception -> 0x01a9 }
            r10.thread = r2     // Catch:{ Exception -> 0x01a9 }
        L_0x0061:
            r10.closeInternal(r3, r2)     // Catch:{ Exception -> 0x01a9 }
            return
        L_0x0065:
            com.unboundid.ldap.sdk.LDAPConnection r5 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.Debug.debugLDAPResult((com.unboundid.ldap.protocol.LDAPResponse) r4, (com.unboundid.ldap.sdk.LDAPConnection) r5)     // Catch:{ Exception -> 0x01a9 }
            boolean r5 = r4 instanceof com.unboundid.ldap.sdk.SearchResultEntry     // Catch:{ Exception -> 0x01a9 }
            if (r5 != 0) goto L_0x00d2
            boolean r5 = r4 instanceof com.unboundid.ldap.sdk.SearchResultReference     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x0073
            goto L_0x00d2
        L_0x0073:
            boolean r5 = r4 instanceof com.unboundid.ldap.sdk.IntermediateResponse     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x00c1
            r5 = r4
            com.unboundid.ldap.sdk.IntermediateResponse r5 = (com.unboundid.ldap.sdk.IntermediateResponse) r5     // Catch:{ Exception -> 0x01a9 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.unboundid.ldap.sdk.ResponseAcceptor> r6 = r10.acceptorMap     // Catch:{ Exception -> 0x01a9 }
            int r4 = r4.getMessageID()     // Catch:{ Exception -> 0x01a9 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.ResponseAcceptor r4 = (com.unboundid.ldap.sdk.ResponseAcceptor) r4     // Catch:{ Exception -> 0x01a9 }
            boolean r6 = r4 instanceof com.unboundid.ldap.sdk.LDAPRequest     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x0095
            com.unboundid.ldap.sdk.LDAPRequest r4 = (com.unboundid.ldap.sdk.LDAPRequest) r4     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.IntermediateResponseListener r4 = r4.getIntermediateResponseListener()     // Catch:{ Exception -> 0x01a9 }
            goto L_0x009d
        L_0x0095:
            boolean r6 = r4 instanceof com.unboundid.ldap.sdk.IntermediateResponseListener     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x009c
            com.unboundid.ldap.sdk.IntermediateResponseListener r4 = (com.unboundid.ldap.sdk.IntermediateResponseListener) r4     // Catch:{ Exception -> 0x01a9 }
            goto L_0x009d
        L_0x009c:
            r4 = r2
        L_0x009d:
            if (r4 != 0) goto L_0x00b6
            java.util.logging.Level r4 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.DebugType r6 = com.unboundid.util.DebugType.LDAP     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPMessages r7 = com.unboundid.ldap.sdk.LDAPMessages.WARN_INTERMEDIATE_RESPONSE_WITH_NO_LISTENER     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x01a9 }
            r8[r1] = r5     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r5 = r7.get(r8)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.Debug.debug(r4, r6, r5)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0006
        L_0x00b6:
            r4.intermediateResponseReturned(r5)     // Catch:{ Exception -> 0x00bb }
            goto L_0x0006
        L_0x00bb:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0006
        L_0x00c1:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.unboundid.ldap.sdk.ResponseAcceptor> r5 = r10.acceptorMap     // Catch:{ Exception -> 0x01a9 }
            int r6 = r4.getMessageID()     // Catch:{ Exception -> 0x01a9 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object r5 = r5.remove(r6)     // Catch:{ Exception -> 0x01a9 }
        L_0x00cf:
            com.unboundid.ldap.sdk.ResponseAcceptor r5 = (com.unboundid.ldap.sdk.ResponseAcceptor) r5     // Catch:{ Exception -> 0x01a9 }
            goto L_0x00e1
        L_0x00d2:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.unboundid.ldap.sdk.ResponseAcceptor> r5 = r10.acceptorMap     // Catch:{ Exception -> 0x01a9 }
            int r6 = r4.getMessageID()     // Catch:{ Exception -> 0x01a9 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x00cf
        L_0x00e1:
            if (r5 != 0) goto L_0x017a
            boolean r5 = r4 instanceof com.unboundid.ldap.sdk.ExtendedResult     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x0163
            int r5 = r4.getMessageID()     // Catch:{ Exception -> 0x01a9 }
            if (r5 != 0) goto L_0x0163
            r5 = r4
            com.unboundid.ldap.sdk.ExtendedResult r5 = (com.unboundid.ldap.sdk.ExtendedResult) r5     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r6 = r5.getOID()     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = "1.3.6.1.4.1.1466.20036"
            boolean r7 = r7.equals(r6)     // Catch:{ Exception -> 0x01a9 }
            if (r7 == 0) goto L_0x010d
            com.unboundid.ldap.sdk.extensions.NoticeOfDisconnectionExtendedResult r6 = new com.unboundid.ldap.sdk.extensions.NoticeOfDisconnectionExtendedResult     // Catch:{ Exception -> 0x01a9 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnection r5 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r7 = com.unboundid.ldap.sdk.DisconnectType.SERVER_CLOSED_WITH_NOTICE     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r8 = r6.getDiagnosticMessage()     // Catch:{ Exception -> 0x01a9 }
            r5.setDisconnectInfo(r7, r8, r2)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0135
        L_0x010d:
            java.lang.String r7 = "1.3.6.1.4.1.30221.2.6.5"
            boolean r6 = r7.equals(r6)     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x0134
            java.lang.String r6 = "com.unboundid.ldap.sdk.unboundidds.extensions.InteractiveTransactionAbortedExtendedResult"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0130 }
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0130 }
            java.lang.Class<com.unboundid.ldap.sdk.ExtendedResult> r8 = com.unboundid.ldap.sdk.ExtendedResult.class
            r7[r1] = r8     // Catch:{ Exception -> 0x0130 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ Exception -> 0x0130 }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0130 }
            r7[r1] = r5     // Catch:{ Exception -> 0x0130 }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ Exception -> 0x0130 }
            com.unboundid.ldap.sdk.ExtendedResult r6 = (com.unboundid.ldap.sdk.ExtendedResult) r6     // Catch:{ Exception -> 0x0130 }
            goto L_0x0135
        L_0x0130:
            r6 = move-exception
            com.unboundid.util.Debug.debugException(r6)     // Catch:{ Exception -> 0x01a9 }
        L_0x0134:
            r6 = r5
        L_0x0135:
            com.unboundid.ldap.sdk.LDAPConnection r5 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r5 = r5.getConnectionOptions()     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.UnsolicitedNotificationHandler r5 = r5.getUnsolicitedNotificationHandler()     // Catch:{ Exception -> 0x01a9 }
            if (r5 != 0) goto L_0x015c
            com.unboundid.util.DebugType r5 = com.unboundid.util.DebugType.LDAP     // Catch:{ Exception -> 0x01a9 }
            boolean r5 = com.unboundid.util.Debug.debugEnabled(r5)     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x0006
            java.util.logging.Level r5 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.DebugType r6 = com.unboundid.util.DebugType.LDAP     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPMessages r7 = com.unboundid.ldap.sdk.LDAPMessages.WARN_READER_UNHANDLED_UNSOLICITED_NOTIFICATION     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01a9 }
            r8[r1] = r4     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r7.get(r8)     // Catch:{ Exception -> 0x01a9 }
        L_0x0157:
            com.unboundid.util.Debug.debug(r5, r6, r4)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0006
        L_0x015c:
            com.unboundid.ldap.sdk.LDAPConnection r4 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            r5.handleUnsolicitedNotification(r4, r6)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0006
        L_0x0163:
            com.unboundid.util.DebugType r5 = com.unboundid.util.DebugType.LDAP     // Catch:{ Exception -> 0x01a9 }
            boolean r5 = com.unboundid.util.Debug.debugEnabled(r5)     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x0006
            java.util.logging.Level r5 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.DebugType r6 = com.unboundid.util.DebugType.LDAP     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPMessages r7 = com.unboundid.ldap.sdk.LDAPMessages.WARN_READER_NO_ACCEPTOR     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01a9 }
            r8[r1] = r4     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r7.get(r8)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0157
        L_0x017a:
            r5.responseReceived(r4)     // Catch:{ LDAPException -> 0x017f }
            goto L_0x0006
        L_0x017f:
            r5 = move-exception
            com.unboundid.util.Debug.debugException(r5)     // Catch:{ Exception -> 0x01a9 }
            java.util.logging.Level r6 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.DebugType r7 = com.unboundid.util.DebugType.LDAP     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPMessages r8 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_ACCEPTOR_ERROR     // Catch:{ Exception -> 0x01a9 }
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x01a9 }
            r9[r1] = r4     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnection r4 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r4.getHostPort()     // Catch:{ Exception -> 0x01a9 }
            r9[r3] = r4     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)     // Catch:{ Exception -> 0x01a9 }
            r9[r0] = r4     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r8.get(r9)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.Debug.debug(r6, r7, r4, r5)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0006
        L_0x01a9:
            r4 = move-exception
            goto L_0x0389
        L_0x01ac:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x02aa
            boolean r6 = r5 instanceof java.net.SocketTimeoutException     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x02aa
            java.net.SocketTimeoutException r5 = (java.net.SocketTimeoutException) r5     // Catch:{ Exception -> 0x01a9 }
            java.util.logging.Level r4 = java.util.logging.Level.FINEST     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.Debug.debugException(r4, r5)     // Catch:{ Exception -> 0x01a9 }
            javax.net.ssl.SSLContext r4 = r10.sslContext     // Catch:{ Exception -> 0x01a9 }
            if (r4 == 0) goto L_0x0006
            com.unboundid.ldap.sdk.LDAPConnection r4 = r10.connection     // Catch:{ Exception -> 0x0268 }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r4 = r4.getConnectionOptions()     // Catch:{ Exception -> 0x0268 }
            int r4 = r4.getConnectTimeoutMillis()     // Catch:{ Exception -> 0x0268 }
            if (r4 <= 0) goto L_0x0201
            boolean r5 = com.unboundid.util.Debug.debugEnabled()     // Catch:{ Exception -> 0x0268 }
            if (r5 == 0) goto L_0x01fb
            java.util.logging.Level r5 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x0268 }
            com.unboundid.util.DebugType r6 = com.unboundid.util.DebugType.CONNECT     // Catch:{ Exception -> 0x0268 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0268 }
            r7.<init>()     // Catch:{ Exception -> 0x0268 }
            java.lang.String r8 = "Setting SO_TIMEOUT to connect timeout of "
            r7.append(r8)     // Catch:{ Exception -> 0x0268 }
            r7.append(r4)     // Catch:{ Exception -> 0x0268 }
            java.lang.String r8 = "ms in "
            r7.append(r8)     // Catch:{ Exception -> 0x0268 }
            java.lang.String r8 = "LDAPConnectionReader.run while performing "
            r7.append(r8)     // Catch:{ Exception -> 0x0268 }
            java.lang.String r8 = "StartTLS processing."
            r7.append(r8)     // Catch:{ Exception -> 0x0268 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0268 }
            com.unboundid.util.Debug.debug(r5, r6, r7)     // Catch:{ Exception -> 0x0268 }
        L_0x01fb:
            java.net.Socket r5 = r10.socket     // Catch:{ Exception -> 0x0268 }
            r5.setSoTimeout(r4)     // Catch:{ Exception -> 0x0268 }
            goto L_0x0215
        L_0x0201:
            boolean r4 = com.unboundid.util.Debug.debugEnabled()     // Catch:{ Exception -> 0x0268 }
            if (r4 == 0) goto L_0x0210
            java.util.logging.Level r4 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x0268 }
            com.unboundid.util.DebugType r5 = com.unboundid.util.DebugType.CONNECT     // Catch:{ Exception -> 0x0268 }
            java.lang.String r6 = "Setting SO_TIMEOUT to 0ms in LDAPConnectionReader.run while performing StartTLS processing."
            com.unboundid.util.Debug.debug(r4, r5, r6)     // Catch:{ Exception -> 0x0268 }
        L_0x0210:
            java.net.Socket r4 = r10.socket     // Catch:{ Exception -> 0x0268 }
            r4.setSoTimeout(r1)     // Catch:{ Exception -> 0x0268 }
        L_0x0215:
            javax.net.ssl.SSLContext r4 = r10.sslContext     // Catch:{ Exception -> 0x0268 }
            javax.net.ssl.SSLSocketFactory r4 = r4.getSocketFactory()     // Catch:{ Exception -> 0x0268 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x0268 }
            java.net.Socket r5 = r10.socket     // Catch:{ all -> 0x0265 }
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection     // Catch:{ all -> 0x0265 }
            java.lang.String r6 = r6.getConnectedAddress()     // Catch:{ all -> 0x0265 }
            java.net.Socket r7 = r10.socket     // Catch:{ all -> 0x0265 }
            int r7 = r7.getPort()     // Catch:{ all -> 0x0265 }
            java.net.Socket r5 = r4.createSocket(r5, r6, r7, r3)     // Catch:{ all -> 0x0265 }
            javax.net.ssl.SSLSocket r5 = (javax.net.ssl.SSLSocket) r5     // Catch:{ all -> 0x0265 }
            r5.startHandshake()     // Catch:{ all -> 0x0265 }
            monitor-exit(r4)     // Catch:{ all -> 0x0265 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0268 }
            java.io.InputStream r6 = r5.getInputStream()     // Catch:{ Exception -> 0x0268 }
            r7 = 4096(0x1000, float:5.74E-42)
            r4.<init>(r6, r7)     // Catch:{ Exception -> 0x0268 }
            r10.inputStream = r4     // Catch:{ Exception -> 0x0268 }
            com.unboundid.asn1.ASN1StreamReader r4 = new com.unboundid.asn1.ASN1StreamReader     // Catch:{ Exception -> 0x0268 }
            java.io.InputStream r6 = r10.inputStream     // Catch:{ Exception -> 0x0268 }
            com.unboundid.ldap.sdk.LDAPConnection r7 = r10.connection     // Catch:{ Exception -> 0x0268 }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r7 = r7.getConnectionOptions()     // Catch:{ Exception -> 0x0268 }
            int r7 = r7.getMaxMessageSize()     // Catch:{ Exception -> 0x0268 }
            r4.<init>(r6, r7)     // Catch:{ Exception -> 0x0268 }
            r10.asn1StreamReader = r4     // Catch:{ Exception -> 0x0268 }
            java.io.OutputStream r4 = r5.getOutputStream()     // Catch:{ Exception -> 0x0268 }
            r10.startTLSOutputStream = r4     // Catch:{ Exception -> 0x0268 }
            r10.socket = r5     // Catch:{ Exception -> 0x0268 }
            com.unboundid.util.WakeableSleeper r4 = r10.startTLSSleeper     // Catch:{ Exception -> 0x0268 }
            r4.wakeup()     // Catch:{ Exception -> 0x0268 }
            r10.sslContext = r2     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0006
        L_0x0265:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0265 }
            throw r5     // Catch:{ Exception -> 0x0268 }
        L_0x0268:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnection r5 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.SECURITY_PROBLEM     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = com.unboundid.util.StaticUtils.getExceptionMessage(r4)     // Catch:{ Exception -> 0x01a9 }
            r5.setDisconnectInfo(r6, r7, r4)     // Catch:{ Exception -> 0x01a9 }
            r10.startTLSException = r4     // Catch:{ Exception -> 0x01a9 }
            r10.closeRequested = r3     // Catch:{ Exception -> 0x01a9 }
            java.lang.Thread r5 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x029d
            java.lang.Thread r5 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a9 }
            r6.<init>()     // Catch:{ Exception -> 0x01a9 }
            java.lang.Thread r7 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = r7.getName()     // Catch:{ Exception -> 0x01a9 }
            r6.append(r7)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = " (closed)"
            r6.append(r7)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a9 }
            r5.setName(r6)     // Catch:{ Exception -> 0x01a9 }
            r10.thread = r2     // Catch:{ Exception -> 0x01a9 }
        L_0x029d:
            java.lang.String r4 = com.unboundid.util.StaticUtils.getExceptionMessage(r4)     // Catch:{ Exception -> 0x01a9 }
            r10.closeInternal(r3, r4)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.WakeableSleeper r4 = r10.startTLSSleeper     // Catch:{ Exception -> 0x01a9 }
            r4.wakeup()     // Catch:{ Exception -> 0x01a9 }
            return
        L_0x02aa:
            boolean r6 = r10.closeRequested     // Catch:{ Exception -> 0x01a9 }
            if (r6 != 0) goto L_0x02c3
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            boolean r6 = r6.closeRequested()     // Catch:{ Exception -> 0x01a9 }
            if (r6 != 0) goto L_0x02c3
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r6 = r6.getDisconnectType()     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x02bf
            goto L_0x02c3
        L_0x02bf:
            com.unboundid.util.Debug.debugException(r4)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x02ca
        L_0x02c3:
            r10.closeRequested = r3     // Catch:{ Exception -> 0x01a9 }
            java.util.logging.Level r6 = java.util.logging.Level.FINEST     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.Debug.debugException(r6, r4)     // Catch:{ Exception -> 0x01a9 }
        L_0x02ca:
            java.util.logging.Level r6 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x01a9 }
            if (r5 != 0) goto L_0x02e0
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r7 = com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r8 = r4.getMessage()     // Catch:{ Exception -> 0x01a9 }
            r6.setDisconnectInfo(r7, r8, r5)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ Exception -> 0x01a9 }
        L_0x02dd:
            java.util.logging.Level r6 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x01a9 }
            goto L_0x034a
        L_0x02e0:
            boolean r7 = r5 instanceof java.io.IOException     // Catch:{ Exception -> 0x01a9 }
            if (r7 == 0) goto L_0x0306
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r7 = com.unboundid.ldap.sdk.DisconnectType.IO_ERROR     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ Exception -> 0x01a9 }
            r6.setDisconnectInfo(r7, r4, r5)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_IO_EXCEPTION     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnection r7 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = r7.getHostPort()     // Catch:{ Exception -> 0x01a9 }
            r6[r1] = r7     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)     // Catch:{ Exception -> 0x01a9 }
            r6[r3] = r7     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r4.get(r6)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x02dd
        L_0x0306:
            boolean r7 = r5 instanceof com.unboundid.asn1.ASN1Exception     // Catch:{ Exception -> 0x01a9 }
            if (r7 == 0) goto L_0x032c
            com.unboundid.ldap.sdk.LDAPConnection r7 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r8 = com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ Exception -> 0x01a9 }
            r7.setDisconnectInfo(r8, r4, r5)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_ASN1_EXCEPTION     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnection r8 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r8 = r8.getHostPort()     // Catch:{ Exception -> 0x01a9 }
            r7[r1] = r8     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r8 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)     // Catch:{ Exception -> 0x01a9 }
            r7[r3] = r8     // Catch:{ Exception -> 0x01a9 }
        L_0x0327:
            java.lang.String r4 = r4.get(r7)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x034a
        L_0x032c:
            com.unboundid.ldap.sdk.LDAPConnection r7 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.DisconnectType r8 = com.unboundid.ldap.sdk.DisconnectType.LOCAL_ERROR     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ Exception -> 0x01a9 }
            r7.setDisconnectInfo(r8, r4, r5)     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_EXCEPTION     // Catch:{ Exception -> 0x01a9 }
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnection r8 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r8 = r8.getHostPort()     // Catch:{ Exception -> 0x01a9 }
            r7[r1] = r8     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r8 = com.unboundid.util.StaticUtils.getExceptionMessage(r5)     // Catch:{ Exception -> 0x01a9 }
            r7[r3] = r8     // Catch:{ Exception -> 0x01a9 }
            goto L_0x0327
        L_0x034a:
            com.unboundid.util.DebugType r7 = com.unboundid.util.DebugType.LDAP     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.util.Debug.debug(r6, r7, r4, r5)     // Catch:{ Exception -> 0x01a9 }
            boolean r5 = r10.closeRequested     // Catch:{ Exception -> 0x01a9 }
            if (r5 != 0) goto L_0x0361
            com.unboundid.ldap.sdk.LDAPConnection r5 = r10.connection     // Catch:{ Exception -> 0x01a9 }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r5 = r5.getConnectionOptions()     // Catch:{ Exception -> 0x01a9 }
            boolean r5 = r5.autoReconnect()     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x0361
            goto L_0x03fe
        L_0x0361:
            r10.closeRequested = r3     // Catch:{ Exception -> 0x01a9 }
            java.lang.Thread r5 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            if (r5 == 0) goto L_0x0385
            java.lang.Thread r5 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a9 }
            r6.<init>()     // Catch:{ Exception -> 0x01a9 }
            java.lang.Thread r7 = r10.thread     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = r7.getName()     // Catch:{ Exception -> 0x01a9 }
            r6.append(r7)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r7 = " (closed)"
            r6.append(r7)     // Catch:{ Exception -> 0x01a9 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x01a9 }
            r5.setName(r6)     // Catch:{ Exception -> 0x01a9 }
            r10.thread = r2     // Catch:{ Exception -> 0x01a9 }
        L_0x0385:
            r10.closeInternal(r3, r4)     // Catch:{ Exception -> 0x01a9 }
            return
        L_0x0389:
            com.unboundid.util.Debug.debugException(r4)
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE
            boolean r6 = r4 instanceof java.io.IOException
            if (r6 == 0) goto L_0x03b2
            com.unboundid.ldap.sdk.LDAPConnection r5 = r10.connection
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.IO_ERROR
            r5.setDisconnectInfo(r6, r2, r4)
            com.unboundid.ldap.sdk.LDAPMessages r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_IO_EXCEPTION
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection
            java.lang.String r6 = r6.getHostPort()
            r0[r1] = r6
            java.lang.String r1 = com.unboundid.util.StaticUtils.getExceptionMessage(r4)
            r0[r3] = r1
            java.lang.String r0 = r5.get(r0)
            java.util.logging.Level r5 = java.util.logging.Level.WARNING
            goto L_0x03ed
        L_0x03b2:
            boolean r6 = r4 instanceof com.unboundid.asn1.ASN1Exception
            if (r6 == 0) goto L_0x03d0
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection
            com.unboundid.ldap.sdk.DisconnectType r7 = com.unboundid.ldap.sdk.DisconnectType.DECODE_ERROR
            r6.setDisconnectInfo(r7, r2, r4)
            com.unboundid.ldap.sdk.LDAPMessages r6 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_ASN1_EXCEPTION
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.unboundid.ldap.sdk.LDAPConnection r7 = r10.connection
            java.lang.String r7 = r7.getHostPort()
            r0[r1] = r7
            java.lang.String r1 = com.unboundid.util.StaticUtils.getExceptionMessage(r4)
            r0[r3] = r1
            goto L_0x03e9
        L_0x03d0:
            com.unboundid.ldap.sdk.LDAPConnection r6 = r10.connection
            com.unboundid.ldap.sdk.DisconnectType r7 = com.unboundid.ldap.sdk.DisconnectType.LOCAL_ERROR
            r6.setDisconnectInfo(r7, r2, r4)
            com.unboundid.ldap.sdk.LDAPMessages r6 = com.unboundid.ldap.sdk.LDAPMessages.ERR_READER_CLOSING_DUE_TO_EXCEPTION
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.unboundid.ldap.sdk.LDAPConnection r7 = r10.connection
            java.lang.String r7 = r7.getHostPort()
            r0[r1] = r7
            java.lang.String r1 = com.unboundid.util.StaticUtils.getExceptionMessage(r4)
            r0[r3] = r1
        L_0x03e9:
            java.lang.String r0 = r6.get(r0)
        L_0x03ed:
            com.unboundid.util.DebugType r1 = com.unboundid.util.DebugType.LDAP
            com.unboundid.util.Debug.debug(r5, r1, r0, r4)
            com.unboundid.ldap.sdk.LDAPConnection r1 = r10.connection
            com.unboundid.ldap.sdk.LDAPConnectionOptions r1 = r1.getConnectionOptions()
            boolean r1 = r1.autoReconnect()
            if (r1 == 0) goto L_0x0400
        L_0x03fe:
            r1 = 1
            goto L_0x0428
        L_0x0400:
            r10.closeRequested = r3
            java.lang.Thread r1 = r10.thread
            if (r1 == 0) goto L_0x0424
            java.lang.Thread r1 = r10.thread
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Thread r5 = r10.thread
            java.lang.String r5 = r5.getName()
            r4.append(r5)
            java.lang.String r5 = " (closed)"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.setName(r4)
            r10.thread = r2
        L_0x0424:
            r10.closeInternal(r3, r0)
            return
        L_0x0428:
            java.lang.Thread r0 = r10.thread
            if (r0 == 0) goto L_0x0437
            java.lang.Thread r0 = r10.thread
            java.lang.String r4 = r10.constructThreadName(r2)
            r0.setName(r4)
            r10.thread = r2
        L_0x0437:
            if (r1 == 0) goto L_0x044c
            com.unboundid.ldap.sdk.LDAPConnection r0 = r10.connection
            boolean r0 = r0.closeRequested()
            if (r0 != 0) goto L_0x044c
            com.unboundid.ldap.sdk.LDAPConnection r0 = r10.connection     // Catch:{ Exception -> 0x0447 }
            r0.reconnect()     // Catch:{ Exception -> 0x0447 }
            goto L_0x044f
        L_0x0447:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
            goto L_0x044f
        L_0x044c:
            r10.closeInternal(r3, r2)
        L_0x044f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.LDAPConnectionReader.run():void");
    }

    /* access modifiers changed from: package-private */
    public void setSoTimeout(int i) {
        try {
            this.socket.setSoTimeout(i);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_READER_CANNOT_SET_SO_TIMEOUT.get(Integer.valueOf(i), this.connection.toString(), StaticUtils.getExceptionMessage(e)), e);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateThreadName() {
        Thread thread2 = this.thread;
        if (thread2 != null) {
            thread2.setName(constructThreadName(this.connection.getConnectionInternals()));
        }
    }
}

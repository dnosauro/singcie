package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;

@InternalUseOnly
final class LDAPConnectionInternals {
    private static final ThreadLocal<ASN1Buffer> asn1Buffers = new ThreadLocal<>();
    private final long connectTime;
    private final LDAPConnection connection;
    private final LDAPConnectionReader connectionReader;
    private volatile boolean disconnectHandlerNotified;
    private final String host;
    private final AtomicInteger nextMessageID;
    private volatile OutputStream outputStream;
    private final int port;
    private final Socket socket;
    private final boolean synchronousMode;

    LDAPConnectionInternals(LDAPConnection lDAPConnection, LDAPConnectionOptions lDAPConnectionOptions, SocketFactory socketFactory, String str, int i, int i2) {
        this.connection = lDAPConnection;
        this.host = str;
        this.port = i;
        if (lDAPConnectionOptions.captureConnectStackTrace()) {
            lDAPConnection.setConnectStackTrace(Thread.currentThread().getStackTrace());
        }
        this.connectTime = System.currentTimeMillis();
        this.nextMessageID = new AtomicInteger(0);
        this.disconnectHandlerNotified = false;
        this.synchronousMode = lDAPConnectionOptions.useSynchronousMode();
        try {
            ConnectThread connectThread = new ConnectThread(socketFactory, str, i);
            connectThread.start();
            this.socket = connectThread.getConnectedSocket((long) i2);
            if (lDAPConnectionOptions.getReceiveBufferSize() > 0) {
                this.socket.setReceiveBufferSize(lDAPConnectionOptions.getReceiveBufferSize());
            }
            if (lDAPConnectionOptions.getSendBufferSize() > 0) {
                this.socket.setSendBufferSize(lDAPConnectionOptions.getSendBufferSize());
            }
            try {
                Debug.debugConnect(str, i, lDAPConnection);
                this.socket.setKeepAlive(lDAPConnectionOptions.useKeepAlive());
                this.socket.setReuseAddress(lDAPConnectionOptions.useReuseAddress());
                this.socket.setSoLinger(lDAPConnectionOptions.useLinger(), lDAPConnectionOptions.getLingerTimeoutSeconds());
                this.socket.setTcpNoDelay(lDAPConnectionOptions.useTCPNoDelay());
                this.outputStream = this.socket.getOutputStream();
                this.connectionReader = new LDAPConnectionReader(lDAPConnection, this);
            } catch (IOException e) {
                Debug.debugException(e);
                try {
                    this.socket.close();
                } catch (Exception e2) {
                    Debug.debugException(e2);
                }
                throw e;
            }
        } catch (LDAPException e3) {
            Debug.debugException(e3);
            throw new IOException(e3.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ca, code lost:
        if (r10.getDisconnectHandler() == null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r10.getDisconnectHandler() != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        r10.setDisconnectHandler(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dc, code lost:
        r12.connection.setDisconnectInfo(r0, r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r12 = this;
            com.unboundid.ldap.sdk.LDAPConnection r0 = r12.connection
            com.unboundid.ldap.sdk.DisconnectType r0 = r0.getDisconnectType()
            com.unboundid.ldap.sdk.LDAPConnection r1 = r12.connection
            java.lang.String r1 = r1.getDisconnectMessage()
            com.unboundid.ldap.sdk.LDAPConnection r2 = r12.connection
            java.lang.Throwable r9 = r2.getDisconnectCause()
            com.unboundid.ldap.sdk.DisconnectType r2 = com.unboundid.ldap.sdk.DisconnectType.CLOSED_BY_FINALIZER
            r8 = 1
            r3 = 0
            if (r0 != r2) goto L_0x0022
            java.net.Socket r2 = r12.socket
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x0022
            r10 = 1
            goto L_0x0023
        L_0x0022:
            r10 = 0
        L_0x0023:
            com.unboundid.ldap.sdk.LDAPConnectionReader r2 = r12.connectionReader     // Catch:{ Exception -> 0x0029 }
            r2.close(r3)     // Catch:{ Exception -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r2 = move-exception
            com.unboundid.util.Debug.debugException(r2)
        L_0x002d:
            java.io.OutputStream r2 = r12.outputStream     // Catch:{ Exception -> 0x0033 }
            r2.close()     // Catch:{ Exception -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r2 = move-exception
            com.unboundid.util.Debug.debugException(r2)
        L_0x0037:
            java.net.Socket r2 = r12.socket     // Catch:{ Exception -> 0x003d }
            r2.close()     // Catch:{ Exception -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r2 = move-exception
            com.unboundid.util.Debug.debugException(r2)
        L_0x0041:
            if (r0 != 0) goto L_0x0071
            com.unboundid.util.DebugType r0 = com.unboundid.util.DebugType.LDAP
            boolean r0 = com.unboundid.util.Debug.debugEnabled(r0)
            if (r0 == 0) goto L_0x006f
            java.util.logging.Level r0 = java.util.logging.Level.WARNING
            com.unboundid.util.DebugType r2 = com.unboundid.util.DebugType.LDAP
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "No disconnect type set for connection closed with stack trace "
            r3.append(r4)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()
            java.lang.String r4 = com.unboundid.util.StaticUtils.getStackTrace((java.lang.StackTraceElement[]) r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.unboundid.util.Debug.debug(r0, r2, r3)
        L_0x006f:
            com.unboundid.ldap.sdk.DisconnectType r0 = com.unboundid.ldap.sdk.DisconnectType.UNKNOWN
        L_0x0071:
            java.lang.String r2 = r12.host
            int r3 = r12.port
            com.unboundid.ldap.sdk.LDAPConnection r4 = r12.connection
            r5 = r0
            r6 = r1
            r7 = r9
            com.unboundid.util.Debug.debugDisconnect((java.lang.String) r2, (int) r3, (com.unboundid.ldap.sdk.LDAPConnection) r4, (com.unboundid.ldap.sdk.DisconnectType) r5, (java.lang.String) r6, (java.lang.Throwable) r7)
            if (r10 == 0) goto L_0x00a3
            com.unboundid.util.DebugType r2 = com.unboundid.util.DebugType.LDAP
            boolean r2 = com.unboundid.util.Debug.debugEnabled(r2)
            if (r2 == 0) goto L_0x00a3
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            com.unboundid.util.DebugType r3 = com.unboundid.util.DebugType.LDAP
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Connection closed by LDAP SDK finalizer:  "
            r4.append(r5)
            java.lang.String r5 = r12.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.unboundid.util.Debug.debug(r2, r3, r4)
        L_0x00a3:
            com.unboundid.ldap.sdk.LDAPConnection r2 = r12.connection
            com.unboundid.ldap.sdk.LDAPConnectionOptions r10 = r2.getConnectionOptions()
            com.unboundid.ldap.sdk.DisconnectHandler r11 = r10.getDisconnectHandler()
            if (r11 == 0) goto L_0x00ec
            boolean r2 = r12.disconnectHandlerNotified
            if (r2 != 0) goto L_0x00ec
            r2 = 0
            r10.setDisconnectHandler(r2)
            r12.disconnectHandlerNotified = r8     // Catch:{ Exception -> 0x00cf }
            com.unboundid.ldap.sdk.LDAPConnection r3 = r12.connection     // Catch:{ Exception -> 0x00cf }
            java.lang.String r4 = r12.host     // Catch:{ Exception -> 0x00cf }
            int r5 = r12.port     // Catch:{ Exception -> 0x00cf }
            r2 = r11
            r6 = r0
            r7 = r1
            r8 = r9
            r2.handleDisconnect(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00cf }
            com.unboundid.ldap.sdk.DisconnectHandler r2 = r10.getDisconnectHandler()
            if (r2 != 0) goto L_0x00dc
            goto L_0x00d9
        L_0x00cd:
            r0 = move-exception
            goto L_0x00e2
        L_0x00cf:
            r2 = move-exception
            com.unboundid.util.Debug.debugException(r2)     // Catch:{ all -> 0x00cd }
            com.unboundid.ldap.sdk.DisconnectHandler r2 = r10.getDisconnectHandler()
            if (r2 != 0) goto L_0x00dc
        L_0x00d9:
            r10.setDisconnectHandler(r11)
        L_0x00dc:
            com.unboundid.ldap.sdk.LDAPConnection r2 = r12.connection
            r2.setDisconnectInfo(r0, r1, r9)
            goto L_0x00ec
        L_0x00e2:
            com.unboundid.ldap.sdk.DisconnectHandler r1 = r10.getDisconnectHandler()
            if (r1 != 0) goto L_0x00eb
            r10.setDisconnectHandler(r11)
        L_0x00eb:
            throw r0
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.LDAPConnectionInternals.close():void");
    }

    /* access modifiers changed from: package-private */
    public void convertToTLS(SSLContext sSLContext) {
        this.outputStream = this.connectionReader.doStartTLS(sSLContext);
    }

    /* access modifiers changed from: package-private */
    public void deregisterResponseAcceptor(int i) {
        this.connectionReader.deregisterResponseAcceptor(i);
    }

    public long getConnectTime() {
        if (isConnected()) {
            return this.connectTime;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public LDAPConnection getConnection() {
        return this.connection;
    }

    /* access modifiers changed from: package-private */
    public LDAPConnectionReader getConnectionReader() {
        return this.connectionReader;
    }

    /* access modifiers changed from: package-private */
    public String getHost() {
        return this.host;
    }

    /* access modifiers changed from: package-private */
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    /* access modifiers changed from: package-private */
    public int getPort() {
        return this.port;
    }

    /* access modifiers changed from: package-private */
    public Socket getSocket() {
        return this.socket;
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.socket.isConnected();
    }

    /* access modifiers changed from: package-private */
    public int nextMessageID() {
        int incrementAndGet = this.nextMessageID.incrementAndGet();
        if (incrementAndGet > 0) {
            return incrementAndGet;
        }
        while (!this.nextMessageID.compareAndSet(incrementAndGet, 1)) {
            incrementAndGet = this.nextMessageID.incrementAndGet();
            if (incrementAndGet > 0) {
                return incrementAndGet;
            }
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void registerResponseAcceptor(int i, ResponseAcceptor responseAcceptor) {
        if (!isConnected()) {
            LDAPConnectionOptions connectionOptions = this.connection.getConnectionOptions();
            boolean closeRequested = this.connection.closeRequested();
            if (!connectionOptions.autoReconnect() || closeRequested) {
                throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONN_NOT_ESTABLISHED.get());
            }
            this.connection.reconnect();
            this.connection.registerResponseAcceptor(i, responseAcceptor);
        }
        this.connectionReader.registerResponseAcceptor(i, responseAcceptor);
    }

    /* access modifiers changed from: package-private */
    public void sendMessage(LDAPMessage lDAPMessage) {
        if (isConnected()) {
            ASN1Buffer aSN1Buffer = asn1Buffers.get();
            if (aSN1Buffer == null) {
                aSN1Buffer = new ASN1Buffer();
                asn1Buffers.set(aSN1Buffer);
            }
            aSN1Buffer.clear();
            try {
                lDAPMessage.writeTo(aSN1Buffer);
            } catch (LDAPRuntimeException e) {
                Debug.debugException(e);
                e.throwLDAPException();
            }
            try {
                OutputStream outputStream2 = this.outputStream;
                aSN1Buffer.writeTo(outputStream2);
                outputStream2.flush();
                if (aSN1Buffer.zeroBufferOnClear()) {
                    aSN1Buffer.clear();
                }
            } catch (IOException e2) {
                Debug.debugException(e2);
                if (lDAPMessage.getProtocolOpType() != 66) {
                    LDAPConnectionOptions connectionOptions = this.connection.getConnectionOptions();
                    boolean closeRequested = this.connection.closeRequested();
                    if (connectionOptions.autoReconnect() && !closeRequested) {
                        this.connection.reconnect();
                    }
                    ResultCode resultCode = ResultCode.SERVER_DOWN;
                    LDAPMessages lDAPMessages = LDAPMessages.ERR_CONN_SEND_ERROR;
                    throw new LDAPException(resultCode, lDAPMessages.get(this.host + ':' + this.port, StaticUtils.getExceptionMessage(e2)), e2);
                } else if (aSN1Buffer.zeroBufferOnClear()) {
                    aSN1Buffer.clear();
                }
            } catch (Exception e3) {
                Debug.debugException(e3);
                ResultCode resultCode2 = ResultCode.LOCAL_ERROR;
                LDAPMessages lDAPMessages2 = LDAPMessages.ERR_CONN_ENCODE_ERROR;
                throw new LDAPException(resultCode2, lDAPMessages2.get(this.host + ':' + this.port, StaticUtils.getExceptionMessage(e3)), e3);
            } catch (Throwable th) {
                if (aSN1Buffer.zeroBufferOnClear()) {
                    aSN1Buffer.clear();
                }
                throw th;
            }
        } else {
            throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONN_NOT_ESTABLISHED.get());
        }
    }

    /* access modifiers changed from: package-private */
    public void startConnectionReader() {
        if (!this.synchronousMode) {
            this.connectionReader.start();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean synchronousMode() {
        return this.synchronousMode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPConnectionInternals(host='");
        sb.append(this.host);
        sb.append("', port=");
        sb.append(this.port);
        sb.append(", connected=");
        sb.append(this.socket.isConnected());
        sb.append(", nextMessageID=");
        sb.append(this.nextMessageID.get());
        sb.append(')');
    }
}

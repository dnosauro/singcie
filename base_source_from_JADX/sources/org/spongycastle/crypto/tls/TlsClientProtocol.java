package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.util.Arrays;

public class TlsClientProtocol extends TlsProtocol {
    protected TlsAuthentication authentication = null;
    protected CertificateRequest certificateRequest = null;
    protected CertificateStatus certificateStatus = null;
    protected TlsKeyExchange keyExchange = null;
    protected byte[] selectedSessionID = null;
    protected TlsClient tlsClient = null;
    TlsClientContextImpl tlsClientContext = null;

    public TlsClientProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
    }

    public TlsClientProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }

    /* access modifiers changed from: protected */
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.selectedSessionID = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateStatus = null;
        this.certificateRequest = null;
    }

    public void connect(TlsClient tlsClient2) {
        SessionParameters exportSessionParameters;
        if (tlsClient2 == null) {
            throw new IllegalArgumentException("'tlsClient' cannot be null");
        } else if (this.tlsClient == null) {
            this.tlsClient = tlsClient2;
            this.securityParameters = new SecurityParameters();
            this.securityParameters.entity = 1;
            this.tlsClientContext = new TlsClientContextImpl(this.secureRandom, this.securityParameters);
            this.securityParameters.clientRandom = createRandomBlock(tlsClient2.shouldUseGMTUnixTime(), this.tlsClientContext.getNonceRandomGenerator());
            this.tlsClient.init(this.tlsClientContext);
            this.recordStream.init(this.tlsClientContext);
            TlsSession sessionToResume = tlsClient2.getSessionToResume();
            if (!(sessionToResume == null || !sessionToResume.isResumable() || (exportSessionParameters = sessionToResume.exportSessionParameters()) == null)) {
                this.tlsSession = sessionToResume;
                this.sessionParameters = exportSessionParameters;
            }
            sendClientHelloMessage();
            this.connection_state = 1;
            blockForHandshake();
        } else {
            throw new IllegalStateException("'connect' can only be called once");
        }
    }

    /* access modifiers changed from: protected */
    public TlsContext getContext() {
        return this.tlsClientContext;
    }

    /* access modifiers changed from: package-private */
    public AbstractTlsContext getContextAdmin() {
        return this.tlsClientContext;
    }

    /* access modifiers changed from: protected */
    public TlsPeer getPeer() {
        return this.tlsClient;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        r7.keyExchange.skipServerCredentials();
        r7.authentication = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0085, code lost:
        r7.keyExchange.skipServerKeyExchange();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008a, code lost:
        assertEmpty(r9);
        r7.connection_state = 8;
        r7.recordStream.getHandshakeHash().sealHashAlgorithms();
        r8 = r7.tlsClient.getClientSupplementalData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        if (r8 == null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a2, code lost:
        sendSupplementalDataMessage(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a5, code lost:
        r7.connection_state = 9;
        r8 = r7.certificateRequest;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        if (r8 != null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r7.keyExchange.skipClientCredentials();
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b4, code lost:
        r8 = r7.authentication.getClientCredentials(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ba, code lost:
        if (r8 != null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bc, code lost:
        r7.keyExchange.skipClientCredentials();
        r9 = org.spongycastle.crypto.tls.Certificate.EMPTY_CHAIN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        r7.keyExchange.processClientCredentials(r8);
        r9 = r8.getCertificate();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cd, code lost:
        sendCertificateMessage(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d0, code lost:
        r7.connection_state = 10;
        sendClientKeyExchangeMessage();
        r7.connection_state = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e1, code lost:
        if (org.spongycastle.crypto.tls.TlsUtils.isSSL(getContext()) == false) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e3, code lost:
        establishMasterSecret(getContext(), r7.keyExchange);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ec, code lost:
        r9 = r7.recordStream.prepareToFinish();
        r7.securityParameters.sessionHash = getCurrentPRFHash(getContext(), r9, (byte[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0106, code lost:
        if (org.spongycastle.crypto.tls.TlsUtils.isSSL(getContext()) != false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0108, code lost:
        establishMasterSecret(getContext(), r7.keyExchange);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0111, code lost:
        r7.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0126, code lost:
        if (r8 == null) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012a, code lost:
        if ((r8 instanceof org.spongycastle.crypto.tls.TlsSignerCredentials) == false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012c, code lost:
        r8 = (org.spongycastle.crypto.tls.TlsSignerCredentials) r8;
        r0 = org.spongycastle.crypto.tls.TlsUtils.getSignatureAndHashAlgorithm(getContext(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0136, code lost:
        if (r0 != null) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0138, code lost:
        r9 = r7.securityParameters.getSessionHash();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013f, code lost:
        r9 = r9.getFinalHash(r0.getHash());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0147, code lost:
        sendCertificateVerifyMessage(new org.spongycastle.crypto.tls.DigitallySigned(r0, r8.generateCertificateSignature(r9)));
        r7.connection_state = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0157, code lost:
        sendChangeCipherSpecMessage();
        sendFinishedMessage();
        r7.connection_state = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b0, code lost:
        r7.keyExchange.skipServerCredentials();
        r7.authentication = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b7, code lost:
        r7.keyExchange.processServerKeyExchange(r9);
        assertEmpty(r9);
        r8 = 6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleHandshakeMessage(short r8, java.io.ByteArrayInputStream r9) {
        /*
            r7 = this;
            boolean r0 = r7.resumedSession
            r1 = 15
            r2 = 20
            r3 = 13
            r4 = 2
            r5 = 10
            if (r0 == 0) goto L_0x0027
            if (r8 != r2) goto L_0x0021
            short r8 = r7.connection_state
            if (r8 != r4) goto L_0x0021
            r7.processFinishedMessage(r9)
            r7.connection_state = r1
            r7.sendFinishedMessage()
            r7.connection_state = r3
            r7.completeHandshake()
            return
        L_0x0021:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x0027:
            if (r8 == 0) goto L_0x0293
            r0 = 0
            if (r8 == r4) goto L_0x0240
            r6 = 4
            if (r8 == r6) goto L_0x0223
            if (r8 == r2) goto L_0x0204
            switch(r8) {
                case 11: goto L_0x01c4;
                case 12: goto L_0x01a2;
                case 13: goto L_0x0161;
                case 14: goto L_0x0070;
                default: goto L_0x0034;
            }
        L_0x0034:
            switch(r8) {
                case 22: goto L_0x0050;
                case 23: goto L_0x003d;
                default: goto L_0x0037;
            }
        L_0x0037:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x003d:
            short r8 = r7.connection_state
            if (r8 != r4) goto L_0x004a
            java.util.Vector r8 = readSupplementalDataMessage(r9)
            r7.handleSupplementalData(r8)
            goto L_0x029f
        L_0x004a:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x0050:
            short r8 = r7.connection_state
            if (r8 != r6) goto L_0x006a
            boolean r8 = r7.allowCertificateStatus
            if (r8 == 0) goto L_0x0064
            org.spongycastle.crypto.tls.CertificateStatus r8 = org.spongycastle.crypto.tls.CertificateStatus.parse(r9)
            r7.certificateStatus = r8
            assertEmpty(r9)
            r8 = 5
            goto L_0x01c0
        L_0x0064:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x006a:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x0070:
            short r8 = r7.connection_state
            switch(r8) {
                case 2: goto L_0x007b;
                case 3: goto L_0x007e;
                case 4: goto L_0x0085;
                case 5: goto L_0x0085;
                case 6: goto L_0x008a;
                case 7: goto L_0x008a;
                default: goto L_0x0075;
            }
        L_0x0075:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x007b:
            r7.handleSupplementalData(r0)
        L_0x007e:
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            r8.skipServerCredentials()
            r7.authentication = r0
        L_0x0085:
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            r8.skipServerKeyExchange()
        L_0x008a:
            assertEmpty(r9)
            r8 = 8
            r7.connection_state = r8
            org.spongycastle.crypto.tls.RecordStream r8 = r7.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r8 = r8.getHandshakeHash()
            r8.sealHashAlgorithms()
            org.spongycastle.crypto.tls.TlsClient r8 = r7.tlsClient
            java.util.Vector r8 = r8.getClientSupplementalData()
            if (r8 == 0) goto L_0x00a5
            r7.sendSupplementalDataMessage(r8)
        L_0x00a5:
            r8 = 9
            r7.connection_state = r8
            org.spongycastle.crypto.tls.CertificateRequest r8 = r7.certificateRequest
            if (r8 != 0) goto L_0x00b4
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            r8.skipClientCredentials()
            r8 = r0
            goto L_0x00d0
        L_0x00b4:
            org.spongycastle.crypto.tls.TlsAuthentication r9 = r7.authentication
            org.spongycastle.crypto.tls.TlsCredentials r8 = r9.getClientCredentials(r8)
            if (r8 != 0) goto L_0x00c4
            org.spongycastle.crypto.tls.TlsKeyExchange r9 = r7.keyExchange
            r9.skipClientCredentials()
            org.spongycastle.crypto.tls.Certificate r9 = org.spongycastle.crypto.tls.Certificate.EMPTY_CHAIN
            goto L_0x00cd
        L_0x00c4:
            org.spongycastle.crypto.tls.TlsKeyExchange r9 = r7.keyExchange
            r9.processClientCredentials(r8)
            org.spongycastle.crypto.tls.Certificate r9 = r8.getCertificate()
        L_0x00cd:
            r7.sendCertificateMessage(r9)
        L_0x00d0:
            r7.connection_state = r5
            r7.sendClientKeyExchangeMessage()
            r9 = 11
            r7.connection_state = r9
            org.spongycastle.crypto.tls.TlsContext r9 = r7.getContext()
            boolean r9 = org.spongycastle.crypto.tls.TlsUtils.isSSL(r9)
            if (r9 == 0) goto L_0x00ec
            org.spongycastle.crypto.tls.TlsContext r9 = r7.getContext()
            org.spongycastle.crypto.tls.TlsKeyExchange r1 = r7.keyExchange
            establishMasterSecret(r9, r1)
        L_0x00ec:
            org.spongycastle.crypto.tls.RecordStream r9 = r7.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r9 = r9.prepareToFinish()
            org.spongycastle.crypto.tls.SecurityParameters r1 = r7.securityParameters
            org.spongycastle.crypto.tls.TlsContext r2 = r7.getContext()
            byte[] r0 = getCurrentPRFHash(r2, r9, r0)
            r1.sessionHash = r0
            org.spongycastle.crypto.tls.TlsContext r0 = r7.getContext()
            boolean r0 = org.spongycastle.crypto.tls.TlsUtils.isSSL(r0)
            if (r0 != 0) goto L_0x0111
            org.spongycastle.crypto.tls.TlsContext r0 = r7.getContext()
            org.spongycastle.crypto.tls.TlsKeyExchange r1 = r7.keyExchange
            establishMasterSecret(r0, r1)
        L_0x0111:
            org.spongycastle.crypto.tls.RecordStream r0 = r7.recordStream
            org.spongycastle.crypto.tls.TlsPeer r1 = r7.getPeer()
            org.spongycastle.crypto.tls.TlsCompression r1 = r1.getCompression()
            org.spongycastle.crypto.tls.TlsPeer r2 = r7.getPeer()
            org.spongycastle.crypto.tls.TlsCipher r2 = r2.getCipher()
            r0.setPendingConnectionState(r1, r2)
            if (r8 == 0) goto L_0x0157
            boolean r0 = r8 instanceof org.spongycastle.crypto.tls.TlsSignerCredentials
            if (r0 == 0) goto L_0x0157
            org.spongycastle.crypto.tls.TlsSignerCredentials r8 = (org.spongycastle.crypto.tls.TlsSignerCredentials) r8
            org.spongycastle.crypto.tls.TlsContext r0 = r7.getContext()
            org.spongycastle.crypto.tls.SignatureAndHashAlgorithm r0 = org.spongycastle.crypto.tls.TlsUtils.getSignatureAndHashAlgorithm(r0, r8)
            if (r0 != 0) goto L_0x013f
            org.spongycastle.crypto.tls.SecurityParameters r9 = r7.securityParameters
            byte[] r9 = r9.getSessionHash()
            goto L_0x0147
        L_0x013f:
            short r1 = r0.getHash()
            byte[] r9 = r9.getFinalHash(r1)
        L_0x0147:
            byte[] r8 = r8.generateCertificateSignature(r9)
            org.spongycastle.crypto.tls.DigitallySigned r9 = new org.spongycastle.crypto.tls.DigitallySigned
            r9.<init>(r0, r8)
            r7.sendCertificateVerifyMessage(r9)
            r8 = 12
            r7.connection_state = r8
        L_0x0157:
            r7.sendChangeCipherSpecMessage()
            r7.sendFinishedMessage()
            r7.connection_state = r3
            goto L_0x029f
        L_0x0161:
            short r8 = r7.connection_state
            switch(r8) {
                case 4: goto L_0x016c;
                case 5: goto L_0x016c;
                case 6: goto L_0x0171;
                default: goto L_0x0166;
            }
        L_0x0166:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x016c:
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            r8.skipServerKeyExchange()
        L_0x0171:
            org.spongycastle.crypto.tls.TlsAuthentication r8 = r7.authentication
            if (r8 == 0) goto L_0x019a
            org.spongycastle.crypto.tls.TlsContext r8 = r7.getContext()
            org.spongycastle.crypto.tls.CertificateRequest r8 = org.spongycastle.crypto.tls.CertificateRequest.parse(r8, r9)
            r7.certificateRequest = r8
            assertEmpty(r9)
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            org.spongycastle.crypto.tls.CertificateRequest r9 = r7.certificateRequest
            r8.validateCertificateRequest(r9)
            org.spongycastle.crypto.tls.RecordStream r8 = r7.recordStream
            org.spongycastle.crypto.tls.TlsHandshakeHash r8 = r8.getHandshakeHash()
            org.spongycastle.crypto.tls.CertificateRequest r9 = r7.certificateRequest
            java.util.Vector r9 = r9.getSupportedSignatureAlgorithms()
            org.spongycastle.crypto.tls.TlsUtils.trackHashAlgorithms(r8, r9)
            r8 = 7
            goto L_0x01c0
        L_0x019a:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r9 = 40
            r8.<init>(r9)
            throw r8
        L_0x01a2:
            short r8 = r7.connection_state
            switch(r8) {
                case 2: goto L_0x01ad;
                case 3: goto L_0x01b0;
                case 4: goto L_0x01b7;
                case 5: goto L_0x01b7;
                default: goto L_0x01a7;
            }
        L_0x01a7:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x01ad:
            r7.handleSupplementalData(r0)
        L_0x01b0:
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            r8.skipServerCredentials()
            r7.authentication = r0
        L_0x01b7:
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            r8.processServerKeyExchange(r9)
            assertEmpty(r9)
            r8 = 6
        L_0x01c0:
            r7.connection_state = r8
            goto L_0x029f
        L_0x01c4:
            short r8 = r7.connection_state
            switch(r8) {
                case 2: goto L_0x01cf;
                case 3: goto L_0x01d2;
                default: goto L_0x01c9;
            }
        L_0x01c9:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x01cf:
            r7.handleSupplementalData(r0)
        L_0x01d2:
            org.spongycastle.crypto.tls.Certificate r8 = org.spongycastle.crypto.tls.Certificate.parse(r9)
            r7.peerCertificate = r8
            assertEmpty(r9)
            org.spongycastle.crypto.tls.Certificate r8 = r7.peerCertificate
            if (r8 == 0) goto L_0x01e7
            org.spongycastle.crypto.tls.Certificate r8 = r7.peerCertificate
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x01ea
        L_0x01e7:
            r8 = 0
            r7.allowCertificateStatus = r8
        L_0x01ea:
            org.spongycastle.crypto.tls.TlsKeyExchange r8 = r7.keyExchange
            org.spongycastle.crypto.tls.Certificate r9 = r7.peerCertificate
            r8.processServerCertificate(r9)
            org.spongycastle.crypto.tls.TlsClient r8 = r7.tlsClient
            org.spongycastle.crypto.tls.TlsAuthentication r8 = r8.getAuthentication()
            r7.authentication = r8
            org.spongycastle.crypto.tls.TlsAuthentication r8 = r7.authentication
            org.spongycastle.crypto.tls.Certificate r9 = r7.peerCertificate
            r8.notifyServerCertificate(r9)
            r7.connection_state = r6
            goto L_0x029f
        L_0x0204:
            short r8 = r7.connection_state
            switch(r8) {
                case 13: goto L_0x020f;
                case 14: goto L_0x0213;
                default: goto L_0x0209;
            }
        L_0x0209:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x020f:
            boolean r8 = r7.expectSessionTicket
            if (r8 != 0) goto L_0x021d
        L_0x0213:
            r7.processFinishedMessage(r9)
            r7.connection_state = r1
            r7.completeHandshake()
            goto L_0x029f
        L_0x021d:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x0223:
            short r8 = r7.connection_state
            if (r8 != r3) goto L_0x023a
            boolean r8 = r7.expectSessionTicket
            if (r8 == 0) goto L_0x0234
            r7.invalidateSession()
            r7.receiveNewSessionTicketMessage(r9)
            r8 = 14
            goto L_0x01c0
        L_0x0234:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x023a:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x0240:
            short r8 = r7.connection_state
            r1 = 1
            if (r8 != r1) goto L_0x028d
            r7.receiveServerHelloMessage(r9)
            r7.connection_state = r4
            org.spongycastle.crypto.tls.RecordStream r8 = r7.recordStream
            r8.notifyHelloComplete()
            r7.applyMaxFragmentLengthExtension()
            boolean r8 = r7.resumedSession
            if (r8 == 0) goto L_0x027d
            org.spongycastle.crypto.tls.SecurityParameters r8 = r7.securityParameters
            org.spongycastle.crypto.tls.SessionParameters r9 = r7.sessionParameters
            byte[] r9 = r9.getMasterSecret()
            byte[] r9 = org.spongycastle.util.Arrays.clone((byte[]) r9)
            r8.masterSecret = r9
            org.spongycastle.crypto.tls.RecordStream r8 = r7.recordStream
            org.spongycastle.crypto.tls.TlsPeer r9 = r7.getPeer()
            org.spongycastle.crypto.tls.TlsCompression r9 = r9.getCompression()
            org.spongycastle.crypto.tls.TlsPeer r0 = r7.getPeer()
            org.spongycastle.crypto.tls.TlsCipher r0 = r0.getCipher()
            r8.setPendingConnectionState(r9, r0)
            r7.sendChangeCipherSpecMessage()
            goto L_0x029f
        L_0x027d:
            r7.invalidateSession()
            byte[] r8 = r7.selectedSessionID
            int r9 = r8.length
            if (r9 <= 0) goto L_0x029f
            org.spongycastle.crypto.tls.TlsSessionImpl r9 = new org.spongycastle.crypto.tls.TlsSessionImpl
            r9.<init>(r8, r0)
            r7.tlsSession = r9
            goto L_0x029f
        L_0x028d:
            org.spongycastle.crypto.tls.TlsFatalAlert r8 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r8.<init>(r5)
            throw r8
        L_0x0293:
            assertEmpty(r9)
            short r8 = r7.connection_state
            r9 = 16
            if (r8 != r9) goto L_0x029f
            r7.refuseRenegotiation()
        L_0x029f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsClientProtocol.handleHandshakeMessage(short, java.io.ByteArrayInputStream):void");
    }

    /* access modifiers changed from: protected */
    public void handleSupplementalData(Vector vector) {
        this.tlsClient.processServerSupplementalData(vector);
        this.connection_state = 3;
        this.keyExchange = this.tlsClient.getKeyExchange();
        this.keyExchange.init(getContext());
    }

    /* access modifiers changed from: protected */
    public void receiveNewSessionTicketMessage(ByteArrayInputStream byteArrayInputStream) {
        NewSessionTicket parse = NewSessionTicket.parse(byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        this.tlsClient.notifyNewSessionTicket(parse);
    }

    /* access modifiers changed from: protected */
    public void receiveServerHelloMessage(ByteArrayInputStream byteArrayInputStream) {
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        if (readVersion.isDTLS()) {
            throw new TlsFatalAlert(47);
        } else if (!readVersion.equals(this.recordStream.getReadVersion())) {
            throw new TlsFatalAlert(47);
        } else if (readVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
            this.recordStream.setWriteVersion(readVersion);
            getContextAdmin().setServerVersion(readVersion);
            this.tlsClient.notifyServerVersion(readVersion);
            this.securityParameters.serverRandom = TlsUtils.readFully(32, (InputStream) byteArrayInputStream);
            this.selectedSessionID = TlsUtils.readOpaque8(byteArrayInputStream);
            byte[] bArr = this.selectedSessionID;
            if (bArr.length <= 32) {
                this.tlsClient.notifySessionID(bArr);
                boolean z = false;
                this.resumedSession = this.selectedSessionID.length > 0 && this.tlsSession != null && Arrays.areEqual(this.selectedSessionID, this.tlsSession.getSessionID());
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (!Arrays.contains(this.offeredCipherSuites, readUint16) || readUint16 == 0 || CipherSuite.isSCSV(readUint16) || !TlsUtils.isValidCipherSuiteForVersion(readUint16, getContext().getServerVersion())) {
                    throw new TlsFatalAlert(47);
                }
                this.tlsClient.notifySelectedCipherSuite(readUint16);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                if (Arrays.contains(this.offeredCompressionMethods, readUint8)) {
                    this.tlsClient.notifySelectedCompressionMethod(readUint8);
                    this.serverExtensions = readExtensions(byteArrayInputStream);
                    if (this.serverExtensions != null) {
                        Enumeration keys = this.serverExtensions.keys();
                        while (keys.hasMoreElements()) {
                            Integer num = (Integer) keys.nextElement();
                            if (!num.equals(EXT_RenegotiationInfo)) {
                                if (TlsUtils.getExtensionData(this.clientExtensions, num) != null) {
                                    boolean z2 = this.resumedSession;
                                } else {
                                    throw new TlsFatalAlert(AlertDescription.unsupported_extension);
                                }
                            }
                        }
                    }
                    byte[] extensionData = TlsUtils.getExtensionData(this.serverExtensions, EXT_RenegotiationInfo);
                    if (extensionData != null) {
                        this.secure_renegotiation = true;
                        if (!Arrays.constantTimeAreEqual(extensionData, createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                            throw new TlsFatalAlert(40);
                        }
                    }
                    this.tlsClient.notifySecureRenegotiation(this.secure_renegotiation);
                    Hashtable hashtable = this.clientExtensions;
                    Hashtable hashtable2 = this.serverExtensions;
                    if (this.resumedSession) {
                        if (readUint16 == this.sessionParameters.getCipherSuite() && readUint8 == this.sessionParameters.getCompressionAlgorithm()) {
                            hashtable = null;
                            hashtable2 = this.sessionParameters.readServerExtensions();
                        } else {
                            throw new TlsFatalAlert(47);
                        }
                    }
                    this.securityParameters.cipherSuite = readUint16;
                    this.securityParameters.compressionAlgorithm = readUint8;
                    if (hashtable2 != null) {
                        boolean hasEncryptThenMACExtension = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable2);
                        if (!hasEncryptThenMACExtension || TlsUtils.isBlockCipherSuite(readUint16)) {
                            this.securityParameters.encryptThenMAC = hasEncryptThenMACExtension;
                            this.securityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(hashtable2);
                            this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension(hashtable, hashtable2, 47);
                            this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable2);
                            this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsExtensionsUtils.EXT_status_request, 47);
                            if (!this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsProtocol.EXT_SessionTicket, 47)) {
                                z = true;
                            }
                            this.expectSessionTicket = z;
                        } else {
                            throw new TlsFatalAlert(47);
                        }
                    }
                    if (hashtable != null) {
                        this.tlsClient.processServerExtensions(hashtable2);
                    }
                    this.securityParameters.prfAlgorithm = getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
                    this.securityParameters.verifyDataLength = 12;
                    return;
                }
                throw new TlsFatalAlert(47);
            }
            throw new TlsFatalAlert(47);
        } else {
            throw new TlsFatalAlert(47);
        }
    }

    /* access modifiers changed from: protected */
    public void sendCertificateVerifyMessage(DigitallySigned digitallySigned) {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 15);
        digitallySigned.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    /* access modifiers changed from: protected */
    public void sendClientHelloMessage() {
        this.recordStream.setWriteVersion(this.tlsClient.getClientHelloRecordLayerVersion());
        ProtocolVersion clientVersion = this.tlsClient.getClientVersion();
        if (!clientVersion.isDTLS()) {
            getContextAdmin().setClientVersion(clientVersion);
            byte[] bArr = TlsUtils.EMPTY_BYTES;
            if (this.tlsSession != null && ((bArr = this.tlsSession.getSessionID()) == null || bArr.length > 32)) {
                bArr = TlsUtils.EMPTY_BYTES;
            }
            boolean isFallback = this.tlsClient.isFallback();
            this.offeredCipherSuites = this.tlsClient.getCipherSuites();
            this.offeredCompressionMethods = this.tlsClient.getCompressionMethods();
            if (bArr.length > 0 && this.sessionParameters != null && (!Arrays.contains(this.offeredCipherSuites, this.sessionParameters.getCipherSuite()) || !Arrays.contains(this.offeredCompressionMethods, this.sessionParameters.getCompressionAlgorithm()))) {
                bArr = TlsUtils.EMPTY_BYTES;
            }
            this.clientExtensions = this.tlsClient.getClientExtensions();
            TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 1);
            TlsUtils.writeVersion(clientVersion, handshakeMessage);
            handshakeMessage.write(this.securityParameters.getClientRandom());
            TlsUtils.writeOpaque8(bArr, handshakeMessage);
            boolean z = TlsUtils.getExtensionData(this.clientExtensions, EXT_RenegotiationInfo) == null;
            boolean z2 = !Arrays.contains(this.offeredCipherSuites, 255);
            if (z && z2) {
                this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, 255);
            }
            if (isFallback && !Arrays.contains(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV)) {
                this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV);
            }
            TlsUtils.writeUint16ArrayWithUint16Length(this.offeredCipherSuites, handshakeMessage);
            TlsUtils.writeUint8ArrayWithUint8Length(this.offeredCompressionMethods, handshakeMessage);
            if (this.clientExtensions != null) {
                writeExtensions(handshakeMessage, this.clientExtensions);
            }
            handshakeMessage.writeToRecordStream();
            return;
        }
        throw new TlsFatalAlert(80);
    }

    /* access modifiers changed from: protected */
    public void sendClientKeyExchangeMessage() {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, 16);
        this.keyExchange.generateClientKeyExchange(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }
}

package org.spongycastle.crypto.tls;

import org.spongycastle.asn1.cmc.BodyPartID;

class DTLSRecordLayer implements DatagramTransport {
    private static final int MAX_FRAGMENT_LENGTH = 16384;
    private static final int RECORD_HEADER_LENGTH = 13;
    private static final long RETRANSMIT_TIMEOUT = 240000;
    private static final long TCP_MSL = 120000;
    private volatile boolean closed = false;
    private final TlsContext context;
    private DTLSEpoch currentEpoch;
    private volatile boolean failed = false;
    private volatile boolean inHandshake;
    private final TlsPeer peer;
    private DTLSEpoch pendingEpoch;
    private volatile int plaintextLimit;
    private DTLSEpoch readEpoch;
    private volatile ProtocolVersion readVersion = null;
    private final ByteQueue recordQueue = new ByteQueue();
    private DTLSHandshakeRetransmit retransmit = null;
    private DTLSEpoch retransmitEpoch = null;
    private long retransmitExpiry = 0;
    private final DatagramTransport transport;
    private DTLSEpoch writeEpoch;
    private volatile ProtocolVersion writeVersion = null;

    DTLSRecordLayer(DatagramTransport datagramTransport, TlsContext tlsContext, TlsPeer tlsPeer, short s) {
        this.transport = datagramTransport;
        this.context = tlsContext;
        this.peer = tlsPeer;
        this.inHandshake = true;
        this.currentEpoch = new DTLSEpoch(0, new TlsNullCipher(tlsContext));
        this.pendingEpoch = null;
        DTLSEpoch dTLSEpoch = this.currentEpoch;
        this.readEpoch = dTLSEpoch;
        this.writeEpoch = dTLSEpoch;
        setPlaintextLimit(16384);
    }

    private void closeTransport() {
        if (!this.closed) {
            try {
                if (!this.failed) {
                    warn(0, (String) null);
                }
                this.transport.close();
            } catch (Exception unused) {
            }
            this.closed = true;
        }
    }

    private static long getMacSequenceNumber(int i, long j) {
        return ((((long) i) & BodyPartID.bodyIdMax) << 48) | j;
    }

    private void raiseAlert(short s, short s2, String str, Throwable th) {
        this.peer.notifyAlertRaised(s, s2, str, th);
        sendRecord(21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    private int receiveRecord(byte[] bArr, int i, int i2, int i3) {
        int readUint16;
        int i4;
        if (this.recordQueue.available() > 0) {
            if (this.recordQueue.available() >= 13) {
                byte[] bArr2 = new byte[2];
                this.recordQueue.read(bArr2, 0, 2, 11);
                i4 = TlsUtils.readUint16(bArr2, 0);
            } else {
                i4 = 0;
            }
            int min = Math.min(this.recordQueue.available(), i4 + 13);
            this.recordQueue.removeData(bArr, i, min, 0);
            return min;
        }
        int receive = this.transport.receive(bArr, i, i2, i3);
        if (receive < 13 || receive <= (readUint16 = TlsUtils.readUint16(bArr, i + 11) + 13)) {
            return receive;
        }
        this.recordQueue.addData(bArr, i + readUint16, receive - readUint16);
        return readUint16;
    }

    private void sendRecord(short s, byte[] bArr, int i, int i2) {
        short s2 = s;
        int i3 = i2;
        if (this.writeVersion != null) {
            if (i3 > this.plaintextLimit) {
                throw new TlsFatalAlert(80);
            } else if (i3 >= 1 || s2 == 23) {
                int epoch = this.writeEpoch.getEpoch();
                long allocateSequenceNumber = this.writeEpoch.allocateSequenceNumber();
                byte[] encodePlaintext = this.writeEpoch.getCipher().encodePlaintext(getMacSequenceNumber(epoch, allocateSequenceNumber), s, bArr, i, i2);
                byte[] bArr2 = new byte[(encodePlaintext.length + 13)];
                TlsUtils.writeUint8(s, bArr2, 0);
                TlsUtils.writeVersion(this.writeVersion, bArr2, 1);
                TlsUtils.writeUint16(epoch, bArr2, 3);
                TlsUtils.writeUint48(allocateSequenceNumber, bArr2, 5);
                TlsUtils.writeUint16(encodePlaintext.length, bArr2, 11);
                System.arraycopy(encodePlaintext, 0, bArr2, 13, encodePlaintext.length);
                this.transport.send(bArr2, 0, bArr2.length);
            } else {
                throw new TlsFatalAlert(80);
            }
        }
    }

    public void close() {
        if (!this.closed) {
            if (this.inHandshake) {
                warn(90, "User canceled handshake");
            }
            closeTransport();
        }
    }

    /* access modifiers changed from: package-private */
    public void fail(short s) {
        if (!this.closed) {
            try {
                raiseAlert(2, s, (String) null, (Throwable) null);
            } catch (Exception unused) {
            }
            this.failed = true;
            closeTransport();
        }
    }

    /* access modifiers changed from: package-private */
    public void failed() {
        if (!this.closed) {
            this.failed = true;
            closeTransport();
        }
    }

    /* access modifiers changed from: package-private */
    public int getReadEpoch() {
        return this.readEpoch.getEpoch();
    }

    /* access modifiers changed from: package-private */
    public ProtocolVersion getReadVersion() {
        return this.readVersion;
    }

    public int getReceiveLimit() {
        return Math.min(this.plaintextLimit, this.readEpoch.getCipher().getPlaintextLimit(this.transport.getReceiveLimit() - 13));
    }

    public int getSendLimit() {
        return Math.min(this.plaintextLimit, this.writeEpoch.getCipher().getPlaintextLimit(this.transport.getSendLimit() - 13));
    }

    /* access modifiers changed from: package-private */
    public void handshakeSuccessful(DTLSHandshakeRetransmit dTLSHandshakeRetransmit) {
        DTLSEpoch dTLSEpoch = this.readEpoch;
        DTLSEpoch dTLSEpoch2 = this.currentEpoch;
        if (dTLSEpoch == dTLSEpoch2 || this.writeEpoch == dTLSEpoch2) {
            throw new IllegalStateException();
        }
        if (dTLSHandshakeRetransmit != null) {
            this.retransmit = dTLSHandshakeRetransmit;
            this.retransmitEpoch = dTLSEpoch2;
            this.retransmitExpiry = System.currentTimeMillis() + RETRANSMIT_TIMEOUT;
        }
        this.inHandshake = false;
        this.currentEpoch = this.pendingEpoch;
        this.pendingEpoch = null;
    }

    /* access modifiers changed from: package-private */
    public void initPendingEpoch(TlsCipher tlsCipher) {
        if (this.pendingEpoch == null) {
            this.pendingEpoch = new DTLSEpoch(this.writeEpoch.getEpoch() + 1, tlsCipher);
            return;
        }
        throw new IllegalStateException();
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [org.spongycastle.crypto.tls.DTLSHandshakeRetransmit, org.spongycastle.crypto.tls.DTLSEpoch] */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076 A[Catch:{ IOException -> 0x013e }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0077 A[Catch:{ IOException -> 0x013e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int receive(byte[] r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r1 = r18
            r0 = 0
            r2 = r0
        L_0x0004:
            int r3 = r18.getReceiveLimit()
            r4 = r21
            int r3 = java.lang.Math.min(r4, r3)
            r5 = 13
            int r3 = r3 + r5
            if (r2 == 0) goto L_0x0016
            int r6 = r2.length
            if (r6 >= r3) goto L_0x0018
        L_0x0016:
            byte[] r2 = new byte[r3]
        L_0x0018:
            org.spongycastle.crypto.tls.DTLSHandshakeRetransmit r6 = r1.retransmit     // Catch:{ IOException -> 0x013e }
            if (r6 == 0) goto L_0x002a
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x013e }
            long r8 = r1.retransmitExpiry     // Catch:{ IOException -> 0x013e }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x002a
            r1.retransmit = r0     // Catch:{ IOException -> 0x013e }
            r1.retransmitEpoch = r0     // Catch:{ IOException -> 0x013e }
        L_0x002a:
            r13 = 0
            r14 = r22
            int r3 = r1.receiveRecord(r2, r13, r3, r14)     // Catch:{ IOException -> 0x013e }
            if (r3 >= 0) goto L_0x0034
            return r3
        L_0x0034:
            if (r3 >= r5) goto L_0x003b
        L_0x0036:
            r5 = r19
            r6 = r20
            goto L_0x0004
        L_0x003b:
            r6 = 11
            int r6 = org.spongycastle.crypto.tls.TlsUtils.readUint16(r2, r6)     // Catch:{ IOException -> 0x013e }
            int r6 = r6 + r5
            if (r3 == r6) goto L_0x0045
            goto L_0x0036
        L_0x0045:
            short r5 = org.spongycastle.crypto.tls.TlsUtils.readUint8(r2, r13)     // Catch:{ IOException -> 0x013e }
            switch(r5) {
                case 20: goto L_0x004d;
                case 21: goto L_0x004d;
                case 22: goto L_0x004d;
                case 23: goto L_0x004d;
                case 24: goto L_0x004d;
                default: goto L_0x004c;
            }     // Catch:{ IOException -> 0x013e }
        L_0x004c:
            goto L_0x0036
        L_0x004d:
            r6 = 3
            int r15 = org.spongycastle.crypto.tls.TlsUtils.readUint16(r2, r6)     // Catch:{ IOException -> 0x013e }
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.readEpoch     // Catch:{ IOException -> 0x013e }
            int r6 = r6.getEpoch()     // Catch:{ IOException -> 0x013e }
            if (r15 != r6) goto L_0x005f
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.readEpoch     // Catch:{ IOException -> 0x013e }
        L_0x005c:
            r16 = r6
            goto L_0x0074
        L_0x005f:
            r6 = 22
            if (r5 != r6) goto L_0x0072
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.retransmitEpoch     // Catch:{ IOException -> 0x013e }
            if (r6 == 0) goto L_0x0072
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.retransmitEpoch     // Catch:{ IOException -> 0x013e }
            int r6 = r6.getEpoch()     // Catch:{ IOException -> 0x013e }
            if (r15 != r6) goto L_0x0072
            org.spongycastle.crypto.tls.DTLSEpoch r6 = r1.retransmitEpoch     // Catch:{ IOException -> 0x013e }
            goto L_0x005c
        L_0x0072:
            r16 = r0
        L_0x0074:
            if (r16 != 0) goto L_0x0077
            goto L_0x0036
        L_0x0077:
            r6 = 5
            long r11 = org.spongycastle.crypto.tls.TlsUtils.readUint48(r2, r6)     // Catch:{ IOException -> 0x013e }
            org.spongycastle.crypto.tls.DTLSReplayWindow r6 = r16.getReplayWindow()     // Catch:{ IOException -> 0x013e }
            boolean r6 = r6.shouldDiscard(r11)     // Catch:{ IOException -> 0x013e }
            if (r6 == 0) goto L_0x0087
            goto L_0x0036
        L_0x0087:
            r10 = 1
            org.spongycastle.crypto.tls.ProtocolVersion r9 = org.spongycastle.crypto.tls.TlsUtils.readVersion(r2, r10)     // Catch:{ IOException -> 0x013e }
            boolean r6 = r9.isDTLS()     // Catch:{ IOException -> 0x013e }
            if (r6 != 0) goto L_0x0093
            goto L_0x0036
        L_0x0093:
            org.spongycastle.crypto.tls.ProtocolVersion r6 = r1.readVersion     // Catch:{ IOException -> 0x013e }
            if (r6 == 0) goto L_0x00a0
            org.spongycastle.crypto.tls.ProtocolVersion r6 = r1.readVersion     // Catch:{ IOException -> 0x013e }
            boolean r6 = r6.equals((org.spongycastle.crypto.tls.ProtocolVersion) r9)     // Catch:{ IOException -> 0x013e }
            if (r6 != 0) goto L_0x00a0
            goto L_0x0036
        L_0x00a0:
            org.spongycastle.crypto.tls.TlsCipher r6 = r16.getCipher()     // Catch:{ IOException -> 0x013e }
            int r7 = r16.getEpoch()     // Catch:{ IOException -> 0x013e }
            long r7 = getMacSequenceNumber(r7, r11)     // Catch:{ IOException -> 0x013e }
            r17 = 13
            int r3 = r3 + -13
            r0 = r9
            r9 = r5
            r10 = r2
            r13 = r11
            r11 = r17
            r12 = r3
            byte[] r3 = r6.decodeCiphertext(r7, r9, r10, r11, r12)     // Catch:{ IOException -> 0x013e }
            org.spongycastle.crypto.tls.DTLSReplayWindow r6 = r16.getReplayWindow()     // Catch:{ IOException -> 0x013e }
            r6.reportAuthenticated(r13)     // Catch:{ IOException -> 0x013e }
            int r6 = r3.length     // Catch:{ IOException -> 0x013e }
            int r7 = r1.plaintextLimit     // Catch:{ IOException -> 0x013e }
            if (r6 <= r7) goto L_0x00ce
        L_0x00c7:
            r5 = r19
            r6 = r20
            r0 = 0
            goto L_0x0004
        L_0x00ce:
            org.spongycastle.crypto.tls.ProtocolVersion r6 = r1.readVersion     // Catch:{ IOException -> 0x013e }
            if (r6 != 0) goto L_0x00d4
            r1.readVersion = r0     // Catch:{ IOException -> 0x013e }
        L_0x00d4:
            switch(r5) {
                case 20: goto L_0x010f;
                case 21: goto L_0x00ed;
                case 22: goto L_0x00dd;
                case 23: goto L_0x00d8;
                case 24: goto L_0x00c7;
                default: goto L_0x00d7;
            }     // Catch:{ IOException -> 0x013e }
        L_0x00d7:
            goto L_0x0126
        L_0x00d8:
            boolean r0 = r1.inHandshake     // Catch:{ IOException -> 0x013e }
            if (r0 == 0) goto L_0x0126
            goto L_0x00c7
        L_0x00dd:
            boolean r0 = r1.inHandshake     // Catch:{ IOException -> 0x013e }
            if (r0 != 0) goto L_0x0126
            org.spongycastle.crypto.tls.DTLSHandshakeRetransmit r0 = r1.retransmit     // Catch:{ IOException -> 0x013e }
            if (r0 == 0) goto L_0x00c7
            org.spongycastle.crypto.tls.DTLSHandshakeRetransmit r0 = r1.retransmit     // Catch:{ IOException -> 0x013e }
            int r5 = r3.length     // Catch:{ IOException -> 0x013e }
            r6 = 0
            r0.receivedHandshakeRecord(r15, r3, r6, r5)     // Catch:{ IOException -> 0x013e }
            goto L_0x00c7
        L_0x00ed:
            int r0 = r3.length     // Catch:{ IOException -> 0x013e }
            r5 = 2
            if (r0 != r5) goto L_0x00c7
            r0 = 0
            byte r0 = r3[r0]     // Catch:{ IOException -> 0x013e }
            short r0 = (short) r0     // Catch:{ IOException -> 0x013e }
            r6 = 1
            byte r3 = r3[r6]     // Catch:{ IOException -> 0x013e }
            short r3 = (short) r3     // Catch:{ IOException -> 0x013e }
            org.spongycastle.crypto.tls.TlsPeer r6 = r1.peer     // Catch:{ IOException -> 0x013e }
            r6.notifyAlertReceived(r0, r3)     // Catch:{ IOException -> 0x013e }
            if (r0 == r5) goto L_0x0106
            if (r3 != 0) goto L_0x00c7
            r18.closeTransport()     // Catch:{ IOException -> 0x013e }
            goto L_0x00c7
        L_0x0106:
            r18.failed()     // Catch:{ IOException -> 0x013e }
            org.spongycastle.crypto.tls.TlsFatalAlert r0 = new org.spongycastle.crypto.tls.TlsFatalAlert     // Catch:{ IOException -> 0x013e }
            r0.<init>(r3)     // Catch:{ IOException -> 0x013e }
            throw r0     // Catch:{ IOException -> 0x013e }
        L_0x010f:
            r6 = 1
            r0 = 0
        L_0x0111:
            int r5 = r3.length     // Catch:{ IOException -> 0x013e }
            if (r0 >= r5) goto L_0x00c7
            short r5 = org.spongycastle.crypto.tls.TlsUtils.readUint8(r3, r0)     // Catch:{ IOException -> 0x013e }
            if (r5 == r6) goto L_0x011b
            goto L_0x0123
        L_0x011b:
            org.spongycastle.crypto.tls.DTLSEpoch r5 = r1.pendingEpoch     // Catch:{ IOException -> 0x013e }
            if (r5 == 0) goto L_0x0123
            org.spongycastle.crypto.tls.DTLSEpoch r5 = r1.pendingEpoch     // Catch:{ IOException -> 0x013e }
            r1.readEpoch = r5     // Catch:{ IOException -> 0x013e }
        L_0x0123:
            int r0 = r0 + 1
            goto L_0x0111
        L_0x0126:
            boolean r0 = r1.inHandshake     // Catch:{ IOException -> 0x013e }
            if (r0 != 0) goto L_0x0133
            org.spongycastle.crypto.tls.DTLSHandshakeRetransmit r0 = r1.retransmit     // Catch:{ IOException -> 0x013e }
            if (r0 == 0) goto L_0x0133
            r0 = 0
            r1.retransmit = r0     // Catch:{ IOException -> 0x013e }
            r1.retransmitEpoch = r0     // Catch:{ IOException -> 0x013e }
        L_0x0133:
            int r0 = r3.length     // Catch:{ IOException -> 0x013e }
            r5 = r19
            r6 = r20
            r2 = 0
            java.lang.System.arraycopy(r3, r2, r5, r6, r0)     // Catch:{ IOException -> 0x013e }
            int r0 = r3.length     // Catch:{ IOException -> 0x013e }
            return r0
        L_0x013e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.DTLSRecordLayer.receive(byte[], int, int, int):int");
    }

    /* access modifiers changed from: package-private */
    public void resetWriteEpoch() {
        DTLSEpoch dTLSEpoch = this.retransmitEpoch;
        if (dTLSEpoch == null) {
            dTLSEpoch = this.currentEpoch;
        }
        this.writeEpoch = dTLSEpoch;
    }

    public void send(byte[] bArr, int i, int i2) {
        short s;
        if (this.inHandshake || this.writeEpoch == this.retransmitEpoch) {
            s = 22;
            if (TlsUtils.readUint8(bArr, i) == 20) {
                DTLSEpoch dTLSEpoch = null;
                if (this.inHandshake) {
                    dTLSEpoch = this.pendingEpoch;
                } else if (this.writeEpoch == this.retransmitEpoch) {
                    dTLSEpoch = this.currentEpoch;
                }
                if (dTLSEpoch != null) {
                    byte[] bArr2 = {1};
                    sendRecord(20, bArr2, 0, bArr2.length);
                    this.writeEpoch = dTLSEpoch;
                } else {
                    throw new IllegalStateException();
                }
            }
        } else {
            s = 23;
        }
        sendRecord(s, bArr, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void setPlaintextLimit(int i) {
        this.plaintextLimit = i;
    }

    /* access modifiers changed from: package-private */
    public void setReadVersion(ProtocolVersion protocolVersion) {
        this.readVersion = protocolVersion;
    }

    /* access modifiers changed from: package-private */
    public void setWriteVersion(ProtocolVersion protocolVersion) {
        this.writeVersion = protocolVersion;
    }

    /* access modifiers changed from: package-private */
    public void warn(short s, String str) {
        raiseAlert(1, s, str, (Throwable) null);
    }
}

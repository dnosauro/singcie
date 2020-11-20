package org.spongycastle.crypto.tls;

import com.parse.ParseQuery;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.util.Integers;

class DTLSReliableHandshake {
    private static final int MAX_RECEIVE_AHEAD = 16;
    private static final int MESSAGE_HEADER_LENGTH = 12;
    private Hashtable currentInboundFlight = new Hashtable();
    private TlsHandshakeHash handshakeHash;
    private int message_seq = 0;
    private int next_receive_seq = 0;
    private Vector outboundFlight = new Vector();
    private Hashtable previousInboundFlight = null;
    private DTLSRecordLayer recordLayer;
    private boolean sending = true;

    static class Message {
        private final byte[] body;
        private final int message_seq;
        private final short msg_type;

        private Message(int i, short s, byte[] bArr) {
            this.message_seq = i;
            this.msg_type = s;
            this.body = bArr;
        }

        public byte[] getBody() {
            return this.body;
        }

        public int getSeq() {
            return this.message_seq;
        }

        public short getType() {
            return this.msg_type;
        }
    }

    static class RecordLayerBuffer extends ByteArrayOutputStream {
        RecordLayerBuffer(int i) {
            super(i);
        }

        /* access modifiers changed from: package-private */
        public void sendToRecordLayer(DTLSRecordLayer dTLSRecordLayer) {
            dTLSRecordLayer.send(this.buf, 0, this.count);
            this.buf = null;
        }
    }

    DTLSReliableHandshake(TlsContext tlsContext, DTLSRecordLayer dTLSRecordLayer) {
        this.recordLayer = dTLSRecordLayer;
        this.handshakeHash = new DeferredHash();
        this.handshakeHash.init(tlsContext);
    }

    private int backOff(int i) {
        return Math.min(i * 2, 60000);
    }

    private static boolean checkAll(Hashtable hashtable) {
        Enumeration elements = hashtable.elements();
        while (elements.hasMoreElements()) {
            if (((DTLSReassembler) elements.nextElement()).getBodyIfComplete() == null) {
                return false;
            }
        }
        return true;
    }

    private void checkInboundFlight() {
        Enumeration keys = this.currentInboundFlight.keys();
        while (keys.hasMoreElements()) {
            ((Integer) keys.nextElement()).intValue();
            int i = this.next_receive_seq;
        }
    }

    private Message getPendingMessage() {
        byte[] bodyIfComplete;
        DTLSReassembler dTLSReassembler = (DTLSReassembler) this.currentInboundFlight.get(Integers.valueOf(this.next_receive_seq));
        if (dTLSReassembler == null || (bodyIfComplete = dTLSReassembler.getBodyIfComplete()) == null) {
            return null;
        }
        this.previousInboundFlight = null;
        int i = this.next_receive_seq;
        this.next_receive_seq = i + 1;
        return updateHandshakeMessagesDigest(new Message(i, dTLSReassembler.getMsgType(), bodyIfComplete));
    }

    private void prepareInboundFlight(Hashtable hashtable) {
        resetAll(this.currentInboundFlight);
        this.previousInboundFlight = this.currentInboundFlight;
        this.currentInboundFlight = hashtable;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
        r7 = org.spongycastle.crypto.tls.TlsUtils.readUint24(r8, r11 + 9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processRecord(int r17, int r18, byte[] r19, int r20, int r21) {
        /*
            r16 = this;
            r0 = r16
            r8 = r19
            r9 = 0
            r11 = r20
            r10 = r21
            r12 = 0
        L_0x000a:
            r13 = 1
            r1 = 12
            if (r10 < r1) goto L_0x0090
            int r1 = r11 + 9
            int r7 = org.spongycastle.crypto.tls.TlsUtils.readUint24(r8, r1)
            int r14 = r7 + 12
            if (r10 >= r14) goto L_0x001b
            goto L_0x0090
        L_0x001b:
            int r1 = r11 + 1
            int r3 = org.spongycastle.crypto.tls.TlsUtils.readUint24(r8, r1)
            int r1 = r11 + 6
            int r6 = org.spongycastle.crypto.tls.TlsUtils.readUint24(r8, r1)
            int r1 = r6 + r7
            if (r1 <= r3) goto L_0x002c
            goto L_0x0090
        L_0x002c:
            int r1 = r11 + 0
            short r2 = org.spongycastle.crypto.tls.TlsUtils.readUint8(r8, r1)
            r1 = 20
            if (r2 != r1) goto L_0x003a
            r15 = r18
            r1 = 1
            goto L_0x003d
        L_0x003a:
            r15 = r18
            r1 = 0
        L_0x003d:
            if (r15 == r1) goto L_0x0040
            goto L_0x0090
        L_0x0040:
            int r1 = r11 + 4
            int r1 = org.spongycastle.crypto.tls.TlsUtils.readUint16(r8, r1)
            int r4 = r0.next_receive_seq
            int r5 = r4 + r17
            if (r1 < r5) goto L_0x004d
            goto L_0x008c
        L_0x004d:
            if (r1 < r4) goto L_0x0074
            java.util.Hashtable r4 = r0.currentInboundFlight
            java.lang.Integer r5 = org.spongycastle.util.Integers.valueOf(r1)
            java.lang.Object r4 = r4.get(r5)
            org.spongycastle.crypto.tls.DTLSReassembler r4 = (org.spongycastle.crypto.tls.DTLSReassembler) r4
            if (r4 != 0) goto L_0x006b
            org.spongycastle.crypto.tls.DTLSReassembler r4 = new org.spongycastle.crypto.tls.DTLSReassembler
            r4.<init>(r2, r3)
            java.util.Hashtable r5 = r0.currentInboundFlight
            java.lang.Integer r1 = org.spongycastle.util.Integers.valueOf(r1)
            r5.put(r1, r4)
        L_0x006b:
            r1 = r4
            int r5 = r11 + 12
            r4 = r19
            r1.contributeFragment(r2, r3, r4, r5, r6, r7)
            goto L_0x008c
        L_0x0074:
            java.util.Hashtable r4 = r0.previousInboundFlight
            if (r4 == 0) goto L_0x008c
            java.lang.Integer r1 = org.spongycastle.util.Integers.valueOf(r1)
            java.lang.Object r1 = r4.get(r1)
            org.spongycastle.crypto.tls.DTLSReassembler r1 = (org.spongycastle.crypto.tls.DTLSReassembler) r1
            if (r1 == 0) goto L_0x008c
            int r5 = r11 + 12
            r4 = r19
            r1.contributeFragment(r2, r3, r4, r5, r6, r7)
            r12 = 1
        L_0x008c:
            int r11 = r11 + r14
            int r10 = r10 - r14
            goto L_0x000a
        L_0x0090:
            if (r12 == 0) goto L_0x009b
            java.util.Hashtable r1 = r0.previousInboundFlight
            boolean r1 = checkAll(r1)
            if (r1 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r13 = 0
        L_0x009c:
            if (r13 == 0) goto L_0x00a6
            r16.resendOutboundFlight()
            java.util.Hashtable r1 = r0.previousInboundFlight
            resetAll(r1)
        L_0x00a6:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.DTLSReliableHandshake.processRecord(int, int, byte[], int, int):boolean");
    }

    private void resendOutboundFlight() {
        this.recordLayer.resetWriteEpoch();
        for (int i = 0; i < this.outboundFlight.size(); i++) {
            writeMessage((Message) this.outboundFlight.elementAt(i));
        }
    }

    private static void resetAll(Hashtable hashtable) {
        Enumeration elements = hashtable.elements();
        while (elements.hasMoreElements()) {
            ((DTLSReassembler) elements.nextElement()).reset();
        }
    }

    private Message updateHandshakeMessagesDigest(Message message) {
        if (message.getType() != 0) {
            byte[] body = message.getBody();
            byte[] bArr = new byte[12];
            TlsUtils.writeUint8(message.getType(), bArr, 0);
            TlsUtils.writeUint24(body.length, bArr, 1);
            TlsUtils.writeUint16(message.getSeq(), bArr, 4);
            TlsUtils.writeUint24(0, bArr, 6);
            TlsUtils.writeUint24(body.length, bArr, 9);
            this.handshakeHash.update(bArr, 0, bArr.length);
            this.handshakeHash.update(body, 0, body.length);
        }
        return message;
    }

    private void writeHandshakeFragment(Message message, int i, int i2) {
        RecordLayerBuffer recordLayerBuffer = new RecordLayerBuffer(i2 + 12);
        TlsUtils.writeUint8(message.getType(), (OutputStream) recordLayerBuffer);
        TlsUtils.writeUint24(message.getBody().length, recordLayerBuffer);
        TlsUtils.writeUint16(message.getSeq(), recordLayerBuffer);
        TlsUtils.writeUint24(i, recordLayerBuffer);
        TlsUtils.writeUint24(i2, recordLayerBuffer);
        recordLayerBuffer.write(message.getBody(), i, i2);
        recordLayerBuffer.sendToRecordLayer(this.recordLayer);
    }

    private void writeMessage(Message message) {
        int sendLimit = this.recordLayer.getSendLimit() - 12;
        if (sendLimit >= 1) {
            int length = message.getBody().length;
            int i = 0;
            do {
                int min = Math.min(length - i, sendLimit);
                writeHandshakeFragment(message, i, min);
                i += min;
            } while (i < length);
            return;
        }
        throw new TlsFatalAlert(80);
    }

    /* access modifiers changed from: package-private */
    public void finish() {
        C35651 r1 = null;
        if (!this.sending) {
            checkInboundFlight();
        } else {
            prepareInboundFlight((Hashtable) null);
            if (this.previousInboundFlight != null) {
                r1 = new DTLSHandshakeRetransmit() {
                    public void receivedHandshakeRecord(int i, byte[] bArr, int i2, int i3) {
                        boolean unused = DTLSReliableHandshake.this.processRecord(0, i, bArr, i2, i3);
                    }
                };
            }
        }
        this.recordLayer.handshakeSuccessful(r1);
    }

    /* access modifiers changed from: package-private */
    public TlsHandshakeHash getHandshakeHash() {
        return this.handshakeHash;
    }

    /* access modifiers changed from: package-private */
    public void notifyHelloComplete() {
        this.handshakeHash = this.handshakeHash.notifyPRFDetermined();
    }

    /* access modifiers changed from: package-private */
    public TlsHandshakeHash prepareToFinish() {
        TlsHandshakeHash tlsHandshakeHash = this.handshakeHash;
        this.handshakeHash = tlsHandshakeHash.stopTracking();
        return tlsHandshakeHash;
    }

    /* access modifiers changed from: package-private */
    public Message receiveMessage() {
        if (this.sending) {
            this.sending = false;
            prepareInboundFlight(new Hashtable());
        }
        byte[] bArr = null;
        int i = ParseQuery.MAX_LIMIT;
        while (true) {
            try {
                Message pendingMessage = getPendingMessage();
                if (pendingMessage != null) {
                    return pendingMessage;
                }
                int receiveLimit = this.recordLayer.getReceiveLimit();
                if (bArr == null || bArr.length < receiveLimit) {
                    bArr = new byte[receiveLimit];
                }
                int receive = this.recordLayer.receive(bArr, 0, receiveLimit, i);
                if (receive < 0) {
                    resendOutboundFlight();
                    i = backOff(i);
                } else {
                    if (processRecord(16, this.recordLayer.getReadEpoch(), bArr, 0, receive)) {
                        i = backOff(i);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] receiveMessageBody(short s) {
        Message receiveMessage = receiveMessage();
        if (receiveMessage.getType() == s) {
            return receiveMessage.getBody();
        }
        throw new TlsFatalAlert(10);
    }

    /* access modifiers changed from: package-private */
    public void resetHandshakeMessagesDigest() {
        this.handshakeHash.reset();
    }

    /* access modifiers changed from: package-private */
    public void sendMessage(short s, byte[] bArr) {
        TlsUtils.checkUint24(bArr.length);
        if (!this.sending) {
            checkInboundFlight();
            this.sending = true;
            this.outboundFlight.removeAllElements();
        }
        int i = this.message_seq;
        this.message_seq = i + 1;
        Message message = new Message(i, s, bArr);
        this.outboundFlight.addElement(message);
        writeMessage(message);
        updateHandshakeMessagesDigest(message);
    }
}

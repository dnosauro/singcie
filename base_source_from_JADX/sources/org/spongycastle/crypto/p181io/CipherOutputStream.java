package org.spongycastle.crypto.p181io;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.modes.AEADBlockCipher;

/* renamed from: org.spongycastle.crypto.io.CipherOutputStream */
public class CipherOutputStream extends FilterOutputStream {
    private AEADBlockCipher aeadBlockCipher;
    private byte[] buf;
    private BufferedBlockCipher bufferedBlockCipher;
    private final byte[] oneByte = new byte[1];
    private StreamCipher streamCipher;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher2) {
        super(outputStream);
        this.bufferedBlockCipher = bufferedBlockCipher2;
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher2) {
        super(outputStream);
        this.streamCipher = streamCipher2;
    }

    public CipherOutputStream(OutputStream outputStream, AEADBlockCipher aEADBlockCipher) {
        super(outputStream);
        this.aeadBlockCipher = aEADBlockCipher;
    }

    private void ensureCapacity(int i, boolean z) {
        if (z) {
            BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
            if (bufferedBlockCipher2 != null) {
                i = bufferedBlockCipher2.getOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    i = aEADBlockCipher.getOutputSize(i);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher3 = this.bufferedBlockCipher;
            if (bufferedBlockCipher3 != null) {
                i = bufferedBlockCipher3.getUpdateOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.aeadBlockCipher;
                if (aEADBlockCipher2 != null) {
                    i = aEADBlockCipher2.getUpdateOutputSize(i);
                }
            }
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < i) {
            this.buf = new byte[i];
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (r1 != null) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            r4.ensureCapacity(r0, r1)
            org.spongycastle.crypto.BufferedBlockCipher r1 = r4.bufferedBlockCipher     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            if (r1 == 0) goto L_0x001b
            org.spongycastle.crypto.BufferedBlockCipher r1 = r4.bufferedBlockCipher     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            byte[] r2 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            int r1 = r1.doFinal(r2, r0)     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            if (r1 == 0) goto L_0x0037
            java.io.OutputStream r2 = r4.out     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            byte[] r3 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
        L_0x0017:
            r2.write(r3, r0, r1)     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            goto L_0x0037
        L_0x001b:
            org.spongycastle.crypto.modes.AEADBlockCipher r1 = r4.aeadBlockCipher     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            if (r1 == 0) goto L_0x002e
            org.spongycastle.crypto.modes.AEADBlockCipher r1 = r4.aeadBlockCipher     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            byte[] r2 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            int r1 = r1.doFinal(r2, r0)     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            if (r1 == 0) goto L_0x0037
            java.io.OutputStream r2 = r4.out     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            byte[] r3 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            goto L_0x0017
        L_0x002e:
            org.spongycastle.crypto.StreamCipher r0 = r4.streamCipher     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            if (r0 == 0) goto L_0x0037
            org.spongycastle.crypto.StreamCipher r0 = r4.streamCipher     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
            r0.reset()     // Catch:{ InvalidCipherTextException -> 0x0043, Exception -> 0x003a }
        L_0x0037:
            r0 = 0
            r1 = r0
            goto L_0x004b
        L_0x003a:
            r0 = move-exception
            org.spongycastle.crypto.io.CipherIOException r1 = new org.spongycastle.crypto.io.CipherIOException
            java.lang.String r2 = "Error closing stream: "
            r1.<init>(r2, r0)
            goto L_0x004b
        L_0x0043:
            r0 = move-exception
            org.spongycastle.crypto.io.InvalidCipherTextIOException r1 = new org.spongycastle.crypto.io.InvalidCipherTextIOException
            java.lang.String r2 = "Error finalising cipher data"
            r1.<init>(r2, r0)
        L_0x004b:
            r4.flush()     // Catch:{ IOException -> 0x0054 }
            java.io.OutputStream r0 = r4.out     // Catch:{ IOException -> 0x0054 }
            r0.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            if (r1 != 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r0 = r1
        L_0x0059:
            if (r0 != 0) goto L_0x005c
            return
        L_0x005c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.p181io.CipherOutputStream.close():void");
    }

    public void flush() {
        this.out.flush();
    }

    public void write(int i) {
        byte[] bArr = this.oneByte;
        byte b = (byte) i;
        bArr[0] = b;
        if (this.streamCipher != null) {
            this.out.write(this.streamCipher.returnByte(b));
        } else {
            write(bArr, 0, 1);
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        int processBytes;
        ensureCapacity(i2, false);
        BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
        if (bufferedBlockCipher2 != null) {
            processBytes = bufferedBlockCipher2.processBytes(bArr, i, i2, this.buf, 0);
            if (processBytes == 0) {
                return;
            }
        } else {
            AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
            if (aEADBlockCipher != null) {
                processBytes = aEADBlockCipher.processBytes(bArr, i, i2, this.buf, 0);
                if (processBytes == 0) {
                    return;
                }
            } else {
                this.streamCipher.processBytes(bArr, i, i2, this.buf, 0);
                this.out.write(this.buf, 0, i2);
                return;
            }
        }
        this.out.write(this.buf, 0, processBytes);
    }
}

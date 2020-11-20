package org.spongycastle.crypto.p181io;

import java.io.OutputStream;
import org.spongycastle.crypto.Digest;

/* renamed from: org.spongycastle.crypto.io.DigestOutputStream */
public class DigestOutputStream extends OutputStream {
    protected Digest digest;

    public DigestOutputStream(Digest digest2) {
        this.digest = digest2;
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public void write(int i) {
        this.digest.update((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}

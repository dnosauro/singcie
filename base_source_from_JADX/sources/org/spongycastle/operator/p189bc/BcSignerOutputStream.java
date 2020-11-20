package org.spongycastle.operator.p189bc;

import java.io.OutputStream;
import org.spongycastle.crypto.Signer;

/* renamed from: org.spongycastle.operator.bc.BcSignerOutputStream */
public class BcSignerOutputStream extends OutputStream {
    private Signer sig;

    BcSignerOutputStream(Signer signer) {
        this.sig = signer;
    }

    /* access modifiers changed from: package-private */
    public byte[] getSignature() {
        return this.sig.generateSignature();
    }

    /* access modifiers changed from: package-private */
    public boolean verify(byte[] bArr) {
        return this.sig.verifySignature(bArr);
    }

    public void write(int i) {
        this.sig.update((byte) i);
    }

    public void write(byte[] bArr) {
        this.sig.update(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.sig.update(bArr, i, i2);
    }
}

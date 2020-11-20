package org.spongycastle.crypto.modes.gcm;

public class BasicGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private int[] f7821H;

    public void init(byte[] bArr) {
        this.f7821H = GCMUtil.asInts(bArr);
    }

    public void multiplyH(byte[] bArr) {
        int[] asInts = GCMUtil.asInts(bArr);
        GCMUtil.multiply(asInts, this.f7821H);
        GCMUtil.asBytes(asInts, bArr);
    }
}

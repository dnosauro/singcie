package org.spongycastle.crypto.digests;

import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA512Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 64;

    public SHA512Digest() {
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }

    public SHA512Digest(byte[] bArr) {
        restoreState(bArr);
    }

    public Memoable copy() {
        return new SHA512Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.longToBigEndian(this.f7518H1, bArr, i);
        Pack.longToBigEndian(this.f7519H2, bArr, i + 8);
        Pack.longToBigEndian(this.f7520H3, bArr, i + 16);
        Pack.longToBigEndian(this.f7521H4, bArr, i + 24);
        Pack.longToBigEndian(this.f7522H5, bArr, i + 32);
        Pack.longToBigEndian(this.f7523H6, bArr, i + 40);
        Pack.longToBigEndian(this.f7524H7, bArr, i + 48);
        Pack.longToBigEndian(this.f7525H8, bArr, i + 56);
        reset();
        return 64;
    }

    public String getAlgorithmName() {
        return McElieceCCA2KeyGenParameterSpec.SHA512;
    }

    public int getDigestSize() {
        return 64;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[getEncodedStateSize()];
        super.populateState(bArr);
        return bArr;
    }

    public void reset() {
        super.reset();
        this.f7518H1 = 7640891576956012808L;
        this.f7519H2 = -4942790177534073029L;
        this.f7520H3 = 4354685564936845355L;
        this.f7521H4 = -6534734903238641935L;
        this.f7522H5 = 5840696475078001361L;
        this.f7523H6 = -7276294671716946913L;
        this.f7524H7 = 2270897969802886507L;
        this.f7525H8 = 6620516959819538809L;
    }

    public void reset(Memoable memoable) {
        copyIn((SHA512Digest) memoable);
    }
}

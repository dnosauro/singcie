package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

public final class GOST3411_2012_256Digest extends GOST3411_2012Digest {

    /* renamed from: IV */
    private static final byte[] f7515IV = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public GOST3411_2012_256Digest() {
        super(f7515IV);
    }

    public GOST3411_2012_256Digest(GOST3411_2012_256Digest gOST3411_2012_256Digest) {
        super(f7515IV);
        reset(gOST3411_2012_256Digest);
    }

    public Memoable copy() {
        return new GOST3411_2012_256Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        byte[] bArr2 = new byte[64];
        super.doFinal(bArr2, 0);
        System.arraycopy(bArr2, 32, bArr, i, 32);
        return 32;
    }

    public String getAlgorithmName() {
        return "GOST3411-2012-256";
    }

    public int getDigestSize() {
        return 32;
    }
}

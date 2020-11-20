package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;

public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x */
    private int[] f7820x;

    public void exponentiateX(long j, byte[] bArr) {
        int[] oneAsInts = GCMUtil.oneAsInts();
        if (j > 0) {
            int[] clone = Arrays.clone(this.f7820x);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.multiply(oneAsInts, clone);
                }
                GCMUtil.multiply(clone, clone);
                j >>>= 1;
            } while (j > 0);
        }
        GCMUtil.asBytes(oneAsInts, bArr);
    }

    public void init(byte[] bArr) {
        this.f7820x = GCMUtil.asInts(bArr);
    }
}

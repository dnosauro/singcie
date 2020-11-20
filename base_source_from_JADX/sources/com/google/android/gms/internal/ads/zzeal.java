package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzeal<P> {
    private final P zzhyp;
    private final byte[] zzhyq;
    private final zzefl zzhyr;
    private final zzegd zzhys;
    private final int zzhyt;

    zzeal(P p, byte[] bArr, zzefl zzefl, zzegd zzegd, int i) {
        this.zzhyp = p;
        this.zzhyq = Arrays.copyOf(bArr, bArr.length);
        this.zzhyr = zzefl;
        this.zzhys = zzegd;
        this.zzhyt = i;
    }

    public final P zzbaa() {
        return this.zzhyp;
    }

    public final zzefl zzbab() {
        return this.zzhyr;
    }

    public final zzegd zzbac() {
        return this.zzhys;
    }

    public final byte[] zzbad() {
        byte[] bArr = this.zzhyq;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}

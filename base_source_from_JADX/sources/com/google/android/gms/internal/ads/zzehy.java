package com.google.android.gms.internal.ads;

import java.security.InvalidAlgorithmParameterException;

public final class zzehy implements zzeak {
    private final zzedb zzihy;
    private final int zzihz;

    public zzehy(zzedb zzedb, int i) {
        this.zzihy = zzedb;
        this.zzihz = i;
        if (i >= 10) {
            zzedb.zzd(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final byte[] zzl(byte[] bArr) {
        return this.zzihy.zzd(bArr, this.zzihz);
    }
}

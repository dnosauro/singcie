package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcgd implements zzepf<zzcgb> {
    private final zzeps<zzcda> zzfbj;
    private final zzeps<Context> zzfwi;
    private final zzeps<zzcce> zzgbm;
    private final zzeps<zzcbt> zzghe;

    private zzcgd(zzeps<Context> zzeps, zzeps<zzcce> zzeps2, zzeps<zzcda> zzeps3, zzeps<zzcbt> zzeps4) {
        this.zzfwi = zzeps;
        this.zzgbm = zzeps2;
        this.zzfbj = zzeps3;
        this.zzghe = zzeps4;
    }

    public static zzcgd zzc(zzeps<Context> zzeps, zzeps<zzcce> zzeps2, zzeps<zzcda> zzeps3, zzeps<zzcbt> zzeps4) {
        return new zzcgd(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzcgb(this.zzfwi.get(), this.zzgbm.get(), this.zzfbj.get(), this.zzghe.get());
    }
}

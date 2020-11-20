package com.google.android.gms.internal.ads;

public final class zzcgc implements zzepf<zzcfz> {
    private final zzeps<String> zzfxm;
    private final zzeps<zzcce> zzgbm;
    private final zzeps<zzcbt> zzghe;

    private zzcgc(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        this.zzfxm = zzeps;
        this.zzghe = zzeps2;
        this.zzgbm = zzeps3;
    }

    public static zzcgc zzm(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        return new zzcgc(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcfz(this.zzfxm.get(), this.zzghe.get(), this.zzgbm.get());
    }
}

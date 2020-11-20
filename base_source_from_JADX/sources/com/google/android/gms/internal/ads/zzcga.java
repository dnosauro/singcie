package com.google.android.gms.internal.ads;

public final class zzcga implements zzepf<zzcfx> {
    private final zzeps<String> zzfxm;
    private final zzeps<zzcce> zzgbm;
    private final zzeps<zzcbt> zzghe;

    private zzcga(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        this.zzfxm = zzeps;
        this.zzghe = zzeps2;
        this.zzgbm = zzeps3;
    }

    public static zzcga zzl(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        return new zzcga(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcfx(this.zzfxm.get(), this.zzghe.get(), this.zzgbm.get());
    }
}

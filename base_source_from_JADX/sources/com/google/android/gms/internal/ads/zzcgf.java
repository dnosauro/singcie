package com.google.android.gms.internal.ads;

public final class zzcgf implements zzepf<zzcgg> {
    private final zzeps<String> zzfxm;
    private final zzeps<zzcce> zzgbm;
    private final zzeps<zzcbt> zzghe;

    private zzcgf(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        this.zzfxm = zzeps;
        this.zzghe = zzeps2;
        this.zzgbm = zzeps3;
    }

    public static zzcgf zzn(zzeps<String> zzeps, zzeps<zzcbt> zzeps2, zzeps<zzcce> zzeps3) {
        return new zzcgf(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcgg(this.zzfxm.get(), this.zzghe.get(), this.zzgbm.get());
    }
}

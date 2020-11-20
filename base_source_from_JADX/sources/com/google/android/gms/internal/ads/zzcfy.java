package com.google.android.gms.internal.ads;

public final class zzcfy implements zzepf<zzcft> {
    private final zzeps<zzcce> zzgbm;
    private final zzeps<zzcbt> zzghe;

    private zzcfy(zzeps<zzcbt> zzeps, zzeps<zzcce> zzeps2) {
        this.zzghe = zzeps;
        this.zzgbm = zzeps2;
    }

    public static zzcfy zzz(zzeps<zzcbt> zzeps, zzeps<zzcce> zzeps2) {
        return new zzcfy(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcft(this.zzghe.get(), this.zzgbm.get());
    }
}

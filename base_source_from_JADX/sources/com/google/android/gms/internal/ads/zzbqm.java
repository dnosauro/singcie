package com.google.android.gms.internal.ads;

public final class zzbqm implements zzepf<zzbxy<zzbsp>> {
    private final zzeps<zzbqx> zzfrk;
    private final zzbpx zzfwh;

    private zzbqm(zzbpx zzbpx, zzeps<zzbqx> zzeps) {
        this.zzfwh = zzbpx;
        this.zzfrk = zzeps;
    }

    public static zzbqm zzc(zzbpx zzbpx, zzeps<zzbqx> zzeps) {
        return new zzbqm(zzbpx, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}

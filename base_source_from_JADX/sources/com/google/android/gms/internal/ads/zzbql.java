package com.google.android.gms.internal.ads;

public final class zzbql implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<zzbqx> zzfrk;
    private final zzbpx zzfwh;

    private zzbql(zzbpx zzbpx, zzeps<zzbqx> zzeps) {
        this.zzfwh = zzbpx;
        this.zzfrk = zzeps;
    }

    public static zzbql zzb(zzbpx zzbpx, zzeps<zzbqx> zzeps) {
        return new zzbql(zzbpx, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}

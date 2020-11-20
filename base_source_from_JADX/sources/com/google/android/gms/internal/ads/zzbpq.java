package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpq implements zzepf<zzbxy<zzbyd>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbyg> zzfse;

    private zzbpq(zzeps<zzbyg> zzeps, zzeps<Executor> zzeps2) {
        this.zzfse = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbpq zzf(zzeps<zzbyg> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

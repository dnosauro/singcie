package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcpo implements zzepf<zzbxy<zzbrz>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcpv> zzfrk;

    private zzcpo(zzeps<zzcpv> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcpo zzav(zzeps<zzcpv> zzeps, zzeps<Executor> zzeps2) {
        return new zzcpo(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
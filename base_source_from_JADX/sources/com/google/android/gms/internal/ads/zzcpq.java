package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcpq implements zzepf<zzbxy<zzdru>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcqc> zzfrk;

    private zzcpq(zzeps<zzcqc> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcpq zzaw(zzeps<zzcqc> zzeps, zzeps<Executor> zzeps2) {
        return new zzcpq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcjc implements zzepf<zzbxy<zzbsm>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcjj> zzfrk;

    private zzcjc(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcjc zzad(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcjc(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

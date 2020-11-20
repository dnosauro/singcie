package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzciz implements zzepf<zzbxy<zzbrz>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcjj> zzfrk;

    private zzciz(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzciz zzaa(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzciz(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

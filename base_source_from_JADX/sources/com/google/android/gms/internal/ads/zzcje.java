package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcje implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcjj> zzfrk;

    private zzcje(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcje zzaf(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcje(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

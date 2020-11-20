package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcjb implements zzepf<zzbxy<zzbwl>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcjj> zzfrk;

    private zzcjb(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcjb zzac(zzeps<zzcjj> zzeps, zzeps<Executor> zzeps2) {
        return new zzcjb(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

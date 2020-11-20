package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcmq implements zzepf<zzbxy<zzbui>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcob> zzfrk;

    private zzcmq(zzeps<zzcob> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcmq zzar(zzeps<zzcob> zzeps, zzeps<Executor> zzeps2) {
        return new zzcmq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

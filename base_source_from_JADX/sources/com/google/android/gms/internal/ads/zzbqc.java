package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqc implements zzepf<zzbxy<zzbry>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcke> zzfrk;

    private zzbqc(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbqc zzn(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqc(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

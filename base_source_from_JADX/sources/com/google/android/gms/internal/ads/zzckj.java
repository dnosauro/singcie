package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzckj implements zzepf<zzbxy<zzdru>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcku> zzfrk;

    private zzckj(zzeps<zzcku> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzckj zzam(zzeps<zzcku> zzeps, zzeps<Executor> zzeps2) {
        return new zzckj(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

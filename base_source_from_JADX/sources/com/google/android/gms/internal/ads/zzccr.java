package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzccr implements zzepf<zzbxy<zzbub>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcyb> zzfrk;

    private zzccr(zzeps<zzcyb> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzccr zzy(zzeps<zzcyb> zzeps, zzeps<Executor> zzeps2) {
        return new zzccr(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

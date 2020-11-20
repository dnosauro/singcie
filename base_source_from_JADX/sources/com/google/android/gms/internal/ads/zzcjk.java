package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcjk implements zzepf<Set<zzbxy<zzdru>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcka> zzfrk;

    private zzcjk(zzeps<Executor> zzeps, zzeps<zzcka> zzeps2) {
        this.zzevg = zzeps;
        this.zzfrk = zzeps2;
    }

    public static zzcjk zzag(zzeps<Executor> zzeps, zzeps<zzcka> zzeps2) {
        return new zzcjk(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        Executor executor = this.zzevg.get();
        return (Set) zzepl.zza(((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue() ? Collections.singleton(new zzbxy(this.zzfrk.get(), executor)) : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

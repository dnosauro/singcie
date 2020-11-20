package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpz implements zzepf<zzbxy<zzbru>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbul> zzfrk;

    private zzbpz(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbpz zzk(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpz(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

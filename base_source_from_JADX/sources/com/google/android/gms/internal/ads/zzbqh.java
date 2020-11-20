package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqh implements zzepf<zzbxy<zzbvz>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcke> zzfrk;

    private zzbqh(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbqh zzr(zzeps<zzcke> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqh(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

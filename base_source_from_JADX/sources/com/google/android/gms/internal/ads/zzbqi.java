package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqi implements zzepf<zzbxy<zzbub>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbul> zzfrk;

    private zzbqi(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbqi zzs(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqi(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

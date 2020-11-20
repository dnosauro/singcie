package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbqd implements zzepf<zzbxy<zzbto>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbul> zzfrk;

    private zzbqd(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbqd zzo(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqd(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

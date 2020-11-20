package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcki implements zzepf<zzbxy<zzbui>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzckg> zzfrk;

    private zzcki(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcki zzal(zzeps<zzckg> zzeps, zzeps<Executor> zzeps2) {
        return new zzcki(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

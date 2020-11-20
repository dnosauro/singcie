package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpt implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbjv> zzfse;

    private zzbpt(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.zzfse = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbxy<zzbtj> zza(zzbjv zzbjv, Executor executor) {
        return (zzbxy) zzepl.zza(new zzbxy(zzbjv, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbpt zzi(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpt(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfse.get(), this.zzevg.get());
    }
}

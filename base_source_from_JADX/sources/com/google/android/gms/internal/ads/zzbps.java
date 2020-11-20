package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbps implements zzepf<zzbxy<zzbru>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbjv> zzfse;

    private zzbps(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.zzfse = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbps zzh(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbps(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

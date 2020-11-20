package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpu implements zzepf<zzbxy<zzbsm>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbjv> zzfse;

    private zzbpu(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.zzfse = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbpu zzj(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpu(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

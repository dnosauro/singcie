package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbpr implements zzepf<zzbxy<zzbsi>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbjv> zzfse;

    private zzbpr(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        this.zzfse = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbpr zzg(zzeps<zzbjv> zzeps, zzeps<Executor> zzeps2) {
        return new zzbpr(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

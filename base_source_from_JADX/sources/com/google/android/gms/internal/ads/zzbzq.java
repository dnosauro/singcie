package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbzq implements zzepf<zzbxy<zzbru>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcal> zzfse;
    private final zzbzc zzfzx;

    private zzbzq(zzbzc zzbzc, zzeps<zzcal> zzeps, zzeps<Executor> zzeps2) {
        this.zzfzx = zzbzc;
        this.zzfse = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbzq zzb(zzbzc zzbzc, zzeps<zzcal> zzeps, zzeps<Executor> zzeps2) {
        return new zzbzq(zzbzc, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbzr implements zzepf<zzbxy<zzbvs>> {
    private final zzeps<Executor> zzevg;
    private final zzbzc zzfzx;

    private zzbzr(zzbzc zzbzc, zzeps<Executor> zzeps) {
        this.zzfzx = zzbzc;
        this.zzevg = zzeps;
    }

    public static zzbzr zzf(zzbzc zzbzc, zzeps<Executor> zzeps) {
        return new zzbzr(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(this.zzfzx.zzb(this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

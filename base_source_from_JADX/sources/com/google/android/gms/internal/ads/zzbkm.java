package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbkm implements zzepf<zzbjz> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzqr> zzfrm;
    private final zzeps<zzamq> zzfrn;

    private zzbkm(zzeps<zzqr> zzeps, zzeps<zzamq> zzeps2, zzeps<Executor> zzeps3) {
        this.zzfrm = zzeps;
        this.zzfrn = zzeps2;
        this.zzevg = zzeps3;
    }

    public static zzbkm zzb(zzeps<zzqr> zzeps, zzeps<zzamq> zzeps2, zzeps<Executor> zzeps3) {
        return new zzbkm(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzbjz) zzepl.zza(new zzbjz(this.zzfrm.get().getUniqueId(), this.zzfrn.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

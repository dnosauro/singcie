package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbmv implements zzepf<zzbxy<zzqu>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbnx> zzfse;
    private final zzbmh zzftq;

    public zzbmv(zzbmh zzbmh, zzeps<zzbnx> zzeps, zzeps<Executor> zzeps2) {
        this.zzftq = zzbmh;
        this.zzfse = zzeps;
        this.zzevg = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

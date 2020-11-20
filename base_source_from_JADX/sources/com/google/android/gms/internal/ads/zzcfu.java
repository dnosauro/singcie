package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcfu implements zzepf<zzcff> {
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzchp> zzgfa;

    public zzcfu(zzeps<zzdnn> zzeps, zzeps<Executor> zzeps2, zzeps<zzchp> zzeps3) {
        this.zzfts = zzeps;
        this.zzftl = zzeps2;
        this.zzgfa = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcff(this.zzfts.get(), this.zzftl.get(), this.zzgfa.get());
    }
}

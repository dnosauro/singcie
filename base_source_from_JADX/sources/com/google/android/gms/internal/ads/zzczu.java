package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzczu implements zzepf<zzczs> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcmx> zzgmg;

    public zzczu(zzeps<Executor> zzeps, zzeps<zzcmx> zzeps2) {
        this.zzevg = zzeps;
        this.zzgmg = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzczs(this.zzevg.get(), this.zzgmg.get());
    }
}

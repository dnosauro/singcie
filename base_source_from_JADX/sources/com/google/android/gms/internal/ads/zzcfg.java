package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcfg implements zzepf<zzcfc> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzces> zzgge;

    public zzcfg(zzeps<Executor> zzeps, zzeps<zzces> zzeps2) {
        this.zzevg = zzeps;
        this.zzgge = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzcfc(this.zzevg.get(), this.zzgge.get());
    }
}

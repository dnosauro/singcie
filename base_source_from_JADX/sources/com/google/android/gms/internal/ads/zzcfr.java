package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzcfr implements zzepf<zzcfo> {
    private final zzeps<Executor> zzftl;
    private final zzeps<zzbkr> zzgfb;
    private final zzeps<zzbxx> zzghb;

    public zzcfr(zzeps<Executor> zzeps, zzeps<zzbkr> zzeps2, zzeps<zzbxx> zzeps3) {
        this.zzftl = zzeps;
        this.zzgfb = zzeps2;
        this.zzghb = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcfo(this.zzftl.get(), this.zzgfb.get(), this.zzghb.get());
    }
}

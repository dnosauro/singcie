package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class zzdjs<R> implements zzdqb {
    public final Executor executor;
    public final String zzbum;
    public final zzvk zzdsr;
    public final zzvw zzgyt;
    public final zzdkn<R> zzhev;
    public final zzdkm zzhew;
    @Nullable
    private final zzdpq zzhex;

    public zzdjs(zzdkn<R> zzdkn, zzdkm zzdkm, zzvk zzvk, String str, Executor executor2, zzvw zzvw, @Nullable zzdpq zzdpq) {
        this.zzhev = zzdkn;
        this.zzhew = zzdkm;
        this.zzdsr = zzvk;
        this.zzbum = str;
        this.executor = executor2;
        this.zzgyt = zzvw;
        this.zzhex = zzdpq;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    @Nullable
    public final zzdpq zzaua() {
        return this.zzhex;
    }

    public final zzdqb zzaub() {
        return new zzdjs(this.zzhev, this.zzhew, this.zzdsr, this.zzbum, this.executor, this.zzgyt, this.zzhex);
    }
}

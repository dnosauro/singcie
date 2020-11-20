package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzbnp implements zzepf<zzbnk> {
    private final zzeps<zzbob> zzfav;
    private final zzeps<Runnable> zzfmb;
    private final zzeps<zzagd> zzfrk;
    private final zzeps<Executor> zzftl;

    public zzbnp(zzeps<zzbob> zzeps, zzeps<zzagd> zzeps2, zzeps<Runnable> zzeps3, zzeps<Executor> zzeps4) {
        this.zzfav = zzeps;
        this.zzfrk = zzeps2;
        this.zzfmb = zzeps3;
        this.zzftl = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzbnk(this.zzfav.get(), this.zzfrk.get(), this.zzfmb.get(), this.zzftl.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcmb implements zzepf<zzclp> {
    private final zzeps<zzciq> zzevd;
    private final zzeps<Executor> zzevg;
    private final zzeps<zzckz> zzewd;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<Executor> zzftl;
    private final zzeps<Context> zzglt;
    private final zzeps<WeakReference<Context>> zzglu;

    public zzcmb(zzeps<Executor> zzeps, zzeps<Context> zzeps2, zzeps<WeakReference<Context>> zzeps3, zzeps<Executor> zzeps4, zzeps<zzciq> zzeps5, zzeps<ScheduledExecutorService> zzeps6, zzeps<zzckz> zzeps7, zzeps<zzazh> zzeps8) {
        this.zzftl = zzeps;
        this.zzglt = zzeps2;
        this.zzglu = zzeps3;
        this.zzevg = zzeps4;
        this.zzevd = zzeps5;
        this.zzfqh = zzeps6;
        this.zzewd = zzeps7;
        this.zzfrq = zzeps8;
    }

    public final /* synthetic */ Object get() {
        return new zzclp(this.zzftl.get(), this.zzglt.get(), this.zzglu.get(), this.zzevg.get(), this.zzevd.get(), this.zzfqh.get(), this.zzewd.get(), this.zzfrq.get());
    }
}

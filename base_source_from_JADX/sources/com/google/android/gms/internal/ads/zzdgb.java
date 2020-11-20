package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdgb implements zzepf<zzdfw> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzayc> zzewn;
    private final zzeps<ScheduledExecutorService> zzfqh;

    public zzdgb(zzeps<zzayc> zzeps, zzeps<Context> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<Executor> zzeps4) {
        this.zzewn = zzeps;
        this.zzevi = zzeps2;
        this.zzfqh = zzeps3;
        this.zzevg = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzdfw(this.zzewn.get(), this.zzevi.get(), this.zzfqh.get(), this.zzevg.get());
    }
}

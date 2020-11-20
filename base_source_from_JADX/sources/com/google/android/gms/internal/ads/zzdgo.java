package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdgo implements zzepf<zzdgk> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzayc> zzewn;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzayg> zzgyo;
    private final zzeps<Integer> zzhci;

    public zzdgo(zzeps<zzayc> zzeps, zzeps<Integer> zzeps2, zzeps<Context> zzeps3, zzeps<zzayg> zzeps4, zzeps<ScheduledExecutorService> zzeps5, zzeps<Executor> zzeps6) {
        this.zzewn = zzeps;
        this.zzhci = zzeps2;
        this.zzevi = zzeps3;
        this.zzgyo = zzeps4;
        this.zzfqh = zzeps5;
        this.zzevg = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzdgk(this.zzewn.get(), this.zzhci.get().intValue(), this.zzevi.get(), this.zzgyo.get(), this.zzfqh.get(), this.zzevg.get());
    }
}

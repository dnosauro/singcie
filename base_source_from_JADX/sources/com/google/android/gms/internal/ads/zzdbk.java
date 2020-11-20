package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdbk implements zzepf<zzdbg> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<ScheduledExecutorService> zzfqh;

    private zzdbk(zzeps<Context> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Executor> zzeps3) {
        this.zzevi = zzeps;
        this.zzfqh = zzeps2;
        this.zzevg = zzeps3;
    }

    public static zzdbk zzt(zzeps<Context> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Executor> zzeps3) {
        return new zzdbk(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdbg(this.zzevi.get(), this.zzfqh.get(), this.zzevg.get());
    }
}

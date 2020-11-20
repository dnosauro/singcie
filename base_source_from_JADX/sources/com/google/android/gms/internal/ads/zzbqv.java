package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbqv implements zzepf<zzbqu> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbsl> zzfwr;
    private final zzeps<zzdmu> zzfws;
    private final zzeps<ScheduledExecutorService> zzfwt;

    private zzbqv(zzeps<zzbsl> zzeps, zzeps<zzdmu> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<Executor> zzeps4) {
        this.zzfwr = zzeps;
        this.zzfws = zzeps2;
        this.zzfwt = zzeps3;
        this.zzevg = zzeps4;
    }

    public static zzbqv zzb(zzeps<zzbsl> zzeps, zzeps<zzdmu> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<Executor> zzeps4) {
        return new zzbqv(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzbqu(this.zzfwr.get(), this.zzfws.get(), this.zzfwt.get(), this.zzevg.get());
    }
}

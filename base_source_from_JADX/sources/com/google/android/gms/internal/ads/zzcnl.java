package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzcnl implements zzepf<zzcnh> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<zzcpx> zzfcv;
    private final zzeps<zzcmd> zzfgy;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzdnn> zzfts;

    private zzcnl(zzeps<zzdnn> zzeps, zzeps<zzcmd> zzeps2, zzeps<zzdzc> zzeps3, zzeps<ScheduledExecutorService> zzeps4, zzeps<zzcpx> zzeps5) {
        this.zzfts = zzeps;
        this.zzfgy = zzeps2;
        this.zzevg = zzeps3;
        this.zzfqh = zzeps4;
        this.zzfcv = zzeps5;
    }

    public static zzcnl zzf(zzeps<zzdnn> zzeps, zzeps<zzcmd> zzeps2, zzeps<zzdzc> zzeps3, zzeps<ScheduledExecutorService> zzeps4, zzeps<zzcpx> zzeps5) {
        return new zzcnl(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzcnh(this.zzfts.get(), this.zzfgy.get(), this.zzevg.get(), this.zzfqh.get(), this.zzfcv.get());
    }
}

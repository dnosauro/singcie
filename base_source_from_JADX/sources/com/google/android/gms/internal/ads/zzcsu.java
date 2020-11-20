package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzcsu implements zzepf<zzcsq> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<zzbna> zzflh;
    private final zzeps<zzcrw> zzfll;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzbrx> zzgsa;

    public zzcsu(zzeps<zzbna> zzeps, zzeps<zzcrw> zzeps2, zzeps<zzbrx> zzeps3, zzeps<ScheduledExecutorService> zzeps4, zzeps<zzdzc> zzeps5) {
        this.zzflh = zzeps;
        this.zzfll = zzeps2;
        this.zzgsa = zzeps3;
        this.zzfqh = zzeps4;
        this.zzevg = zzeps5;
    }

    public final /* synthetic */ Object get() {
        return new zzcsq(this.zzflh.get(), this.zzfll.get(), this.zzgsa.get(), this.zzfqh.get(), this.zzevg.get());
    }
}

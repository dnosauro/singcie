package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzczl implements zzepf<zzcyx> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzef> zzfql;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<zzdod<zzcgh>> zzgsm;
    private final zzeps<zzbgm> zzgxs;

    public zzczl(zzeps<zzbgm> zzeps, zzeps<Context> zzeps2, zzeps<zzef> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzdod<zzcgh>> zzeps5, zzeps<zzdzc> zzeps6, zzeps<ScheduledExecutorService> zzeps7) {
        this.zzgxs = zzeps;
        this.zzevi = zzeps2;
        this.zzfql = zzeps3;
        this.zzfrq = zzeps4;
        this.zzgsm = zzeps5;
        this.zzevg = zzeps6;
        this.zzfqh = zzeps7;
    }

    public final /* synthetic */ Object get() {
        return new zzcyx(this.zzgxs.get(), this.zzevi.get(), this.zzfql.get(), this.zzfrq.get(), this.zzgsm.get(), this.zzevg.get(), this.zzfqh.get());
    }
}

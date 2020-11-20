package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcez implements zzepf<zzces> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzcej> zzfgj;
    private final zzeps<zzcff> zzfgm;
    private final zzeps<zzazh> zzfpc;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzef> zzgbn;
    private final zzeps<zzb> zzggu;
    private final zzeps<zzts> zzggv;

    public zzcez(zzeps<Context> zzeps, zzeps<zzcej> zzeps2, zzeps<zzef> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzb> zzeps5, zzeps<zzts> zzeps6, zzeps<Executor> zzeps7, zzeps<zzdnn> zzeps8, zzeps<zzcff> zzeps9, zzeps<ScheduledExecutorService> zzeps10) {
        this.zzevi = zzeps;
        this.zzfgj = zzeps2;
        this.zzgbn = zzeps3;
        this.zzfpc = zzeps4;
        this.zzggu = zzeps5;
        this.zzggv = zzeps6;
        this.zzevg = zzeps7;
        this.zzfts = zzeps8;
        this.zzfgm = zzeps9;
        this.zzfqh = zzeps10;
    }

    public final /* synthetic */ Object get() {
        return new zzces(this.zzevi.get(), this.zzfgj.get(), this.zzgbn.get(), this.zzfpc.get(), this.zzggu.get(), this.zzggv.get(), this.zzevg.get(), this.zzfts.get(), this.zzfgm.get(), this.zzfqh.get());
    }
}

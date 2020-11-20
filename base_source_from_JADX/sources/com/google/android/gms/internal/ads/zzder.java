package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzder implements zzepf<zzdek> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzcwz> zzevx;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<String> zzfrr;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzcwx> zzgtx;

    private zzder(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<String> zzeps3, zzeps<zzcwz> zzeps4, zzeps<Context> zzeps5, zzeps<zzdnn> zzeps6, zzeps<zzcwx> zzeps7) {
        this.zzevg = zzeps;
        this.zzfqh = zzeps2;
        this.zzfrr = zzeps3;
        this.zzevx = zzeps4;
        this.zzevi = zzeps5;
        this.zzfts = zzeps6;
        this.zzgtx = zzeps7;
    }

    public static zzder zzb(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<String> zzeps3, zzeps<zzcwz> zzeps4, zzeps<Context> zzeps5, zzeps<zzdnn> zzeps6, zzeps<zzcwx> zzeps7) {
        return new zzder(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7);
    }

    public final /* synthetic */ Object get() {
        return new zzdek(this.zzevg.get(), this.zzfqh.get(), this.zzfrr.get(), this.zzevx.get(), this.zzevi.get(), this.zzfts.get(), this.zzgtx.get());
    }
}

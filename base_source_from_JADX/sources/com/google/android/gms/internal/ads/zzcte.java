package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcte implements zzepf<zzcsv> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzchp> zzgfa;
    private final zzeps<zzbzx> zzgrb;

    public zzcte(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdnn> zzeps3, zzeps<Executor> zzeps4, zzeps<zzbzx> zzeps5, zzeps<zzchp> zzeps6) {
        this.zzevi = zzeps;
        this.zzfrq = zzeps2;
        this.zzfts = zzeps3;
        this.zzftl = zzeps4;
        this.zzgrb = zzeps5;
        this.zzgfa = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzcsv(this.zzevi.get(), this.zzfrq.get(), this.zzfts.get(), this.zzftl.get(), this.zzgrb.get(), this.zzgfa.get());
    }
}

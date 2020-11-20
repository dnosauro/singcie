package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcrn implements zzepf<zzcrk> {
    private final zzeps<Context> zzevi;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzazh> zzfxq;
    private final zzeps<zzchp> zzgfa;
    private final zzeps<zzblp> zzgrb;

    public zzcrn(zzeps<zzblp> zzeps, zzeps<Context> zzeps2, zzeps<Executor> zzeps3, zzeps<zzchp> zzeps4, zzeps<zzdnn> zzeps5, zzeps<zzazh> zzeps6) {
        this.zzgrb = zzeps;
        this.zzevi = zzeps2;
        this.zzftl = zzeps3;
        this.zzgfa = zzeps4;
        this.zzfts = zzeps5;
        this.zzfxq = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzcrk(this.zzgrb.get(), this.zzevi.get(), this.zzftl.get(), this.zzgfa.get(), this.zzfts.get(), this.zzfxq.get());
    }
}

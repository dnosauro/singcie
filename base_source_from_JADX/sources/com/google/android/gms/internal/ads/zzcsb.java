package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzag;
import java.util.concurrent.Executor;

public final class zzcsb implements zzepf<zzcrw> {
    private final zzeps<Context> zzevi;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzchp> zzgfa;
    private final zzeps<zzbna> zzgrb;
    private final zzeps<zzdvm<zzdmu, zzag>> zzgrl;

    public zzcsb(zzeps<zzbna> zzeps, zzeps<Context> zzeps2, zzeps<Executor> zzeps3, zzeps<zzchp> zzeps4, zzeps<zzdnn> zzeps5, zzeps<zzdvm<zzdmu, zzag>> zzeps6) {
        this.zzgrb = zzeps;
        this.zzevi = zzeps2;
        this.zzftl = zzeps3;
        this.zzgfa = zzeps4;
        this.zzfts = zzeps5;
        this.zzgrl = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzcrw(this.zzgrb.get(), this.zzevi.get(), this.zzftl.get(), this.zzgfa.get(), this.zzfts.get(), this.zzgrl.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcsn implements zzepf<zzcsm> {
    private final zzeps<Context> zzevi;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzbzx> zzgrb;
    private final zzeps<zzdms> zzgru;

    public zzcsn(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbzx> zzeps3, zzeps<zzdms> zzeps4) {
        this.zzevi = zzeps;
        this.zzftl = zzeps2;
        this.zzgrb = zzeps3;
        this.zzgru = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcsm(this.zzevi.get(), this.zzftl.get(), this.zzgrb.get(), this.zzgru.get());
    }
}

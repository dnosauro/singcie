package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcsg implements zzepf<zzcse> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzbna> zzgrb;

    public zzcsg(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzbna> zzeps3, zzeps<Executor> zzeps4) {
        this.zzevi = zzeps;
        this.zzfrq = zzeps2;
        this.zzgrb = zzeps3;
        this.zzftl = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcse(this.zzevi.get(), this.zzfrq.get(), this.zzgrb.get(), this.zzftl.get());
    }
}

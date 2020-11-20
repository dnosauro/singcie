package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcti implements zzepf<zzctg> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzbzx> zzgrb;

    public zzcti(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzbzx> zzeps3, zzeps<Executor> zzeps4) {
        this.zzevi = zzeps;
        this.zzfrq = zzeps2;
        this.zzgrb = zzeps3;
        this.zzftl = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzctg(this.zzevi.get(), this.zzfrq.get(), this.zzgrb.get(), this.zzftl.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcrt implements zzepf<zzcrp> {
    private final zzeps<Context> zzevi;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzchp> zzgfa;
    private final zzeps<zzblg> zzgrb;

    public zzcrt(zzeps<zzblg> zzeps, zzeps<Context> zzeps2, zzeps<Executor> zzeps3, zzeps<zzchp> zzeps4) {
        this.zzgrb = zzeps;
        this.zzevi = zzeps2;
        this.zzftl = zzeps3;
        this.zzgfa = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcrp(this.zzgrb.get(), this.zzevi.get(), this.zzftl.get(), this.zzgfa.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcuw implements zzepf<zzcuu> {
    private final zzeps<Context> zzevi;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzchf> zzgrb;

    public zzcuw(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzchf> zzeps3) {
        this.zzevi = zzeps;
        this.zzftl = zzeps2;
        this.zzgrb = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzcuu(this.zzevi.get(), this.zzftl.get(), this.zzgrb.get());
    }
}

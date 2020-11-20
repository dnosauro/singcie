package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzctv implements zzepf<zzctw> {
    private final zzeps<Context> zzevi;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzcat> zzgrb;

    public zzctv(zzeps<Context> zzeps, zzeps<zzcat> zzeps2, zzeps<Executor> zzeps3) {
        this.zzevi = zzeps;
        this.zzgrb = zzeps2;
        this.zzftl = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzctw(this.zzevi.get(), this.zzgrb.get(), this.zzftl.get());
    }
}

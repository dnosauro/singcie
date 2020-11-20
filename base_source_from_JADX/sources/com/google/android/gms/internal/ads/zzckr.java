package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzckr implements zzepf<zzckq> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzckv> zzewc;

    public zzckr(zzeps<zzckv> zzeps, zzeps<Executor> zzeps2) {
        this.zzewc = zzeps;
        this.zzevg = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzckq(this.zzewc.get(), this.zzevg.get());
    }
}

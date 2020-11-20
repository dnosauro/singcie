package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcla implements zzepf<zzckv> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzaze> zzewl;
    private final zzeps<zzazh> zzfpc;

    public zzcla(zzeps<Executor> zzeps, zzeps<zzaze> zzeps2, zzeps<Context> zzeps3, zzeps<zzazh> zzeps4) {
        this.zzevg = zzeps;
        this.zzewl = zzeps2;
        this.zzevi = zzeps3;
        this.zzfpc = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzckv(this.zzevg.get(), this.zzewl.get(), this.zzevi.get(), this.zzfpc.get());
    }
}

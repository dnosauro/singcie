package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdsb implements zzepf<zzdrz> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzaze> zzewb;

    public zzdsb(zzeps<Executor> zzeps, zzeps<zzaze> zzeps2) {
        this.zzevg = zzeps;
        this.zzewb = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzdrz(this.zzevg.get(), this.zzewb.get());
    }
}

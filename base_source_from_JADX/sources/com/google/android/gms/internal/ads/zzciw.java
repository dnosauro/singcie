package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzciw implements zzepf<zzcis> {
    private final zzeps<Executor> zzevg;

    public zzciw(zzeps<Executor> zzeps) {
        this.zzevg = zzeps;
    }

    public final /* synthetic */ Object get() {
        return new zzcis(this.zzevg.get());
    }
}

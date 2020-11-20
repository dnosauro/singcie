package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdev implements zzepf<zzdet> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzawx> zzfpf;

    private zzdev(zzeps<zzawx> zzeps, zzeps<zzdzc> zzeps2, zzeps<Context> zzeps3) {
        this.zzfpf = zzeps;
        this.zzevg = zzeps2;
        this.zzevi = zzeps3;
    }

    public static zzdev zzv(zzeps<zzawx> zzeps, zzeps<zzdzc> zzeps2, zzeps<Context> zzeps3) {
        return new zzdev(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdet(this.zzfpf.get(), this.zzevg.get(), this.zzevi.get());
    }
}

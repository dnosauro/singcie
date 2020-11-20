package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzctm implements zzepf<zzcth> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzbzx> zzgrb;

    public zzctm(zzeps<Context> zzeps, zzeps<zzbzx> zzeps2) {
        this.zzevi = zzeps;
        this.zzgrb = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzcth(this.zzevi.get(), this.zzgrb.get());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcdf implements zzepf<zzcdd> {
    private final zzeps<zzcgh> zzfaw;
    private final zzeps<Clock> zzfrf;

    public zzcdf(zzeps<zzcgh> zzeps, zzeps<Clock> zzeps2) {
        this.zzfaw = zzeps;
        this.zzfrf = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzcdd(this.zzfaw.get(), this.zzfrf.get());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzdcf implements zzepf<zzdbw<zzdfp>> {
    private final zzeps<zzdfo> zzewx;
    private final zzeps<Clock> zzfrf;

    public zzdcf(zzeps<zzdfo> zzeps, zzeps<Clock> zzeps2) {
        this.zzewx = zzeps;
        this.zzfrf = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzdbw) zzepl.zza(new zzdbw(this.zzewx.get(), zzact.zzdbo.get().longValue(), this.zzfrf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

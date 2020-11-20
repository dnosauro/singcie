package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzdcc implements zzepf<zzdbw<zzdbr>> {
    private final zzeps<Clock> zzfrf;
    private final zzeps<zzdbq> zzgzq;

    public zzdcc(zzeps<zzdbq> zzeps, zzeps<Clock> zzeps2) {
        this.zzgzq = zzeps;
        this.zzfrf = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzdbw) zzepl.zza(new zzdbw(this.zzgzq.get(), 10000, this.zzfrf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

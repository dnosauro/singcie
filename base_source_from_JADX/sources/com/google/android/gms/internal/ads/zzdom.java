package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public final class zzdom implements zzepf<Clock> {
    private final zzdoj zzhjz;

    public zzdom(zzdoj zzdoj) {
        this.zzhjz = zzdoj;
    }

    public final /* synthetic */ Object get() {
        return (Clock) zzepl.zza(DefaultClock.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

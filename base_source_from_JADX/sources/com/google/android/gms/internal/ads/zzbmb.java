package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbmb implements zzepf<zzbua> {
    private final zzeps<Clock> zzfrf;
    private final zzeps<ScheduledExecutorService> zzfsz;

    public zzbmb(zzeps<ScheduledExecutorService> zzeps, zzeps<Clock> zzeps2) {
        this.zzfsz = zzeps;
        this.zzfrf = zzeps2;
    }

    public static zzbua zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        return (zzbua) zzepl.zza(new zzbua(scheduledExecutorService, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfsz.get(), this.zzfrf.get());
    }
}

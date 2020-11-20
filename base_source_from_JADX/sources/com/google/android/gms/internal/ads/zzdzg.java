package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzdzg extends zzdzd implements zzdzc, ScheduledExecutorService {
    private final ScheduledExecutorService zzhxx;

    zzdzg(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.zzhxx = (ScheduledExecutorService) zzdvv.checkNotNull(scheduledExecutorService);
    }

    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzdzo zza = zzdzo.zza(runnable, null);
        return new zzdzf(zza, this.zzhxx.schedule(zza, j, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzdzo zzf = zzdzo.zzf(callable);
        return new zzdzf(zzf, this.zzhxx.schedule(zzf, j, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdzi zzdzi = new zzdzi(runnable);
        return new zzdzf(zzdzi, this.zzhxx.scheduleAtFixedRate(zzdzi, j, j2, timeUnit));
    }

    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdzi zzdzi = new zzdzi(runnable);
        return new zzdzf(zzdzi, this.zzhxx.scheduleWithFixedDelay(zzdzi, j, j2, timeUnit));
    }
}

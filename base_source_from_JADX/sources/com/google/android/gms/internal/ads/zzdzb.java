package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdzb {
    public static zzdzc zza(ExecutorService executorService) {
        return executorService instanceof zzdzc ? (zzdzc) executorService : executorService instanceof ScheduledExecutorService ? new zzdzg((ScheduledExecutorService) executorService) : new zzdzd(executorService);
    }

    static Executor zza(Executor executor, zzdxo<?> zzdxo) {
        zzdvv.checkNotNull(executor);
        zzdvv.checkNotNull(zzdxo);
        return executor == zzdyg.INSTANCE ? executor : new zzdze(executor, zzdxo);
    }

    public static Executor zzazo() {
        return zzdyg.INSTANCE;
    }
}

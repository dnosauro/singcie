package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class zzdzd extends zzdxr {
    private final ExecutorService zzhxt;

    zzdzd(ExecutorService executorService) {
        this.zzhxt = (ExecutorService) zzdvv.checkNotNull(executorService);
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.zzhxt.awaitTermination(j, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.zzhxt.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.zzhxt.isShutdown();
    }

    public final boolean isTerminated() {
        return this.zzhxt.isTerminated();
    }

    public final void shutdown() {
        this.zzhxt.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.zzhxt.shutdownNow();
    }
}

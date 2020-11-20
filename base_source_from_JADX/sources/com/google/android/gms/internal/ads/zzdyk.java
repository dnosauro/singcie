package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

final class zzdyk<V> extends zzdyi<V> {
    private final zzdyz<V> zzhxl;

    zzdyk(zzdyz<V> zzdyz) {
        this.zzhxl = (zzdyz) zzdvv.checkNotNull(zzdyz);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhxl.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzhxl.cancel(z);
    }

    public final V get() {
        return this.zzhxl.get();
    }

    public final V get(long j, TimeUnit timeUnit) {
        return this.zzhxl.get(j, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zzhxl.isCancelled();
    }

    public final boolean isDone() {
        return this.zzhxl.isDone();
    }

    public final String toString() {
        return this.zzhxl.toString();
    }
}

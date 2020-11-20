package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzdzf<V> extends zzdyp<V> implements zzdyz<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zzhxw;

    public zzdzf(zzdyz<V> zzdyz, ScheduledFuture<?> scheduledFuture) {
        super(zzdyz);
        this.zzhxw = scheduledFuture;
    }

    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zzhxw.cancel(z);
        }
        return cancel;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzhxw.compareTo((Delayed) obj);
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zzhxw.getDelay(timeUnit);
    }
}

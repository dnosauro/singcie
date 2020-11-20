package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzp;
import javax.annotation.concurrent.GuardedBy;

public final class zzbs {
    private final Object lock = new Object();
    private long zzefh;
    @GuardedBy("lock")
    private long zzefi = Long.MIN_VALUE;

    public zzbs(long j) {
        this.zzefh = j;
    }

    public final boolean tryAcquire() {
        synchronized (this.lock) {
            long elapsedRealtime = zzp.zzkx().elapsedRealtime();
            if (this.zzefi + this.zzefh > elapsedRealtime) {
                return false;
            }
            this.zzefi = elapsedRealtime;
            return true;
        }
    }

    public final void zzfb(long j) {
        synchronized (this.lock) {
            this.zzefh = j;
        }
    }
}

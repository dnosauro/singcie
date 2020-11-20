package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class zzbkv implements zzrl {
    private final Clock zzbpw;
    @GuardedBy("this")
    private Runnable zzebx = null;
    private final ScheduledExecutorService zzfru;
    @GuardedBy("this")
    private ScheduledFuture<?> zzfrv;
    @GuardedBy("this")
    private long zzfrw = -1;
    @GuardedBy("this")
    private long zzfrx = -1;
    @GuardedBy("this")
    private boolean zzfry = false;

    public zzbkv(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zzfru = scheduledExecutorService;
        this.zzbpw = clock;
        zzp.zzkt().zza(this);
    }

    @VisibleForTesting
    private final synchronized void zzaik() {
        if (!this.zzfry) {
            if (this.zzfrv == null || this.zzfrv.isDone()) {
                this.zzfrx = -1;
            } else {
                this.zzfrv.cancel(true);
                this.zzfrx = this.zzfrw - this.zzbpw.elapsedRealtime();
            }
            this.zzfry = true;
        }
    }

    @VisibleForTesting
    private final synchronized void zzail() {
        if (this.zzfry) {
            if (this.zzfrx > 0 && this.zzfrv != null && this.zzfrv.isCancelled()) {
                this.zzfrv = this.zzfru.schedule(this.zzebx, this.zzfrx, TimeUnit.MILLISECONDS);
            }
            this.zzfry = false;
        }
    }

    public final synchronized void zza(int i, Runnable runnable) {
        this.zzebx = runnable;
        long j = (long) i;
        this.zzfrw = this.zzbpw.elapsedRealtime() + j;
        this.zzfrv = this.zzfru.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public final void zzp(boolean z) {
        if (z) {
            zzail();
        } else {
            zzaik();
        }
    }
}

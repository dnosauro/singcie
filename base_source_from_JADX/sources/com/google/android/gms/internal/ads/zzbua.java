package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class zzbua extends zzbwk<zzbue> {
    private final Clock zzbpw;
    @GuardedBy("this")
    private boolean zzfrg = false;
    private final ScheduledExecutorService zzfru;
    @GuardedBy("this")
    private long zzfrw = -1;
    @GuardedBy("this")
    private long zzfrx = -1;
    @GuardedBy("this")
    private ScheduledFuture<?> zzfyc;

    public zzbua(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfru = scheduledExecutorService;
        this.zzbpw = clock;
    }

    /* access modifiers changed from: private */
    public final void zzalc() {
        zza(zzbud.zzfxs);
    }

    private final synchronized void zzfd(long j) {
        if (this.zzfyc != null && !this.zzfyc.isDone()) {
            this.zzfyc.cancel(true);
        }
        this.zzfrw = this.zzbpw.elapsedRealtime() + j;
        this.zzfyc = this.zzfru.schedule(new zzbuf(this), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void onPause() {
        if (!this.zzfrg) {
            if (this.zzfyc == null || this.zzfyc.isCancelled()) {
                this.zzfrx = -1;
            } else {
                this.zzfyc.cancel(true);
                this.zzfrx = this.zzfrw - this.zzbpw.elapsedRealtime();
            }
            this.zzfrg = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfrg) {
            if (this.zzfrx > 0 && this.zzfyc.isCancelled()) {
                zzfd(this.zzfrx);
            }
            this.zzfrg = false;
        }
    }

    public final synchronized void zzalb() {
        this.zzfrg = false;
        zzfd(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdx(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0043 }
            long r1 = (long) r7     // Catch:{ all -> 0x0043 }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x0043 }
            boolean r7 = r6.zzfrg     // Catch:{ all -> 0x0043 }
            if (r7 == 0) goto L_0x0025
            long r2 = r6.zzfrx     // Catch:{ all -> 0x0043 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001f
            long r2 = r6.zzfrx     // Catch:{ all -> 0x0043 }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            long r0 = r6.zzfrx     // Catch:{ all -> 0x0043 }
        L_0x0021:
            r6.zzfrx = r0     // Catch:{ all -> 0x0043 }
            monitor-exit(r6)
            return
        L_0x0025:
            com.google.android.gms.common.util.Clock r7 = r6.zzbpw     // Catch:{ all -> 0x0043 }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r4 = r6.zzfrw     // Catch:{ all -> 0x0043 }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x003e
            long r2 = r6.zzfrw     // Catch:{ all -> 0x0043 }
            com.google.android.gms.common.util.Clock r7 = r6.zzbpw     // Catch:{ all -> 0x0043 }
            long r4 = r7.elapsedRealtime()     // Catch:{ all -> 0x0043 }
            long r2 = r2 - r4
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0041
        L_0x003e:
            r6.zzfd(r0)     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r6)
            return
        L_0x0043:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbua.zzdx(int):void");
    }
}

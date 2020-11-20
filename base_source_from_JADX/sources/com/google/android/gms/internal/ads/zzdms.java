package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import javax.annotation.concurrent.GuardedBy;

public final class zzdms {
    private final Object lock = new Object();
    private final Clock zzbpw;
    private volatile long zzebm = 0;
    @GuardedBy("lock")
    private volatile int zzhgn = zzdmv.zzhhs;

    public zzdms(Clock clock) {
        this.zzbpw = clock;
    }

    private final void zzauh() {
        long currentTimeMillis = this.zzbpw.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhgn == zzdmv.zzhhu) {
                if (this.zzebm + ((Long) zzwq.zzqe().zzd(zzabf.zzcwh)).longValue() <= currentTimeMillis) {
                    this.zzhgn = zzdmv.zzhhs;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzr(int r5, int r6) {
        /*
            r4 = this;
            r4.zzauh()
            com.google.android.gms.common.util.Clock r0 = r4.zzbpw
            long r0 = r0.currentTimeMillis()
            java.lang.Object r2 = r4.lock
            monitor-enter(r2)
            int r3 = r4.zzhgn     // Catch:{ all -> 0x001e }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x0012:
            r4.zzhgn = r6     // Catch:{ all -> 0x001e }
            int r5 = r4.zzhgn     // Catch:{ all -> 0x001e }
            int r6 = com.google.android.gms.internal.ads.zzdmv.zzhhu     // Catch:{ all -> 0x001e }
            if (r5 != r6) goto L_0x001c
            r4.zzebm = r0     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdms.zzr(int, int):void");
    }

    public final boolean zzaui() {
        boolean z;
        synchronized (this.lock) {
            zzauh();
            z = this.zzhgn == zzdmv.zzhht;
        }
        return z;
    }

    public final boolean zzauj() {
        boolean z;
        synchronized (this.lock) {
            zzauh();
            z = this.zzhgn == zzdmv.zzhhu;
        }
        return z;
    }

    public final void zzbm(boolean z) {
        int i;
        int i2;
        if (z) {
            i = zzdmv.zzhhs;
            i2 = zzdmv.zzhht;
        } else {
            i = zzdmv.zzhht;
            i2 = zzdmv.zzhhs;
        }
        zzr(i, i2);
    }

    public final void zzwv() {
        zzr(zzdmv.zzhht, zzdmv.zzhhu);
    }
}

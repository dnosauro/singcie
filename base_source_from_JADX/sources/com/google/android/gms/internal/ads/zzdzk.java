package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdzk<V> extends zzdyl<V> {
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdyz<V> zzhxz;
    /* access modifiers changed from: private */
    @NullableDecl
    public ScheduledFuture<?> zzhya;

    private zzdzk(zzdyz<V> zzdyz) {
        this.zzhxz = (zzdyz) zzdvv.checkNotNull(zzdyz);
    }

    static <V> zzdyz<V> zzb(zzdyz<V> zzdyz, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdzk zzdzk = new zzdzk(zzdyz);
        zzdzm zzdzm = new zzdzm(zzdzk);
        zzdzk.zzhya = scheduledExecutorService.schedule(zzdzm, j, timeUnit);
        zzdyz.addListener(zzdzm, zzdyg.INSTANCE);
        return zzdzk;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhxz);
        ScheduledFuture<?> scheduledFuture = this.zzhya;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzhxz = null;
        this.zzhya = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdyz<V> zzdyz = this.zzhxz;
        ScheduledFuture<?> scheduledFuture = this.zzhya;
        if (zzdyz == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdyz);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }
}

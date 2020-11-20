package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzboj {
    private final Executor executor;
    private volatile boolean zzafb = true;
    private final ScheduledExecutorService zzfpq;
    private final zzdyz<zzboi> zzfuz;

    public zzboj(Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdyz<zzboi> zzdyz) {
        this.executor = executor2;
        this.zzfpq = scheduledExecutorService;
        this.zzfuz = zzdyz;
    }

    /* access modifiers changed from: private */
    public final void zza(List<? extends zzdyz<? extends zzboc>> list, zzdyo<zzboc> zzdyo) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new zzbom(zzdyo));
            return;
        }
        zzdyz<O> zzag = zzdyr.zzag(null);
        for (zzdyz zzboo : list) {
            zzag = zzdyr.zzb(zzdyr.zzb(zzag, Throwable.class, new zzbol(zzdyo), this.executor), new zzboo(this, zzdyo, zzboo), this.executor);
        }
        zzdyr.zza(zzag, new zzbop(this, zzdyo), this.executor);
    }

    /* access modifiers changed from: private */
    public final void zzakc() {
        zzazj.zzegt.execute(new zzbon(this));
    }

    public final boolean isLoading() {
        return this.zzafb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdyo zzdyo, zzdyz zzdyz, zzboc zzboc) {
        if (zzboc != null) {
            zzdyo.onSuccess(zzboc);
        }
        return zzdyr.zza(zzdyz, zzadk.zzddr.get().longValue(), TimeUnit.MILLISECONDS, this.zzfpq);
    }

    public final void zza(zzdyo<zzboc> zzdyo) {
        zzdyr.zza(this.zzfuz, new zzboq(this, zzdyo), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzakd() {
        this.zzafb = false;
    }
}

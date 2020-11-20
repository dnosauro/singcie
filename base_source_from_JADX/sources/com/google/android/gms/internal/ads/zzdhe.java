package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdhe implements zzdfi<zzdhf> {
    private ApplicationInfo applicationInfo;
    private boolean zzdvy;
    private ScheduledExecutorService zzfpq;
    private zzamy zzgzs;

    public zzdhe(zzamy zzamy, ScheduledExecutorService scheduledExecutorService, boolean z, ApplicationInfo applicationInfo2) {
        this.zzgzs = zzamy;
        this.zzfpq = scheduledExecutorService;
        this.zzdvy = z;
        this.applicationInfo = applicationInfo2;
    }

    public final zzdyz<zzdhf> zzasm() {
        if (!zzacq.zzdbe.get().booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Auto Collect Location by gms is disabled."));
        }
        if (!this.zzdvy) {
            return zzdyr.immediateFailedFuture(new Exception("Auto Collect Location is false."));
        }
        return zzdyr.zzb(zzdyr.zza(this.zzgzs.zza(this.applicationInfo), ((Long) zzwq.zzqe().zzd(zzabf.zzcsn)).longValue(), TimeUnit.MILLISECONDS, this.zzfpq), zzdhh.zzdza, (Executor) zzazj.zzegp);
    }
}

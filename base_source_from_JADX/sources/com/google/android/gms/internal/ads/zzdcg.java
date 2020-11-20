package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdcg implements zzdfi<zzdch> {
    private ApplicationInfo applicationInfo;
    private zzf zzebt;
    private ScheduledExecutorService zzfpq;
    zzdnn zzfvl;
    private zzamy zzgzs;

    public zzdcg(zzamy zzamy, ScheduledExecutorService scheduledExecutorService, zzf zzf, ApplicationInfo applicationInfo2, zzdnn zzdnn) {
        this.zzgzs = zzamy;
        this.zzfpq = scheduledExecutorService;
        this.zzebt = zzf;
        this.applicationInfo = applicationInfo2;
        this.zzfvl = zzdnn;
    }

    public final zzdyz<zzdch> zzasm() {
        zzdyz<V> zzdyz;
        if (zzacq.zzdbd.get().booleanValue() && this.zzebt.zzxt()) {
            zzdyz = zzdyr.zzb(zzdyr.zza(this.zzgzs.zza(this.applicationInfo), ((Long) zzwq.zzqe().zzd(zzabf.zzcsn)).longValue(), TimeUnit.MILLISECONDS, this.zzfpq), Throwable.class, zzdcl.zzbon, zzazj.zzegu);
        } else {
            zzdyz = zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyr.zzb(zzdyz, new zzdci(this), (Executor) this.zzfpq), zzdcj.zzdza, (Executor) zzazj.zzegp);
    }
}

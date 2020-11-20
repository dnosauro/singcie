package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdhi implements zzdfi<zzdhj> {
    private Context context;
    private ScheduledExecutorService zzfpq;
    private zzarr zzhcu;

    public zzdhi(zzarr zzarr, ScheduledExecutorService scheduledExecutorService, Context context2) {
        this.zzhcu = zzarr;
        this.zzfpq = scheduledExecutorService;
        this.context = context2;
    }

    public final zzdyz<zzdhj> zzasm() {
        return zzdyr.zzb(zzdyr.zza(this.zzhcu.zzo(this.context), ((Long) zzwq.zzqe().zzd(zzabf.zzcsv)).longValue(), TimeUnit.MILLISECONDS, this.zzfpq), zzdhl.zzdza, (Executor) zzazj.zzegp);
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdbg implements zzdfi<zzdbh> {
    private final Context context;
    private final Executor executor;
    private final ScheduledExecutorService zzfpq;

    public zzdbg(Context context2, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.context = context2;
        this.zzfpq = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzdyz<zzdbh> zzasm() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue()) {
            return zzdyr.zzag(null);
        }
        zzazq zzazq = new zzazq();
        try {
            new zzdbj(zzazq).zzbl(false);
        } catch (Throwable unused) {
            zzd.zzey("ArCoreApk is not ready.");
            zzazq.set(false);
        }
        return zzdyr.zzb(zzdyr.zzb(zzdyr.zza(zzazq, 200, TimeUnit.MILLISECONDS, this.zzfpq), new zzdbi(this), this.executor), Throwable.class, zzdbl.zzbon, this.executor);
    }
}

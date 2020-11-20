package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdfw implements zzdfi<zzdfx> {
    private final Context context;
    private final Executor executor;
    private final ScheduledExecutorService zzfpq;
    private final zzayc zzhbw;

    public zzdfw(zzayc zzayc, Context context2, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzhbw = zzayc;
        this.context = context2;
        this.zzfpq = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzdyz<zzdfx> zzasm() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcoq)).booleanValue()) {
            return zzdyr.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
        }
        return zzdyi.zzg(this.zzhbw.zzai(this.context)).zza(zzdfz.zzdza, this.executor).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzfpq).zza(Throwable.class, new zzdfy(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfx zzf(Throwable th) {
        zzwq.zzqa();
        return new zzdfx((AdvertisingIdClient.Info) null, zzayr.zzbo(this.context));
    }
}

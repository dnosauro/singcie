package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzdgk implements zzdfi<zzdgl> {
    private final Context context;
    private final Executor executor;
    private final zzayg zzbpt;
    private final ScheduledExecutorService zzfpq;
    private final int zzgon;
    private final zzayc zzhbw;

    public zzdgk(zzayc zzayc, int i, Context context2, zzayg zzayg, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzhbw = zzayc;
        this.zzgon = i;
        this.context = context2;
        this.zzbpt = zzayg;
        this.zzfpq = scheduledExecutorService;
        this.executor = executor2;
    }

    public final zzdyz<zzdgl> zzasm() {
        return zzdyi.zzg(zzdyr.zza(new zzdgn(this), this.executor)).zza(zzdgm.zzdza, this.executor).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzfpq).zza(Exception.class, new zzdgp(this), zzdzb.zzazo());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzati() {
        return this.zzhbw.zza(this.context, this.zzgon);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdgl zzb(Exception exc) {
        this.zzbpt.zza(exc, "AttestationTokenSignal");
        return null;
    }
}

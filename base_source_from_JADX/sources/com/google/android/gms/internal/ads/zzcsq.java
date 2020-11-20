package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcsq implements zzcqz<zzbme> {
    private final ScheduledExecutorService zzfpq;
    /* access modifiers changed from: private */
    public final zzbrx zzfzd;
    private final zzdzc zzggb;
    /* access modifiers changed from: private */
    public final zzbna zzgrw;
    private final zzcrw zzgrx;

    public zzcsq(zzbna zzbna, zzcrw zzcrw, zzbrx zzbrx, ScheduledExecutorService scheduledExecutorService, zzdzc zzdzc) {
        this.zzgrw = zzbna;
        this.zzgrx = zzcrw;
        this.zzfzd = zzbrx;
        this.zzfpq = scheduledExecutorService;
        this.zzggb = zzdzc;
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdnj.zzhij.zzfvl.zzaun() != null && this.zzgrx.zza(zzdnj, zzdmu);
    }

    public final zzdyz<zzbme> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return this.zzggb.zze(new zzcsp(this, zzdnj, zzdmu));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbme zzc(zzdnj zzdnj, zzdmu zzdmu) {
        return this.zzgrw.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbno(zzdnj.zzhij.zzfvl.zzaun(), new zzcss(this, zzdnj, zzdmu))).zzaha();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdnj zzdnj, zzdmu zzdmu) {
        zzdyr.zza(zzdyr.zza(this.zzgrx.zzb(zzdnj, zzdmu), (long) zzdmu.zzhhh, TimeUnit.SECONDS, this.zzfpq), new zzcsr(this), this.zzggb);
    }
}

package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzh;

public final class zzkl extends zzkm {
    private final AlarmManager zzb = ((AlarmManager) zzm().getSystemService("alarm"));
    private final zzaj zzc;
    private Integer zzd;

    protected zzkl(zzkp zzkp) {
        super(zzkp);
        this.zzc = new zzkk(this, zzkp.zzu(), zzkp);
    }

    @TargetApi(24)
    private final void zzu() {
        ((JobScheduler) zzm().getSystemService("jobscheduler")).cancel(zzv());
    }

    private final int zzv() {
        if (this.zzd == null) {
            String valueOf = String.valueOf(zzm().getPackageName());
            this.zzd = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.zzd.intValue();
    }

    private final PendingIntent zzw() {
        Context zzm = zzm();
        return PendingIntent.getBroadcast(zzm, 0, new Intent().setClassName(zzm, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzkt mo18590f_() {
        return super.mo18590f_();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(long j) {
        zzaj();
        Context zzm = zzm();
        if (!zzft.zza(zzm)) {
            zzq().zzv().zza("Receiver not registered/enabled");
        }
        if (!zzkx.zza(zzm, false)) {
            zzq().zzv().zza("Service not registered/enabled");
        }
        zze();
        zzq().zzw().zza("Scheduling upload, millis", Long.valueOf(j));
        long elapsedRealtime = zzl().elapsedRealtime() + j;
        if (j < Math.max(0, zzat.zzw.zza(null).longValue()) && !this.zzc.zzb()) {
            this.zzc.zza(j);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Context zzm2 = zzm();
            ComponentName componentName = new ComponentName(zzm2, "com.google.android.gms.measurement.AppMeasurementJobService");
            int zzv = zzv();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            zzh.zza(zzm2, new JobInfo.Builder(zzv, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
            return;
        }
        this.zzb.setInexactRepeating(2, elapsedRealtime, Math.max(zzat.zzr.zza(null).longValue(), j), zzw());
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        this.zzb.cancel(zzw());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        zzu();
        return false;
    }

    public final void zze() {
        zzaj();
        zzq().zzw().zza("Unscheduling upload");
        this.zzb.cancel(zzw());
        this.zzc.zzc();
        if (Build.VERSION.SDK_INT >= 24) {
            zzu();
        }
    }

    public final /* bridge */ /* synthetic */ zzjv zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzo zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfv zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }
}

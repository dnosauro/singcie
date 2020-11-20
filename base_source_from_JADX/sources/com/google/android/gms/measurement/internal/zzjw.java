package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class zzjw implements Runnable {
    private final zzju zza;
    private final zzex zzb;
    private final JobParameters zzc;

    zzjw(zzju zzju, zzex zzex, JobParameters jobParameters) {
        this.zza = zzju;
        this.zzb = zzex;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}

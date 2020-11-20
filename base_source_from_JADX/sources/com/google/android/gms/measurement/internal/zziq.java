package com.google.android.gms.measurement.internal;

final class zziq implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzim zzb;

    zziq(zzim zzim, long j) {
        this.zzb = zzim;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzd().zza(this.zza);
        this.zzb.zza = null;
    }
}

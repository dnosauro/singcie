package com.google.android.gms.measurement.internal;

final class zzgd implements Runnable {
    private final /* synthetic */ zzhf zza;
    private final /* synthetic */ zzgb zzb;

    zzgd(zzgb zzgb, zzhf zzhf) {
        this.zzb = zzgb;
        this.zza = zzhf;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}

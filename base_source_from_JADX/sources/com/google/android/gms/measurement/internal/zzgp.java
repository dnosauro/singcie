package com.google.android.gms.measurement.internal;

final class zzgp implements Runnable {
    private final /* synthetic */ zzar zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzgc zzc;

    zzgp(zzgc zzgc, zzar zzar, zzn zzn) {
        this.zzc = zzgc;
        this.zza = zzar;
        this.zzb = zzn;
    }

    public final void run() {
        zzar zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzr();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}

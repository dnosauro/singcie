package com.google.android.gms.measurement.internal;

final class zzgg implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzgc zzb;

    zzgg(zzgc zzgc, zzw zzw) {
        this.zzb = zzgc;
        this.zza = zzw;
    }

    public final void run() {
        this.zzb.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}

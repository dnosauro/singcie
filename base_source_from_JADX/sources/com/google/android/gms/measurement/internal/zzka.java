package com.google.android.gms.measurement.internal;

final class zzka implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzkb zzb;

    zzka(zzkb zzkb, long j) {
        this.zzb = zzkb;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}

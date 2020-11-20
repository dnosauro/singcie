package com.google.android.gms.measurement.internal;

final class zzgo implements Runnable {
    private final /* synthetic */ zzar zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgc zzc;

    zzgo(zzgc zzgc, zzar zzar, String str) {
        this.zzc = zzgc;
        this.zza = zzar;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzr();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}

package com.google.android.gms.measurement.internal;

final class zzib implements Runnable {
    private final /* synthetic */ zzad zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ int zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzhe zzf;

    zzib(zzhe zzhe, zzad zzad, long j, int i, long j2, boolean z) {
        this.zzf = zzhe;
        this.zza = zzad;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zza(this.zza);
        this.zzf.zza(this.zzb, false);
        this.zzf.zza(this.zza, this.zzc, this.zzd, true, this.zze);
    }
}

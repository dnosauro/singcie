package com.google.android.gms.measurement.internal;

final class zzia implements Runnable {
    private final /* synthetic */ zzad zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzhe zze;

    zzia(zzhe zzhe, zzad zzad, int i, long j, boolean z) {
        this.zze = zzhe;
        this.zza = zzad;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza(this.zza);
        this.zze.zza(this.zza, this.zzb, this.zzc, false, this.zzd);
    }
}

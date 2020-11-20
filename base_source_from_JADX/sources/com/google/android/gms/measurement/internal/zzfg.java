package com.google.android.gms.measurement.internal;

final class zzfg implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfh zzb;

    zzfg(zzfh zzfh, boolean z) {
        this.zzb = zzfh;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}

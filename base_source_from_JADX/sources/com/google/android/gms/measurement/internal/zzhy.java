package com.google.android.gms.measurement.internal;

final class zzhy implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zzhe zzb;

    zzhy(zzhe zzhe, Boolean bool) {
        this.zzb = zzhe;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}

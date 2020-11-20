package com.google.android.gms.measurement.internal;

final class zzko implements Runnable {
    private final /* synthetic */ zzku zza;
    private final /* synthetic */ zzkp zzb;

    zzko(zzkp zzkp, zzku zzku) {
        this.zzb = zzkp;
        this.zza = zzku;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}

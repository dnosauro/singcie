package com.google.android.gms.measurement.internal;

final class zzjz implements Runnable {
    private final /* synthetic */ zzkp zza;
    private final /* synthetic */ Runnable zzb;

    zzjz(zzju zzju, zzkp zzkp, Runnable runnable) {
        this.zza = zzkp;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzr();
        this.zza.zza(this.zzb);
        this.zza.zzo();
    }
}

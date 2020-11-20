package com.google.android.gms.measurement.internal;

final class zzjq implements Runnable {
    private final /* synthetic */ zzep zza;
    private final /* synthetic */ zzjp zzb;

    zzjq(zzjp zzjp, zzep zzep) {
        this.zzb = zzjp;
        this.zza = zzep;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzaa()) {
                this.zzb.zza.zzq().zzv().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}

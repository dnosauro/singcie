package com.google.android.gms.measurement.internal;

final class zzai implements Runnable {
    private final /* synthetic */ zzgw zza;
    private final /* synthetic */ zzaj zzb;

    zzai(zzaj zzaj, zzgw zzgw) {
        this.zzb = zzaj;
        this.zza = zzgw;
    }

    public final void run() {
        this.zza.zzt();
        if (zzx.zza()) {
            this.zza.zzp().zza((Runnable) this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        long unused = this.zzb.zzd = 0;
        if (zzb2) {
            this.zzb.zza();
        }
    }
}

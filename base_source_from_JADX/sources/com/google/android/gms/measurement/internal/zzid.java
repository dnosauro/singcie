package com.google.android.gms.measurement.internal;

final class zzid implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhe zzb;

    zzid(zzhe zzhe, boolean z) {
        this.zzb = zzhe;
        this.zza = z;
    }

    public final void run() {
        boolean zzaa = this.zzb.zzy.zzaa();
        boolean zzz = this.zzb.zzy.zzz();
        this.zzb.zzy.zza(this.zza);
        if (zzz == this.zza) {
            this.zzb.zzy.zzq().zzw().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzy.zzaa() == zzaa || this.zzb.zzy.zzaa() != this.zzb.zzy.zzz()) {
            this.zzb.zzy.zzq().zzj().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzaa));
        }
        this.zzb.zzal();
    }
}

package com.google.android.gms.measurement.internal;

final class zzkk extends zzaj {
    private final /* synthetic */ zzkp zza;
    private final /* synthetic */ zzkl zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzkk(zzkl zzkl, zzgw zzgw, zzkp zzkp) {
        super(zzgw);
        this.zzb = zzkl;
        this.zza = zzkp;
    }

    public final void zza() {
        this.zzb.zze();
        this.zzb.zzq().zzw().zza("Starting upload from DelayedRunnable");
        this.zza.zzo();
    }
}

package com.google.android.gms.internal.measurement;

final class zzgu {
    private final zzhf zza;
    private final byte[] zzb;

    private zzgu(int i) {
        this.zzb = new byte[i];
        this.zza = zzhf.zza(this.zzb);
    }

    /* synthetic */ zzgu(int i, zzgp zzgp) {
        this(i);
    }

    public final zzgm zza() {
        this.zza.zzb();
        return new zzgw(this.zzb);
    }

    public final zzhf zzb() {
        return this.zza;
    }
}

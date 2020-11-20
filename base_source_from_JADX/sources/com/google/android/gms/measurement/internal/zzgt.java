package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzgt implements Callable<List<zzky>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzgc zzb;

    zzgt(zzgc zzgc, zzn zzn) {
        this.zzb = zzgc;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() {
        this.zzb.zza.zzr();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}

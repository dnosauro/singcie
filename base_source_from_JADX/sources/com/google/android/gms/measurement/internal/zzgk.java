package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzgk implements Callable<List<zzw>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzgc zzd;

    zzgk(zzgc zzgc, String str, String str2, String str3) {
        this.zzd = zzgc;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final /* synthetic */ Object call() {
        this.zzd.zza.zzr();
        return this.zzd.zza.zze().zzb(this.zza, this.zzb, this.zzc);
    }
}

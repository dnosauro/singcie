package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

final class zzbjy implements zzdyo<String> {
    private final /* synthetic */ zzbjv zzfqc;

    zzbjy(zzbjv zzbjv) {
        this.zzfqc = zzbjv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdnv zze = this.zzfqc.zzfpu;
        List<String> zza = this.zzfqc.zzfpt.zza(this.zzfqc.zzfpr, this.zzfqc.zzfps, false, "", (String) obj, this.zzfqc.zzfps.zzdls);
        zzp.zzkq();
        zze.zza(zza, zzm.zzbc(this.zzfqc.context) ? zzcql.zzgqc : zzcql.zzgqb);
    }

    public final void zzb(Throwable th) {
        zzdnv zze = this.zzfqc.zzfpu;
        List<String> zza = this.zzfqc.zzfpt.zza(this.zzfqc.zzfpr, this.zzfqc.zzfps, false, "", "failure_click_attok", this.zzfqc.zzfps.zzdls);
        zzp.zzkq();
        zze.zza(zza, zzm.zzbc(this.zzfqc.context) ? zzcql.zzgqc : zzcql.zzgqb);
    }
}

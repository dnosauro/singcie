package com.google.android.gms.internal.ads;

final class zzbjx implements zzdyo<String> {
    private final /* synthetic */ String zzfqb;
    private final /* synthetic */ zzbjv zzfqc;

    zzbjx(zzbjv zzbjv, String str) {
        this.zzfqc = zzbjv;
        this.zzfqb = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfqc.zzfpu.zzi(this.zzfqc.zzfpt.zza(this.zzfqc.zzfpr, this.zzfqc.zzfps, false, this.zzfqb, (String) obj, this.zzfqc.zzfps.zzdlt));
    }

    public final void zzb(Throwable th) {
        this.zzfqc.zzfpu.zzi(this.zzfqc.zzfpt.zza(this.zzfqc.zzfpr, this.zzfqc.zzfps, false, this.zzfqb, (String) null, this.zzfqc.zzfps.zzdlt));
    }
}

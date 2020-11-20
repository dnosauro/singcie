package com.google.android.gms.internal.ads;

final /* synthetic */ class zzclw implements Runnable {
    private final Object zzdko;
    private final String zzgji;
    private final zzclp zzglj;
    private final zzazq zzglm;
    private final long zzgln;

    zzclw(zzclp zzclp, Object obj, zzazq zzazq, String str, long j) {
        this.zzglj = zzclp;
        this.zzdko = obj;
        this.zzglm = zzazq;
        this.zzgji = str;
        this.zzgln = j;
    }

    public final void run() {
        this.zzglj.zza(this.zzdko, this.zzglm, this.zzgji, this.zzgln);
    }
}

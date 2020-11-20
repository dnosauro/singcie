package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcvp implements Runnable {
    private final zzdmu zzfto;
    private final zzdnj zzgfz;
    private final zzcvq zzgto;
    private final zzcrb zzgtp;

    zzcvp(zzcvq zzcvq, zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        this.zzgto = zzcvq;
        this.zzgfz = zzdnj;
        this.zzfto = zzdmu;
        this.zzgtp = zzcrb;
    }

    public final void run() {
        zzcvq zzcvq = this.zzgto;
        zzcvo.zzc(this.zzgfz, this.zzfto, this.zzgtp);
    }
}

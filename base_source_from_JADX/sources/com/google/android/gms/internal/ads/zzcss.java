package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcss implements Runnable {
    private final zzdmu zzfto;
    private final zzdnj zzgfz;
    private final zzcsq zzgrv;

    zzcss(zzcsq zzcsq, zzdnj zzdnj, zzdmu zzdmu) {
        this.zzgrv = zzcsq;
        this.zzgfz = zzdnj;
        this.zzfto = zzdmu;
    }

    public final void run() {
        this.zzgrv.zzd(this.zzgfz, this.zzfto);
    }
}

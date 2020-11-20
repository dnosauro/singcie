package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcsp implements Callable {
    private final zzdmu zzfto;
    private final zzdnj zzgfz;
    private final zzcsq zzgrv;

    zzcsp(zzcsq zzcsq, zzdnj zzdnj, zzdmu zzdmu) {
        this.zzgrv = zzcsq;
        this.zzgfz = zzdnj;
        this.zzfto = zzdmu;
    }

    public final Object call() {
        return this.zzgrv.zzc(this.zzgfz, this.zzfto);
    }
}

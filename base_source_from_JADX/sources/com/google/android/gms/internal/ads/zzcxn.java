package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcxn implements Runnable {
    private final zzcxl zzgvy;
    private final zzve zzgvz;

    zzcxn(zzcxl zzcxl, zzve zzve) {
        this.zzgvy = zzcxl;
        this.zzgvz = zzve;
    }

    public final void run() {
        zzcxl zzcxl = this.zzgvy;
        zzcxl.zzgvr.zzgvs.zzk(this.zzgvz);
    }
}

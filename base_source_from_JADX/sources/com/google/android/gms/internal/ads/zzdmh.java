package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdmh implements Runnable {
    private final zzve zzgvz;
    private final zzdmf zzhgd;

    zzdmh(zzdmf zzdmf, zzve zzve) {
        this.zzhgd = zzdmf;
        this.zzgvz = zzve;
    }

    public final void run() {
        zzdmf zzdmf = this.zzhgd;
        zzdmf.zzhgf.zzhga.zzk(this.zzgvz);
    }
}

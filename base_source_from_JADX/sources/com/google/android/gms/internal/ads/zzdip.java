package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdip implements Runnable {
    private final zzve zzgvz;
    private final zzdim zzhdr;

    zzdip(zzdim zzdim, zzve zzve) {
        this.zzhdr = zzdim;
        this.zzgvz = zzve;
    }

    public final void run() {
        zzdim zzdim = this.zzhdr;
        zzdim.zzhdq.zzhdn.zzk(this.zzgvz);
    }
}

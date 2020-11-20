package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdlb implements Runnable {
    private final zzve zzgvz;
    private final zzdkx zzhfo;

    zzdlb(zzdkx zzdkx, zzve zzve) {
        this.zzhfo = zzdkx;
        this.zzgvz = zzve;
    }

    public final void run() {
        zzdkx zzdkx = this.zzhfo;
        zzdkx.zzhfq.zzhfm.zzk(this.zzgvz);
    }
}

package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbbq implements Runnable {
    private final int zzeds;
    private final int zzedt;
    private final zzbbl zzels;

    zzbbq(zzbbl zzbbl, int i, int i2) {
        this.zzels = zzbbl;
        this.zzeds = i;
        this.zzedt = i2;
    }

    public final void run() {
        this.zzels.zzp(this.zzeds, this.zzedt);
    }
}

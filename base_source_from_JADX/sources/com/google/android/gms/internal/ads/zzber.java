package com.google.android.gms.internal.ads;

final /* synthetic */ class zzber implements Runnable {
    private final int zzeds;
    private final int zzedt;
    private final boolean zzeqh;
    private final boolean zzeqi;
    private final zzbep zzesn;

    zzber(zzbep zzbep, int i, int i2, boolean z, boolean z2) {
        this.zzesn = zzbep;
        this.zzeds = i;
        this.zzedt = i2;
        this.zzeqh = z;
        this.zzeqi = z2;
    }

    public final void run() {
        this.zzesn.zzb(this.zzeds, this.zzedt, this.zzeqh, this.zzeqi);
    }
}

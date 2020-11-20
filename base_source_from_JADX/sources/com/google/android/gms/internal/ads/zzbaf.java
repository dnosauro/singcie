package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbaf implements Runnable {
    private final int zzeds;
    private final zzbac zzeic;

    zzbaf(zzbac zzbac, int i) {
        this.zzeic = zzbac;
        this.zzeds = i;
    }

    public final void run() {
        this.zzeic.zzdk(this.zzeds);
    }
}

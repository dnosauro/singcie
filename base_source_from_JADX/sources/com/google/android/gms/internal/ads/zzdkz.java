package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdkz implements Runnable {
    private final zzdkx zzhfo;

    zzdkz(zzdkx zzdkx) {
        this.zzhfo = zzdkx;
    }

    public final void run() {
        this.zzhfo.zzhfq.zzhfm.onAdLoaded();
    }
}

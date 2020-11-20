package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdme implements Runnable {
    private final zzdmf zzhgd;

    zzdme(zzdmf zzdmf) {
        this.zzhgd = zzdmf;
    }

    public final void run() {
        this.zzhgd.zzhgf.zzhga.onAdLoaded();
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

public final class zzvg extends zzww {
    private final AdListener zzcgw;

    public zzvg(AdListener adListener) {
        this.zzcgw = adListener;
    }

    public final AdListener getAdListener() {
        return this.zzcgw;
    }

    public final void onAdClicked() {
        this.zzcgw.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzcgw.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcgw.onAdFailedToLoad(i);
    }

    public final void onAdImpression() {
        this.zzcgw.onAdImpression();
    }

    public final void onAdLeftApplication() {
        this.zzcgw.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzcgw.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzcgw.onAdOpened();
    }

    public final void zzc(zzve zzve) {
        this.zzcgw.onAdFailedToLoad(zzve.zzpm());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

public class zzwp extends AdListener {
    private final Object lock = new Object();
    private AdListener zzciv;

    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzciv != null) {
                this.zzciv.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzciv != null) {
                this.zzciv.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.lock) {
            if (this.zzciv != null) {
                this.zzciv.onAdFailedToLoad(loadAdError);
            }
        }
    }

    public void onAdImpression() {
        synchronized (this.lock) {
            if (this.zzciv != null) {
                this.zzciv.onAdImpression();
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzciv != null) {
                this.zzciv.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzciv != null) {
                this.zzciv.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzciv != null) {
                this.zzciv.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzciv = adListener;
        }
    }
}

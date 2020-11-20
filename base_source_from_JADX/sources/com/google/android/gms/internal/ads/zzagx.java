package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzagx extends zzagb {
    private final UnifiedNativeAd.OnUnifiedNativeAdLoadedListener zzdfq;

    public zzagx(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.zzdfq = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzagj zzagj) {
        this.zzdfq.onUnifiedNativeAdLoaded(new zzagk(zzagj));
    }
}

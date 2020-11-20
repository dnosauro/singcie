package com.google.android.gms.ads.formats;

import android.widget.ImageView;
import com.google.android.gms.internal.ads.zzadw;

final /* synthetic */ class zze implements zzadw {
    private final UnifiedNativeAdView zzboc;

    zze(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzboc = unifiedNativeAdView;
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzboc.zza(scaleType);
    }
}

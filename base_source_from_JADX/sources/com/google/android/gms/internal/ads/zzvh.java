package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

public final class zzvh extends zzxm {
    private final AdMetadataListener zzcgx;

    public zzvh(AdMetadataListener adMetadataListener) {
        this.zzcgx = adMetadataListener;
    }

    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzcgx;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}

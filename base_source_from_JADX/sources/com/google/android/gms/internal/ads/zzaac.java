package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

public final class zzaac extends zzyk {
    private final OnAdMetadataChangedListener zzcky;

    public zzaac(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzcky = onAdMetadataChangedListener;
    }

    public final void onAdMetadataChanged() {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zzcky;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}

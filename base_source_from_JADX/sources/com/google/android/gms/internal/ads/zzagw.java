package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzagw extends zzagh {
    private final UnifiedNativeAd.UnconfirmedClickListener zzdfp;

    public zzagw(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzdfp = unconfirmedClickListener;
    }

    public final void onUnconfirmedClickCancelled() {
        this.zzdfp.onUnconfirmedClickCancelled();
    }

    public final void onUnconfirmedClickReceived(String str) {
        this.zzdfp.onUnconfirmedClickReceived(str);
    }
}

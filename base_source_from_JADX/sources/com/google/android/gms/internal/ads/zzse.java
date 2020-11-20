package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

@Deprecated
public final class zzse extends zzsp {
    private final AppOpenAdPresentationCallback zzbuh;

    public zzse(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbuh = appOpenAdPresentationCallback;
    }

    public final void onAppOpenAdClosed() {
        this.zzbuh.onAppOpenAdClosed();
    }
}

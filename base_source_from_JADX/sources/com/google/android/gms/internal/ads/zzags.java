package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

public final class zzags extends zzafn {
    private final NativeContentAd.OnContentAdLoadedListener zzdfj;

    public zzags(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzdfj = onContentAdLoadedListener;
    }

    public final void zza(zzafb zzafb) {
        this.zzdfj.onContentAdLoaded(new zzafc(zzafb));
    }
}

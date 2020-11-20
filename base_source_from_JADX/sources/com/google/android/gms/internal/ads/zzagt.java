package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

public final class zzagt extends zzafi {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzdfk;

    public zzagt(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzdfk = onAppInstallAdLoadedListener;
    }

    public final void zza(zzaex zzaex) {
        this.zzdfk.onAppInstallAdLoaded(new zzaey(zzaex));
    }
}

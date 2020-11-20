package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

public final class zzajw extends zzajs {
    private final InstreamAd.InstreamAdLoadCallback zzdhw;

    public zzajw(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdhw = instreamAdLoadCallback;
    }

    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdhw.onInstreamAdFailedToLoad(i);
    }

    public final void zza(zzajn zzajn) {
        this.zzdhw.onInstreamAdLoaded(new zzaju(zzajn));
    }

    public final void zzd(zzve zzve) {
        this.zzdhw.onInstreamAdFailedToLoad(zzve.zzpm());
    }
}

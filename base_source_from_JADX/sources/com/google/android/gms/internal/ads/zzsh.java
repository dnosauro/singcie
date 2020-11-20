package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;

public final class zzsh extends zzst {
    private final FullScreenContentCallback zzbuj;

    public zzsh(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuj = fullScreenContentCallback;
    }

    public final void onAdDismissedFullScreenContent() {
        this.zzbuj.onAdDismissedFullScreenContent();
    }

    public final void onAdShowedFullScreenContent() {
        this.zzbuj.onAdShowedFullScreenContent();
    }

    public final void zzb(zzve zzve) {
        this.zzbuj.onAdFailedToShowFullScreenContent(zzve.zzpl());
    }
}

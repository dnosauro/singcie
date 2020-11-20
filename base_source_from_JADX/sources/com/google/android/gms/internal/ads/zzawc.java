package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;

public final class zzawc extends zzavl {
    private FullScreenContentCallback zzdyf;
    private OnUserEarnedRewardListener zzdyg;

    public final void onRewardedAdClosed() {
        FullScreenContentCallback fullScreenContentCallback = this.zzdyf;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
    }

    public final void onRewardedAdOpened() {
        FullScreenContentCallback fullScreenContentCallback = this.zzdyf;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzdyf = fullScreenContentCallback;
    }

    public final void zza(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzdyg = onUserEarnedRewardListener;
    }

    public final void zza(zzavc zzavc) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.zzdyg;
        if (onUserEarnedRewardListener != null) {
            onUserEarnedRewardListener.onUserEarnedReward(new zzavv(zzavc));
        }
    }

    public final void zzh(zzve zzve) {
        FullScreenContentCallback fullScreenContentCallback = this.zzdyf;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzve.zzpl());
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

public final class zzawf extends zzavo {
    private final RewardedInterstitialAdLoadCallback zzdyi;
    private final zzawe zzdyj;

    public zzawf(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzawe zzawe) {
        this.zzdyi = rewardedInterstitialAdLoadCallback;
        this.zzdyj = zzawe;
    }

    public final void onRewardedAdFailedToLoad(int i) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdyi;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i);
        }
    }

    public final void onRewardedAdLoaded() {
        zzawe zzawe;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdyi;
        if (rewardedInterstitialAdLoadCallback != null && (zzawe = this.zzdyj) != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzawe);
        }
    }

    public final void zzi(zzve zzve) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdyi;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(zzve.zzpm());
        }
    }
}

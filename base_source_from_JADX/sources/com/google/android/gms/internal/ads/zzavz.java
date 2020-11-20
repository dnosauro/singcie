package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public final class zzavz extends zzavo {
    private final RewardedAdLoadCallback zzdye;

    public zzavz(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzdye = rewardedAdLoadCallback;
    }

    public final void onRewardedAdFailedToLoad(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdye;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }

    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdye;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }

    public final void zzi(zzve zzve) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdye;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(zzve.zzpm());
        }
    }
}

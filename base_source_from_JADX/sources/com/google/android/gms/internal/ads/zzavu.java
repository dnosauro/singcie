package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

public final class zzavu extends zzavl {
    private final RewardedAdCallback zzdyc;

    public zzavu(RewardedAdCallback rewardedAdCallback) {
        this.zzdyc = rewardedAdCallback;
    }

    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzdyc;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzdyc;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }

    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzdyc;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    public final void zza(zzavc zzavc) {
        RewardedAdCallback rewardedAdCallback = this.zzdyc;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzavv(zzavc));
        }
    }

    public final void zzh(zzve zzve) {
        RewardedAdCallback rewardedAdCallback = this.zzdyc;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(zzve.zzpl());
        }
    }
}

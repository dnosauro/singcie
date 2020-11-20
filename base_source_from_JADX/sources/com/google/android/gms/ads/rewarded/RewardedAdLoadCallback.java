package com.google.android.gms.ads.rewarded;

import com.google.android.gms.ads.LoadAdError;

public class RewardedAdLoadCallback {
    @Deprecated
    public void onRewardedAdFailedToLoad(int i) {
    }

    public void onRewardedAdFailedToLoad(LoadAdError loadAdError) {
    }

    public void onRewardedAdLoaded() {
    }
}

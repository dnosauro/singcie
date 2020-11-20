package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

final class zzb implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmm;

    zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmm = abstractAdViewAdapter;
    }

    public final void onRewarded(RewardItem rewardItem) {
        this.zzmm.zzmk.onRewarded(this.zzmm, rewardItem);
    }

    public final void onRewardedVideoAdClosed() {
        this.zzmm.zzmk.onAdClosed(this.zzmm);
        InterstitialAd unused = this.zzmm.zzmj = null;
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.zzmm.zzmk.onAdFailedToLoad(this.zzmm, i);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.zzmm.zzmk.onAdLeftApplication(this.zzmm);
    }

    public final void onRewardedVideoAdLoaded() {
        this.zzmm.zzmk.onAdLoaded(this.zzmm);
    }

    public final void onRewardedVideoAdOpened() {
        this.zzmm.zzmk.onAdOpened(this.zzmm);
    }

    public final void onRewardedVideoCompleted() {
        this.zzmm.zzmk.onVideoCompleted(this.zzmm);
    }

    public final void onRewardedVideoStarted() {
        this.zzmm.zzmk.onVideoStarted(this.zzmm);
    }
}

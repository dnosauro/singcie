package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzze;

public final class InterstitialAd {
    private final zzze zzadh;

    public InterstitialAd(Context context) {
        this.zzadh = new zzze(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzadh.getAdListener();
    }

    public final Bundle getAdMetadata() {
        return this.zzadh.getAdMetadata();
    }

    public final String getAdUnitId() {
        return this.zzadh.getAdUnitId();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadh.getMediationAdapterClassName();
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadh.getResponseInfo();
    }

    public final boolean isLoaded() {
        return this.zzadh.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadh.isLoading();
    }

    public final void loadAd(AdRequest adRequest) {
        this.zzadh.zza(adRequest.zzds());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadh.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzva)) {
            this.zzadh.zza((zzva) adListener);
        } else if (adListener == null) {
            this.zzadh.zza((zzva) null);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzadh.setAdMetadataListener(adMetadataListener);
    }

    public final void setAdUnitId(String str) {
        this.zzadh.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadh.setImmersiveMode(z);
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzadh.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzadh.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.zzadh.show();
    }

    public final void zzd(boolean z) {
        this.zzadh.zzd(true);
    }
}

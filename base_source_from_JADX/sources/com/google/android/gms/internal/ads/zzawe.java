package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzawe extends RewardedInterstitialAd {
    private final Context zzaaa;
    private final zzavh zzdyb;
    private final zzawc zzdyh = new zzawc();

    public zzawe(Context context, String str) {
        this.zzaaa = context.getApplicationContext();
        this.zzdyb = zzwq.zzqb().zzc(context, str, new zzanj());
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzdyb.getAdMetadata();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn;
        try {
            zzyn = this.zzdyb.zzkh();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            zzyn = null;
        }
        return ResponseInfo.zza(zzyn);
    }

    public final RewardItem getRewardItem() {
        try {
            zzavc zzre = this.zzdyb.zzre();
            if (zzre != null) {
                return new zzavv(zzre);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzdyh.setFullScreenContentCallback(fullScreenContentCallback);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzdyb.zza((zzyh) new zzaac(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdyb.zza((zzym) new zzaaf(onPaidEventListener));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdyb.zza(new zzavy(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzdyh.zza(onUserEarnedRewardListener);
        try {
            this.zzdyb.zza((zzavi) this.zzdyh);
            this.zzdyb.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzza zzza, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            this.zzdyb.zzb(zzvl.zza(this.zzaaa, zzza), new zzawf(rewardedInterstitialAdLoadCallback, this));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}

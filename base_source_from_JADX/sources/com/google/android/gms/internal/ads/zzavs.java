package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzavs {
    private final Context zzaaa;
    private final zzavh zzdyb;

    public zzavs(Context context, String str) {
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

    public final String getMediationAdapterClassName() {
        try {
            return this.zzdyb.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return "";
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
            if (zzre == null) {
                return null;
            }
            return new zzavv(zzre);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzdyb.isLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
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

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.zzdyb.zza((zzavi) new zzavu(rewardedAdCallback));
            this.zzdyb.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.zzdyb.zza((zzavi) new zzavu(rewardedAdCallback));
            this.zzdyb.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzza zzza, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzdyb.zza(zzvl.zza(this.zzaaa, zzza), (zzavp) new zzavz(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}

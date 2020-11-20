package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzaog implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzano zzdmv;
    private final /* synthetic */ zzaoe zzdmw;

    zzaog(zzaoe zzaoe, zzano zzano) {
        this.zzdmw = zzaoe;
        this.zzdmv = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            MediationRewardedAd unused = this.zzdmw.zzdms = mediationRewardedAd;
            this.zzdmv.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
        return new zzawa(this.zzdmv);
    }

    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzdmw.zzdmo.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 87 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ErrorCode = ");
            sb.append(code);
            sb.append(". ErrorMessage = ");
            sb.append(message);
            sb.append(". ErrorDomain = ");
            sb.append(domain);
            zzaza.zzeb(sb.toString());
            this.zzdmv.zzc(adError.zzdq());
            this.zzdmv.zzc(adError.getCode(), adError.getMessage());
            this.zzdmv.onAdFailedToLoad(adError.getCode());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzdmw.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 31 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzaza.zzeb(sb.toString());
            this.zzdmv.zzc(0, str);
            this.zzdmv.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}

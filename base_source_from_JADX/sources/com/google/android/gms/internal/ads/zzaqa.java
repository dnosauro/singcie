package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

final class zzaqa implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzano zzdnq;
    private final /* synthetic */ zzapx zzdnw;
    private final /* synthetic */ zzapn zzdnx;

    zzaqa(zzapx zzapx, zzapn zzapn, zzano zzano) {
        this.zzdnw = zzapx;
        this.zzdnx = zzapn;
        this.zzdnq = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdnx.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationRewardedAd unused = this.zzdnw.zzdms = mediationRewardedAd;
                this.zzdnx.zzuw();
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new zzaqd(this.zzdnq);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.zzdnx.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdnx.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}

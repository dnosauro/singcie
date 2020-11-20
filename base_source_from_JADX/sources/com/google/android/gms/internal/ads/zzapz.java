package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

final class zzapz implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzano zzdnq;
    private final /* synthetic */ zzaph zzdnv;
    private final /* synthetic */ zzapx zzdnw;

    zzapz(zzapx zzapx, zzaph zzaph, zzano zzano) {
        this.zzdnw = zzapx;
        this.zzdnv = zzaph;
        this.zzdnq = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdnv.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationInterstitialAd unused = this.zzdnw.zzdns = mediationInterstitialAd;
                this.zzdnv.zzuw();
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new zzaqd(this.zzdnq);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.zzdnv.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdnv.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzapw implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzapc zzdnp;
    private final /* synthetic */ zzano zzdnq;

    zzapw(zzapx zzapx, zzapc zzapc, zzano zzano) {
        this.zzdnp = zzapc;
        this.zzdnq = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        if (mediationBannerAd == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdnp.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdnp.zzx(ObjectWrapper.wrap(mediationBannerAd.getView()));
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new zzaqd(this.zzdnq);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.zzdnp.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdnp.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}

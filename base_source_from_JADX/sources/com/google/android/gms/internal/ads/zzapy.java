package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

final class zzapy implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzano zzdnq;
    private final /* synthetic */ zzapi zzdnu;

    zzapy(zzapx zzapx, zzapi zzapi, zzano zzano) {
        this.zzdnu = zzapi;
        this.zzdnq = zzano;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper == null) {
            zzaza.zzfa("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdnu.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzaza.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdnu.zza(new zzapd(unifiedNativeAdMapper));
            } catch (RemoteException e2) {
                zzaza.zzc("", e2);
            }
            return new zzaqd(this.zzdnq);
        }
    }

    public final void onFailure(AdError adError) {
        try {
            this.zzdnu.zzf(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdnu.zzdm(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}

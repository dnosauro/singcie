package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

final class zzaqb implements SignalCallbacks {
    private final /* synthetic */ zzapt zzdny;

    zzaqb(zzapx zzapx, zzapt zzapt) {
        this.zzdny = zzapt;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zzdny.zzg(adError.zzdq());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zzdny.onFailure(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onSuccess(String str) {
        try {
            this.zzdny.zzdo(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}

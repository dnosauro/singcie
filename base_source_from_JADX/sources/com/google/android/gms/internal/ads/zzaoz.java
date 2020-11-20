package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

final class zzaoz implements Runnable {
    private final /* synthetic */ zzaop zzdnk;
    private final /* synthetic */ AdRequest.ErrorCode zzdnl;

    zzaoz(zzaop zzaop, AdRequest.ErrorCode errorCode) {
        this.zzdnk = zzaop;
        this.zzdnl = errorCode;
    }

    public final void run() {
        try {
            this.zzdnk.zzdmz.onAdFailedToLoad(zzapb.zza(this.zzdnl));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}

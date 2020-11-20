package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final /* synthetic */ class zzaab implements Runnable {
    private final zzavp zzckx;

    zzaab(zzavp zzavp) {
        this.zzckx = zzavp;
    }

    public final void run() {
        zzavp zzavp = this.zzckx;
        if (zzavp != null) {
            try {
                zzavp.onRewardedAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }
}

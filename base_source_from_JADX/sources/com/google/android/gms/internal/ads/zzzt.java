package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzzt implements Runnable {
    private final /* synthetic */ zzzq zzcks;

    zzzt(zzzq zzzq) {
        this.zzcks = zzzq;
    }

    public final void run() {
        if (this.zzcks.zzckr.zzbpi != null) {
            try {
                this.zzcks.zzckr.zzbpi.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}

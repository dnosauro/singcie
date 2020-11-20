package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzzv implements Runnable {
    private final /* synthetic */ zzzs zzcku;

    zzzv(zzzs zzzs) {
        this.zzcku = zzzs;
    }

    public final void run() {
        if (this.zzcku.zzbpi != null) {
            try {
                this.zzcku.zzbpi.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}

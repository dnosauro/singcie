package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaad implements Runnable {
    private final /* synthetic */ zzaaa zzckz;

    zzaad(zzaaa zzaaa) {
        this.zzckz = zzaaa;
    }

    public final void run() {
        if (this.zzckz.zzckw != null) {
            try {
                this.zzckz.zzckw.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzaza.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}

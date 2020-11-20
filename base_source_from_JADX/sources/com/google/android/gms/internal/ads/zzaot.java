package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaot implements Runnable {
    private final /* synthetic */ zzaop zzdnk;

    zzaot(zzaop zzaop) {
        this.zzdnk = zzaop;
    }

    public final void run() {
        try {
            this.zzdnk.zzdmz.onAdClosed();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaor implements Runnable {
    private final /* synthetic */ zzaop zzdnk;

    zzaor(zzaop zzaop) {
        this.zzdnk = zzaop;
    }

    public final void run() {
        try {
            this.zzdnk.zzdmz.onAdOpened();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}

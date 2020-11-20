package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzaov implements Runnable {
    private final /* synthetic */ zzaop zzdnk;

    zzaov(zzaop zzaop) {
        this.zzdnk = zzaop;
    }

    public final void run() {
        try {
            this.zzdnk.zzdmz.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}

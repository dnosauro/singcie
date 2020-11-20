package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

final class zzaoh implements InitializationCompleteCallback {
    private final /* synthetic */ zzajb zzdmx;

    zzaoh(zzaoe zzaoe, zzajb zzajb) {
        this.zzdmx = zzajb;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zzdmx.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zzdmx.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import javax.annotation.concurrent.GuardedBy;

public final class zzcyd implements zzva {
    @GuardedBy("this")
    private zzws zzgwh;

    public final synchronized void onAdClicked() {
        if (this.zzgwh != null) {
            try {
                this.zzgwh.onAdClicked();
            } catch (RemoteException e) {
                zzd.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zzb(zzws zzws) {
        this.zzgwh = zzws;
    }
}

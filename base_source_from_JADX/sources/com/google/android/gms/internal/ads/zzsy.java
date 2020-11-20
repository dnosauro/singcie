package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzsy implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzsx zzbup;

    zzsy(zzsx zzsx) {
        this.zzbup = zzsx;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbup.lock) {
            try {
                if (this.zzbup.zzbur != null) {
                    zztg unused = this.zzbup.zzbus = this.zzbup.zzbur.zznc();
                }
            } catch (DeadObjectException e) {
                zzd.zzc("Unable to obtain a cache service instance.", e);
                this.zzbup.disconnect();
            }
            this.zzbup.lock.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbup.lock) {
            zztg unused = this.zzbup.zzbus = null;
            this.zzbup.lock.notifyAll();
        }
    }
}

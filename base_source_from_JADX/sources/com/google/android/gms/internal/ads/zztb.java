package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zztb implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzsx zzbup;

    zztb(zzsx zzsx) {
        this.zzbup = zzsx;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbup.lock) {
            zztg unused = this.zzbup.zzbus = null;
            if (this.zzbup.zzbur != null) {
                zztc unused2 = this.zzbup.zzbur = null;
            }
            this.zzbup.lock.notifyAll();
        }
    }
}

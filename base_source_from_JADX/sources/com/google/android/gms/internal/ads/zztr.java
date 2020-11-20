package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zztr implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zztl zzbvh;
    private final /* synthetic */ zzazq zzbvo;

    zztr(zztl zztl, zzazq zzazq) {
        this.zzbvh = zztl;
        this.zzbvo = zzazq;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbvh.lock) {
            this.zzbvo.setException(new RuntimeException("Connection failed."));
        }
    }
}

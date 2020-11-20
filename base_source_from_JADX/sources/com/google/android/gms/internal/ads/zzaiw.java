package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzaiw implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzazq zzbvo;

    zzaiw(zzait zzait, zzazq zzazq) {
        this.zzbvo = zzazq;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbvo.setException(new RuntimeException("Connection failed."));
    }
}

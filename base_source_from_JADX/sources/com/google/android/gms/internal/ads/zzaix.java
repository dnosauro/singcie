package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzaix implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzazq zzbvo;
    private final /* synthetic */ zzait zzdhm;

    zzaix(zzait zzait, zzazq zzazq) {
        this.zzdhm = zzait;
        this.zzbvo = zzazq;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zzbvo.set(this.zzdhm.zzdhl.zztk());
        } catch (DeadObjectException e) {
            this.zzbvo.setException(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        zzazq zzazq = this.zzbvo;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzazq.setException(new RuntimeException(sb.toString()));
    }
}

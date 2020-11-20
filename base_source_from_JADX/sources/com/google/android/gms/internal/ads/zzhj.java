package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzhj extends Handler {
    private final /* synthetic */ zzhk zzaen;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzhj(zzhk zzhk, Looper looper) {
        super(looper);
        this.zzaen = zzhk;
    }

    public final void handleMessage(Message message) {
        this.zzaen.zza(message);
    }
}

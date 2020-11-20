package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzr extends BroadcastReceiver {
    private final /* synthetic */ zzm zzedj;

    private zzr(zzm zzm) {
        this.zzedj = zzm;
    }

    /* synthetic */ zzr(zzm zzm, zzo zzo) {
        this(zzm);
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            boolean unused = this.zzedj.zzys = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            boolean unused2 = this.zzedj.zzys = false;
        }
    }
}

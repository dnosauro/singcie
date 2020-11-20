package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzzg implements Runnable {
    private final zzzd zzckk;
    private final Context zzckm;

    zzzg(zzzd zzzd, Context context) {
        this.zzckk = zzzd;
        this.zzckm = context;
    }

    public final void run() {
        this.zzckk.getRewardedVideoAdInstance(this.zzckm);
    }
}

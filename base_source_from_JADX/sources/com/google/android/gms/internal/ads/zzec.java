package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

final class zzec implements Runnable {
    private final /* synthetic */ Context zzxm;
    private final /* synthetic */ View zzxo;
    private final /* synthetic */ Activity zzxp;

    zzec(zzdx zzdx, Context context, View view, Activity activity) {
        this.zzxm = context;
        this.zzxo = view;
        this.zzxp = activity;
    }

    public final void run() {
        try {
            zzdx.zzwi.zza(this.zzxm, this.zzxo, this.zzxp);
        } catch (Exception e) {
            zzdx.zzwk.zza(2020, -1, e);
        }
    }
}

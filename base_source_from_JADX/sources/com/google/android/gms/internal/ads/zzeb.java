package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

final class zzeb implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzxm;
    private final /* synthetic */ String zzxn;
    private final /* synthetic */ View zzxo;

    zzeb(zzdx zzdx, Context context, String str, View view, Activity activity) {
        this.zzxm = context;
        this.zzxn = str;
        this.zzxo = view;
        this.val$activity = activity;
    }

    public final void run() {
        try {
            zzdx.zzwi.zza(this.zzxm, this.zzxn, this.zzxo, this.val$activity);
        } catch (Exception e) {
            zzdx.zzwk.zza(2021, -1, e);
        }
    }
}

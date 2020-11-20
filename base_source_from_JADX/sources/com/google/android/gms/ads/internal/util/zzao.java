package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

final class zzao implements Runnable {
    final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzeeb;
    private final /* synthetic */ boolean zzeec;
    private final /* synthetic */ boolean zzeed;

    zzao(zzal zzal, Context context, String str, boolean z, boolean z2) {
        this.val$context = context;
        this.zzeeb = str;
        this.zzeec = z;
        this.zzeed = z2;
    }

    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.val$context);
        builder.setMessage(this.zzeeb);
        builder.setTitle(this.zzeec ? "Error" : "Info");
        if (this.zzeed) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new zzan(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}

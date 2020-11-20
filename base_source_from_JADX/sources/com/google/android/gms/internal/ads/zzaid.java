package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import java.util.Timer;
import java.util.TimerTask;

final class zzaid extends TimerTask {
    private final /* synthetic */ AlertDialog zzdhc;
    private final /* synthetic */ Timer zzdhd;

    zzaid(zzahz zzahz, AlertDialog alertDialog, Timer timer) {
        this.zzdhc = alertDialog;
        this.zzdhd = timer;
    }

    public final void run() {
        this.zzdhc.dismiss();
        this.zzdhd.cancel();
    }
}

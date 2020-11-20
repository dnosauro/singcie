package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbfo implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzawq zzepx;
    private final /* synthetic */ int zzepz;
    private final /* synthetic */ zzbfm zzete;

    zzbfo(zzbfm zzbfm, View view, zzawq zzawq, int i) {
        this.zzete = zzbfm;
        this.val$view = view;
        this.zzepx = zzawq;
        this.zzepz = i;
    }

    public final void run() {
        this.zzete.zza(this.val$view, this.zzepx, this.zzepz - 1);
    }
}

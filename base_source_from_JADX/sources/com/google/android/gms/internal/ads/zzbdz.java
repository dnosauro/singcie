package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbdz implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzawq zzepx;
    private final /* synthetic */ zzbdu zzepy;
    private final /* synthetic */ int zzepz;

    zzbdz(zzbdu zzbdu, View view, zzawq zzawq, int i) {
        this.zzepy = zzbdu;
        this.val$view = view;
        this.zzepx = zzawq;
        this.zzepz = i;
    }

    public final void run() {
        this.zzepy.zza(this.val$view, this.zzepx, this.zzepz - 1);
    }
}

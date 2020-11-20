package com.google.android.gms.internal.ads;

import android.view.View;

final class zzrn implements Runnable {
    private final /* synthetic */ zzrk zzbtl;
    private final /* synthetic */ View zzbtm;

    zzrn(zzrk zzrk, View view) {
        this.zzbtl = zzrk;
        this.zzbtm = view;
    }

    public final void run() {
        this.zzbtl.zzj(this.zzbtm);
    }
}

package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

final /* synthetic */ class zzawg implements Runnable {
    private final zzawh zzdyk;
    private final Bitmap zzdyl;

    zzawg(zzawh zzawh, Bitmap bitmap) {
        this.zzdyk = zzawh;
        this.zzdyl = bitmap;
    }

    public final void run() {
        this.zzdyk.zza(this.zzdyl);
    }
}

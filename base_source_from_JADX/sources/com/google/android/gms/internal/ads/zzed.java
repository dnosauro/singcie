package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

final class zzed implements Runnable {
    private final /* synthetic */ int zzxq;
    private final /* synthetic */ int zzxr;
    private final /* synthetic */ int zzxs;

    zzed(zzdx zzdx, int i, int i2, int i3) {
        this.zzxq = i;
        this.zzxr = i2;
        this.zzxs = i3;
    }

    public final void run() {
        try {
            zzdx.zzwi.zza(MotionEvent.obtain(0, (long) this.zzxq, 0, (float) this.zzxr, (float) this.zzxs, 0));
        } catch (Exception e) {
            zzdx.zzwk.zza(2022, -1, e);
        }
    }
}

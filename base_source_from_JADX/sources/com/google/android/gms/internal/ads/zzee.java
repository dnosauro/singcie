package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

final class zzee implements Runnable {
    private final /* synthetic */ MotionEvent zzxt;

    zzee(zzdx zzdx, MotionEvent motionEvent) {
        this.zzxt = motionEvent;
    }

    public final void run() {
        try {
            zzdx.zzwi.zza(this.zzxt);
        } catch (Exception e) {
            zzdx.zzwk.zza(2022, -1, e);
        }
    }
}

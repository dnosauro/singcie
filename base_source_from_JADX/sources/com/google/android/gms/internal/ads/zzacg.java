package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

public final class zzacg {
    private MotionEvent zzdak = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzdal = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zzdak.getEventTime()) {
            this.zzdak = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzdal.getEventTime()) {
            this.zzdal = MotionEvent.obtain(motionEvent);
        }
    }

    public final MotionEvent zzsg() {
        return this.zzdak;
    }

    public final MotionEvent zzsh() {
        return this.zzdal;
    }
}

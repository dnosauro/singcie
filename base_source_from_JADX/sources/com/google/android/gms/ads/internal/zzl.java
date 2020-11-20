package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

final class zzl implements View.OnTouchListener {
    private final /* synthetic */ zzj zzbpl;

    zzl(zzj zzj) {
        this.zzbpl = zzj;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzbpl.zzbpj == null) {
            return false;
        }
        this.zzbpl.zzbpj.zza(motionEvent);
        return false;
    }
}

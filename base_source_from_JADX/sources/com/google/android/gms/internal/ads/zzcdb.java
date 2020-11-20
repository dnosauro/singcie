package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONObject;

final class zzcdb implements zzadx {
    private final /* synthetic */ zzcdy zzgel;
    private final /* synthetic */ ViewGroup zzgem;
    private final /* synthetic */ zzcda zzgen;

    zzcdb(zzcda zzcda, zzcdy zzcdy, ViewGroup viewGroup) {
        this.zzgen = zzcda;
        this.zzgel = zzcdy;
        this.zzgem = viewGroup;
    }

    public final void zzc(MotionEvent motionEvent) {
        this.zzgel.onTouch((View) null, motionEvent);
    }

    public final void zzss() {
        if (zzcda.zza(this.zzgel, zzccy.zzgeb)) {
            this.zzgel.onClick(this.zzgem);
        }
    }

    public final JSONObject zzst() {
        return this.zzgel.zzst();
    }
}

package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbdy implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzawq zzepx;
    private final /* synthetic */ zzbdu zzepy;

    zzbdy(zzbdu zzbdu, zzawq zzawq) {
        this.zzepy = zzbdu;
        this.zzepx = zzawq;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzepy.zza(view, this.zzepx, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}

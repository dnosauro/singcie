package com.google.android.gms.internal.ads;

import android.view.View;

final class zzbfr implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzawq zzepx;
    private final /* synthetic */ zzbfm zzete;

    zzbfr(zzbfm zzbfm, zzawq zzawq) {
        this.zzete = zzbfm;
        this.zzepx = zzawq;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzete.zza(view, this.zzepx, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}

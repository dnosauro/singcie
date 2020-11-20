package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;

final /* synthetic */ class zzbej implements Runnable {
    private final IObjectWrapper zzeqy;

    zzbej(IObjectWrapper iObjectWrapper) {
        this.zzeqy = iObjectWrapper;
    }

    public final void run() {
        zzp.zzlf().zzac(this.zzeqy);
    }
}

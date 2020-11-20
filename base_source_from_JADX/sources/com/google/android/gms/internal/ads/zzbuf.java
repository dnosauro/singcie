package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

final class zzbuf implements Runnable {
    private final WeakReference<zzbua> zzfyd;

    private zzbuf(zzbua zzbua) {
        this.zzfyd = new WeakReference<>(zzbua);
    }

    public final void run() {
        zzbua zzbua = (zzbua) this.zzfyd.get();
        if (zzbua != null) {
            zzbua.zzalc();
        }
    }
}

package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

final /* synthetic */ class zzcdc implements Runnable {
    private final zzcda zzgeh;
    private final ViewGroup zzgeo;

    zzcdc(zzcda zzcda, ViewGroup viewGroup) {
        this.zzgeh = zzcda;
        this.zzgeo = viewGroup;
    }

    public final void run() {
        this.zzgeh.zzb(this.zzgeo);
    }
}

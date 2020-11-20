package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

final /* synthetic */ class zzzf implements Runnable {
    private final zzzd zzckk;
    private final OnInitializationCompleteListener zzckl;

    zzzf(zzzd zzzd, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzckk = zzzd;
        this.zzckl = onInitializationCompleteListener;
    }

    public final void run() {
        this.zzckk.zza(this.zzckl);
    }
}

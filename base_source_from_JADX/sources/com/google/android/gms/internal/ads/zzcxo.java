package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcxo implements Runnable {
    private final zzcxq zzgwa;

    private zzcxo(zzcxq zzcxq) {
        this.zzgwa = zzcxq;
    }

    static Runnable zzb(zzcxq zzcxq) {
        return new zzcxo(zzcxq);
    }

    public final void run() {
        this.zzgwa.onAdLoaded();
    }
}

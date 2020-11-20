package com.google.android.gms.internal.ads;

final /* synthetic */ class zzchb implements Runnable {
    private final zzbdv zzesw;

    private zzchb(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    static Runnable zzh(zzbdv zzbdv) {
        return new zzchb(zzbdv);
    }

    public final void run() {
        this.zzesw.destroy();
    }
}

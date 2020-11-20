package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbza implements Runnable {
    private final zzbdv zzesw;

    private zzbza(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    static Runnable zzh(zzbdv zzbdv) {
        return new zzbza(zzbdv);
    }

    public final void run() {
        this.zzesw.destroy();
    }
}

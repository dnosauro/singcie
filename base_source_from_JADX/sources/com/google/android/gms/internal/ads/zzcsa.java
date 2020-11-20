package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcsa implements Runnable {
    private final zzbdv zzesw;

    private zzcsa(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    static Runnable zzh(zzbdv zzbdv) {
        return new zzcsa(zzbdv);
    }

    public final void run() {
        this.zzesw.zzadf();
    }
}

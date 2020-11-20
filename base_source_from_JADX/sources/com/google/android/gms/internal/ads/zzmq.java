package com.google.android.gms.internal.ads;

final class zzmq implements Runnable {
    private final /* synthetic */ zzmo zzbei;

    zzmq(zzmo zzmo) {
        this.zzbei = zzmo;
    }

    public final void run() {
        if (!this.zzbei.zzagh) {
            this.zzbei.zzbdt.zza(this.zzbei);
        }
    }
}

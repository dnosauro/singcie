package com.google.android.gms.internal.ads;

final /* synthetic */ class zzalw implements Runnable {
    private final zzalx zzdjp;
    private final zzako zzdjq;

    zzalw(zzalx zzalx, zzako zzako) {
        this.zzdjp = zzalx;
        this.zzdjq = zzako;
    }

    public final void run() {
        zzalx zzalx = this.zzdjp;
        zzako zzako = this.zzdjq;
        zzalx.zzdjr.zzdiv.zzh(zzako);
        zzako.destroy();
    }
}

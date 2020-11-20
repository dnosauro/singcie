package com.google.android.gms.internal.ads;

final /* synthetic */ class zzalh implements Runnable {
    private final zzako zzdjd;

    private zzalh(zzako zzako) {
        this.zzdjd = zzako;
    }

    static Runnable zzb(zzako zzako) {
        return new zzalh(zzako);
    }

    public final void run() {
        this.zzdjd.destroy();
    }
}

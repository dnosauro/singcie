package com.google.android.gms.internal.ads;

final /* synthetic */ class zzall implements Runnable {
    private final zzako zzdjd;

    private zzall(zzako zzako) {
        this.zzdjd = zzako;
    }

    static Runnable zzb(zzako zzako) {
        return new zzall(zzako);
    }

    public final void run() {
        this.zzdjd.destroy();
    }
}

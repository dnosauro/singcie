package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbnm implements Runnable {
    private final Runnable zzfow;
    private final zzbnk zzfuc;

    zzbnm(zzbnk zzbnk, Runnable runnable) {
        this.zzfuc = zzbnk;
        this.zzfow = runnable;
    }

    public final void run() {
        this.zzfuc.zze(this.zzfow);
    }
}

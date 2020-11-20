package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbit implements Runnable {
    private final zzbiu zzfov;
    private final Runnable zzfow;

    zzbit(zzbiu zzbiu, Runnable runnable) {
        this.zzfov = zzbiu;
        this.zzfow = runnable;
    }

    public final void run() {
        zzazj.zzegt.execute(new zzbiw(this.zzfov, this.zzfow));
    }
}

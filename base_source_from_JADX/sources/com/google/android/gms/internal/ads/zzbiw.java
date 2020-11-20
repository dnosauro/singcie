package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbiw implements Runnable {
    private final zzbiu zzfov;
    private final Runnable zzfow;

    zzbiw(zzbiu zzbiu, Runnable runnable) {
        this.zzfov = zzbiu;
        this.zzfow = runnable;
    }

    public final void run() {
        this.zzfov.zzd(this.zzfow);
    }
}

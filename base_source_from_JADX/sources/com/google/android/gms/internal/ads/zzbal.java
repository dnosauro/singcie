package com.google.android.gms.internal.ads;

final class zzbal implements Runnable {
    private final /* synthetic */ zzbac zzeib;

    zzbal(zzbac zzbac) {
        this.zzeib = zzbac;
    }

    public final void run() {
        if (this.zzeib.zzehx != null) {
            this.zzeib.zzehx.onPaused();
            this.zzeib.zzehx.zzzu();
        }
    }
}

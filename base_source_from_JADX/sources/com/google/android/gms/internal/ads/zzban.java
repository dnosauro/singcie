package com.google.android.gms.internal.ads;

final class zzban implements Runnable {
    private final /* synthetic */ zzbac zzeib;

    zzban(zzbac zzbac) {
        this.zzeib = zzbac;
    }

    public final void run() {
        if (this.zzeib.zzehx != null) {
            this.zzeib.zzehx.onPaused();
        }
    }
}
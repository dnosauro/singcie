package com.google.android.gms.internal.ads;

final class zzsw implements Runnable {
    private final /* synthetic */ zzsx zzbup;

    zzsw(zzsx zzsx) {
        this.zzbup = zzsx;
    }

    public final void run() {
        this.zzbup.disconnect();
    }
}

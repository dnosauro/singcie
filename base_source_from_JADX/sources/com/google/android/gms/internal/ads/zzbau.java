package com.google.android.gms.internal.ads;

final class zzbau implements Runnable {
    private final /* synthetic */ zzbar zzeja;
    private final /* synthetic */ boolean zzejd;

    zzbau(zzbar zzbar, boolean z) {
        this.zzeja = zzbar;
        this.zzejd = z;
    }

    public final void run() {
        this.zzeja.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzejd));
    }
}

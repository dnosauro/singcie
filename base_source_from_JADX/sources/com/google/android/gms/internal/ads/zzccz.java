package com.google.android.gms.internal.ads;

final /* synthetic */ class zzccz implements Runnable {
    private final zzcda zzgeh;
    private final zzcdy zzgei;

    zzccz(zzcda zzcda, zzcdy zzcdy) {
        this.zzgeh = zzcda;
        this.zzgei = zzcdy;
    }

    public final void run() {
        this.zzgeh.zze(this.zzgei);
    }
}

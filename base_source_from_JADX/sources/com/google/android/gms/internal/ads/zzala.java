package com.google.android.gms.internal.ads;

final /* synthetic */ class zzala implements Runnable {
    private final zzalb zzdiq;
    private final zzef zzdir;
    private final zzals zzdis;

    zzala(zzalb zzalb, zzef zzef, zzals zzals) {
        this.zzdiq = zzalb;
        this.zzdir = zzef;
        this.zzdis = zzals;
    }

    public final void run() {
        this.zzdiq.zza(this.zzdir, this.zzdis);
    }
}

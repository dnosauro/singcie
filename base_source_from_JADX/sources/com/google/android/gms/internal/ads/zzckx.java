package com.google.android.gms.internal.ads;

final /* synthetic */ class zzckx implements Runnable {
    private final String zzdha;
    private final zzcky zzgkr;

    zzckx(zzcky zzcky, String str) {
        this.zzgkr = zzcky;
        this.zzdha = str;
    }

    public final void run() {
        zzcky zzcky = this.zzgkr;
        zzcky.zzeff.zzeo(this.zzdha);
    }
}

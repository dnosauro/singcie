package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbbm implements Runnable {
    private final String zzdha;
    private final zzbbl zzels;

    zzbbm(zzbbl zzbbl, String str) {
        this.zzels = zzbbl;
        this.zzdha = str;
    }

    public final void run() {
        this.zzels.zzfg(this.zzdha);
    }
}

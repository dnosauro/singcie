package com.google.android.gms.internal.ads;

final /* synthetic */ class zzdsc implements Runnable {
    private final String zzdha;
    private final zzdrz zzhjb;

    zzdsc(zzdrz zzdrz, String str) {
        this.zzhjb = zzdrz;
        this.zzdha = str;
    }

    public final void run() {
        this.zzhjb.zzgw(this.zzdha);
    }
}

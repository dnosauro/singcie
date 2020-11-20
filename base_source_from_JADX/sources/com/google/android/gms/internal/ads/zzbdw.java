package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzbdw implements Runnable {
    private final String zzdih;

    zzbdw(String str) {
        this.zzdih = str;
    }

    public final void run() {
        zzp.zzku().zzwt().zzcr(this.zzdih.substring(1));
    }
}

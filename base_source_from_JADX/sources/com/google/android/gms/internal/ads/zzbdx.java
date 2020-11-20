package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;

final /* synthetic */ class zzbdx implements Runnable {
    private final zzbdu zzepw;

    zzbdx(zzbdu zzbdu) {
        this.zzepw = zzbdu;
    }

    public final void run() {
        zzbdu zzbdu = this.zzepw;
        zzbdu.zzepg.zzadb();
        zze zzaco = zzbdu.zzepg.zzaco();
        if (zzaco != null) {
            zzaco.zzvf();
        }
    }
}

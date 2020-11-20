package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zze;

final /* synthetic */ class zzbfp implements Runnable {
    private final zzbfm zzetf;

    zzbfp(zzbfm zzbfm) {
        this.zzetf = zzbfm;
    }

    public final void run() {
        zzbfm zzbfm = this.zzetf;
        zzbfm.zzepg.zzadb();
        zze zzaco = zzbfm.zzepg.zzaco();
        if (zzaco != null) {
            zzaco.zzvf();
        }
    }
}

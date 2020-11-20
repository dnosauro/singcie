package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcvf implements zzbsm {
    private final zzbdv zzesw;

    zzcvf(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    public final void onAdImpression() {
        zzbdv zzbdv = this.zzesw;
        if (zzbdv.zzacs() != null) {
            zzbdv.zzacs().zzace();
        }
    }
}

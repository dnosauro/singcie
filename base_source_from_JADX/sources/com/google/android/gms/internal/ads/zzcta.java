package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcta implements zzbsm {
    private final zzbdv zzesw;

    zzcta(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    public final void onAdImpression() {
        zzbdv zzbdv = this.zzesw;
        if (zzbdv.zzacs() != null) {
            zzbdv.zzacs().zzace();
        }
    }
}
package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbze implements zzbvs {
    private final zzbdv zzesw;

    zzbze(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    public final void zzajn() {
        zzbdv zzbdv = this.zzesw;
        if (zzbdv.zzaco() != null) {
            zzbdv.zzaco().close();
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzu;

final /* synthetic */ class zzcgr implements zzu {
    private final zzbsu zzghs;

    private zzcgr(zzbsu zzbsu) {
        this.zzghs = zzbsu;
    }

    static zzu zza(zzbsu zzbsu) {
        return new zzcgr(zzbsu);
    }

    public final void zzvo() {
        this.zzghs.onAdLeftApplication();
    }
}

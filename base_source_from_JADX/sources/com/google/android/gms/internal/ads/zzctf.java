package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;

final /* synthetic */ class zzctf implements zzcaf {
    private final zzcrb zzgro;

    zzctf(zzcrb zzcrb) {
        this.zzgro = zzcrb;
    }

    public final void zza(boolean z, Context context) {
        zzcrb zzcrb = this.zzgro;
        try {
            ((zzdoe) zzcrb.zzdmo).setImmersiveMode(z);
            ((zzdoe) zzcrb.zzdmo).showInterstitial();
        } catch (zzdnr e) {
            zzd.zzez("Cannot show interstitial.");
            throw new zzcai(e.getCause());
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;

final /* synthetic */ class zzcvn implements zzcaf {
    private final zzcrb zzgro;

    zzcvn(zzcrb zzcrb) {
        this.zzgro = zzcrb;
    }

    public final void zza(boolean z, Context context) {
        zzcrb zzcrb = this.zzgro;
        try {
            ((zzdoe) zzcrb.zzdmo).setImmersiveMode(z);
            ((zzdoe) zzcrb.zzdmo).showVideo();
        } catch (zzdnr e) {
            zzd.zzd("Cannot show rewarded video.", e);
            throw new zzcai(e.getCause());
        }
    }
}

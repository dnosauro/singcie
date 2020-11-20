package com.google.android.gms.internal.ads;

import android.content.Context;

final /* synthetic */ class zzcut implements zzcaf {
    private final zzcrb zzgro;

    zzcut(zzcrb zzcrb) {
        this.zzgro = zzcrb;
    }

    public final void zza(boolean z, Context context) {
        zzcrb zzcrb = this.zzgro;
        try {
            ((zzdoe) zzcrb.zzdmo).setImmersiveMode(z);
            ((zzdoe) zzcrb.zzdmo).zzck(context);
        } catch (zzdnr e) {
            throw new zzcai(e.getCause());
        }
    }
}

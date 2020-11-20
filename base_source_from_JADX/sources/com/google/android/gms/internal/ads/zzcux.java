package com.google.android.gms.internal.ads;

final class zzcux extends zzapm {
    private zzcrb<zzapo, zzcst> zzgrp;

    private zzcux(zzcuv zzcuv, zzcrb<zzapo, zzcst> zzcrb) {
        this.zzgrp = zzcrb;
    }

    public final void zzdm(String str) {
        ((zzcst) this.zzgrp.zzgqp).zzc(0, str);
    }

    public final void zzf(zzve zzve) {
        ((zzcst) this.zzgrp.zzgqp).zzc(zzve);
    }

    public final void zzuw() {
        ((zzcst) this.zzgrp.zzgqp).onAdLoaded();
    }
}

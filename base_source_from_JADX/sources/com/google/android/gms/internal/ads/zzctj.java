package com.google.android.gms.internal.ads;

final class zzctj extends zzapg {
    private zzcrb<zzapo, zzcst> zzgrp;

    private zzctj(zzcth zzcth, zzcrb<zzapo, zzcst> zzcrb) {
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

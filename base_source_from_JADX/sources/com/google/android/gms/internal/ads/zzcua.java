package com.google.android.gms.internal.ads;

final class zzcua extends zzapl {
    private zzcrb<zzapo, zzcst> zzgrp;
    private final /* synthetic */ zzcty zzgsr;

    private zzcua(zzcty zzcty, zzcrb<zzapo, zzcst> zzcrb) {
        this.zzgsr = zzcty;
        this.zzgrp = zzcrb;
    }

    public final void zza(zzaob zzaob) {
        zzaob unused = this.zzgsr.zzgsq = zzaob;
        ((zzcst) this.zzgrp.zzgqp).onAdLoaded();
    }

    public final void zzdm(String str) {
        ((zzcst) this.zzgrp.zzgqp).zzc(0, str);
    }

    public final void zzf(zzve zzve) {
        ((zzcst) this.zzgrp.zzgqp).zzc(zzve);
    }
}

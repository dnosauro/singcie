package com.google.android.gms.internal.ads;

public final class zzckg implements zzbrz, zzbtj, zzbui {
    private final zzcko zzgkd;
    private final zzckv zzgke;

    public zzckg(zzcko zzcko, zzckv zzckv) {
        this.zzgkd = zzcko;
        this.zzgke = zzckv;
    }

    public final void onAdLoaded() {
        this.zzgkd.zzrx().put("action", "loaded");
        this.zzgke.zzo(this.zzgkd.zzrx());
    }

    public final void zzb(zzdnj zzdnj) {
        this.zzgkd.zzc(zzdnj);
    }

    public final void zzd(zzatl zzatl) {
        this.zzgkd.zzi(zzatl.zzdvx);
    }

    public final void zzk(zzve zzve) {
        this.zzgkd.zzrx().put("action", "ftl");
        this.zzgkd.zzrx().put("ftl", String.valueOf(zzve.errorCode));
        this.zzgkd.zzrx().put("ed", zzve.zzcgt);
        this.zzgke.zzo(this.zzgkd.zzrx());
    }
}

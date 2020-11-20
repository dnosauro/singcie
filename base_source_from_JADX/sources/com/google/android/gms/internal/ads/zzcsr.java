package com.google.android.gms.internal.ads;

final class zzcsr implements zzdyo<zzbme> {
    private final /* synthetic */ zzcsq zzgry;

    zzcsr(zzcsq zzcsq) {
        this.zzgry = zzcsq;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbme) obj).zzajj();
    }

    public final void zzb(Throwable th) {
        zzve zze = this.zzgry.zzgrw.zzagh().zze(th);
        this.zzgry.zzfzd.zzk(zze);
        zzdob.zza(zze.errorCode, th, "DelayedBannerAd.onFailure");
    }
}

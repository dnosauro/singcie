package com.google.android.gms.internal.ads;

final class zzcgq implements zzdyo<zzbdv> {
    private final /* synthetic */ zzdmu zzghq;
    private final /* synthetic */ zzdmz zzghr;

    zzcgq(zzcgh zzcgh, zzdmu zzdmu, zzdmz zzdmz) {
        this.zzghq = zzdmu;
        this.zzghr = zzdmz;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbdv) obj).zza(this.zzghq, this.zzghr);
    }

    public final void zzb(Throwable th) {
    }
}

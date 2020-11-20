package com.google.android.gms.internal.ads;

final class zzboq implements zzdyo<zzboi> {
    private final /* synthetic */ zzdyo zzfve;
    private final /* synthetic */ zzboj zzfvf;

    zzboq(zzboj zzboj, zzdyo zzdyo) {
        this.zzfvf = zzboj;
        this.zzfve = zzdyo;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfvf.zza(((zzboi) obj).zzfuy, this.zzfve);
    }

    public final void zzb(Throwable th) {
        this.zzfve.zzb(th);
        this.zzfvf.zzakc();
    }
}

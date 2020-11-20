package com.google.android.gms.internal.ads;

final class zzbop implements zzdyo<zzboc> {
    private final /* synthetic */ zzdyo zzfve;
    private final /* synthetic */ zzboj zzfvf;

    zzbop(zzboj zzboj, zzdyo zzdyo) {
        this.zzfvf = zzboj;
        this.zzfve = zzdyo;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfvf.zzakc();
        this.zzfve.onSuccess((zzboc) obj);
    }

    public final void zzb(Throwable th) {
        this.zzfvf.zzakc();
        this.zzfve.zzb(th);
    }
}

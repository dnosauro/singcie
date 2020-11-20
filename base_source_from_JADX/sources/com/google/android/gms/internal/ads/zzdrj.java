package com.google.android.gms.internal.ads;

final class zzdrj implements zzdyo<O> {
    private final /* synthetic */ zzdqx zzhnx;
    private final /* synthetic */ zzdrg zzhny;

    zzdrj(zzdrg zzdrg, zzdqx zzdqx) {
        this.zzhny = zzdrg;
        this.zzhnx = zzdqx;
    }

    public final void onSuccess(O o) {
        this.zzhny.zzhns.zzhnq.zzc(this.zzhnx);
    }

    public final void zzb(Throwable th) {
        this.zzhny.zzhns.zzhnq.zza(this.zzhnx, th);
    }
}

package com.google.android.gms.internal.ads;

final class zzds implements zzdtn {
    private final /* synthetic */ zzdsi zzwa;

    zzds(zzdsi zzdsi) {
        this.zzwa = zzdsi;
    }

    public final void zza(int i, long j) {
        this.zzwa.zzh(i, System.currentTimeMillis() - j);
    }

    public final void zza(int i, long j, String str) {
        this.zzwa.zzb(i, System.currentTimeMillis() - j, str);
    }
}

package com.google.android.gms.internal.ads;

final class zzcgl implements zzdyo<zzbdv> {
    private final /* synthetic */ String zzeqc;
    private final /* synthetic */ zzahv zzghn;

    zzcgl(zzcgh zzcgh, String str, zzahv zzahv) {
        this.zzeqc = str;
        this.zzghn = zzahv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbdv) obj).zza(this.zzeqc, (zzahv<? super zzbdv>) this.zzghn);
    }

    public final void zzb(Throwable th) {
    }
}

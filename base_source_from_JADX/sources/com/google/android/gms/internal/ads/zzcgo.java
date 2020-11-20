package com.google.android.gms.internal.ads;

final class zzcgo implements zzdyo<zzbdv> {
    private final /* synthetic */ String zzeqc;
    private final /* synthetic */ zzahv zzghn;

    zzcgo(zzcgh zzcgh, String str, zzahv zzahv) {
        this.zzeqc = str;
        this.zzghn = zzahv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbdv) obj).zzb(this.zzeqc, this.zzghn);
    }

    public final void zzb(Throwable th) {
    }
}

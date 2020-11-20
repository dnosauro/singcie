package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzcgn implements zzdyo<zzbdv> {
    private final /* synthetic */ String zzgho;
    private final /* synthetic */ Map zzghp;

    zzcgn(zzcgh zzcgh, String str, Map map) {
        this.zzgho = str;
        this.zzghp = map;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        ((zzbdv) obj).zza(this.zzgho, this.zzghp);
    }

    public final void zzb(Throwable th) {
    }
}

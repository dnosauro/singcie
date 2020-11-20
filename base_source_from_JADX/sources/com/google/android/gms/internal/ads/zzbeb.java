package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

final class zzbeb implements zzdyo<Map<String, String>> {
    private final /* synthetic */ zzbdu zzepy;
    private final /* synthetic */ List zzeqb;
    private final /* synthetic */ String zzeqc;

    zzbeb(zzbdu zzbdu, List list, String str) {
        this.zzepy = zzbdu;
        this.zzeqb = list;
        this.zzeqc = str;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzepy.zza((Map<String, String>) (Map) obj, (List<zzahv<? super zzbdv>>) this.zzeqb, this.zzeqc);
    }

    public final void zzb(Throwable th) {
    }
}

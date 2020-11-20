package com.google.android.gms.internal.ads;

import java.util.HashMap;

final /* synthetic */ class zzcfq implements zzqu {
    private final zzbdv zzesw;

    zzcfq(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    public final void zza(zzqv zzqv) {
        zzbdv zzbdv = this.zzesw;
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", zzqv.zzbqz ? "1" : "0");
        zzbdv.zza("onAdVisibilityChanged", hashMap);
    }
}

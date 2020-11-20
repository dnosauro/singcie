package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

final /* synthetic */ class zzzi implements InitializationStatus {
    private final zzzd zzckk;

    zzzi(zzzd zzzd) {
        this.zzckk = zzzd;
    }

    public final Map getAdapterStatusMap() {
        zzzd zzzd = this.zzckk;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzzh(zzzd));
        return hashMap;
    }
}

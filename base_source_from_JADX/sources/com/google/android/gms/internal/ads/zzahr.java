package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzahr implements zzahv<zzbdv> {
    zzahr() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbdv.zzkm();
        } else if ("resume".equals(str)) {
            zzbdv.zzkn();
        }
    }
}

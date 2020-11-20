package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzaht implements zzahv<zzbdv> {
    zzaht() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map.keySet().contains("start")) {
            zzbdv.zzbb(true);
        }
        if (map.keySet().contains("stop")) {
            zzbdv.zzbb(false);
        }
    }
}

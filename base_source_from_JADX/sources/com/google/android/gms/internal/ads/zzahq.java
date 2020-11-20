package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzahq implements zzahv<zzbdv> {
    zzahq() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map.keySet().contains("start")) {
            zzbdv.zzacs().zzacf();
        } else if (map.keySet().contains("stop")) {
            zzbdv.zzacs().zzacg();
        } else if (map.keySet().contains("cancel")) {
            zzbdv.zzacs().zzach();
        }
    }
}

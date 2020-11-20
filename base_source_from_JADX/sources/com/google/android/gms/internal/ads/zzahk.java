package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

final class zzahk implements zzahv<zzbdv> {
    zzahk() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzst;
        zzbdv zzbdv = (zzbdv) obj;
        zzadx zzadd = zzbdv.zzadd();
        if (zzadd == null || (zzst = zzadd.zzst()) == null) {
            zzbdv.zzb("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzbdv.zzb("nativeAdViewSignalsReady", zzst);
        }
    }
}

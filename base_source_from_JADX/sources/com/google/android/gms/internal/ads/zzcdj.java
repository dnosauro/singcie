package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

final /* synthetic */ class zzcdj implements zzahv {
    private final zzcdi zzgex;

    zzcdj(zzcdi zzcdi) {
        this.zzgex = zzcdi;
    }

    public final void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        zzbdv.zzacs().zza((zzbfj) new zzcdo(this.zzgex, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbdv.loadData(str, "text/html", "UTF-8");
        } else {
            zzbdv.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

final class zzben implements zzahv<zzbdv> {
    private final /* synthetic */ zzbel zzesm;

    zzben(zzbel zzbel) {
        this.zzesm = zzbel;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzesm) {
                        if (this.zzesm.zzesd != parseInt) {
                            int unused = this.zzesm.zzesd = parseInt;
                            this.zzesm.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzd.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

final class zzbfx implements zzahv<zzbdv> {
    private final /* synthetic */ zzbfv zzeti;

    zzbfx(zzbfv zzbfv) {
        this.zzeti = zzbfv;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbdv zzbdv = (zzbdv) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzeti) {
                        if (this.zzeti.zzesd != parseInt) {
                            int unused = this.zzeti.zzesd = parseInt;
                            this.zzeti.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzd.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}

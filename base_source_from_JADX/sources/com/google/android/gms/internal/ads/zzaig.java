package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

public final class zzaig implements zzahv<Object> {
    private final zzaij zzdhg;

    private zzaig(zzaij zzaij) {
        this.zzdhg = zzaij;
    }

    public static void zza(zzbdv zzbdv, zzaij zzaij) {
        zzbdv.zza("/reward", (zzahv<? super zzbdv>) new zzaig(zzaij));
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzava zzava = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzava = new zzava(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzd.zzd("Unable to parse reward amount.", e);
            }
            this.zzdhg.zza(zzava);
        } else if ("video_start".equals(str)) {
            this.zzdhg.zztl();
        } else if ("video_complete".equals(str)) {
            this.zzdhg.zztm();
        }
    }
}

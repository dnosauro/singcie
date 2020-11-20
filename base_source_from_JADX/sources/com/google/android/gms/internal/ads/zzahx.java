package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

public final class zzahx implements zzahv<Object> {
    private final Context context;

    public zzahx(Context context2) {
        this.context = context2;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzp.zzlo().zzz(this.context)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            switch (c) {
                case 0:
                    zzp.zzlo().zzg(this.context, str2);
                    return;
                case 1:
                    zzp.zzlo().zzh(this.context, str2);
                    return;
                case 2:
                    zzp.zzlo().zzj(this.context, str2);
                    return;
                default:
                    zzd.zzey("logScionEvent gmsg contained unsupported eventName");
                    return;
            }
        }
    }
}

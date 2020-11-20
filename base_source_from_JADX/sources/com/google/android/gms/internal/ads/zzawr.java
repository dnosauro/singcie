package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

public final class zzawr {
    public static boolean isEnabled() {
        return zzadh.zzddl.get().booleanValue();
    }

    public static void zzeb(String str) {
        if (zzadh.zzddl.get().booleanValue()) {
            zzd.zzeb(str);
        }
    }
}

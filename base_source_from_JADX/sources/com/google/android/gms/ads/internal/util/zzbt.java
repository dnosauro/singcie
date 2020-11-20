package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;

@TargetApi(17)
public final class zzbt {
    private static zzbt zzefj;
    String zzefk;

    private zzbt() {
    }

    public static zzbt zzyy() {
        if (zzefj == null) {
            zzefj = new zzbt();
        }
        return zzefj;
    }
}

package com.google.android.gms.internal.ads;

import android.os.Trace;

public final class zzpq {
    public static void beginSection(String str) {
        if (zzpt.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzpt.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}

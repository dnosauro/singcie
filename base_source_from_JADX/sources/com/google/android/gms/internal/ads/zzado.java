package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzado {
    private static final AtomicReference<zzadp> zzddy = new AtomicReference<>();
    static final AtomicBoolean zzddz = new AtomicBoolean();

    public static void zza(zzadp zzadp) {
        zzddy.set(zzadp);
    }

    static zzadp zzsl() {
        return zzddy.get();
    }
}

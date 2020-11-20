package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdae implements zzdfi<Object> {
    private final Executor executor;
    private final zzdyz<String> zzgyg;

    public zzdae(zzdyz<String> zzdyz, Executor executor2) {
        this.zzgyg = zzdyz;
        this.executor = executor2;
    }

    public final zzdyz<Object> zzasm() {
        return zzdyr.zzb(this.zzgyg, zzdah.zzbon, this.executor);
    }
}

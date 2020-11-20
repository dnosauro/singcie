package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzbrc implements Callable {
    private final zzbqz zzfxg;
    private final zzdyz zzfxh;

    zzbrc(zzbqz zzbqz, zzdyz zzdyz) {
        this.zzfxg = zzbqz;
        this.zzfxh = zzdyz;
    }

    public final Object call() {
        return this.zzfxg.zzc(this.zzfxh);
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcpc implements Callable {
    private final zzdyz zzfvd;
    private final zzdyz zzfxh;
    private final zzcou zzgof;

    zzcpc(zzcou zzcou, zzdyz zzdyz, zzdyz zzdyz2) {
        this.zzgof = zzcou;
        this.zzfxh = zzdyz;
        this.zzfvd = zzdyz2;
    }

    public final Object call() {
        return this.zzgof.zza(this.zzfxh, this.zzfvd);
    }
}

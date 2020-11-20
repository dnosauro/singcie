package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzcov implements Callable {
    private final zzdyz zzfxh;
    private final zzdyz zzggs;

    zzcov(zzdyz zzdyz, zzdyz zzdyz2) {
        this.zzggs = zzdyz;
        this.zzfxh = zzdyz2;
    }

    public final Object call() {
        zzdyz zzdyz = this.zzggs;
        zzdyz zzdyz2 = this.zzfxh;
        return new zzcpi((zzcpl) zzdyz.get(), ((zzcpf) zzdyz2.get()).zzgoi, ((zzcpf) zzdyz2.get()).zzgoh);
    }
}

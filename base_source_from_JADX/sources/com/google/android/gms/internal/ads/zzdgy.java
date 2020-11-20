package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzdgy implements Callable {
    private final zzdyz zzfxh;
    private final zzdyz zzggs;

    zzdgy(zzdyz zzdyz, zzdyz zzdyz2) {
        this.zzggs = zzdyz;
        this.zzfxh = zzdyz2;
    }

    public final Object call() {
        return new zzdgw((String) this.zzggs.get(), (String) this.zzfxh.get());
    }
}

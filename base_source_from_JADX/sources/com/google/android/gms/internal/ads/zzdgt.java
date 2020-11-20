package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final /* synthetic */ class zzdgt implements Callable {
    private final zzdgq zzhcl;

    zzdgt(zzdgq zzdgq) {
        this.zzhcl = zzdgq;
    }

    public final Object call() {
        zzdgq zzdgq = this.zzhcl;
        return new zzdgr(zzdgq.zzhcj.zzf(zzdgq.context));
    }
}

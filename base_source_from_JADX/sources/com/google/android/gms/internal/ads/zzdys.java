package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzdys<V> {
    private final boolean zzhwv;
    private final zzdwm<zzdyz<? extends V>> zzhxm;

    private zzdys(boolean z, zzdwm<zzdyz<? extends V>> zzdwm) {
        this.zzhwv = z;
        this.zzhxm = zzdwm;
    }

    /* synthetic */ zzdys(boolean z, zzdwm zzdwm, zzdyq zzdyq) {
        this(z, zzdwm);
    }

    public final <C> zzdyz<C> zza(Callable<C> callable, Executor executor) {
        return new zzdyf(this.zzhxm, this.zzhwv, executor, callable);
    }
}

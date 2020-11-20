package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class zzdye extends zzdyh<V> {
    private final Callable<V> zzhxf;
    private final /* synthetic */ zzdyf zzhxg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdye(zzdyf zzdyf, Callable<V> callable, Executor executor) {
        super(zzdyf, executor);
        this.zzhxg = zzdyf;
        this.zzhxf = (Callable) zzdvv.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    public final void setValue(V v) {
        this.zzhxg.set(v);
    }

    /* access modifiers changed from: package-private */
    public final V zzazk() {
        return this.zzhxf.call();
    }

    /* access modifiers changed from: package-private */
    public final String zzazl() {
        return this.zzhxf.toString();
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class zzdzq extends zzdyy<V> {
    private final Callable<V> zzhxf;
    private final /* synthetic */ zzdzo zzhyd;

    zzdzq(zzdzo zzdzo, Callable<V> callable) {
        this.zzhyd = zzdzo;
        this.zzhxf = (Callable) zzdvv.checkNotNull(callable);
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzhyd.isDone();
    }

    /* access modifiers changed from: package-private */
    public final V zzazk() {
        return this.zzhxf.call();
    }

    /* access modifiers changed from: package-private */
    public final String zzazl() {
        return this.zzhxf.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzhyd.set(v);
        } else {
            this.zzhyd.setException(th);
        }
    }
}

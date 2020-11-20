package com.google.android.gms.internal.ads;

import java.lang.Throwable;

final class zzdxm<V, X extends Throwable> extends zzdxn<V, X, zzdyb<? super X, ? extends V>, zzdyz<? extends V>> {
    zzdxm(zzdyz<? extends V> zzdyz, Class<X> cls, zzdyb<? super X, ? extends V> zzdyb) {
        super(zzdyz, cls, zzdyb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdyz) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj, Throwable th) {
        zzdyb zzdyb = (zzdyb) obj;
        zzdyz zzf = zzdyb.zzf(th);
        zzdvv.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyb);
        return zzf;
    }
}

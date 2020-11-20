package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdxp<V, X extends Throwable> extends zzdxn<V, X, zzdvm<? super X, ? extends V>, V> {
    zzdxp(zzdyz<? extends V> zzdyz, Class<X> cls, zzdvm<? super X, ? extends V> zzdvm) {
        super(zzdyz, cls, zzdvm);
    }

    /* access modifiers changed from: package-private */
    public final void setResult(@NullableDecl V v) {
        set(v);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* synthetic */ Object zza(Object obj, Throwable th) {
        return ((zzdvm) obj).apply(th);
    }
}

package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdxs<I, O> extends zzdxq<I, O, zzdvm<? super I, ? extends O>, O> {
    zzdxs(zzdyz<? extends I> zzdyz, zzdvm<? super I, ? extends O> zzdvm) {
        super(zzdyz, zzdvm);
    }

    /* access modifiers changed from: package-private */
    public final void setResult(@NullableDecl O o) {
        set(o);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) {
        return ((zzdvm) obj).apply(obj2);
    }
}

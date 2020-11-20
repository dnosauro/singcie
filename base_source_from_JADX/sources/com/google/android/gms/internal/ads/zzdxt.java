package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdxt<I, O> extends zzdxq<I, O, zzdyb<? super I, ? extends O>, zzdyz<? extends O>> {
    zzdxt(zzdyz<? extends I> zzdyz, zzdyb<? super I, ? extends O> zzdyb) {
        super(zzdyz, zzdyb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdyz) obj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) {
        zzdyb zzdyb = (zzdyb) obj;
        zzdyz zzf = zzdyb.zzf(obj2);
        zzdvv.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyb);
        return zzf;
    }
}

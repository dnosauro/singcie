package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdxa<K> extends zzdwt<K> {
    private final transient zzdwm<K> zzhuw;
    private final transient zzdwq<K, ?> zzhvi;

    zzdxa(zzdwq<K, ?> zzdwq, zzdwm<K> zzdwm) {
        this.zzhvi = zzdwq;
        this.zzhuw = zzdwm;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzhvi.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.zzhvi.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzayt().zza(objArr, i);
    }

    public final zzdxh<K> zzayp() {
        return (zzdxh) zzayt().iterator();
    }

    public final zzdwm<K> zzayt() {
        return this.zzhuw;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzayu() {
        return true;
    }
}

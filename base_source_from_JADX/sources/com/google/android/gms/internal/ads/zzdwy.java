package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzdwy<K, V> extends zzdwt<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzdwq<K, V> zzhvi;
    /* access modifiers changed from: private */
    public final transient Object[] zzhvj;
    private final transient int zzhvk = 0;

    zzdwy(zzdwq<K, V> zzdwq, Object[] objArr, int i, int i2) {
        this.zzhvi = zzdwq;
        this.zzhvj = objArr;
        this.size = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.zzhvi.get(key));
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzayt().zza(objArr, i);
    }

    public final zzdxh<Map.Entry<K, V>> zzayp() {
        return (zzdxh) zzayt().iterator();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzayu() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final zzdwm<Map.Entry<K, V>> zzazb() {
        return new zzdxb(this);
    }
}

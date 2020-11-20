package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p172io.FileUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdwq<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzhux = new Map.Entry[0];
    private transient zzdwt<Map.Entry<K, V>> zzhuy;
    private transient zzdwt<K> zzhuz;
    private transient zzdwl<V> zzhva;

    zzdwq() {
    }

    public static <K, V> zzdwq<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        zzdwg.zzb(k, v);
        zzdwg.zzb(k2, v2);
        zzdwg.zzb(k3, v3);
        zzdwg.zzb(k4, v4);
        return zzdwz.zzc(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> zzdwq<K, V> zzc(K k, V v) {
        zzdwg.zzb(k, v);
        return zzdwz.zzc(1, new Object[]{k, v});
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdwl) values()).contains(obj);
    }

    public /* synthetic */ Set entrySet() {
        zzdwt<Map.Entry<K, V>> zzdwt = this.zzhuy;
        if (zzdwt != null) {
            return zzdwt;
        }
        zzdwt<Map.Entry<K, V>> zzayw = zzayw();
        this.zzhuy = zzayw;
        return zzayw;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract V get(@NullableDecl Object obj);

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public int hashCode() {
        return zzdxf.zzg((zzdwt) entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Set keySet() {
        zzdwt<K> zzdwt = this.zzhuz;
        if (zzdwt != null) {
            return zzdwt;
        }
        zzdwt<K> zzayx = zzayx();
        this.zzhuz = zzayx;
        return zzayx;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        zzdwg.zzh(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, FileUtils.ONE_GB));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ Collection values() {
        zzdwl<V> zzdwl = this.zzhva;
        if (zzdwl != null) {
            return zzdwl;
        }
        zzdwl<V> zzayy = zzayy();
        this.zzhva = zzayy;
        return zzayy;
    }

    /* access modifiers changed from: package-private */
    public abstract zzdwt<Map.Entry<K, V>> zzayw();

    /* access modifiers changed from: package-private */
    public abstract zzdwt<K> zzayx();

    /* access modifiers changed from: package-private */
    public abstract zzdwl<V> zzayy();
}

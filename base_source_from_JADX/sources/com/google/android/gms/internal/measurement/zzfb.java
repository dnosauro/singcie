package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.p172io.FileUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzfb<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zza = new Map.Entry[0];
    private transient zzff<Map.Entry<K, V>> zzb;
    private transient zzff<K> zzc;
    private transient zzex<V> zzd;

    zzfb() {
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzex) values()).contains(obj);
    }

    public /* synthetic */ Set entrySet() {
        zzff<Map.Entry<K, V>> zzff = this.zzb;
        if (zzff != null) {
            return zzff;
        }
        zzff<Map.Entry<K, V>> zza2 = zza();
        this.zzb = zza2;
        return zza2;
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
        return zzfq.zza((zzff) entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Set keySet() {
        zzff<K> zzff = this.zzc;
        if (zzff != null) {
            return zzff;
        }
        zzff<K> zzb2 = zzb();
        this.zzc = zzb2;
        return zzb2;
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
        if (size >= 0) {
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
        StringBuilder sb2 = new StringBuilder(String.valueOf("size").length() + 40);
        sb2.append("size");
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public /* synthetic */ Collection values() {
        zzex<V> zzex = this.zzd;
        if (zzex != null) {
            return zzex;
        }
        zzex<V> zzc2 = zzc();
        this.zzd = zzc2;
        return zzc2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzff<Map.Entry<K, V>> zza();

    /* access modifiers changed from: package-private */
    public abstract zzff<K> zzb();

    /* access modifiers changed from: package-private */
    public abstract zzex<V> zzc();
}

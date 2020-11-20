package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzemx implements Comparable<zzemx>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzems zzirr;
    private final K zzirv;

    zzemx(zzems zzems, K k, V v) {
        this.zzirr = zzems;
        this.zzirv = k;
        this.value = v;
    }

    zzemx(zzems zzems, Map.Entry<K, V> entry) {
        this(zzems, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzemx) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzirv, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzirv;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        K k = this.zzirv;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzirr.zzbka();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzirv);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}

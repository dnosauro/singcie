package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzemz extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzems zzirr;

    private zzemz(zzems zzems) {
        this.zzirr = zzems;
    }

    /* synthetic */ zzemz(zzems zzems, zzemr zzemr) {
        this(zzems);
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzirr.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzirr.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzirr.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzena(this.zzirr, (zzemr) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzirr.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzirr.size();
    }
}

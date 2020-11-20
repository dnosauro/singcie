package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzems<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzikn;
    private final int zzirl;
    /* access modifiers changed from: private */
    public List<zzemx> zzirm;
    /* access modifiers changed from: private */
    public Map<K, V> zzirn;
    private volatile zzemz zziro;
    /* access modifiers changed from: private */
    public Map<K, V> zzirp;
    private volatile zzemt zzirq;

    private zzems(int i) {
        this.zzirl = i;
        this.zzirm = Collections.emptyList();
        this.zzirn = Collections.emptyMap();
        this.zzirp = Collections.emptyMap();
    }

    /* synthetic */ zzems(int i, zzemr zzemr) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzirm.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzirm.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzirm.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* access modifiers changed from: private */
    public final void zzbka() {
        if (this.zzikn) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzbkb() {
        zzbka();
        if (this.zzirn.isEmpty() && !(this.zzirn instanceof TreeMap)) {
            this.zzirn = new TreeMap();
            this.zzirp = ((TreeMap) this.zzirn).descendingMap();
        }
        return (SortedMap) this.zzirn;
    }

    static <FieldDescriptorType extends zzejz<FieldDescriptorType>> zzems<FieldDescriptorType, Object> zzhs(int i) {
        return new zzemr(i);
    }

    /* access modifiers changed from: private */
    public final V zzhu(int i) {
        zzbka();
        V value = this.zzirm.remove(i).getValue();
        if (!this.zzirn.isEmpty()) {
            Iterator it = zzbkb().entrySet().iterator();
            this.zzirm.add(new zzemx(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        zzbka();
        if (!this.zzirm.isEmpty()) {
            this.zzirm.clear();
        }
        if (!this.zzirn.isEmpty()) {
            this.zzirn.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzirn.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zziro == null) {
            this.zziro = new zzemz(this, (zzemr) null);
        }
        return this.zziro;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzems)) {
            return super.equals(obj);
        }
        zzems zzems = (zzems) obj;
        int size = size();
        if (size != zzems.size()) {
            return false;
        }
        int zzbjx = zzbjx();
        if (zzbjx != zzems.zzbjx()) {
            return entrySet().equals(zzems.entrySet());
        }
        for (int i = 0; i < zzbjx; i++) {
            if (!zzht(i).equals(zzems.zzht(i))) {
                return false;
            }
        }
        if (zzbjx != size) {
            return this.zzirn.equals(zzems.zzirn);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzirm.get(zza).getValue() : this.zzirn.get(comparable);
    }

    public int hashCode() {
        int zzbjx = zzbjx();
        int i = 0;
        for (int i2 = 0; i2 < zzbjx; i2++) {
            i += this.zzirm.get(i2).hashCode();
        }
        return this.zzirn.size() > 0 ? i + this.zzirn.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzikn;
    }

    public V remove(Object obj) {
        zzbka();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzhu(zza);
        }
        if (this.zzirn.isEmpty()) {
            return null;
        }
        return this.zzirn.remove(comparable);
    }

    public int size() {
        return this.zzirm.size() + this.zzirn.size();
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzbka();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzirm.get(zza).setValue(v);
        }
        zzbka();
        if (this.zzirm.isEmpty() && !(this.zzirm instanceof ArrayList)) {
            this.zzirm = new ArrayList(this.zzirl);
        }
        int i = -(zza + 1);
        if (i >= this.zzirl) {
            return zzbkb().put(k, v);
        }
        int size = this.zzirm.size();
        int i2 = this.zzirl;
        if (size == i2) {
            zzemx remove = this.zzirm.remove(i2 - 1);
            zzbkb().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzirm.add(i, new zzemx(this, k, v));
        return null;
    }

    public void zzbfl() {
        if (!this.zzikn) {
            this.zzirn = this.zzirn.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzirn);
            this.zzirp = this.zzirp.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzirp);
            this.zzikn = true;
        }
    }

    public final int zzbjx() {
        return this.zzirm.size();
    }

    public final Iterable<Map.Entry<K, V>> zzbjy() {
        return this.zzirn.isEmpty() ? zzemw.zzbkd() : this.zzirn.entrySet();
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzbjz() {
        if (this.zzirq == null) {
            this.zzirq = new zzemt(this, (zzemr) null);
        }
        return this.zzirq;
    }

    public final Map.Entry<K, V> zzht(int i) {
        return this.zzirm.get(i);
    }
}

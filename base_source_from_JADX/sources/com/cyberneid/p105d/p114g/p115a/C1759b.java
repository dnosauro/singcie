package com.cyberneid.p105d.p114g.p115a;

import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.g.a.b */
public class C1759b<K, V> implements Map<K, V> {

    /* renamed from: a */
    private final C1607d f5729a;

    /* renamed from: b */
    private final Map<K, V> f5730b;

    public C1759b(Map<K, V> map, C1607d dVar) {
        this.f5730b = map;
        this.f5729a = dVar;
    }

    public void clear() {
        this.f5729a.mo7535b();
        this.f5730b.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f5729a.mo7540c().contains(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f5730b.containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.unmodifiableSet(this.f5730b.entrySet());
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1759b) {
            return ((C1759b) obj).f5729a.equals(this.f5729a);
        }
        return false;
    }

    public V get(Object obj) {
        return this.f5730b.get(obj);
    }

    public int hashCode() {
        return this.f5729a.hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> keySet() {
        return this.f5730b.keySet();
    }

    public V put(K k, V v) {
        this.f5729a.mo7521a(C1613i.m6461a((String) k), ((C1760c) v).mo7505d());
        return this.f5730b.put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        throw new RuntimeException("Not yet implemented");
    }

    public V remove(Object obj) {
        this.f5729a.mo7553j(C1613i.m6461a((String) obj));
        return this.f5730b.remove(obj);
    }

    public int size() {
        return this.f5729a.mo7511a();
    }

    public String toString() {
        return this.f5730b.toString();
    }

    public Collection<V> values() {
        return this.f5730b.values();
    }
}

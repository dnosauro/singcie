package com.parse;

import java.lang.ref.WeakReference;
import java.util.HashMap;

class WeakValueHashMap<K, V> {
    private HashMap<K, WeakReference<V>> map = new HashMap<>();

    public void clear() {
        this.map.clear();
    }

    public V get(K k) {
        WeakReference weakReference = this.map.get(k);
        if (weakReference == null) {
            return null;
        }
        V v = weakReference.get();
        if (v == null) {
            this.map.remove(k);
        }
        return v;
    }

    public void put(K k, V v) {
        this.map.put(k, new WeakReference(v));
    }

    public void remove(K k) {
        this.map.remove(k);
    }
}

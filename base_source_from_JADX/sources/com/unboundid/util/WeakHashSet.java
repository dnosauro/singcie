package com.unboundid.util;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class WeakHashSet<T> implements Set<T> {

    /* renamed from: m */
    private final WeakHashMap<T, WeakReference<T>> f7274m;

    public WeakHashSet() {
        this.f7274m = new WeakHashMap<>(16);
    }

    public WeakHashSet(int i) {
        this.f7274m = new WeakHashMap<>(i);
    }

    public boolean add(T t) {
        if (this.f7274m.containsKey(t)) {
            return false;
        }
        this.f7274m.put(t, new WeakReference(t));
        return true;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean z = false;
        for (Object next : collection) {
            if (!this.f7274m.containsKey(next)) {
                this.f7274m.put(next, new WeakReference(next));
                z = true;
            }
        }
        return z;
    }

    public T addAndGet(T t) {
        T t2;
        WeakReference weakReference = this.f7274m.get(t);
        if (weakReference != null && (t2 = weakReference.get()) != null) {
            return t2;
        }
        this.f7274m.put(t, new WeakReference(t));
        return t;
    }

    public void clear() {
        this.f7274m.clear();
    }

    public boolean contains(Object obj) {
        return this.f7274m.containsKey(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f7274m.keySet().containsAll(collection);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Set) && this.f7274m.keySet().equals(obj);
    }

    public T get(T t) {
        WeakReference weakReference = this.f7274m.get(t);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int hashCode() {
        return this.f7274m.keySet().hashCode();
    }

    public boolean isEmpty() {
        return this.f7274m.isEmpty();
    }

    public Iterator<T> iterator() {
        return this.f7274m.keySet().iterator();
    }

    public boolean remove(Object obj) {
        return this.f7274m.remove(obj) != null;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            if (this.f7274m.remove(remove) != null) {
                z = true;
            }
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        Iterator<Map.Entry<T, WeakReference<T>>> it = this.f7274m.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next().getKey())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f7274m.size();
    }

    public Object[] toArray() {
        return this.f7274m.keySet().toArray();
    }

    public <E> E[] toArray(E[] eArr) {
        return this.f7274m.keySet().toArray(eArr);
    }

    public String toString() {
        return this.f7274m.keySet().toString();
    }
}

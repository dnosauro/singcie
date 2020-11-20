package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzeio<E> extends AbstractList<E> implements zzekp<E> {
    private boolean zziin = true;

    zzeio() {
    }

    public void add(int i, E e) {
        zzbfm();
        super.add(i, e);
    }

    public boolean add(E e) {
        zzbfm();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzbfm();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzbfm();
        return super.addAll(collection);
    }

    public void clear() {
        zzbfm();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        zzbfm();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzbfm();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzbfm();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzbfm();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzbfm();
        return super.set(i, e);
    }

    public boolean zzbfk() {
        return this.zziin;
    }

    public final void zzbfl() {
        this.zziin = false;
    }

    /* access modifiers changed from: protected */
    public final void zzbfm() {
        if (!this.zziin) {
            throw new UnsupportedOperationException();
        }
    }
}

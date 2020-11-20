package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzeov<E> extends AbstractList<E> {
    private static final zzeox zzcz = zzeox.zzn(zzeov.class);
    List<E> zziyj;
    Iterator<E> zziyk;

    public zzeov(List<E> list, Iterator<E> it) {
        this.zziyj = list;
        this.zziyk = it;
    }

    public E get(int i) {
        if (this.zziyj.size() > i) {
            return this.zziyj.get(i);
        }
        if (this.zziyk.hasNext()) {
            this.zziyj.add(this.zziyk.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new zzeoy(this);
    }

    public int size() {
        zzcz.zzii("potentially expensive size() call");
        zzcz.zzii("blowup running");
        while (this.zziyk.hasNext()) {
            this.zziyj.add(this.zziyk.next());
        }
        return this.zziyj.size();
    }
}

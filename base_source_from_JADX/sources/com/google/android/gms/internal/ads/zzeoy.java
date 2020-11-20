package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

final class zzeoy implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzeov zziyl;

    zzeoy(zzeov zzeov) {
        this.zziyl = zzeov;
    }

    public final boolean hasNext() {
        return this.pos < this.zziyl.zziyj.size() || this.zziyl.zziyk.hasNext();
    }

    public final E next() {
        while (this.pos >= this.zziyl.zziyj.size()) {
            this.zziyl.zziyj.add(this.zziyl.zziyk.next());
        }
        List<E> list = this.zziyl.zziyj;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

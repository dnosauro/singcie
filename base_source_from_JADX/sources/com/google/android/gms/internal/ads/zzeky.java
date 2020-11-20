package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzeky<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zziox;

    public zzeky(Iterator<Map.Entry<K, Object>> it) {
        this.zziox = it;
    }

    public final boolean hasNext() {
        return this.zziox.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zziox.next();
        return next.getValue() instanceof zzekt ? new zzekv(next) : next;
    }

    public final void remove() {
        this.zziox.remove();
    }
}

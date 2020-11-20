package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzemu implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzems zzirr;
    private Iterator<Map.Entry<K, V>> zzirs;

    private zzemu(zzems zzems) {
        this.zzirr = zzems;
        this.pos = this.zzirr.zzirm.size();
    }

    /* synthetic */ zzemu(zzems zzems, zzemr zzemr) {
        this(zzems);
    }

    private final Iterator<Map.Entry<K, V>> zzbkc() {
        if (this.zzirs == null) {
            this.zzirs = this.zzirr.zzirp.entrySet().iterator();
        }
        return this.zzirs;
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzirr.zzirm.size()) || zzbkc().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object obj;
        if (zzbkc().hasNext()) {
            obj = zzbkc().next();
        } else {
            List zzb = this.zzirr.zzirm;
            int i = this.pos - 1;
            this.pos = i;
            obj = zzb.get(i);
        }
        return (Map.Entry) obj;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

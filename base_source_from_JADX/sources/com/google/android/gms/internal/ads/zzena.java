package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzena implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzems zzirr;
    private Iterator<Map.Entry<K, V>> zzirs;
    private boolean zzirw;

    private zzena(zzems zzems) {
        this.zzirr = zzems;
        this.pos = -1;
    }

    /* synthetic */ zzena(zzems zzems, zzemr zzemr) {
        this(zzems);
    }

    private final Iterator<Map.Entry<K, V>> zzbkc() {
        if (this.zzirs == null) {
            this.zzirs = this.zzirr.zzirn.entrySet().iterator();
        }
        return this.zzirs;
    }

    public final boolean hasNext() {
        return this.pos + 1 < this.zzirr.zzirm.size() || (!this.zzirr.zzirn.isEmpty() && zzbkc().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzirw = true;
        int i = this.pos + 1;
        this.pos = i;
        return (Map.Entry) (i < this.zzirr.zzirm.size() ? this.zzirr.zzirm.get(this.pos) : zzbkc().next());
    }

    public final void remove() {
        if (this.zzirw) {
            this.zzirw = false;
            this.zzirr.zzbka();
            if (this.pos < this.zzirr.zzirm.size()) {
                zzems zzems = this.zzirr;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzems.zzhu(i);
                return;
            }
            zzbkc().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}

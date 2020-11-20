package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzenm implements Iterator<String> {
    private final /* synthetic */ zzenk zzisc;
    private Iterator<String> zzisy = this.zzisc.zzisd.iterator();

    zzenm(zzenk zzenk) {
        this.zzisc = zzenk;
    }

    public final boolean hasNext() {
        return this.zzisy.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzisy.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

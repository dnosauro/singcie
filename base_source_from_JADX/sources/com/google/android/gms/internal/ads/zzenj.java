package com.google.android.gms.internal.ads;

import java.util.ListIterator;

final class zzenj implements ListIterator<String> {
    private final /* synthetic */ int zzhws;
    private ListIterator<String> zzisb = this.zzisc.zzisd.listIterator(this.zzhws);
    private final /* synthetic */ zzenk zzisc;

    zzenj(zzenk zzenk, int i) {
        this.zzisc = zzenk;
        this.zzhws = i;
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zzisb.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzisb.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzisb.next();
    }

    public final int nextIndex() {
        return this.zzisb.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzisb.previous();
    }

    public final int previousIndex() {
        return this.zzisb.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }
}

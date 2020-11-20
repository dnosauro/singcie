package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzenk extends AbstractList<String> implements zzekz, RandomAccess {
    /* access modifiers changed from: private */
    public final zzekz zzisd;

    public zzenk(zzekz zzekz) {
        this.zzisd = zzekz;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzisd.get(i);
    }

    public final Iterator<String> iterator() {
        return new zzenm(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzenj(this, i);
    }

    public final int size() {
        return this.zzisd.size();
    }

    public final void zzak(zzeiu zzeiu) {
        throw new UnsupportedOperationException();
    }

    public final List<?> zzbiu() {
        return this.zzisd.zzbiu();
    }

    public final zzekz zzbiv() {
        return this;
    }

    public final Object zzhi(int i) {
        return this.zzisd.zzhi(i);
    }
}

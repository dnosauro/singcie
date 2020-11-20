package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

public abstract class zzfv<E> extends zzfs<E> implements ListIterator<E> {
    protected zzfv() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}

package com.google.android.gms.internal.measurement;

import java.util.Iterator;

public abstract class zzfs<E> implements Iterator<E> {
    protected zzfs() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

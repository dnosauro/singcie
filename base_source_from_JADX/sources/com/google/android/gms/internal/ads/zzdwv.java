package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzdwv extends zzdxh<T> {
    private boolean zzhve;
    private final /* synthetic */ Object zzhvf;

    zzdwv(Object obj) {
        this.zzhvf = obj;
    }

    public final boolean hasNext() {
        return !this.zzhve;
    }

    public final T next() {
        if (!this.zzhve) {
            this.zzhve = true;
            return this.zzhvf;
        }
        throw new NoSuchElementException();
    }
}

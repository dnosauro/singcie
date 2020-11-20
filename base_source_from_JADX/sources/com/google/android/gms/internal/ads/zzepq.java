package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

public final class zzepq<T> {
    private final List<zzeps<T>> zzizc;
    private final List<zzeps<Collection<T>>> zzizd;

    private zzepq(int i, int i2) {
        this.zzizc = zzepe.zzic(i);
        this.zzizd = zzepe.zzic(i2);
    }

    public final zzepq<T> zzau(zzeps<? extends T> zzeps) {
        this.zzizc.add(zzeps);
        return this;
    }

    public final zzepq<T> zzav(zzeps<? extends Collection<? extends T>> zzeps) {
        this.zzizd.add(zzeps);
        return this;
    }

    public final zzepo<T> zzblv() {
        return new zzepo<>(this.zzizc, this.zzizd);
    }
}

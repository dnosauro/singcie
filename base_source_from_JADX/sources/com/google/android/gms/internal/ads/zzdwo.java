package com.google.android.gms.internal.ads;

final class zzdwo<E> extends zzdwh<E> {
    private final zzdwm<E> zzhuw;

    zzdwo(zzdwm<E> zzdwm, int i) {
        super(zzdwm.size(), i);
        this.zzhuw = zzdwm;
    }

    /* access modifiers changed from: protected */
    public final E get(int i) {
        return this.zzhuw.get(i);
    }
}

package com.google.android.gms.internal.ads;

public abstract class zzeag<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zzhyk;

    public zzeag(Class<PrimitiveT> cls) {
        this.zzhyk = cls;
    }

    public abstract PrimitiveT zzah(KeyT keyt);

    /* access modifiers changed from: package-private */
    public final Class<PrimitiveT> zzazr() {
        return this.zzhyk;
    }
}

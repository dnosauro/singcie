package com.google.android.gms.internal.ads;

public final class zzepd<T> implements zzepf<T> {
    private zzeps<T> zziyw;

    public static <T> void zzbl(zzeps<T> zzeps, zzeps<T> zzeps2) {
        zzepl.checkNotNull(zzeps2);
        zzepd zzepd = (zzepd) zzeps;
        if (zzepd.zziyw == null) {
            zzepd.zziyw = zzeps2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T get() {
        zzeps<T> zzeps = this.zziyw;
        if (zzeps != null) {
            return zzeps.get();
        }
        throw new IllegalStateException();
    }
}

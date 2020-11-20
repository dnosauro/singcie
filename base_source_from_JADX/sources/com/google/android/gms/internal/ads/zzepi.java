package com.google.android.gms.internal.ads;

public final class zzepi<T> implements zzeoz<T>, zzepf<T> {
    private static final zzepi<Object> zziza = new zzepi<>((Object) null);
    private final T zzefg;

    private zzepi(T t) {
        this.zzefg = t;
    }

    public static <T> zzepf<T> zzbb(T t) {
        return new zzepi(zzepl.zza(t, "instance cannot be null"));
    }

    public static <T> zzepf<T> zzbc(T t) {
        return t == null ? zziza : new zzepi(t);
    }

    public final T get() {
        return this.zzefg;
    }
}

package com.google.android.gms.internal.ads;

public final class zzepp<T> implements zzeps<T> {
    private static final Object zziyx = new Object();
    private volatile Object zzefg = zziyx;
    private volatile zzeps<T> zziyy;

    private zzepp(zzeps<T> zzeps) {
        this.zziyy = zzeps;
    }

    public static <P extends zzeps<T>, T> zzeps<T> zzas(P p) {
        return ((p instanceof zzepp) || (p instanceof zzepg)) ? p : new zzepp((zzeps) zzepl.checkNotNull(p));
    }

    public final T get() {
        T t = this.zzefg;
        if (t != zziyx) {
            return t;
        }
        zzeps<T> zzeps = this.zziyy;
        if (zzeps == null) {
            return this.zzefg;
        }
        T t2 = zzeps.get();
        this.zzefg = t2;
        this.zziyy = null;
        return t2;
    }
}

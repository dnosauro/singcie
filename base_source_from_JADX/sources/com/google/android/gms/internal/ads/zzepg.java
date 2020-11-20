package com.google.android.gms.internal.ads;

public final class zzepg<T> implements zzeoz<T>, zzeps<T> {
    private static final Object zziyx = new Object();
    private volatile Object zzefg = zziyx;
    private volatile zzeps<T> zziyy;

    private zzepg(zzeps<T> zzeps) {
        this.zziyy = zzeps;
    }

    public static <P extends zzeps<T>, T> zzeps<T> zzas(P p) {
        zzepl.checkNotNull(p);
        return p instanceof zzepg ? p : new zzepg(p);
    }

    public static <P extends zzeps<T>, T> zzeoz<T> zzat(P p) {
        return p instanceof zzeoz ? (zzeoz) p : new zzepg((zzeps) zzepl.checkNotNull(p));
    }

    public final T get() {
        T t = this.zzefg;
        if (t == zziyx) {
            synchronized (this) {
                t = this.zzefg;
                if (t == zziyx) {
                    t = this.zziyy.get();
                    T t2 = this.zzefg;
                    if (t2 != zziyx && !(t2 instanceof zzepm)) {
                        if (t2 != t) {
                            String valueOf = String.valueOf(t2);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzefg = t;
                    this.zziyy = null;
                }
            }
        }
        return t;
    }
}

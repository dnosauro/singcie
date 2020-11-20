package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzemg {
    private static final zzemg zziqn = new zzemg();
    private final zzemq zziqo = new zzelf();
    private final ConcurrentMap<Class<?>, zzemn<?>> zziqp = new ConcurrentHashMap();

    private zzemg() {
    }

    public static zzemg zzbjn() {
        return zziqn;
    }

    public final <T> zzemn<T> zzax(T t) {
        return zzh(t.getClass());
    }

    public final <T> zzemn<T> zzh(Class<T> cls) {
        zzekk.zza(cls, "messageType");
        zzemn<T> zzemn = (zzemn) this.zziqp.get(cls);
        if (zzemn != null) {
            return zzemn;
        }
        zzemn<T> zzg = this.zziqo.zzg(cls);
        zzekk.zza(cls, "messageType");
        zzekk.zza(zzg, "schema");
        zzemn<T> putIfAbsent = this.zziqp.putIfAbsent(cls, zzg);
        return putIfAbsent != null ? putIfAbsent : zzg;
    }
}

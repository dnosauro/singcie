package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzelo implements zzell {
    zzelo() {
    }

    public final Map<?, ?> zzan(Object obj) {
        return (zzelm) obj;
    }

    public final Map<?, ?> zzao(Object obj) {
        return (zzelm) obj;
    }

    public final boolean zzap(Object obj) {
        return !((zzelm) obj).isMutable();
    }

    public final Object zzaq(Object obj) {
        ((zzelm) obj).zzbfl();
        return obj;
    }

    public final Object zzar(Object obj) {
        return zzelm.zzbja().zzbjb();
    }

    public final zzelj<?, ?> zzas(Object obj) {
        zzelk zzelk = (zzelk) obj;
        throw new NoSuchMethodError();
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzelm zzelm = (zzelm) obj;
        zzelk zzelk = (zzelk) obj2;
        if (zzelm.isEmpty()) {
            return 0;
        }
        Iterator it = zzelm.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final Object zzf(Object obj, Object obj2) {
        zzelm zzelm = (zzelm) obj;
        zzelm zzelm2 = (zzelm) obj2;
        if (!zzelm2.isEmpty()) {
            if (!zzelm.isMutable()) {
                zzelm = zzelm.zzbjb();
            }
            zzelm.zza(zzelm2);
        }
        return zzelm;
    }
}

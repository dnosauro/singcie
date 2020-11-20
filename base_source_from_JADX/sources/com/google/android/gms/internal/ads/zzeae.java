package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import com.google.android.gms.internal.ads.zzels;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class zzeae<KeyProtoT extends zzels> {
    private final Class<KeyProtoT> zzhyk;
    private final Map<Class<?>, zzeag<?, KeyProtoT>> zzhyl;
    private final Class<?> zzhym;

    @SafeVarargs
    protected zzeae(Class<KeyProtoT> cls, zzeag<?, KeyProtoT>... zzeagArr) {
        this.zzhyk = cls;
        HashMap hashMap = new HashMap();
        int length = zzeagArr.length;
        int i = 0;
        while (i < length) {
            zzecg zzecg = zzeagArr[i];
            if (hashMap.containsKey(zzecg.zzazr())) {
                String valueOf = String.valueOf(zzecg.zzazr().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzecg.zzazr(), zzecg);
                i++;
            }
        }
        this.zzhym = zzeagArr.length > 0 ? zzeagArr[0].zzazr() : Void.class;
        this.zzhyl = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) {
        zzeag zzeag = this.zzhyl.get(cls);
        if (zzeag != null) {
            return zzeag.zzah(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Class<KeyProtoT> zzazu() {
        return this.zzhyk;
    }

    public abstract zzefh.zzb zzazv();

    public final Set<Class<?>> zzazw() {
        return this.zzhyl.keySet();
    }

    /* access modifiers changed from: package-private */
    public final Class<?> zzazx() {
        return this.zzhym;
    }

    public zzead<?, KeyProtoT> zzazy() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract void zze(KeyProtoT keyprotot);

    public abstract KeyProtoT zzr(zzeiu zzeiu);
}

package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzekv<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzekt> zziot;

    private zzekv(Map.Entry<K, zzekt> entry) {
        this.zziot = entry;
    }

    public final K getKey() {
        return this.zziot.getKey();
    }

    public final Object getValue() {
        if (this.zziot.getValue() == null) {
            return null;
        }
        return zzekt.zzbir();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzels) {
            return this.zziot.getValue().zzn((zzels) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzekt zzbit() {
        return this.zziot.getValue();
    }
}

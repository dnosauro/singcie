package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

abstract class zzepc<K, V, V2> implements zzepf<Map<K, V2>> {
    private final Map<K, zzeps<V>> zziyv;

    zzepc(Map<K, zzeps<V>> map) {
        this.zziyv = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, zzeps<V>> zzblt() {
        return this.zziyv;
    }
}

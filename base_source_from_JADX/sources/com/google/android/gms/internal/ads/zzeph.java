package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzeph<K, V> extends zzepc<K, V, V> {
    private static final zzeps<Map<Object, Object>> zziyz = zzepi.zzbb(Collections.emptyMap());

    private zzeph(Map<K, zzeps<V>> map) {
        super(map);
    }

    public static <K, V> zzepj<K, V> zzig(int i) {
        return new zzepj<>(i);
    }

    public final /* synthetic */ Object get() {
        LinkedHashMap zzie = zzepe.zzie(zzblt().size());
        for (Map.Entry entry : zzblt().entrySet()) {
            zzie.put(entry.getKey(), ((zzeps) entry.getValue()).get());
        }
        return Collections.unmodifiableMap(zzie);
    }
}

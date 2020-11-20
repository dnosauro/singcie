package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgo<T> {
    private final Map<String, AtomicReference<T>> zzabv = new HashMap();

    public final AtomicReference<T> zzas(String str) {
        synchronized (this) {
            if (!this.zzabv.containsKey(str)) {
                this.zzabv.put(str, new AtomicReference());
            }
        }
        return this.zzabv.get(str);
    }
}

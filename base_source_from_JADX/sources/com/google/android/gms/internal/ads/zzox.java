package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzox {
    private final Map<String, String> zzbjg = new HashMap();
    private Map<String, String> zzbjh;

    public final synchronized Map<String, String> zzit() {
        if (this.zzbjh == null) {
            this.zzbjh = Collections.unmodifiableMap(new HashMap(this.zzbjg));
        }
        return this.zzbjh;
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

public final class zzajg implements InitializationStatus {
    private final Map<String, AdapterStatus> zzdhq;

    public zzajg(Map<String, AdapterStatus> map) {
        this.zzdhq = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zzdhq;
    }
}

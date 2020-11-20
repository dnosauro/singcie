package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

public final class zzajh implements AdapterStatus {
    private final String description;
    private final int zzdhp;
    private final AdapterStatus.State zzdhr;

    public zzajh(AdapterStatus.State state, String str, int i) {
        this.zzdhr = state;
        this.description = str;
        this.zzdhp = i;
    }

    public final String getDescription() {
        return this.description;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.zzdhr;
    }

    public final int getLatency() {
        return this.zzdhp;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbog<AdT> implements zzbod<AdT> {
    private final Map<String, zzcqz<AdT>> zzfux;

    zzbog(Map<String, zzcqz<AdT>> map) {
        this.zzfux = map;
    }

    public final zzcqz<AdT> zze(int i, String str) {
        return this.zzfux.get(str);
    }
}

package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbof<AdT> implements zzepf<zzbog<AdT>> {
    private final zzeps<Map<String, zzcqz<AdT>>> zzfuw;

    private zzbof(zzeps<Map<String, zzcqz<AdT>>> zzeps) {
        this.zzfuw = zzeps;
    }

    public static <AdT> zzbof<AdT> zzd(zzeps<Map<String, zzcqz<AdT>>> zzeps) {
        return new zzbof<>(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbog(this.zzfuw.get());
    }
}

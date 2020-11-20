package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbzs implements zzepf<Set<zzbxy<zzbxr>>> {
    private final zzeps<zzcaj> zzfse;

    private zzbzs(zzeps<zzcaj> zzeps) {
        this.zzfse = zzeps;
    }

    public static zzbzs zzw(zzeps<zzcaj> zzeps) {
        return new zzbzs(zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(zzbxy.zzb(this.zzfse.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}

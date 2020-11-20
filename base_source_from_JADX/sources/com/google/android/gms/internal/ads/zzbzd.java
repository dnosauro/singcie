package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbzd implements zzepf<Set<zzbxy<zzbsi>>> {
    private final zzeps<zzbqu> zzfse;
    private final zzbzc zzfzx;

    private zzbzd(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        this.zzfzx = zzbzc;
        this.zzfse = zzeps;
    }

    public static zzbzd zza(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        return new zzbzd(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(zzbxy.zzb(this.zzfse.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}

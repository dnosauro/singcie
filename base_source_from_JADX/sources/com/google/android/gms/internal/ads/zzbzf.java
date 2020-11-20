package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbzf implements zzepf<Set<zzbxy<zzbvz>>> {
    private final zzeps<zzbqu> zzfse;
    private final zzbzc zzfzx;

    private zzbzf(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        this.zzfzx = zzbzc;
        this.zzfse = zzeps;
    }

    public static zzbzf zzb(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        return new zzbzf(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(zzbxy.zzb(this.zzfse.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}

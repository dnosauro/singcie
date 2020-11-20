package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbzl implements zzepf<Set<zzbxy<zzbru>>> {
    private final zzeps<zzbqu> zzfse;
    private final zzbzc zzfzx;

    private zzbzl(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        this.zzfzx = zzbzc;
        this.zzfse = zzeps;
    }

    public static zzbzl zze(zzbzc zzbzc, zzeps<zzbqu> zzeps) {
        return new zzbzl(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfzx.zzb(this.zzfse.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbms implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzeps<zzbnt> zzfse;
    private final zzbmh zzftq;

    public zzbms(zzbmh zzbmh, zzeps<zzbnt> zzeps) {
        this.zzftq = zzbmh;
        this.zzfse = zzeps;
    }

    public static Set<zzbxy<zzbtj>> zza(zzbmh zzbmh, zzbnt zzbnt) {
        return (Set) zzepl.zza(Collections.singleton(new zzbxy(zzbnt, zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzftq, this.zzfse.get());
    }
}

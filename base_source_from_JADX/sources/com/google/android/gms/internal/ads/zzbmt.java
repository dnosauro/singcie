package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzbmt implements zzepf<Set<zzbxy<zzqu>>> {
    private final zzeps<zzbnt> zzfse;
    private final zzbmh zzftq;

    public zzbmt(zzbmh zzbmh, zzeps<zzbnt> zzeps) {
        this.zzftq = zzbmh;
        this.zzfse = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(Collections.singleton(new zzbxy(this.zzfse.get(), zzazj.zzegu)), "Cannot return null from a non-@Nullable @Provides method");
    }
}

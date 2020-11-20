package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbmm implements zzepf<zzbte> {
    private final zzbmh zzftq;
    private final zzeps<Set<zzbxy<zzbtj>>> zzftr;

    public zzbmm(zzbmh zzbmh, zzeps<Set<zzbxy<zzbtj>>> zzeps) {
        this.zzftq = zzbmh;
        this.zzftr = zzeps;
    }

    public static zzbte zza(zzbmh zzbmh, Set<zzbxy<zzbtj>> set) {
        return (zzbte) zzepl.zza(zzbmh.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzftq, this.zzftr.get());
    }
}

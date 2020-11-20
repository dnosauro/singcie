package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzdrw implements zzepf<zzdrn> {
    private final zzeps<Set<zzbxy<zzdru>>> zzftr;

    private zzdrw(zzeps<Set<zzbxy<zzdru>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzdrw zzar(zzeps<Set<zzbxy<zzdru>>> zzeps) {
        return new zzdrw(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzdrn(this.zzftr.get());
    }
}

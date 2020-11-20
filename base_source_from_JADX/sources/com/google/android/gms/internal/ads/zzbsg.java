package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsg implements zzepf<zzbsf> {
    private final zzeps<Set<zzbxy<zzbsi>>> zzftr;

    private zzbsg(zzeps<Set<zzbxy<zzbsi>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbsg zzh(zzeps<Set<zzbxy<zzbsi>>> zzeps) {
        return new zzbsg(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbsf(this.zzftr.get());
    }
}

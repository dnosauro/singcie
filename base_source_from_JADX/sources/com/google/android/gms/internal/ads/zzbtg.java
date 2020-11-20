package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtg implements zzepf<zzbte> {
    private final zzeps<Set<zzbxy<zzbtj>>> zzftr;

    private zzbtg(zzeps<Set<zzbxy<zzbtj>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbtg zzl(zzeps<Set<zzbxy<zzbtj>>> zzeps) {
        return new zzbtg(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbte(this.zzftr.get());
    }
}

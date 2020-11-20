package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtd implements zzepf<zzbsu> {
    private final zzeps<Set<zzbxy<zzbru>>> zzftr;

    private zzbtd(zzeps<Set<zzbxy<zzbru>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbtd zzk(zzeps<Set<zzbxy<zzbru>>> zzeps) {
        return new zzbtd(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbsu(this.zzftr.get());
    }
}

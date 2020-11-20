package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbye implements zzepf<zzbyc> {
    private final zzeps<Set<zzbxy<zzbyd>>> zzftr;

    private zzbye(zzeps<Set<zzbxy<zzbyd>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbye zzu(zzeps<Set<zzbxy<zzbyd>>> zzeps) {
        return new zzbye(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbyc(this.zzftr.get());
    }
}

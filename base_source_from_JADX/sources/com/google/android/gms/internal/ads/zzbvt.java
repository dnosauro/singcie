package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbvt implements zzepf<zzbvr> {
    private final zzeps<Set<zzbxy<zzbvs>>> zzftr;

    private zzbvt(zzeps<Set<zzbxy<zzbvs>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbvt zzp(zzeps<Set<zzbxy<zzbvs>>> zzeps) {
        return new zzbvt(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbvr(this.zzftr.get());
    }
}

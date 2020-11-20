package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbwi implements zzepf<zzbwd> {
    private final zzeps<Set<zzbxy<zzbwl>>> zzftr;

    private zzbwi(zzeps<Set<zzbxy<zzbwl>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbwi zzs(zzeps<Set<zzbxy<zzbwl>>> zzeps) {
        return new zzbwi(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbwd(this.zzftr.get());
    }
}

package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbtp implements zzepf<zzbtn> {
    private final zzeps<Set<zzbxy<zzbto>>> zzftr;

    private zzbtp(zzeps<Set<zzbxy<zzbto>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbtp zzn(zzeps<Set<zzbxy<zzbto>>> zzeps) {
        return new zzbtp(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbtn(this.zzftr.get());
    }
}

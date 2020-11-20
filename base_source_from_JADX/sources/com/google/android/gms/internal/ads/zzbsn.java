package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsn implements zzepf<zzbsl> {
    private final zzeps<Set<zzbxy<zzbsm>>> zzftr;

    private zzbsn(zzeps<Set<zzbxy<zzbsm>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbsn zzi(zzeps<Set<zzbxy<zzbsm>>> zzeps) {
        return new zzbsn(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbsl(this.zzftr.get());
    }
}

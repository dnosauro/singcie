package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbsv implements zzepf<zzbso> {
    private final zzeps<Set<zzbxy<zzbsp>>> zzftr;

    private zzbsv(zzeps<Set<zzbxy<zzbsp>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbsv zzj(zzeps<Set<zzbxy<zzbsp>>> zzeps) {
        return new zzbsv(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbso(this.zzftr.get());
    }
}

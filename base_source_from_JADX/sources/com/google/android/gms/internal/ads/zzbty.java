package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbty implements zzepf<zzbtw> {
    private final zzeps<zzdmu> zzfqj;
    private final zzeps<Set<zzbxy<zzbub>>> zzftr;

    private zzbty(zzeps<Set<zzbxy<zzbub>>> zzeps, zzeps<zzdmu> zzeps2) {
        this.zzftr = zzeps;
        this.zzfqj = zzeps2;
    }

    public static zzbty zzv(zzeps<Set<zzbxy<zzbub>>> zzeps, zzeps<zzdmu> zzeps2) {
        return new zzbty(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbtw(this.zzftr.get(), this.zzfqj.get());
    }
}

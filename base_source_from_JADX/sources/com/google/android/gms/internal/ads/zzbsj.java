package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzbsj implements zzepf<zzbsb> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbsf> zzfap;
    private final zzeps<Set<zzbxy<zzbry>>> zzftr;

    private zzbsj(zzeps<zzbsf> zzeps, zzeps<Set<zzbxy<zzbry>>> zzeps2, zzeps<Executor> zzeps3) {
        this.zzfap = zzeps;
        this.zzftr = zzeps2;
        this.zzevg = zzeps3;
    }

    public static zzbsj zzj(zzeps<zzbsf> zzeps, zzeps<Set<zzbxy<zzbry>>> zzeps2, zzeps<Executor> zzeps3) {
        return new zzbsj(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbsb(this.zzfap.get(), this.zzftr.get(), this.zzevg.get());
    }
}

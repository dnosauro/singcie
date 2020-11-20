package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdfm<T> implements zzepf<zzdfl<T>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Set<zzdfi<? extends zzdfj<T>>>> zzhbp;

    private zzdfm(zzeps<Executor> zzeps, zzeps<Set<zzdfi<? extends zzdfj<T>>>> zzeps2) {
        this.zzevg = zzeps;
        this.zzhbp = zzeps2;
    }

    public static <T> zzdfl<T> zza(Executor executor, Set<zzdfi<? extends zzdfj<T>>> set) {
        return new zzdfl<>(executor, set);
    }

    public static <T> zzdfm<T> zzbi(zzeps<Executor> zzeps, zzeps<Set<zzdfi<? extends zzdfj<T>>>> zzeps2) {
        return new zzdfm<>(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzevg.get(), this.zzhbp.get());
    }
}

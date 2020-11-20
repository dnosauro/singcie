package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzclh implements zzepf<Set<zzbxy<zzbtj>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcln> zzgjn;
    private final zzcld zzgkz;

    private zzclh(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.zzgkz = zzcld;
        this.zzgjn = zzeps;
        this.zzevg = zzeps2;
    }

    public static Set<zzbxy<zzbtj>> zza(zzcld zzcld, zzcln zzcln, Executor executor) {
        return (Set) zzepl.zza(zzcld.zzc(zzcln, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzclh zzc(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclh(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgkz, this.zzgjn.get(), this.zzevg.get());
    }
}

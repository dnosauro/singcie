package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzclf implements zzepf<Set<zzbxy<zzbrz>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcln> zzgjn;
    private final zzcld zzgkz;

    private zzclf(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.zzgkz = zzcld;
        this.zzgjn = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzclf zza(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclf(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zzd(this.zzgjn.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

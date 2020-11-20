package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcli implements zzepf<Set<zzbxy<zzbsp>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcln> zzgjn;
    private final zzcld zzgkz;

    private zzcli(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.zzgkz = zzcld;
        this.zzgjn = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzcli zzd(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzcli(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zza(this.zzgjn.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

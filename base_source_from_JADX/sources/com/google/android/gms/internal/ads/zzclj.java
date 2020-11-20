package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzclj implements zzepf<Set<zzbxy<AppEventListener>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcln> zzgjn;
    private final zzcld zzgkz;

    private zzclj(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        this.zzgkz = zzcld;
        this.zzgjn = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzclj zze(zzcld zzcld, zzeps<zzcln> zzeps, zzeps<Executor> zzeps2) {
        return new zzclj(zzcld, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(zzcld.zzb(this.zzgjn.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
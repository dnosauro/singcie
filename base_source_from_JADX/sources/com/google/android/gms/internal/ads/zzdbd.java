package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdbd implements zzepf<zzday> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzayg> zzgyo;

    private zzdbd(zzeps<Executor> zzeps, zzeps<zzayg> zzeps2) {
        this.zzevg = zzeps;
        this.zzgyo = zzeps2;
    }

    public static zzday zza(Executor executor, zzayg zzayg) {
        return new zzday(executor, zzayg);
    }

    public static zzdbd zzaz(zzeps<Executor> zzeps, zzeps<zzayg> zzeps2) {
        return new zzdbd(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzevg.get(), this.zzgyo.get());
    }
}

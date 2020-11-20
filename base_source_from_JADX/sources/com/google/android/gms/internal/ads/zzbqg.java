package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.Executor;

public final class zzbqg implements zzepf<zzbxy<zzp>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbul> zzfrk;

    private zzbqg(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzbqg zzq(zzeps<zzbul> zzeps, zzeps<Executor> zzeps2) {
        return new zzbqg(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzevg.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

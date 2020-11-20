package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

public final class zzcek implements zzepf<zzbxy<VideoController.VideoLifecycleCallbacks>> {
    private final zzeps<zzcgy> zzfrk;
    private final zzeps<Executor> zzftl;
    private final zzceb zzgft;

    public zzcek(zzceb zzceb, zzeps<zzcgy> zzeps, zzeps<Executor> zzeps2) {
        this.zzgft = zzceb;
        this.zzfrk = zzeps;
        this.zzftl = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), this.zzftl.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

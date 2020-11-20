package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdry implements zzepf<zzaml> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfxq;
    private final zzdrv zzhpb;

    public zzdry(zzdrv zzdrv, zzeps<Context> zzeps, zzeps<zzazh> zzeps2) {
        this.zzhpb = zzdrv;
        this.zzevi = zzeps;
        this.zzfxq = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzaml) zzepl.zza(new zzamc().zzb(this.zzevi.get(), this.zzfxq.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

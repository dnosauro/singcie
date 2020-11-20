package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbmp implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfpc;
    private final zzeps<zzdmu> zzfrp;
    private final zzbmh zzftq;
    private final zzeps<zzdnn> zzfts;

    public zzbmp(zzbmh zzbmh, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdnn> zzeps4) {
        this.zzftq = zzbmh;
        this.zzevi = zzeps;
        this.zzfpc = zzeps2;
        this.zzfrp = zzeps3;
        this.zzfts = zzeps4;
    }

    public static zzbxy<zzbtj> zza(zzbmh zzbmh, Context context, zzazh zzazh, zzdmu zzdmu, zzdnn zzdnn) {
        return (zzbxy) zzepl.zza(new zzbxy(new zzbmk(context, zzazh, zzdmu, zzdnn), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzftq, this.zzevi.get(), this.zzfpc.get(), this.zzfrp.get(), this.zzfts.get());
    }
}

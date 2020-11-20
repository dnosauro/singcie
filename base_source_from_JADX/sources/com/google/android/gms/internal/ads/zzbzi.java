package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbzi implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfpc;
    private final zzeps<zzdmu> zzfrp;
    private final zzeps<zzdnn> zzfts;
    private final zzbzc zzfzx;

    private zzbzi(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdnn> zzeps4) {
        this.zzfzx = zzbzc;
        this.zzevi = zzeps;
        this.zzfpc = zzeps2;
        this.zzfrp = zzeps3;
        this.zzfts = zzeps4;
    }

    public static zzbzi zza(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdnn> zzeps4) {
        return new zzbzi(zzbzc, zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(new zzbzb(this.zzevi.get(), this.zzfpc.get(), this.zzfrp.get(), this.zzfts.get()), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}

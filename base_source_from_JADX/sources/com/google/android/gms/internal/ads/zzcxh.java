package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcxh implements zzepf<zzcxi> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzwt> zzgvj;
    private final zzeps<zzbme> zzgvk;

    public zzcxh(zzeps<Context> zzeps, zzeps<zzwt> zzeps2, zzeps<zzdnn> zzeps3, zzeps<zzbme> zzeps4) {
        this.zzevi = zzeps;
        this.zzgvj = zzeps2;
        this.zzfts = zzeps3;
        this.zzgvk = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcxi(this.zzevi.get(), this.zzgvj.get(), this.zzfts.get(), this.zzgvk.get());
    }
}

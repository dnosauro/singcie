package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbmw implements zzepf<zzawu> {
    private final zzeps<Context> zzevi;
    private final zzbmh zzftq;
    private final zzeps<zzdnn> zzfts;

    public zzbmw(zzbmh zzbmh, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        this.zzftq = zzbmh;
        this.zzevi = zzeps;
        this.zzfts = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return (zzawu) zzepl.zza(new zzawu(this.zzevi.get(), this.zzfts.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}

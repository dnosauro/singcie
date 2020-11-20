package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbzo implements zzepf<zzawu> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdnn> zzfts;
    private final zzbzc zzfzx;

    private zzbzo(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        this.zzfzx = zzbzc;
        this.zzevi = zzeps;
        this.zzfts = zzeps2;
    }

    public static zzbzo zza(zzbzc zzbzc, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        return new zzbzo(zzbzc, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzawu) zzepl.zza(new zzawu(this.zzevi.get(), this.zzfts.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}

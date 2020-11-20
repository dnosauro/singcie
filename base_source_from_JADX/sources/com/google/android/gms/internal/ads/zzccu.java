package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzccu implements zzepf<zzawu> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdnn> zzfts;
    private final zzccq zzgds;

    private zzccu(zzccq zzccq, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        this.zzgds = zzccq;
        this.zzevi = zzeps;
        this.zzfts = zzeps2;
    }

    public static zzccu zza(zzccq zzccq, zzeps<Context> zzeps, zzeps<zzdnn> zzeps2) {
        return new zzccu(zzccq, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzawu) zzepl.zza(new zzawu(this.zzevi.get(), this.zzfts.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}

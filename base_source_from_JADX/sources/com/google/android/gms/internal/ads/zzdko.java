package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdko implements zzepf<zzdkl<zzblp, zzblv>> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdpa> zzexm;
    private final zzeps<zzdpr> zzexn;

    public zzdko(zzeps<Context> zzeps, zzeps<zzdpa> zzeps2, zzeps<zzdpr> zzeps3) {
        this.zzevi = zzeps;
        this.zzexm = zzeps2;
        this.zzexn = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return (zzdkl) zzepl.zza(zzdkp.zzb(this.zzevi.get(), this.zzexm.get(), this.zzexn.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

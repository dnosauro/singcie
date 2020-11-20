package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzag;

public final class zzbqr implements zzepf<zzdvm<zzdmu, zzag>> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfpc;
    private final zzeps<zzdnn> zzfts;

    public zzbqr(zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdnn> zzeps3) {
        this.zzevi = zzeps;
        this.zzfpc = zzeps2;
        this.zzfts = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return (zzdvm) zzepl.zza(new zzbqs(this.zzevi.get(), this.zzfpc.get(), this.zzfts.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

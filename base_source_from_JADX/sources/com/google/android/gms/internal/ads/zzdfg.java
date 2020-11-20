package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdfg implements zzepf<zzdfd> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzfwi;

    private zzdfg(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        this.zzevg = zzeps;
        this.zzfwi = zzeps2;
    }

    public static zzdfd zza(zzdzc zzdzc, Context context) {
        return new zzdfd(zzdzc, context);
    }

    public static zzdfg zzbh(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        return new zzdfg(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzevg.get(), this.zzfwi.get());
    }
}

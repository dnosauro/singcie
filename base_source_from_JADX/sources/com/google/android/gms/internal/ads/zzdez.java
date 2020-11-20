package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdez implements zzepf<zzdex> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfpc;

    private zzdez(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<zzazh> zzeps3) {
        this.zzevg = zzeps;
        this.zzevi = zzeps2;
        this.zzfpc = zzeps3;
    }

    public static zzdez zzw(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<zzazh> zzeps3) {
        return new zzdez(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdex(this.zzevg.get(), this.zzevi.get(), this.zzfpc.get());
    }
}

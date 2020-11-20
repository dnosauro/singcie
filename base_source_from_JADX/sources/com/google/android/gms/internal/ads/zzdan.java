package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdan implements zzepf<zzdal> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdbw<zzdfp>> zzewx;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzayg> zzgyo;

    private zzdan(zzeps<zzdbw<zzdfp>> zzeps, zzeps<zzdnn> zzeps2, zzeps<Context> zzeps3, zzeps<zzayg> zzeps4) {
        this.zzewx = zzeps;
        this.zzfts = zzeps2;
        this.zzevi = zzeps3;
        this.zzgyo = zzeps4;
    }

    public static zzdan zzg(zzeps<zzdbw<zzdfp>> zzeps, zzeps<zzdnn> zzeps2, zzeps<Context> zzeps3, zzeps<zzayg> zzeps4) {
        return new zzdan(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzdal(this.zzewx.get(), this.zzfts.get(), this.zzevi.get(), this.zzgyo.get());
    }
}

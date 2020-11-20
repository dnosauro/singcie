package com.google.android.gms.internal.ads;

public final class zzdaz implements zzepf<zzdax> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzazh> zzfxq;

    private zzdaz(zzeps<zzdzc> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3) {
        this.zzevg = zzeps;
        this.zzfts = zzeps2;
        this.zzfxq = zzeps3;
    }

    public static zzdaz zzs(zzeps<zzdzc> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3) {
        return new zzdaz(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdax(this.zzevg.get(), this.zzfts.get(), this.zzfxq.get());
    }
}

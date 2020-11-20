package com.google.android.gms.internal.ads;

public final class zzdcd implements zzepf<zzdcb> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<String> zzfrr;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzcis> zzgzr;

    private zzdcd(zzeps<zzdzc> zzeps, zzeps<zzcis> zzeps2, zzeps<zzdnn> zzeps3, zzeps<String> zzeps4) {
        this.zzevg = zzeps;
        this.zzgzr = zzeps2;
        this.zzfts = zzeps3;
        this.zzfrr = zzeps4;
    }

    public static zzdcd zzh(zzeps<zzdzc> zzeps, zzeps<zzcis> zzeps2, zzeps<zzdnn> zzeps3, zzeps<String> zzeps4) {
        return new zzdcd(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzdcb(this.zzevg.get(), this.zzgzr.get(), this.zzfts.get(), this.zzfrr.get());
    }
}

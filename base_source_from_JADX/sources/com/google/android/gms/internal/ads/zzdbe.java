package com.google.android.gms.internal.ads;

public final class zzdbe implements zzepf<zzdbc> {
    private final zzeps<zzbpo> zzfcd;
    private final zzeps<zzdon> zzfdo;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<String> zzgyu;
    private final zzeps<String> zzgyy;

    private zzdbe(zzeps<String> zzeps, zzeps<String> zzeps2, zzeps<zzbpo> zzeps3, zzeps<zzdon> zzeps4, zzeps<zzdnn> zzeps5) {
        this.zzgyu = zzeps;
        this.zzgyy = zzeps2;
        this.zzfcd = zzeps3;
        this.zzfdo = zzeps4;
        this.zzfts = zzeps5;
    }

    public static zzdbe zzg(zzeps<String> zzeps, zzeps<String> zzeps2, zzeps<zzbpo> zzeps3, zzeps<zzdon> zzeps4, zzeps<zzdnn> zzeps5) {
        return new zzdbe(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzdbc(this.zzgyu.get(), this.zzgyy.get(), this.zzfcd.get(), this.zzfdo.get(), this.zzfts.get());
    }
}

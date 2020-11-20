package com.google.android.gms.internal.ads;

public final class zzchk implements zzepf<zzcqz<zzchc>> {
    private final zzeps<zzcvy<zzchc, zzdoe, zzcsw>> zzfrd;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzcvy<zzchc, zzdoe, zzcst>> zzgig;

    public zzchk(zzeps<zzcvy<zzchc, zzdoe, zzcsw>> zzeps, zzeps<zzcvy<zzchc, zzdoe, zzcst>> zzeps2, zzeps<zzdnn> zzeps3) {
        this.zzfrd = zzeps;
        this.zzgig = zzeps2;
        this.zzfts = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return (zzcqz) zzepl.zza((zzcqz) (zzchh.zzgif[this.zzfts.get().zzhiv.zzhia - 1] != 1 ? this.zzgig.get() : this.zzfrd.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

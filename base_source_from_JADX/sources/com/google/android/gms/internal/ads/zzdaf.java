package com.google.android.gms.internal.ads;

public final class zzdaf implements zzepf<zzdac> {
    private final zzeps<zzdnn> zzfts;

    private zzdaf(zzeps<zzdnn> zzeps) {
        this.zzfts = zzeps;
    }

    public static zzdaf zzaj(zzeps<zzdnn> zzeps) {
        return new zzdaf(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzdac(this.zzfts.get());
    }
}

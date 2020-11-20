package com.google.android.gms.internal.ads;

public final class zzcjq implements zzepf<zzcjj> {
    private final zzeps<zzdkt> zzfci;
    private final zzeps<zzts> zzgjn;

    private zzcjq(zzeps<zzts> zzeps, zzeps<zzdkt> zzeps2) {
        this.zzgjn = zzeps;
        this.zzfci = zzeps2;
    }

    public static zzcjq zzah(zzeps<zzts> zzeps, zzeps<zzdkt> zzeps2) {
        return new zzcjq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcjj(this.zzgjn.get(), this.zzfci.get());
    }
}

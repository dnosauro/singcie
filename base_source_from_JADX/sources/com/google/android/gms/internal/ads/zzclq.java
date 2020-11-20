package com.google.android.gms.internal.ads;

public final class zzclq implements zzepf<zzcln> {
    private final zzeps<zzbgm> zzeve;
    private final zzeps<zzclb> zzgjn;

    private zzclq(zzeps<zzclb> zzeps, zzeps<zzbgm> zzeps2) {
        this.zzgjn = zzeps;
        this.zzeve = zzeps2;
    }

    public static zzclq zzap(zzeps<zzclb> zzeps, zzeps<zzbgm> zzeps2) {
        return new zzclq(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcln(this.zzgjn.get(), this.zzeve.get());
    }
}

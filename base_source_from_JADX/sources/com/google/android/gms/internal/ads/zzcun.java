package com.google.android.gms.internal.ads;

public final class zzcun implements zzepf<zzcuo> {
    private final zzeps<zzcil> zzevs;
    private final zzeps<zzckq> zzewm;
    private final zzeps<zzdoa> zzexf;

    private zzcun(zzeps<zzdoa> zzeps, zzeps<zzcil> zzeps2, zzeps<zzckq> zzeps3) {
        this.zzexf = zzeps;
        this.zzevs = zzeps2;
        this.zzewm = zzeps3;
    }

    public static zzcun zzq(zzeps<zzdoa> zzeps, zzeps<zzcil> zzeps2, zzeps<zzckq> zzeps3) {
        return new zzcun(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzcuo(this.zzexf.get(), this.zzevs.get(), this.zzewm.get());
    }
}

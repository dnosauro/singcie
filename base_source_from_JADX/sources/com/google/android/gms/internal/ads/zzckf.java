package com.google.android.gms.internal.ads;

public final class zzckf implements zzepf<zzckg> {
    private final zzeps<zzckv> zzewc;
    private final zzeps<zzcko> zzfco;

    private zzckf(zzeps<zzcko> zzeps, zzeps<zzckv> zzeps2) {
        this.zzfco = zzeps;
        this.zzewc = zzeps2;
    }

    public static zzckf zzaj(zzeps<zzcko> zzeps, zzeps<zzckv> zzeps2) {
        return new zzckf(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzckg(this.zzfco.get(), this.zzewc.get());
    }
}

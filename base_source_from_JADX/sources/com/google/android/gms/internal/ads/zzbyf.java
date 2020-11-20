package com.google.android.gms.internal.ads;

public final class zzbyf implements zzepf<zzbyg> {
    private final zzeps<zzdrz> zzewl;
    private final zzeps<zzdmu> zzfqj;

    private zzbyf(zzeps<zzdmu> zzeps, zzeps<zzdrz> zzeps2) {
        this.zzfqj = zzeps;
        this.zzewl = zzeps2;
    }

    public static zzbyf zzw(zzeps<zzdmu> zzeps, zzeps<zzdrz> zzeps2) {
        return new zzbyf(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbyg(this.zzfqj.get(), this.zzewl.get());
    }
}

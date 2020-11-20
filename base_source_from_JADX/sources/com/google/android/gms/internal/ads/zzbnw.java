package com.google.android.gms.internal.ads;

public final class zzbnw implements zzepf<zzbnt> {
    private final zzeps<zzdmu> zzfqj;
    private final zzeps<zzbsl> zzfum;
    private final zzeps<zzbtn> zzfun;

    private zzbnw(zzeps<zzdmu> zzeps, zzeps<zzbsl> zzeps2, zzeps<zzbtn> zzeps3) {
        this.zzfqj = zzeps;
        this.zzfum = zzeps2;
        this.zzfun = zzeps3;
    }

    public static zzbnw zzf(zzeps<zzdmu> zzeps, zzeps<zzbsl> zzeps2, zzeps<zzbtn> zzeps3) {
        return new zzbnw(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbnt(this.zzfqj.get(), this.zzfum.get(), this.zzfun.get());
    }
}

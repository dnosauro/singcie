package com.google.android.gms.internal.ads;

public final class zzddl implements zzepf<zzddj> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<zzdms> zzgru;

    private zzddl(zzeps<zzdzc> zzeps, zzeps<zzdms> zzeps2) {
        this.zzevg = zzeps;
        this.zzgru = zzeps2;
    }

    public static zzddl zzbd(zzeps<zzdzc> zzeps, zzeps<zzdms> zzeps2) {
        return new zzddl(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzddj(this.zzevg.get(), this.zzgru.get());
    }
}

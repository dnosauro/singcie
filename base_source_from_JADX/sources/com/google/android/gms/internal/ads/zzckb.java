package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzckb implements zzepf<zzcka> {
    private final zzeps<zzts> zzgjn;
    private final zzeps<Map<zzdrl, zzckc>> zzgjv;

    private zzckb(zzeps<zzts> zzeps, zzeps<Map<zzdrl, zzckc>> zzeps2) {
        this.zzgjn = zzeps;
        this.zzgjv = zzeps2;
    }

    public static zzckb zzai(zzeps<zzts> zzeps, zzeps<Map<zzdrl, zzckc>> zzeps2) {
        return new zzckb(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcka(this.zzgjn.get(), this.zzgjv.get());
    }
}

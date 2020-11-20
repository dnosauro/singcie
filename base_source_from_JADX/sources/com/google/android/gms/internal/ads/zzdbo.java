package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdbo implements zzepf<zzdbm> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;

    private zzdbo(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        this.zzevg = zzeps;
        this.zzevi = zzeps2;
    }

    public static zzdbo zzba(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        return new zzdbo(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdbm(this.zzevg.get(), this.zzevi.get());
    }
}

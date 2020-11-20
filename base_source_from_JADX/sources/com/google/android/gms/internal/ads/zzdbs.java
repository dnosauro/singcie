package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdbs implements zzepf<zzdbq> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;

    public zzdbs(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2) {
        this.zzevg = zzeps;
        this.zzevi = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzdbq(this.zzevg.get(), this.zzevi.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdgi implements zzepf<zzdgg> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzato> zzewn;
    private final zzeps<String> zzfxb;

    public zzdgi(zzeps<zzato> zzeps, zzeps<Context> zzeps2, zzeps<String> zzeps3, zzeps<zzdzc> zzeps4) {
        this.zzewn = zzeps;
        this.zzevi = zzeps2;
        this.zzfxb = zzeps3;
        this.zzevg = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzdgg(this.zzewn.get(), this.zzevi.get(), this.zzfxb.get(), this.zzevg.get());
    }
}

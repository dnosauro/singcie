package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

public final class zzdab implements zzepf<zzczz> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<ViewGroup> zzgsv;
    private final zzeps<zzdzc> zzgyf;

    public zzdab(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<zzdnn> zzeps3, zzeps<ViewGroup> zzeps4) {
        this.zzgyf = zzeps;
        this.zzevi = zzeps2;
        this.zzfts = zzeps3;
        this.zzgsv = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzczz(this.zzgyf.get(), this.zzevi.get(), this.zzfts.get(), this.zzgsv.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbnu implements zzepf<zzbnr> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfpc;
    private final zzeps<zzbdv> zzfti;
    private final zzeps<zzdmu> zzfuk;

    public zzbnu(zzeps<Context> zzeps, zzeps<zzbdv> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzazh> zzeps4) {
        this.zzevi = zzeps;
        this.zzfti = zzeps2;
        this.zzfuk = zzeps3;
        this.zzfpc = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzbnr(this.zzevi.get(), this.zzfti.get(), this.zzfuk.get(), this.zzfpc.get());
    }
}

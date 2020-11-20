package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbra implements zzepf<zzbqx> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdmu> zzfuk;
    private final zzeps<zzarq> zzfwz;

    private zzbra(zzeps<Context> zzeps, zzeps<zzdmu> zzeps2, zzeps<zzarq> zzeps3) {
        this.zzevi = zzeps;
        this.zzfuk = zzeps2;
        this.zzfwz = zzeps3;
    }

    public static zzbra zzh(zzeps<Context> zzeps, zzeps<zzdmu> zzeps2, zzeps<zzarq> zzeps3) {
        return new zzbra(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbqx(this.zzevi.get(), this.zzfuk.get(), this.zzfwz.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzue;

public final class zzcak implements zzepf<zzcah> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzazh> zzfpc;
    private final zzeps<zzue.zza.C3719zza> zzfrr;
    private final zzeps<zzbdv> zzfti;
    private final zzeps<zzdmu> zzfuk;

    private zzcak(zzeps<Context> zzeps, zzeps<zzbdv> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzue.zza.C3719zza> zzeps5) {
        this.zzevi = zzeps;
        this.zzfti = zzeps2;
        this.zzfuk = zzeps3;
        this.zzfpc = zzeps4;
        this.zzfrr = zzeps5;
    }

    public static zzcak zzc(zzeps<Context> zzeps, zzeps<zzbdv> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzue.zza.C3719zza> zzeps5) {
        return new zzcak(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzcah(this.zzevi.get(), this.zzfti.get(), this.zzfuk.get(), this.zzfpc.get(), this.zzfrr.get());
    }
}

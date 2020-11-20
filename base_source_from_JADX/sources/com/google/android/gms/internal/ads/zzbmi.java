package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzbmi implements zzepf<zzbmg> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzbyc> zzezx;
    private final zzeps<zzbob> zzfav;
    private final zzeps<zzcxi> zzfmo;
    private final zzeps<View> zzfqk;
    private final zzeps<zzdmx> zzfth;
    private final zzeps<zzbdv> zzfti;
    private final zzeps<zzbnz> zzftj;
    private final zzeps<zzccl> zzftk;
    private final zzeps<Executor> zzftl;

    public zzbmi(zzeps<zzbob> zzeps, zzeps<Context> zzeps2, zzeps<zzdmx> zzeps3, zzeps<View> zzeps4, zzeps<zzbdv> zzeps5, zzeps<zzbnz> zzeps6, zzeps<zzccl> zzeps7, zzeps<zzbyc> zzeps8, zzeps<zzcxi> zzeps9, zzeps<Executor> zzeps10) {
        this.zzfav = zzeps;
        this.zzevi = zzeps2;
        this.zzfth = zzeps3;
        this.zzfqk = zzeps4;
        this.zzfti = zzeps5;
        this.zzftj = zzeps6;
        this.zzftk = zzeps7;
        this.zzezx = zzeps8;
        this.zzfmo = zzeps9;
        this.zzftl = zzeps10;
    }

    public static zzbmg zza(zzbob zzbob, Context context, zzdmx zzdmx, View view, zzbdv zzbdv, zzbnz zzbnz, zzccl zzccl, zzbyc zzbyc, zzeoz<zzcxi> zzeoz, Executor executor) {
        return new zzbmg(zzbob, context, zzdmx, view, zzbdv, zzbnz, zzccl, zzbyc, zzeoz, executor);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfav.get(), this.zzevi.get(), this.zzfth.get(), this.zzfqk.get(), this.zzfti.get(), this.zzftj.get(), this.zzftk.get(), this.zzezx.get(), zzepg.zzat(this.zzfmo), this.zzftl.get());
    }
}

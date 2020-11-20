package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

public final class zzcid implements zzepf<zzchp> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzacg> zzfgk;
    private final zzeps<zzazh> zzfpc;
    private final zzeps<zzbua> zzftt;
    private final zzeps<zzef> zzgbn;
    private final zzeps<zzts> zzggv;
    private final zzeps<zzbed> zzghz;
    private final zzeps<zzb> zzgiq;
    private final zzeps<zzbyw> zzgir;

    private zzcid(zzeps<zzbed> zzeps, zzeps<Context> zzeps2, zzeps<zzef> zzeps3, zzeps<zzacg> zzeps4, zzeps<zzazh> zzeps5, zzeps<zzb> zzeps6, zzeps<zzts> zzeps7, zzeps<zzbua> zzeps8, zzeps<zzbyw> zzeps9) {
        this.zzghz = zzeps;
        this.zzevi = zzeps2;
        this.zzgbn = zzeps3;
        this.zzfgk = zzeps4;
        this.zzfpc = zzeps5;
        this.zzgiq = zzeps6;
        this.zzggv = zzeps7;
        this.zzftt = zzeps8;
        this.zzgir = zzeps9;
    }

    public static zzcid zzb(zzeps<zzbed> zzeps, zzeps<Context> zzeps2, zzeps<zzef> zzeps3, zzeps<zzacg> zzeps4, zzeps<zzazh> zzeps5, zzeps<zzb> zzeps6, zzeps<zzts> zzeps7, zzeps<zzbua> zzeps8, zzeps<zzbyw> zzeps9) {
        return new zzcid(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8, zzeps9);
    }

    public final /* synthetic */ Object get() {
        return new zzchp(this.zzghz.get(), this.zzevi.get(), this.zzgbn.get(), this.zzfgk.get(), this.zzfpc.get(), this.zzgiq.get(), this.zzggv.get(), this.zzftt.get(), this.zzgir.get());
    }
}

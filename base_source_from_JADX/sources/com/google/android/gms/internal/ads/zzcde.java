package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.Executor;

public final class zzcde implements zzepf<zzcda> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzcci> zzeye;
    private final zzeps<zzcdi> zzfbf;
    private final zzeps<zzcdq> zzfbg;
    private final zzeps<zzcbz> zzfbi;
    private final zzeps<zzf> zzfcl;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<zzcce> zzgbm;

    private zzcde(zzeps<zzf> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzcci> zzeps3, zzeps<zzcce> zzeps4, zzeps<zzcdi> zzeps5, zzeps<zzcdq> zzeps6, zzeps<Executor> zzeps7, zzeps<Executor> zzeps8, zzeps<zzcbz> zzeps9) {
        this.zzfcl = zzeps;
        this.zzfts = zzeps2;
        this.zzeye = zzeps3;
        this.zzgbm = zzeps4;
        this.zzfbf = zzeps5;
        this.zzfbg = zzeps6;
        this.zzftl = zzeps7;
        this.zzevg = zzeps8;
        this.zzfbi = zzeps9;
    }

    public static zzcde zza(zzeps<zzf> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzcci> zzeps3, zzeps<zzcce> zzeps4, zzeps<zzcdi> zzeps5, zzeps<zzcdq> zzeps6, zzeps<Executor> zzeps7, zzeps<Executor> zzeps8, zzeps<zzcbz> zzeps9) {
        return new zzcde(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8, zzeps9);
    }

    public final /* synthetic */ Object get() {
        return new zzcda(this.zzfcl.get(), this.zzfts.get(), this.zzeye.get(), this.zzgbm.get(), this.zzfbf.get(), this.zzfbg.get(), this.zzftl.get(), this.zzevg.get(), this.zzfbi.get());
    }
}

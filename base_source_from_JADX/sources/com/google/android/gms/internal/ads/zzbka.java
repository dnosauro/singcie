package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbka implements zzepf<zzbjv> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<zzdnv> zzeyt;
    private final zzeps<zzdrx> zzffv;
    private final zzeps<zzacg> zzfgk;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzdnj> zzfqi;
    private final zzeps<zzdmu> zzfqj;
    private final zzeps<View> zzfqk;
    private final zzeps<zzef> zzfql;
    private final zzeps<zzacl> zzfqm;

    private zzbka(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzdrx> zzeps6, zzeps<zzdnv> zzeps7, zzeps<View> zzeps8, zzeps<zzef> zzeps9, zzeps<zzacg> zzeps10, zzeps<zzacl> zzeps11) {
        this.zzevi = zzeps;
        this.zzevg = zzeps2;
        this.zzfqh = zzeps3;
        this.zzfqi = zzeps4;
        this.zzfqj = zzeps5;
        this.zzffv = zzeps6;
        this.zzeyt = zzeps7;
        this.zzfqk = zzeps8;
        this.zzfql = zzeps9;
        this.zzfgk = zzeps10;
        this.zzfqm = zzeps11;
    }

    public static zzbka zza(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<ScheduledExecutorService> zzeps3, zzeps<zzdnj> zzeps4, zzeps<zzdmu> zzeps5, zzeps<zzdrx> zzeps6, zzeps<zzdnv> zzeps7, zzeps<View> zzeps8, zzeps<zzef> zzeps9, zzeps<zzacg> zzeps10, zzeps<zzacl> zzeps11) {
        return new zzbka(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8, zzeps9, zzeps10, zzeps11);
    }

    public final /* synthetic */ Object get() {
        return new zzbjv(this.zzevi.get(), this.zzevg.get(), this.zzfqh.get(), this.zzfqi.get(), this.zzfqj.get(), this.zzffv.get(), this.zzeyt.get(), this.zzfqk.get(), this.zzfql.get(), this.zzfgk.get(), this.zzfqm.get());
    }
}

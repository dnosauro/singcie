package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzdla implements zzepf<zzdkv> {
    private final zzeps<zzbgm> zzeve;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzcxq> zzgwr;
    private final zzeps<Context> zzhcz;
    private final zzeps<zzdnp> zzhdb;
    private final zzeps<zzdlf> zzhfr;

    public zzdla(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbgm> zzeps3, zzeps<zzcxq> zzeps4, zzeps<zzdlf> zzeps5, zzeps<zzdnp> zzeps6) {
        this.zzhcz = zzeps;
        this.zzftl = zzeps2;
        this.zzeve = zzeps3;
        this.zzgwr = zzeps4;
        this.zzhfr = zzeps5;
        this.zzhdb = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzdkv(this.zzhcz.get(), this.zzftl.get(), this.zzeve.get(), this.zzgwr.get(), this.zzhfr.get(), this.zzhdb.get());
    }
}

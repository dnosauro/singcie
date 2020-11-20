package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzdia implements zzepf<zzdib> {
    private final zzeps<zzbgm> zzeve;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdir> zzgwr;
    private final zzeps<Context> zzhcz;
    private final zzeps<zzdkl<zzblg, zzbll>> zzhda;
    private final zzeps<zzdnp> zzhdb;

    public zzdia(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbgm> zzeps3, zzeps<zzdkl<zzblg, zzbll>> zzeps4, zzeps<zzdir> zzeps5, zzeps<zzdnp> zzeps6) {
        this.zzhcz = zzeps;
        this.zzftl = zzeps2;
        this.zzeve = zzeps3;
        this.zzhda = zzeps4;
        this.zzgwr = zzeps5;
        this.zzhdb = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzdib(this.zzhcz.get(), this.zzftl.get(), this.zzeve.get(), this.zzhda.get(), this.zzgwr.get(), this.zzhdb.get());
    }
}

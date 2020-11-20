package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzdjc implements zzepf<zzdjd> {
    private final zzeps<zzbgm> zzeve;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdir> zzgwr;
    private final zzeps<Context> zzhcz;
    private final zzeps<zzdkl<zzblp, zzblv>> zzhda;
    private final zzeps<zzdnp> zzhdb;

    public zzdjc(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbgm> zzeps3, zzeps<zzdkl<zzblp, zzblv>> zzeps4, zzeps<zzdir> zzeps5, zzeps<zzdnp> zzeps6) {
        this.zzhcz = zzeps;
        this.zzftl = zzeps2;
        this.zzeve = zzeps3;
        this.zzhda = zzeps4;
        this.zzgwr = zzeps5;
        this.zzhdb = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzdjd(this.zzhcz.get(), this.zzftl.get(), this.zzeve.get(), this.zzhda.get(), this.zzgwr.get(), this.zzhdb.get());
    }
}

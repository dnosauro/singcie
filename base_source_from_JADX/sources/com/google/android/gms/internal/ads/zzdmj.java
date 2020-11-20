package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzdmj implements zzepf<zzdma> {
    private final zzeps<zzbgm> zzeve;
    private final zzeps<zzdni> zzfnq;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzdlf> zzgwr;
    private final zzeps<Context> zzhcz;
    private final zzeps<zzdkl<zzchf, zzchc>> zzhda;
    private final zzeps<zzdnp> zzhdb;

    public zzdmj(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzbgm> zzeps3, zzeps<zzdkl<zzchf, zzchc>> zzeps4, zzeps<zzdlf> zzeps5, zzeps<zzdnp> zzeps6, zzeps<zzdni> zzeps7) {
        this.zzhcz = zzeps;
        this.zzftl = zzeps2;
        this.zzeve = zzeps3;
        this.zzhda = zzeps4;
        this.zzgwr = zzeps5;
        this.zzhdb = zzeps6;
        this.zzfnq = zzeps7;
    }

    public final /* synthetic */ Object get() {
        return new zzdma(this.zzhcz.get(), this.zzftl.get(), this.zzeve.get(), this.zzhda.get(), this.zzgwr.get(), this.zzhdb.get(), this.zzfnq.get());
    }
}

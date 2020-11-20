package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcyi implements zzepf<zzcyg> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzvn> zzgwo;
    private final zzeps<String> zzgwp;
    private final zzeps<zzdkv> zzgwq;
    private final zzeps<zzcxq> zzgwr;
    private final zzeps<zzdlf> zzgws;

    public zzcyi(zzeps<Context> zzeps, zzeps<zzvn> zzeps2, zzeps<String> zzeps3, zzeps<zzdkv> zzeps4, zzeps<zzcxq> zzeps5, zzeps<zzdlf> zzeps6) {
        this.zzevi = zzeps;
        this.zzgwo = zzeps2;
        this.zzgwp = zzeps3;
        this.zzgwq = zzeps4;
        this.zzgwr = zzeps5;
        this.zzgws = zzeps6;
    }

    public final /* synthetic */ Object get() {
        return new zzcyg(this.zzevi.get(), this.zzgwo.get(), this.zzgwp.get(), this.zzgwq.get(), this.zzgwr.get(), this.zzgws.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

public final class zzbqn implements zzepf<zzbqo> {
    private final zzeps<zzclp> zzewe;
    private final zzeps<zzf> zzfcl;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<zzdnn> zzfts;
    private final zzeps<Context> zzfwi;

    private zzbqn(zzeps<Context> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzf> zzeps4, zzeps<zzclp> zzeps5) {
        this.zzfwi = zzeps;
        this.zzfts = zzeps2;
        this.zzfrq = zzeps3;
        this.zzfcl = zzeps4;
        this.zzewe = zzeps5;
    }

    public static zzbqn zzb(zzeps<Context> zzeps, zzeps<zzdnn> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzf> zzeps4, zzeps<zzclp> zzeps5) {
        return new zzbqn(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzbqo(this.zzfwi.get(), this.zzfts.get(), this.zzfrq.get(), this.zzfcl.get(), this.zzewe.get());
    }
}

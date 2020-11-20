package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

public final class zzdsa implements zzepf<zzdrx> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdni> zzfnq;
    private final zzeps<zzef> zzfql;
    private final zzeps<Clock> zzfrf;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<String> zzgyu;
    private final zzeps<String> zzgyy;
    private final zzeps<zzcum> zzhpd;

    private zzdsa(zzeps<zzcum> zzeps, zzeps<zzazh> zzeps2, zzeps<String> zzeps3, zzeps<String> zzeps4, zzeps<Context> zzeps5, zzeps<zzdni> zzeps6, zzeps<Clock> zzeps7, zzeps<zzef> zzeps8) {
        this.zzhpd = zzeps;
        this.zzfrq = zzeps2;
        this.zzgyu = zzeps3;
        this.zzgyy = zzeps4;
        this.zzevi = zzeps5;
        this.zzfnq = zzeps6;
        this.zzfrf = zzeps7;
        this.zzfql = zzeps8;
    }

    public static zzdsa zza(zzeps<zzcum> zzeps, zzeps<zzazh> zzeps2, zzeps<String> zzeps3, zzeps<String> zzeps4, zzeps<Context> zzeps5, zzeps<zzdni> zzeps6, zzeps<Clock> zzeps7, zzeps<zzef> zzeps8) {
        return new zzdsa(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6, zzeps7, zzeps8);
    }

    public final /* synthetic */ Object get() {
        return new zzdrx(this.zzhpd.get(), this.zzfrq.get(), this.zzgyu.get(), this.zzgyy.get(), this.zzevi.get(), this.zzfnq.get(), this.zzfrf.get(), this.zzfql.get());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtc;

public final class zzcwc<AdT, AdapterT, ListenerT extends zzbtc> implements zzepf<zzcvy<AdT, AdapterT, ListenerT>> {
    private final zzeps<zzcre<AdapterT, ListenerT>> zzfpd;
    private final zzeps<zzdzc> zzftl;
    private final zzeps<zzdro> zzftw;
    private final zzeps<zzcrh<AdT, AdapterT, ListenerT>> zzguh;

    private zzcwc(zzeps<zzdro> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcre<AdapterT, ListenerT>> zzeps3, zzeps<zzcrh<AdT, AdapterT, ListenerT>> zzeps4) {
        this.zzftw = zzeps;
        this.zzftl = zzeps2;
        this.zzfpd = zzeps3;
        this.zzguh = zzeps4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbtc> zzcwc<AdT, AdapterT, ListenerT> zzf(zzeps<zzdro> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcre<AdapterT, ListenerT>> zzeps3, zzeps<zzcrh<AdT, AdapterT, ListenerT>> zzeps4) {
        return new zzcwc<>(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzcvy(this.zzftw.get(), this.zzftl.get(), this.zzfpd.get(), this.zzguh.get());
    }
}

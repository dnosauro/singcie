package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbpn implements zzepf<zzbpo> {
    private final zzeps<Clock> zzfrf;
    private final zzeps<zzayf> zzfwb;

    private zzbpn(zzeps<Clock> zzeps, zzeps<zzayf> zzeps2) {
        this.zzfrf = zzeps;
        this.zzfwb = zzeps2;
    }

    public static zzbpn zzd(zzeps<Clock> zzeps, zzeps<zzayf> zzeps2) {
        return new zzbpn(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbpo(this.zzfrf.get(), this.zzfwb.get());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbxk implements zzepf<zzcum> {
    private final zzeps<zzcuo> zzfdl;
    private final zzeps<zzcrg> zzfdm;
    private final zzeps<Clock> zzfrf;
    private final zzbwp zzfzf;

    private zzbxk(zzbwp zzbwp, zzeps<Clock> zzeps, zzeps<zzcuo> zzeps2, zzeps<zzcrg> zzeps3) {
        this.zzfzf = zzbwp;
        this.zzfrf = zzeps;
        this.zzfdl = zzeps2;
        this.zzfdm = zzeps3;
    }

    public static zzbxk zza(zzbwp zzbwp, zzeps<Clock> zzeps, zzeps<zzcuo> zzeps2, zzeps<zzcrg> zzeps3) {
        return new zzbxk(zzbwp, zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzcum) zzepl.zza(this.zzfzf.zza(this.zzfrf.get(), this.zzfdl.get(), this.zzfdm.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

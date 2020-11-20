package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzdrt implements zzepf<zzdro> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<zzdrn> zzfdi;
    private final zzeps<ScheduledExecutorService> zzfsz;

    private zzdrt(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<zzdrn> zzeps3) {
        this.zzevg = zzeps;
        this.zzfsz = zzeps2;
        this.zzfdi = zzeps3;
    }

    public static zzdrt zzx(zzeps<zzdzc> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<zzdrn> zzeps3) {
        return new zzdrt(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdro(this.zzevg.get(), this.zzfsz.get(), this.zzfdi.get());
    }
}

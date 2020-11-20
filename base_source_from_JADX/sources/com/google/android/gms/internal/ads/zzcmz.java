package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzcmz implements zzepf<zzcmx> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<ScheduledExecutorService> zzfqh;
    private final zzeps<zzcnw> zzgmg;
    private final zzeps<zzcou> zzgmh;

    public zzcmz(zzeps<ScheduledExecutorService> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcnw> zzeps3, zzeps<zzcou> zzeps4) {
        this.zzfqh = zzeps;
        this.zzevg = zzeps2;
        this.zzgmg = zzeps3;
        this.zzgmh = zzeps4;
    }

    public final /* synthetic */ Object get() {
        return new zzcmx(this.zzfqh.get(), this.zzevg.get(), this.zzgmg.get(), zzepg.zzat(this.zzgmh));
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdhk implements zzepf<zzdhi> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzarr> zzewn;
    private final zzeps<ScheduledExecutorService> zzfqh;

    public zzdhk(zzeps<zzarr> zzeps, zzeps<ScheduledExecutorService> zzeps2, zzeps<Context> zzeps3) {
        this.zzewn = zzeps;
        this.zzfqh = zzeps2;
        this.zzevi = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return new zzdhi(this.zzewn.get(), this.zzfqh.get(), this.zzevi.get());
    }
}

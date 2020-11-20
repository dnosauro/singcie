package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public final class zzdqu implements zzepf<ScheduledExecutorService> {
    private final zzeps<ThreadFactory> zzhnk;

    public zzdqu(zzeps<ThreadFactory> zzeps) {
        this.zzhnk = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (ScheduledExecutorService) zzepl.zza(zzduo.zzayg().zzb(1, this.zzhnk.get(), zzdut.zzhsl), "Cannot return null from a non-@Nullable @Provides method");
    }
}

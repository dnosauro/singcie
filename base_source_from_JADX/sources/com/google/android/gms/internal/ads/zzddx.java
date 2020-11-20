package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfj;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzddx<S extends zzdfj<?>> implements zzdfi<S> {
    private final ScheduledExecutorService zzfru;
    private final zzdfi<S> zzgzk;
    private final long zzhak;

    public zzddx(zzdfi<S> zzdfi, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zzgzk = zzdfi;
        this.zzhak = j;
        this.zzfru = scheduledExecutorService;
    }

    public final zzdyz<S> zzasm() {
        zzdyz<S> zzasm = this.zzgzk.zzasm();
        long j = this.zzhak;
        if (j > 0) {
            zzasm = zzdyr.zza(zzasm, j, TimeUnit.MILLISECONDS, this.zzfru);
        }
        return zzdyr.zzb(zzasm, Throwable.class, zzddw.zzbon, zzazj.zzegu);
    }
}

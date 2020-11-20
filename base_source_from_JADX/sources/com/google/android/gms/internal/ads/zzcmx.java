package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcmx {
    private final ScheduledExecutorService zzfpq;
    private final zzdzc zzggb;
    private final zzeoz<zzcou> zzgmb;
    private final zzcnw zzgmn;

    public zzcmx(ScheduledExecutorService scheduledExecutorService, zzdzc zzdzc, zzcnw zzcnw, zzeoz<zzcou> zzeoz) {
        this.zzfpq = scheduledExecutorService;
        this.zzggb = zzdzc;
        this.zzgmn = zzcnw;
        this.zzgmb = zzeoz;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzatl zzatl, int i, Throwable th) {
        return this.zzgmb.get().zzd(zzatl, i);
    }

    public final zzdyz<InputStream> zzg(zzatl zzatl) {
        String str = zzatl.packageName;
        zzp.zzkq();
        return zzdyi.zzg(zzm.zzen(str) ? zzdyr.immediateFailedFuture(new zzcoh(zzdok.INTERNAL_ERROR)) : this.zzgmn.zzj(zzatl)).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS, this.zzfpq).zza(Throwable.class, new zzcna(this, zzatl, Binder.getCallingUid()), (Executor) this.zzggb);
    }
}

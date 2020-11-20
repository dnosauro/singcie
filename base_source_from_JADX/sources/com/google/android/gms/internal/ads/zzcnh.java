package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzcnh implements zzcoi {
    /* access modifiers changed from: private */
    public static final Pattern zzgmv = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzfpq;
    private final zzdnn zzfvl;
    private final zzdzc zzggb;
    private final zzcmd zzgmt;
    /* access modifiers changed from: private */
    public final zzcpx zzgmu;

    zzcnh(zzdnn zzdnn, zzcmd zzcmd, zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, zzcpx zzcpx) {
        this.zzfvl = zzdnn;
        this.zzgmt = zzcmd;
        this.zzggb = zzdzc;
        this.zzfpq = scheduledExecutorService;
        this.zzgmu = zzcpx;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zze(InputStream inputStream) {
        return zzdyr.zzag(new zzdnj(new zzdne(this.zzfvl), zzdnh.zza(new InputStreamReader(inputStream))));
    }

    public final zzdyz<zzdnj> zzh(zzatl zzatl) {
        zzdyz<zzdnj> zzb = zzdyr.zzb(this.zzgmt.zze(zzatl), new zzcnk(this), (Executor) this.zzggb);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvi)).booleanValue()) {
            zzb = zzdyr.zzb(zzdyr.zza(zzb, (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS, this.zzfpq), TimeoutException.class, zzcnj.zzbon, zzazj.zzegu);
        }
        zzdyr.zza(zzb, new zzcnm(this), zzazj.zzegu);
        return zzb;
    }
}

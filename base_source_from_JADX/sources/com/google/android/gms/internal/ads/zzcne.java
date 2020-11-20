package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzcne extends zzcnc {
    /* access modifiers changed from: private */
    public static final Pattern zzgmv = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzfpq;
    private final zzdnn zzfvl;
    private final zzdzc zzggb;
    private final zzcmd zzgmt;
    /* access modifiers changed from: private */
    public final zzcpx zzgmu;

    zzcne(zzbuh zzbuh, zzdnn zzdnn, zzcmd zzcmd, zzdzc zzdzc, ScheduledExecutorService scheduledExecutorService, zzcpx zzcpx) {
        super(zzbuh);
        this.zzfvl = zzdnn;
        this.zzgmt = zzcmd;
        this.zzggb = zzdzc;
        this.zzfpq = scheduledExecutorService;
        this.zzgmu = zzcpx;
    }

    public final zzdyz<zzdnj> zzb(zzatl zzatl) {
        zzdyz<zzdnj> zzb = zzdyr.zzb(this.zzgmt.zze(zzatl), new zzcnd(this), (Executor) this.zzggb);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvi)).booleanValue()) {
            zzb = zzdyr.zzb(zzdyr.zza(zzb, (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS, this.zzfpq), TimeoutException.class, zzcng.zzbon, zzazj.zzegu);
        }
        zzdyr.zza(zzb, new zzcnf(this), zzazj.zzegu);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzd(InputStream inputStream) {
        return zzdyr.zzag(new zzdnj(new zzdne(this.zzfvl), zzdnh.zza(new InputStreamReader(inputStream))));
    }
}

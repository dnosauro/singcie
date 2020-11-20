package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class zzcmd {
    private final zzdzc zzggb;
    private final zzdzc zzglz;
    private final zzcns zzgma;
    private final zzeoz<zzcou> zzgmb;

    public zzcmd(zzdzc zzdzc, zzdzc zzdzc2, zzcns zzcns, zzeoz<zzcou> zzeoz) {
        this.zzglz = zzdzc;
        this.zzggb = zzdzc2;
        this.zzgma = zzcns;
        this.zzgmb = zzeoz;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzatl zzatl, int i, zzcoh zzcoh) {
        return this.zzgmb.get().zzb(zzatl, i);
    }

    public final zzdyz<InputStream> zze(zzatl zzatl) {
        String str = zzatl.packageName;
        zzp.zzkq();
        return zzdyr.zzb(zzm.zzen(str) ? zzdyr.immediateFailedFuture(new zzcoh(zzdok.INTERNAL_ERROR)) : zzdyr.zzb(this.zzglz.zze(new zzcmg(this, zzatl)), ExecutionException.class, zzcmf.zzbon, this.zzggb), zzcoh.class, new zzcmi(this, zzatl, Binder.getCallingUid()), this.zzggb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzf(zzatl zzatl) {
        return (InputStream) this.zzgma.zzi(zzatl).get((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS);
    }
}

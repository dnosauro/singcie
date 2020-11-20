package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

final class zzcul implements zzdyo<T> {
    private final /* synthetic */ zzdmz zzghr;
    private final /* synthetic */ long zzgsw;
    private final /* synthetic */ String zzgsx;
    private final /* synthetic */ zzdmu zzgsy;
    private final /* synthetic */ zzcum zzgsz;

    zzcul(zzcum zzcum, long j, String str, zzdmu zzdmu, zzdmz zzdmz) {
        this.zzgsz = zzcum;
        this.zzgsw = j;
        this.zzgsx = str;
        this.zzgsy = zzdmu;
        this.zzghr = zzdmz;
    }

    public final void onSuccess(T t) {
        long elapsedRealtime = this.zzgsz.zzbpw.elapsedRealtime() - this.zzgsw;
        this.zzgsz.zza(this.zzgsx, 0, elapsedRealtime, this.zzgsy.zzhhn);
        if (this.zzgsz.zzgtc) {
            this.zzgsz.zzgta.zza(this.zzghr, this.zzgsy, 0, (zzcrd) null, elapsedRealtime);
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            this.zzgsz.zzfvu.zza(this.zzgsy, elapsedRealtime, (zzve) null);
        }
    }

    public final void zzb(Throwable th) {
        long elapsedRealtime = this.zzgsz.zzbpw.elapsedRealtime() - this.zzgsw;
        int i = th instanceof TimeoutException ? 2 : th instanceof zzcuc ? 3 : th instanceof CancellationException ? 4 : th instanceof zzdnr ? 5 : (!(th instanceof zzcme) || zzdoi.zzh(th).errorCode != 3) ? 6 : 1;
        this.zzgsz.zza(this.zzgsx, i, elapsedRealtime, this.zzgsy.zzhhn);
        if (this.zzgsz.zzgtc) {
            this.zzgsz.zzgta.zza(this.zzghr, this.zzgsy, i, th instanceof zzcrd ? (zzcrd) th : null, elapsedRealtime);
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            zzve zzh = zzdoi.zzh(th);
            if ((zzh.errorCode == 3 || zzh.errorCode == 0) && zzh.zzcgu != null && !zzh.zzcgu.zzcgt.equals(MobileAds.ERROR_DOMAIN)) {
                zzh = zzdoi.zzh(new zzcrd(zzdok.MEDIATION_NO_FILL, zzh.zzcgu));
            }
            this.zzgsz.zzfvu.zza(this.zzgsy, elapsedRealtime, zzh);
        }
    }
}

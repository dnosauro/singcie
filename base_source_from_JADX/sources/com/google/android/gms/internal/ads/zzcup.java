package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcup<AdT> implements zzdyb<zzdnj, AdT> {
    private final Executor executor;
    private final zzdrx zzfpt;
    private final zzdrz zzfqa;
    private final ScheduledExecutorService zzfru;
    private final zzdro zzfvm;
    private final zzcrg zzfvu;
    private final zzbrx zzfzd;
    private final zzbod<AdT> zzgtd;
    private final zzcum zzgte;

    public zzcup(zzdro zzdro, zzcum zzcum, zzbrx zzbrx, zzdrx zzdrx, zzdrz zzdrz, zzbod<AdT> zzbod, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzcrg zzcrg) {
        this.zzfvm = zzdro;
        this.zzgte = zzcum;
        this.zzfzd = zzbrx;
        this.zzfpt = zzdrx;
        this.zzfqa = zzdrz;
        this.zzgtd = zzbod;
        this.executor = executor2;
        this.zzfru = scheduledExecutorService;
        this.zzfvu = zzcrg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdnj zzdnj, zzdmu zzdmu, zzcqz zzcqz, Throwable th) {
        return this.zzgte.zza(zzdnj.zzhik.zzerj, zzdmu, zzdyr.zza(zzcqz.zzb(zzdnj, zzdmu), (long) zzdmu.zzhhh, TimeUnit.MILLISECONDS, this.zzfru));
    }

    public final /* synthetic */ zzdyz zzf(Object obj) {
        boolean z;
        int i;
        zzdnj zzdnj = (zzdnj) obj;
        String str = "No ad config.";
        int i2 = zzdnj.zzhik.zzerj.responseCode;
        if (i2 != 0) {
            if (i2 >= 200 && i2 < 300) {
                if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcvg)).booleanValue()) {
                    str = "No fill.";
                }
            } else if (i2 < 300 || i2 >= 400) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Received error HTTP response code: ");
                sb.append(i2);
                str = sb.toString();
            } else {
                str = "No location header to follow redirect or too many redirects.";
            }
        }
        zzdmw zzdmw = zzdnj.zzhik.zzerj.zzhhz;
        if (zzdmw != null) {
            str = zzdmw.getDescription();
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcza)).booleanValue() && ((i = zzdnj.zzhik.zzerj.responseCode) < 200 || i >= 300)) {
            return zzdyr.immediateFailedFuture(new zzcuq(zzdok.NO_FILL, str));
        }
        zzdqx<E, I> zzaww = this.zzfvm.zzu(zzdrl.RENDER_CONFIG_INIT).zze(zzdyr.immediateFailedFuture(new zzcuq(zzdok.NO_FILL, str))).zzaww();
        this.zzfzd.zza(new zzbjw(zzdnj, this.zzfqa, this.zzfpt), this.executor);
        int i3 = 0;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczb)).booleanValue()) {
            for (zzdmu next : zzdnj.zzhik.zzhih) {
                this.zzfvu.zzd(next);
                Iterator<String> it = next.zzhgo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    zzcqz<AdT> zze = this.zzgtd.zze(next.zzhgp, it.next());
                    if (zze != null && zze.zza(zzdnj, next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.zzfvu.zza(next, 0, zzdoi.zza(zzdok.INTERNAL_ERROR, (String) null, (zzve) null));
                }
            }
        }
        for (zzdmu next2 : zzdnj.zzhik.zzhih) {
            Iterator<String> it2 = next2.zzhgo.iterator();
            while (true) {
                if (it2.hasNext()) {
                    String next3 = it2.next();
                    zzcqz<AdT> zze2 = this.zzgtd.zze(next2.zzhgp, next3);
                    if (zze2 != null && zze2.zza(zzdnj, next2)) {
                        zzdrg<I> zza = this.zzfvm.zza(zzdrl.RENDER_CONFIG_WATERFALL, zzaww);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(next3).length() + 26);
                        sb2.append("render-config-");
                        sb2.append(i3);
                        sb2.append("-");
                        sb2.append(next3);
                        zzaww = zza.zzgu(sb2.toString()).zza(Throwable.class, new zzcus(this, zzdnj, next2, zze2)).zzaww();
                        break;
                    }
                } else {
                    break;
                }
            }
            i3++;
        }
        return zzaww;
    }
}

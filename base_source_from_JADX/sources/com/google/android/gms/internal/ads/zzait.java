package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzait implements zzx {
    private final Context context;
    /* access modifiers changed from: private */
    public volatile zzaii zzdhl;

    public zzait(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdhl != null) {
            this.zzdhl.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzy zzc(zzaa<?> zzaa) {
        zzail zzh = zzail.zzh(zzaa);
        long elapsedRealtime = zzp.zzkx().elapsedRealtime();
        try {
            zzazq zzazq = new zzazq();
            this.zzdhl = new zzaii(this.context, zzp.zzle().zzyw(), new zzaix(this, zzazq), new zzaiw(this, zzazq));
            this.zzdhl.checkAvailabilityAndConnect();
            zzdyz zza = zzdyr.zza(zzdyr.zzb(zzazq, new zzais(this, zzh), (Executor) zzazj.zzegp), (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzctm)).intValue(), TimeUnit.MILLISECONDS, zzazj.zzegs);
            zza.addListener(new zzaiu(this), zzazj.zzegp);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzp.zzkx().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzd.zzee(sb.toString());
            zzain zzain = (zzain) new zzatg(parcelFileDescriptor).zza(zzain.CREATOR);
            if (zzain == null) {
                return null;
            }
            if (zzain.zzdhj) {
                throw new zzao(zzain.zzcgs);
            } else if (zzain.zzdhh.length != zzain.zzdhi.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < zzain.zzdhh.length; i++) {
                    hashMap.put(zzain.zzdhh[i], zzain.zzdhi[i]);
                }
                return new zzy(zzain.statusCode, zzain.data, (Map<String, String>) hashMap, zzain.zzam, zzain.zzan);
            }
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(zzp.zzkx().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            zzd.zzee(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime3 = zzp.zzkx().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3);
            sb3.append("ms");
            zzd.zzee(sb3.toString());
            throw th;
        }
    }
}

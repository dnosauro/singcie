package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdzm<V> implements Runnable {
    @NullableDecl
    private zzdzk<V> zzhyb;

    zzdzm(zzdzk<V> zzdzk) {
        this.zzhyb = zzdzk;
    }

    public final void run() {
        zzdyz zza;
        String str;
        zzdzk<V> zzdzk = this.zzhyb;
        if (zzdzk != null && (zza = zzdzk.zzhxz) != null) {
            this.zzhyb = null;
            if (zza.isDone()) {
                zzdzk.setFuture(zza);
                return;
            }
            try {
                ScheduledFuture zzb = zzdzk.zzhya;
                ScheduledFuture unused = zzdzk.zzhya = null;
                str = "Timed out";
                if (zzb != null) {
                    long abs = Math.abs(zzb.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        String valueOf = String.valueOf(str);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 66);
                        sb.append(valueOf);
                        sb.append(" (timeout delayed by ");
                        sb.append(abs);
                        sb.append(" ms after scheduled time)");
                        str = sb.toString();
                    }
                }
                String valueOf2 = String.valueOf(str);
                String valueOf3 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 2 + String.valueOf(valueOf3).length());
                sb2.append(valueOf2);
                sb2.append(": ");
                sb2.append(valueOf3);
                zzdzk.setException(new zzdzl(sb2.toString()));
                zza.cancel(true);
            } catch (Throwable th) {
                zza.cancel(true);
                throw th;
            }
        }
    }
}

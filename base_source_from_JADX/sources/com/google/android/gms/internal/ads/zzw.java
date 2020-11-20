package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzw extends Thread {
    private final BlockingQueue<zzaa<?>> zzaj;
    private final zzx zzak;
    private final zzk zzn;
    private final zzak zzo;
    private volatile boolean zzp = false;

    public zzw(BlockingQueue<zzaa<?>> blockingQueue, zzx zzx, zzk zzk, zzak zzak2) {
        this.zzaj = blockingQueue;
        this.zzak = zzx;
        this.zzn = zzk;
        this.zzo = zzak2;
    }

    private final void processRequest() {
        zzaa take = this.zzaj.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.zzd(3);
        try {
            take.zzc("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zzd());
            zzy zzc = this.zzak.zzc(take);
            take.zzc("network-http-complete");
            if (!zzc.zzam || !take.zzl()) {
                zzaj zza = take.zza(zzc);
                take.zzc("network-parse-complete");
                if (take.zzh() && zza.zzbq != null) {
                    this.zzn.zza(take.zze(), zza.zzbq);
                    take.zzc("network-cache-written");
                }
                take.zzk();
                this.zzo.zzb(take, zza);
                take.zza((zzaj<?>) zza);
                take.zzd(4);
                return;
            }
            take.zzd("not-modified");
            take.zzm();
        } catch (zzao e) {
            e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzo.zza(take, e);
            take.zzm();
        } catch (Exception e2) {
            zzaq.zza(e2, "Unhandled exception %s", e2.toString());
            zzao zzao = new zzao((Throwable) e2);
            zzao.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzo.zza(take, zzao);
            take.zzm();
        } finally {
            take.zzd(4);
        }
    }

    public final void quit() {
        this.zzp = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzp) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.m8703e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}

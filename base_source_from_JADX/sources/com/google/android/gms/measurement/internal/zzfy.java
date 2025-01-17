package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class zzfy extends Thread {
    private final Object zza;
    private final BlockingQueue<zzfz<?>> zzb;
    private boolean zzc = false;
    private final /* synthetic */ zzfu zzd;

    public zzfy(zzfu zzfu, String str, BlockingQueue<zzfz<?>> blockingQueue) {
        this.zzd = zzfu;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zza = new Object();
        this.zzb = blockingQueue;
        setName(str);
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzd.zzq().zzh().zza(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    private final void zzb() {
        synchronized (this.zzd.zzg) {
            if (!this.zzc) {
                this.zzd.zzh.release();
                this.zzd.zzg.notifyAll();
                if (this == this.zzd.zza) {
                    zzfy unused = this.zzd.zza = null;
                } else if (this == this.zzd.zzb) {
                    zzfy unused2 = this.zzd.zzb = null;
                } else {
                    this.zzd.zzq().zze().zza("Current scheduler thread is neither worker nor network");
                }
                this.zzc = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0075, code lost:
        zzb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            if (r0 != 0) goto L_0x0013
            com.google.android.gms.measurement.internal.zzfu r1 = r5.zzd     // Catch:{ InterruptedException -> 0x000e }
            java.util.concurrent.Semaphore r1 = r1.zzh     // Catch:{ InterruptedException -> 0x000e }
            r1.acquire()     // Catch:{ InterruptedException -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x000e:
            r1 = move-exception
            r5.zza(r1)
            goto L_0x0001
        L_0x0013:
            int r0 = android.os.Process.myTid()     // Catch:{ all -> 0x0081 }
            int r0 = android.os.Process.getThreadPriority(r0)     // Catch:{ all -> 0x0081 }
        L_0x001b:
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.zzfz<?>> r1 = r5.zzb     // Catch:{ all -> 0x0081 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0081 }
            com.google.android.gms.measurement.internal.zzfz r1 = (com.google.android.gms.measurement.internal.zzfz) r1     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0034
            boolean r2 = r1.zza     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x002b
            r2 = r0
            goto L_0x002d
        L_0x002b:
            r2 = 10
        L_0x002d:
            android.os.Process.setThreadPriority(r2)     // Catch:{ all -> 0x0081 }
            r1.run()     // Catch:{ all -> 0x0081 }
            goto L_0x001b
        L_0x0034:
            java.lang.Object r1 = r5.zza     // Catch:{ all -> 0x0081 }
            monitor-enter(r1)     // Catch:{ all -> 0x0081 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.zzfz<?>> r2 = r5.zzb     // Catch:{ all -> 0x007e }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0053
            com.google.android.gms.measurement.internal.zzfu r2 = r5.zzd     // Catch:{ all -> 0x007e }
            boolean r2 = r2.zzi     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0053
            java.lang.Object r2 = r5.zza     // Catch:{ InterruptedException -> 0x004f }
            r3 = 30000(0x7530, double:1.4822E-319)
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r2 = move-exception
            r5.zza(r2)     // Catch:{ all -> 0x007e }
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.zzfu r1 = r5.zzd     // Catch:{ all -> 0x0081 }
            java.lang.Object r1 = r1.zzg     // Catch:{ all -> 0x0081 }
            monitor-enter(r1)     // Catch:{ all -> 0x0081 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.zzfz<?>> r2 = r5.zzb     // Catch:{ all -> 0x007b }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x007b }
            if (r2 != 0) goto L_0x0079
            com.google.android.gms.measurement.internal.zzfu r0 = r5.zzd     // Catch:{ all -> 0x007b }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzs()     // Catch:{ all -> 0x007b }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbs     // Catch:{ all -> 0x007b }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)     // Catch:{ all -> 0x007b }
            if (r0 == 0) goto L_0x0074
            r5.zzb()     // Catch:{ all -> 0x007b }
        L_0x0074:
            monitor-exit(r1)     // Catch:{ all -> 0x007b }
            r5.zzb()
            return
        L_0x0079:
            monitor-exit(r1)     // Catch:{ all -> 0x007b }
            goto L_0x001b
        L_0x007b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007b }
            throw r0     // Catch:{ all -> 0x0081 }
        L_0x007e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007e }
            throw r0     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r0 = move-exception
            r5.zzb()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfy.run():void");
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.notifyAll();
        }
    }
}

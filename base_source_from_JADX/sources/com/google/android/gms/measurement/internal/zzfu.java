package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class zzfu extends zzgx {
    /* access modifiers changed from: private */
    public static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzfy zza;
    /* access modifiers changed from: private */
    public zzfy zzb;
    private final PriorityBlockingQueue<zzfz<?>> zzc = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzfz<?>> zzd = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zze = new zzfw(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzf = new zzfw(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzg = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzh = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzi;

    zzfu(zzgb zzgb) {
        super(zzgb);
    }

    private final void zza(zzfz<?> zzfz) {
        synchronized (this.zzg) {
            this.zzc.add(zzfz);
            if (this.zza == null) {
                this.zza = new zzfy(this, "Measurement Worker", this.zzc);
                this.zza.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                this.zza.zza();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(1:18)(1:19)|20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r5.length() == 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r4 = "Timed out waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r4 = new java.lang.String("Timed out waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r3.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = zzq().zzh();
        r5 = java.lang.String.valueOf(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r5.length() != 0) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        r4 = "Interrupted waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        r4 = new java.lang.String("Interrupted waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        r3.zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r2 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = zzq().zzh();
        r5 = java.lang.String.valueOf(r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T zza(java.util.concurrent.atomic.AtomicReference<T> r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzp()     // Catch:{ all -> 0x005a }
            r0.zza((java.lang.Runnable) r6)     // Catch:{ all -> 0x005a }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0035 }
            monitor-exit(r2)     // Catch:{ all -> 0x005a }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzex r3 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzh()
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x002b
            java.lang.String r4 = r4.concat(r5)
            goto L_0x0031
        L_0x002b:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x0031:
            r3.zza(r4)
        L_0x0034:
            return r2
        L_0x0035:
            com.google.android.gms.measurement.internal.zzex r3 = r1.zzq()     // Catch:{ all -> 0x005a }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zzh()     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "Interrupted waiting for "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x005a }
            int r6 = r5.length()     // Catch:{ all -> 0x005a }
            if (r6 == 0) goto L_0x004e
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x005a }
            goto L_0x0054
        L_0x004e:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x005a }
            r5.<init>(r4)     // Catch:{ all -> 0x005a }
            r4 = r5
        L_0x0054:
            r3.zza(r4)     // Catch:{ all -> 0x005a }
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x005a }
            return r3
        L_0x005a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x005a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.zza(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final <V> Future<V> zza(Callable<V> callable) {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzfz zzfz = new zzfz(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                zzq().zzh().zza("Callable skipped the worker queue.");
            }
            zzfz.run();
        } else {
            zza((zzfz<?>) zzfz);
        }
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(Runnable runnable) {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zza((zzfz<?>) new zzfz(this, runnable, false, "Task exception on worker thread"));
    }

    public final <V> Future<V> zzb(Callable<V> callable) {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzfz zzfz = new zzfz(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzfz.run();
        } else {
            zza((zzfz<?>) zzfz);
        }
        return zzfz;
    }

    public final void zzb() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void zzb(Runnable runnable) {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zza((zzfz<?>) new zzfz(this, runnable, true, "Task exception on worker thread"));
    }

    public final void zzc() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void zzc(Runnable runnable) {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zzfz zzfz = new zzfz(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzfz);
            if (this.zzb == null) {
                this.zzb = new zzfy(this, "Measurement Network", this.zzd);
                this.zzb.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                this.zzb.zza();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    public final boolean zzf() {
        return Thread.currentThread() == this.zza;
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }
}

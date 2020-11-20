package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

public class zzdxo<V> extends zzdzr implements zzdyz<V> {
    /* access modifiers changed from: private */
    public static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL = new Object();
    private static final Logger zzhwc = Logger.getLogger(zzdxo.class.getName());
    /* access modifiers changed from: private */
    public static final zza zzhwd;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile Object value;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzk waiters;

    static abstract class zza {
        private zza() {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract void zza(zzk zzk, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdxo<?> zzdxo, zzd zzd, zzd zzd2);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdxo<?> zzdxo, zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdxo<?> zzdxo, Object obj, Object obj2);
    }

    static final class zzb {
        static final zzb zzhwe = new zzb(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        zzb(Throwable th) {
            this.exception = (Throwable) zzdvv.checkNotNull(th);
        }
    }

    static final class zzc {
        static final zzc zzhwf;
        static final zzc zzhwg;
        @NullableDecl
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (zzdxo.GENERATE_CANCELLATION_CAUSES) {
                zzhwg = null;
                zzhwf = null;
                return;
            }
            zzhwg = new zzc(false, (Throwable) null);
            zzhwf = new zzc(true, (Throwable) null);
        }

        zzc(boolean z, @NullableDecl Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    static final class zzd {
        static final zzd zzhwh = new zzd((Runnable) null, (Executor) null);
        final Executor executor;
        @NullableDecl
        zzd next;
        final Runnable task;

        zzd(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }
    }

    static final class zze<V> implements Runnable {
        final zzdyz<? extends V> future;
        final zzdxo<V> zzhwi;

        zze(zzdxo<V> zzdxo, zzdyz<? extends V> zzdyz) {
            this.zzhwi = zzdxo;
            this.future = zzdyz;
        }

        public final void run() {
            if (this.zzhwi.value == this) {
                if (zzdxo.zzhwd.zza((zzdxo<?>) this.zzhwi, (Object) this, zzdxo.getFutureValue(this.future))) {
                    zzdxo.zza((zzdxo<?>) this.zzhwi);
                }
            }
        }
    }

    static final class zzf extends zza {
        final AtomicReferenceFieldUpdater<zzdxo, zzd> listenersUpdater;
        final AtomicReferenceFieldUpdater<zzdxo, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<zzdxo, zzk> waitersUpdater;

        zzf(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdxo, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdxo, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdxo, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, zzk zzk2) {
            this.waiterNextUpdater.lazySet(zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzk, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, zzd zzd, zzd zzd2) {
            return this.listenersUpdater.compareAndSet(zzdxo, zzd, zzd2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, zzk zzk, zzk zzk2) {
            return this.waitersUpdater.compareAndSet(zzdxo, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzdxo, obj, obj2);
        }
    }

    interface zzg<V> extends zzdyz<V> {
    }

    static final class zzh extends zza {
        private zzh() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, zzd zzd, zzd zzd2) {
            synchronized (zzdxo) {
                if (zzdxo.listeners != zzd) {
                    return false;
                }
                zzd unused = zzdxo.listeners = zzd2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, zzk zzk, zzk zzk2) {
            synchronized (zzdxo) {
                if (zzdxo.waiters != zzk) {
                    return false;
                }
                zzk unused = zzdxo.waiters = zzk2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, Object obj, Object obj2) {
            synchronized (zzdxo) {
                if (zzdxo.value != obj) {
                    return false;
                }
                Object unused = zzdxo.value = obj2;
                return true;
            }
        }
    }

    static final class zzi extends zza {
        static final Unsafe zzhwj;
        static final long zzhwk;
        static final long zzhwl;
        static final long zzhwm;
        static final long zzhwn;
        static final long zzhwo;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x005f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x006b, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:?, code lost:
            r0 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzdxo.zzi.C22391());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
        static {
            /*
                sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                goto L_0x0010
            L_0x0005:
                com.google.android.gms.internal.ads.zzdxo$zzi$1 r0 = new com.google.android.gms.internal.ads.zzdxo$zzi$1     // Catch:{ PrivilegedActionException -> 0x005f }
                r0.<init>()     // Catch:{ PrivilegedActionException -> 0x005f }
                java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x005f }
                sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x005f }
            L_0x0010:
                java.lang.Class<com.google.android.gms.internal.ads.zzdxo> r1 = com.google.android.gms.internal.ads.zzdxo.class
                java.lang.String r2 = "waiters"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0055 }
                zzhwl = r2     // Catch:{ Exception -> 0x0055 }
                java.lang.String r2 = "listeners"
                java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r2 = r0.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0055 }
                zzhwk = r2     // Catch:{ Exception -> 0x0055 }
                java.lang.String r2 = "value"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                zzhwm = r1     // Catch:{ Exception -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.ads.zzdxo$zzk> r1 = com.google.android.gms.internal.ads.zzdxo.zzk.class
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                zzhwn = r1     // Catch:{ Exception -> 0x0055 }
                java.lang.Class<com.google.android.gms.internal.ads.zzdxo$zzk> r1 = com.google.android.gms.internal.ads.zzdxo.zzk.class
                java.lang.String r2 = "next"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ Exception -> 0x0055 }
                long r1 = r0.objectFieldOffset(r1)     // Catch:{ Exception -> 0x0055 }
                zzhwo = r1     // Catch:{ Exception -> 0x0055 }
                zzhwj = r0     // Catch:{ Exception -> 0x0055 }
                return
            L_0x0055:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzdwe.zzi(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005f:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.zzi.<clinit>():void");
        }

        private zzi() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, zzk zzk2) {
            zzhwj.putObject(zzk, zzhwo, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            zzhwj.putObject(zzk, zzhwn, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, zzd zzd, zzd zzd2) {
            return zzhwj.compareAndSwapObject(zzdxo, zzhwk, zzd, zzd2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, zzk zzk, zzk zzk2) {
            return zzhwj.compareAndSwapObject(zzdxo, zzhwl, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdxo<?> zzdxo, Object obj, Object obj2) {
            return zzhwj.compareAndSwapObject(zzdxo, zzhwm, obj, obj2);
        }
    }

    static abstract class zzj<V> extends zzdxo<V> implements zzg<V> {
        zzj() {
        }

        public final V get(long j, TimeUnit timeUnit) {
            return zzdxo.super.get(j, timeUnit);
        }
    }

    static final class zzk {
        static final zzk zzhwp = new zzk(false);
        @NullableDecl
        volatile zzk next;
        @NullableDecl
        volatile Thread thread;

        zzk() {
            zzdxo.zzhwd.zza(this, Thread.currentThread());
        }

        private zzk(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzk zzk) {
            zzdxo.zzhwd.zza(this, zzk);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        try {
            zza2 = new zzi();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th;
            th2 = th3;
            zza2 = new zzh();
        }
        zzhwd = zza2;
        if (th2 != null) {
            zzhwc.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            zzhwc.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
    }

    protected zzdxo() {
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(zzdyz<?> zzdyz) {
        Throwable zza2;
        if (zzdyz instanceof zzg) {
            Object obj = ((zzdxo) zzdyz).value;
            if (!(obj instanceof zzc)) {
                return obj;
            }
            zzc zzc2 = (zzc) obj;
            return zzc2.wasInterrupted ? zzc2.cause != null ? new zzc(false, zzc2.cause) : zzc.zzhwg : obj;
        } else if ((zzdyz instanceof zzdzr) && (zza2 = zzdzu.zza((zzdzr) zzdyz)) != null) {
            return new zzb(zza2);
        } else {
            boolean isCancelled = zzdyz.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
                return zzc.zzhwg;
            }
            try {
                Object uninterruptibly = getUninterruptibly(zzdyz);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                String valueOf = String.valueOf(zzdyz);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zzc(false, new IllegalArgumentException(sb.toString()));
            } catch (ExecutionException e) {
                if (!isCancelled) {
                    return new zzb(e.getCause());
                }
                String valueOf2 = String.valueOf(zzdyz);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 84);
                sb2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb2.append(valueOf2);
                return new zzc(false, new IllegalArgumentException(sb2.toString(), e));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new zzc(false, e2);
                }
                String valueOf3 = String.valueOf(zzdyz);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 77);
                sb3.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                sb3.append(valueOf3);
                return new zzb(new IllegalArgumentException(sb3.toString(), e2));
            } catch (Throwable th) {
                return new zzb(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private final void zza(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zzhwp) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (zzhwd.zza((zzdxo<?>) this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    public static void zza(zzdxo<?> zzdxo) {
        zzdxo<V> zzdxo2;
        zzd zzd2;
        zzd zzd3;
        zzd zzd4 = null;
        zzdxo<?> zzdxo3 = zzdxo;
        while (true) {
            zzk zzk2 = zzdxo3.waiters;
            if (zzhwd.zza(zzdxo3, zzk2, zzk.zzhwp)) {
                while (zzk2 != null) {
                    Thread thread = zzk2.thread;
                    if (thread != null) {
                        zzk2.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzk2 = zzk2.next;
                }
                zzdxo3.afterDone();
                do {
                    zzd2 = zzdxo3.listeners;
                } while (!zzhwd.zza(zzdxo3, zzd2, zzd.zzhwh));
                while (true) {
                    zzd3 = zzd4;
                    zzd4 = zzd2;
                    if (zzd4 == null) {
                        break;
                    }
                    zzd2 = zzd4.next;
                    zzd4.next = zzd3;
                }
                while (zzd3 != null) {
                    zzd4 = zzd3.next;
                    Runnable runnable = zzd3.task;
                    if (runnable instanceof zze) {
                        zze zze2 = (zze) runnable;
                        zzdxo<V> zzdxo4 = zze2.zzhwi;
                        if (zzdxo4.value == zze2) {
                            if (zzhwd.zza((zzdxo<?>) zzdxo4, (Object) zze2, getFutureValue(zze2.future))) {
                                zzdxo2 = zzdxo4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zza(runnable, zzd3.executor);
                    }
                    zzd3 = zzd4;
                }
                return;
            }
            zzdxo2 = zzdxo3;
            zzdxo3 = zzdxo2;
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhwc;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), e);
        }
    }

    private final void zza(StringBuilder sb) {
        String str;
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            zza(sb, uninterruptibly);
            sb.append("]");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            str = "]";
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
            sb.append(str);
        }
    }

    private final void zza(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static V zzaf(Object obj) {
        if (obj instanceof zzc) {
            Throwable th = ((zzc) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzb) {
            throw new ExecutionException(((zzb) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzdvv.checkNotNull(runnable, "Runnable was null.");
        zzdvv.checkNotNull(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zzhwh) {
            zza(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzhwd.zza((zzdxo<?>) this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zzhwh);
        zza(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    public boolean cancel(boolean z) {
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zze)) {
            return false;
        }
        zzc zzc2 = GENERATE_CANCELLATION_CAUSES ? new zzc(z, new CancellationException("Future.cancel() was called.")) : z ? zzc.zzhwf : zzc.zzhwg;
        boolean z2 = false;
        Object obj2 = obj;
        zzdxo zzdxo = this;
        while (true) {
            if (zzhwd.zza((zzdxo<?>) zzdxo, obj2, (Object) zzc2)) {
                if (z) {
                    zzdxo.interruptTask();
                }
                zza((zzdxo<?>) zzdxo);
                if (!(obj2 instanceof zze)) {
                    return true;
                }
                zzdyz<? extends V> zzdyz = ((zze) obj2).future;
                if (zzdyz instanceof zzg) {
                    zzdxo = (zzdxo) zzdyz;
                    obj2 = zzdxo.value;
                    if (!(obj2 == null) && !(obj2 instanceof zze)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    zzdyz.cancel(z);
                    return true;
                }
            } else {
                obj2 = zzdxo.value;
                if (!(obj2 instanceof zze)) {
                    return z2;
                }
            }
        }
    }

    public V get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zze))) {
                return zzaf(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zzhwp) {
                zzk zzk3 = new zzk();
                do {
                    zzk3.zzb(zzk2);
                    if (zzhwd.zza((zzdxo<?>) this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zze))));
                        return zzaf(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zzhwp);
            }
            return zzaf(this.value);
        }
        throw new InterruptedException();
    }

    public V get(long j, TimeUnit timeUnit) {
        long j2 = j;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof zze))) {
                return zzaf(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zzhwp) {
                    zzk zzk3 = new zzk();
                    do {
                        zzk3.zzb(zzk2);
                        if (zzhwd.zza((zzdxo<?>) this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zze))) {
                                        return zzaf(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zza(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zza(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zzhwp);
                }
                return zzaf(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof zze))) {
                    return zzaf(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzdxo = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j2);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j3 = -nanos;
                long convert = timeUnit2.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit2.toNanos(convert);
                int i = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzdxo).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(zzdxo);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.value instanceof zzc;
    }

    public boolean isDone() {
        Object obj = this.value;
        boolean z = true;
        boolean z2 = obj != null;
        if (obj instanceof zze) {
            z = false;
        }
        return z2 & z;
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = NULL;
        }
        if (!zzhwd.zza((zzdxo<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        zza((zzdxo<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (!zzhwd.zza((zzdxo<?>) this, (Object) null, (Object) new zzb((Throwable) zzdvv.checkNotNull(th)))) {
            return false;
        }
        zza((zzdxo<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean setFuture(zzdyz<? extends V> zzdyz) {
        zze zze2;
        zzb zzb2;
        zzdvv.checkNotNull(zzdyz);
        Object obj = this.value;
        if (obj == null) {
            if (zzdyz.isDone()) {
                if (!zzhwd.zza((zzdxo<?>) this, (Object) null, getFutureValue(zzdyz))) {
                    return false;
                }
                zza((zzdxo<?>) this);
                return true;
            }
            zze2 = new zze(this, zzdyz);
            if (zzhwd.zza((zzdxo<?>) this, (Object) null, (Object) zze2)) {
                try {
                    zzdyz.addListener(zze2, zzdyg.INSTANCE);
                } catch (Throwable unused) {
                    zzb2 = zzb.zzhwe;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzc) {
            zzdyz.cancel(((zzc) obj).wasInterrupted);
        }
        return false;
        zzhwd.zza((zzdxo<?>) this, (Object) zze2, (Object) zzb2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.google.common.util.concurrent."
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L_0x001e
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getSimpleName()
            goto L_0x0026
        L_0x001e:
            java.lang.Class r1 = r5.getClass()
            java.lang.String r1 = r1.getName()
        L_0x0026:
            r0.append(r1)
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r5)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r1 = "[status="
            r0.append(r1)
            boolean r1 = r5.isCancelled()
            if (r1 == 0) goto L_0x004b
            java.lang.String r1 = "CANCELLED"
            r0.append(r1)
            goto L_0x00be
        L_0x004b:
            boolean r1 = r5.isDone()
            if (r1 == 0) goto L_0x0055
        L_0x0051:
            r5.zza((java.lang.StringBuilder) r0)
            goto L_0x00be
        L_0x0055:
            int r1 = r0.length()
            java.lang.String r2 = "PENDING"
            r0.append(r2)
            java.lang.Object r2 = r5.value
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzdxo.zze
            if (r3 == 0) goto L_0x0076
            java.lang.String r3 = ", setFuture=["
            r0.append(r3)
            com.google.android.gms.internal.ads.zzdxo$zze r2 = (com.google.android.gms.internal.ads.zzdxo.zze) r2
            com.google.android.gms.internal.ads.zzdyz<? extends V> r2 = r2.future
            r5.zza((java.lang.StringBuilder) r0, (java.lang.Object) r2)
        L_0x0070:
            java.lang.String r2 = "]"
            r0.append(r2)
            goto L_0x00b0
        L_0x0076:
            java.lang.String r2 = r5.pendingToString()     // Catch:{ RuntimeException -> 0x0081, StackOverflowError -> 0x007f }
            java.lang.String r2 = com.google.android.gms.internal.ads.zzdwc.emptyToNull(r2)     // Catch:{ RuntimeException -> 0x0081, StackOverflowError -> 0x007f }
            goto L_0x00a5
        L_0x007f:
            r2 = move-exception
            goto L_0x0082
        L_0x0081:
            r2 = move-exception
        L_0x0082:
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            int r3 = r3 + 38
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Exception thrown from implementation: "
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
        L_0x00a5:
            if (r2 == 0) goto L_0x00b0
            java.lang.String r3 = ", info=["
            r0.append(r3)
            r0.append(r2)
            goto L_0x0070
        L_0x00b0:
            boolean r2 = r5.isDone()
            if (r2 == 0) goto L_0x00be
            int r2 = r0.length()
            r0.delete(r1, r2)
            goto L_0x0051
        L_0x00be:
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxo.toString():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zzc) && ((zzc) obj).wasInterrupted;
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public final Throwable zzazc() {
        if (!(this instanceof zzg)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzb) {
            return ((zzb) obj).exception;
        }
        return null;
    }
}

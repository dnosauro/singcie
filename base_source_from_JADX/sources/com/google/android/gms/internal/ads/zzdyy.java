package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzdyy<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zzhxq = new zzdza();
    private static final Runnable zzhxr = new zzdza();
    private static final Runnable zzhxs = new zzdza();

    zzdyy() {
    }

    /* access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable runnable = (Runnable) get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, zzhxr)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (((Runnable) getAndSet(zzhxq)) == zzhxs) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isDone();

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void run() {
        /*
            r11 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r1 = 0
            boolean r2 = r11.compareAndSet(r1, r0)
            if (r2 != 0) goto L_0x000c
            return
        L_0x000c:
            boolean r2 = r11.isDone()
            r3 = 1
            r2 = r2 ^ r3
            r4 = 1000(0x3e8, float:1.401E-42)
            r5 = 0
            if (r2 == 0) goto L_0x00bd
            java.lang.Object r6 = r11.zzazk()     // Catch:{ Throwable -> 0x006d, all -> 0x001d }
            goto L_0x00be
        L_0x001d:
            r6 = move-exception
            java.lang.Runnable r7 = zzhxq
            boolean r7 = r11.compareAndSet(r0, r7)
            if (r7 != 0) goto L_0x0067
            java.lang.Object r7 = r11.get()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r8 = 0
            r9 = 0
        L_0x002e:
            java.lang.Runnable r10 = zzhxr
            if (r7 == r10) goto L_0x003d
            java.lang.Runnable r10 = zzhxs
            if (r7 != r10) goto L_0x0037
            goto L_0x003d
        L_0x0037:
            if (r8 == 0) goto L_0x0067
            r0.interrupt()
            goto L_0x0067
        L_0x003d:
            int r9 = r9 + r3
            if (r9 <= r4) goto L_0x005d
            java.lang.Runnable r10 = zzhxs
            if (r7 == r10) goto L_0x004c
            java.lang.Runnable r7 = zzhxr
            boolean r7 = r11.compareAndSet(r7, r10)
            if (r7 == 0) goto L_0x0060
        L_0x004c:
            boolean r7 = java.lang.Thread.interrupted()
            if (r7 != 0) goto L_0x0057
            if (r8 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r7 = 0
            goto L_0x0058
        L_0x0057:
            r7 = 1
        L_0x0058:
            java.util.concurrent.locks.LockSupport.park(r11)
            r8 = r7
            goto L_0x0060
        L_0x005d:
            java.lang.Thread.yield()
        L_0x0060:
            java.lang.Object r7 = r11.get()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L_0x002e
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r11.zzb(r1, r1)
        L_0x006c:
            throw r6
        L_0x006d:
            r6 = move-exception
            java.lang.Runnable r7 = zzhxq
            boolean r7 = r11.compareAndSet(r0, r7)
            if (r7 != 0) goto L_0x00b7
            java.lang.Object r7 = r11.get()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r8 = 0
            r9 = 0
        L_0x007e:
            java.lang.Runnable r10 = zzhxr
            if (r7 == r10) goto L_0x008d
            java.lang.Runnable r10 = zzhxs
            if (r7 != r10) goto L_0x0087
            goto L_0x008d
        L_0x0087:
            if (r8 == 0) goto L_0x00b7
            r0.interrupt()
            goto L_0x00b7
        L_0x008d:
            int r9 = r9 + r3
            if (r9 <= r4) goto L_0x00ad
            java.lang.Runnable r10 = zzhxs
            if (r7 == r10) goto L_0x009c
            java.lang.Runnable r7 = zzhxr
            boolean r7 = r11.compareAndSet(r7, r10)
            if (r7 == 0) goto L_0x00b0
        L_0x009c:
            boolean r7 = java.lang.Thread.interrupted()
            if (r7 != 0) goto L_0x00a7
            if (r8 == 0) goto L_0x00a5
            goto L_0x00a7
        L_0x00a5:
            r7 = 0
            goto L_0x00a8
        L_0x00a7:
            r7 = 1
        L_0x00a8:
            java.util.concurrent.locks.LockSupport.park(r11)
            r8 = r7
            goto L_0x00b0
        L_0x00ad:
            java.lang.Thread.yield()
        L_0x00b0:
            java.lang.Object r7 = r11.get()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L_0x007e
        L_0x00b7:
            if (r2 == 0) goto L_0x010c
            r11.zzb(r1, r6)
            return
        L_0x00bd:
            r6 = r1
        L_0x00be:
            java.lang.Runnable r7 = zzhxq
            boolean r7 = r11.compareAndSet(r0, r7)
            if (r7 != 0) goto L_0x0107
            java.lang.Object r7 = r11.get()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r8 = 0
            r9 = 0
        L_0x00ce:
            java.lang.Runnable r10 = zzhxr
            if (r7 == r10) goto L_0x00dd
            java.lang.Runnable r10 = zzhxs
            if (r7 != r10) goto L_0x00d7
            goto L_0x00dd
        L_0x00d7:
            if (r8 == 0) goto L_0x0107
            r0.interrupt()
            goto L_0x0107
        L_0x00dd:
            int r9 = r9 + r3
            if (r9 <= r4) goto L_0x00fd
            java.lang.Runnable r10 = zzhxs
            if (r7 == r10) goto L_0x00ec
            java.lang.Runnable r7 = zzhxr
            boolean r7 = r11.compareAndSet(r7, r10)
            if (r7 == 0) goto L_0x0100
        L_0x00ec:
            boolean r7 = java.lang.Thread.interrupted()
            if (r7 != 0) goto L_0x00f7
            if (r8 == 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r7 = 0
            goto L_0x00f8
        L_0x00f7:
            r7 = 1
        L_0x00f8:
            java.util.concurrent.locks.LockSupport.park(r11)
            r8 = r7
            goto L_0x0100
        L_0x00fd:
            java.lang.Thread.yield()
        L_0x0100:
            java.lang.Object r7 = r11.get()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L_0x00ce
        L_0x0107:
            if (r2 == 0) goto L_0x010c
            r11.zzb(r6, r1)
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyy.run():void");
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zzhxq) {
            str = "running=[DONE]";
        } else if (runnable == zzhxr) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzazl = zzazl();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(zzazl).length());
        sb2.append(str);
        sb2.append(", ");
        sb2.append(zzazl);
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract T zzazk();

    /* access modifiers changed from: package-private */
    public abstract String zzazl();

    /* access modifiers changed from: package-private */
    public abstract void zzb(@NullableDecl T t, @NullableDecl Throwable th);
}

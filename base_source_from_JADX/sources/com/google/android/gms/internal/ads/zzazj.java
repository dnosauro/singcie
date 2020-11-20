package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzazj {
    public static final zzdzc zzegp = zza(ClientLibraryUtils.isPackageSide() ? zzduo.zzayg().zza(zzfd("Default"), zzdut.zzhsl) : new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), zzfd("Default")));
    public static final zzdzc zzegq;
    public static final zzdzc zzegr;
    public static final ScheduledExecutorService zzegs = new zzazi(3, zzfd("Schedule"));
    public static final zzdzc zzegt = zza(new zzazk());
    public static final zzdzc zzegu = zza(zzdzb.zzazo());

    /* JADX WARNING: type inference failed for: r0v16, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: type inference failed for: r0v22, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdul r0 = com.google.android.gms.internal.ads.zzduo.zzayg()
            java.lang.String r1 = "Default"
            java.util.concurrent.ThreadFactory r1 = zzfd(r1)
            int r2 = com.google.android.gms.internal.ads.zzdut.zzhsl
            java.util.concurrent.ExecutorService r0 = r0.zza(r1, r2)
            goto L_0x0030
        L_0x0017:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            r2 = 2
            r3 = 2147483647(0x7fffffff, float:NaN)
            r4 = 10
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.SynchronousQueue r7 = new java.util.concurrent.SynchronousQueue
            r7.<init>()
            java.lang.String r1 = "Default"
            java.util.concurrent.ThreadFactory r8 = zzfd(r1)
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r7, r8)
        L_0x0030:
            com.google.android.gms.internal.ads.zzdzc r0 = zza(r0)
            zzegp = r0
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            r1 = 1
            if (r0 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzdul r0 = com.google.android.gms.internal.ads.zzduo.zzayg()
            r2 = 5
            java.lang.String r3 = "Loader"
            java.util.concurrent.ThreadFactory r3 = zzfd(r3)
            int r4 = com.google.android.gms.internal.ads.zzdut.zzhsk
            java.util.concurrent.ExecutorService r0 = r0.zza(r2, r3, r4)
            goto L_0x006c
        L_0x004f:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            r3 = 5
            r4 = 5
            r5 = 10
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r8 = new java.util.concurrent.LinkedBlockingQueue
            r8.<init>()
            java.lang.String r2 = "Loader"
            java.util.concurrent.ThreadFactory r9 = zzfd(r2)
            r2 = r0
            r2.<init>(r3, r4, r5, r7, r8, r9)
            r2 = r0
            java.util.concurrent.ThreadPoolExecutor r2 = (java.util.concurrent.ThreadPoolExecutor) r2
            r2.allowCoreThreadTimeOut(r1)
        L_0x006c:
            com.google.android.gms.internal.ads.zzdzc r0 = zza(r0)
            zzegq = r0
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzdul r0 = com.google.android.gms.internal.ads.zzduo.zzayg()
            java.lang.String r1 = "Activeview"
            java.util.concurrent.ThreadFactory r1 = zzfd(r1)
            int r2 = com.google.android.gms.internal.ads.zzdut.zzhsk
            java.util.concurrent.ExecutorService r0 = r0.zzb(r1, r2)
            goto L_0x00a6
        L_0x0089:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            r3 = 1
            r4 = 1
            r5 = 10
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r8 = new java.util.concurrent.LinkedBlockingQueue
            r8.<init>()
            java.lang.String r2 = "Activeview"
            java.util.concurrent.ThreadFactory r9 = zzfd(r2)
            r2 = r0
            r2.<init>(r3, r4, r5, r7, r8, r9)
            r2 = r0
            java.util.concurrent.ThreadPoolExecutor r2 = (java.util.concurrent.ThreadPoolExecutor) r2
            r2.allowCoreThreadTimeOut(r1)
        L_0x00a6:
            com.google.android.gms.internal.ads.zzdzc r0 = zza(r0)
            zzegr = r0
            com.google.android.gms.internal.ads.zzazi r0 = new com.google.android.gms.internal.ads.zzazi
            r1 = 3
            java.lang.String r2 = "Schedule"
            java.util.concurrent.ThreadFactory r2 = zzfd(r2)
            r0.<init>(r1, r2)
            zzegs = r0
            com.google.android.gms.internal.ads.zzazk r0 = new com.google.android.gms.internal.ads.zzazk
            r0.<init>()
            com.google.android.gms.internal.ads.zzdzc r0 = zza(r0)
            zzegt = r0
            java.util.concurrent.Executor r0 = com.google.android.gms.internal.ads.zzdzb.zzazo()
            com.google.android.gms.internal.ads.zzdzc r0 = zza(r0)
            zzegu = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazj.<clinit>():void");
    }

    private static zzdzc zza(Executor executor) {
        return new zzazn(executor, (zzazi) null);
    }

    private static ThreadFactory zzfd(String str) {
        return new zzazl(str);
    }
}

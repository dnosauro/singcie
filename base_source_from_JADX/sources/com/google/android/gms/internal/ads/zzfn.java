package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzby;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.ExecutionException;

public final class zzfn extends zzgl {
    private static final zzgo<zzcy> zzaar = new zzgo<>();
    private final Context zzaas;
    private zzby.zza zzaat = null;

    public zzfn(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2, Context context, zzby.zza zza2) {
        super(zzfa, str, str2, zza, i, 27);
        this.zzaas = context;
        this.zzaat = zza2;
    }

    private static String zza(zzby.zza zza) {
        if (zza == null || !zza.zzz() || zzff.zzar(zza.zzaa().zzaf())) {
            return null;
        }
        return zza.zzaa().zzaf();
    }

    private final String zzcx() {
        try {
            if (this.zzwb.zzcp() != null) {
                this.zzwb.zzcp().get();
            }
            zzcf.zza zzco = this.zzwb.zzco();
            if (zzco == null || !zzco.zzaj()) {
                return null;
            }
            return zzco.zzaf();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ca, code lost:
        if (com.google.android.gms.internal.ads.zzff.zzar(r1) == false) goto L_0x00cc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcw() {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzgo<com.google.android.gms.internal.ads.zzcy> r0 = zzaar
            android.content.Context r1 = r9.zzaas
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zzas(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0111 }
            com.google.android.gms.internal.ads.zzcy r1 = (com.google.android.gms.internal.ads.zzcy) r1     // Catch:{ all -> 0x0111 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.zznt     // Catch:{ all -> 0x0111 }
            boolean r4 = com.google.android.gms.internal.ads.zzff.zzar(r4)     // Catch:{ all -> 0x0111 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.zznt     // Catch:{ all -> 0x0111 }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0111 }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.zznt     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x0111 }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzby$zza r1 = r9.zzaat     // Catch:{ all -> 0x0111 }
            java.lang.String r1 = zza(r1)     // Catch:{ all -> 0x0111 }
            boolean r1 = com.google.android.gms.internal.ads.zzff.zzar(r1)     // Catch:{ all -> 0x0111 }
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x0111 }
            goto L_0x0082
        L_0x0048:
            com.google.android.gms.internal.ads.zzby$zza r1 = r9.zzaat     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = zza(r1)     // Catch:{ all -> 0x0111 }
            boolean r4 = com.google.android.gms.internal.ads.zzff.zzar(r4)     // Catch:{ all -> 0x0111 }
            if (r4 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x006a
            boolean r4 = r1.zzx()     // Catch:{ all -> 0x0111 }
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzby$zzb r1 = r1.zzy()     // Catch:{ all -> 0x0111 }
            com.google.android.gms.internal.ads.zzcb r1 = r1.zzac()     // Catch:{ all -> 0x0111 }
            com.google.android.gms.internal.ads.zzcb r4 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0111 }
            if (r1 != r4) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0111 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0111 }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzfa r1 = r9.zzwb     // Catch:{ all -> 0x0111 }
            boolean r1 = r1.zzcm()     // Catch:{ all -> 0x0111 }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x0111 }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.internal.ads.zzcb r1 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0111 }
        L_0x0082:
            com.google.android.gms.internal.ads.zzcb r4 = com.google.android.gms.internal.ads.zzcb.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x0111 }
            if (r1 != r4) goto L_0x0088
            r4 = 1
            goto L_0x0089
        L_0x0088:
            r4 = 0
        L_0x0089:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0111 }
            java.lang.reflect.Method r5 = r9.zzabi     // Catch:{ all -> 0x0111 }
            r6 = 0
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0111 }
            android.content.Context r8 = r9.zzaas     // Catch:{ all -> 0x0111 }
            r7[r2] = r8     // Catch:{ all -> 0x0111 }
            r7[r3] = r4     // Catch:{ all -> 0x0111 }
            java.lang.Object r2 = r5.invoke(r6, r7)     // Catch:{ all -> 0x0111 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0111 }
            com.google.android.gms.internal.ads.zzcy r3 = new com.google.android.gms.internal.ads.zzcy     // Catch:{ all -> 0x0111 }
            r3.<init>(r2)     // Catch:{ all -> 0x0111 }
            java.lang.String r2 = r3.zznt     // Catch:{ all -> 0x0111 }
            boolean r2 = com.google.android.gms.internal.ads.zzff.zzar(r2)     // Catch:{ all -> 0x0111 }
            if (r2 != 0) goto L_0x00b6
            java.lang.String r2 = r3.zznt     // Catch:{ all -> 0x0111 }
            java.lang.String r4 = "E"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0111 }
            if (r2 == 0) goto L_0x00da
        L_0x00b6:
            int[] r2 = com.google.android.gms.internal.ads.zzfq.zzaav     // Catch:{ all -> 0x0111 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0111 }
            r1 = r2[r1]     // Catch:{ all -> 0x0111 }
            switch(r1) {
                case 1: goto L_0x00cf;
                case 2: goto L_0x00c2;
                default: goto L_0x00c1;
            }     // Catch:{ all -> 0x0111 }
        L_0x00c1:
            goto L_0x00da
        L_0x00c2:
            java.lang.String r1 = r9.zzcx()     // Catch:{ all -> 0x0111 }
            boolean r2 = com.google.android.gms.internal.ads.zzff.zzar(r1)     // Catch:{ all -> 0x0111 }
            if (r2 != 0) goto L_0x00da
        L_0x00cc:
            r3.zznt = r1     // Catch:{ all -> 0x0111 }
            goto L_0x00da
        L_0x00cf:
            com.google.android.gms.internal.ads.zzby$zza r1 = r9.zzaat     // Catch:{ all -> 0x0111 }
            com.google.android.gms.internal.ads.zzby$zzc r1 = r1.zzaa()     // Catch:{ all -> 0x0111 }
            java.lang.String r1 = r1.zzaf()     // Catch:{ all -> 0x0111 }
            goto L_0x00cc
        L_0x00da:
            r0.set(r3)     // Catch:{ all -> 0x0111 }
        L_0x00dd:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x0111 }
            com.google.android.gms.internal.ads.zzcy r1 = (com.google.android.gms.internal.ads.zzcy) r1     // Catch:{ all -> 0x0111 }
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            com.google.android.gms.internal.ads.zzcf$zza$zza r2 = r9.zzaay
            monitor-enter(r2)
            if (r1 == 0) goto L_0x010c
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r9.zzaay     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r1.zznt     // Catch:{ all -> 0x010e }
            r0.zzv((java.lang.String) r3)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r9.zzaay     // Catch:{ all -> 0x010e }
            long r3 = r1.zznu     // Catch:{ all -> 0x010e }
            r0.zzt((long) r3)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r9.zzaay     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r1.zznv     // Catch:{ all -> 0x010e }
            r0.zzx((java.lang.String) r3)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r9.zzaay     // Catch:{ all -> 0x010e }
            java.lang.String r3 = r1.zznw     // Catch:{ all -> 0x010e }
            r0.zzy((java.lang.String) r3)     // Catch:{ all -> 0x010e }
            com.google.android.gms.internal.ads.zzcf$zza$zza r0 = r9.zzaay     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r1.zznx     // Catch:{ all -> 0x010e }
            r0.zzz((java.lang.String) r1)     // Catch:{ all -> 0x010e }
        L_0x010c:
            monitor-exit(r2)     // Catch:{ all -> 0x010e }
            return
        L_0x010e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x010e }
            throw r0
        L_0x0111:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0111 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfn.zzcw():void");
    }
}

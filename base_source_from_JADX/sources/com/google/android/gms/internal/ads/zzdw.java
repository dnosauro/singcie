package com.google.android.gms.internal.ads;

final class zzdw implements Runnable {
    private final /* synthetic */ zzdt zzwh;

    zzdw(zzdt zzdt) {
        this.zzwh = zzdt;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|11|12|(2:16|17)|18|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzdt r0 = r7.zzwh
            java.lang.Boolean r0 = r0.zzwe
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            android.os.ConditionVariable r0 = com.google.android.gms.internal.ads.zzdt.zzwc
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzdt r1 = r7.zzwh     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r1 = r1.zzwe     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0014
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0014:
            r1 = 0
            com.google.android.gms.internal.ads.zzacn<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzcqv     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.Object r2 = r2.get()     // Catch:{ IllegalStateException -> 0x0022 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ IllegalStateException -> 0x0022 }
            boolean r2 = r2.booleanValue()     // Catch:{ IllegalStateException -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r2 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zztx r3 = new com.google.android.gms.internal.ads.zztx     // Catch:{ Throwable -> 0x0038 }
            com.google.android.gms.internal.ads.zzdt r4 = r7.zzwh     // Catch:{ Throwable -> 0x0038 }
            com.google.android.gms.internal.ads.zzfa r4 = r4.zzwb     // Catch:{ Throwable -> 0x0038 }
            android.content.Context r4 = r4.context     // Catch:{ Throwable -> 0x0038 }
            java.lang.String r5 = "ADSHIELD"
            r6 = 0
            r3.<init>(r4, r5, r6)     // Catch:{ Throwable -> 0x0038 }
            com.google.android.gms.internal.ads.zzdt.zzwd = r3     // Catch:{ Throwable -> 0x0038 }
        L_0x0037:
            r1 = r2
        L_0x0038:
            com.google.android.gms.internal.ads.zzdt r2 = r7.zzwh     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0049 }
            r2.zzwe = r1     // Catch:{ all -> 0x0049 }
            android.os.ConditionVariable r1 = com.google.android.gms.internal.ads.zzdt.zzwc     // Catch:{ all -> 0x0049 }
            r1.open()     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return
        L_0x0049:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdw.run():void");
    }
}

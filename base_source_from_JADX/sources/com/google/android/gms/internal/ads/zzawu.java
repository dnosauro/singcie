package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzawu implements zzqu {
    private final Object lock;
    private String zzbum;
    private final Context zzcln;
    private boolean zzdzj;

    public zzawu(Context context, String str) {
        this.zzcln = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbum = str;
        this.zzdzj = false;
        this.lock = new Object();
    }

    public final String getAdUnitId() {
        return this.zzbum;
    }

    public final void zza(zzqv zzqv) {
        zzam(zzqv.zzbqz);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzam(boolean r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzawx r0 = com.google.android.gms.ads.internal.zzp.zzlo()
            android.content.Context r1 = r3.zzcln
            boolean r0 = r0.zzz(r1)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            boolean r1 = r3.zzdzj     // Catch:{ all -> 0x003f }
            if (r1 != r4) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0016:
            r3.zzdzj = r4     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r3.zzbum     // Catch:{ all -> 0x003f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0022
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0022:
            boolean r4 = r3.zzdzj     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzawx r4 = com.google.android.gms.ads.internal.zzp.zzlo()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.zzcln     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.zzbum     // Catch:{ all -> 0x003f }
            r4.zzd(r1, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0032:
            com.google.android.gms.internal.ads.zzawx r4 = com.google.android.gms.ads.internal.zzp.zzlo()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.zzcln     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.zzbum     // Catch:{ all -> 0x003f }
            r4.zze(r1, r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawu.zzam(boolean):void");
    }
}

package com.google.android.gms.internal.ads;

public abstract class zzhz {
    public static final zzhz zzaib = new zzic();

    public final boolean isEmpty() {
        return zzff() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        if ((zzff() - 1) == 0) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r2, com.google.android.gms.internal.ads.zzib r3, com.google.android.gms.internal.ads.zzie r4, int r5) {
        /*
            r1 = this;
            r0 = 0
            r1.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r3, (boolean) r0)
            r1.zza((int) r0, (com.google.android.gms.internal.ads.zzie) r4, (boolean) r0)
            r3 = 1
            if (r2 != 0) goto L_0x002c
            r2 = -1
            switch(r5) {
                case 0: goto L_0x001d;
                case 1: goto L_0x001b;
                case 2: goto L_0x0014;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            r2.<init>()
            throw r2
        L_0x0014:
            int r5 = r1.zzff()
            int r5 = r5 - r3
            if (r5 != 0) goto L_0x0025
        L_0x001b:
            r3 = 0
            goto L_0x0025
        L_0x001d:
            int r5 = r1.zzff()
            int r5 = r5 - r3
            if (r5 != 0) goto L_0x0025
            r3 = -1
        L_0x0025:
            if (r3 != r2) goto L_0x0028
            return r2
        L_0x0028:
            r1.zza((int) r3, (com.google.android.gms.internal.ads.zzie) r4, (boolean) r0)
            return r0
        L_0x002c:
            int r2 = r2 + r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhz.zza(int, com.google.android.gms.internal.ads.zzib, com.google.android.gms.internal.ads.zzie, int):int");
    }

    public abstract zzib zza(int i, zzib zzib, boolean z);

    public final zzie zza(int i, zzie zzie, boolean z) {
        return zza(i, zzie, false, 0);
    }

    public abstract zzie zza(int i, zzie zzie, boolean z, long j);

    public abstract int zzc(Object obj);

    public abstract int zzff();

    public abstract int zzfg();
}

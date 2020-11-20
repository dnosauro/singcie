package com.google.android.gms.internal.measurement;

abstract class zzkn<T, B> {
    zzkn() {
    }

    /* access modifiers changed from: package-private */
    public abstract B zza();

    /* access modifiers changed from: package-private */
    public abstract T zza(B b);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzgm zzgm);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzlk zzlk);

    /* access modifiers changed from: package-private */
    public abstract void zza(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzjw zzjw);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023 A[LOOP:0: B:8:0x0023->B:11:0x0030, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(B r7, com.google.android.gms.internal.measurement.zzjw r8) {
        /*
            r6 = this;
            int r0 = r8.zzb()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            switch(r0) {
                case 0: goto L_0x0055;
                case 1: goto L_0x004d;
                case 2: goto L_0x0045;
                case 3: goto L_0x001b;
                case 4: goto L_0x0019;
                case 5: goto L_0x0011;
                default: goto L_0x000c;
            }
        L_0x000c:
            com.google.android.gms.internal.measurement.zzif r7 = com.google.android.gms.internal.measurement.zzig.zzf()
            throw r7
        L_0x0011:
            int r8 = r8.zzj()
            r6.zza(r7, (int) r1, (int) r8)
            return r2
        L_0x0019:
            r7 = 0
            return r7
        L_0x001b:
            java.lang.Object r0 = r6.zza()
            int r3 = r1 << 3
            r3 = r3 | 4
        L_0x0023:
            int r4 = r8.zza()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0032
            boolean r4 = r6.zza(r0, (com.google.android.gms.internal.measurement.zzjw) r8)
            if (r4 != 0) goto L_0x0023
        L_0x0032:
            int r8 = r8.zzb()
            if (r3 != r8) goto L_0x0040
            java.lang.Object r8 = r6.zza(r0)
            r6.zza(r7, (int) r1, r8)
            return r2
        L_0x0040:
            com.google.android.gms.internal.measurement.zzig r7 = com.google.android.gms.internal.measurement.zzig.zze()
            throw r7
        L_0x0045:
            com.google.android.gms.internal.measurement.zzgm r8 = r8.zzn()
            r6.zza(r7, (int) r1, (com.google.android.gms.internal.measurement.zzgm) r8)
            return r2
        L_0x004d:
            long r3 = r8.zzi()
            r6.zzb(r7, r1, r3)
            return r2
        L_0x0055:
            long r3 = r8.zzg()
            r6.zza(r7, (int) r1, (long) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjw):boolean");
    }

    /* access modifiers changed from: package-private */
    public abstract T zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(T t, zzlk zzlk);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzc(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzd(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zze(T t);

    /* access modifiers changed from: package-private */
    public abstract int zzf(T t);
}

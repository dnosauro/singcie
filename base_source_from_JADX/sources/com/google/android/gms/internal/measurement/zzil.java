package com.google.android.gms.internal.measurement;

public class zzil {
    private static final zzhi zza = zzhi.zza();
    private zzgm zzb;
    private volatile zzjg zzc;
    private volatile zzgm zzd;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzjg zzb(com.google.android.gms.internal.measurement.zzjg r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzjg r0 = r1.zzc
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzjg r0 = r1.zzc     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzig -> 0x0012 }
            com.google.android.gms.internal.measurement.zzgm r0 = com.google.android.gms.internal.measurement.zzgm.zza     // Catch:{ zzig -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzig -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.measurement.zzgm r2 = com.google.android.gms.internal.measurement.zzgm.zza     // Catch:{ all -> 0x0019 }
            r1.zzd = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.measurement.zzjg r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzil.zzb(com.google.android.gms.internal.measurement.zzjg):com.google.android.gms.internal.measurement.zzjg");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzil)) {
            return false;
        }
        zzil zzil = (zzil) obj;
        zzjg zzjg = this.zzc;
        zzjg zzjg2 = zzil.zzc;
        return (zzjg == null && zzjg2 == null) ? zzc().equals(zzil.zzc()) : (zzjg == null || zzjg2 == null) ? zzjg != null ? zzjg.equals(zzil.zzb(zzjg.zzbv())) : zzb(zzjg2.zzbv()).equals(zzjg2) : zzjg.equals(zzjg2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzjg zza(zzjg zzjg) {
        zzjg zzjg2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjg;
        return zzjg2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbp();
        }
        return 0;
    }

    public final zzgm zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzgm zzgm = this.zzd;
                return zzgm;
            }
            this.zzd = this.zzc == null ? zzgm.zza : this.zzc.zzbj();
            zzgm zzgm2 = this.zzd;
            return zzgm2;
        }
    }
}

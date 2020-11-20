package com.google.android.gms.internal.ads;

public class zzekx {
    private static final zzeju zziip = zzeju.zzbhe();
    private zzeiu zziou;
    private volatile zzels zziov;
    private volatile zzeiu zziow;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzels zzm(com.google.android.gms.internal.ads.zzels r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzels r0 = r1.zziov
            if (r0 != 0) goto L_0x001c
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzels r0 = r1.zziov     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000b
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001c
        L_0x000b:
            r1.zziov = r2     // Catch:{ zzeks -> 0x0012 }
            com.google.android.gms.internal.ads.zzeiu r0 = com.google.android.gms.internal.ads.zzeiu.zziiy     // Catch:{ zzeks -> 0x0012 }
            r1.zziow = r0     // Catch:{ zzeks -> 0x0012 }
            goto L_0x0009
        L_0x0012:
            r1.zziov = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.internal.ads.zzeiu r2 = com.google.android.gms.internal.ads.zzeiu.zziiy     // Catch:{ all -> 0x0019 }
            r1.zziow = r2     // Catch:{ all -> 0x0019 }
            goto L_0x0009
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r2
        L_0x001c:
            com.google.android.gms.internal.ads.zzels r2 = r1.zziov
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekx.zzm(com.google.android.gms.internal.ads.zzels):com.google.android.gms.internal.ads.zzels");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzekx)) {
            return false;
        }
        zzekx zzekx = (zzekx) obj;
        zzels zzels = this.zziov;
        zzels zzels2 = zzekx.zziov;
        return (zzels == null && zzels2 == null) ? zzbfg().equals(zzekx.zzbfg()) : (zzels == null || zzels2 == null) ? zzels != null ? zzels.equals(zzekx.zzm(zzels.zzbhw())) : zzm(zzels2.zzbhw()).equals(zzels2) : zzels.equals(zzels2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzeiu zzbfg() {
        if (this.zziow != null) {
            return this.zziow;
        }
        synchronized (this) {
            if (this.zziow != null) {
                zzeiu zzeiu = this.zziow;
                return zzeiu;
            }
            this.zziow = this.zziov == null ? zzeiu.zziiy : this.zziov.zzbfg();
            zzeiu zzeiu2 = this.zziow;
            return zzeiu2;
        }
    }

    public final int zzbhz() {
        if (this.zziow != null) {
            return this.zziow.size();
        }
        if (this.zziov != null) {
            return this.zziov.zzbhz();
        }
        return 0;
    }

    public final zzels zzn(zzels zzels) {
        zzels zzels2 = this.zziov;
        this.zziou = null;
        this.zziow = null;
        this.zziov = zzels;
        return zzels2;
    }
}

package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(16)
public final class zzqe {
    private final zzqh zzbmf;
    private final boolean zzbmg;
    private final long zzbmh;
    private final long zzbmi;
    private long zzbmj;
    private long zzbmk;
    private long zzbml;
    private boolean zzbmm;
    private long zzbmn;
    private long zzbmo;
    private long zzbmp;

    public zzqe() {
        this(-1.0d);
    }

    private zzqe(double d) {
        long j;
        this.zzbmg = d != -1.0d;
        if (this.zzbmg) {
            this.zzbmf = zzqh.zzjp();
            this.zzbmh = (long) (1.0E9d / d);
            j = (this.zzbmh * 80) / 100;
        } else {
            this.zzbmf = null;
            j = -1;
            this.zzbmh = -1;
        }
        this.zzbmi = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzqe(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L_0x0018
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L_0x001a
        L_0x0018:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x001a:
            r2.<init>((double) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqe.<init>(android.content.Context):void");
    }

    private final boolean zzg(long j, long j2) {
        return Math.abs((j2 - this.zzbmn) - (j - this.zzbmo)) > 20000000;
    }

    public final void disable() {
        if (this.zzbmg) {
            this.zzbmf.removeObserver();
        }
    }

    public final void enable() {
        this.zzbmm = false;
        if (this.zzbmg) {
            this.zzbmf.zzjq();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (zzg(r0, r14) != false) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.zzbmm
            if (r2 == 0) goto L_0x0040
            long r2 = r11.zzbmj
            int r4 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r11.zzbmp
            r4 = 1
            long r2 = r2 + r4
            r11.zzbmp = r2
            long r2 = r11.zzbml
            r11.zzbmk = r2
        L_0x0019:
            long r2 = r11.zzbmp
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0038
            long r4 = r11.zzbmo
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r11.zzbmk
            long r2 = r2 + r4
            boolean r4 = r11.zzg(r2, r14)
            if (r4 == 0) goto L_0x0031
            goto L_0x003e
        L_0x0031:
            long r4 = r11.zzbmn
            long r4 = r4 + r2
            long r6 = r11.zzbmo
            long r4 = r4 - r6
            goto L_0x0042
        L_0x0038:
            boolean r2 = r11.zzg(r0, r14)
            if (r2 == 0) goto L_0x0040
        L_0x003e:
            r11.zzbmm = r6
        L_0x0040:
            r4 = r14
            r2 = r0
        L_0x0042:
            boolean r6 = r11.zzbmm
            r7 = 0
            if (r6 != 0) goto L_0x0051
            r11.zzbmo = r0
            r11.zzbmn = r14
            r11.zzbmp = r7
            r14 = 1
            r11.zzbmm = r14
        L_0x0051:
            r11.zzbmj = r12
            r11.zzbml = r2
            com.google.android.gms.internal.ads.zzqh r12 = r11.zzbmf
            if (r12 == 0) goto L_0x0084
            long r12 = r12.zzbmr
            int r14 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r14 != 0) goto L_0x0060
            goto L_0x0084
        L_0x0060:
            com.google.android.gms.internal.ads.zzqh r12 = r11.zzbmf
            long r12 = r12.zzbmr
            long r14 = r11.zzbmh
            long r0 = r4 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x0073
            long r14 = r12 - r14
            goto L_0x0077
        L_0x0073:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L_0x0077:
            long r0 = r12 - r4
            long r4 = r4 - r14
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r12 = r14
        L_0x0080:
            long r14 = r11.zzbmi
            long r12 = r12 - r14
            return r12
        L_0x0084:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqe.zzf(long, long):long");
    }
}

package com.google.android.gms.internal.ads;

import com.parse.ParseQuery;

final class zzng {
    private int length;
    private int[] zzaol;
    private long[] zzaom;
    private long[] zzaoo;
    private int[] zzaxi;
    private int zzbfj = ParseQuery.MAX_LIMIT;
    private int[] zzbfk;
    private zzkg[] zzbfl;
    private zzhp[] zzbfm;
    private int zzbfn;
    private int zzbfo;
    private int zzbfp;
    private long zzbfq;
    private long zzbfr;
    private boolean zzbfs;
    private boolean zzbft;
    private zzhp zzbfu;

    public zzng() {
        int i = this.zzbfj;
        this.zzbfk = new int[i];
        this.zzaom = new long[i];
        this.zzaoo = new long[i];
        this.zzaxi = new int[i];
        this.zzaol = new int[i];
        this.zzbfl = new zzkg[i];
        this.zzbfm = new zzhp[i];
        this.zzbfq = Long.MIN_VALUE;
        this.zzbfr = Long.MIN_VALUE;
        this.zzbft = true;
        this.zzbfs = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zza(com.google.android.gms.internal.ads.zzhr r5, com.google.android.gms.internal.ads.zzjl r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzhp r9, com.google.android.gms.internal.ads.zznj r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzie()     // Catch:{ all -> 0x00a6 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0024
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzhp r6 = r4.zzbfu     // Catch:{ all -> 0x00a6 }
            if (r6 == 0) goto L_0x0022
            if (r7 != 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzhp r6 = r4.zzbfu     // Catch:{ all -> 0x00a6 }
            if (r6 == r9) goto L_0x0022
        L_0x001c:
            com.google.android.gms.internal.ads.zzhp r6 = r4.zzbfu     // Catch:{ all -> 0x00a6 }
            r5.zzahv = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r1
        L_0x0022:
            monitor-exit(r4)
            return r2
        L_0x0024:
            if (r7 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzhp[] r7 = r4.zzbfm     // Catch:{ all -> 0x00a6 }
            int r8 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r7 = r7[r8]     // Catch:{ all -> 0x00a6 }
            if (r7 == r9) goto L_0x002f
            goto L_0x009c
        L_0x002f:
            java.nio.ByteBuffer r5 = r6.zzda     // Catch:{ all -> 0x00a6 }
            r7 = 0
            r8 = 1
            if (r5 != 0) goto L_0x0037
            r5 = 1
            goto L_0x0038
        L_0x0037:
            r5 = 0
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            monitor-exit(r4)
            return r2
        L_0x003c:
            long[] r5 = r4.zzaoo     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r6.zzanz = r0     // Catch:{ all -> 0x00a6 }
            int[] r5 = r4.zzaxi     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r6.setFlags(r5)     // Catch:{ all -> 0x00a6 }
            int[] r5 = r4.zzaol     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.size = r5     // Catch:{ all -> 0x00a6 }
            long[] r5 = r4.zzaom     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r0 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.zzawl = r0     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzkg[] r5 = r4.zzbfl     // Catch:{ all -> 0x00a6 }
            int r9 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r5 = r5[r9]     // Catch:{ all -> 0x00a6 }
            r10.zzaro = r5     // Catch:{ all -> 0x00a6 }
            long r0 = r4.zzbfq     // Catch:{ all -> 0x00a6 }
            long r5 = r6.zzanz     // Catch:{ all -> 0x00a6 }
            long r5 = java.lang.Math.max(r0, r5)     // Catch:{ all -> 0x00a6 }
            r4.zzbfq = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.length     // Catch:{ all -> 0x00a6 }
            int r5 = r5 - r8
            r4.length = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            int r5 = r5 + r8
            r4.zzbfo = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbfn     // Catch:{ all -> 0x00a6 }
            int r5 = r5 + r8
            r4.zzbfn = r5     // Catch:{ all -> 0x00a6 }
            int r5 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            int r6 = r4.zzbfj     // Catch:{ all -> 0x00a6 }
            if (r5 != r6) goto L_0x0086
            r4.zzbfo = r7     // Catch:{ all -> 0x00a6 }
        L_0x0086:
            int r5 = r4.length     // Catch:{ all -> 0x00a6 }
            if (r5 <= 0) goto L_0x0091
            long[] r5 = r4.zzaom     // Catch:{ all -> 0x00a6 }
            int r6 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r6 = r5[r6]     // Catch:{ all -> 0x00a6 }
            goto L_0x0098
        L_0x0091:
            long r5 = r10.zzawl     // Catch:{ all -> 0x00a6 }
            int r7 = r10.size     // Catch:{ all -> 0x00a6 }
            long r7 = (long) r7     // Catch:{ all -> 0x00a6 }
            long r6 = r5 + r7
        L_0x0098:
            r10.zzbgi = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r3
        L_0x009c:
            com.google.android.gms.internal.ads.zzhp[] r6 = r4.zzbfm     // Catch:{ all -> 0x00a6 }
            int r7 = r4.zzbfo     // Catch:{ all -> 0x00a6 }
            r6 = r6[r7]     // Catch:{ all -> 0x00a6 }
            r5.zzahv = r6     // Catch:{ all -> 0x00a6 }
            monitor-exit(r4)
            return r1
        L_0x00a6:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzng.zza(com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzjl, boolean, boolean, com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zznj):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ea, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(long r6, int r8, long r9, int r11, com.google.android.gms.internal.ads.zzkg r12) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzbfs     // Catch:{ all -> 0x00eb }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            r0 = r8 & 1
            if (r0 != 0) goto L_0x000c
            monitor-exit(r5)
            return
        L_0x000c:
            r5.zzbfs = r1     // Catch:{ all -> 0x00eb }
        L_0x000e:
            boolean r0 = r5.zzbft     // Catch:{ all -> 0x00eb }
            r2 = 1
            if (r0 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)     // Catch:{ all -> 0x00eb }
            r5.zzei(r6)     // Catch:{ all -> 0x00eb }
            long[] r0 = r5.zzaoo     // Catch:{ all -> 0x00eb }
            int r3 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            r0[r3] = r6     // Catch:{ all -> 0x00eb }
            long[] r6 = r5.zzaom     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            r6[r7] = r9     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.zzaol     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            r6[r7] = r11     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.zzaxi     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            r6[r7] = r8     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzkg[] r6 = r5.zzbfl     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            r6[r7] = r12     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzhp[] r6 = r5.zzbfm     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzhp r8 = r5.zzbfu     // Catch:{ all -> 0x00eb }
            r6[r7] = r8     // Catch:{ all -> 0x00eb }
            int[] r6 = r5.zzbfk     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            r6[r7] = r1     // Catch:{ all -> 0x00eb }
            int r6 = r5.length     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r2
            r5.length = r6     // Catch:{ all -> 0x00eb }
            int r6 = r5.length     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfj     // Catch:{ all -> 0x00eb }
            if (r6 != r7) goto L_0x00dc
            int r6 = r5.zzbfj     // Catch:{ all -> 0x00eb }
            int r6 = r6 + 1000
            int[] r7 = new int[r6]     // Catch:{ all -> 0x00eb }
            long[] r8 = new long[r6]     // Catch:{ all -> 0x00eb }
            long[] r9 = new long[r6]     // Catch:{ all -> 0x00eb }
            int[] r10 = new int[r6]     // Catch:{ all -> 0x00eb }
            int[] r11 = new int[r6]     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzkg[] r12 = new com.google.android.gms.internal.ads.zzkg[r6]     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzhp[] r0 = new com.google.android.gms.internal.ads.zzhp[r6]     // Catch:{ all -> 0x00eb }
            int r2 = r5.zzbfj     // Catch:{ all -> 0x00eb }
            int r3 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            int r2 = r2 - r3
            long[] r3 = r5.zzaom     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r8, r1, r2)     // Catch:{ all -> 0x00eb }
            long[] r3 = r5.zzaoo     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r9, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.zzaxi     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r10, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.zzaol     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r11, r1, r2)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzkg[] r3 = r5.zzbfl     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r12, r1, r2)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzhp[] r3 = r5.zzbfm     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r0, r1, r2)     // Catch:{ all -> 0x00eb }
            int[] r3 = r5.zzbfk     // Catch:{ all -> 0x00eb }
            int r4 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r3, r4, r7, r1, r2)     // Catch:{ all -> 0x00eb }
            int r3 = r5.zzbfo     // Catch:{ all -> 0x00eb }
            long[] r4 = r5.zzaom     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r8, r2, r3)     // Catch:{ all -> 0x00eb }
            long[] r4 = r5.zzaoo     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r9, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.zzaxi     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r10, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.zzaol     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r11, r2, r3)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzkg[] r4 = r5.zzbfl     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r12, r2, r3)     // Catch:{ all -> 0x00eb }
            com.google.android.gms.internal.ads.zzhp[] r4 = r5.zzbfm     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r0, r2, r3)     // Catch:{ all -> 0x00eb }
            int[] r4 = r5.zzbfk     // Catch:{ all -> 0x00eb }
            java.lang.System.arraycopy(r4, r1, r7, r2, r3)     // Catch:{ all -> 0x00eb }
            r5.zzaom = r8     // Catch:{ all -> 0x00eb }
            r5.zzaoo = r9     // Catch:{ all -> 0x00eb }
            r5.zzaxi = r10     // Catch:{ all -> 0x00eb }
            r5.zzaol = r11     // Catch:{ all -> 0x00eb }
            r5.zzbfl = r12     // Catch:{ all -> 0x00eb }
            r5.zzbfm = r0     // Catch:{ all -> 0x00eb }
            r5.zzbfk = r7     // Catch:{ all -> 0x00eb }
            r5.zzbfo = r1     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfj     // Catch:{ all -> 0x00eb }
            r5.zzbfp = r7     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfj     // Catch:{ all -> 0x00eb }
            r5.length = r7     // Catch:{ all -> 0x00eb }
            r5.zzbfj = r6     // Catch:{ all -> 0x00eb }
            monitor-exit(r5)
            return
        L_0x00dc:
            int r6 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            int r6 = r6 + r2
            r5.zzbfp = r6     // Catch:{ all -> 0x00eb }
            int r6 = r5.zzbfp     // Catch:{ all -> 0x00eb }
            int r7 = r5.zzbfj     // Catch:{ all -> 0x00eb }
            if (r6 != r7) goto L_0x00e9
            r5.zzbfp = r1     // Catch:{ all -> 0x00eb }
        L_0x00e9:
            monitor-exit(r5)
            return
        L_0x00eb:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzng.zza(long, int, long, int, com.google.android.gms.internal.ads.zzkg):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzd(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzie()     // Catch:{ all -> 0x0061 }
            r1 = -1
            if (r0 == 0) goto L_0x005f
            long[] r0 = r8.zzaoo     // Catch:{ all -> 0x0061 }
            int r3 = r8.zzbfo     // Catch:{ all -> 0x0061 }
            r3 = r0[r3]     // Catch:{ all -> 0x0061 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005f
        L_0x0014:
            long r3 = r8.zzbfr     // Catch:{ all -> 0x0061 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x001e
            if (r11 != 0) goto L_0x001e
            monitor-exit(r8)
            return r1
        L_0x001e:
            r11 = 0
            int r0 = r8.zzbfo     // Catch:{ all -> 0x0061 }
            r3 = -1
            r11 = -1
            r4 = 0
        L_0x0024:
            int r5 = r8.zzbfp     // Catch:{ all -> 0x0061 }
            if (r0 == r5) goto L_0x0041
            long[] r5 = r8.zzaoo     // Catch:{ all -> 0x0061 }
            r6 = r5[r0]     // Catch:{ all -> 0x0061 }
            int r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x0041
            int[] r5 = r8.zzaxi     // Catch:{ all -> 0x0061 }
            r5 = r5[r0]     // Catch:{ all -> 0x0061 }
            r5 = r5 & 1
            if (r5 == 0) goto L_0x0039
            r11 = r4
        L_0x0039:
            int r0 = r0 + 1
            int r5 = r8.zzbfj     // Catch:{ all -> 0x0061 }
            int r0 = r0 % r5
            int r4 = r4 + 1
            goto L_0x0024
        L_0x0041:
            if (r11 != r3) goto L_0x0045
            monitor-exit(r8)
            return r1
        L_0x0045:
            int r9 = r8.zzbfo     // Catch:{ all -> 0x0061 }
            int r9 = r9 + r11
            int r10 = r8.zzbfj     // Catch:{ all -> 0x0061 }
            int r9 = r9 % r10
            r8.zzbfo = r9     // Catch:{ all -> 0x0061 }
            int r9 = r8.zzbfn     // Catch:{ all -> 0x0061 }
            int r9 = r9 + r11
            r8.zzbfn = r9     // Catch:{ all -> 0x0061 }
            int r9 = r8.length     // Catch:{ all -> 0x0061 }
            int r9 = r9 - r11
            r8.length = r9     // Catch:{ all -> 0x0061 }
            long[] r9 = r8.zzaom     // Catch:{ all -> 0x0061 }
            int r10 = r8.zzbfo     // Catch:{ all -> 0x0061 }
            r10 = r9[r10]     // Catch:{ all -> 0x0061 }
            monitor-exit(r8)
            return r10
        L_0x005f:
            monitor-exit(r8)
            return r1
        L_0x0061:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzng.zzd(long, boolean):long");
    }

    public final synchronized void zzei(long j) {
        this.zzbfr = Math.max(this.zzbfr, j);
    }

    public final synchronized boolean zzg(zzhp zzhp) {
        if (zzhp == null) {
            this.zzbft = true;
            return false;
        }
        this.zzbft = false;
        if (zzpt.zza(zzhp, this.zzbfu)) {
            return false;
        }
        this.zzbfu = zzhp;
        return true;
    }

    public final synchronized long zzhv() {
        return Math.max(this.zzbfq, this.zzbfr);
    }

    public final void zzib() {
        this.zzbfn = 0;
        this.zzbfo = 0;
        this.zzbfp = 0;
        this.length = 0;
        this.zzbfs = true;
    }

    public final void zzic() {
        this.zzbfq = Long.MIN_VALUE;
        this.zzbfr = Long.MIN_VALUE;
    }

    public final int zzid() {
        return this.zzbfn + this.length;
    }

    public final synchronized boolean zzie() {
        return this.length != 0;
    }

    public final synchronized zzhp zzif() {
        if (this.zzbft) {
            return null;
        }
        return this.zzbfu;
    }

    public final synchronized long zzig() {
        if (!zzie()) {
            return -1;
        }
        int i = ((this.zzbfo + this.length) - 1) % this.zzbfj;
        this.zzbfo = (this.zzbfo + this.length) % this.zzbfj;
        this.zzbfn += this.length;
        this.length = 0;
        return this.zzaom[i] + ((long) this.zzaol[i]);
    }
}

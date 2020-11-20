package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

public final class zznw extends zzob {
    private static final int[] zzbgx = new int[0];
    private final zzof zzbgy;
    private final AtomicReference<zznz> zzbgz;

    public zznw() {
        this((zzof) null);
    }

    private zznw(zzof zzof) {
        this.zzbgy = null;
        this.zzbgz = new AtomicReference<>(new zznz());
    }

    private static int zze(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0185, code lost:
        if (r9.zzagw <= r15) goto L_0x018a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzoc[] zza(com.google.android.gms.internal.ads.zzhx[] r36, com.google.android.gms.internal.ads.zznq[] r37, int[][][] r38) {
        /*
            r35 = this;
            r0 = r36
            int r1 = r0.length
            com.google.android.gms.internal.ads.zzoc[] r2 = new com.google.android.gms.internal.ads.zzoc[r1]
            r3 = r35
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zznz> r4 = r3.zzbgz
            java.lang.Object r4 = r4.get()
            com.google.android.gms.internal.ads.zznz r4 = (com.google.android.gms.internal.ads.zznz) r4
            r6 = 0
            r7 = 0
        L_0x0011:
            r8 = 2
            if (r6 >= r1) goto L_0x0262
            r12 = r0[r6]
            int r12 = r12.getTrackType()
            if (r8 != r12) goto L_0x024c
            if (r7 != 0) goto L_0x023f
            r7 = r37[r6]
            r12 = r38[r6]
            int r13 = r4.zzbhe
            int r14 = r4.zzbhf
            int r15 = r4.zzbhg
            int r9 = r4.viewportWidth
            int r8 = r4.viewportHeight
            boolean r5 = r4.zzbhj
            boolean r10 = r4.zzbhh
            boolean r11 = r4.zzbhi
            r24 = r1
            r20 = r4
            r0 = 0
            r3 = 0
            r4 = 0
            r21 = 0
            r22 = -1
            r23 = -1
        L_0x003f:
            int r1 = r7.length
            if (r3 >= r1) goto L_0x021d
            com.google.android.gms.internal.ads.zznr r1 = r7.zzbb(r3)
            r25 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r26 = r2
            int r2 = r1.length
            r7.<init>(r2)
            r27 = r6
            r2 = 0
        L_0x0055:
            int r6 = r1.length
            if (r2 >= r6) goto L_0x0063
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            r7.add(r6)
            int r2 = r2 + 1
            goto L_0x0055
        L_0x0063:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r2) goto L_0x0139
            if (r8 != r2) goto L_0x006c
            goto L_0x0139
        L_0x006c:
            r28 = r0
            r6 = 0
        L_0x006f:
            int r0 = r1.length
            if (r6 >= r0) goto L_0x0103
            com.google.android.gms.internal.ads.zzhp r0 = r1.zzbc(r6)
            r29 = r4
            int r4 = r0.width
            if (r4 <= 0) goto L_0x00e9
            int r4 = r0.height
            if (r4 <= 0) goto L_0x00e9
            int r4 = r0.width
            r30 = r10
            int r10 = r0.height
            if (r5 == 0) goto L_0x00a3
            if (r4 <= r10) goto L_0x008f
            r31 = r5
            r5 = 1
            goto L_0x0092
        L_0x008f:
            r31 = r5
            r5 = 0
        L_0x0092:
            if (r9 <= r8) goto L_0x0098
            r32 = r8
            r8 = 1
            goto L_0x009b
        L_0x0098:
            r32 = r8
            r8 = 0
        L_0x009b:
            if (r5 == r8) goto L_0x00a7
            r5 = r9
            r33 = r5
            r8 = r32
            goto L_0x00ac
        L_0x00a3:
            r31 = r5
            r32 = r8
        L_0x00a7:
            r8 = r9
            r33 = r8
            r5 = r32
        L_0x00ac:
            int r9 = r4 * r5
            r34 = r15
            int r15 = r10 * r8
            if (r9 < r15) goto L_0x00bf
            android.graphics.Point r5 = new android.graphics.Point
            int r4 = com.google.android.gms.internal.ads.zzpt.zzf(r15, r4)
            r5.<init>(r8, r4)
            r4 = r5
            goto L_0x00c8
        L_0x00bf:
            android.graphics.Point r4 = new android.graphics.Point
            int r8 = com.google.android.gms.internal.ads.zzpt.zzf(r9, r10)
            r4.<init>(r8, r5)
        L_0x00c8:
            int r5 = r0.width
            int r8 = r0.height
            int r5 = r5 * r8
            int r8 = r0.width
            int r9 = r4.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r8 < r9) goto L_0x00f3
            int r0 = r0.height
            int r4 = r4.y
            float r4 = (float) r4
            float r4 = r4 * r10
            int r4 = (int) r4
            if (r0 < r4) goto L_0x00f3
            if (r5 >= r2) goto L_0x00f3
            r2 = r5
            goto L_0x00f3
        L_0x00e9:
            r31 = r5
            r32 = r8
            r33 = r9
            r30 = r10
            r34 = r15
        L_0x00f3:
            int r6 = r6 + 1
            r4 = r29
            r10 = r30
            r5 = r31
            r8 = r32
            r9 = r33
            r15 = r34
            goto L_0x006f
        L_0x0103:
            r29 = r4
            r31 = r5
            r32 = r8
            r33 = r9
            r30 = r10
            r34 = r15
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r0) goto L_0x0147
            int r0 = r7.size()
            r4 = 1
            int r0 = r0 - r4
        L_0x011a:
            if (r0 < 0) goto L_0x0147
            java.lang.Object r4 = r7.get(r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzhp r4 = r1.zzbc(r4)
            int r4 = r4.zzez()
            r5 = -1
            if (r4 == r5) goto L_0x0133
            if (r4 <= r2) goto L_0x0136
        L_0x0133:
            r7.remove(r0)
        L_0x0136:
            int r0 = r0 + -1
            goto L_0x011a
        L_0x0139:
            r28 = r0
            r29 = r4
            r31 = r5
            r32 = r8
            r33 = r9
            r30 = r10
            r34 = r15
        L_0x0147:
            r0 = r12[r3]
            r5 = r21
            r6 = r22
            r8 = r23
            r4 = r29
            r2 = 0
        L_0x0152:
            int r9 = r1.length
            if (r2 >= r9) goto L_0x01ff
            r9 = r0[r2]
            boolean r9 = zze((int) r9, (boolean) r11)
            if (r9 == 0) goto L_0x01eb
            com.google.android.gms.internal.ads.zzhp r9 = r1.zzbc(r2)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            boolean r10 = r7.contains(r10)
            if (r10 == 0) goto L_0x018c
            int r10 = r9.width
            r15 = -1
            if (r10 == r15) goto L_0x0175
            int r10 = r9.width
            if (r10 > r13) goto L_0x018c
        L_0x0175:
            int r10 = r9.height
            if (r10 == r15) goto L_0x017d
            int r10 = r9.height
            if (r10 > r14) goto L_0x018c
        L_0x017d:
            int r10 = r9.zzagw
            if (r10 == r15) goto L_0x0188
            int r10 = r9.zzagw
            r15 = r34
            if (r10 > r15) goto L_0x018e
            goto L_0x018a
        L_0x0188:
            r15 = r34
        L_0x018a:
            r10 = 1
            goto L_0x018f
        L_0x018c:
            r15 = r34
        L_0x018e:
            r10 = 0
        L_0x018f:
            if (r10 != 0) goto L_0x019b
            if (r30 == 0) goto L_0x0194
            goto L_0x019b
        L_0x0194:
            r23 = r0
            r21 = r1
            r22 = r4
            goto L_0x01f3
        L_0x019b:
            if (r10 == 0) goto L_0x01a3
            r21 = r1
            r22 = r4
            r1 = 2
            goto L_0x01a8
        L_0x01a3:
            r21 = r1
            r22 = r4
            r1 = 1
        L_0x01a8:
            r4 = r0[r2]
            r23 = r0
            r0 = 0
            boolean r4 = zze((int) r4, (boolean) r0)
            if (r4 == 0) goto L_0x01b5
            int r1 = r1 + 1000
        L_0x01b5:
            if (r1 <= r5) goto L_0x01b9
            r0 = 1
            goto L_0x01ba
        L_0x01b9:
            r0 = 0
        L_0x01ba:
            if (r1 != r5) goto L_0x01dd
            int r0 = r9.zzez()
            if (r0 == r6) goto L_0x01cb
            int r0 = r9.zzez()
            int r0 = zze((int) r0, (int) r6)
            goto L_0x01d1
        L_0x01cb:
            int r0 = r9.zzagw
            int r0 = zze((int) r0, (int) r8)
        L_0x01d1:
            if (r4 == 0) goto L_0x01d8
            if (r10 == 0) goto L_0x01d8
            if (r0 <= 0) goto L_0x01dc
            goto L_0x01da
        L_0x01d8:
            if (r0 >= 0) goto L_0x01dc
        L_0x01da:
            r0 = 1
            goto L_0x01dd
        L_0x01dc:
            r0 = 0
        L_0x01dd:
            if (r0 == 0) goto L_0x01f3
            int r8 = r9.zzagw
            int r6 = r9.zzez()
            r5 = r1
            r28 = r2
            r4 = r21
            goto L_0x01f5
        L_0x01eb:
            r23 = r0
            r21 = r1
            r22 = r4
            r15 = r34
        L_0x01f3:
            r4 = r22
        L_0x01f5:
            int r2 = r2 + 1
            r34 = r15
            r1 = r21
            r0 = r23
            goto L_0x0152
        L_0x01ff:
            r22 = r4
            r15 = r34
            int r3 = r3 + 1
            r21 = r5
            r23 = r8
            r7 = r25
            r2 = r26
            r0 = r28
            r10 = r30
            r5 = r31
            r8 = r32
            r9 = r33
            r22 = r6
            r6 = r27
            goto L_0x003f
        L_0x021d:
            r28 = r0
            r26 = r2
            r29 = r4
            r27 = r6
            if (r29 != 0) goto L_0x022a
            r16 = 0
            goto L_0x0235
        L_0x022a:
            com.google.android.gms.internal.ads.zzny r9 = new com.google.android.gms.internal.ads.zzny
            r1 = r28
            r0 = r29
            r9.<init>(r0, r1)
            r16 = r9
        L_0x0235:
            r26[r27] = r16
            r0 = r26[r27]
            if (r0 == 0) goto L_0x023d
            r7 = 1
            goto L_0x0247
        L_0x023d:
            r7 = 0
            goto L_0x0247
        L_0x023f:
            r24 = r1
            r26 = r2
            r20 = r4
            r27 = r6
        L_0x0247:
            r0 = r37[r27]
            int r0 = r0.length
            goto L_0x0254
        L_0x024c:
            r24 = r1
            r26 = r2
            r20 = r4
            r27 = r6
        L_0x0254:
            int r6 = r27 + 1
            r4 = r20
            r1 = r24
            r2 = r26
            r0 = r36
            r3 = r35
            goto L_0x0011
        L_0x0262:
            r26 = r2
            r20 = r4
            r0 = r1
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x026a:
            if (r1 >= r0) goto L_0x0404
            r4 = r36[r1]
            int r4 = r4.getTrackType()
            switch(r4) {
                case 1: goto L_0x0320;
                case 2: goto L_0x0318;
                case 3: goto L_0x028d;
                default: goto L_0x0275;
            }
        L_0x0275:
            r24 = r0
            r5 = r20
            r6 = -1
            r17 = 2
            r0 = r36[r1]
            r0.getTrackType()
            r0 = r37[r1]
            r4 = r38[r1]
            boolean r7 = r5.zzbhi
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            goto L_0x0394
        L_0x028d:
            if (r3 != 0) goto L_0x0318
            r3 = r37[r1]
            r4 = r38[r1]
            r5 = r20
            boolean r6 = r5.zzbhi
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x029b:
            int r11 = r3.length
            if (r7 >= r11) goto L_0x02ff
            com.google.android.gms.internal.ads.zznr r11 = r3.zzbb(r7)
            r12 = r4[r7]
            r13 = r10
            r10 = r9
            r9 = r8
            r8 = 0
        L_0x02a9:
            int r14 = r11.length
            if (r8 >= r14) goto L_0x02f5
            r14 = r12[r8]
            boolean r14 = zze((int) r14, (boolean) r6)
            if (r14 == 0) goto L_0x02ec
            com.google.android.gms.internal.ads.zzhp r14 = r11.zzbc(r8)
            int r15 = r14.zzahq
            r19 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x02c3
            r15 = 1
            goto L_0x02c4
        L_0x02c3:
            r15 = 0
        L_0x02c4:
            int r14 = r14.zzahq
            r17 = 2
            r14 = r14 & 2
            if (r14 == 0) goto L_0x02ce
            r14 = 1
            goto L_0x02cf
        L_0x02ce:
            r14 = 0
        L_0x02cf:
            if (r15 == 0) goto L_0x02d3
            r14 = 3
            goto L_0x02d6
        L_0x02d3:
            if (r14 == 0) goto L_0x02e9
            r14 = 1
        L_0x02d6:
            r15 = r12[r8]
            r24 = r0
            r0 = 0
            boolean r15 = zze((int) r15, (boolean) r0)
            if (r15 == 0) goto L_0x02e3
            int r14 = r14 + 1000
        L_0x02e3:
            if (r14 <= r13) goto L_0x02f0
            r10 = r8
            r9 = r11
            r13 = r14
            goto L_0x02f0
        L_0x02e9:
            r24 = r0
            goto L_0x02f0
        L_0x02ec:
            r24 = r0
            r17 = 2
        L_0x02f0:
            int r8 = r8 + 1
            r0 = r24
            goto L_0x02a9
        L_0x02f5:
            r24 = r0
            r17 = 2
            int r7 = r7 + 1
            r8 = r9
            r9 = r10
            r10 = r13
            goto L_0x029b
        L_0x02ff:
            r24 = r0
            r17 = 2
            if (r8 != 0) goto L_0x0307
            r0 = 0
            goto L_0x030c
        L_0x0307:
            com.google.android.gms.internal.ads.zzny r0 = new com.google.android.gms.internal.ads.zzny
            r0.<init>(r8, r9)
        L_0x030c:
            r26[r1] = r0
            r0 = r26[r1]
            if (r0 == 0) goto L_0x0314
            r0 = 1
            goto L_0x0315
        L_0x0314:
            r0 = 0
        L_0x0315:
            r3 = r0
            goto L_0x038f
        L_0x0318:
            r24 = r0
            r5 = r20
            r17 = 2
            goto L_0x038f
        L_0x0320:
            r24 = r0
            r5 = r20
            r17 = 2
            if (r2 != 0) goto L_0x038f
            r0 = r37[r1]
            r2 = r38[r1]
            boolean r4 = r5.zzbhi
            r6 = 0
            r7 = -1
            r8 = -1
            r9 = 0
        L_0x0332:
            int r10 = r0.length
            if (r6 >= r10) goto L_0x0377
            com.google.android.gms.internal.ads.zznr r10 = r0.zzbb(r6)
            r11 = r2[r6]
            r12 = r9
            r9 = r8
            r8 = r7
            r7 = 0
        L_0x0340:
            int r13 = r10.length
            if (r7 >= r13) goto L_0x0371
            r13 = r11[r7]
            boolean r13 = zze((int) r13, (boolean) r4)
            if (r13 == 0) goto L_0x036e
            com.google.android.gms.internal.ads.zzhp r13 = r10.zzbc(r7)
            r14 = r11[r7]
            int r13 = r13.zzahq
            r15 = 1
            r13 = r13 & r15
            if (r13 == 0) goto L_0x035a
            r13 = 1
            goto L_0x035b
        L_0x035a:
            r13 = 0
        L_0x035b:
            if (r13 == 0) goto L_0x035f
            r13 = 2
            goto L_0x0360
        L_0x035f:
            r13 = 1
        L_0x0360:
            r15 = 0
            boolean r14 = zze((int) r14, (boolean) r15)
            if (r14 == 0) goto L_0x0369
            int r13 = r13 + 1000
        L_0x0369:
            if (r13 <= r12) goto L_0x036e
            r8 = r6
            r9 = r7
            r12 = r13
        L_0x036e:
            int r7 = r7 + 1
            goto L_0x0340
        L_0x0371:
            int r6 = r6 + 1
            r7 = r8
            r8 = r9
            r9 = r12
            goto L_0x0332
        L_0x0377:
            r6 = -1
            if (r7 != r6) goto L_0x037c
            r9 = 0
            goto L_0x0385
        L_0x037c:
            com.google.android.gms.internal.ads.zznr r0 = r0.zzbb(r7)
            com.google.android.gms.internal.ads.zzny r9 = new com.google.android.gms.internal.ads.zzny
            r9.<init>(r0, r8)
        L_0x0385:
            r26[r1] = r9
            r0 = r26[r1]
            if (r0 == 0) goto L_0x038d
            r0 = 1
            goto L_0x038e
        L_0x038d:
            r0 = 0
        L_0x038e:
            r2 = r0
        L_0x038f:
            r0 = 0
            r18 = 1
            goto L_0x03fc
        L_0x0394:
            int r12 = r0.length
            if (r8 >= r12) goto L_0x03ee
            com.google.android.gms.internal.ads.zznr r12 = r0.zzbb(r8)
            r13 = r4[r8]
            r14 = r11
            r11 = r10
            r10 = r9
            r9 = 0
        L_0x03a2:
            int r15 = r12.length
            if (r9 >= r15) goto L_0x03e0
            r15 = r13[r9]
            boolean r15 = zze((int) r15, (boolean) r7)
            if (r15 == 0) goto L_0x03d5
            com.google.android.gms.internal.ads.zzhp r15 = r12.zzbc(r9)
            int r15 = r15.zzahq
            r18 = 1
            r15 = r15 & 1
            if (r15 == 0) goto L_0x03bc
            r15 = 1
            goto L_0x03bd
        L_0x03bc:
            r15 = 0
        L_0x03bd:
            if (r15 == 0) goto L_0x03c1
            r15 = 2
            goto L_0x03c2
        L_0x03c1:
            r15 = 1
        L_0x03c2:
            r6 = r13[r9]
            r20 = r0
            r0 = 0
            boolean r6 = zze((int) r6, (boolean) r0)
            if (r6 == 0) goto L_0x03cf
            int r15 = r15 + 1000
        L_0x03cf:
            if (r15 <= r14) goto L_0x03da
            r11 = r9
            r10 = r12
            r14 = r15
            goto L_0x03da
        L_0x03d5:
            r20 = r0
            r0 = 0
            r18 = 1
        L_0x03da:
            int r9 = r9 + 1
            r0 = r20
            r6 = -1
            goto L_0x03a2
        L_0x03e0:
            r20 = r0
            r0 = 0
            r18 = 1
            int r8 = r8 + 1
            r9 = r10
            r10 = r11
            r11 = r14
            r0 = r20
            r6 = -1
            goto L_0x0394
        L_0x03ee:
            r0 = 0
            r18 = 1
            if (r9 != 0) goto L_0x03f5
            r4 = 0
            goto L_0x03fa
        L_0x03f5:
            com.google.android.gms.internal.ads.zzny r4 = new com.google.android.gms.internal.ads.zzny
            r4.<init>(r9, r10)
        L_0x03fa:
            r26[r1] = r4
        L_0x03fc:
            int r1 = r1 + 1
            r20 = r5
            r0 = r24
            goto L_0x026a
        L_0x0404:
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznw.zza(com.google.android.gms.internal.ads.zzhx[], com.google.android.gms.internal.ads.zznq[], int[][][]):com.google.android.gms.internal.ads.zzoc[]");
    }
}

package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Map;

public abstract class zzob extends zzoh {
    private int zzaid = 0;
    private final SparseArray<Map<zznq, zzod>> zzbhp = new SparseArray<>();
    private final SparseBooleanArray zzbhq = new SparseBooleanArray();
    private zzoa zzbhr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: com.google.android.gms.internal.ads.zzod} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzoj zza(com.google.android.gms.internal.ads.zzhx[] r17, com.google.android.gms.internal.ads.zznq r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            int r3 = r1.length
            int r3 = r3 + 1
            int[] r3 = new int[r3]
            int r4 = r1.length
            int r4 = r4 + 1
            com.google.android.gms.internal.ads.zznr[][] r4 = new com.google.android.gms.internal.ads.zznr[r4][]
            int r5 = r1.length
            int r5 = r5 + 1
            int[][][] r10 = new int[r5][][]
            r6 = 0
        L_0x0016:
            int r7 = r4.length
            if (r6 >= r7) goto L_0x0028
            int r7 = r2.length
            com.google.android.gms.internal.ads.zznr[] r7 = new com.google.android.gms.internal.ads.zznr[r7]
            r4[r6] = r7
            int r7 = r2.length
            int[][] r7 = new int[r7][]
            r10[r6] = r7
            int r6 = r6 + 1
            goto L_0x0016
        L_0x0028:
            int r6 = r1.length
            int[] r9 = new int[r6]
            r6 = 0
        L_0x002c:
            int r7 = r9.length
            if (r6 >= r7) goto L_0x003a
            r7 = r1[r6]
            int r7 = r7.zzeg()
            r9[r6] = r7
            int r6 = r6 + 1
            goto L_0x002c
        L_0x003a:
            r6 = 0
        L_0x003b:
            int r7 = r2.length
            if (r6 >= r7) goto L_0x00a0
            com.google.android.gms.internal.ads.zznr r7 = r2.zzbb(r6)
            int r8 = r1.length
            r12 = r8
            r8 = 0
            r11 = 0
        L_0x0047:
            int r13 = r1.length
            if (r8 >= r13) goto L_0x006b
            r13 = r1[r8]
            r14 = r12
            r12 = r11
            r11 = 0
        L_0x004f:
            int r15 = r7.length
            if (r11 >= r15) goto L_0x0066
            com.google.android.gms.internal.ads.zzhp r15 = r7.zzbc(r11)
            int r15 = r13.zza(r15)
            r5 = 3
            r15 = r15 & r5
            if (r15 <= r12) goto L_0x0063
            if (r15 == r5) goto L_0x006c
            r14 = r8
            r12 = r15
        L_0x0063:
            int r11 = r11 + 1
            goto L_0x004f
        L_0x0066:
            int r8 = r8 + 1
            r11 = r12
            r12 = r14
            goto L_0x0047
        L_0x006b:
            r8 = r12
        L_0x006c:
            int r5 = r1.length
            if (r8 != r5) goto L_0x0074
            int r5 = r7.length
            int[] r5 = new int[r5]
            goto L_0x008d
        L_0x0074:
            r5 = r1[r8]
            int r11 = r7.length
            int[] r11 = new int[r11]
            r12 = 0
        L_0x007b:
            int r13 = r7.length
            if (r12 >= r13) goto L_0x008c
            com.google.android.gms.internal.ads.zzhp r13 = r7.zzbc(r12)
            int r13 = r5.zza(r13)
            r11[r12] = r13
            int r12 = r12 + 1
            goto L_0x007b
        L_0x008c:
            r5 = r11
        L_0x008d:
            r11 = r3[r8]
            r12 = r4[r8]
            r12[r11] = r7
            r7 = r10[r8]
            r7[r11] = r5
            r5 = r3[r8]
            int r5 = r5 + 1
            r3[r8] = r5
            int r6 = r6 + 1
            goto L_0x003b
        L_0x00a0:
            int r5 = r1.length
            com.google.android.gms.internal.ads.zznq[] r8 = new com.google.android.gms.internal.ads.zznq[r5]
            int r5 = r1.length
            int[] r7 = new int[r5]
            r5 = 0
        L_0x00a7:
            int r6 = r1.length
            if (r5 >= r6) goto L_0x00d0
            r6 = r3[r5]
            com.google.android.gms.internal.ads.zznq r11 = new com.google.android.gms.internal.ads.zznq
            r12 = r4[r5]
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            com.google.android.gms.internal.ads.zznr[] r12 = (com.google.android.gms.internal.ads.zznr[]) r12
            r11.<init>(r12)
            r8[r5] = r11
            r11 = r10[r5]
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r11, r6)
            int[][] r6 = (int[][]) r6
            r10[r5] = r6
            r6 = r1[r5]
            int r6 = r6.getTrackType()
            r7[r5] = r6
            int r5 = r5 + 1
            goto L_0x00a7
        L_0x00d0:
            int r5 = r1.length
            r3 = r3[r5]
            com.google.android.gms.internal.ads.zznq r11 = new com.google.android.gms.internal.ads.zznq
            int r5 = r1.length
            r4 = r4[r5]
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r4, r3)
            com.google.android.gms.internal.ads.zznr[] r3 = (com.google.android.gms.internal.ads.zznr[]) r3
            r11.<init>(r3)
            com.google.android.gms.internal.ads.zzoc[] r3 = r0.zza(r1, r8, r10)
            r4 = 0
        L_0x00e6:
            int r5 = r1.length
            r12 = 0
            if (r4 >= r5) goto L_0x0114
            android.util.SparseBooleanArray r5 = r0.zzbhq
            boolean r5 = r5.get(r4)
            if (r5 == 0) goto L_0x00f5
            r3[r4] = r12
            goto L_0x010b
        L_0x00f5:
            r5 = r8[r4]
            android.util.SparseArray<java.util.Map<com.google.android.gms.internal.ads.zznq, com.google.android.gms.internal.ads.zzod>> r6 = r0.zzbhp
            java.lang.Object r6 = r6.get(r4)
            java.util.Map r6 = (java.util.Map) r6
            if (r6 != 0) goto L_0x0102
            goto L_0x0109
        L_0x0102:
            java.lang.Object r5 = r6.get(r5)
            r12 = r5
            com.google.android.gms.internal.ads.zzod r12 = (com.google.android.gms.internal.ads.zzod) r12
        L_0x0109:
            if (r12 != 0) goto L_0x010e
        L_0x010b:
            int r4 = r4 + 1
            goto L_0x00e6
        L_0x010e:
            java.lang.NoSuchMethodError r1 = new java.lang.NoSuchMethodError
            r1.<init>()
            throw r1
        L_0x0114:
            com.google.android.gms.internal.ads.zzoa r4 = new com.google.android.gms.internal.ads.zzoa
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11)
            int r5 = r1.length
            com.google.android.gms.internal.ads.zzia[] r5 = new com.google.android.gms.internal.ads.zzia[r5]
            r6 = 0
        L_0x011e:
            int r7 = r1.length
            if (r6 >= r7) goto L_0x012e
            r7 = r3[r6]
            if (r7 == 0) goto L_0x0128
            com.google.android.gms.internal.ads.zzia r7 = com.google.android.gms.internal.ads.zzia.zzaic
            goto L_0x0129
        L_0x0128:
            r7 = r12
        L_0x0129:
            r5[r6] = r7
            int r6 = r6 + 1
            goto L_0x011e
        L_0x012e:
            com.google.android.gms.internal.ads.zzoj r1 = new com.google.android.gms.internal.ads.zzoj
            com.google.android.gms.internal.ads.zzoe r6 = new com.google.android.gms.internal.ads.zzoe
            r6.<init>(r3)
            r1.<init>(r2, r6, r4, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzob.zza(com.google.android.gms.internal.ads.zzhx[], com.google.android.gms.internal.ads.zznq):com.google.android.gms.internal.ads.zzoj");
    }

    /* access modifiers changed from: protected */
    public abstract zzoc[] zza(zzhx[] zzhxArr, zznq[] zznqArr, int[][][] iArr);

    public final void zzd(Object obj) {
        this.zzbhr = (zzoa) obj;
    }

    public final void zzf(int i, boolean z) {
        if (this.zzbhq.get(i) != z) {
            this.zzbhq.put(i, z);
            invalidate();
        }
    }
}

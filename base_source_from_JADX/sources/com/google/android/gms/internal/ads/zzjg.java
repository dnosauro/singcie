package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzjg {
    private final int zzahl;
    private float zzahy;
    private float zzahz;
    private final int zzamy;
    private final int zzamz;
    private final int zzana;
    private final int zzanb = (this.zzana * 2);
    private final short[] zzanc;
    private int zzand;
    private short[] zzane;
    private int zzanf;
    private short[] zzang;
    private int zzanh;
    private short[] zzani;
    private int zzanj;
    private int zzank;
    private int zzanl;
    private int zzanm;
    private int zzann;
    private int zzano;
    private int zzanp;
    private int zzanq;
    private int zzanr;
    private int zzans;

    public zzjg(int i, int i2) {
        this.zzahl = i;
        this.zzamy = i2;
        this.zzamz = i / 400;
        this.zzana = i / 65;
        int i3 = this.zzanb;
        this.zzanc = new short[i3];
        this.zzand = i3;
        this.zzane = new short[(i3 * i2)];
        this.zzanf = i3;
        this.zzang = new short[(i3 * i2)];
        this.zzanh = i3;
        this.zzani = new short[(i3 * i2)];
        this.zzanj = 0;
        this.zzank = 0;
        this.zzanp = 0;
        this.zzahy = 1.0f;
        this.zzahz = 1.0f;
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzamy;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.zzanr = i5 / i6;
        this.zzans = i7 / i8;
        return i6;
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzy(i2);
        int i3 = this.zzamy;
        System.arraycopy(sArr, i * i3, this.zzang, this.zzanm * i3, i3 * i2);
        this.zzanm += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzanb / i2;
        int i4 = this.zzamy;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzanc[i7] = (short) (i8 / i5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzgi() {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.zzanm
            float r2 = r0.zzahy
            float r3 = r0.zzahz
            float r2 = r2 / r3
            double r3 = (double) r2
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r7 = 1
            r8 = 4607182463836013682(0x3ff0000a7c5ac472, double:1.00001)
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x002c
            r8 = 4607182328728024861(0x3fefffeb074a771d, double:0.99999)
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0021
            goto L_0x002c
        L_0x0021:
            short[] r2 = r0.zzane
            int r3 = r0.zzanl
            r0.zza(r2, r6, r3)
            r0.zzanl = r6
            goto L_0x0170
        L_0x002c:
            int r8 = r0.zzanl
            int r9 = r0.zzanb
            if (r8 < r9) goto L_0x0170
            r9 = 0
        L_0x0033:
            int r10 = r0.zzano
            if (r10 <= 0) goto L_0x004a
            int r11 = r0.zzanb
            int r10 = java.lang.Math.min(r11, r10)
            short[] r11 = r0.zzane
            r0.zza(r11, r9, r10)
            int r11 = r0.zzano
            int r11 = r11 - r10
            r0.zzano = r11
            int r9 = r9 + r10
            goto L_0x0157
        L_0x004a:
            short[] r10 = r0.zzane
            int r11 = r0.zzahl
            r12 = 4000(0xfa0, float:5.605E-42)
            if (r11 <= r12) goto L_0x0055
            int r11 = r11 / 4000
            goto L_0x0056
        L_0x0055:
            r11 = 1
        L_0x0056:
            int r12 = r0.zzamy
            if (r12 != r7) goto L_0x0065
            if (r11 != r7) goto L_0x0065
            int r11 = r0.zzamz
            int r12 = r0.zzana
        L_0x0060:
            int r10 = r0.zza(r10, r9, r11, r12)
            goto L_0x0098
        L_0x0065:
            r0.zzb(r10, r9, r11)
            short[] r12 = r0.zzanc
            int r13 = r0.zzamz
            int r13 = r13 / r11
            int r14 = r0.zzana
            int r14 = r14 / r11
            int r12 = r0.zza(r12, r6, r13, r14)
            if (r11 == r7) goto L_0x0097
            int r12 = r12 * r11
            int r11 = r11 << 2
            int r13 = r12 - r11
            int r12 = r12 + r11
            int r11 = r0.zzamz
            if (r13 >= r11) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r11 = r13
        L_0x0083:
            int r13 = r0.zzana
            if (r12 <= r13) goto L_0x0088
            r12 = r13
        L_0x0088:
            int r13 = r0.zzamy
            if (r13 != r7) goto L_0x008d
            goto L_0x0060
        L_0x008d:
            r0.zzb(r10, r9, r7)
            short[] r10 = r0.zzanc
            int r10 = r0.zza(r10, r6, r11, r12)
            goto L_0x0098
        L_0x0097:
            r10 = r12
        L_0x0098:
            int r11 = r0.zzanr
            int r12 = r0.zzans
            if (r11 == 0) goto L_0x00b3
            int r13 = r0.zzanp
            if (r13 != 0) goto L_0x00a3
            goto L_0x00b3
        L_0x00a3:
            int r13 = r11 * 3
            if (r12 <= r13) goto L_0x00a8
            goto L_0x00b3
        L_0x00a8:
            int r11 = r11 << 1
            int r12 = r0.zzanq
            int r12 = r12 * 3
            if (r11 > r12) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r11 = 1
            goto L_0x00b4
        L_0x00b3:
            r11 = 0
        L_0x00b4:
            if (r11 == 0) goto L_0x00ba
            int r11 = r0.zzanp
            r15 = r11
            goto L_0x00bb
        L_0x00ba:
            r15 = r10
        L_0x00bb:
            int r11 = r0.zzanr
            r0.zzanq = r11
            r0.zzanp = r10
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r12 = 1073741824(0x40000000, float:2.0)
            int r13 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r13 <= 0) goto L_0x0104
            short[] r14 = r0.zzane
            int r10 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x00d6
            float r10 = (float) r15
            float r11 = r2 - r5
            float r10 = r10 / r11
            int r10 = (int) r10
            r13 = r10
            goto L_0x00e1
        L_0x00d6:
            float r10 = (float) r15
            float r12 = r12 - r2
            float r10 = r10 * r12
            float r11 = r2 - r5
            float r10 = r10 / r11
            int r10 = (int) r10
            r0.zzano = r10
            r13 = r15
        L_0x00e1:
            r0.zzy(r13)
            int r11 = r0.zzamy
            short[] r12 = r0.zzang
            int r10 = r0.zzanm
            int r17 = r9 + r15
            r16 = r10
            r10 = r13
            r18 = r13
            r13 = r16
            r16 = r14
            r7 = r15
            r15 = r9
            zza(r10, r11, r12, r13, r14, r15, r16, r17)
            int r10 = r0.zzanm
            int r10 = r10 + r18
            r0.zzanm = r10
            int r15 = r7 + r18
            int r9 = r9 + r15
            goto L_0x0157
        L_0x0104:
            r7 = r15
            short[] r15 = r0.zzane
            r10 = 1056964608(0x3f000000, float:0.5)
            int r10 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x0117
            float r10 = (float) r7
            float r10 = r10 * r2
            float r11 = r5 - r2
            float r10 = r10 / r11
            int r10 = (int) r10
            r18 = r10
            goto L_0x0125
        L_0x0117:
            float r10 = (float) r7
            float r12 = r12 * r2
            float r12 = r12 - r5
            float r10 = r10 * r12
            float r11 = r5 - r2
            float r10 = r10 / r11
            int r10 = (int) r10
            r0.zzano = r10
            r18 = r7
        L_0x0125:
            int r14 = r7 + r18
            r0.zzy(r14)
            int r10 = r0.zzamy
            int r11 = r9 * r10
            short[] r12 = r0.zzang
            int r13 = r0.zzanm
            int r13 = r13 * r10
            int r10 = r10 * r7
            java.lang.System.arraycopy(r15, r11, r12, r13, r10)
            int r11 = r0.zzamy
            short[] r12 = r0.zzang
            int r10 = r0.zzanm
            int r13 = r10 + r7
            int r7 = r7 + r9
            r10 = r18
            r19 = r14
            r14 = r15
            r16 = r15
            r15 = r7
            r17 = r9
            zza(r10, r11, r12, r13, r14, r15, r16, r17)
            int r7 = r0.zzanm
            int r7 = r7 + r19
            r0.zzanm = r7
            int r9 = r9 + r18
        L_0x0157:
            int r7 = r0.zzanb
            int r7 = r7 + r9
            if (r7 <= r8) goto L_0x016d
            int r2 = r0.zzanl
            int r2 = r2 - r9
            short[] r3 = r0.zzane
            int r4 = r0.zzamy
            int r9 = r9 * r4
            int r4 = r4 * r2
            java.lang.System.arraycopy(r3, r9, r3, r6, r4)
            r0.zzanl = r2
            goto L_0x0170
        L_0x016d:
            r7 = 1
            goto L_0x0033
        L_0x0170:
            float r2 = r0.zzahz
            int r3 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0248
            int r3 = r0.zzanm
            if (r3 == r1) goto L_0x0248
            int r3 = r0.zzahl
            float r4 = (float) r3
            float r4 = r4 / r2
            int r2 = (int) r4
        L_0x017f:
            r4 = 16384(0x4000, float:2.2959E-41)
            if (r2 > r4) goto L_0x0241
            if (r3 <= r4) goto L_0x0187
            goto L_0x0241
        L_0x0187:
            int r4 = r0.zzanm
            int r4 = r4 - r1
            int r5 = r0.zzann
            int r5 = r5 + r4
            int r7 = r0.zzanh
            if (r5 <= r7) goto L_0x01a5
            int r5 = r7 / 2
            int r5 = r5 + r4
            int r7 = r7 + r5
            r0.zzanh = r7
            short[] r5 = r0.zzani
            int r7 = r0.zzanh
            int r8 = r0.zzamy
            int r7 = r7 * r8
            short[] r5 = java.util.Arrays.copyOf(r5, r7)
            r0.zzani = r5
        L_0x01a5:
            short[] r5 = r0.zzang
            int r7 = r0.zzamy
            int r8 = r1 * r7
            short[] r9 = r0.zzani
            int r10 = r0.zzann
            int r10 = r10 * r7
            int r7 = r7 * r4
            java.lang.System.arraycopy(r5, r8, r9, r10, r7)
            r0.zzanm = r1
            int r1 = r0.zzann
            int r1 = r1 + r4
            r0.zzann = r1
            r1 = 0
        L_0x01be:
            int r4 = r0.zzann
            int r5 = r4 + -1
            if (r1 >= r5) goto L_0x022b
        L_0x01c4:
            int r4 = r0.zzanj
            int r5 = r4 + 1
            int r5 = r5 * r2
            int r7 = r0.zzank
            int r8 = r7 * r3
            if (r5 <= r8) goto L_0x0213
            r5 = 1
            r0.zzy(r5)
            r4 = 0
        L_0x01d5:
            int r5 = r0.zzamy
            if (r4 >= r5) goto L_0x0207
            short[] r7 = r0.zzang
            int r8 = r0.zzanm
            int r8 = r8 * r5
            int r8 = r8 + r4
            short[] r9 = r0.zzani
            int r10 = r1 * r5
            int r10 = r10 + r4
            short r11 = r9[r10]
            int r10 = r10 + r5
            short r5 = r9[r10]
            int r9 = r0.zzank
            int r9 = r9 * r3
            int r10 = r0.zzanj
            int r12 = r10 * r2
            r13 = 1
            int r10 = r10 + r13
            int r10 = r10 * r2
            int r9 = r10 - r9
            int r10 = r10 - r12
            int r11 = r11 * r9
            int r9 = r10 - r9
            int r9 = r9 * r5
            int r11 = r11 + r9
            int r11 = r11 / r10
            short r5 = (short) r11
            r7[r8] = r5
            int r4 = r4 + 1
            goto L_0x01d5
        L_0x0207:
            int r4 = r0.zzank
            r5 = 1
            int r4 = r4 + r5
            r0.zzank = r4
            int r4 = r0.zzanm
            int r4 = r4 + r5
            r0.zzanm = r4
            goto L_0x01c4
        L_0x0213:
            r5 = 1
            int r4 = r4 + 1
            r0.zzanj = r4
            int r4 = r0.zzanj
            if (r4 != r3) goto L_0x0228
            r0.zzanj = r6
            if (r7 != r2) goto L_0x0222
            r4 = 1
            goto L_0x0223
        L_0x0222:
            r4 = 0
        L_0x0223:
            com.google.android.gms.internal.ads.zzpc.checkState(r4)
            r0.zzank = r6
        L_0x0228:
            int r1 = r1 + 1
            goto L_0x01be
        L_0x022b:
            int r1 = r4 + -1
            if (r1 == 0) goto L_0x0248
            short[] r2 = r0.zzani
            int r3 = r0.zzamy
            int r5 = r1 * r3
            int r4 = r4 - r1
            int r4 = r4 * r3
            java.lang.System.arraycopy(r2, r5, r2, r6, r4)
            int r2 = r0.zzann
            int r2 = r2 - r1
            r0.zzann = r2
            goto L_0x0248
        L_0x0241:
            r5 = 1
            int r2 = r2 / 2
            int r3 = r3 / 2
            goto L_0x017f
        L_0x0248:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjg.zzgi():void");
    }

    private final void zzy(int i) {
        int i2 = this.zzanm + i;
        int i3 = this.zzanf;
        if (i2 > i3) {
            this.zzanf = i3 + (i3 / 2) + i;
            this.zzang = Arrays.copyOf(this.zzang, this.zzanf * this.zzamy);
        }
    }

    private final void zzz(int i) {
        int i2 = this.zzanl + i;
        int i3 = this.zzand;
        if (i2 > i3) {
            this.zzand = i3 + (i3 / 2) + i;
            this.zzane = Arrays.copyOf(this.zzane, this.zzand * this.zzamy);
        }
    }

    public final void setSpeed(float f) {
        this.zzahy = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzamy;
        int i2 = remaining / i;
        zzz(i2);
        shortBuffer.get(this.zzane, this.zzanl * this.zzamy, ((i * i2) << 1) / 2);
        this.zzanl += i2;
        zzgi();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzamy, this.zzanm);
        shortBuffer.put(this.zzang, 0, this.zzamy * min);
        this.zzanm -= min;
        short[] sArr = this.zzang;
        int i = this.zzamy;
        System.arraycopy(sArr, min * i, sArr, 0, this.zzanm * i);
    }

    public final void zzc(float f) {
        this.zzahz = f;
    }

    public final void zzfl() {
        int i;
        int i2 = this.zzanl;
        float f = this.zzahy;
        float f2 = this.zzahz;
        int i3 = this.zzanm + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzann)) / f2) + 0.5f));
        zzz((this.zzanb * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzanb;
            int i5 = this.zzamy;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzane[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzanl += i * 2;
        zzgi();
        if (this.zzanm > i3) {
            this.zzanm = i3;
        }
        this.zzanl = 0;
        this.zzano = 0;
        this.zzann = 0;
    }

    public final int zzgh() {
        return this.zzanm;
    }
}

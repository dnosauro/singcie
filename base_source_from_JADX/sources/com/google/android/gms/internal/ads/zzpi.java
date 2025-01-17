package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class zzpi {
    public static final byte[] zzbjq = {0, 0, 0, 1};
    private static final float[] zzbju = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzbjv = new Object();
    private static int[] zzbjw = new int[10];

    public static boolean zza(String str, byte b) {
        return ("video/avc".equals(str) && (b & 31) == 6) || ("video/hevc".equals(str) && ((b & 126) >> 1) == 39);
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzbjv) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 < i - 2) {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = i;
                        break;
                    }
                }
                if (i3 < i) {
                    if (zzbjw.length <= i4) {
                        zzbjw = Arrays.copyOf(zzbjw, zzbjw.length << 1);
                    }
                    zzbjw[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = zzbjw[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzpl zzd(byte[] r18, int r19, int r20) {
        /*
            com.google.android.gms.internal.ads.zzpm r0 = new com.google.android.gms.internal.ads.zzpm
            r1 = r18
            r2 = r19
            r3 = r20
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.zzbi(r1)
            int r2 = r0.zzbh(r1)
            r3 = 16
            r0.zzbi(r3)
            int r5 = r0.zziw()
            r4 = 3
            r6 = 0
            r7 = 1
            r8 = 100
            if (r2 == r8) goto L_0x004c
            r8 = 110(0x6e, float:1.54E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 122(0x7a, float:1.71E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 244(0xf4, float:3.42E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 44
            if (r2 == r8) goto L_0x004c
            r8 = 83
            if (r2 == r8) goto L_0x004c
            r8 = 86
            if (r2 == r8) goto L_0x004c
            r8 = 118(0x76, float:1.65E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 128(0x80, float:1.794E-43)
            if (r2 == r8) goto L_0x004c
            r8 = 138(0x8a, float:1.93E-43)
            if (r2 != r8) goto L_0x0049
            goto L_0x004c
        L_0x0049:
            r2 = 1
            r9 = 0
            goto L_0x009c
        L_0x004c:
            int r2 = r0.zziw()
            if (r2 != r4) goto L_0x0057
            boolean r8 = r0.zziv()
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            r0.zziw()
            r0.zziw()
            r0.zzbi(r7)
            boolean r9 = r0.zziv()
            if (r9 == 0) goto L_0x009b
            if (r2 == r4) goto L_0x006c
            r9 = 8
            goto L_0x006e
        L_0x006c:
            r9 = 12
        L_0x006e:
            r10 = 0
        L_0x006f:
            if (r10 >= r9) goto L_0x009b
            boolean r11 = r0.zziv()
            if (r11 == 0) goto L_0x0098
            r11 = 6
            if (r10 >= r11) goto L_0x007d
            r11 = 16
            goto L_0x007f
        L_0x007d:
            r11 = 64
        L_0x007f:
            r12 = 0
            r13 = 8
            r14 = 8
        L_0x0084:
            if (r12 >= r11) goto L_0x0098
            if (r13 == 0) goto L_0x0091
            int r13 = r0.zzix()
            int r13 = r13 + r14
            int r13 = r13 + 256
            int r13 = r13 % 256
        L_0x0091:
            if (r13 != 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r14 = r13
        L_0x0095:
            int r12 = r12 + 1
            goto L_0x0084
        L_0x0098:
            int r10 = r10 + 1
            goto L_0x006f
        L_0x009b:
            r9 = r8
        L_0x009c:
            int r8 = r0.zziw()
            int r11 = r8 + 4
            int r12 = r0.zziw()
            if (r12 != 0) goto L_0x00b0
            int r8 = r0.zziw()
            int r8 = r8 + 4
            r13 = r8
            goto L_0x00d1
        L_0x00b0:
            if (r12 != r7) goto L_0x00d0
            boolean r8 = r0.zziv()
            r0.zzix()
            r0.zzix()
            int r10 = r0.zziw()
            long r13 = (long) r10
            r10 = 0
        L_0x00c2:
            long r3 = (long) r10
            int r15 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x00cd
            r0.zziw()
            int r10 = r10 + 1
            goto L_0x00c2
        L_0x00cd:
            r14 = r8
            r13 = 0
            goto L_0x00d2
        L_0x00d0:
            r13 = 0
        L_0x00d1:
            r14 = 0
        L_0x00d2:
            r0.zziw()
            r0.zzbi(r7)
            int r3 = r0.zziw()
            int r3 = r3 + r7
            int r4 = r0.zziw()
            int r4 = r4 + r7
            boolean r10 = r0.zziv()
            r6 = 2
            int r8 = 2 - r10
            int r8 = r8 * r4
            if (r10 != 0) goto L_0x00f0
            r0.zzbi(r7)
        L_0x00f0:
            r0.zzbi(r7)
            int r3 = r3 << 4
            int r4 = r8 << 4
            boolean r8 = r0.zziv()
            if (r8 == 0) goto L_0x0128
            int r8 = r0.zziw()
            int r15 = r0.zziw()
            int r16 = r0.zziw()
            int r17 = r0.zziw()
            if (r2 != 0) goto L_0x0112
            int r6 = r6 - r10
            r1 = 1
            goto L_0x011e
        L_0x0112:
            r1 = 3
            if (r2 != r1) goto L_0x0117
            r1 = 1
            goto L_0x0118
        L_0x0117:
            r1 = 2
        L_0x0118:
            if (r2 != r7) goto L_0x011b
            r7 = 2
        L_0x011b:
            int r6 = r6 - r10
            int r6 = r6 * r7
        L_0x011e:
            int r8 = r8 + r15
            int r8 = r8 * r1
            int r3 = r3 - r8
            int r16 = r16 + r17
            int r16 = r16 * r6
            int r4 = r4 - r16
        L_0x0128:
            r6 = r3
            r7 = r4
            r1 = 1065353216(0x3f800000, float:1.0)
            boolean r2 = r0.zziv()
            if (r2 == 0) goto L_0x0176
            boolean r2 = r0.zziv()
            if (r2 == 0) goto L_0x0176
            r2 = 8
            int r2 = r0.zzbh(r2)
            r3 = 255(0xff, float:3.57E-43)
            if (r2 != r3) goto L_0x0155
            r3 = 16
            int r2 = r0.zzbh(r3)
            int r0 = r0.zzbh(r3)
            if (r2 == 0) goto L_0x0153
            if (r0 == 0) goto L_0x0153
            float r1 = (float) r2
            float r0 = (float) r0
            float r1 = r1 / r0
        L_0x0153:
            r8 = r1
            goto L_0x0178
        L_0x0155:
            float[] r0 = zzbju
            int r3 = r0.length
            if (r2 >= r3) goto L_0x015e
            r0 = r0[r2]
            r8 = r0
            goto L_0x0178
        L_0x015e:
            java.lang.String r0 = "NalUnitUtil"
            r3 = 46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected aspect_ratio_idc value: "
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            android.util.Log.w(r0, r2)
        L_0x0176:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0178:
            com.google.android.gms.internal.ads.zzpl r0 = new com.google.android.gms.internal.ads.zzpl
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.zzd(byte[], int, int):com.google.android.gms.internal.ads.zzpl");
    }

    public static void zzp(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                byte b = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (b == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b == 0) {
                    i2++;
                }
                if (b != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }
}

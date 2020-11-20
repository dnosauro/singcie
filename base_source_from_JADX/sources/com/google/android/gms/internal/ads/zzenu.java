package com.google.android.gms.internal.ads;

final class zzenu extends zzenp {
    zzenu() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzeno.zzhv(i);
            case 1:
                return zzeno.zzaq(i, zzenl.zza(bArr, j));
            case 2:
                return zzeno.zzj(i, zzenl.zza(bArr, j), zzenl.zza(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (com.google.android.gms.internal.ads.zzenl.zza(r1, r8) > -65) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        if (com.google.android.gms.internal.ads.zzenl.zza(r1, r8) > -65) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0102, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0129, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r24, byte[] r25, int r26, int r27) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r2 | r3
            int r5 = r1.length
            int r5 = r5 - r3
            r4 = r4 | r5
            r7 = 0
            if (r4 < 0) goto L_0x015d
            long r8 = (long) r2
            long r2 = (long) r3
            r4 = -19
            r10 = -62
            r11 = -16
            r12 = 16
            r13 = -96
            r14 = -32
            r15 = -1
            r6 = -65
            r16 = 1
            if (r0 == 0) goto L_0x00ac
            int r18 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r18 < 0) goto L_0x002a
            return r0
        L_0x002a:
            byte r5 = (byte) r0
            if (r5 >= r14) goto L_0x0038
            if (r5 < r10) goto L_0x0037
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            if (r0 <= r6) goto L_0x00ae
        L_0x0037:
            return r15
        L_0x0038:
            if (r5 >= r11) goto L_0x0064
            int r0 = r0 >> 8
            int r0 = ~r0
            byte r0 = (byte) r0
            if (r0 != 0) goto L_0x0051
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x004f
            int r0 = com.google.android.gms.internal.ads.zzeno.zzaq(r5, r0)
            return r0
        L_0x004f:
            r8 = r19
        L_0x0051:
            if (r0 > r6) goto L_0x0063
            if (r5 != r14) goto L_0x0057
            if (r0 < r13) goto L_0x0063
        L_0x0057:
            if (r5 != r4) goto L_0x005b
            if (r0 >= r13) goto L_0x0063
        L_0x005b:
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            if (r0 <= r6) goto L_0x00ae
        L_0x0063:
            return r15
        L_0x0064:
            int r4 = r0 >> 8
            int r4 = ~r4
            byte r4 = (byte) r4
            if (r4 != 0) goto L_0x007d
            long r19 = r8 + r16
            byte r4 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            int r0 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0079
            int r0 = com.google.android.gms.internal.ads.zzeno.zzaq(r5, r4)
            return r0
        L_0x0079:
            r8 = r19
            r0 = 0
            goto L_0x007f
        L_0x007d:
            int r0 = r0 >> r12
            byte r0 = (byte) r0
        L_0x007f:
            if (r0 != 0) goto L_0x0092
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0090
            int r0 = com.google.android.gms.internal.ads.zzeno.zzj(r5, r4, r0)
            return r0
        L_0x0090:
            r8 = r19
        L_0x0092:
            if (r4 > r6) goto L_0x00ab
            int r5 = r5 << 28
            int r4 = r4 + 112
            int r5 = r5 + r4
            int r4 = r5 >> 30
            if (r4 != 0) goto L_0x00ab
            if (r0 > r6) goto L_0x00ab
            long r4 = r8 + r16
            byte r0 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            if (r0 <= r6) goto L_0x00a8
            goto L_0x00ab
        L_0x00a8:
            r19 = r4
            goto L_0x00ae
        L_0x00ab:
            return r15
        L_0x00ac:
            r19 = r8
        L_0x00ae:
            long r2 = r2 - r19
            int r0 = (int) r2
            if (r0 >= r12) goto L_0x00b5
            r2 = 0
            goto L_0x00c8
        L_0x00b5:
            r3 = r19
            r2 = 0
        L_0x00b8:
            if (r2 >= r0) goto L_0x00c7
            long r8 = r3 + r16
            byte r3 = com.google.android.gms.internal.ads.zzenl.zza(r1, r3)
            if (r3 >= 0) goto L_0x00c3
            goto L_0x00c8
        L_0x00c3:
            int r2 = r2 + 1
            r3 = r8
            goto L_0x00b8
        L_0x00c7:
            r2 = r0
        L_0x00c8:
            int r0 = r0 - r2
            long r2 = (long) r2
            long r19 = r19 + r2
        L_0x00cc:
            r2 = r19
            r4 = 0
        L_0x00cf:
            if (r0 <= 0) goto L_0x00e1
            long r4 = r2 + r16
            byte r2 = com.google.android.gms.internal.ads.zzenl.zza(r1, r2)
            if (r2 < 0) goto L_0x00e6
            int r0 = r0 + -1
            r21 = r4
            r4 = r2
            r2 = r21
            goto L_0x00cf
        L_0x00e1:
            r21 = r2
            r2 = r4
            r4 = r21
        L_0x00e6:
            if (r0 != 0) goto L_0x00e9
            return r7
        L_0x00e9:
            int r0 = r0 + -1
            if (r2 >= r14) goto L_0x0103
            if (r0 != 0) goto L_0x00f0
            return r2
        L_0x00f0:
            int r0 = r0 + -1
            if (r2 < r10) goto L_0x0102
            long r2 = r4 + r16
            byte r4 = com.google.android.gms.internal.ads.zzenl.zza(r1, r4)
            if (r4 <= r6) goto L_0x00fd
            goto L_0x0102
        L_0x00fd:
            r19 = r2
            r12 = -19
            goto L_0x00cc
        L_0x0102:
            return r15
        L_0x0103:
            if (r2 >= r11) goto L_0x012a
            r3 = 2
            if (r0 >= r3) goto L_0x010d
            int r0 = zza(r1, r2, r4, r0)
            return r0
        L_0x010d:
            int r0 = r0 + -2
            long r8 = r4 + r16
            byte r3 = com.google.android.gms.internal.ads.zzenl.zza(r1, r4)
            if (r3 > r6) goto L_0x0129
            if (r2 != r14) goto L_0x011b
            if (r3 < r13) goto L_0x0129
        L_0x011b:
            r12 = -19
            if (r2 != r12) goto L_0x0121
            if (r3 >= r13) goto L_0x0129
        L_0x0121:
            long r19 = r8 + r16
            byte r2 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            if (r2 <= r6) goto L_0x00cc
        L_0x0129:
            return r15
        L_0x012a:
            r3 = 3
            r12 = -19
            if (r0 >= r3) goto L_0x0134
            int r0 = zza(r1, r2, r4, r0)
            return r0
        L_0x0134:
            int r0 = r0 + -3
            long r8 = r4 + r16
            byte r3 = com.google.android.gms.internal.ads.zzenl.zza(r1, r4)
            if (r3 > r6) goto L_0x015c
            int r2 = r2 << 28
            int r3 = r3 + 112
            int r2 = r2 + r3
            int r2 = r2 >> 30
            if (r2 != 0) goto L_0x015c
            long r2 = r8 + r16
            byte r4 = com.google.android.gms.internal.ads.zzenl.zza(r1, r8)
            if (r4 > r6) goto L_0x015c
            long r4 = r2 + r16
            byte r2 = com.google.android.gms.internal.ads.zzenl.zza(r1, r2)
            if (r2 <= r6) goto L_0x0158
            goto L_0x015c
        L_0x0158:
            r19 = r4
            goto L_0x00cc
        L_0x015c:
            return r15
        L_0x015d:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r1 = r1.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r7] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
            r2 = 1
            r4[r2] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r27)
            r2 = 2
            r4[r2] = r1
            java.lang.String r1 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenu.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        int i3;
        long j2;
        char charAt;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        long j3 = (long) i4;
        long j4 = ((long) i5) + j3;
        int length = charSequence.length();
        if (length > i5 || bArr2.length - i5 < i4) {
            char charAt2 = charSequence2.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i4 + i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i6 = 0;
        while (i6 < length && (charAt = charSequence2.charAt(i6)) < 128) {
            zzenl.zza(bArr2, j, (byte) charAt);
            i6++;
            j3 = 1 + j;
        }
        if (i6 == length) {
            return (int) j;
        }
        while (i6 < length) {
            char charAt3 = charSequence2.charAt(i6);
            if (charAt3 < 128 && j < j4) {
                j2 = j + 1;
            } else if (charAt3 < 2048 && j <= j4 - 2) {
                long j5 = j + 1;
                zzenl.zza(bArr2, j, (byte) ((charAt3 >>> 6) | 960));
                j = j5 + 1;
                zzenl.zza(bArr2, j5, (byte) ((charAt3 & '?') | 128));
                i6++;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j <= j4 - 3) {
                long j6 = j + 1;
                zzenl.zza(bArr2, j, (byte) ((charAt3 >>> 12) | 480));
                j = j6 + 1;
                zzenl.zza(bArr2, j6, (byte) (((charAt3 >>> 6) & 63) | 128));
                j2 = j + 1;
                charAt3 = (charAt3 & '?') | 128;
            } else if (j <= j4 - 4) {
                int i7 = i6 + 1;
                if (i7 != length) {
                    char charAt4 = charSequence2.charAt(i7);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j7 = j + 1;
                        zzenl.zza(bArr2, j, (byte) ((codePoint >>> 18) | 240));
                        long j8 = j7 + 1;
                        zzenl.zza(bArr2, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j9 = j8 + 1;
                        zzenl.zza(bArr2, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = j9 + 1;
                        zzenl.zza(bArr2, j9, (byte) ((codePoint & 63) | 128));
                        i6 = i7;
                        i6++;
                    }
                } else {
                    i7 = i6;
                }
                throw new zzenr(i7 - 1, length);
            } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i6 + 1) != length && Character.isSurrogatePair(charAt3, charSequence2.charAt(i3)))) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzenr(i6, length);
            }
            zzenl.zza(bArr2, j, (byte) charAt3);
            j = j2;
            i6++;
        }
        return (int) j;
    }

    /* access modifiers changed from: package-private */
    public final String zzo(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte zza = zzenl.zza(bArr, (long) r13);
                if (!zzenq.zze(zza)) {
                    break;
                }
                i = r13 + 1;
                zzenq.zza(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (r13 < i3) {
                int i6 = r13 + 1;
                byte zza2 = zzenl.zza(bArr, (long) r13);
                if (zzenq.zze(zza2)) {
                    int i7 = i5 + 1;
                    zzenq.zza(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zzenl.zza(bArr, (long) i6);
                        if (!zzenq.zze(zza3)) {
                            break;
                        }
                        i6++;
                        zzenq.zza(zza3, cArr, i7);
                        i7++;
                    }
                    r13 = i6;
                    i5 = i7;
                } else if (zzenq.zzf(zza2)) {
                    if (i6 < i3) {
                        int i8 = i6 + 1;
                        zzenq.zza(zza2, zzenl.zza(bArr, (long) i6), cArr, i5);
                        r13 = i8;
                        i5++;
                    } else {
                        throw zzeks.zzbiq();
                    }
                } else if (zzenq.zzg(zza2)) {
                    if (i6 < i3 - 1) {
                        int i9 = i6 + 1;
                        int i10 = i9 + 1;
                        zzenq.zza(zza2, zzenl.zza(bArr, (long) i6), zzenl.zza(bArr, (long) i9), cArr, i5);
                        r13 = i10;
                        i5++;
                    } else {
                        throw zzeks.zzbiq();
                    }
                } else if (i6 < i3 - 2) {
                    int i11 = i6 + 1;
                    byte zza4 = zzenl.zza(bArr, (long) i6);
                    int i12 = i11 + 1;
                    zzenq.zza(zza2, zza4, zzenl.zza(bArr, (long) i11), zzenl.zza(bArr, (long) i12), cArr, i5);
                    r13 = i12 + 1;
                    i5 = i5 + 1 + 1;
                } else {
                    throw zzeks.zzbiq();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }
}

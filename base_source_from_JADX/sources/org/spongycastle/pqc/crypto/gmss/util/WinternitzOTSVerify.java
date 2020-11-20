package org.spongycastle.pqc.crypto.gmss.util;

import org.spongycastle.crypto.Digest;

public class WinternitzOTSVerify {
    private Digest messDigestOTS;

    /* renamed from: w */
    private int f8125w;

    public WinternitzOTSVerify(Digest digest, int i) {
        this.f8125w = i;
        this.messDigestOTS = digest;
    }

    public byte[] Verify(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr5 = new byte[digestSize];
        this.messDigestOTS.update(bArr3, 0, bArr3.length);
        byte[] bArr6 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr6, 0);
        int i2 = digestSize << 3;
        int i3 = this.f8125w;
        int i4 = ((i3 - 1) + i2) / i3;
        int log = getLog((i4 << i3) + 1);
        int i5 = this.f8125w;
        int i6 = ((((log + i5) - 1) / i5) + i4) * digestSize;
        if (i6 != bArr4.length) {
            return null;
        }
        byte[] bArr7 = new byte[i6];
        int i7 = 8;
        if (8 % i5 == 0) {
            int i8 = 8 / i5;
            int i9 = (1 << i5) - 1;
            byte[] bArr8 = new byte[digestSize];
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i10 < bArr6.length) {
                byte[] bArr9 = bArr8;
                int i13 = i12;
                int i14 = i11;
                int i15 = 0;
                while (i15 < i8) {
                    int i16 = bArr6[i10] & i9;
                    i14 += i16;
                    int i17 = i8;
                    int i18 = i13 * digestSize;
                    System.arraycopy(bArr4, i18, bArr9, 0, digestSize);
                    while (i16 < i9) {
                        this.messDigestOTS.update(bArr9, 0, bArr9.length);
                        bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr9, 0);
                        i16++;
                        i14 = i14;
                        byte[] bArr10 = bArr2;
                    }
                    int i19 = i14;
                    System.arraycopy(bArr9, 0, bArr7, i18, digestSize);
                    bArr6[i10] = (byte) (bArr6[i10] >>> this.f8125w);
                    i13++;
                    i15++;
                    i8 = i17;
                    bArr4 = bArr2;
                }
                int i20 = i8;
                i10++;
                i11 = i14;
                i12 = i13;
                bArr8 = bArr9;
                bArr4 = bArr2;
            }
            int i21 = (i4 << this.f8125w) - i11;
            int i22 = 0;
            while (i22 < log) {
                int i23 = i12 * digestSize;
                System.arraycopy(bArr2, i23, bArr8, 0, digestSize);
                for (int i24 = i21 & i9; i24 < i9; i24++) {
                    this.messDigestOTS.update(bArr8, 0, bArr8.length);
                    bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr8, 0);
                }
                System.arraycopy(bArr8, 0, bArr7, i23, digestSize);
                int i25 = this.f8125w;
                i21 >>>= i25;
                i12++;
                i22 += i25;
            }
        } else {
            byte[] bArr11 = bArr4;
            if (i5 < 8) {
                int i26 = digestSize / i5;
                int i27 = (1 << i5) - 1;
                byte[] bArr12 = new byte[digestSize];
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                while (i28 < i26) {
                    int i32 = i29;
                    long j = 0;
                    for (int i33 = 0; i33 < this.f8125w; i33++) {
                        j ^= (long) ((bArr6[i32] & 255) << (i33 << 3));
                        i32++;
                    }
                    byte[] bArr13 = bArr12;
                    int i34 = 0;
                    while (i34 < i7) {
                        int i35 = i28;
                        int i36 = (int) (j & ((long) i27));
                        i30 += i36;
                        int i37 = i31 * digestSize;
                        System.arraycopy(bArr11, i37, bArr13, 0, digestSize);
                        while (i36 < i27) {
                            this.messDigestOTS.update(bArr13, 0, bArr13.length);
                            bArr13 = new byte[this.messDigestOTS.getDigestSize()];
                            this.messDigestOTS.doFinal(bArr13, 0);
                            i36++;
                        }
                        System.arraycopy(bArr13, 0, bArr7, i37, digestSize);
                        j >>>= this.f8125w;
                        i31++;
                        i34++;
                        i28 = i35;
                        i7 = 8;
                    }
                    i28++;
                    bArr12 = bArr13;
                    i29 = i32;
                    i7 = 8;
                }
                int i38 = digestSize % this.f8125w;
                long j2 = 0;
                for (int i39 = 0; i39 < i38; i39++) {
                    j2 ^= (long) ((bArr6[i29] & 255) << (i39 << 3));
                    i29++;
                }
                int i40 = i38 << 3;
                byte[] bArr14 = bArr12;
                int i41 = 0;
                while (i41 < i40) {
                    int i42 = (int) (j2 & ((long) i27));
                    i30 += i42;
                    int i43 = i31 * digestSize;
                    System.arraycopy(bArr11, i43, bArr14, 0, digestSize);
                    while (i42 < i27) {
                        this.messDigestOTS.update(bArr14, 0, bArr14.length);
                        bArr14 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr14, 0);
                        i42++;
                    }
                    System.arraycopy(bArr14, 0, bArr7, i43, digestSize);
                    int i44 = this.f8125w;
                    j2 >>>= i44;
                    i31++;
                    i41 += i44;
                }
                int i45 = (i4 << this.f8125w) - i30;
                int i46 = 0;
                while (i46 < log) {
                    int i47 = i31 * digestSize;
                    System.arraycopy(bArr11, i47, bArr14, 0, digestSize);
                    for (int i48 = i45 & i27; i48 < i27; i48++) {
                        this.messDigestOTS.update(bArr14, 0, bArr14.length);
                        bArr14 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr14, 0);
                    }
                    System.arraycopy(bArr14, 0, bArr7, i47, digestSize);
                    int i49 = this.f8125w;
                    i45 >>>= i49;
                    i31++;
                    i46 += i49;
                }
            } else if (i5 < 57) {
                int i50 = i2 - i5;
                int i51 = (1 << i5) - 1;
                byte[] bArr15 = new byte[digestSize];
                int i52 = 0;
                int i53 = 0;
                int i54 = 0;
                while (i52 <= i50) {
                    int i55 = i52 >>> 3;
                    int i56 = i52 % 8;
                    int i57 = i52 + this.f8125w;
                    int i58 = (i57 + 7) >>> 3;
                    int i59 = 0;
                    long j3 = 0;
                    while (i55 < i58) {
                        j3 ^= (long) ((bArr6[i55] & 255) << (i59 << 3));
                        i59++;
                        i55++;
                        log = log;
                        i50 = i50;
                    }
                    int i60 = i50;
                    int i61 = log;
                    int i62 = i4;
                    long j4 = (long) i51;
                    long j5 = (j3 >>> i56) & j4;
                    int i63 = i51;
                    i53 = (int) (((long) i53) + j5);
                    int i64 = i54 * digestSize;
                    int i65 = i57;
                    System.arraycopy(bArr11, i64, bArr15, 0, digestSize);
                    while (j5 < j4) {
                        this.messDigestOTS.update(bArr15, 0, bArr15.length);
                        bArr15 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr15, 0);
                        j5++;
                        j4 = j4;
                    }
                    System.arraycopy(bArr15, 0, bArr7, i64, digestSize);
                    i54++;
                    i4 = i62;
                    i51 = i63;
                    i52 = i65;
                    log = i61;
                    i50 = i60;
                }
                int i66 = log;
                int i67 = i4;
                int i68 = i51;
                int i69 = i52 >>> 3;
                if (i69 < digestSize) {
                    int i70 = i52 % 8;
                    int i71 = 0;
                    long j6 = 0;
                    while (i69 < digestSize) {
                        j6 ^= (long) ((bArr6[i69] & 255) << (i71 << 3));
                        i71++;
                        i69++;
                    }
                    i = i68;
                    long j7 = (long) i;
                    long j8 = (j6 >>> i70) & j7;
                    i53 = (int) (((long) i53) + j8);
                    int i72 = i54 * digestSize;
                    System.arraycopy(bArr11, i72, bArr15, 0, digestSize);
                    while (j8 < j7) {
                        this.messDigestOTS.update(bArr15, 0, bArr15.length);
                        bArr15 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr15, 0);
                        j8++;
                        j7 = j7;
                    }
                    System.arraycopy(bArr15, 0, bArr7, i72, digestSize);
                    i54++;
                } else {
                    i = i68;
                }
                int i73 = (i67 << this.f8125w) - i53;
                int i74 = i66;
                int i75 = 0;
                while (i75 < i74) {
                    int i76 = i54 * digestSize;
                    System.arraycopy(bArr11, i76, bArr15, 0, digestSize);
                    byte[] bArr16 = bArr7;
                    for (long j9 = (long) (i73 & i); j9 < ((long) i); j9++) {
                        this.messDigestOTS.update(bArr15, 0, bArr15.length);
                        bArr15 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr15, 0);
                    }
                    byte[] bArr17 = bArr16;
                    System.arraycopy(bArr15, 0, bArr17, i76, digestSize);
                    int i77 = this.f8125w;
                    i73 >>>= i77;
                    i54++;
                    i75 += i77;
                    bArr7 = bArr17;
                }
            }
        }
        byte[] bArr18 = bArr7;
        byte[] bArr19 = new byte[digestSize];
        this.messDigestOTS.update(bArr18, 0, bArr18.length);
        byte[] bArr20 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr20, 0);
        return bArr20;
    }

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public int getSignatureLength() {
        int digestSize = this.messDigestOTS.getDigestSize();
        int i = this.f8125w;
        int i2 = ((digestSize << 3) + (i - 1)) / i;
        int log = getLog((i2 << i) + 1);
        int i3 = this.f8125w;
        return digestSize * (i2 + (((log + i3) - 1) / i3));
    }
}

package org.spongycastle.math.raw;

import java.math.BigInteger;
import org.spongycastle.util.Pack;

public abstract class Nat256 {

    /* renamed from: M */
    private static final long f8095M = 4294967295L;

    public static int add(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i2 + 0]) & 4294967295L) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i2 + 1]) & 4294967295L);
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i2 + 2]) & 4294967295L);
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i2 + 3]) & 4294967295L);
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i2 + 4]) & 4294967295L);
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i2 + 5]) & 4294967295L);
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & 4294967295L) + (((long) iArr2[i2 + 6]) & 4294967295L);
        iArr3[i3 + 6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[i + 7]) & 4294967295L) + (((long) iArr2[i2 + 7]) & 4294967295L);
        iArr3[i3 + 7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr3[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        int i4 = i3 + 0;
        long j = (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i2 + 0]) & 4294967295L) + (((long) iArr3[i4]) & 4294967295L) + 0;
        iArr3[i4] = (int) j;
        int i5 = i3 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i2 + 1]) & 4294967295L) + (((long) iArr3[i5]) & 4294967295L);
        iArr3[i5] = (int) j2;
        int i6 = i3 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i2 + 2]) & 4294967295L) + (((long) iArr3[i6]) & 4294967295L);
        iArr3[i6] = (int) j3;
        int i7 = i3 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i2 + 3]) & 4294967295L) + (((long) iArr3[i7]) & 4294967295L);
        iArr3[i7] = (int) j4;
        int i8 = i3 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i2 + 4]) & 4294967295L) + (((long) iArr3[i8]) & 4294967295L);
        iArr3[i8] = (int) j5;
        int i9 = i3 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i2 + 5]) & 4294967295L) + (((long) iArr3[i9]) & 4294967295L);
        iArr3[i9] = (int) j6;
        int i10 = i3 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & 4294967295L) + (((long) iArr2[i2 + 6]) & 4294967295L) + (((long) iArr3[i10]) & 4294967295L);
        iArr3[i10] = (int) j7;
        int i11 = i3 + 7;
        long j8 = (j7 >>> 32) + (((long) iArr[i + 7]) & 4294967295L) + (((long) iArr2[i2 + 7]) & 4294967295L) + (((long) iArr3[i11]) & 4294967295L);
        iArr3[i11] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L);
        iArr3[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & 4294967295L) + (((long) iArr2[7]) & 4294967295L) + (((long) iArr3[7]) & 4294967295L);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addTo(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = i2 + 0;
        long j = (((long) i3) & 4294967295L) + (((long) iArr[i + 0]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L);
        iArr2[i4] = (int) j;
        int i5 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & 4294967295L) + (((long) iArr2[i5]) & 4294967295L);
        iArr2[i5] = (int) j2;
        int i6 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & 4294967295L) + (((long) iArr2[i6]) & 4294967295L);
        iArr2[i6] = (int) j3;
        int i7 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L);
        iArr2[i7] = (int) j4;
        int i8 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & 4294967295L) + (((long) iArr2[i8]) & 4294967295L);
        iArr2[i8] = (int) j5;
        int i9 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & 4294967295L) + (((long) iArr2[i9]) & 4294967295L);
        iArr2[i9] = (int) j6;
        int i10 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & 4294967295L) + (((long) iArr2[i10]) & 4294967295L);
        iArr2[i10] = (int) j7;
        int i11 = i2 + 7;
        long j8 = (j7 >>> 32) + (((long) iArr[i + 7]) & 4294967295L) + (4294967295L & ((long) iArr2[i11]));
        iArr2[i11] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr2[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & 4294967295L) + (4294967295L & ((long) iArr2[7]));
        iArr2[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i + 0;
        int i4 = i2 + 0;
        long j = (((long) iArr[i3]) & 4294967295L) + (((long) iArr2[i4]) & 4294967295L) + 0;
        int i5 = (int) j;
        iArr[i3] = i5;
        iArr2[i4] = i5;
        int i6 = i + 1;
        int i7 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i6]) & 4294967295L) + (((long) iArr2[i7]) & 4294967295L);
        int i8 = (int) j2;
        iArr[i6] = i8;
        iArr2[i7] = i8;
        int i9 = i + 2;
        int i10 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i9]) & 4294967295L) + (((long) iArr2[i10]) & 4294967295L);
        int i11 = (int) j3;
        iArr[i9] = i11;
        iArr2[i10] = i11;
        int i12 = i + 3;
        int i13 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L);
        int i14 = (int) j4;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i + 4;
        int i16 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i15]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
        int i17 = (int) j5;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i + 5;
        int i19 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i18]) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L);
        int i20 = (int) j6;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        int i21 = i + 6;
        int i22 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i21]) & 4294967295L) + (((long) iArr2[i22]) & 4294967295L);
        int i23 = (int) j7;
        iArr[i21] = i23;
        iArr2[i22] = i23;
        int i24 = i + 7;
        int i25 = i2 + 7;
        long j8 = (j7 >>> 32) + (((long) iArr[i24]) & 4294967295L) + (4294967295L & ((long) iArr2[i25]));
        int i26 = (int) j8;
        iArr[i24] = i26;
        iArr2[i25] = i26;
        return (int) (j8 >>> 32);
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
        iArr2[7] = iArr[7];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static int[] create() {
        return new int[8];
    }

    public static long[] create64() {
        return new long[4];
    }

    public static int[] createExt() {
        return new int[16];
    }

    public static long[] createExt64() {
        return new long[8];
    }

    public static boolean diff(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean gte = gte(iArr, i, iArr2, i2);
        if (gte) {
            sub(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            sub(iArr2, i2, iArr, i, iArr3, i3);
        }
        return gte;
    }

    /* renamed from: eq */
    public static boolean m9231eq(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i = 3; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        int i = 0;
        while (bigInteger.signum() != 0) {
            create[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return create;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        long[] create64 = create64();
        int i = 0;
        while (bigInteger.signum() != 0) {
            create64[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        return create64;
    }

    public static int getBit(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else if ((i & 255) != i) {
            return 0;
        } else {
            i2 = iArr[i >>> 5] >>> (i & 31);
        }
        return i2 & 1;
    }

    public static boolean gte(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 7; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i = 0; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i = 0; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & 4294967295L;
        long j2 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 4]) & 4294967295L;
        long j6 = ((long) iArr2[i2 + 5]) & 4294967295L;
        long j7 = ((long) iArr2[i2 + 6]) & 4294967295L;
        long j8 = ((long) iArr2[i2 + 7]) & 4294967295L;
        long j9 = ((long) iArr[i + 0]) & 4294967295L;
        long j10 = (j9 * j) + 0;
        long j11 = j;
        iArr3[i3 + 0] = (int) j10;
        long j12 = (j10 >>> 32) + (j9 * j2);
        long j13 = j2;
        iArr3[i3 + 1] = (int) j12;
        long j14 = (j12 >>> 32) + (j9 * j3);
        iArr3[i3 + 2] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j4);
        iArr3[i3 + 3] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j5);
        iArr3[i3 + 4] = (int) j16;
        long j17 = (j16 >>> 32) + (j9 * j6);
        iArr3[i3 + 5] = (int) j17;
        long j18 = (j17 >>> 32) + (j9 * j7);
        iArr3[i3 + 6] = (int) j18;
        long j19 = (j18 >>> 32) + (j9 * j8);
        iArr3[i3 + 7] = (int) j19;
        iArr3[i3 + 8] = (int) (j19 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 8) {
            i5 += i4;
            long j20 = ((long) iArr[i + i6]) & 4294967295L;
            int i7 = i5 + 0;
            long j21 = (j20 * j11) + (((long) iArr3[i7]) & 4294967295L) + 0;
            iArr3[i7] = (int) j21;
            int i8 = i5 + 1;
            long j22 = j6;
            long j23 = (j21 >>> 32) + (j20 * j13) + (((long) iArr3[i8]) & 4294967295L);
            iArr3[i8] = (int) j23;
            int i9 = i5 + 2;
            long j24 = (j23 >>> 32) + (j20 * j3) + (((long) iArr3[i9]) & 4294967295L);
            iArr3[i9] = (int) j24;
            int i10 = i5 + 3;
            long j25 = (j24 >>> 32) + (j20 * j4) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j25;
            int i11 = i5 + 4;
            long j26 = (j25 >>> 32) + (j20 * j5) + (((long) iArr3[i11]) & 4294967295L);
            iArr3[i11] = (int) j26;
            int i12 = i5 + 5;
            long j27 = (j26 >>> 32) + (j20 * j22) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j27;
            int i13 = i5 + 6;
            long j28 = (j27 >>> 32) + (j20 * j7) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j28;
            int i14 = i5 + 7;
            long j29 = (j28 >>> 32) + (j20 * j8) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j29;
            iArr3[i5 + 8] = (int) (j29 >>> 32);
            i6++;
            j6 = j22;
            j3 = j3;
            i4 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[3]) & 4294967295L;
        long j4 = ((long) iArr2[4]) & 4294967295L;
        long j5 = ((long) iArr2[2]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[6]) & 4294967295L;
        long j8 = ((long) iArr2[7]) & 4294967295L;
        long j9 = ((long) iArr[0]) & 4294967295L;
        long j10 = (j9 * j) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (j9 * j2);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (j9 * j5);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (j9 * j3);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (j9 * j4);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j6);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j7);
        iArr3[6] = (int) j16;
        long j17 = (j16 >>> 32) + (j9 * j8);
        iArr3[7] = (int) j17;
        int i = (int) (j17 >>> 32);
        iArr3[8] = i;
        int i2 = 1;
        for (int i3 = 8; i2 < i3; i3 = 8) {
            long j18 = ((long) iArr[i2]) & 4294967295L;
            int i4 = i2 + 0;
            long j19 = (j18 * j) + (((long) iArr3[i4]) & 4294967295L) + 0;
            iArr3[i4] = (int) j19;
            int i5 = i2 + 1;
            int i6 = i5;
            long j20 = (j19 >>> 32) + (j18 * j2) + (((long) iArr3[i5]) & 4294967295L);
            iArr3[i6] = (int) j20;
            int i7 = i2 + 2;
            long j21 = (j20 >>> 32) + (j18 * j5) + (((long) iArr3[i7]) & 4294967295L);
            iArr3[i7] = (int) j21;
            int i8 = i2 + 3;
            long j22 = (j21 >>> 32) + (j18 * j3) + (((long) iArr3[i8]) & 4294967295L);
            iArr3[i8] = (int) j22;
            int i9 = i2 + 4;
            long j23 = (j22 >>> 32) + (j18 * j4) + (((long) iArr3[i9]) & 4294967295L);
            iArr3[i9] = (int) j23;
            int i10 = i2 + 5;
            long j24 = (j23 >>> 32) + (j18 * j6) + (((long) iArr3[i10]) & 4294967295L);
            iArr3[i10] = (int) j24;
            int i11 = i2 + 6;
            long j25 = (j24 >>> 32) + (j18 * j7) + (((long) iArr3[i11]) & 4294967295L);
            iArr3[i11] = (int) j25;
            int i12 = i2 + 7;
            long j26 = (j25 >>> 32) + (j18 * j8) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j26;
            iArr3[i2 + 8] = (int) (j26 >>> 32);
            j = j;
            i2 = i6;
        }
    }

    public static long mul33Add(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((long) iArr[i2 + 0]) & 4294967295L;
        long j3 = (j * j2) + (((long) iArr2[i3 + 0]) & 4294967295L) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = ((long) iArr[i2 + 1]) & 4294967295L;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (((long) iArr2[i3 + 1]) & 4294967295L);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = ((long) iArr[i2 + 2]) & 4294967295L;
        long j8 = j6 + (j * j7) + j4 + (((long) iArr2[i3 + 2]) & 4294967295L);
        iArr3[i4 + 2] = (int) j8;
        long j9 = ((long) iArr[i2 + 3]) & 4294967295L;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (((long) iArr2[i3 + 3]) & 4294967295L);
        iArr3[i4 + 3] = (int) j10;
        long j11 = ((long) iArr[i2 + 4]) & 4294967295L;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (((long) iArr2[i3 + 4]) & 4294967295L);
        iArr3[i4 + 4] = (int) j12;
        long j13 = ((long) iArr[i2 + 5]) & 4294967295L;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (((long) iArr2[i3 + 5]) & 4294967295L);
        iArr3[i4 + 5] = (int) j14;
        long j15 = ((long) iArr[i2 + 6]) & 4294967295L;
        long j16 = (j14 >>> 32) + (j * j15) + j13 + (((long) iArr2[i3 + 6]) & 4294967295L);
        iArr3[i4 + 6] = (int) j16;
        long j17 = ((long) iArr[i2 + 7]) & 4294967295L;
        long j18 = (j16 >>> 32) + (j * j17) + j15 + (4294967295L & ((long) iArr2[i3 + 7]));
        iArr3[i4 + 7] = (int) j18;
        return (j18 >>> 32) + j17;
    }

    public static int mul33DWordAdd(int i, long j, int[] iArr, int i2) {
        int[] iArr2 = iArr;
        int i3 = i2;
        long j2 = ((long) i) & 4294967295L;
        long j3 = j & 4294967295L;
        int i4 = i3 + 0;
        long j4 = (j2 * j3) + (((long) iArr2[i4]) & 4294967295L) + 0;
        iArr2[i4] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        int i5 = i3 + 1;
        long j7 = (j4 >>> 32) + j6 + (((long) iArr2[i5]) & 4294967295L);
        iArr2[i5] = (int) j7;
        int i6 = i3 + 2;
        long j8 = (j7 >>> 32) + j5 + (((long) iArr2[i6]) & 4294967295L);
        iArr2[i6] = (int) j8;
        int i7 = i3 + 3;
        long j9 = (j8 >>> 32) + (4294967295L & ((long) iArr2[i7]));
        iArr2[i7] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr2, i3, 4);
    }

    public static int mul33WordAdd(int i, int i2, int[] iArr, int i3) {
        long j = ((long) i2) & 4294967295L;
        int i4 = i3 + 0;
        long j2 = ((((long) i) & 4294967295L) * j) + (((long) iArr[i4]) & 4294967295L) + 0;
        iArr[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = (j2 >>> 32) + j + (((long) iArr[i5]) & 4294967295L);
        iArr[i5] = (int) j3;
        long j4 = j3 >>> 32;
        int i6 = i3 + 2;
        long j5 = j4 + (((long) iArr[i6]) & 4294967295L);
        iArr[i6] = (int) j5;
        if ((j5 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i3, 3);
    }

    public static int mulAddTo(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((long) iArr2[i2 + 0]) & 4294967295L;
        long j2 = ((long) iArr2[i2 + 1]) & 4294967295L;
        long j3 = ((long) iArr2[i2 + 2]) & 4294967295L;
        long j4 = ((long) iArr2[i2 + 3]) & 4294967295L;
        long j5 = ((long) iArr2[i2 + 4]) & 4294967295L;
        long j6 = ((long) iArr2[i2 + 5]) & 4294967295L;
        long j7 = ((long) iArr2[i2 + 6]) & 4294967295L;
        int i4 = i3;
        long j8 = ((long) iArr2[i2 + 7]) & 4294967295L;
        long j9 = 0;
        int i5 = 0;
        while (i5 < 8) {
            long j10 = ((long) iArr[i + i5]) & 4294967295L;
            int i6 = i4 + 0;
            long j11 = j;
            long j12 = (j10 * j) + (((long) iArr3[i6]) & 4294967295L) + 0;
            iArr3[i6] = (int) j12;
            int i7 = i4 + 1;
            long j13 = (j12 >>> 32) + (j10 * j2) + (((long) iArr3[i7]) & 4294967295L);
            iArr3[i7] = (int) j13;
            int i8 = i4 + 2;
            long j14 = j3;
            long j15 = (j13 >>> 32) + (j10 * j3) + (((long) iArr3[i8]) & 4294967295L);
            iArr3[i8] = (int) j15;
            int i9 = i4 + 3;
            int i10 = i4;
            long j16 = (j15 >>> 32) + (j10 * j4) + (((long) iArr3[i9]) & 4294967295L);
            iArr3[i9] = (int) j16;
            int i11 = i10 + 4;
            long j17 = (j16 >>> 32) + (j10 * j5) + (((long) iArr3[i11]) & 4294967295L);
            iArr3[i11] = (int) j17;
            int i12 = i10 + 5;
            long j18 = (j17 >>> 32) + (j10 * j6) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j18;
            int i13 = i10 + 6;
            long j19 = (j18 >>> 32) + (j10 * j7) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j19;
            int i14 = i10 + 7;
            long j20 = (j19 >>> 32) + (j10 * j8) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j20;
            int i15 = i10 + 8;
            long j21 = (j20 >>> 32) + j9 + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j21;
            j9 = j21 >>> 32;
            i5++;
            i4 = i7;
            j = j11;
            j2 = j2;
            j3 = j14;
        }
        return (int) j9;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 4294967295L;
        long j2 = ((long) iArr2[1]) & 4294967295L;
        long j3 = ((long) iArr2[2]) & 4294967295L;
        long j4 = ((long) iArr2[3]) & 4294967295L;
        long j5 = ((long) iArr2[4]) & 4294967295L;
        long j6 = ((long) iArr2[5]) & 4294967295L;
        long j7 = ((long) iArr2[0]) & 4294967295L;
        long j8 = ((long) iArr2[6]) & 4294967295L;
        long j9 = ((long) iArr2[7]) & 4294967295L;
        long j10 = 0;
        int i = 0;
        while (i < 8) {
            long j11 = j9;
            long j12 = ((long) iArr[i]) & j;
            int i2 = i + 0;
            long j13 = j6;
            long j14 = (j12 * j7) + (((long) iArr3[i2]) & j) + 0;
            iArr3[i2] = (int) j14;
            int i3 = i + 1;
            long j15 = j2;
            long j16 = (j14 >>> 32) + (j12 * j2) + (((long) iArr3[i3]) & j);
            iArr3[i3] = (int) j16;
            int i4 = i + 2;
            long j17 = (j16 >>> 32) + (j12 * j3) + (((long) iArr3[i4]) & j);
            iArr3[i4] = (int) j17;
            int i5 = i + 3;
            long j18 = (j17 >>> 32) + (j12 * j4) + (((long) iArr3[i5]) & j);
            iArr3[i5] = (int) j18;
            int i6 = i + 4;
            long j19 = (j18 >>> 32) + (j12 * j5) + (((long) iArr3[i6]) & j);
            iArr3[i6] = (int) j19;
            int i7 = i + 5;
            long j20 = (j19 >>> 32) + (j12 * j13) + (((long) iArr3[i7]) & j);
            iArr3[i7] = (int) j20;
            int i8 = i + 6;
            long j21 = (j20 >>> 32) + (j12 * j8) + (((long) iArr3[i8]) & j);
            iArr3[i8] = (int) j21;
            int i9 = i + 7;
            long j22 = (j21 >>> 32) + (j12 * j11) + (((long) iArr3[i9]) & j);
            iArr3[i9] = (int) j22;
            int i10 = i + 8;
            long j23 = (j22 >>> 32) + j10 + (((long) iArr3[i10]) & j);
            iArr3[i10] = (int) j23;
            j10 = j23 >>> 32;
            i = i3;
            j9 = j11;
            j6 = j13;
            j2 = j15;
            j = 4294967295L;
        }
        return (int) j10;
    }

    public static int mulByWord(int i, int[] iArr) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((((long) iArr[0]) & 4294967295L) * j) + 0;
        iArr[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr[1]) & 4294967295L) * j);
        iArr[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr[2]) & 4294967295L) * j);
        iArr[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr[3]) & 4294967295L) * j);
        iArr[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr[4]) & 4294967295L) * j);
        iArr[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr[5]) & 4294967295L) * j);
        iArr[5] = (int) j7;
        long j8 = (j7 >>> 32) + ((((long) iArr[6]) & 4294967295L) * j);
        iArr[6] = (int) j8;
        long j9 = (j8 >>> 32) + (j * (4294967295L & ((long) iArr[7])));
        iArr[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mulByWordAddTo(int i, int[] iArr, int[] iArr2) {
        long j = ((long) i) & 4294967295L;
        long j2 = ((((long) iArr2[0]) & 4294967295L) * j) + (((long) iArr[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr2[1]) & 4294967295L) * j) + (((long) iArr[1]) & 4294967295L);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr2[2]) & 4294967295L) * j) + (((long) iArr[2]) & 4294967295L);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr2[3]) & 4294967295L) * j) + (((long) iArr[3]) & 4294967295L);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr2[4]) & 4294967295L) * j) + (((long) iArr[4]) & 4294967295L);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr2[5]) & 4294967295L) * j) + (((long) iArr[5]) & 4294967295L);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + ((((long) iArr2[6]) & 4294967295L) * j) + (((long) iArr[6]) & 4294967295L);
        iArr2[6] = (int) j8;
        long j9 = (j8 >>> 32) + (j * (((long) iArr2[7]) & 4294967295L)) + (4294967295L & ((long) iArr[7]));
        iArr2[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mulWord(int i, int[] iArr, int[] iArr2, int i2) {
        long j = ((long) i) & 4294967295L;
        long j2 = 0;
        int i3 = 0;
        do {
            long j3 = j2 + ((((long) iArr[i3]) & 4294967295L) * j);
            iArr2[i2 + i3] = (int) j3;
            j2 = j3 >>> 32;
            i3++;
        } while (i3 < 8);
        return (int) j2;
    }

    public static int mulWordAddTo(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        long j = ((long) i) & 4294967295L;
        int i4 = i3 + 0;
        long j2 = ((((long) iArr[i2 + 0]) & 4294967295L) * j) + (((long) iArr2[i4]) & 4294967295L) + 0;
        iArr2[i4] = (int) j2;
        int i5 = i3 + 1;
        long j3 = (j2 >>> 32) + ((((long) iArr[i2 + 1]) & 4294967295L) * j) + (((long) iArr2[i5]) & 4294967295L);
        iArr2[i5] = (int) j3;
        int i6 = i3 + 2;
        long j4 = (j3 >>> 32) + ((((long) iArr[i2 + 2]) & 4294967295L) * j) + (((long) iArr2[i6]) & 4294967295L);
        iArr2[i6] = (int) j4;
        int i7 = i3 + 3;
        long j5 = (j4 >>> 32) + ((((long) iArr[i2 + 3]) & 4294967295L) * j) + (((long) iArr2[i7]) & 4294967295L);
        iArr2[i7] = (int) j5;
        int i8 = i3 + 4;
        long j6 = (j5 >>> 32) + ((((long) iArr[i2 + 4]) & 4294967295L) * j) + (((long) iArr2[i8]) & 4294967295L);
        iArr2[i8] = (int) j6;
        int i9 = i3 + 5;
        long j7 = (j6 >>> 32) + ((((long) iArr[i2 + 5]) & 4294967295L) * j) + (((long) iArr2[i9]) & 4294967295L);
        iArr2[i9] = (int) j7;
        int i10 = i3 + 6;
        long j8 = (j7 >>> 32) + ((((long) iArr[i2 + 6]) & 4294967295L) * j) + (((long) iArr2[i10]) & 4294967295L);
        iArr2[i10] = (int) j8;
        int i11 = i3 + 7;
        long j9 = (j8 >>> 32) + (j * (((long) iArr[i2 + 7]) & 4294967295L)) + (((long) iArr2[i11]) & 4294967295L);
        iArr2[i11] = (int) j9;
        return (int) (j9 >>> 32);
    }

    public static int mulWordDwordAdd(int i, long j, int[] iArr, int i2) {
        long j2 = ((long) i) & 4294967295L;
        int i3 = i2 + 0;
        long j3 = ((j & 4294967295L) * j2) + (((long) iArr[i3]) & 4294967295L) + 0;
        iArr[i3] = (int) j3;
        long j4 = j2 * (j >>> 32);
        int i4 = i2 + 1;
        long j5 = (j3 >>> 32) + j4 + (((long) iArr[i4]) & 4294967295L);
        iArr[i4] = (int) j5;
        int i5 = i2 + 2;
        long j6 = (j5 >>> 32) + (((long) iArr[i5]) & 4294967295L);
        iArr[i5] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(8, iArr, i2, 3);
    }

    public static void square(int[] iArr, int i, int[] iArr2, int i2) {
        long j = ((long) iArr[i + 0]) & 4294967295L;
        int i3 = 16;
        int i4 = 7;
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            long j2 = ((long) iArr[i + i4]) & 4294967295L;
            long j3 = j2 * j2;
            int i7 = i3 - 1;
            iArr2[i2 + i7] = (i5 << 31) | ((int) (j3 >>> 33));
            i3 = i7 - 1;
            iArr2[i2 + i3] = (int) (j3 >>> 1);
            int i8 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                iArr2[i2 + 0] = (int) j4;
                long j5 = ((long) iArr[i + 1]) & 4294967295L;
                int i9 = i2 + 2;
                long j6 = ((((long) (i8 << 31)) & 4294967295L) | (j4 >>> 33)) + (j5 * j);
                int i10 = (int) j6;
                iArr2[i2 + 1] = (i10 << 1) | (((int) (j4 >>> 32)) & 1);
                int i11 = i10 >>> 31;
                long j7 = (((long) iArr2[i9]) & 4294967295L) + (j6 >>> 32);
                long j8 = ((long) iArr[i + 2]) & 4294967295L;
                int i12 = i2 + 3;
                long j9 = j5;
                int i13 = i2 + 4;
                long j10 = ((long) iArr2[i12]) & 4294967295L;
                long j11 = j7 + (j8 * j);
                int i14 = (int) j11;
                iArr2[i9] = (i14 << 1) | i11;
                int i15 = i14 >>> 31;
                long j12 = j10 + (j11 >>> 32) + (j8 * j9);
                long j13 = (((long) iArr2[i13]) & 4294967295L) + (j12 >>> 32);
                long j14 = j8;
                long j15 = ((long) iArr[i + 3]) & 4294967295L;
                int i16 = i2 + 5;
                long j16 = (((long) iArr2[i16]) & 4294967295L) + (j13 >>> 32);
                int i17 = i2 + 6;
                int i18 = i16;
                long j17 = (((long) iArr2[i17]) & 4294967295L) + (j16 >>> 32);
                long j18 = (j12 & 4294967295L) + (j15 * j);
                int i19 = (int) j18;
                iArr2[i12] = (i19 << 1) | i15;
                long j19 = (j13 & 4294967295L) + (j18 >>> 32) + (j15 * j9);
                long j20 = (j16 & 4294967295L) + (j19 >>> 32) + (j15 * j14);
                long j21 = j17 + (j20 >>> 32);
                long j22 = j20 & 4294967295L;
                long j23 = ((long) iArr[i + 4]) & 4294967295L;
                int i20 = i2 + 7;
                long j24 = j15;
                long j25 = (((long) iArr2[i20]) & 4294967295L) + (j21 >>> 32);
                int i21 = i2 + 8;
                int i22 = i20;
                long j26 = j21 & 4294967295L;
                long j27 = (((long) iArr2[i21]) & 4294967295L) + (j25 >>> 32);
                long j28 = (j19 & 4294967295L) + (j23 * j);
                int i23 = (int) j28;
                iArr2[i13] = (i19 >>> 31) | (i23 << 1);
                int i24 = i23 >>> 31;
                long j29 = j22 + (j28 >>> 32) + (j23 * j9);
                long j30 = j26 + (j29 >>> 32) + (j23 * j14);
                long j31 = (j25 & 4294967295L) + (j30 >>> 32) + (j23 * j24);
                long j32 = j27 + (j31 >>> 32);
                long j33 = j23;
                long j34 = ((long) iArr[i + 5]) & 4294967295L;
                int i25 = i2 + 9;
                long j35 = j31 & 4294967295L;
                long j36 = (((long) iArr2[i25]) & 4294967295L) + (j32 >>> 32);
                int i26 = i2 + 10;
                int i27 = i25;
                long j37 = (j29 & 4294967295L) + (j34 * j);
                int i28 = (int) j37;
                iArr2[i18] = i24 | (i28 << 1);
                int i29 = i28 >>> 31;
                long j38 = (j30 & 4294967295L) + (j37 >>> 32) + (j34 * j9);
                long j39 = j35 + (j38 >>> 32) + (j34 * j14);
                long j40 = (j32 & 4294967295L) + (j39 >>> 32) + (j34 * j24);
                long j41 = (j36 & 4294967295L) + (j40 >>> 32) + (j34 * j33);
                long j42 = j40 & 4294967295L;
                long j43 = (((long) iArr2[i26]) & 4294967295L) + (j36 >>> 32) + (j41 >>> 32);
                long j44 = j34;
                long j45 = ((long) iArr[i + 6]) & 4294967295L;
                int i30 = i2 + 11;
                long j46 = j41 & 4294967295L;
                long j47 = (((long) iArr2[i30]) & 4294967295L) + (j43 >>> 32);
                int i31 = i2 + 12;
                int i32 = i30;
                long j48 = j43 & 4294967295L;
                long j49 = (((long) iArr2[i31]) & 4294967295L) + (j47 >>> 32);
                long j50 = (j38 & 4294967295L) + (j45 * j);
                int i33 = (int) j50;
                iArr2[i17] = i29 | (i33 << 1);
                int i34 = i33 >>> 31;
                long j51 = (j39 & 4294967295L) + (j50 >>> 32) + (j45 * j9);
                long j52 = j42 + (j51 >>> 32) + (j45 * j14);
                long j53 = j46 + (j52 >>> 32) + (j45 * j24);
                long j54 = j52 & 4294967295L;
                long j55 = j48 + (j53 >>> 32) + (j45 * j33);
                long j56 = (j47 & 4294967295L) + (j55 >>> 32) + (j45 * j44);
                long j57 = j49 + (j56 >>> 32);
                long j58 = ((long) iArr[i + 7]) & 4294967295L;
                int i35 = i2 + 13;
                long j59 = j56 & 4294967295L;
                long j60 = (((long) iArr2[i35]) & 4294967295L) + (j57 >>> 32);
                int i36 = i2 + 14;
                long j61 = (j51 & 4294967295L) + (j * j58);
                int i37 = (int) j61;
                iArr2[i22] = (i37 << 1) | i34;
                long j62 = j54 + (j61 >>> 32) + (j58 * j9);
                long j63 = (j53 & 4294967295L) + (j62 >>> 32) + (j58 * j14);
                long j64 = (j55 & 4294967295L) + (j63 >>> 32) + (j58 * j24);
                long j65 = j59 + (j64 >>> 32) + (j58 * j33);
                long j66 = j65;
                long j67 = (j57 & 4294967295L) + (j65 >>> 32) + (j58 * j44);
                long j68 = (j60 & 4294967295L) + (j67 >>> 32) + (j58 * j45);
                long j69 = (((long) iArr2[i36]) & 4294967295L) + (j60 >>> 32) + (j68 >>> 32);
                int i38 = (int) j62;
                iArr2[i21] = (i37 >>> 31) | (i38 << 1);
                int i39 = (int) j63;
                iArr2[i27] = (i38 >>> 31) | (i39 << 1);
                int i40 = i39 >>> 31;
                int i41 = (int) j64;
                iArr2[i26] = i40 | (i41 << 1);
                int i42 = (int) j66;
                iArr2[i32] = (i41 >>> 31) | (i42 << 1);
                int i43 = (int) j67;
                iArr2[i31] = (i42 >>> 31) | (i43 << 1);
                int i44 = i43 >>> 31;
                int i45 = (int) j68;
                iArr2[i35] = i44 | (i45 << 1);
                int i46 = i45 >>> 31;
                int i47 = (int) j69;
                iArr2[i36] = i46 | (i47 << 1);
                int i48 = i47 >>> 31;
                int i49 = i2 + 15;
                iArr2[i49] = i48 | ((iArr2[i49] + ((int) (j69 >>> 32))) << 1);
                return;
            }
            i5 = i8;
            i4 = i6;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & 4294967295L;
        int i = 7;
        int i2 = 16;
        int i3 = 0;
        while (true) {
            int i4 = i - 1;
            long j2 = ((long) iArr[i]) & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i2 - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i2 = i5 - 1;
            iArr2[i2] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                iArr2[0] = (int) j4;
                long j5 = ((long) iArr[1]) & 4294967295L;
                long j6 = ((j4 >>> 33) | (((long) (i6 << 31)) & 4294967295L)) + (j5 * j);
                int i7 = (int) j6;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j7 = (((long) iArr2[2]) & 4294967295L) + (j6 >>> 32);
                long j8 = ((long) iArr[2]) & 4294967295L;
                long j9 = j7 + (j8 * j);
                int i8 = (int) j9;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j10 = (((long) iArr2[3]) & 4294967295L) + (j9 >>> 32) + (j8 * j5);
                long j11 = (((long) iArr2[4]) & 4294967295L) + (j10 >>> 32);
                long j12 = j;
                long j13 = ((long) iArr[3]) & 4294967295L;
                long j14 = j8;
                long j15 = (((long) iArr2[5]) & 4294967295L) + (j11 >>> 32);
                long j16 = j5;
                long j17 = (j10 & 4294967295L) + (j13 * j12);
                int i9 = (int) j17;
                iArr2[3] = (i8 >>> 31) | (i9 << 1);
                int i10 = i9 >>> 31;
                long j18 = (j11 & 4294967295L) + (j17 >>> 32) + (j13 * j16);
                long j19 = (j15 & 4294967295L) + (j18 >>> 32) + (j13 * j14);
                long j20 = (((long) iArr2[6]) & 4294967295L) + (j15 >>> 32) + (j19 >>> 32);
                long j21 = ((long) iArr[4]) & 4294967295L;
                long j22 = (((long) iArr2[7]) & 4294967295L) + (j20 >>> 32);
                long j23 = j13;
                long j24 = (((long) iArr2[8]) & 4294967295L) + (j22 >>> 32);
                long j25 = (j18 & 4294967295L) + (j21 * j12);
                int i11 = (int) j25;
                iArr2[4] = i10 | (i11 << 1);
                int i12 = i11 >>> 31;
                long j26 = (j19 & 4294967295L) + (j25 >>> 32) + (j21 * j16);
                long j27 = (j20 & 4294967295L) + (j26 >>> 32) + (j21 * j14);
                long j28 = (j22 & 4294967295L) + (j27 >>> 32) + (j21 * j23);
                long j29 = j27 & 4294967295L;
                long j30 = j24 + (j28 >>> 32);
                long j31 = ((long) iArr[5]) & 4294967295L;
                long j32 = (((long) iArr2[9]) & 4294967295L) + (j30 >>> 32);
                long j33 = j21;
                long j34 = (j26 & 4294967295L) + (j31 * j12);
                int i13 = (int) j34;
                iArr2[5] = i12 | (i13 << 1);
                int i14 = i13 >>> 31;
                long j35 = j29 + (j34 >>> 32) + (j31 * j16);
                long j36 = (j28 & 4294967295L) + (j35 >>> 32) + (j31 * j14);
                long j37 = (j30 & 4294967295L) + (j36 >>> 32) + (j31 * j23);
                long j38 = (j32 & 4294967295L) + (j37 >>> 32) + (j31 * j33);
                long j39 = (((long) iArr2[10]) & 4294967295L) + (j32 >>> 32) + (j38 >>> 32);
                long j40 = j38 & 4294967295L;
                long j41 = j35 & 4294967295L;
                long j42 = ((long) iArr[6]) & 4294967295L;
                long j43 = (((long) iArr2[11]) & 4294967295L) + (j39 >>> 32);
                long j44 = j31;
                long j45 = (((long) iArr2[12]) & 4294967295L) + (j43 >>> 32);
                long j46 = j41 + (j42 * j12);
                int i15 = (int) j46;
                iArr2[6] = (i15 << 1) | i14;
                long j47 = (j36 & 4294967295L) + (j46 >>> 32) + (j42 * j16);
                long j48 = (j37 & 4294967295L) + (j47 >>> 32) + (j42 * j14);
                long j49 = j40 + (j48 >>> 32) + (j42 * j23);
                long j50 = (j39 & 4294967295L) + (j49 >>> 32) + (j42 * j33);
                long j51 = j49 & 4294967295L;
                long j52 = (j43 & 4294967295L) + (j50 >>> 32) + (j42 * j44);
                long j53 = j45 + (j52 >>> 32);
                long j54 = j42;
                long j55 = ((long) iArr[7]) & 4294967295L;
                long j56 = j52 & 4294967295L;
                long j57 = (((long) iArr2[13]) & 4294967295L) + (j53 >>> 32);
                long j58 = (j47 & 4294967295L) + (j55 * j12);
                int i16 = (int) j58;
                iArr2[7] = (i16 << 1) | (i15 >>> 31);
                long j59 = (j48 & 4294967295L) + (j58 >>> 32) + (j55 * j16);
                long j60 = j51 + (j59 >>> 32) + (j55 * j14);
                long j61 = (j50 & 4294967295L) + (j60 >>> 32) + (j55 * j23);
                long j62 = j56 + (j61 >>> 32) + (j55 * j33);
                long j63 = j62;
                long j64 = (j53 & 4294967295L) + (j62 >>> 32) + (j55 * j44);
                long j65 = (j57 & 4294967295L) + (j64 >>> 32) + (j55 * j54);
                long j66 = (((long) iArr2[14]) & 4294967295L) + (j57 >>> 32) + (j65 >>> 32);
                int i17 = (int) j59;
                iArr2[8] = (i17 << 1) | (i16 >>> 31);
                int i18 = i17 >>> 31;
                int i19 = (int) j60;
                iArr2[9] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j61;
                iArr2[10] = i20 | (i21 << 1);
                int i22 = i21 >>> 31;
                int i23 = (int) j63;
                iArr2[11] = i22 | (i23 << 1);
                int i24 = i23 >>> 31;
                int i25 = (int) j64;
                iArr2[12] = i24 | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) j65;
                iArr2[13] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) j66;
                iArr2[14] = i28 | (i29 << 1);
                iArr2[15] = (i29 >>> 31) | ((iArr2[15] + ((int) (j66 >>> 32))) << 1);
                return;
            }
            i = i4;
            i3 = i6;
        }
    }

    public static int sub(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i + 0]) & 4294967295L) - (((long) iArr2[i2 + 0]) & 4294967295L)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & 4294967295L) - (((long) iArr2[i2 + 1]) & 4294967295L));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & 4294967295L) - (((long) iArr2[i2 + 2]) & 4294967295L));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & 4294967295L) - (((long) iArr2[i2 + 3]) & 4294967295L));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[i + 4]) & 4294967295L) - (((long) iArr2[i2 + 4]) & 4294967295L));
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[i + 5]) & 4294967295L) - (((long) iArr2[i2 + 5]) & 4294967295L));
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[i + 6]) & 4294967295L) - (((long) iArr2[i2 + 6]) & 4294967295L));
        iArr3[i3 + 6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr[i + 7]) & 4294967295L) - (((long) iArr2[i2 + 7]) & 4294967295L));
        iArr3[i3 + 7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr[7]) & 4294967295L) - (((long) iArr2[7]) & 4294967295L));
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((((long) iArr3[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + (((((long) iArr3[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + (((((long) iArr3[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + (((((long) iArr3[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + (((((long) iArr3[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + (((((long) iArr3[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + (((((long) iArr3[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j7;
        long j8 = (j7 >> 32) + (((((long) iArr3[7]) & 4294967295L) - (((long) iArr[7]) & 4294967295L)) - (((long) iArr2[7]) & 4294967295L));
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int subFrom(int[] iArr, int i, int[] iArr2, int i2) {
        int i3 = i2 + 0;
        long j = ((((long) iArr2[i3]) & 4294967295L) - (((long) iArr[i + 0]) & 4294967295L)) + 0;
        iArr2[i3] = (int) j;
        int i4 = i2 + 1;
        long j2 = (j >> 32) + ((((long) iArr2[i4]) & 4294967295L) - (((long) iArr[i + 1]) & 4294967295L));
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = (j2 >> 32) + ((((long) iArr2[i5]) & 4294967295L) - (((long) iArr[i + 2]) & 4294967295L));
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = (j3 >> 32) + ((((long) iArr2[i6]) & 4294967295L) - (((long) iArr[i + 3]) & 4294967295L));
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = (j4 >> 32) + ((((long) iArr2[i7]) & 4294967295L) - (((long) iArr[i + 4]) & 4294967295L));
        iArr2[i7] = (int) j5;
        int i8 = i2 + 5;
        long j6 = (j5 >> 32) + ((((long) iArr2[i8]) & 4294967295L) - (((long) iArr[i + 5]) & 4294967295L));
        iArr2[i8] = (int) j6;
        int i9 = i2 + 6;
        long j7 = (j6 >> 32) + ((((long) iArr2[i9]) & 4294967295L) - (((long) iArr[i + 6]) & 4294967295L));
        iArr2[i9] = (int) j7;
        int i10 = i2 + 7;
        long j8 = (j7 >> 32) + ((((long) iArr2[i10]) & 4294967295L) - (((long) iArr[i + 7]) & 4294967295L));
        iArr2[i10] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr2[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L));
        iArr2[6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr2[7]) & 4294967295L) - (4294967295L & ((long) iArr[7])));
        iArr2[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 8; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                Pack.intToBigEndian(i2, bArr, (7 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 4; i++) {
            long j = jArr[i];
            if (j != 0) {
                Pack.longToBigEndian(j, bArr, (3 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
    }
}

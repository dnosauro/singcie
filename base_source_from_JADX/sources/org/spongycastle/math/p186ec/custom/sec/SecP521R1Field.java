package org.spongycastle.math.p186ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat512;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP521R1Field */
public class SecP521R1Field {

    /* renamed from: P */
    static final int[] f8073P = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, P16};
    private static final int P16 = 511;

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        int add = Nat.add(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (add > P16 || (add == P16 && Nat.m9226eq(16, iArr3, f8073P))) {
            add = (add + Nat.inc(16, iArr3)) & P16;
        }
        iArr3[16] = add;
    }

    public static void addOne(int[] iArr, int[] iArr2) {
        int inc = Nat.inc(16, iArr, iArr2) + iArr[16];
        if (inc > P16 || (inc == P16 && Nat.m9226eq(16, iArr2, f8073P))) {
            inc = (inc + Nat.inc(16, iArr2)) & P16;
        }
        iArr2[16] = inc;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        int[] fromBigInteger = Nat.fromBigInteger(521, bigInteger);
        if (Nat.m9226eq(17, fromBigInteger, f8073P)) {
            Nat.zero(17, fromBigInteger);
        }
        return fromBigInteger;
    }

    public static void half(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (Nat.shiftDownBit(16, iArr, i, iArr2) >>> 23) | (i >>> 1);
    }

    protected static void implMultiply(int[] iArr, int[] iArr2, int[] iArr3) {
        Nat512.mul(iArr, iArr2, iArr3);
        int i = iArr[16];
        int i2 = iArr2[16];
        iArr3[32] = Nat.mul31BothAdd(16, i, iArr2, i2, iArr, iArr3, 16) + (i * i2);
    }

    protected static void implSquare(int[] iArr, int[] iArr2) {
        Nat512.square(iArr, iArr2);
        int i = iArr[16];
        iArr2[32] = Nat.mulWordAddTo(16, i << 1, iArr, 0, iArr2, 16) + (i * i);
    }

    public static void multiply(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = Nat.create(33);
        implMultiply(iArr, iArr2, create);
        reduce(create, iArr3);
    }

    public static void negate(int[] iArr, int[] iArr2) {
        if (Nat.isZero(17, iArr)) {
            Nat.zero(17, iArr2);
        } else {
            Nat.sub(17, f8073P, iArr, iArr2);
        }
    }

    public static void reduce(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int shiftDownBits = (Nat.shiftDownBits(16, iArr, 16, 9, i, iArr2, 0) >>> 23) + (i >>> 9) + Nat.addTo(16, iArr, iArr2);
        if (shiftDownBits > P16 || (shiftDownBits == P16 && Nat.m9226eq(16, iArr2, f8073P))) {
            shiftDownBits = (shiftDownBits + Nat.inc(16, iArr2)) & P16;
        }
        iArr2[16] = shiftDownBits;
    }

    public static void reduce23(int[] iArr) {
        int i = iArr[16];
        int addWordTo = Nat.addWordTo(16, i >>> 9, iArr) + (i & P16);
        if (addWordTo > P16 || (addWordTo == P16 && Nat.m9226eq(16, iArr, f8073P))) {
            addWordTo = (addWordTo + Nat.inc(16, iArr)) & P16;
        }
        iArr[16] = addWordTo;
    }

    public static void square(int[] iArr, int[] iArr2) {
        int[] create = Nat.create(33);
        implSquare(iArr, create);
        reduce(create, iArr2);
    }

    public static void squareN(int[] iArr, int i, int[] iArr2) {
        int[] create = Nat.create(33);
        implSquare(iArr, create);
        while (true) {
            reduce(create, iArr2);
            i--;
            if (i > 0) {
                implSquare(iArr2, create);
            } else {
                return;
            }
        }
    }

    public static void subtract(int[] iArr, int[] iArr2, int[] iArr3) {
        int sub = (Nat.sub(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (sub < 0) {
            sub = (sub + Nat.dec(16, iArr3)) & P16;
        }
        iArr3[16] = sub;
    }

    public static void twice(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (Nat.shiftUpBit(16, iArr, i << 23, iArr2) | (i << 1)) & P16;
    }
}

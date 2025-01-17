package org.spongycastle.math.p186ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.p186ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat224;
import org.spongycastle.util.Arrays;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP224K1FieldElement */
public class SecP224K1FieldElement extends ECFieldElement {
    private static final int[] PRECOMP_POW2 = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    /* renamed from: Q */
    public static final BigInteger f8048Q = SecP224K1Curve.f8045q;

    /* renamed from: x */
    protected int[] f8049x;

    public SecP224K1FieldElement() {
        this.f8049x = Nat224.create();
    }

    public SecP224K1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f8048Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f8049x = SecP224K1Field.fromBigInteger(bigInteger);
    }

    protected SecP224K1FieldElement(int[] iArr) {
        this.f8049x = iArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        SecP224K1Field.add(this.f8049x, ((SecP224K1FieldElement) eCFieldElement).f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat224.create();
        SecP224K1Field.addOne(this.f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        Mod.invert(SecP224K1Field.f8046P, ((SecP224K1FieldElement) eCFieldElement).f8049x, create);
        SecP224K1Field.multiply(create, this.f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP224K1FieldElement)) {
            return false;
        }
        return Nat224.m9230eq(this.f8049x, ((SecP224K1FieldElement) obj).f8049x);
    }

    public String getFieldName() {
        return "SecP224K1Field";
    }

    public int getFieldSize() {
        return f8048Q.bitLength();
    }

    public int hashCode() {
        return f8048Q.hashCode() ^ Arrays.hashCode(this.f8049x, 0, 7);
    }

    public ECFieldElement invert() {
        int[] create = Nat224.create();
        Mod.invert(SecP224K1Field.f8046P, this.f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public boolean isOne() {
        return Nat224.isOne(this.f8049x);
    }

    public boolean isZero() {
        return Nat224.isZero(this.f8049x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        SecP224K1Field.multiply(this.f8049x, ((SecP224K1FieldElement) eCFieldElement).f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat224.create();
        SecP224K1Field.negate(this.f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f8049x;
        if (Nat224.isZero(iArr) || Nat224.isOne(iArr)) {
            return this;
        }
        int[] create = Nat224.create();
        SecP224K1Field.square(iArr, create);
        SecP224K1Field.multiply(create, iArr, create);
        SecP224K1Field.square(create, create);
        SecP224K1Field.multiply(create, iArr, create);
        int[] create2 = Nat224.create();
        SecP224K1Field.square(create, create2);
        SecP224K1Field.multiply(create2, iArr, create2);
        int[] create3 = Nat224.create();
        SecP224K1Field.squareN(create2, 4, create3);
        SecP224K1Field.multiply(create3, create2, create3);
        int[] create4 = Nat224.create();
        SecP224K1Field.squareN(create3, 3, create4);
        SecP224K1Field.multiply(create4, create, create4);
        SecP224K1Field.squareN(create4, 8, create4);
        SecP224K1Field.multiply(create4, create3, create4);
        SecP224K1Field.squareN(create4, 4, create3);
        SecP224K1Field.multiply(create3, create2, create3);
        SecP224K1Field.squareN(create3, 19, create2);
        SecP224K1Field.multiply(create2, create4, create2);
        int[] create5 = Nat224.create();
        SecP224K1Field.squareN(create2, 42, create5);
        SecP224K1Field.multiply(create5, create2, create5);
        SecP224K1Field.squareN(create5, 23, create2);
        SecP224K1Field.multiply(create2, create3, create2);
        SecP224K1Field.squareN(create2, 84, create3);
        SecP224K1Field.multiply(create3, create5, create3);
        SecP224K1Field.squareN(create3, 20, create3);
        SecP224K1Field.multiply(create3, create4, create3);
        SecP224K1Field.squareN(create3, 3, create3);
        SecP224K1Field.multiply(create3, iArr, create3);
        SecP224K1Field.squareN(create3, 2, create3);
        SecP224K1Field.multiply(create3, iArr, create3);
        SecP224K1Field.squareN(create3, 4, create3);
        SecP224K1Field.multiply(create3, create, create3);
        SecP224K1Field.square(create3, create3);
        SecP224K1Field.square(create3, create5);
        if (Nat224.m9230eq(iArr, create5)) {
            return new SecP224K1FieldElement(create3);
        }
        SecP224K1Field.multiply(create3, PRECOMP_POW2, create3);
        SecP224K1Field.square(create3, create5);
        if (Nat224.m9230eq(iArr, create5)) {
            return new SecP224K1FieldElement(create3);
        }
        return null;
    }

    public ECFieldElement square() {
        int[] create = Nat224.create();
        SecP224K1Field.square(this.f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat224.create();
        SecP224K1Field.subtract(this.f8049x, ((SecP224K1FieldElement) eCFieldElement).f8049x, create);
        return new SecP224K1FieldElement(create);
    }

    public boolean testBitZero() {
        return Nat224.getBit(this.f8049x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.f8049x);
    }
}

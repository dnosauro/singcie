package org.spongycastle.math.p186ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.p186ec.ECFieldElement;
import org.spongycastle.math.raw.Nat576;
import org.spongycastle.util.Arrays;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecT571FieldElement */
public class SecT571FieldElement extends ECFieldElement {

    /* renamed from: x */
    protected long[] f8085x;

    public SecT571FieldElement() {
        this.f8085x = Nat576.create64();
    }

    public SecT571FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f8085x = SecT571Field.fromBigInteger(bigInteger);
    }

    protected SecT571FieldElement(long[] jArr) {
        this.f8085x = jArr;
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        long[] create64 = Nat576.create64();
        SecT571Field.add(this.f8085x, ((SecT571FieldElement) eCFieldElement).f8085x, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement addOne() {
        long[] create64 = Nat576.create64();
        SecT571Field.addOne(this.f8085x, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        return multiply(eCFieldElement.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecT571FieldElement)) {
            return false;
        }
        return Nat576.eq64(this.f8085x, ((SecT571FieldElement) obj).f8085x);
    }

    public String getFieldName() {
        return "SecT571Field";
    }

    public int getFieldSize() {
        return 571;
    }

    public int getK1() {
        return 2;
    }

    public int getK2() {
        return 5;
    }

    public int getK3() {
        return 10;
    }

    public int getM() {
        return 571;
    }

    public int getRepresentation() {
        return 3;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f8085x, 0, 9) ^ 5711052;
    }

    public ECFieldElement invert() {
        long[] create64 = Nat576.create64();
        SecT571Field.invert(this.f8085x, create64);
        return new SecT571FieldElement(create64);
    }

    public boolean isOne() {
        return Nat576.isOne64(this.f8085x);
    }

    public boolean isZero() {
        return Nat576.isZero64(this.f8085x);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        long[] create64 = Nat576.create64();
        SecT571Field.multiply(this.f8085x, ((SecT571FieldElement) eCFieldElement).f8085x, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        long[] jArr = this.f8085x;
        long[] jArr2 = ((SecT571FieldElement) eCFieldElement).f8085x;
        long[] jArr3 = ((SecT571FieldElement) eCFieldElement2).f8085x;
        long[] jArr4 = ((SecT571FieldElement) eCFieldElement3).f8085x;
        long[] createExt64 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(jArr, jArr2, createExt64);
        SecT571Field.multiplyAddToExt(jArr3, jArr4, createExt64);
        long[] create64 = Nat576.create64();
        SecT571Field.reduce(createExt64, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement negate() {
        return this;
    }

    public ECFieldElement sqrt() {
        long[] create64 = Nat576.create64();
        SecT571Field.sqrt(this.f8085x, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement square() {
        long[] create64 = Nat576.create64();
        SecT571Field.square(this.f8085x, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return squarePlusProduct(eCFieldElement, eCFieldElement2);
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        long[] jArr = this.f8085x;
        long[] jArr2 = ((SecT571FieldElement) eCFieldElement).f8085x;
        long[] jArr3 = ((SecT571FieldElement) eCFieldElement2).f8085x;
        long[] createExt64 = Nat576.createExt64();
        SecT571Field.squareAddToExt(jArr, createExt64);
        SecT571Field.multiplyAddToExt(jArr2, jArr3, createExt64);
        long[] create64 = Nat576.create64();
        SecT571Field.reduce(createExt64, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement squarePow(int i) {
        if (i < 1) {
            return this;
        }
        long[] create64 = Nat576.create64();
        SecT571Field.squareN(this.f8085x, i, create64);
        return new SecT571FieldElement(create64);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        return add(eCFieldElement);
    }

    public boolean testBitZero() {
        return (this.f8085x[0] & 1) != 0;
    }

    public BigInteger toBigInteger() {
        return Nat576.toBigInteger64(this.f8085x);
    }
}

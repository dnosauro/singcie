package org.spongycastle.math.p186ec.custom.sec;

import org.spongycastle.math.p186ec.ECCurve;
import org.spongycastle.math.p186ec.ECFieldElement;
import org.spongycastle.math.p186ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat192;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP192R1Point */
public class SecP192R1Point extends ECPoint.AbstractFp {
    public SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecP192R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    public ECPoint add(ECPoint eCPoint) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        if (this == eCPoint) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement) this.f8001x;
        SecP192R1FieldElement secP192R1FieldElement2 = (SecP192R1FieldElement) this.f8002y;
        SecP192R1FieldElement secP192R1FieldElement3 = (SecP192R1FieldElement) eCPoint.getXCoord();
        SecP192R1FieldElement secP192R1FieldElement4 = (SecP192R1FieldElement) eCPoint.getYCoord();
        SecP192R1FieldElement secP192R1FieldElement5 = (SecP192R1FieldElement) this.f8003zs[0];
        SecP192R1FieldElement secP192R1FieldElement6 = (SecP192R1FieldElement) eCPoint.getZCoord(0);
        int[] createExt = Nat192.createExt();
        int[] create = Nat192.create();
        int[] create2 = Nat192.create();
        int[] create3 = Nat192.create();
        boolean isOne = secP192R1FieldElement5.isOne();
        if (isOne) {
            iArr2 = secP192R1FieldElement3.f8044x;
            iArr = secP192R1FieldElement4.f8044x;
        } else {
            SecP192R1Field.square(secP192R1FieldElement5.f8044x, create2);
            SecP192R1Field.multiply(create2, secP192R1FieldElement3.f8044x, create);
            SecP192R1Field.multiply(create2, secP192R1FieldElement5.f8044x, create2);
            SecP192R1Field.multiply(create2, secP192R1FieldElement4.f8044x, create2);
            iArr2 = create;
            iArr = create2;
        }
        boolean isOne2 = secP192R1FieldElement6.isOne();
        if (isOne2) {
            iArr4 = secP192R1FieldElement.f8044x;
            iArr3 = secP192R1FieldElement2.f8044x;
        } else {
            SecP192R1Field.square(secP192R1FieldElement6.f8044x, create3);
            SecP192R1Field.multiply(create3, secP192R1FieldElement.f8044x, createExt);
            SecP192R1Field.multiply(create3, secP192R1FieldElement6.f8044x, create3);
            SecP192R1Field.multiply(create3, secP192R1FieldElement2.f8044x, create3);
            iArr4 = createExt;
            iArr3 = create3;
        }
        int[] create4 = Nat192.create();
        SecP192R1Field.subtract(iArr4, iArr2, create4);
        SecP192R1Field.subtract(iArr3, iArr, create);
        if (Nat192.isZero(create4)) {
            return Nat192.isZero(create) ? twice() : curve.getInfinity();
        }
        SecP192R1Field.square(create4, create2);
        int[] create5 = Nat192.create();
        SecP192R1Field.multiply(create2, create4, create5);
        SecP192R1Field.multiply(create2, iArr4, create2);
        SecP192R1Field.negate(create5, create5);
        Nat192.mul(iArr3, create5, createExt);
        SecP192R1Field.reduce32(Nat192.addBothTo(create2, create2, create5), create5);
        SecP192R1FieldElement secP192R1FieldElement7 = new SecP192R1FieldElement(create3);
        SecP192R1Field.square(create, secP192R1FieldElement7.f8044x);
        SecP192R1Field.subtract(secP192R1FieldElement7.f8044x, create5, secP192R1FieldElement7.f8044x);
        SecP192R1FieldElement secP192R1FieldElement8 = new SecP192R1FieldElement(create5);
        SecP192R1Field.subtract(create2, secP192R1FieldElement7.f8044x, secP192R1FieldElement8.f8044x);
        SecP192R1Field.multiplyAddToExt(secP192R1FieldElement8.f8044x, create, createExt);
        SecP192R1Field.reduce(createExt, secP192R1FieldElement8.f8044x);
        SecP192R1FieldElement secP192R1FieldElement9 = new SecP192R1FieldElement(create4);
        if (!isOne) {
            SecP192R1Field.multiply(secP192R1FieldElement9.f8044x, secP192R1FieldElement5.f8044x, secP192R1FieldElement9.f8044x);
        }
        if (!isOne2) {
            SecP192R1Field.multiply(secP192R1FieldElement9.f8044x, secP192R1FieldElement6.f8044x, secP192R1FieldElement9.f8044x);
        }
        return new SecP192R1Point(curve, secP192R1FieldElement7, secP192R1FieldElement8, new ECFieldElement[]{secP192R1FieldElement9}, this.withCompression);
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP192R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECPoint negate() {
        return isInfinity() ? this : new SecP192R1Point(this.curve, this.f8001x, this.f8002y.negate(), this.f8003zs, this.withCompression);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f8002y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP192R1FieldElement secP192R1FieldElement = (SecP192R1FieldElement) this.f8002y;
        if (secP192R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP192R1FieldElement secP192R1FieldElement2 = (SecP192R1FieldElement) this.f8001x;
        SecP192R1FieldElement secP192R1FieldElement3 = (SecP192R1FieldElement) this.f8003zs[0];
        int[] create = Nat192.create();
        int[] create2 = Nat192.create();
        int[] create3 = Nat192.create();
        SecP192R1Field.square(secP192R1FieldElement.f8044x, create3);
        int[] create4 = Nat192.create();
        SecP192R1Field.square(create3, create4);
        boolean isOne = secP192R1FieldElement3.isOne();
        int[] iArr = secP192R1FieldElement3.f8044x;
        if (!isOne) {
            SecP192R1Field.square(secP192R1FieldElement3.f8044x, create2);
            iArr = create2;
        }
        SecP192R1Field.subtract(secP192R1FieldElement2.f8044x, iArr, create);
        SecP192R1Field.add(secP192R1FieldElement2.f8044x, iArr, create2);
        SecP192R1Field.multiply(create2, create, create2);
        SecP192R1Field.reduce32(Nat192.addBothTo(create2, create2, create2), create2);
        SecP192R1Field.multiply(create3, secP192R1FieldElement2.f8044x, create3);
        SecP192R1Field.reduce32(Nat.shiftUpBits(6, create3, 2, 0), create3);
        SecP192R1Field.reduce32(Nat.shiftUpBits(6, create4, 3, 0, create), create);
        SecP192R1FieldElement secP192R1FieldElement4 = new SecP192R1FieldElement(create4);
        SecP192R1Field.square(create2, secP192R1FieldElement4.f8044x);
        SecP192R1Field.subtract(secP192R1FieldElement4.f8044x, create3, secP192R1FieldElement4.f8044x);
        SecP192R1Field.subtract(secP192R1FieldElement4.f8044x, create3, secP192R1FieldElement4.f8044x);
        SecP192R1FieldElement secP192R1FieldElement5 = new SecP192R1FieldElement(create3);
        SecP192R1Field.subtract(create3, secP192R1FieldElement4.f8044x, secP192R1FieldElement5.f8044x);
        SecP192R1Field.multiply(secP192R1FieldElement5.f8044x, create2, secP192R1FieldElement5.f8044x);
        SecP192R1Field.subtract(secP192R1FieldElement5.f8044x, create, secP192R1FieldElement5.f8044x);
        SecP192R1FieldElement secP192R1FieldElement6 = new SecP192R1FieldElement(create2);
        SecP192R1Field.twice(secP192R1FieldElement.f8044x, secP192R1FieldElement6.f8044x);
        if (!isOne) {
            SecP192R1Field.multiply(secP192R1FieldElement6.f8044x, secP192R1FieldElement3.f8044x, secP192R1FieldElement6.f8044x);
        }
        return new SecP192R1Point(curve, secP192R1FieldElement4, secP192R1FieldElement5, new ECFieldElement[]{secP192R1FieldElement6}, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f8002y.isZero() ? eCPoint : twice().add(eCPoint);
    }
}

package org.spongycastle.math.p186ec.custom.sec;

import org.spongycastle.math.p186ec.ECConstants;
import org.spongycastle.math.p186ec.ECCurve;
import org.spongycastle.math.p186ec.ECFieldElement;
import org.spongycastle.math.p186ec.ECPoint;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecT163R2Point */
public class SecT163R2Point extends ECPoint.AbstractF2m {
    public SecT163R2Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecT163R2Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecT163R2Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    public ECPoint add(ECPoint eCPoint) {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        ECFieldElement eCFieldElement3;
        ECFieldElement eCFieldElement4;
        ECFieldElement eCFieldElement5;
        ECFieldElement eCFieldElement6;
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement7 = this.f8001x;
        ECFieldElement rawXCoord = eCPoint.getRawXCoord();
        if (eCFieldElement7.isZero()) {
            return rawXCoord.isZero() ? curve.getInfinity() : eCPoint.add(this);
        }
        ECFieldElement eCFieldElement8 = this.f8002y;
        ECFieldElement eCFieldElement9 = this.f8003zs[0];
        ECFieldElement rawYCoord = eCPoint.getRawYCoord();
        ECFieldElement zCoord = eCPoint.getZCoord(0);
        boolean isOne = eCFieldElement9.isOne();
        if (!isOne) {
            eCFieldElement2 = rawXCoord.multiply(eCFieldElement9);
            eCFieldElement = rawYCoord.multiply(eCFieldElement9);
        } else {
            eCFieldElement2 = rawXCoord;
            eCFieldElement = rawYCoord;
        }
        boolean isOne2 = zCoord.isOne();
        if (!isOne2) {
            eCFieldElement7 = eCFieldElement7.multiply(zCoord);
            eCFieldElement3 = eCFieldElement8.multiply(zCoord);
        } else {
            eCFieldElement3 = eCFieldElement8;
        }
        ECFieldElement add = eCFieldElement3.add(eCFieldElement);
        ECFieldElement add2 = eCFieldElement7.add(eCFieldElement2);
        if (add2.isZero()) {
            return add.isZero() ? twice() : curve.getInfinity();
        }
        if (rawXCoord.isZero()) {
            ECPoint normalize = normalize();
            ECFieldElement xCoord = normalize.getXCoord();
            ECFieldElement yCoord = normalize.getYCoord();
            ECFieldElement divide = yCoord.add(rawYCoord).divide(xCoord);
            eCFieldElement6 = divide.square().add(divide).add(xCoord).addOne();
            if (eCFieldElement6.isZero()) {
                return new SecT163R2Point(curve, eCFieldElement6, curve.getB().sqrt(), this.withCompression);
            }
            eCFieldElement5 = divide.multiply(xCoord.add(eCFieldElement6)).add(eCFieldElement6).add(yCoord).divide(eCFieldElement6).add(eCFieldElement6);
            eCFieldElement4 = curve.fromBigInteger(ECConstants.ONE);
        } else {
            ECFieldElement square = add2.square();
            ECFieldElement multiply = add.multiply(eCFieldElement7);
            ECFieldElement multiply2 = add.multiply(eCFieldElement2);
            ECFieldElement multiply3 = multiply.multiply(multiply2);
            if (multiply3.isZero()) {
                return new SecT163R2Point(curve, multiply3, curve.getB().sqrt(), this.withCompression);
            }
            ECFieldElement multiply4 = add.multiply(square);
            eCFieldElement4 = !isOne2 ? multiply4.multiply(zCoord) : multiply4;
            ECFieldElement squarePlusProduct = multiply2.add(square).squarePlusProduct(eCFieldElement4, eCFieldElement8.add(eCFieldElement9));
            if (!isOne) {
                eCFieldElement4 = eCFieldElement4.multiply(eCFieldElement9);
            }
            eCFieldElement6 = multiply3;
            eCFieldElement5 = squarePlusProduct;
        }
        return new SecT163R2Point(curve, eCFieldElement6, eCFieldElement5, new ECFieldElement[]{eCFieldElement4}, this.withCompression);
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecT163R2Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    /* access modifiers changed from: protected */
    public boolean getCompressionYTilde() {
        ECFieldElement rawXCoord = getRawXCoord();
        return !rawXCoord.isZero() && getRawYCoord().testBitZero() != rawXCoord.testBitZero();
    }

    public ECFieldElement getYCoord() {
        ECFieldElement eCFieldElement = this.f8001x;
        ECFieldElement eCFieldElement2 = this.f8002y;
        if (isInfinity() || eCFieldElement.isZero()) {
            return eCFieldElement2;
        }
        ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
        ECFieldElement eCFieldElement3 = this.f8003zs[0];
        return !eCFieldElement3.isOne() ? multiply.divide(eCFieldElement3) : multiply;
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.f8001x;
        if (eCFieldElement.isZero()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.f8002y;
        ECFieldElement eCFieldElement3 = this.f8003zs[0];
        ECCurve eCCurve = this.curve;
        ECFieldElement[] eCFieldElementArr = {eCFieldElement3};
        return new SecT163R2Point(eCCurve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), eCFieldElementArr, this.withCompression);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement = this.f8001x;
        if (eCFieldElement.isZero()) {
            return curve.getInfinity();
        }
        ECFieldElement eCFieldElement2 = this.f8002y;
        ECFieldElement eCFieldElement3 = this.f8003zs[0];
        boolean isOne = eCFieldElement3.isOne();
        ECFieldElement multiply = isOne ? eCFieldElement2 : eCFieldElement2.multiply(eCFieldElement3);
        ECFieldElement square = isOne ? eCFieldElement3 : eCFieldElement3.square();
        ECFieldElement add = eCFieldElement2.square().add(multiply).add(square);
        if (add.isZero()) {
            return new SecT163R2Point(curve, add, curve.getB().sqrt(), this.withCompression);
        }
        ECFieldElement square2 = add.square();
        ECFieldElement multiply2 = isOne ? add : add.multiply(square);
        if (!isOne) {
            eCFieldElement = eCFieldElement.multiply(eCFieldElement3);
        }
        return new SecT163R2Point(curve, square2, eCFieldElement.squarePlusProduct(add, multiply).add(square2).add(multiply2), new ECFieldElement[]{multiply2}, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement = this.f8001x;
        if (eCFieldElement.isZero()) {
            return eCPoint;
        }
        ECFieldElement rawXCoord = eCPoint.getRawXCoord();
        ECFieldElement zCoord = eCPoint.getZCoord(0);
        if (rawXCoord.isZero() || !zCoord.isOne()) {
            return twice().add(eCPoint);
        }
        ECFieldElement eCFieldElement2 = this.f8002y;
        ECFieldElement eCFieldElement3 = this.f8003zs[0];
        ECFieldElement rawYCoord = eCPoint.getRawYCoord();
        ECFieldElement square = eCFieldElement.square();
        ECFieldElement square2 = eCFieldElement2.square();
        ECFieldElement square3 = eCFieldElement3.square();
        ECFieldElement add = square3.add(square2).add(eCFieldElement2.multiply(eCFieldElement3));
        ECFieldElement multiplyPlusProduct = rawYCoord.multiply(square3).add(square2).multiplyPlusProduct(add, square, square3);
        ECFieldElement multiply = rawXCoord.multiply(square3);
        ECFieldElement square4 = multiply.add(add).square();
        if (square4.isZero()) {
            return multiplyPlusProduct.isZero() ? eCPoint.twice() : curve.getInfinity();
        }
        if (multiplyPlusProduct.isZero()) {
            return new SecT163R2Point(curve, multiplyPlusProduct, curve.getB().sqrt(), this.withCompression);
        }
        ECFieldElement multiply2 = multiplyPlusProduct.square().multiply(multiply);
        ECFieldElement multiply3 = multiplyPlusProduct.multiply(square4).multiply(square3);
        return new SecT163R2Point(curve, multiply2, multiplyPlusProduct.add(square4).square().multiplyPlusProduct(add, rawYCoord.addOne(), multiply3), new ECFieldElement[]{multiply3}, this.withCompression);
    }
}

package org.spongycastle.math.p186ec.custom.sec;

import org.spongycastle.math.p186ec.ECConstants;
import org.spongycastle.math.p186ec.ECCurve;
import org.spongycastle.math.p186ec.ECFieldElement;
import org.spongycastle.math.p186ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat576;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecT571R1Point */
public class SecT571R1Point extends ECPoint.AbstractF2m {
    public SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    public ECPoint add(ECPoint eCPoint) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        SecT571FieldElement secT571FieldElement;
        SecT571FieldElement secT571FieldElement2;
        SecT571FieldElement secT571FieldElement3;
        ECPoint eCPoint2 = eCPoint;
        if (isInfinity()) {
            return eCPoint2;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.f8001x;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) eCPoint.getRawXCoord();
        if (secT571FieldElement4.isZero()) {
            return secT571FieldElement5.isZero() ? curve.getInfinity() : eCPoint2.add(this);
        }
        SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) this.f8002y;
        SecT571FieldElement secT571FieldElement7 = (SecT571FieldElement) this.f8003zs[0];
        SecT571FieldElement secT571FieldElement8 = (SecT571FieldElement) eCPoint.getRawYCoord();
        SecT571FieldElement secT571FieldElement9 = (SecT571FieldElement) eCPoint2.getZCoord(0);
        long[] create64 = Nat576.create64();
        long[] create642 = Nat576.create64();
        long[] create643 = Nat576.create64();
        long[] create644 = Nat576.create64();
        long[] precompMultiplicand = secT571FieldElement7.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement7.f8085x);
        if (precompMultiplicand == null) {
            jArr = secT571FieldElement5.f8085x;
            jArr2 = secT571FieldElement8.f8085x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement5.f8085x, precompMultiplicand, create642);
            SecT571Field.multiplyPrecomp(secT571FieldElement8.f8085x, precompMultiplicand, create644);
            jArr = create642;
            jArr2 = create644;
        }
        long[] precompMultiplicand2 = secT571FieldElement9.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement9.f8085x);
        if (precompMultiplicand2 == null) {
            jArr4 = secT571FieldElement4.f8085x;
            jArr3 = secT571FieldElement6.f8085x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement4.f8085x, precompMultiplicand2, create64);
            SecT571Field.multiplyPrecomp(secT571FieldElement6.f8085x, precompMultiplicand2, create643);
            jArr4 = create64;
            jArr3 = create643;
        }
        SecT571Field.add(jArr3, jArr2, create643);
        SecT571Field.add(jArr4, jArr, create644);
        if (Nat576.isZero64(create644)) {
            return Nat576.isZero64(create643) ? twice() : curve.getInfinity();
        }
        if (secT571FieldElement5.isZero()) {
            ECPoint normalize = normalize();
            SecT571FieldElement secT571FieldElement10 = (SecT571FieldElement) normalize.getXCoord();
            ECFieldElement yCoord = normalize.getYCoord();
            ECFieldElement divide = yCoord.add(secT571FieldElement8).divide(secT571FieldElement10);
            secT571FieldElement2 = (SecT571FieldElement) divide.square().add(divide).add(secT571FieldElement10).addOne();
            if (secT571FieldElement2.isZero()) {
                return new SecT571R1Point(curve, secT571FieldElement2, SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
            }
            secT571FieldElement3 = (SecT571FieldElement) curve.fromBigInteger(ECConstants.ONE);
            secT571FieldElement = (SecT571FieldElement) divide.multiply(secT571FieldElement10.add(secT571FieldElement2)).add(secT571FieldElement2).add(yCoord).divide(secT571FieldElement2).add(secT571FieldElement2);
        } else {
            SecT571Field.square(create644, create644);
            long[] precompMultiplicand3 = SecT571Field.precompMultiplicand(create643);
            SecT571Field.multiplyPrecomp(jArr4, precompMultiplicand3, create64);
            SecT571Field.multiplyPrecomp(jArr, precompMultiplicand3, create642);
            SecT571FieldElement secT571FieldElement11 = new SecT571FieldElement(create64);
            SecT571Field.multiply(create64, create642, secT571FieldElement11.f8085x);
            if (secT571FieldElement11.isZero()) {
                return new SecT571R1Point(curve, secT571FieldElement11, SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
            }
            SecT571FieldElement secT571FieldElement12 = new SecT571FieldElement(create643);
            SecT571Field.multiplyPrecomp(create644, precompMultiplicand3, secT571FieldElement12.f8085x);
            if (precompMultiplicand2 != null) {
                SecT571Field.multiplyPrecomp(secT571FieldElement12.f8085x, precompMultiplicand2, secT571FieldElement12.f8085x);
            }
            long[] createExt64 = Nat576.createExt64();
            SecT571Field.add(create642, create644, create644);
            SecT571Field.squareAddToExt(create644, createExt64);
            SecT571Field.add(secT571FieldElement6.f8085x, secT571FieldElement7.f8085x, create644);
            SecT571Field.multiplyAddToExt(create644, secT571FieldElement12.f8085x, createExt64);
            SecT571FieldElement secT571FieldElement13 = new SecT571FieldElement(create644);
            SecT571Field.reduce(createExt64, secT571FieldElement13.f8085x);
            if (precompMultiplicand != null) {
                SecT571Field.multiplyPrecomp(secT571FieldElement12.f8085x, precompMultiplicand, secT571FieldElement12.f8085x);
            }
            secT571FieldElement2 = secT571FieldElement11;
            secT571FieldElement = secT571FieldElement13;
            secT571FieldElement3 = secT571FieldElement12;
        }
        return new SecT571R1Point(curve, secT571FieldElement2, secT571FieldElement, new ECFieldElement[]{secT571FieldElement3}, this.withCompression);
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecT571R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
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
        return new SecT571R1Point(eCCurve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), eCFieldElementArr, this.withCompression);
    }

    public ECPoint twice() {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement) this.f8001x;
        if (secT571FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement) this.f8002y;
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement) this.f8003zs[0];
        long[] create64 = Nat576.create64();
        long[] create642 = Nat576.create64();
        long[] precompMultiplicand = secT571FieldElement3.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement3.f8085x);
        if (precompMultiplicand == null) {
            jArr = secT571FieldElement2.f8085x;
            jArr2 = secT571FieldElement3.f8085x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement2.f8085x, precompMultiplicand, create64);
            SecT571Field.square(secT571FieldElement3.f8085x, create642);
            jArr = create64;
            jArr2 = create642;
        }
        long[] create643 = Nat576.create64();
        SecT571Field.square(secT571FieldElement2.f8085x, create643);
        SecT571Field.addBothTo(jArr, jArr2, create643);
        if (Nat576.isZero64(create643)) {
            return new SecT571R1Point(curve, new SecT571FieldElement(create643), SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
        }
        long[] createExt64 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(create643, jArr, createExt64);
        SecT571FieldElement secT571FieldElement4 = new SecT571FieldElement(create64);
        SecT571Field.square(create643, secT571FieldElement4.f8085x);
        SecT571FieldElement secT571FieldElement5 = new SecT571FieldElement(create643);
        if (precompMultiplicand != null) {
            SecT571Field.multiply(secT571FieldElement5.f8085x, jArr2, secT571FieldElement5.f8085x);
        }
        if (precompMultiplicand == null) {
            jArr3 = secT571FieldElement.f8085x;
        } else {
            SecT571Field.multiplyPrecomp(secT571FieldElement.f8085x, precompMultiplicand, create642);
            jArr3 = create642;
        }
        SecT571Field.squareAddToExt(jArr3, createExt64);
        SecT571Field.reduce(createExt64, create642);
        SecT571Field.addBothTo(secT571FieldElement4.f8085x, secT571FieldElement5.f8085x, create642);
        return new SecT571R1Point(curve, secT571FieldElement4, new SecT571FieldElement(create642), new ECFieldElement[]{secT571FieldElement5}, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement) this.f8001x;
        if (secT571FieldElement.isZero()) {
            return eCPoint;
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement) eCPoint.getRawXCoord();
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement) eCPoint.getZCoord(0);
        if (secT571FieldElement2.isZero() || !secT571FieldElement3.isOne()) {
            return twice().add(eCPoint);
        }
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.f8002y;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) this.f8003zs[0];
        SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) eCPoint.getRawYCoord();
        long[] create64 = Nat576.create64();
        long[] create642 = Nat576.create64();
        long[] create643 = Nat576.create64();
        long[] create644 = Nat576.create64();
        SecT571Field.square(secT571FieldElement.f8085x, create64);
        SecT571Field.square(secT571FieldElement4.f8085x, create642);
        SecT571Field.square(secT571FieldElement5.f8085x, create643);
        SecT571Field.multiply(secT571FieldElement4.f8085x, secT571FieldElement5.f8085x, create644);
        SecT571Field.addBothTo(create643, create642, create644);
        long[] precompMultiplicand = SecT571Field.precompMultiplicand(create643);
        SecT571Field.multiplyPrecomp(secT571FieldElement6.f8085x, precompMultiplicand, create643);
        SecT571Field.add(create643, create642, create643);
        long[] createExt64 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(create643, create644, createExt64);
        SecT571Field.multiplyPrecompAddToExt(create64, precompMultiplicand, createExt64);
        SecT571Field.reduce(createExt64, create643);
        SecT571Field.multiplyPrecomp(secT571FieldElement2.f8085x, precompMultiplicand, create64);
        SecT571Field.add(create64, create644, create642);
        SecT571Field.square(create642, create642);
        if (Nat576.isZero64(create642)) {
            return Nat576.isZero64(create643) ? eCPoint.twice() : curve.getInfinity();
        }
        if (Nat576.isZero64(create643)) {
            return new SecT571R1Point(curve, new SecT571FieldElement(create643), SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
        }
        SecT571FieldElement secT571FieldElement7 = new SecT571FieldElement();
        SecT571Field.square(create643, secT571FieldElement7.f8085x);
        SecT571Field.multiply(secT571FieldElement7.f8085x, create64, secT571FieldElement7.f8085x);
        SecT571FieldElement secT571FieldElement8 = new SecT571FieldElement(create64);
        SecT571Field.multiply(create643, create642, secT571FieldElement8.f8085x);
        SecT571Field.multiplyPrecomp(secT571FieldElement8.f8085x, precompMultiplicand, secT571FieldElement8.f8085x);
        SecT571FieldElement secT571FieldElement9 = new SecT571FieldElement(create642);
        SecT571Field.add(create643, create642, secT571FieldElement9.f8085x);
        SecT571Field.square(secT571FieldElement9.f8085x, secT571FieldElement9.f8085x);
        Nat.zero64(18, createExt64);
        SecT571Field.multiplyAddToExt(secT571FieldElement9.f8085x, create644, createExt64);
        SecT571Field.addOne(secT571FieldElement6.f8085x, create644);
        SecT571Field.multiplyAddToExt(create644, secT571FieldElement8.f8085x, createExt64);
        SecT571Field.reduce(createExt64, secT571FieldElement9.f8085x);
        return new SecT571R1Point(curve, secT571FieldElement7, secT571FieldElement9, new ECFieldElement[]{secT571FieldElement8}, this.withCompression);
    }
}

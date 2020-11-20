package org.spongycastle.math.p186ec;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.math.p186ec.ECFieldElement;

/* renamed from: org.spongycastle.math.ec.ECPoint */
public abstract class ECPoint {
    protected static ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    protected ECCurve curve;
    protected Hashtable preCompTable;
    protected boolean withCompression;

    /* renamed from: x */
    protected ECFieldElement f8001x;

    /* renamed from: y */
    protected ECFieldElement f8002y;

    /* renamed from: zs */
    protected ECFieldElement[] f8003zs;

    /* renamed from: org.spongycastle.math.ec.ECPoint$AbstractF2m */
    public static abstract class AbstractF2m extends ECPoint {
        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* access modifiers changed from: protected */
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement3 = this.f8001x;
            ECFieldElement a = curve.getA();
            ECFieldElement b = curve.getB();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.f8003zs[0];
                boolean isOne = eCFieldElement4.isOne();
                if (eCFieldElement3.isZero()) {
                    ECFieldElement square = this.f8002y.square();
                    if (!isOne) {
                        b = b.multiply(eCFieldElement4.square());
                    }
                    return square.equals(b);
                }
                ECFieldElement eCFieldElement5 = this.f8002y;
                ECFieldElement square2 = eCFieldElement3.square();
                if (isOne) {
                    eCFieldElement2 = eCFieldElement5.square().add(eCFieldElement5).add(a);
                    eCFieldElement = square2.square().add(b);
                } else {
                    ECFieldElement square3 = eCFieldElement4.square();
                    ECFieldElement square4 = square3.square();
                    eCFieldElement2 = eCFieldElement5.add(eCFieldElement4).multiplyPlusProduct(eCFieldElement5, a, square3);
                    eCFieldElement = square2.squarePlusProduct(b, square4);
                }
                return eCFieldElement2.multiply(square2).equals(eCFieldElement);
            }
            ECFieldElement eCFieldElement6 = this.f8002y;
            ECFieldElement multiply = eCFieldElement6.add(eCFieldElement3).multiply(eCFieldElement6);
            switch (coordinateSystem) {
                case 0:
                    break;
                case 1:
                    ECFieldElement eCFieldElement7 = this.f8003zs[0];
                    if (!eCFieldElement7.isOne()) {
                        ECFieldElement multiply2 = eCFieldElement7.multiply(eCFieldElement7.square());
                        multiply = multiply.multiply(eCFieldElement7);
                        a = a.multiply(eCFieldElement7);
                        b = b.multiply(multiply2);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            return multiply.equals(eCFieldElement3.add(a).multiply(eCFieldElement3.square()).add(b));
        }

        public ECPoint scaleX(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            switch (getCurveCoordinateSystem()) {
                case 5:
                    ECFieldElement rawXCoord = getRawXCoord();
                    ECFieldElement rawYCoord = getRawYCoord();
                    return getCurve().createRawPoint(rawXCoord, rawYCoord.add(rawXCoord).divide(eCFieldElement).add(rawXCoord.multiply(eCFieldElement)), getRawZCoords(), this.withCompression);
                case 6:
                    ECFieldElement rawXCoord2 = getRawXCoord();
                    ECFieldElement rawYCoord2 = getRawYCoord();
                    ECFieldElement eCFieldElement2 = getRawZCoords()[0];
                    ECFieldElement multiply = rawXCoord2.multiply(eCFieldElement.square());
                    ECFieldElement add = rawYCoord2.add(rawXCoord2).add(multiply);
                    ECFieldElement multiply2 = eCFieldElement2.multiply(eCFieldElement);
                    return getCurve().createRawPoint(multiply, add, new ECFieldElement[]{multiply2}, this.withCompression);
                default:
                    return ECPoint.super.scaleX(eCFieldElement);
            }
        }

        public ECPoint scaleY(ECFieldElement eCFieldElement) {
            if (isInfinity()) {
                return this;
            }
            switch (getCurveCoordinateSystem()) {
                case 5:
                case 6:
                    ECFieldElement rawXCoord = getRawXCoord();
                    return getCurve().createRawPoint(rawXCoord, getRawYCoord().add(rawXCoord).multiply(eCFieldElement).add(rawXCoord), getRawZCoords(), this.withCompression);
                default:
                    return ECPoint.super.scaleY(eCFieldElement);
            }
        }

        public ECPoint subtract(ECPoint eCPoint) {
            return eCPoint.isInfinity() ? this : add(eCPoint.negate());
        }

        public AbstractF2m tau() {
            ECPoint createRawPoint;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.f8001x;
            switch (coordinateSystem) {
                case 0:
                case 5:
                    createRawPoint = curve.createRawPoint(eCFieldElement.square(), this.f8002y.square(), this.withCompression);
                    break;
                case 1:
                case 6:
                    ECFieldElement eCFieldElement2 = this.f8002y;
                    ECFieldElement eCFieldElement3 = this.f8003zs[0];
                    createRawPoint = curve.createRawPoint(eCFieldElement.square(), eCFieldElement2.square(), new ECFieldElement[]{eCFieldElement3.square()}, this.withCompression);
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            return (AbstractF2m) createRawPoint;
        }

        public AbstractF2m tauPow(int i) {
            ECPoint createRawPoint;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.f8001x;
            switch (coordinateSystem) {
                case 0:
                case 5:
                    createRawPoint = curve.createRawPoint(eCFieldElement.squarePow(i), this.f8002y.squarePow(i), this.withCompression);
                    break;
                case 1:
                case 6:
                    ECFieldElement eCFieldElement2 = this.f8002y;
                    ECFieldElement eCFieldElement3 = this.f8003zs[0];
                    createRawPoint = curve.createRawPoint(eCFieldElement.squarePow(i), eCFieldElement2.squarePow(i), new ECFieldElement[]{eCFieldElement3.squarePow(i)}, this.withCompression);
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            return (AbstractF2m) createRawPoint;
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$AbstractFp */
    public static abstract class AbstractFp extends ECPoint {
        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        protected AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        /* access modifiers changed from: protected */
        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        /* access modifiers changed from: protected */
        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement = this.f8001x;
            ECFieldElement eCFieldElement2 = this.f8002y;
            ECFieldElement a = this.curve.getA();
            ECFieldElement b = this.curve.getB();
            ECFieldElement square = eCFieldElement2.square();
            switch (getCurveCoordinateSystem()) {
                case 0:
                    break;
                case 1:
                    ECFieldElement eCFieldElement3 = this.f8003zs[0];
                    if (!eCFieldElement3.isOne()) {
                        ECFieldElement square2 = eCFieldElement3.square();
                        ECFieldElement multiply = eCFieldElement3.multiply(square2);
                        square = square.multiply(eCFieldElement3);
                        a = a.multiply(square2);
                        b = b.multiply(multiply);
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    ECFieldElement eCFieldElement4 = this.f8003zs[0];
                    if (!eCFieldElement4.isOne()) {
                        ECFieldElement square3 = eCFieldElement4.square();
                        ECFieldElement square4 = square3.square();
                        ECFieldElement multiply2 = square3.multiply(square4);
                        a = a.multiply(square4);
                        b = b.multiply(multiply2);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            return square.equals(eCFieldElement.square().add(a).multiply(eCFieldElement).add(b));
        }

        public ECPoint subtract(ECPoint eCPoint) {
            return eCPoint.isInfinity() ? this : add(eCPoint.negate());
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$F2m */
    public static class F2m extends AbstractF2m {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                if (eCFieldElement != null) {
                    ECFieldElement.F2m.checkFieldElements(this.f8001x, this.f8002y);
                    if (eCCurve != null) {
                        ECFieldElement.F2m.checkFieldElements(this.f8001x, this.curve.getA());
                    }
                }
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
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
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement7 = this.f8001x;
            ECFieldElement eCFieldElement8 = eCPoint.f8001x;
            if (coordinateSystem != 6) {
                switch (coordinateSystem) {
                    case 0:
                        ECFieldElement eCFieldElement9 = this.f8002y;
                        ECFieldElement eCFieldElement10 = eCPoint.f8002y;
                        ECFieldElement add = eCFieldElement7.add(eCFieldElement8);
                        ECFieldElement add2 = eCFieldElement9.add(eCFieldElement10);
                        if (add.isZero()) {
                            return add2.isZero() ? twice() : curve.getInfinity();
                        }
                        ECFieldElement divide = add2.divide(add);
                        ECFieldElement add3 = divide.square().add(divide).add(add).add(curve.getA());
                        return new F2m(curve, add3, divide.multiply(eCFieldElement7.add(add3)).add(add3).add(eCFieldElement9), this.withCompression);
                    case 1:
                        ECFieldElement eCFieldElement11 = this.f8002y;
                        ECFieldElement eCFieldElement12 = this.f8003zs[0];
                        ECFieldElement eCFieldElement13 = eCPoint.f8002y;
                        ECFieldElement eCFieldElement14 = eCPoint.f8003zs[0];
                        boolean isOne = eCFieldElement14.isOne();
                        ECFieldElement add4 = eCFieldElement12.multiply(eCFieldElement13).add(isOne ? eCFieldElement11 : eCFieldElement11.multiply(eCFieldElement14));
                        ECFieldElement add5 = eCFieldElement12.multiply(eCFieldElement8).add(isOne ? eCFieldElement7 : eCFieldElement7.multiply(eCFieldElement14));
                        if (add5.isZero()) {
                            return add4.isZero() ? twice() : curve.getInfinity();
                        }
                        ECFieldElement square = add5.square();
                        ECFieldElement multiply = square.multiply(add5);
                        if (!isOne) {
                            eCFieldElement12 = eCFieldElement12.multiply(eCFieldElement14);
                        }
                        ECFieldElement add6 = add4.add(add5);
                        ECFieldElement add7 = add6.multiplyPlusProduct(add4, square, curve.getA()).multiply(eCFieldElement12).add(multiply);
                        ECFieldElement multiply2 = add5.multiply(add7);
                        if (!isOne) {
                            square = square.multiply(eCFieldElement14);
                        }
                        return new F2m(curve, multiply2, add4.multiplyPlusProduct(eCFieldElement7, add5, eCFieldElement11).multiplyPlusProduct(square, add6, add7), new ECFieldElement[]{multiply.multiply(eCFieldElement12)}, this.withCompression);
                    default:
                        throw new IllegalStateException("unsupported coordinate system");
                }
            } else if (eCFieldElement7.isZero()) {
                return eCFieldElement8.isZero() ? curve.getInfinity() : eCPoint.add(this);
            } else {
                ECFieldElement eCFieldElement15 = this.f8002y;
                ECFieldElement eCFieldElement16 = this.f8003zs[0];
                ECFieldElement eCFieldElement17 = eCPoint.f8002y;
                ECFieldElement eCFieldElement18 = eCPoint.f8003zs[0];
                boolean isOne2 = eCFieldElement16.isOne();
                if (!isOne2) {
                    eCFieldElement2 = eCFieldElement8.multiply(eCFieldElement16);
                    eCFieldElement = eCFieldElement17.multiply(eCFieldElement16);
                } else {
                    eCFieldElement2 = eCFieldElement8;
                    eCFieldElement = eCFieldElement17;
                }
                boolean isOne3 = eCFieldElement18.isOne();
                if (!isOne3) {
                    eCFieldElement7 = eCFieldElement7.multiply(eCFieldElement18);
                    eCFieldElement3 = eCFieldElement15.multiply(eCFieldElement18);
                } else {
                    eCFieldElement3 = eCFieldElement15;
                }
                ECFieldElement add8 = eCFieldElement3.add(eCFieldElement);
                ECFieldElement add9 = eCFieldElement7.add(eCFieldElement2);
                if (add9.isZero()) {
                    return add8.isZero() ? twice() : curve.getInfinity();
                }
                if (eCFieldElement8.isZero()) {
                    ECPoint normalize = normalize();
                    ECFieldElement xCoord = normalize.getXCoord();
                    ECFieldElement yCoord = normalize.getYCoord();
                    ECFieldElement divide2 = yCoord.add(eCFieldElement17).divide(xCoord);
                    eCFieldElement6 = divide2.square().add(divide2).add(xCoord).add(curve.getA());
                    if (eCFieldElement6.isZero()) {
                        return new F2m(curve, eCFieldElement6, curve.getB().sqrt(), this.withCompression);
                    }
                    eCFieldElement5 = divide2.multiply(xCoord.add(eCFieldElement6)).add(eCFieldElement6).add(yCoord).divide(eCFieldElement6).add(eCFieldElement6);
                    eCFieldElement4 = curve.fromBigInteger(ECConstants.ONE);
                } else {
                    ECFieldElement square2 = add9.square();
                    ECFieldElement multiply3 = add8.multiply(eCFieldElement7);
                    ECFieldElement multiply4 = add8.multiply(eCFieldElement2);
                    ECFieldElement multiply5 = multiply3.multiply(multiply4);
                    if (multiply5.isZero()) {
                        return new F2m(curve, multiply5, curve.getB().sqrt(), this.withCompression);
                    }
                    ECFieldElement multiply6 = add8.multiply(square2);
                    eCFieldElement4 = !isOne3 ? multiply6.multiply(eCFieldElement18) : multiply6;
                    ECFieldElement squarePlusProduct = multiply4.add(square2).squarePlusProduct(eCFieldElement4, eCFieldElement15.add(eCFieldElement16));
                    if (!isOne2) {
                        eCFieldElement4 = eCFieldElement4.multiply(eCFieldElement16);
                    }
                    eCFieldElement5 = squarePlusProduct;
                    eCFieldElement6 = multiply5;
                }
                return new F2m(curve, eCFieldElement6, eCFieldElement5, new ECFieldElement[]{eCFieldElement4}, this.withCompression);
            }
        }

        /* access modifiers changed from: protected */
        public ECPoint detach() {
            return new F2m((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        /* access modifiers changed from: protected */
        public boolean getCompressionYTilde() {
            ECFieldElement rawXCoord = getRawXCoord();
            if (rawXCoord.isZero()) {
                return false;
            }
            ECFieldElement rawYCoord = getRawYCoord();
            switch (getCurveCoordinateSystem()) {
                case 5:
                case 6:
                    return rawYCoord.testBitZero() != rawXCoord.testBitZero();
                default:
                    return rawYCoord.divide(rawXCoord).testBitZero();
            }
        }

        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            switch (curveCoordinateSystem) {
                case 5:
                case 6:
                    ECFieldElement eCFieldElement = this.f8001x;
                    ECFieldElement eCFieldElement2 = this.f8002y;
                    if (isInfinity() || eCFieldElement.isZero()) {
                        return eCFieldElement2;
                    }
                    ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
                    if (6 != curveCoordinateSystem) {
                        return multiply;
                    }
                    ECFieldElement eCFieldElement3 = this.f8003zs[0];
                    return !eCFieldElement3.isOne() ? multiply.divide(eCFieldElement3) : multiply;
                default:
                    return this.f8002y;
            }
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f8001x;
            if (eCFieldElement.isZero()) {
                return this;
            }
            switch (getCurveCoordinateSystem()) {
                case 0:
                    return new F2m(this.curve, eCFieldElement, this.f8002y.add(eCFieldElement), this.withCompression);
                case 1:
                    ECFieldElement eCFieldElement2 = this.f8002y;
                    ECFieldElement eCFieldElement3 = this.f8003zs[0];
                    return new F2m(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement), new ECFieldElement[]{eCFieldElement3}, this.withCompression);
                case 5:
                    return new F2m(this.curve, eCFieldElement, this.f8002y.addOne(), this.withCompression);
                case 6:
                    ECFieldElement eCFieldElement4 = this.f8002y;
                    ECFieldElement eCFieldElement5 = this.f8003zs[0];
                    return new F2m(this.curve, eCFieldElement, eCFieldElement4.add(eCFieldElement5), new ECFieldElement[]{eCFieldElement5}, this.withCompression);
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement2 = this.f8001x;
            if (eCFieldElement2.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 6) {
                switch (coordinateSystem) {
                    case 0:
                        ECFieldElement add = this.f8002y.divide(eCFieldElement2).add(eCFieldElement2);
                        ECFieldElement add2 = add.square().add(add).add(curve.getA());
                        return new F2m(curve, add2, eCFieldElement2.squarePlusProduct(add2, add.addOne()), this.withCompression);
                    case 1:
                        ECFieldElement eCFieldElement3 = this.f8002y;
                        ECFieldElement eCFieldElement4 = this.f8003zs[0];
                        boolean isOne = eCFieldElement4.isOne();
                        ECFieldElement multiply = isOne ? eCFieldElement2 : eCFieldElement2.multiply(eCFieldElement4);
                        if (!isOne) {
                            eCFieldElement3 = eCFieldElement3.multiply(eCFieldElement4);
                        }
                        ECFieldElement square = eCFieldElement2.square();
                        ECFieldElement add3 = square.add(eCFieldElement3);
                        ECFieldElement square2 = multiply.square();
                        ECFieldElement add4 = add3.add(multiply);
                        ECFieldElement multiplyPlusProduct = add4.multiplyPlusProduct(add3, square2, curve.getA());
                        return new F2m(curve, multiply.multiply(multiplyPlusProduct), square.square().multiplyPlusProduct(multiply, multiplyPlusProduct, add4), new ECFieldElement[]{multiply.multiply(square2)}, this.withCompression);
                    default:
                        throw new IllegalStateException("unsupported coordinate system");
                }
            } else {
                ECFieldElement eCFieldElement5 = this.f8002y;
                ECFieldElement eCFieldElement6 = this.f8003zs[0];
                boolean isOne2 = eCFieldElement6.isOne();
                ECFieldElement multiply2 = isOne2 ? eCFieldElement5 : eCFieldElement5.multiply(eCFieldElement6);
                ECFieldElement square3 = isOne2 ? eCFieldElement6 : eCFieldElement6.square();
                ECFieldElement a = curve.getA();
                ECFieldElement multiply3 = isOne2 ? a : a.multiply(square3);
                ECFieldElement add5 = eCFieldElement5.square().add(multiply2).add(multiply3);
                if (add5.isZero()) {
                    return new F2m(curve, add5, curve.getB().sqrt(), this.withCompression);
                }
                ECFieldElement square4 = add5.square();
                ECFieldElement multiply4 = isOne2 ? add5 : add5.multiply(square3);
                ECFieldElement b = curve.getB();
                ECCurve eCCurve = curve;
                if (b.bitLength() < (curve.getFieldSize() >> 1)) {
                    ECFieldElement square5 = eCFieldElement5.add(eCFieldElement2).square();
                    eCFieldElement = square5.add(add5).add(square3).multiply(square5).add(b.isOne() ? multiply3.add(square3).square() : multiply3.squarePlusProduct(b, square3.square())).add(square4);
                    if (!a.isZero()) {
                        if (!a.isOne()) {
                            eCFieldElement = eCFieldElement.add(a.addOne().multiply(multiply4));
                        }
                        return new F2m(eCCurve, square4, eCFieldElement, new ECFieldElement[]{multiply4}, this.withCompression);
                    }
                } else {
                    if (!isOne2) {
                        eCFieldElement2 = eCFieldElement2.multiply(eCFieldElement6);
                    }
                    eCFieldElement = eCFieldElement2.squarePlusProduct(add5, multiply2).add(square4);
                }
                eCFieldElement = eCFieldElement.add(multiply4);
                return new F2m(eCCurve, square4, eCFieldElement, new ECFieldElement[]{multiply4}, this.withCompression);
            }
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
            if (curve.getCoordinateSystem() != 6) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = eCPoint.f8001x;
            ECFieldElement eCFieldElement3 = eCPoint.f8003zs[0];
            if (eCFieldElement2.isZero() || !eCFieldElement3.isOne()) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement4 = this.f8002y;
            ECFieldElement eCFieldElement5 = this.f8003zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.f8002y;
            ECFieldElement square = eCFieldElement.square();
            ECFieldElement square2 = eCFieldElement4.square();
            ECFieldElement square3 = eCFieldElement5.square();
            ECFieldElement add = curve.getA().multiply(square3).add(square2).add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement addOne = eCFieldElement6.addOne();
            ECFieldElement multiplyPlusProduct = curve.getA().add(addOne).multiply(square3).add(square2).multiplyPlusProduct(add, square, square3);
            ECFieldElement multiply = eCFieldElement2.multiply(square3);
            ECFieldElement square4 = multiply.add(add).square();
            if (square4.isZero()) {
                return multiplyPlusProduct.isZero() ? eCPoint.twice() : curve.getInfinity();
            }
            if (multiplyPlusProduct.isZero()) {
                return new F2m(curve, multiplyPlusProduct, curve.getB().sqrt(), this.withCompression);
            }
            ECFieldElement multiply2 = multiplyPlusProduct.square().multiply(multiply);
            ECFieldElement multiply3 = multiplyPlusProduct.multiply(square4).multiply(square3);
            return new F2m(curve, multiply2, multiplyPlusProduct.add(square4).square().multiplyPlusProduct(add, addOne, multiply3), new ECFieldElement[]{multiply3}, this.withCompression);
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$Fp */
    public static class C3630Fp extends AbstractFp {
        public C3630Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public C3630Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        C3630Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }

        /* JADX WARNING: type inference failed for: r17v0, types: [org.spongycastle.math.ec.ECPoint] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x01fe  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x020c  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.spongycastle.math.p186ec.ECPoint add(org.spongycastle.math.p186ec.ECPoint r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                boolean r2 = r16.isInfinity()
                if (r2 == 0) goto L_0x000b
                return r1
            L_0x000b:
                boolean r2 = r17.isInfinity()
                if (r2 == 0) goto L_0x0012
                return r0
            L_0x0012:
                if (r0 != r1) goto L_0x0019
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0019:
                org.spongycastle.math.ec.ECCurve r3 = r16.getCurve()
                int r2 = r3.getCoordinateSystem()
                org.spongycastle.math.ec.ECFieldElement r4 = r0.f8001x
                org.spongycastle.math.ec.ECFieldElement r5 = r0.f8002y
                org.spongycastle.math.ec.ECFieldElement r6 = r1.f8001x
                org.spongycastle.math.ec.ECFieldElement r7 = r1.f8002y
                r8 = 4
                r9 = 1
                r10 = 0
                if (r2 == r8) goto L_0x0110
                switch(r2) {
                    case 0: goto L_0x00ce;
                    case 1: goto L_0x0039;
                    case 2: goto L_0x0110;
                    default: goto L_0x0031;
                }
            L_0x0031:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x0039:
                org.spongycastle.math.ec.ECFieldElement[] r2 = r0.f8003zs
                r2 = r2[r10]
                org.spongycastle.math.ec.ECFieldElement[] r1 = r1.f8003zs
                r1 = r1[r10]
                boolean r8 = r2.isOne()
                boolean r11 = r1.isOne()
                if (r8 == 0) goto L_0x004c
                goto L_0x0050
            L_0x004c:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.multiply(r2)
            L_0x0050:
                if (r11 == 0) goto L_0x0053
                goto L_0x0057
            L_0x0053:
                org.spongycastle.math.ec.ECFieldElement r5 = r5.multiply(r1)
            L_0x0057:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.subtract(r5)
                if (r8 == 0) goto L_0x005e
                goto L_0x0062
            L_0x005e:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r2)
            L_0x0062:
                if (r11 == 0) goto L_0x0065
                goto L_0x0069
            L_0x0065:
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r1)
            L_0x0069:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.subtract(r4)
                boolean r12 = r6.isZero()
                if (r12 == 0) goto L_0x0083
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x007e
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x007e:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x0083:
                if (r8 == 0) goto L_0x0087
                r2 = r1
                goto L_0x008e
            L_0x0087:
                if (r11 == 0) goto L_0x008a
                goto L_0x008e
            L_0x008a:
                org.spongycastle.math.ec.ECFieldElement r2 = r2.multiply(r1)
            L_0x008e:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.square()
                org.spongycastle.math.ec.ECFieldElement r8 = r1.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r4 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r2)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r8)
                org.spongycastle.math.ec.ECFieldElement r11 = r0.two(r1)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r11)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r5 = r1.multiplyMinusProduct(r7, r5, r8)
                org.spongycastle.math.ec.ECFieldElement r1 = r8.multiply(r2)
                org.spongycastle.math.ec.ECPoint$Fp r8 = new org.spongycastle.math.ec.ECPoint$Fp
                org.spongycastle.math.ec.ECFieldElement[] r7 = new org.spongycastle.math.p186ec.ECFieldElement[r9]
                r7[r10] = r1
                boolean r1 = r0.withCompression
                r2 = r8
                r4 = r6
                r6 = r7
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r8
            L_0x00ce:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r7.subtract(r5)
                boolean r7 = r1.isZero()
                if (r7 == 0) goto L_0x00ec
                boolean r1 = r2.isZero()
                if (r1 == 0) goto L_0x00e7
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x00e7:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x00ec:
                org.spongycastle.math.ec.ECFieldElement r1 = r2.divide(r1)
                org.spongycastle.math.ec.ECFieldElement r2 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r2 = r2.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r2.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r2)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.subtract(r5)
                org.spongycastle.math.ec.ECPoint$Fp r4 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r5 = r0.withCompression
                r4.<init>(r3, r2, r1, r5)
                return r4
            L_0x0110:
                org.spongycastle.math.ec.ECFieldElement[] r11 = r0.f8003zs
                r11 = r11[r10]
                org.spongycastle.math.ec.ECFieldElement[] r1 = r1.f8003zs
                r1 = r1[r10]
                boolean r12 = r11.isOne()
                if (r12 != 0) goto L_0x0177
                boolean r14 = r11.equals(r1)
                if (r14 == 0) goto L_0x0177
                org.spongycastle.math.ec.ECFieldElement r1 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r12 = r1.isZero()
                if (r12 == 0) goto L_0x0142
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x013d
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x013d:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x0142:
                org.spongycastle.math.ec.ECFieldElement r12 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r12)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r12)
                org.spongycastle.math.ec.ECFieldElement r12 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r5 = r12.multiply(r5)
                org.spongycastle.math.ec.ECFieldElement r12 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r12 = r12.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r6 = r12.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r7)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r5)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r11)
                r5 = r4
                r4 = r6
            L_0x0174:
                r15 = 0
                goto L_0x01fc
            L_0x0177:
                if (r12 == 0) goto L_0x017a
                goto L_0x018a
            L_0x017a:
                org.spongycastle.math.ec.ECFieldElement r14 = r11.square()
                org.spongycastle.math.ec.ECFieldElement r6 = r14.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r14 = r14.multiply(r11)
                org.spongycastle.math.ec.ECFieldElement r7 = r14.multiply(r7)
            L_0x018a:
                boolean r14 = r1.isOne()
                if (r14 == 0) goto L_0x0191
                goto L_0x01a1
            L_0x0191:
                org.spongycastle.math.ec.ECFieldElement r15 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r15.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r15 = r15.multiply(r1)
                org.spongycastle.math.ec.ECFieldElement r5 = r15.multiply(r5)
            L_0x01a1:
                org.spongycastle.math.ec.ECFieldElement r6 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r15 = r6.isZero()
                if (r15 == 0) goto L_0x01bf
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x01ba
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x01ba:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x01bf:
                org.spongycastle.math.ec.ECFieldElement r15 = r6.square()
                org.spongycastle.math.ec.ECFieldElement r13 = r15.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r15.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r9 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r9 = r9.add(r13)
                org.spongycastle.math.ec.ECFieldElement r10 = r0.two(r4)
                org.spongycastle.math.ec.ECFieldElement r9 = r9.subtract(r10)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiplyMinusProduct(r7, r13, r5)
                if (r12 != 0) goto L_0x01ea
                org.spongycastle.math.ec.ECFieldElement r5 = r6.multiply(r11)
                goto L_0x01eb
            L_0x01ea:
                r5 = r6
            L_0x01eb:
                if (r14 != 0) goto L_0x01f2
                org.spongycastle.math.ec.ECFieldElement r1 = r5.multiply(r1)
                goto L_0x01f3
            L_0x01f2:
                r1 = r5
            L_0x01f3:
                if (r1 != r6) goto L_0x01f8
                r5 = r4
                r4 = r9
                goto L_0x01fc
            L_0x01f8:
                r5 = r4
                r4 = r9
                goto L_0x0174
            L_0x01fc:
                if (r2 != r8) goto L_0x020c
                org.spongycastle.math.ec.ECFieldElement r2 = r0.calculateJacobianModifiedW(r1, r15)
                r6 = 2
                org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.p186ec.ECFieldElement[r6]
                r7 = 0
                r6[r7] = r1
                r8 = 1
                r6[r8] = r2
                goto L_0x0213
            L_0x020c:
                r7 = 0
                r8 = 1
                org.spongycastle.math.ec.ECFieldElement[] r2 = new org.spongycastle.math.p186ec.ECFieldElement[r8]
                r2[r7] = r1
                r6 = r2
            L_0x0213:
                org.spongycastle.math.ec.ECPoint$Fp r1 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r7 = r0.withCompression
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p186ec.ECPoint.C3630Fp.add(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
        }

        /* access modifiers changed from: protected */
        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement a = getCurve().getA();
            if (a.isZero() || eCFieldElement.isOne()) {
                return a;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.square();
            }
            ECFieldElement square = eCFieldElement2.square();
            ECFieldElement negate = a.negate();
            return negate.bitLength() < a.bitLength() ? square.multiply(negate).negate() : square.multiply(a);
        }

        /* access modifiers changed from: protected */
        public ECPoint detach() {
            return new C3630Fp((ECCurve) null, getAffineXCoord(), getAffineYCoord());
        }

        /* access modifiers changed from: protected */
        public ECFieldElement doubleProductFromSquares(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3, ECFieldElement eCFieldElement4) {
            return eCFieldElement.add(eCFieldElement2).square().subtract(eCFieldElement3).subtract(eCFieldElement4);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement eight(ECFieldElement eCFieldElement) {
            return four(two(eCFieldElement));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement four(ECFieldElement eCFieldElement) {
            return two(two(eCFieldElement));
        }

        /* access modifiers changed from: protected */
        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement eCFieldElement = this.f8003zs[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement[] eCFieldElementArr = this.f8003zs;
            ECFieldElement calculateJacobianModifiedW = calculateJacobianModifiedW(this.f8003zs[0], (ECFieldElement) null);
            eCFieldElementArr[1] = calculateJacobianModifiedW;
            return calculateJacobianModifiedW;
        }

        public ECFieldElement getZCoord(int i) {
            return (i == 1 && 4 == getCurveCoordinateSystem()) ? getJacobianModifiedW() : super.getZCoord(i);
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            return curve.getCoordinateSystem() != 0 ? new C3630Fp(curve, this.f8001x, this.f8002y.negate(), this.f8003zs, this.withCompression) : new C3630Fp(curve, this.f8001x, this.f8002y.negate(), this.withCompression);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement three(ECFieldElement eCFieldElement) {
            return two(eCFieldElement).add(eCFieldElement);
        }

        public ECPoint threeTimes() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.f8002y;
            if (eCFieldElement.isZero()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(this) : twiceJacobianModified(false).add(this);
            }
            ECFieldElement eCFieldElement2 = this.f8001x;
            ECFieldElement two = two(eCFieldElement);
            ECFieldElement square = two.square();
            ECFieldElement add = three(eCFieldElement2.square()).add(getCurve().getA());
            ECFieldElement subtract = three(eCFieldElement2).multiply(square).subtract(add.square());
            if (subtract.isZero()) {
                return getCurve().getInfinity();
            }
            ECFieldElement invert = subtract.multiply(two).invert();
            ECFieldElement multiply = subtract.multiply(invert).multiply(add);
            ECFieldElement subtract2 = square.square().multiply(invert).subtract(multiply);
            ECFieldElement add2 = subtract2.subtract(multiply).multiply(multiply.add(subtract2)).add(eCFieldElement2);
            return new C3630Fp(curve, add2, eCFieldElement2.subtract(add2).multiply(subtract2).subtract(eCFieldElement), this.withCompression);
        }

        public ECPoint timesPow2(int i) {
            ECFieldElement eCFieldElement;
            if (i < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            } else if (i == 0 || isInfinity()) {
                return this;
            } else {
                if (i == 1) {
                    return twice();
                }
                ECCurve curve = getCurve();
                ECFieldElement eCFieldElement2 = this.f8002y;
                if (eCFieldElement2.isZero()) {
                    return curve.getInfinity();
                }
                int coordinateSystem = curve.getCoordinateSystem();
                ECFieldElement a = curve.getA();
                ECFieldElement eCFieldElement3 = this.f8001x;
                ECFieldElement fromBigInteger = this.f8003zs.length < 1 ? curve.fromBigInteger(ECConstants.ONE) : this.f8003zs[0];
                if (!fromBigInteger.isOne()) {
                    if (coordinateSystem != 4) {
                        switch (coordinateSystem) {
                            case 0:
                                break;
                            case 1:
                                eCFieldElement = fromBigInteger.square();
                                eCFieldElement3 = eCFieldElement3.multiply(fromBigInteger);
                                eCFieldElement2 = eCFieldElement2.multiply(eCFieldElement);
                                break;
                            case 2:
                                eCFieldElement = null;
                                break;
                            default:
                                throw new IllegalStateException("unsupported coordinate system");
                        }
                        a = calculateJacobianModifiedW(fromBigInteger, eCFieldElement);
                    } else {
                        a = getJacobianModifiedW();
                    }
                }
                ECFieldElement eCFieldElement4 = a;
                ECFieldElement eCFieldElement5 = eCFieldElement2;
                int i2 = 0;
                while (i2 < i) {
                    if (eCFieldElement5.isZero()) {
                        return curve.getInfinity();
                    }
                    ECFieldElement three = three(eCFieldElement3.square());
                    ECFieldElement two = two(eCFieldElement5);
                    ECFieldElement multiply = two.multiply(eCFieldElement5);
                    ECFieldElement two2 = two(eCFieldElement3.multiply(multiply));
                    ECFieldElement two3 = two(multiply.square());
                    if (!eCFieldElement4.isZero()) {
                        three = three.add(eCFieldElement4);
                        eCFieldElement4 = two(two3.multiply(eCFieldElement4));
                    }
                    ECFieldElement subtract = three.square().subtract(two(two2));
                    eCFieldElement5 = three.multiply(two2.subtract(subtract)).subtract(two3);
                    fromBigInteger = fromBigInteger.isOne() ? two : two.multiply(fromBigInteger);
                    i2++;
                    eCFieldElement3 = subtract;
                }
                if (coordinateSystem != 4) {
                    switch (coordinateSystem) {
                        case 0:
                            ECFieldElement invert = fromBigInteger.invert();
                            ECFieldElement square = invert.square();
                            return new C3630Fp(curve, eCFieldElement3.multiply(square), eCFieldElement5.multiply(square.multiply(invert)), this.withCompression);
                        case 1:
                            return new C3630Fp(curve, eCFieldElement3.multiply(fromBigInteger), eCFieldElement5, new ECFieldElement[]{fromBigInteger.multiply(fromBigInteger.square())}, this.withCompression);
                        case 2:
                            return new C3630Fp(curve, eCFieldElement3, eCFieldElement5, new ECFieldElement[]{fromBigInteger}, this.withCompression);
                        default:
                            throw new IllegalStateException("unsupported coordinate system");
                    }
                } else {
                    return new C3630Fp(curve, eCFieldElement3, eCFieldElement5, new ECFieldElement[]{fromBigInteger, eCFieldElement4}, this.withCompression);
                }
            }
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement3 = this.f8002y;
            if (eCFieldElement3.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement4 = this.f8001x;
            if (coordinateSystem == 4) {
                return twiceJacobianModified(true);
            }
            switch (coordinateSystem) {
                case 0:
                    ECFieldElement divide = three(eCFieldElement4.square()).add(getCurve().getA()).divide(two(eCFieldElement3));
                    ECFieldElement subtract = divide.square().subtract(two(eCFieldElement4));
                    return new C3630Fp(curve, subtract, divide.multiply(eCFieldElement4.subtract(subtract)).subtract(eCFieldElement3), this.withCompression);
                case 1:
                    ECFieldElement eCFieldElement5 = this.f8003zs[0];
                    boolean isOne = eCFieldElement5.isOne();
                    ECFieldElement a = curve.getA();
                    if (!a.isZero() && !isOne) {
                        a = a.multiply(eCFieldElement5.square());
                    }
                    ECFieldElement add = a.add(three(eCFieldElement4.square()));
                    ECFieldElement multiply = isOne ? eCFieldElement3 : eCFieldElement3.multiply(eCFieldElement5);
                    ECFieldElement square = isOne ? eCFieldElement3.square() : multiply.multiply(eCFieldElement3);
                    ECFieldElement four = four(eCFieldElement4.multiply(square));
                    ECFieldElement subtract2 = add.square().subtract(two(four));
                    ECFieldElement two = two(multiply);
                    ECFieldElement multiply2 = subtract2.multiply(two);
                    ECFieldElement two2 = two(square);
                    return new C3630Fp(curve, multiply2, four.subtract(subtract2).multiply(add).subtract(two(two2.square())), new ECFieldElement[]{two(isOne ? two(two2) : two.square()).multiply(multiply)}, this.withCompression);
                case 2:
                    ECFieldElement eCFieldElement6 = this.f8003zs[0];
                    boolean isOne2 = eCFieldElement6.isOne();
                    ECFieldElement square2 = eCFieldElement3.square();
                    ECFieldElement square3 = square2.square();
                    ECFieldElement a2 = curve.getA();
                    ECFieldElement negate = a2.negate();
                    if (negate.toBigInteger().equals(BigInteger.valueOf(3))) {
                        ECFieldElement square4 = isOne2 ? eCFieldElement6 : eCFieldElement6.square();
                        eCFieldElement = three(eCFieldElement4.add(square4).multiply(eCFieldElement4.subtract(square4)));
                        eCFieldElement2 = square2.multiply(eCFieldElement4);
                    } else {
                        ECFieldElement three = three(eCFieldElement4.square());
                        if (!isOne2) {
                            if (!a2.isZero()) {
                                ECFieldElement square5 = eCFieldElement6.square().square();
                                if (negate.bitLength() < a2.bitLength()) {
                                    eCFieldElement = three.subtract(square5.multiply(negate));
                                } else {
                                    a2 = square5.multiply(a2);
                                }
                            } else {
                                eCFieldElement = three;
                            }
                            eCFieldElement2 = eCFieldElement4.multiply(square2);
                        }
                        eCFieldElement = three.add(a2);
                        eCFieldElement2 = eCFieldElement4.multiply(square2);
                    }
                    ECFieldElement four2 = four(eCFieldElement2);
                    ECFieldElement subtract3 = eCFieldElement.square().subtract(two(four2));
                    ECFieldElement subtract4 = four2.subtract(subtract3).multiply(eCFieldElement).subtract(eight(square3));
                    ECFieldElement two3 = two(eCFieldElement3);
                    if (!isOne2) {
                        two3 = two3.multiply(eCFieldElement6);
                    }
                    return new C3630Fp(curve, subtract3, subtract4, new ECFieldElement[]{two3}, this.withCompression);
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }

        /* access modifiers changed from: protected */
        public C3630Fp twiceJacobianModified(boolean z) {
            ECFieldElement eCFieldElement = this.f8001x;
            ECFieldElement eCFieldElement2 = this.f8002y;
            ECFieldElement eCFieldElement3 = this.f8003zs[0];
            ECFieldElement jacobianModifiedW = getJacobianModifiedW();
            ECFieldElement add = three(eCFieldElement.square()).add(jacobianModifiedW);
            ECFieldElement two = two(eCFieldElement2);
            ECFieldElement multiply = two.multiply(eCFieldElement2);
            ECFieldElement two2 = two(eCFieldElement.multiply(multiply));
            ECFieldElement subtract = add.square().subtract(two(two2));
            ECFieldElement two3 = two(multiply.square());
            ECFieldElement subtract2 = add.multiply(two2.subtract(subtract)).subtract(two3);
            ECFieldElement two4 = z ? two(two3.multiply(jacobianModifiedW)) : null;
            if (!eCFieldElement3.isOne()) {
                two = two.multiply(eCFieldElement3);
            }
            return new C3630Fp(getCurve(), subtract, subtract2, new ECFieldElement[]{two, two4}, this.withCompression);
        }

        public ECPoint twicePlus(ECPoint eCPoint) {
            if (this == eCPoint) {
                return threeTimes();
            }
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return twice();
            }
            ECFieldElement eCFieldElement = this.f8002y;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(eCPoint) : twiceJacobianModified(false).add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = this.f8001x;
            ECFieldElement eCFieldElement3 = eCPoint.f8001x;
            ECFieldElement eCFieldElement4 = eCPoint.f8002y;
            ECFieldElement subtract = eCFieldElement3.subtract(eCFieldElement2);
            ECFieldElement subtract2 = eCFieldElement4.subtract(eCFieldElement);
            if (subtract.isZero()) {
                return subtract2.isZero() ? threeTimes() : this;
            }
            ECFieldElement square = subtract.square();
            ECFieldElement subtract3 = square.multiply(two(eCFieldElement2).add(eCFieldElement3)).subtract(subtract2.square());
            if (subtract3.isZero()) {
                return curve.getInfinity();
            }
            ECFieldElement invert = subtract3.multiply(subtract).invert();
            ECFieldElement multiply = subtract3.multiply(invert).multiply(subtract2);
            ECFieldElement subtract4 = two(eCFieldElement).multiply(square).multiply(subtract).multiply(invert).subtract(multiply);
            ECFieldElement add = subtract4.subtract(multiply).multiply(multiply.add(subtract4)).add(eCFieldElement3);
            return new C3630Fp(curve, add, eCFieldElement2.subtract(add).multiply(subtract4).subtract(eCFieldElement), this.withCompression);
        }

        /* access modifiers changed from: protected */
        public ECFieldElement two(ECFieldElement eCFieldElement) {
            return eCFieldElement.add(eCFieldElement);
        }
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, getInitialZCoords(eCCurve));
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.preCompTable = null;
        this.curve = eCCurve;
        this.f8001x = eCFieldElement;
        this.f8002y = eCFieldElement2;
        this.f8003zs = eCFieldElementArr;
    }

    protected static ECFieldElement[] getInitialZCoords(ECCurve eCCurve) {
        int coordinateSystem = eCCurve == null ? 0 : eCCurve.getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            return EMPTY_ZS;
        }
        ECFieldElement fromBigInteger = eCCurve.fromBigInteger(ECConstants.ONE);
        if (coordinateSystem != 6) {
            switch (coordinateSystem) {
                case 1:
                case 2:
                    break;
                case 3:
                    return new ECFieldElement[]{fromBigInteger, fromBigInteger, fromBigInteger};
                case 4:
                    return new ECFieldElement[]{fromBigInteger, eCCurve.getA()};
                default:
                    throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new ECFieldElement[]{fromBigInteger};
    }

    public abstract ECPoint add(ECPoint eCPoint);

    /* access modifiers changed from: protected */
    public void checkNormalized() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* access modifiers changed from: protected */
    public ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().multiply(eCFieldElement2), this.withCompression);
    }

    /* access modifiers changed from: protected */
    public abstract ECPoint detach();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint)) {
            return false;
        }
        return equals((ECPoint) obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(org.spongycastle.math.p186ec.ECPoint r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            org.spongycastle.math.ec.ECCurve r1 = r9.getCurve()
            org.spongycastle.math.ec.ECCurve r2 = r10.getCurve()
            r3 = 1
            if (r1 != 0) goto L_0x0011
            r4 = 1
            goto L_0x0012
        L_0x0011:
            r4 = 0
        L_0x0012:
            if (r2 != 0) goto L_0x0016
            r5 = 1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            boolean r6 = r9.isInfinity()
            boolean r7 = r10.isInfinity()
            if (r6 != 0) goto L_0x0073
            if (r7 == 0) goto L_0x0024
            goto L_0x0073
        L_0x0024:
            if (r4 == 0) goto L_0x0029
            if (r5 == 0) goto L_0x0029
            goto L_0x002f
        L_0x0029:
            if (r4 == 0) goto L_0x0032
            org.spongycastle.math.ec.ECPoint r10 = r10.normalize()
        L_0x002f:
            r1 = r10
            r10 = r9
            goto L_0x0055
        L_0x0032:
            if (r5 == 0) goto L_0x003c
            org.spongycastle.math.ec.ECPoint r1 = r9.normalize()
            r8 = r1
            r1 = r10
            r10 = r8
            goto L_0x0055
        L_0x003c:
            boolean r2 = r1.equals((org.spongycastle.math.p186ec.ECCurve) r2)
            if (r2 != 0) goto L_0x0043
            return r0
        L_0x0043:
            r2 = 2
            org.spongycastle.math.ec.ECPoint[] r2 = new org.spongycastle.math.p186ec.ECPoint[r2]
            r2[r0] = r9
            org.spongycastle.math.ec.ECPoint r10 = r1.importPoint(r10)
            r2[r3] = r10
            r1.normalizeAll(r2)
            r10 = r2[r0]
            r1 = r2[r3]
        L_0x0055:
            org.spongycastle.math.ec.ECFieldElement r2 = r10.getXCoord()
            org.spongycastle.math.ec.ECFieldElement r4 = r1.getXCoord()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0072
            org.spongycastle.math.ec.ECFieldElement r10 = r10.getYCoord()
            org.spongycastle.math.ec.ECFieldElement r1 = r1.getYCoord()
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0072
            r0 = 1
        L_0x0072:
            return r0
        L_0x0073:
            if (r6 == 0) goto L_0x0082
            if (r7 == 0) goto L_0x0082
            if (r4 != 0) goto L_0x0081
            if (r5 != 0) goto L_0x0081
            boolean r10 = r1.equals((org.spongycastle.math.p186ec.ECCurve) r2)
            if (r10 == 0) goto L_0x0082
        L_0x0081:
            r0 = 1
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p186ec.ECPoint.equals(org.spongycastle.math.ec.ECPoint):boolean");
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    /* access modifiers changed from: protected */
    public abstract boolean getCompressionYTilde();

    public ECCurve getCurve() {
        return this.curve;
    }

    /* access modifiers changed from: protected */
    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.getCoordinateSystem();
    }

    public final ECPoint getDetachedPoint() {
        return normalize().detach();
    }

    public byte[] getEncoded() {
        return getEncoded(this.withCompression);
    }

    public byte[] getEncoded(boolean z) {
        if (isInfinity()) {
            return new byte[1];
        }
        ECPoint normalize = normalize();
        byte[] encoded = normalize.getXCoord().getEncoded();
        if (z) {
            byte[] bArr = new byte[(encoded.length + 1)];
            bArr[0] = (byte) (normalize.getCompressionYTilde() ? 3 : 2);
            System.arraycopy(encoded, 0, bArr, 1, encoded.length);
            return bArr;
        }
        byte[] encoded2 = normalize.getYCoord().getEncoded();
        byte[] bArr2 = new byte[(encoded.length + encoded2.length + 1)];
        bArr2[0] = 4;
        System.arraycopy(encoded, 0, bArr2, 1, encoded.length);
        System.arraycopy(encoded2, 0, bArr2, encoded.length + 1, encoded2.length);
        return bArr2;
    }

    public final ECFieldElement getRawXCoord() {
        return this.f8001x;
    }

    public final ECFieldElement getRawYCoord() {
        return this.f8002y;
    }

    /* access modifiers changed from: protected */
    public final ECFieldElement[] getRawZCoords() {
        return this.f8003zs;
    }

    public ECFieldElement getX() {
        return normalize().getXCoord();
    }

    public ECFieldElement getXCoord() {
        return this.f8001x;
    }

    public ECFieldElement getY() {
        return normalize().getYCoord();
    }

    public ECFieldElement getYCoord() {
        return this.f8002y;
    }

    public ECFieldElement getZCoord(int i) {
        if (i >= 0) {
            ECFieldElement[] eCFieldElementArr = this.f8003zs;
            if (i < eCFieldElementArr.length) {
                return eCFieldElementArr[i];
            }
        }
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] eCFieldElementArr = this.f8003zs;
        int length = eCFieldElementArr.length;
        if (length == 0) {
            return EMPTY_ZS;
        }
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[length];
        System.arraycopy(eCFieldElementArr, 0, eCFieldElementArr2, 0, length);
        return eCFieldElementArr2;
    }

    public int hashCode() {
        ECCurve curve2 = getCurve();
        int i = curve2 == null ? 0 : ~curve2.hashCode();
        if (isInfinity()) {
            return i;
        }
        ECPoint normalize = normalize();
        return (i ^ (normalize.getXCoord().hashCode() * 17)) ^ (normalize.getYCoord().hashCode() * 257);
    }

    public boolean isCompressed() {
        return this.withCompression;
    }

    public boolean isInfinity() {
        if (!(this.f8001x == null || this.f8002y == null)) {
            ECFieldElement[] eCFieldElementArr = this.f8003zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isNormalized() {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        return curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || isInfinity() || this.f8003zs[0].isOne();
    }

    public boolean isValid() {
        return isInfinity() || getCurve() == null || (satisfiesCurveEquation() && satisfiesCofactor());
    }

    public ECPoint multiply(BigInteger bigInteger) {
        return getCurve().getMultiplier().multiply(this, bigInteger);
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        int curveCoordinateSystem;
        if (isInfinity() || (curveCoordinateSystem = getCurveCoordinateSystem()) == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        return zCoord.isOne() ? this : normalize(zCoord.invert());
    }

    /* access modifiers changed from: package-private */
    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 6) {
            switch (curveCoordinateSystem) {
                case 1:
                    break;
                case 2:
                case 3:
                case 4:
                    ECFieldElement square = eCFieldElement.square();
                    return createScaledPoint(square, square.multiply(eCFieldElement));
                default:
                    throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }

    /* access modifiers changed from: protected */
    public boolean satisfiesCofactor() {
        BigInteger cofactor = this.curve.getCofactor();
        return cofactor == null || cofactor.equals(ECConstants.ONE) || !ECAlgorithms.referenceMultiply(this, cofactor).isInfinity();
    }

    /* access modifiers changed from: protected */
    public abstract boolean satisfiesCurveEquation();

    public ECPoint scaleX(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord(), getRawZCoords(), this.withCompression);
    }

    public ECPoint scaleY(ECFieldElement eCFieldElement) {
        return isInfinity() ? this : getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(eCFieldElement), getRawZCoords(), this.withCompression);
    }

    public abstract ECPoint subtract(ECPoint eCPoint);

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint timesPow2(int i) {
        if (i >= 0) {
            ECPoint eCPoint = this;
            while (true) {
                i--;
                if (i < 0) {
                    return eCPoint;
                }
                eCPoint = eCPoint.twice();
            }
        } else {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(getRawXCoord());
        stringBuffer.append(',');
        stringBuffer.append(getRawYCoord());
        for (ECFieldElement append : this.f8003zs) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint eCPoint) {
        return twice().add(eCPoint);
    }
}

package org.spongycastle.math.p186ec.custom.sec;

import org.spongycastle.math.p186ec.ECCurve;
import org.spongycastle.math.p186ec.ECFieldElement;
import org.spongycastle.math.p186ec.ECPoint;
import org.spongycastle.math.raw.Nat;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP521R1Point */
public class SecP521R1Point extends ECPoint.AbstractFp {
    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [org.spongycastle.math.ec.ECPoint] */
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
            org.spongycastle.math.ec.ECFieldElement r2 = r0.f8001x
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r2 = (org.spongycastle.math.p186ec.custom.sec.SecP521R1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f8002y
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r4 = (org.spongycastle.math.p186ec.custom.sec.SecP521R1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r17.getXCoord()
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r5 = (org.spongycastle.math.p186ec.custom.sec.SecP521R1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r17.getYCoord()
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r6 = (org.spongycastle.math.p186ec.custom.sec.SecP521R1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f8003zs
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r7 = (org.spongycastle.math.p186ec.custom.sec.SecP521R1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r1.getZCoord(r8)
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r1 = (org.spongycastle.math.p186ec.custom.sec.SecP521R1FieldElement) r1
            r9 = 17
            int[] r10 = org.spongycastle.math.raw.Nat.create(r9)
            int[] r11 = org.spongycastle.math.raw.Nat.create(r9)
            int[] r12 = org.spongycastle.math.raw.Nat.create(r9)
            int[] r13 = org.spongycastle.math.raw.Nat.create(r9)
            boolean r14 = r7.isOne()
            if (r14 == 0) goto L_0x005b
            int[] r5 = r5.f8075x
            int[] r6 = r6.f8075x
            goto L_0x0071
        L_0x005b:
            int[] r15 = r7.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.square(r15, r12)
            int[] r5 = r5.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r12, r5, r11)
            int[] r5 = r7.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r12, r5, r12)
            int[] r5 = r6.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x0071:
            boolean r15 = r1.isOne()
            if (r15 == 0) goto L_0x007c
            int[] r2 = r2.f8075x
            int[] r4 = r4.f8075x
            goto L_0x0092
        L_0x007c:
            int[] r8 = r1.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.square(r8, r13)
            int[] r2 = r2.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r13, r2, r10)
            int[] r2 = r1.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r13, r2, r13)
            int[] r2 = r4.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r13, r2, r13)
            r2 = r10
            r4 = r13
        L_0x0092:
            int[] r8 = org.spongycastle.math.raw.Nat.create(r9)
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.subtract(r2, r5, r8)
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.subtract(r4, r6, r11)
            boolean r5 = org.spongycastle.math.raw.Nat.isZero(r9, r8)
            if (r5 == 0) goto L_0x00b2
            boolean r1 = org.spongycastle.math.raw.Nat.isZero(r9, r11)
            if (r1 == 0) goto L_0x00ad
            org.spongycastle.math.ec.ECPoint r1 = r16.twice()
            return r1
        L_0x00ad:
            org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
            return r1
        L_0x00b2:
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.square(r8, r12)
            int[] r5 = org.spongycastle.math.raw.Nat.create(r9)
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r12, r8, r5)
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r12, r2, r12)
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r4, r5, r10)
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement
            r4.<init>((int[]) r13)
            int[] r2 = r4.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.square(r11, r2)
            int[] r2 = r4.f8075x
            int[] r6 = r4.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.add(r2, r5, r6)
            int[] r2 = r4.f8075x
            int[] r6 = r4.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.subtract(r2, r12, r6)
            int[] r2 = r4.f8075x
            int[] r6 = r4.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.subtract(r2, r12, r6)
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r6 = new org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement
            r6.<init>((int[]) r5)
            int[] r2 = r4.f8075x
            int[] r5 = r6.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.subtract(r12, r2, r5)
            int[] r2 = r6.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r2, r11, r11)
            int[] r2 = r6.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.subtract(r11, r10, r2)
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement
            r2.<init>((int[]) r8)
            if (r14 != 0) goto L_0x0107
            int[] r5 = r2.f8075x
            int[] r7 = r7.f8075x
            int[] r8 = r2.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r5, r7, r8)
        L_0x0107:
            if (r15 != 0) goto L_0x0112
            int[] r5 = r2.f8075x
            int[] r1 = r1.f8075x
            int[] r7 = r2.f8075x
            org.spongycastle.math.p186ec.custom.sec.SecP521R1Field.multiply(r5, r1, r7)
        L_0x0112:
            r1 = 1
            org.spongycastle.math.ec.ECFieldElement[] r1 = new org.spongycastle.math.p186ec.ECFieldElement[r1]
            r5 = 0
            r1[r5] = r2
            org.spongycastle.math.ec.custom.sec.SecP521R1Point r8 = new org.spongycastle.math.ec.custom.sec.SecP521R1Point
            boolean r7 = r0.withCompression
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p186ec.custom.sec.SecP521R1Point.add(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecP521R1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
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

    public ECPoint negate() {
        return isInfinity() ? this : new SecP521R1Point(this.curve, this.f8001x, this.f8002y.negate(), this.f8003zs, this.withCompression);
    }

    /* access modifiers changed from: protected */
    public ECFieldElement three(ECFieldElement eCFieldElement) {
        return two(eCFieldElement).add(eCFieldElement);
    }

    public ECPoint threeTimes() {
        return (isInfinity() || this.f8002y.isZero()) ? this : twice().add(this);
    }

    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement) this.f8002y;
        if (secP521R1FieldElement.isZero()) {
            return curve.getInfinity();
        }
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement) this.f8001x;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement) this.f8003zs[0];
        int[] create = Nat.create(17);
        int[] create2 = Nat.create(17);
        int[] create3 = Nat.create(17);
        SecP521R1Field.square(secP521R1FieldElement.f8075x, create3);
        int[] create4 = Nat.create(17);
        SecP521R1Field.square(create3, create4);
        boolean isOne = secP521R1FieldElement3.isOne();
        int[] iArr = secP521R1FieldElement3.f8075x;
        if (!isOne) {
            SecP521R1Field.square(secP521R1FieldElement3.f8075x, create2);
            iArr = create2;
        }
        SecP521R1Field.subtract(secP521R1FieldElement2.f8075x, iArr, create);
        SecP521R1Field.add(secP521R1FieldElement2.f8075x, iArr, create2);
        SecP521R1Field.multiply(create2, create, create2);
        Nat.addBothTo(17, create2, create2, create2);
        SecP521R1Field.reduce23(create2);
        SecP521R1Field.multiply(create3, secP521R1FieldElement2.f8075x, create3);
        Nat.shiftUpBits(17, create3, 2, 0);
        SecP521R1Field.reduce23(create3);
        Nat.shiftUpBits(17, create4, 3, 0, create);
        SecP521R1Field.reduce23(create);
        SecP521R1FieldElement secP521R1FieldElement4 = new SecP521R1FieldElement(create4);
        SecP521R1Field.square(create2, secP521R1FieldElement4.f8075x);
        SecP521R1Field.subtract(secP521R1FieldElement4.f8075x, create3, secP521R1FieldElement4.f8075x);
        SecP521R1Field.subtract(secP521R1FieldElement4.f8075x, create3, secP521R1FieldElement4.f8075x);
        SecP521R1FieldElement secP521R1FieldElement5 = new SecP521R1FieldElement(create3);
        SecP521R1Field.subtract(create3, secP521R1FieldElement4.f8075x, secP521R1FieldElement5.f8075x);
        SecP521R1Field.multiply(secP521R1FieldElement5.f8075x, create2, secP521R1FieldElement5.f8075x);
        SecP521R1Field.subtract(secP521R1FieldElement5.f8075x, create, secP521R1FieldElement5.f8075x);
        SecP521R1FieldElement secP521R1FieldElement6 = new SecP521R1FieldElement(create2);
        SecP521R1Field.twice(secP521R1FieldElement.f8075x, secP521R1FieldElement6.f8075x);
        if (!isOne) {
            SecP521R1Field.multiply(secP521R1FieldElement6.f8075x, secP521R1FieldElement3.f8075x, secP521R1FieldElement6.f8075x);
        }
        return new SecP521R1Point(curve, secP521R1FieldElement4, secP521R1FieldElement5, new ECFieldElement[]{secP521R1FieldElement6}, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        return this == eCPoint ? threeTimes() : isInfinity() ? eCPoint : eCPoint.isInfinity() ? twice() : this.f8002y.isZero() ? eCPoint : twice().add(eCPoint);
    }

    /* access modifiers changed from: protected */
    public ECFieldElement two(ECFieldElement eCFieldElement) {
        return eCFieldElement.add(eCFieldElement);
    }
}

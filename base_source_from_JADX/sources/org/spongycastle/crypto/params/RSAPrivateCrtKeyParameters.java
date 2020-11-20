package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* renamed from: dP */
    private BigInteger f7885dP;

    /* renamed from: dQ */
    private BigInteger f7886dQ;

    /* renamed from: e */
    private BigInteger f7887e;

    /* renamed from: p */
    private BigInteger f7888p;

    /* renamed from: q */
    private BigInteger f7889q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f7887e = bigInteger2;
        this.f7888p = bigInteger4;
        this.f7889q = bigInteger5;
        this.f7885dP = bigInteger6;
        this.f7886dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.f7885dP;
    }

    public BigInteger getDQ() {
        return this.f7886dQ;
    }

    public BigInteger getP() {
        return this.f7888p;
    }

    public BigInteger getPublicExponent() {
        return this.f7887e;
    }

    public BigInteger getQ() {
        return this.f7889q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}

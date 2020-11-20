package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f7975a;

    /* renamed from: p */
    private BigInteger f7976p;

    /* renamed from: q */
    private BigInteger f7977q;

    /* renamed from: x */
    private BigInteger f7978x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f7978x = bigInteger;
        this.f7976p = bigInteger2;
        this.f7977q = bigInteger3;
        this.f7975a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f7975a;
    }

    public BigInteger getP() {
        return this.f7976p;
    }

    public BigInteger getQ() {
        return this.f7977q;
    }

    public BigInteger getX() {
        return this.f7978x;
    }
}

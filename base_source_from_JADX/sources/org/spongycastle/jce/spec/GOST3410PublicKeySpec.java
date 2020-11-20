package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f7982a;

    /* renamed from: p */
    private BigInteger f7983p;

    /* renamed from: q */
    private BigInteger f7984q;

    /* renamed from: y */
    private BigInteger f7985y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f7985y = bigInteger;
        this.f7983p = bigInteger2;
        this.f7984q = bigInteger3;
        this.f7982a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f7982a;
    }

    public BigInteger getP() {
        return this.f7983p;
    }

    public BigInteger getQ() {
        return this.f7984q;
    }

    public BigInteger getY() {
        return this.f7985y;
    }
}

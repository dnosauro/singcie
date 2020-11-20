package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g */
    private BigInteger f7971g;

    /* renamed from: p */
    private BigInteger f7972p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f7972p = bigInteger;
        this.f7971g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f7971g;
    }

    public BigInteger getP() {
        return this.f7972p;
    }
}

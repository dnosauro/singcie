package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class SRP6GroupParameters {

    /* renamed from: N */
    private BigInteger f7890N;

    /* renamed from: g */
    private BigInteger f7891g;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f7890N = bigInteger;
        this.f7891g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f7891g;
    }

    public BigInteger getN() {
        return this.f7890N;
    }
}

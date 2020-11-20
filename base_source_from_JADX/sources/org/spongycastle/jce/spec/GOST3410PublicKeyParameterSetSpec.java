package org.spongycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a */
    private BigInteger f7979a;

    /* renamed from: p */
    private BigInteger f7980p;

    /* renamed from: q */
    private BigInteger f7981q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f7980p = bigInteger;
        this.f7981q = bigInteger2;
        this.f7979a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        return this.f7979a.equals(gOST3410PublicKeyParameterSetSpec.f7979a) && this.f7980p.equals(gOST3410PublicKeyParameterSetSpec.f7980p) && this.f7981q.equals(gOST3410PublicKeyParameterSetSpec.f7981q);
    }

    public BigInteger getA() {
        return this.f7979a;
    }

    public BigInteger getP() {
        return this.f7980p;
    }

    public BigInteger getQ() {
        return this.f7981q;
    }

    public int hashCode() {
        return (this.f7979a.hashCode() ^ this.f7980p.hashCode()) ^ this.f7981q.hashCode();
    }
}

package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a */
    private BigInteger f7865a;

    /* renamed from: p */
    private BigInteger f7866p;

    /* renamed from: q */
    private BigInteger f7867q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f7866p = bigInteger;
        this.f7867q = bigInteger2;
        this.f7865a = bigInteger3;
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f7865a = bigInteger3;
        this.f7866p = bigInteger;
        this.f7867q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        return gOST3410Parameters.getP().equals(this.f7866p) && gOST3410Parameters.getQ().equals(this.f7867q) && gOST3410Parameters.getA().equals(this.f7865a);
    }

    public BigInteger getA() {
        return this.f7865a;
    }

    public BigInteger getP() {
        return this.f7866p;
    }

    public BigInteger getQ() {
        return this.f7867q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f7866p.hashCode() ^ this.f7867q.hashCode()) ^ this.f7865a.hashCode();
    }
}

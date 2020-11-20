package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f7850g;

    /* renamed from: p */
    private BigInteger f7851p;

    /* renamed from: q */
    private BigInteger f7852q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f7850g = bigInteger3;
        this.f7851p = bigInteger;
        this.f7852q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f7850g = bigInteger3;
        this.f7851p = bigInteger;
        this.f7852q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.getP().equals(this.f7851p) && dSAParameters.getQ().equals(this.f7852q) && dSAParameters.getG().equals(this.f7850g);
    }

    public BigInteger getG() {
        return this.f7850g;
    }

    public BigInteger getP() {
        return this.f7851p;
    }

    public BigInteger getQ() {
        return this.f7852q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}

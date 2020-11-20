package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;

public class CramerShoupParameters implements CipherParameters {

    /* renamed from: H */
    private Digest f7827H;

    /* renamed from: g1 */
    private BigInteger f7828g1;

    /* renamed from: g2 */
    private BigInteger f7829g2;

    /* renamed from: p */
    private BigInteger f7830p;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest) {
        this.f7830p = bigInteger;
        this.f7828g1 = bigInteger2;
        this.f7829g2 = bigInteger3;
        this.f7827H = digest;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        return cramerShoupParameters.getP().equals(this.f7830p) && cramerShoupParameters.getG1().equals(this.f7828g1) && cramerShoupParameters.getG2().equals(this.f7829g2);
    }

    public BigInteger getG1() {
        return this.f7828g1;
    }

    public BigInteger getG2() {
        return this.f7829g2;
    }

    public Digest getH() {
        this.f7827H.reset();
        return this.f7827H;
    }

    public BigInteger getP() {
        return this.f7830p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG1().hashCode()) ^ getG2().hashCode();
    }
}

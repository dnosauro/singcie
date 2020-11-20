package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f7860g;

    /* renamed from: l */
    private int f7861l;

    /* renamed from: p */
    private BigInteger f7862p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f7860g = bigInteger2;
        this.f7862p = bigInteger;
        this.f7861l = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.f7862p) && elGamalParameters.getG().equals(this.f7860g) && elGamalParameters.getL() == this.f7861l;
    }

    public BigInteger getG() {
        return this.f7860g;
    }

    public int getL() {
        return this.f7861l;
    }

    public BigInteger getP() {
        return this.f7862p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f7861l;
    }
}

package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c */
    private BigInteger f7837c;

    /* renamed from: d */
    private BigInteger f7838d;

    /* renamed from: h */
    private BigInteger f7839h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f7837c = bigInteger;
        this.f7838d = bigInteger2;
        this.f7839h = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f7837c) && cramerShoupPublicKeyParameters.getD().equals(this.f7838d) && cramerShoupPublicKeyParameters.getH().equals(this.f7839h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f7837c;
    }

    public BigInteger getD() {
        return this.f7838d;
    }

    public BigInteger getH() {
        return this.f7839h;
    }

    public int hashCode() {
        return ((this.f7837c.hashCode() ^ this.f7838d.hashCode()) ^ this.f7839h.hashCode()) ^ super.hashCode();
    }
}

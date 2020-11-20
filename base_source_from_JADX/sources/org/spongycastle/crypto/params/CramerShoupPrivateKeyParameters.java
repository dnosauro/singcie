package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: pk */
    private CramerShoupPublicKeyParameters f7831pk;

    /* renamed from: x1 */
    private BigInteger f7832x1;

    /* renamed from: x2 */
    private BigInteger f7833x2;

    /* renamed from: y1 */
    private BigInteger f7834y1;

    /* renamed from: y2 */
    private BigInteger f7835y2;

    /* renamed from: z */
    private BigInteger f7836z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f7832x1 = bigInteger;
        this.f7833x2 = bigInteger2;
        this.f7834y1 = bigInteger3;
        this.f7835y2 = bigInteger4;
        this.f7836z = bigInteger5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.getX1().equals(this.f7832x1) && cramerShoupPrivateKeyParameters.getX2().equals(this.f7833x2) && cramerShoupPrivateKeyParameters.getY1().equals(this.f7834y1) && cramerShoupPrivateKeyParameters.getY2().equals(this.f7835y2) && cramerShoupPrivateKeyParameters.getZ().equals(this.f7836z) && super.equals(obj);
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f7831pk;
    }

    public BigInteger getX1() {
        return this.f7832x1;
    }

    public BigInteger getX2() {
        return this.f7833x2;
    }

    public BigInteger getY1() {
        return this.f7834y1;
    }

    public BigInteger getY2() {
        return this.f7835y2;
    }

    public BigInteger getZ() {
        return this.f7836z;
    }

    public int hashCode() {
        return ((((this.f7832x1.hashCode() ^ this.f7833x2.hashCode()) ^ this.f7834y1.hashCode()) ^ this.f7835y2.hashCode()) ^ this.f7836z.hashCode()) ^ super.hashCode();
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f7831pk = cramerShoupPublicKeyParameters;
    }
}

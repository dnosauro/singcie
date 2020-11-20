package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.math.p186ec.ECConstants;
import org.spongycastle.math.p186ec.ECCurve;
import org.spongycastle.math.p186ec.ECPoint;
import org.spongycastle.util.Arrays;

public class ECDomainParameters implements ECConstants {

    /* renamed from: G */
    private ECPoint f7855G;
    private ECCurve curve;

    /* renamed from: h */
    private BigInteger f7856h;

    /* renamed from: n */
    private BigInteger f7857n;
    private byte[] seed;

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ONE, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f7855G = eCPoint.normalize();
        this.f7857n = bigInteger;
        this.f7856h = bigInteger2;
        this.seed = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters) obj;
        return this.curve.equals(eCDomainParameters.curve) && this.f7855G.equals(eCDomainParameters.f7855G) && this.f7857n.equals(eCDomainParameters.f7857n) && this.f7856h.equals(eCDomainParameters.f7856h);
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f7855G;
    }

    public BigInteger getH() {
        return this.f7856h;
    }

    public BigInteger getN() {
        return this.f7857n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int hashCode() {
        return (((((this.curve.hashCode() * 37) ^ this.f7855G.hashCode()) * 37) ^ this.f7857n.hashCode()) * 37) ^ this.f7856h.hashCode();
    }
}

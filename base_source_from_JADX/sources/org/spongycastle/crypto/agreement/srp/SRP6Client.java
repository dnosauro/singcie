package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.SRP6GroupParameters;

public class SRP6Client {

    /* renamed from: A */
    protected BigInteger f7471A;

    /* renamed from: B */
    protected BigInteger f7472B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f7473M1;

    /* renamed from: M2 */
    protected BigInteger f7474M2;

    /* renamed from: N */
    protected BigInteger f7475N;

    /* renamed from: S */
    protected BigInteger f7476S;

    /* renamed from: a */
    protected BigInteger f7477a;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f7478g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f7479u;

    /* renamed from: x */
    protected BigInteger f7480x;

    private BigInteger calculateS() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f7475N, this.f7478g);
        return this.f7472B.subtract(this.f7478g.modPow(this.f7480x, this.f7475N).multiply(calculateK).mod(this.f7475N)).mod(this.f7475N).modPow(this.f7479u.multiply(this.f7480x).add(this.f7477a), this.f7475N);
    }

    public BigInteger calculateClientEvidenceMessage() {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f7471A;
        if (bigInteger3 == null || (bigInteger = this.f7472B) == null || (bigInteger2 = this.f7476S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        this.f7473M1 = SRP6Util.calculateM1(this.digest, this.f7475N, bigInteger3, bigInteger, bigInteger2);
        return this.f7473M1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) {
        this.f7472B = SRP6Util.validatePublicValue(this.f7475N, bigInteger);
        this.f7479u = SRP6Util.calculateU(this.digest, this.f7475N, this.f7471A, this.f7472B);
        this.f7476S = calculateS();
        return this.f7476S;
    }

    public BigInteger calculateSessionKey() {
        BigInteger bigInteger = this.f7476S;
        if (bigInteger == null || this.f7473M1 == null || this.f7474M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        this.Key = SRP6Util.calculateKey(this.digest, this.f7475N, bigInteger);
        return this.Key;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f7480x = SRP6Util.calculateX(this.digest, this.f7475N, bArr, bArr2, bArr3);
        this.f7477a = selectPrivateValue();
        this.f7471A = this.f7478g.modPow(this.f7477a, this.f7475N);
        return this.f7471A;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2, SecureRandom secureRandom) {
        this.f7475N = bigInteger;
        this.f7478g = bigInteger2;
        this.digest = digest2;
        this.random = secureRandom;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), digest2, secureRandom);
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f7475N, this.f7478g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f7471A;
        if (bigInteger4 == null || (bigInteger2 = this.f7473M1) == null || (bigInteger3 = this.f7476S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        } else if (!SRP6Util.calculateM2(this.digest, this.f7475N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f7474M2 = bigInteger;
            return true;
        }
    }
}

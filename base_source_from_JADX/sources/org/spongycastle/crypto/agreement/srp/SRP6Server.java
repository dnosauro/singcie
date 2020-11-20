package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.SRP6GroupParameters;

public class SRP6Server {

    /* renamed from: A */
    protected BigInteger f7481A;

    /* renamed from: B */
    protected BigInteger f7482B;
    protected BigInteger Key;

    /* renamed from: M1 */
    protected BigInteger f7483M1;

    /* renamed from: M2 */
    protected BigInteger f7484M2;

    /* renamed from: N */
    protected BigInteger f7485N;

    /* renamed from: S */
    protected BigInteger f7486S;

    /* renamed from: b */
    protected BigInteger f7487b;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f7488g;
    protected SecureRandom random;

    /* renamed from: u */
    protected BigInteger f7489u;

    /* renamed from: v */
    protected BigInteger f7490v;

    private BigInteger calculateS() {
        return this.f7490v.modPow(this.f7489u, this.f7485N).multiply(this.f7481A).mod(this.f7485N).modPow(this.f7487b, this.f7485N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) {
        this.f7481A = SRP6Util.validatePublicValue(this.f7485N, bigInteger);
        this.f7489u = SRP6Util.calculateU(this.digest, this.f7485N, this.f7481A, this.f7482B);
        this.f7486S = calculateS();
        return this.f7486S;
    }

    public BigInteger calculateServerEvidenceMessage() {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f7481A;
        if (bigInteger3 == null || (bigInteger = this.f7483M1) == null || (bigInteger2 = this.f7486S) == null) {
            throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
        }
        this.f7484M2 = SRP6Util.calculateM2(this.digest, this.f7485N, bigInteger3, bigInteger, bigInteger2);
        return this.f7484M2;
    }

    public BigInteger calculateSessionKey() {
        BigInteger bigInteger = this.f7486S;
        if (bigInteger == null || this.f7483M1 == null || this.f7484M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        this.Key = SRP6Util.calculateKey(this.digest, this.f7485N, bigInteger);
        return this.Key;
    }

    public BigInteger generateServerCredentials() {
        BigInteger calculateK = SRP6Util.calculateK(this.digest, this.f7485N, this.f7488g);
        this.f7487b = selectPrivateValue();
        this.f7482B = calculateK.multiply(this.f7490v).mod(this.f7485N).add(this.f7488g.modPow(this.f7487b, this.f7485N)).mod(this.f7485N);
        return this.f7482B;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest2, SecureRandom secureRandom) {
        this.f7485N = bigInteger;
        this.f7488g = bigInteger2;
        this.f7490v = bigInteger3;
        this.random = secureRandom;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, BigInteger bigInteger, Digest digest2, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), bigInteger, digest2, secureRandom);
    }

    /* access modifiers changed from: protected */
    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.f7485N, this.f7488g, this.random);
    }

    public boolean verifyClientEvidenceMessage(BigInteger bigInteger) {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f7481A;
        if (bigInteger4 == null || (bigInteger2 = this.f7482B) == null || (bigInteger3 = this.f7486S) == null) {
            throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
        } else if (!SRP6Util.calculateM1(this.digest, this.f7485N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        } else {
            this.f7483M1 = bigInteger;
            return true;
        }
    }
}

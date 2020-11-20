package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.SRP6GroupParameters;

public class SRP6VerifierGenerator {

    /* renamed from: N */
    protected BigInteger f7491N;
    protected Digest digest;

    /* renamed from: g */
    protected BigInteger f7492g;

    public BigInteger generateVerifier(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f7492g.modPow(SRP6Util.calculateX(this.digest, this.f7491N, bArr, bArr2, bArr3), this.f7491N);
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest2) {
        this.f7491N = bigInteger;
        this.f7492g = bigInteger2;
        this.digest = digest2;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest2) {
        this.f7491N = sRP6GroupParameters.getN();
        this.f7492g = sRP6GroupParameters.getG();
        this.digest = digest2;
    }
}

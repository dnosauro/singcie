package org.spongycastle.operator.p189bc;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.signers.RSADigestSigner;

/* renamed from: org.spongycastle.operator.bc.BcRSAContentSignerBuilder */
public class BcRSAContentSignerBuilder extends BcContentSignerBuilder {
    public BcRSAContentSignerBuilder(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        super(algorithmIdentifier, algorithmIdentifier2);
    }

    /* access modifiers changed from: protected */
    public Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        return new RSADigestSigner(this.digestProvider.get(algorithmIdentifier2));
    }
}

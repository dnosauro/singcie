package org.spongycastle.operator.p189bc;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.signers.DSADigestSigner;
import org.spongycastle.crypto.signers.ECDSASigner;

/* renamed from: org.spongycastle.operator.bc.BcECContentSignerBuilder */
public class BcECContentSignerBuilder extends BcContentSignerBuilder {
    public BcECContentSignerBuilder(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        super(algorithmIdentifier, algorithmIdentifier2);
    }

    /* access modifiers changed from: protected */
    public Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        return new DSADigestSigner(new ECDSASigner(), this.digestProvider.get(algorithmIdentifier2));
    }
}
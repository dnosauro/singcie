package org.spongycastle.operator;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public interface KeyWrapper {
    byte[] generateWrappedKey(GenericKey genericKey);

    AlgorithmIdentifier getAlgorithmIdentifier();
}

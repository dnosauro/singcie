package org.spongycastle.cert.crmf;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.operator.InputDecryptor;

public interface ValueDecryptorGenerator {
    InputDecryptor getValueDecryptor(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr);
}

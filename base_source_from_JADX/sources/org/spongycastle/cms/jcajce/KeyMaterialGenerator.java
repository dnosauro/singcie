package org.spongycastle.cms.jcajce;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;

interface KeyMaterialGenerator {
    byte[] generateKDFMaterial(AlgorithmIdentifier algorithmIdentifier, int i, byte[] bArr);
}

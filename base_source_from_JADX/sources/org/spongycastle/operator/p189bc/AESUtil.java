package org.spongycastle.operator.p189bc;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.params.KeyParameter;

/* renamed from: org.spongycastle.operator.bc.AESUtil */
class AESUtil {
    AESUtil() {
    }

    static AlgorithmIdentifier determineKeyEncAlg(KeyParameter keyParameter) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        int length = keyParameter.getKey().length * 8;
        if (length == 128) {
            aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes128_wrap;
        } else if (length == 192) {
            aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes192_wrap;
        } else if (length == 256) {
            aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes256_wrap;
        } else {
            throw new IllegalArgumentException("illegal keysize in AES");
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier);
    }
}

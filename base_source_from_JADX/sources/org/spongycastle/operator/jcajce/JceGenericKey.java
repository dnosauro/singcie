package org.spongycastle.operator.jcajce;

import java.security.Key;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.operator.GenericKey;

public class JceGenericKey extends GenericKey {
    public JceGenericKey(AlgorithmIdentifier algorithmIdentifier, Key key) {
        super(algorithmIdentifier, getRepresentation(key));
    }

    private static Object getRepresentation(Key key) {
        byte[] encoded = key.getEncoded();
        return encoded != null ? encoded : key;
    }
}

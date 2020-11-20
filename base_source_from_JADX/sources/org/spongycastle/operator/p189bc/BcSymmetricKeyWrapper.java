package org.spongycastle.operator.p189bc;

import java.security.SecureRandom;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.operator.GenericKey;
import org.spongycastle.operator.SymmetricKeyWrapper;

/* renamed from: org.spongycastle.operator.bc.BcSymmetricKeyWrapper */
public class BcSymmetricKeyWrapper extends SymmetricKeyWrapper {
    private SecureRandom random;
    private Wrapper wrapper;
    private KeyParameter wrappingKey;

    public BcSymmetricKeyWrapper(AlgorithmIdentifier algorithmIdentifier, Wrapper wrapper2, KeyParameter keyParameter) {
        super(algorithmIdentifier);
        this.wrapper = wrapper2;
        this.wrappingKey = keyParameter;
    }

    public byte[] generateWrappedKey(GenericKey genericKey) {
        byte[] keyBytes = OperatorUtils.getKeyBytes(genericKey);
        SecureRandom secureRandom = this.random;
        if (secureRandom == null) {
            this.wrapper.init(true, this.wrappingKey);
        } else {
            this.wrapper.init(true, new ParametersWithRandom(this.wrappingKey, secureRandom));
        }
        return this.wrapper.wrap(keyBytes, 0, keyBytes.length);
    }

    public BcSymmetricKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}

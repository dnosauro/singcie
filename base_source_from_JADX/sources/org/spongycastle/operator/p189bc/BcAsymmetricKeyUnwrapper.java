package org.spongycastle.operator.p189bc;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.operator.AsymmetricKeyUnwrapper;
import org.spongycastle.operator.GenericKey;
import org.spongycastle.operator.OperatorException;

/* renamed from: org.spongycastle.operator.bc.BcAsymmetricKeyUnwrapper */
public abstract class BcAsymmetricKeyUnwrapper extends AsymmetricKeyUnwrapper {
    private AsymmetricKeyParameter privateKey;

    public BcAsymmetricKeyUnwrapper(AlgorithmIdentifier algorithmIdentifier, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(algorithmIdentifier);
        this.privateKey = asymmetricKeyParameter;
    }

    /* access modifiers changed from: protected */
    public abstract AsymmetricBlockCipher createAsymmetricUnwrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier);

    public GenericKey generateUnwrappedKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        AsymmetricBlockCipher createAsymmetricUnwrapper = createAsymmetricUnwrapper(getAlgorithmIdentifier().getAlgorithm());
        createAsymmetricUnwrapper.init(false, this.privateKey);
        try {
            byte[] processBlock = createAsymmetricUnwrapper.processBlock(bArr, 0, bArr.length);
            return algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.des_EDE3_CBC) ? new GenericKey(algorithmIdentifier, processBlock) : new GenericKey(algorithmIdentifier, processBlock);
        } catch (InvalidCipherTextException e) {
            throw new OperatorException("unable to recover secret key: " + e.getMessage(), e);
        }
    }
}

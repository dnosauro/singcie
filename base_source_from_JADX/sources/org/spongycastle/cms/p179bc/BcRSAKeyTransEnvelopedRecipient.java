package org.spongycastle.cms.p179bc;

import java.io.InputStream;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cms.RecipientOperator;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.p181io.CipherInputStream;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.operator.InputDecryptor;

/* renamed from: org.spongycastle.cms.bc.BcRSAKeyTransEnvelopedRecipient */
public class BcRSAKeyTransEnvelopedRecipient extends BcKeyTransRecipient {
    public BcRSAKeyTransEnvelopedRecipient(AsymmetricKeyParameter asymmetricKeyParameter) {
        super(asymmetricKeyParameter);
    }

    public RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, final AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) {
        final Object createContentCipher = EnvelopedDataHelper.createContentCipher(false, extractSecretKey(algorithmIdentifier, algorithmIdentifier2, bArr), algorithmIdentifier2);
        return new RecipientOperator((InputDecryptor) new InputDecryptor() {
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier2;
            }

            public InputStream getInputStream(InputStream inputStream) {
                Object obj = createContentCipher;
                return obj instanceof BufferedBlockCipher ? new CipherInputStream(inputStream, (BufferedBlockCipher) obj) : new CipherInputStream(inputStream, (StreamCipher) obj);
            }
        });
    }
}
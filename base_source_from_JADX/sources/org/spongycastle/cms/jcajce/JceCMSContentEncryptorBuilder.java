package org.spongycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cms.CMSException;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.operator.DefaultSecretKeySizeProvider;
import org.spongycastle.operator.GenericKey;
import org.spongycastle.operator.OutputEncryptor;
import org.spongycastle.operator.SecretKeySizeProvider;
import org.spongycastle.operator.jcajce.JceGenericKey;

public class JceCMSContentEncryptorBuilder {
    private static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
    private AlgorithmParameters algorithmParameters;
    private final ASN1ObjectIdentifier encryptionOID;
    /* access modifiers changed from: private */
    public EnvelopedDataHelper helper;
    private final int keySize;
    private SecureRandom random;

    private class CMSOutputEncryptor implements OutputEncryptor {
        private AlgorithmIdentifier algorithmIdentifier;
        private Cipher cipher;
        private SecretKey encKey;

        CMSOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
            KeyGenerator createKeyGenerator = JceCMSContentEncryptorBuilder.this.helper.createKeyGenerator(aSN1ObjectIdentifier);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            if (i < 0) {
                createKeyGenerator.init(secureRandom);
            } else {
                createKeyGenerator.init(i, secureRandom);
            }
            this.cipher = JceCMSContentEncryptorBuilder.this.helper.createCipher(aSN1ObjectIdentifier);
            this.encKey = createKeyGenerator.generateKey();
            algorithmParameters = algorithmParameters == null ? JceCMSContentEncryptorBuilder.this.helper.generateParameters(aSN1ObjectIdentifier, this.encKey, secureRandom) : algorithmParameters;
            try {
                this.cipher.init(1, this.encKey, algorithmParameters, secureRandom);
                this.algorithmIdentifier = JceCMSContentEncryptorBuilder.this.helper.getAlgorithmIdentifier(aSN1ObjectIdentifier, algorithmParameters == null ? this.cipher.getParameters() : algorithmParameters);
            } catch (GeneralSecurityException e) {
                throw new CMSException("unable to initialize cipher: " + e.getMessage(), e);
            }
        }

        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        public GenericKey getKey() {
            return new JceGenericKey(this.algorithmIdentifier, this.encKey);
        }

        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.cipher);
        }
    }

    public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, KEY_SIZE_PROVIDER.getKeySize(aSN1ObjectIdentifier));
    }

    public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        int i2;
        this.helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.encryptionOID = aSN1ObjectIdentifier;
        int keySize2 = KEY_SIZE_PROVIDER.getKeySize(aSN1ObjectIdentifier);
        if (aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.des_EDE3_CBC)) {
            i2 = CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256;
            if (!(i == 168 || i == keySize2)) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        } else if (aSN1ObjectIdentifier.equals(OIWObjectIdentifiers.desCBC)) {
            i2 = 56;
            if (!(i == 56 || i == keySize2)) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        } else if (keySize2 <= 0 || keySize2 == i) {
            this.keySize = i;
            return;
        } else {
            throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
        }
        this.keySize = i2;
    }

    public OutputEncryptor build() {
        return new CMSOutputEncryptor(this.encryptionOID, this.keySize, this.algorithmParameters, this.random);
    }

    public JceCMSContentEncryptorBuilder setAlgorithmParameters(AlgorithmParameters algorithmParameters2) {
        this.algorithmParameters = algorithmParameters2;
        return this;
    }

    public JceCMSContentEncryptorBuilder setProvider(String str) {
        this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JceCMSContentEncryptorBuilder setProvider(Provider provider) {
        this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }

    public JceCMSContentEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}

package org.spongycastle.pkcs.jcajce;

import java.io.InputStream;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.asn1.pkcs.PBEParameter;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.PasswordConverter;
import org.spongycastle.jcajce.PBKDF1Key;
import org.spongycastle.jcajce.PKCS12KeyWithParameters;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.operator.DefaultSecretKeySizeProvider;
import org.spongycastle.operator.InputDecryptor;
import org.spongycastle.operator.InputDecryptorProvider;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.operator.SecretKeySizeProvider;

public class JcePKCSPBEInputDecryptorProviderBuilder {
    /* access modifiers changed from: private */
    public JcaJceHelper helper = new DefaultJcaJceHelper();
    /* access modifiers changed from: private */
    public SecretKeySizeProvider keySizeProvider = DefaultSecretKeySizeProvider.INSTANCE;
    /* access modifiers changed from: private */
    public boolean wrongPKCS12Zero = false;

    public InputDecryptorProvider build(final char[] cArr) {
        return new InputDecryptorProvider() {
            /* access modifiers changed from: private */
            public Cipher cipher;
            /* access modifiers changed from: private */
            public AlgorithmIdentifier encryptionAlg;

            public InputDecryptor get(AlgorithmIdentifier algorithmIdentifier) {
                Cipher cipher2;
                AlgorithmParameterSpec gOST28147ParameterSpec;
                ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
                try {
                    if (algorithm.mo27879on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                        PKCS12PBEParams instance = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                        this.cipher = JcePKCSPBEInputDecryptorProviderBuilder.this.helper.createCipher(algorithm.getId());
                        this.cipher.init(2, new PKCS12KeyWithParameters(cArr, JcePKCSPBEInputDecryptorProviderBuilder.this.wrongPKCS12Zero, instance.getIV(), instance.getIterations().intValue()));
                        this.encryptionAlg = algorithmIdentifier;
                    } else if (algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
                        PBES2Parameters instance2 = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
                        PBKDF2Params instance3 = PBKDF2Params.getInstance(instance2.getKeyDerivationFunc().getParameters());
                        AlgorithmIdentifier instance4 = AlgorithmIdentifier.getInstance(instance2.getEncryptionScheme());
                        SecretKeyFactory createSecretKeyFactory = JcePKCSPBEInputDecryptorProviderBuilder.this.helper.createSecretKeyFactory(instance2.getKeyDerivationFunc().getAlgorithm().getId());
                        SecretKey generateSecret = instance3.isDefaultPrf() ? createSecretKeyFactory.generateSecret(new PBEKeySpec(cArr, instance3.getSalt(), instance3.getIterationCount().intValue(), JcePKCSPBEInputDecryptorProviderBuilder.this.keySizeProvider.getKeySize(instance4))) : createSecretKeyFactory.generateSecret(new PBKDF2KeySpec(cArr, instance3.getSalt(), instance3.getIterationCount().intValue(), JcePKCSPBEInputDecryptorProviderBuilder.this.keySizeProvider.getKeySize(instance4), instance3.getPrf()));
                        this.cipher = JcePKCSPBEInputDecryptorProviderBuilder.this.helper.createCipher(instance2.getEncryptionScheme().getAlgorithm().getId());
                        this.encryptionAlg = AlgorithmIdentifier.getInstance(instance2.getEncryptionScheme());
                        ASN1Encodable parameters = instance2.getEncryptionScheme().getParameters();
                        if (parameters instanceof ASN1OctetString) {
                            cipher2 = this.cipher;
                            gOST28147ParameterSpec = new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets());
                        } else {
                            GOST28147Parameters instance5 = GOST28147Parameters.getInstance(parameters);
                            cipher2 = this.cipher;
                            gOST28147ParameterSpec = new GOST28147ParameterSpec(instance5.getEncryptionParamSet(), instance5.getIV());
                        }
                        cipher2.init(2, generateSecret, gOST28147ParameterSpec);
                    } else {
                        if (!algorithm.equals(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC)) {
                            if (!algorithm.equals(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC)) {
                                throw new OperatorCreationException("unable to create InputDecryptor: algorithm " + algorithm + " unknown.");
                            }
                        }
                        PBEParameter instance6 = PBEParameter.getInstance(algorithmIdentifier.getParameters());
                        this.cipher = JcePKCSPBEInputDecryptorProviderBuilder.this.helper.createCipher(algorithm.getId());
                        this.cipher.init(2, new PBKDF1Key(cArr, PasswordConverter.ASCII), new PBEParameterSpec(instance6.getSalt(), instance6.getIterationCount().intValue()));
                    }
                    return new InputDecryptor() {
                        public AlgorithmIdentifier getAlgorithmIdentifier() {
                            return C36751.this.encryptionAlg;
                        }

                        public InputStream getInputStream(InputStream inputStream) {
                            return new CipherInputStream(inputStream, C36751.this.cipher);
                        }
                    };
                } catch (Exception e) {
                    throw new OperatorCreationException("unable to create InputDecryptor: " + e.getMessage(), e);
                }
            }
        };
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setKeySizeProvider(SecretKeySizeProvider secretKeySizeProvider) {
        this.keySizeProvider = secretKeySizeProvider;
        return this;
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setProvider(String str) {
        this.helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setProvider(Provider provider) {
        this.helper = new ProviderJcaJceHelper(provider);
        return this;
    }

    public JcePKCSPBEInputDecryptorProviderBuilder setTryWrongPKCS12Zero(boolean z) {
        this.wrongPKCS12Zero = z;
        return this;
    }
}

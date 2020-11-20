package org.spongycastle.jcajce.provider.keystore.pkcs12;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BEROutputStream;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.AuthenticatedSafe;
import org.spongycastle.asn1.pkcs.CertBag;
import org.spongycastle.asn1.pkcs.ContentInfo;
import org.spongycastle.asn1.pkcs.EncryptedData;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.MacData;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.Pfx;
import org.spongycastle.asn1.pkcs.SafeBag;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.cms.CMSEnvelopedGenerator;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12StoreParameter;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.JDKPKCS12StoreParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Properties;
import org.spongycastle.util.Strings;

public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 1024;
    static final int NULL = 0;
    static final String PKCS12_MAX_IT_COUNT_PROPERTY = "org.spongycastle.pkcs12.max_it_count";
    private static final int SALT_SIZE = 20;
    static final int SEALED = 4;
    static final int SECRET = 3;
    private static final DefaultSecretKeyProvider keySizeProvider = new DefaultSecretKeyProvider();
    private ASN1ObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private IgnoresCaseHashtable certs = new IgnoresCaseHashtable();
    private Hashtable chainCerts = new Hashtable();
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int itCount = 1024;
    private ASN1ObjectIdentifier keyAlgorithm;
    private Hashtable keyCerts = new Hashtable();
    private IgnoresCaseHashtable keys = new IgnoresCaseHashtable();
    private Hashtable localIds = new Hashtable();
    private AlgorithmIdentifier macAlgorithm = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    protected SecureRandom random = new SecureRandom();
    private int saltLength = 20;

    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new BouncyCastleProvider(), pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore3DES() {
            super(new BouncyCastleProvider(), pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    private class CertId {

        /* renamed from: id */
        byte[] f7942id;

        CertId(PublicKey publicKey) {
            this.f7942id = PKCS12KeyStoreSpi.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        CertId(byte[] bArr) {
            this.f7942id = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CertId)) {
                return false;
            }
            return Arrays.areEqual(this.f7942id, ((CertId) obj).f7942id);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f7942id);
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore() {
            super((Provider) null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore3DES() {
            super((Provider) null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    private static class DefaultSecretKeyProvider {
        private final Map KEY_SIZES;

        DefaultSecretKeyProvider() {
            HashMap hashMap = new HashMap();
            hashMap.put(new ASN1ObjectIdentifier(CMSEnvelopedGenerator.CAST5_CBC), Integers.valueOf(128));
            hashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
            hashMap.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
            hashMap.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
            hashMap.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
            hashMap.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
            hashMap.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(192));
            hashMap.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
            hashMap.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.valueOf(256));
            this.KEY_SIZES = Collections.unmodifiableMap(hashMap);
        }

        public int getKeySize(AlgorithmIdentifier algorithmIdentifier) {
            Integer num = (Integer) this.KEY_SIZES.get(algorithmIdentifier.getAlgorithm());
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    private static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        public Enumeration elements() {
            return this.orig.elements();
        }

        public Object get(String str) {
            String str2 = (String) this.keys.get(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.get(str2);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public void put(String str, Object obj) {
            String lowerCase = str == null ? null : Strings.toLowerCase(str);
            String str2 = (String) this.keys.get(lowerCase);
            if (str2 != null) {
                this.orig.remove(str2);
            }
            this.keys.put(lowerCase, str);
            this.orig.put(str, obj);
        }

        public Object remove(String str) {
            String str2 = (String) this.keys.remove(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.remove(str2);
        }
    }

    public PKCS12KeyStoreSpi(Provider provider, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        CertificateFactory instance;
        this.keyAlgorithm = aSN1ObjectIdentifier;
        this.certAlgorithm = aSN1ObjectIdentifier2;
        if (provider != null) {
            try {
                instance = CertificateFactory.getInstance("X.509", provider);
            } catch (Exception e) {
                throw new IllegalArgumentException("can't create cert factory - " + e.toString());
            }
        } else {
            instance = CertificateFactory.getInstance("X.509");
        }
        this.certFact = instance;
    }

    private byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) {
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        Mac createMac = this.helper.createMac(aSN1ObjectIdentifier.getId());
        createMac.init(new PKCS12Key(cArr, z), pBEParameterSpec);
        createMac.update(bArr2);
        return createMac.doFinal();
    }

    private Cipher createCipher(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier) {
        SecretKey secretKey;
        AlgorithmParameterSpec algorithmParameterSpec;
        PBES2Parameters instance = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
        PBKDF2Params instance2 = PBKDF2Params.getInstance(instance.getKeyDerivationFunc().getParameters());
        AlgorithmIdentifier instance3 = AlgorithmIdentifier.getInstance(instance.getEncryptionScheme());
        SecretKeyFactory createSecretKeyFactory = this.helper.createSecretKeyFactory(instance.getKeyDerivationFunc().getAlgorithm().getId());
        if (instance2.isDefaultPrf()) {
            secretKey = createSecretKeyFactory.generateSecret(new PBEKeySpec(cArr, instance2.getSalt(), validateIterationCount(instance2.getIterationCount()), keySizeProvider.getKeySize(instance3)));
        } else {
            secretKey = createSecretKeyFactory.generateSecret(new PBKDF2KeySpec(cArr, instance2.getSalt(), validateIterationCount(instance2.getIterationCount()), keySizeProvider.getKeySize(instance3), instance2.getPrf()));
        }
        Cipher instance4 = Cipher.getInstance(instance.getEncryptionScheme().getAlgorithm().getId());
        ASN1Encodable parameters = instance.getEncryptionScheme().getParameters();
        if (parameters instanceof ASN1OctetString) {
            algorithmParameterSpec = new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets());
        } else {
            GOST28147Parameters instance5 = GOST28147Parameters.getInstance(parameters);
            algorithmParameterSpec = new GOST28147ParameterSpec(instance5.getEncryptionParamSet(), instance5.getIV());
        }
        instance4.init(i, secretKey, algorithmParameterSpec);
        return instance4;
    }

    /* access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(getDigest(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    private void doStore(OutputStream outputStream, char[] cArr, boolean z) {
        Enumeration enumeration;
        boolean z2;
        Enumeration enumeration2;
        boolean z3;
        boolean z4;
        OutputStream outputStream2 = outputStream;
        char[] cArr2 = cArr;
        if (cArr2 != null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            Enumeration keys2 = this.keys.keys();
            while (keys2.hasMoreElements()) {
                byte[] bArr = new byte[20];
                this.random.nextBytes(bArr);
                String str = (String) keys2.nextElement();
                PrivateKey privateKey = (PrivateKey) this.keys.get(str);
                PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, 1024);
                EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(this.keyAlgorithm, pKCS12PBEParams.toASN1Primitive()), wrapKey(this.keyAlgorithm.getId(), privateKey, pKCS12PBEParams, cArr2));
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                if (privateKey instanceof PKCS12BagAttributeCarrier) {
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKey;
                    DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_friendlyName);
                    if (dERBMPString == null || !dERBMPString.getString().equals(str)) {
                        pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str));
                    }
                    if (pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                        pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(engineGetCertificate(str).getPublicKey()));
                    }
                    Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
                    z4 = false;
                    while (bagAttributeKeys.hasMoreElements()) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) bagAttributeKeys.nextElement();
                        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                        aSN1EncodableVector3.add(aSN1ObjectIdentifier);
                        aSN1EncodableVector3.add(new DERSet(pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier)));
                        aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector3));
                        z4 = true;
                    }
                } else {
                    z4 = false;
                }
                if (!z4) {
                    ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                    Certificate engineGetCertificate = engineGetCertificate(str);
                    aSN1EncodableVector4.add(pkcs_9_at_localKeyId);
                    aSN1EncodableVector4.add(new DERSet((ASN1Encodable) createSubjectKeyId(engineGetCertificate.getPublicKey())));
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector4));
                    ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                    aSN1EncodableVector5.add(pkcs_9_at_friendlyName);
                    aSN1EncodableVector5.add(new DERSet((ASN1Encodable) new DERBMPString(str)));
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector5));
                }
                aSN1EncodableVector.add(new SafeBag(pkcs8ShroudedKeyBag, encryptedPrivateKeyInfo.toASN1Primitive(), new DERSet(aSN1EncodableVector2)));
            }
            BEROctetString bEROctetString = new BEROctetString(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER));
            byte[] bArr2 = new byte[20];
            this.random.nextBytes(bArr2);
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(this.certAlgorithm, new PKCS12PBEParams(bArr2, 1024).toASN1Primitive());
            Hashtable hashtable = new Hashtable();
            Enumeration keys3 = this.keys.keys();
            while (keys3.hasMoreElements()) {
                try {
                    String str2 = (String) keys3.nextElement();
                    Certificate engineGetCertificate2 = engineGetCertificate(str2);
                    CertBag certBag = new CertBag(x509Certificate, new DEROctetString(engineGetCertificate2.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    if (engineGetCertificate2 instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) engineGetCertificate2;
                        DERBMPString dERBMPString2 = (DERBMPString) pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_friendlyName);
                        if (dERBMPString2 == null || !dERBMPString2.getString().equals(str2)) {
                            pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str2));
                        }
                        if (pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                            pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(engineGetCertificate2.getPublicKey()));
                        }
                        Enumeration bagAttributeKeys2 = pKCS12BagAttributeCarrier2.getBagAttributeKeys();
                        z3 = false;
                        while (bagAttributeKeys2.hasMoreElements()) {
                            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) bagAttributeKeys2.nextElement();
                            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                            aSN1EncodableVector8.add(aSN1ObjectIdentifier2);
                            aSN1EncodableVector8.add(new DERSet(pKCS12BagAttributeCarrier2.getBagAttribute(aSN1ObjectIdentifier2)));
                            aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector8));
                            keys3 = keys3;
                            z3 = true;
                        }
                        enumeration2 = keys3;
                    } else {
                        enumeration2 = keys3;
                        z3 = false;
                    }
                    if (!z3) {
                        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                        aSN1EncodableVector9.add(pkcs_9_at_localKeyId);
                        aSN1EncodableVector9.add(new DERSet((ASN1Encodable) createSubjectKeyId(engineGetCertificate2.getPublicKey())));
                        aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector9));
                        ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                        aSN1EncodableVector10.add(pkcs_9_at_friendlyName);
                        aSN1EncodableVector10.add(new DERSet((ASN1Encodable) new DERBMPString(str2)));
                        aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector10));
                    }
                    aSN1EncodableVector6.add(new SafeBag(certBag, certBag.toASN1Primitive(), new DERSet(aSN1EncodableVector7)));
                    hashtable.put(engineGetCertificate2, engineGetCertificate2);
                    keys3 = enumeration2;
                } catch (CertificateEncodingException e) {
                    throw new IOException("Error encoding certificate: " + e.toString());
                }
            }
            Enumeration keys4 = this.certs.keys();
            while (keys4.hasMoreElements()) {
                try {
                    String str3 = (String) keys4.nextElement();
                    Certificate certificate = (Certificate) this.certs.get(str3);
                    if (this.keys.get(str3) == null) {
                        CertBag certBag2 = new CertBag(x509Certificate, new DEROctetString(certificate.getEncoded()));
                        ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                        if (certificate instanceof PKCS12BagAttributeCarrier) {
                            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) certificate;
                            DERBMPString dERBMPString3 = (DERBMPString) pKCS12BagAttributeCarrier3.getBagAttribute(pkcs_9_at_friendlyName);
                            if (dERBMPString3 == null || !dERBMPString3.getString().equals(str3)) {
                                pKCS12BagAttributeCarrier3.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str3));
                            }
                            Enumeration bagAttributeKeys3 = pKCS12BagAttributeCarrier3.getBagAttributeKeys();
                            z2 = false;
                            while (bagAttributeKeys3.hasMoreElements()) {
                                ASN1ObjectIdentifier aSN1ObjectIdentifier3 = (ASN1ObjectIdentifier) bagAttributeKeys3.nextElement();
                                Enumeration enumeration3 = keys4;
                                if (aSN1ObjectIdentifier3.equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                    keys4 = enumeration3;
                                } else {
                                    ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                                    aSN1EncodableVector12.add(aSN1ObjectIdentifier3);
                                    aSN1EncodableVector12.add(new DERSet(pKCS12BagAttributeCarrier3.getBagAttribute(aSN1ObjectIdentifier3)));
                                    aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector12));
                                    keys4 = enumeration3;
                                    z2 = true;
                                }
                            }
                            enumeration = keys4;
                        } else {
                            enumeration = keys4;
                            z2 = false;
                        }
                        if (!z2) {
                            ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
                            aSN1EncodableVector13.add(pkcs_9_at_friendlyName);
                            aSN1EncodableVector13.add(new DERSet((ASN1Encodable) new DERBMPString(str3)));
                            aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector13));
                        }
                        aSN1EncodableVector6.add(new SafeBag(certBag, certBag2.toASN1Primitive(), new DERSet(aSN1EncodableVector11)));
                        hashtable.put(certificate, certificate);
                        keys4 = enumeration;
                    }
                } catch (CertificateEncodingException e2) {
                    throw new IOException("Error encoding certificate: " + e2.toString());
                }
            }
            Set usedCertificateSet = getUsedCertificateSet();
            Enumeration keys5 = this.chainCerts.keys();
            while (keys5.hasMoreElements()) {
                try {
                    Certificate certificate2 = (Certificate) this.chainCerts.get((CertId) keys5.nextElement());
                    if (usedCertificateSet.contains(certificate2)) {
                        if (hashtable.get(certificate2) == null) {
                            CertBag certBag3 = new CertBag(x509Certificate, new DEROctetString(certificate2.getEncoded()));
                            ASN1EncodableVector aSN1EncodableVector14 = new ASN1EncodableVector();
                            if (certificate2 instanceof PKCS12BagAttributeCarrier) {
                                PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier4 = (PKCS12BagAttributeCarrier) certificate2;
                                Enumeration bagAttributeKeys4 = pKCS12BagAttributeCarrier4.getBagAttributeKeys();
                                while (bagAttributeKeys4.hasMoreElements()) {
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier4 = (ASN1ObjectIdentifier) bagAttributeKeys4.nextElement();
                                    if (!aSN1ObjectIdentifier4.equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                        ASN1EncodableVector aSN1EncodableVector15 = new ASN1EncodableVector();
                                        aSN1EncodableVector15.add(aSN1ObjectIdentifier4);
                                        aSN1EncodableVector15.add(new DERSet(pKCS12BagAttributeCarrier4.getBagAttribute(aSN1ObjectIdentifier4)));
                                        aSN1EncodableVector14.add(new DERSequence(aSN1EncodableVector15));
                                    }
                                }
                            }
                            aSN1EncodableVector6.add(new SafeBag(certBag, certBag3.toASN1Primitive(), new DERSet(aSN1EncodableVector14)));
                        }
                    }
                } catch (CertificateEncodingException e3) {
                    throw new IOException("Error encoding certificate: " + e3.toString());
                }
            }
            AuthenticatedSafe authenticatedSafe = new AuthenticatedSafe(new ContentInfo[]{new ContentInfo(data, bEROctetString), new ContentInfo(encryptedData, new EncryptedData(data, algorithmIdentifier, new BEROctetString(cryptData(true, algorithmIdentifier, cArr, false, new DERSequence(aSN1EncodableVector6).getEncoded(ASN1Encoding.DER)))).toASN1Primitive())});
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            (z ? new DEROutputStream(byteArrayOutputStream) : new BEROutputStream(byteArrayOutputStream)).writeObject(authenticatedSafe);
            ContentInfo contentInfo = new ContentInfo(data, new BEROctetString(byteArrayOutputStream.toByteArray()));
            byte[] bArr3 = new byte[this.saltLength];
            this.random.nextBytes(bArr3);
            try {
                (z ? new DEROutputStream(outputStream2) : new BEROutputStream(outputStream2)).writeObject(new Pfx(contentInfo, new MacData(new DigestInfo(this.macAlgorithm, calculatePbeMac(this.macAlgorithm.getAlgorithm(), bArr3, this.itCount, cArr, false, ((ASN1OctetString) contentInfo.getContent()).getOctets())), bArr3, this.itCount)));
            } catch (Exception e4) {
                throw new IOException("error constructing MAC: " + e4.toString());
            }
        } else {
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
    }

    private static byte[] getDigest(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        Digest createSHA1 = DigestFactory.createSHA1();
        byte[] bArr = new byte[createSHA1.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        createSHA1.update(bytes, 0, bytes.length);
        createSHA1.doFinal(bArr, 0);
        return bArr;
    }

    private Set getUsedCertificateSet() {
        HashSet hashSet = new HashSet();
        Enumeration keys2 = this.keys.keys();
        while (keys2.hasMoreElements()) {
            Certificate[] engineGetCertificateChain = engineGetCertificateChain((String) keys2.nextElement());
            for (int i = 0; i != engineGetCertificateChain.length; i++) {
                hashSet.add(engineGetCertificateChain[i]);
            }
        }
        Enumeration keys3 = this.certs.keys();
        while (keys3.hasMoreElements()) {
            hashSet.add(engineGetCertificate((String) keys3.nextElement()));
        }
        return hashSet;
    }

    private int validateIterationCount(BigInteger bigInteger) {
        int intValue = bigInteger.intValue();
        if (intValue >= 0) {
            BigInteger asBigInteger = Properties.asBigInteger(PKCS12_MAX_IT_COUNT_PROPERTY);
            if (asBigInteger == null || asBigInteger.intValue() >= intValue) {
                return intValue;
            }
            throw new IllegalStateException("iteration count " + intValue + " greater than " + asBigInteger.intValue());
        }
        throw new IllegalStateException("negative iteration count found");
    }

    /* access modifiers changed from: protected */
    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        int i = z ? 1 : 2;
        if (algorithm.mo27879on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
            PKCS12PBEParams instance = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
            try {
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(instance.getIV(), instance.getIterations().intValue());
                PKCS12Key pKCS12Key = new PKCS12Key(cArr, z2);
                Cipher createCipher = this.helper.createCipher(algorithm.getId());
                createCipher.init(i, pKCS12Key, pBEParameterSpec);
                return createCipher.doFinal(bArr);
            } catch (Exception e) {
                throw new IOException("exception decrypting data - " + e.toString());
            }
        } else if (algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
            try {
                return createCipher(i, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (Exception e2) {
                throw new IOException("exception decrypting data - " + e2.toString());
            }
        } else {
            throw new IOException("unknown PBE algorithm: " + algorithm);
        }
    }

    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    public boolean engineContainsAlias(String str) {
        return (this.certs.get(str) == null && this.keys.get(str) == null) ? false : true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.security.cert.Certificate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineDeleteEntry(java.lang.String r6) {
        /*
            r5 = this;
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = r5.keys
            java.lang.Object r0 = r0.remove(r6)
            java.security.Key r0 = (java.security.Key) r0
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = r5.certs
            java.lang.Object r1 = r1.remove(r6)
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
            if (r1 == 0) goto L_0x0020
            java.util.Hashtable r2 = r5.chainCerts
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r3 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r4 = r1.getPublicKey()
            r3.<init>((java.security.PublicKey) r4)
            r2.remove(r3)
        L_0x0020:
            if (r0 == 0) goto L_0x0045
            java.util.Hashtable r0 = r5.localIds
            java.lang.Object r6 = r0.remove(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0035
            java.util.Hashtable r0 = r5.keyCerts
            java.lang.Object r6 = r0.remove(r6)
            r1 = r6
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
        L_0x0035:
            if (r1 == 0) goto L_0x0045
            java.util.Hashtable r6 = r5.chainCerts
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r0 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r1 = r1.getPublicKey()
            r0.<init>((java.security.PublicKey) r1)
            r6.remove(r0)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineDeleteEntry(java.lang.String):void");
    }

    public Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.certs.get(str);
            if (certificate != null) {
                return certificate;
            }
            String str2 = (String) this.localIds.get(str);
            return (Certificate) (str2 != null ? this.keyCerts.get(str2) : this.keyCerts.get(str));
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.certs.elements();
        Enumeration keys2 = this.certs.keys();
        while (elements.hasMoreElements()) {
            String str = (String) keys2.nextElement();
            if (((Certificate) elements.nextElement()).equals(certificate)) {
                return str;
            }
        }
        Enumeration elements2 = this.keyCerts.elements();
        Enumeration keys3 = this.keyCerts.keys();
        while (elements2.hasMoreElements()) {
            String str2 = (String) keys3.nextElement();
            if (((Certificate) elements2.nextElement()).equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00c8
            boolean r0 = r8.engineIsKeyEntry(r9)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.security.cert.Certificate r9 = r8.engineGetCertificate(r9)
            if (r9 == 0) goto L_0x00c7
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
        L_0x0015:
            if (r9 == 0) goto L_0x00b1
            r2 = r9
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x509.Extension.authorityKeyIdentifier
            java.lang.String r3 = r3.getId()
            byte[] r3 = r2.getExtensionValue(r3)
            if (r3 == 0) goto L_0x0065
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x005a }
            r4.<init>((byte[]) r3)     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3     // Catch:{ IOException -> 0x005a }
            byte[] r3 = r3.getOctets()     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x005a }
            r4.<init>((byte[]) r3)     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch:{ IOException -> 0x005a }
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r3 = org.spongycastle.asn1.x509.AuthorityKeyIdentifier.getInstance(r3)     // Catch:{ IOException -> 0x005a }
            byte[] r4 = r3.getKeyIdentifier()     // Catch:{ IOException -> 0x005a }
            if (r4 == 0) goto L_0x0065
            java.util.Hashtable r4 = r8.chainCerts     // Catch:{ IOException -> 0x005a }
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r5 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId     // Catch:{ IOException -> 0x005a }
            byte[] r3 = r3.getKeyIdentifier()     // Catch:{ IOException -> 0x005a }
            r5.<init>((byte[]) r3)     // Catch:{ IOException -> 0x005a }
            java.lang.Object r3 = r4.get(r5)     // Catch:{ IOException -> 0x005a }
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3     // Catch:{ IOException -> 0x005a }
            goto L_0x0066
        L_0x005a:
            r9 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x0065:
            r3 = r1
        L_0x0066:
            if (r3 != 0) goto L_0x00a0
            java.security.Principal r4 = r2.getIssuerDN()
            java.security.Principal r5 = r2.getSubjectDN()
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00a0
            java.util.Hashtable r5 = r8.chainCerts
            java.util.Enumeration r5 = r5.keys()
        L_0x007c:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto L_0x00a0
            java.util.Hashtable r6 = r8.chainCerts
            java.lang.Object r7 = r5.nextElement()
            java.lang.Object r6 = r6.get(r7)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            java.security.Principal r7 = r6.getSubjectDN()
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x007c
            java.security.PublicKey r7 = r6.getPublicKey()     // Catch:{ Exception -> 0x007c }
            r2.verify(r7)     // Catch:{ Exception -> 0x007c }
            r3 = r6
        L_0x00a0:
            boolean r2 = r0.contains(r9)
            if (r2 == 0) goto L_0x00a9
        L_0x00a6:
            r9 = r1
            goto L_0x0015
        L_0x00a9:
            r0.addElement(r9)
            if (r3 == r9) goto L_0x00a6
            r9 = r3
            goto L_0x0015
        L_0x00b1:
            int r9 = r0.size()
            java.security.cert.Certificate[] r9 = new java.security.cert.Certificate[r9]
            r1 = 0
        L_0x00b8:
            int r2 = r9.length
            if (r1 == r2) goto L_0x00c6
            java.lang.Object r2 = r0.elementAt(r1)
            java.security.cert.Certificate r2 = (java.security.cert.Certificate) r2
            r9[r1] = r2
            int r1 = r1 + 1
            goto L_0x00b8
        L_0x00c6:
            return r9
        L_0x00c7:
            return r1
        L_0x00c8:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "null alias passed to getCertificateChain."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    public Date engineGetCreationDate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        } else if (this.keys.get(str) == null && this.certs.get(str) == null) {
            return null;
        } else {
            return new Date();
        }
    }

    public Key engineGetKey(String str, char[] cArr) {
        if (str != null) {
            return (Key) this.keys.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    public boolean engineIsCertificateEntry(String str) {
        return this.certs.get(str) != null && this.keys.get(str) == null;
    }

    public boolean engineIsKeyEntry(String str) {
        return this.keys.get(str) != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: org.spongycastle.asn1.ASN1Primitive} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: org.spongycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: org.spongycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: org.spongycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: org.spongycastle.asn1.ASN1OctetString} */
    /* JADX WARNING: type inference failed for: r5v11, types: [org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Encodable, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r12v32, types: [org.spongycastle.asn1.ASN1Encodable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0476  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineLoad(java.io.InputStream r19, char[] r20) {
        /*
            r18 = this;
            r8 = r18
            r0 = r19
            r9 = r20
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            if (r9 == 0) goto L_0x05d0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r1.<init>(r0)
            r0 = 10
            r1.mark(r0)
            int r0 = r1.read()
            r2 = 48
            if (r0 != r2) goto L_0x05c8
            r1.reset()
            org.spongycastle.asn1.ASN1InputStream r0 = new org.spongycastle.asn1.ASN1InputStream
            r0.<init>((java.io.InputStream) r1)
            org.spongycastle.asn1.ASN1Primitive r0 = r0.readObject()
            org.spongycastle.asn1.ASN1Sequence r0 = (org.spongycastle.asn1.ASN1Sequence) r0
            org.spongycastle.asn1.pkcs.Pfx r0 = org.spongycastle.asn1.pkcs.Pfx.getInstance(r0)
            org.spongycastle.asn1.pkcs.ContentInfo r10 = r0.getAuthSafe()
            java.util.Vector r11 = new java.util.Vector
            r11.<init>()
            org.spongycastle.asn1.pkcs.MacData r1 = r0.getMacData()
            r12 = 1
            r13 = 0
            if (r1 == 0) goto L_0x00d2
            org.spongycastle.asn1.pkcs.MacData r0 = r0.getMacData()
            org.spongycastle.asn1.x509.DigestInfo r14 = r0.getMac()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r14.getAlgorithmId()
            r8.macAlgorithm = r1
            byte[] r15 = r0.getSalt()
            java.math.BigInteger r0 = r0.getIterationCount()
            int r0 = r8.validateIterationCount(r0)
            r8.itCount = r0
            int r0 = r15.length
            r8.saltLength = r0
            org.spongycastle.asn1.ASN1Encodable r0 = r10.getContent()
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0
            byte[] r0 = r0.getOctets()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r8.macAlgorithm     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r1.getAlgorithm()     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            int r4 = r8.itCount     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            r6 = 0
            r1 = r18
            r3 = r15
            r5 = r20
            r7 = r0
            byte[] r1 = r1.calculatePbeMac(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            byte[] r14 = r14.getDigest()     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            boolean r1 = org.spongycastle.util.Arrays.constantTimeAreEqual(r1, r14)     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            if (r1 != 0) goto L_0x00d2
            int r1 = r9.length     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            if (r1 > 0) goto L_0x00ac
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r8.macAlgorithm     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r1.getAlgorithm()     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            int r4 = r8.itCount     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            r6 = 1
            r1 = r18
            r3 = r15
            r5 = r20
            r7 = r0
            byte[] r0 = r1.calculatePbeMac(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            boolean r0 = org.spongycastle.util.Arrays.constantTimeAreEqual(r0, r14)     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            if (r0 == 0) goto L_0x00a4
            r0 = 1
            goto L_0x00d3
        L_0x00a4:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            java.lang.String r1 = "PKCS12 key store mac invalid - wrong password or corrupted file."
            r0.<init>(r1)     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            throw r0     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
        L_0x00ac:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            java.lang.String r1 = "PKCS12 key store mac invalid - wrong password or corrupted file."
            r0.<init>(r1)     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
            throw r0     // Catch:{ IOException -> 0x00d0, Exception -> 0x00b4 }
        L_0x00b4:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "error constructing MAC: "
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00d0:
            r0 = move-exception
            throw r0
        L_0x00d2:
            r0 = 0
        L_0x00d3:
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable
            r7 = 0
            r1.<init>()
            r8.keys = r1
            java.util.Hashtable r1 = new java.util.Hashtable
            r1.<init>()
            r8.localIds = r1
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r10.getContentType()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = data
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0476
            org.spongycastle.asn1.ASN1InputStream r1 = new org.spongycastle.asn1.ASN1InputStream
            org.spongycastle.asn1.ASN1Encodable r2 = r10.getContent()
            org.spongycastle.asn1.ASN1OctetString r2 = (org.spongycastle.asn1.ASN1OctetString) r2
            byte[] r2 = r2.getOctets()
            r1.<init>((byte[]) r2)
            org.spongycastle.asn1.ASN1Primitive r1 = r1.readObject()
            org.spongycastle.asn1.pkcs.AuthenticatedSafe r1 = org.spongycastle.asn1.pkcs.AuthenticatedSafe.getInstance(r1)
            org.spongycastle.asn1.pkcs.ContentInfo[] r10 = r1.getContentInfo()
            r14 = 0
            r15 = 0
        L_0x010b:
            int r1 = r10.length
            if (r14 == r1) goto L_0x0477
            r1 = r10[r14]
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.getContentType()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = data
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0248
            org.spongycastle.asn1.ASN1InputStream r1 = new org.spongycastle.asn1.ASN1InputStream
            r2 = r10[r14]
            org.spongycastle.asn1.ASN1Encodable r2 = r2.getContent()
            org.spongycastle.asn1.ASN1OctetString r2 = (org.spongycastle.asn1.ASN1OctetString) r2
            byte[] r2 = r2.getOctets()
            r1.<init>((byte[]) r2)
            org.spongycastle.asn1.ASN1Primitive r1 = r1.readObject()
            org.spongycastle.asn1.ASN1Sequence r1 = (org.spongycastle.asn1.ASN1Sequence) r1
            r2 = 0
        L_0x0134:
            int r3 = r1.size()
            if (r2 == r3) goto L_0x0244
            org.spongycastle.asn1.ASN1Encodable r3 = r1.getObjectAt(r2)
            org.spongycastle.asn1.pkcs.SafeBag r3 = org.spongycastle.asn1.pkcs.SafeBag.getInstance(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r3.getBagId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = pkcs8ShroudedKeyBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x020a
            org.spongycastle.asn1.ASN1Encodable r4 = r3.getBagValue()
            org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo r4 = org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo.getInstance(r4)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r5 = r4.getEncryptionAlgorithm()
            byte[] r4 = r4.getEncryptedData()
            java.security.PrivateKey r4 = r8.unwrapKey(r5, r4, r9, r0)
            r5 = r4
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r5 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r5
            org.spongycastle.asn1.ASN1Set r6 = r3.getBagAttributes()
            if (r6 == 0) goto L_0x01e1
            org.spongycastle.asn1.ASN1Set r3 = r3.getBagAttributes()
            java.util.Enumeration r3 = r3.getObjects()
            r6 = r7
            r16 = r6
        L_0x0176:
            boolean r17 = r3.hasMoreElements()
            if (r17 == 0) goto L_0x01e4
            java.lang.Object r17 = r3.nextElement()
            r7 = r17
            org.spongycastle.asn1.ASN1Sequence r7 = (org.spongycastle.asn1.ASN1Sequence) r7
            org.spongycastle.asn1.ASN1Encodable r17 = r7.getObjectAt(r13)
            r13 = r17
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r13
            org.spongycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r12)
            org.spongycastle.asn1.ASN1Set r7 = (org.spongycastle.asn1.ASN1Set) r7
            int r17 = r7.size()
            if (r17 <= 0) goto L_0x01bc
            r12 = 0
            org.spongycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r12)
            org.spongycastle.asn1.ASN1Primitive r7 = (org.spongycastle.asn1.ASN1Primitive) r7
            org.spongycastle.asn1.ASN1Encodable r12 = r5.getBagAttribute(r13)
            if (r12 == 0) goto L_0x01b8
            org.spongycastle.asn1.ASN1Primitive r12 = r12.toASN1Primitive()
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x01b0
            goto L_0x01bd
        L_0x01b0:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "attempt to add existing attribute with different value"
            r0.<init>(r1)
            throw r0
        L_0x01b8:
            r5.setBagAttribute(r13, r7)
            goto L_0x01bd
        L_0x01bc:
            r7 = 0
        L_0x01bd:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_friendlyName
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x01d1
            org.spongycastle.asn1.DERBMPString r7 = (org.spongycastle.asn1.DERBMPString) r7
            java.lang.String r6 = r7.getString()
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r7 = r8.keys
            r7.put(r6, r4)
            goto L_0x01dd
        L_0x01d1:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_localKeyId
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x01dd
            r16 = r7
            org.spongycastle.asn1.ASN1OctetString r16 = (org.spongycastle.asn1.ASN1OctetString) r16
        L_0x01dd:
            r7 = 0
            r12 = 1
            r13 = 0
            goto L_0x0176
        L_0x01e1:
            r6 = 0
            r16 = 0
        L_0x01e4:
            if (r16 == 0) goto L_0x0201
            java.lang.String r3 = new java.lang.String
            byte[] r5 = r16.getOctets()
            byte[] r5 = org.spongycastle.util.encoders.Hex.encode(r5)
            r3.<init>(r5)
            if (r6 != 0) goto L_0x01fb
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r5 = r8.keys
            r5.put(r3, r4)
            goto L_0x023d
        L_0x01fb:
            java.util.Hashtable r4 = r8.localIds
            r4.put(r6, r3)
            goto L_0x023d
        L_0x0201:
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.keys
            java.lang.String r5 = "unmarked"
            r3.put(r5, r4)
            r15 = 1
            goto L_0x023d
        L_0x020a:
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r3.getBagId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = certBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x021a
            r11.addElement(r3)
            goto L_0x023d
        L_0x021a:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "extra in data "
            r5.append(r6)
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r3.getBagId()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.println(r5)
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.String r3 = org.spongycastle.asn1.util.ASN1Dump.dumpAsString(r3)
            r4.println(r3)
        L_0x023d:
            int r2 = r2 + 1
            r7 = 0
            r12 = 1
            r13 = 0
            goto L_0x0134
        L_0x0244:
            r16 = r0
            goto L_0x046d
        L_0x0248:
            r1 = r10[r14]
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.getContentType()
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = encryptedData
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x042b
            r1 = r10[r14]
            org.spongycastle.asn1.ASN1Encodable r1 = r1.getContent()
            org.spongycastle.asn1.pkcs.EncryptedData r1 = org.spongycastle.asn1.pkcs.EncryptedData.getInstance(r1)
            r2 = 0
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = r1.getEncryptionAlgorithm()
            org.spongycastle.asn1.ASN1OctetString r1 = r1.getContent()
            byte[] r6 = r1.getOctets()
            r1 = r18
            r4 = r20
            r5 = r0
            byte[] r1 = r1.cryptData(r2, r3, r4, r5, r6)
            org.spongycastle.asn1.ASN1Primitive r1 = org.spongycastle.asn1.ASN1Primitive.fromByteArray(r1)
            org.spongycastle.asn1.ASN1Sequence r1 = (org.spongycastle.asn1.ASN1Sequence) r1
            r2 = 0
        L_0x027d:
            int r3 = r1.size()
            if (r2 == r3) goto L_0x0244
            org.spongycastle.asn1.ASN1Encodable r3 = r1.getObjectAt(r2)
            org.spongycastle.asn1.pkcs.SafeBag r3 = org.spongycastle.asn1.pkcs.SafeBag.getInstance(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r3.getBagId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = certBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x029e
            r11.addElement(r3)
            r16 = r0
            goto L_0x0425
        L_0x029e:
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r3.getBagId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = pkcs8ShroudedKeyBag
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0357
            org.spongycastle.asn1.ASN1Encodable r4 = r3.getBagValue()
            org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo r4 = org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo.getInstance(r4)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r5 = r4.getEncryptionAlgorithm()
            byte[] r4 = r4.getEncryptedData()
            java.security.PrivateKey r4 = r8.unwrapKey(r5, r4, r9, r0)
            r5 = r4
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r5 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r5
            org.spongycastle.asn1.ASN1Set r3 = r3.getBagAttributes()
            java.util.Enumeration r3 = r3.getObjects()
            r6 = 0
            r7 = 0
        L_0x02cb:
            boolean r12 = r3.hasMoreElements()
            if (r12 == 0) goto L_0x0338
            java.lang.Object r12 = r3.nextElement()
            org.spongycastle.asn1.ASN1Sequence r12 = (org.spongycastle.asn1.ASN1Sequence) r12
            r13 = 0
            org.spongycastle.asn1.ASN1Encodable r16 = r12.getObjectAt(r13)
            r13 = r16
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r13
            r16 = r0
            r0 = 1
            org.spongycastle.asn1.ASN1Encodable r12 = r12.getObjectAt(r0)
            org.spongycastle.asn1.ASN1Set r12 = (org.spongycastle.asn1.ASN1Set) r12
            int r0 = r12.size()
            if (r0 <= 0) goto L_0x0314
            r0 = 0
            org.spongycastle.asn1.ASN1Encodable r12 = r12.getObjectAt(r0)
            r0 = r12
            org.spongycastle.asn1.ASN1Primitive r0 = (org.spongycastle.asn1.ASN1Primitive) r0
            org.spongycastle.asn1.ASN1Encodable r12 = r5.getBagAttribute(r13)
            if (r12 == 0) goto L_0x0310
            org.spongycastle.asn1.ASN1Primitive r12 = r12.toASN1Primitive()
            boolean r12 = r12.equals(r0)
            if (r12 == 0) goto L_0x0308
            goto L_0x0315
        L_0x0308:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "attempt to add existing attribute with different value"
            r0.<init>(r1)
            throw r0
        L_0x0310:
            r5.setBagAttribute(r13, r0)
            goto L_0x0315
        L_0x0314:
            r0 = 0
        L_0x0315:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_friendlyName
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x032a
            org.spongycastle.asn1.DERBMPString r0 = (org.spongycastle.asn1.DERBMPString) r0
            java.lang.String r0 = r0.getString()
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r7 = r8.keys
            r7.put(r0, r4)
            r7 = r0
            goto L_0x0335
        L_0x032a:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_localKeyId
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x0335
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0
            r6 = r0
        L_0x0335:
            r0 = r16
            goto L_0x02cb
        L_0x0338:
            r16 = r0
            java.lang.String r0 = new java.lang.String
            byte[] r3 = r6.getOctets()
            byte[] r3 = org.spongycastle.util.encoders.Hex.encode(r3)
            r0.<init>(r3)
            if (r7 != 0) goto L_0x0350
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.keys
            r3.put(r0, r4)
            goto L_0x0425
        L_0x0350:
            java.util.Hashtable r3 = r8.localIds
            r3.put(r7, r0)
            goto L_0x0425
        L_0x0357:
            r16 = r0
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r3.getBagId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = keyBag
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0402
            org.spongycastle.asn1.ASN1Encodable r0 = r3.getBagValue()
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r0 = org.spongycastle.asn1.pkcs.PrivateKeyInfo.getInstance(r0)
            java.security.PrivateKey r0 = org.spongycastle.jce.provider.BouncyCastleProvider.getPrivateKey(r0)
            r4 = r0
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r4 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r4
            org.spongycastle.asn1.ASN1Set r3 = r3.getBagAttributes()
            java.util.Enumeration r3 = r3.getObjects()
            r5 = 0
            r6 = 0
        L_0x037e:
            boolean r7 = r3.hasMoreElements()
            if (r7 == 0) goto L_0x03e7
            java.lang.Object r7 = r3.nextElement()
            org.spongycastle.asn1.ASN1Sequence r7 = org.spongycastle.asn1.ASN1Sequence.getInstance(r7)
            r12 = 0
            org.spongycastle.asn1.ASN1Encodable r13 = r7.getObjectAt(r12)
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = org.spongycastle.asn1.ASN1ObjectIdentifier.getInstance(r13)
            r12 = 1
            org.spongycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r12)
            org.spongycastle.asn1.ASN1Set r7 = org.spongycastle.asn1.ASN1Set.getInstance(r7)
            int r12 = r7.size()
            if (r12 <= 0) goto L_0x037e
            r12 = 0
            org.spongycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r12)
            org.spongycastle.asn1.ASN1Primitive r7 = (org.spongycastle.asn1.ASN1Primitive) r7
            org.spongycastle.asn1.ASN1Encodable r12 = r4.getBagAttribute(r13)
            if (r12 == 0) goto L_0x03c4
            org.spongycastle.asn1.ASN1Primitive r12 = r12.toASN1Primitive()
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x03bc
            goto L_0x03c7
        L_0x03bc:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "attempt to add existing attribute with different value"
            r0.<init>(r1)
            throw r0
        L_0x03c4:
            r4.setBagAttribute(r13, r7)
        L_0x03c7:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_friendlyName
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x03db
            org.spongycastle.asn1.DERBMPString r7 = (org.spongycastle.asn1.DERBMPString) r7
            java.lang.String r6 = r7.getString()
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r7 = r8.keys
            r7.put(r6, r0)
            goto L_0x037e
        L_0x03db:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_localKeyId
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x037e
            org.spongycastle.asn1.ASN1OctetString r7 = (org.spongycastle.asn1.ASN1OctetString) r7
            r5 = r7
            goto L_0x037e
        L_0x03e7:
            java.lang.String r3 = new java.lang.String
            byte[] r4 = r5.getOctets()
            byte[] r4 = org.spongycastle.util.encoders.Hex.encode(r4)
            r3.<init>(r4)
            if (r6 != 0) goto L_0x03fc
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r4 = r8.keys
            r4.put(r3, r0)
            goto L_0x0425
        L_0x03fc:
            java.util.Hashtable r0 = r8.localIds
            r0.put(r6, r3)
            goto L_0x0425
        L_0x0402:
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "extra in encryptedData "
            r4.append(r5)
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = r3.getBagId()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.println(r4)
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r3 = org.spongycastle.asn1.util.ASN1Dump.dumpAsString(r3)
            r0.println(r3)
        L_0x0425:
            int r2 = r2 + 1
            r0 = r16
            goto L_0x027d
        L_0x042b:
            r16 = r0
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "extra "
            r1.append(r2)
            r2 = r10[r14]
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r2.getContentType()
            java.lang.String r2 = r2.getId()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "extra "
            r1.append(r2)
            r2 = r10[r14]
            org.spongycastle.asn1.ASN1Encodable r2 = r2.getContent()
            java.lang.String r2 = org.spongycastle.asn1.util.ASN1Dump.dumpAsString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
        L_0x046d:
            int r14 = r14 + 1
            r0 = r16
            r7 = 0
            r12 = 1
            r13 = 0
            goto L_0x010b
        L_0x0476:
            r15 = 0
        L_0x0477:
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable
            r1 = 0
            r0.<init>()
            r8.certs = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r8.chainCerts = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r8.keyCerts = r0
            r0 = 0
        L_0x048e:
            int r2 = r11.size()
            if (r0 == r2) goto L_0x05c7
            java.lang.Object r2 = r11.elementAt(r0)
            org.spongycastle.asn1.pkcs.SafeBag r2 = (org.spongycastle.asn1.pkcs.SafeBag) r2
            org.spongycastle.asn1.ASN1Encodable r3 = r2.getBagValue()
            org.spongycastle.asn1.pkcs.CertBag r3 = org.spongycastle.asn1.pkcs.CertBag.getInstance(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r3.getCertId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = x509Certificate
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x05ac
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x05a1 }
            org.spongycastle.asn1.ASN1Encodable r3 = r3.getCertValue()     // Catch:{ Exception -> 0x05a1 }
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3     // Catch:{ Exception -> 0x05a1 }
            byte[] r3 = r3.getOctets()     // Catch:{ Exception -> 0x05a1 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x05a1 }
            java.security.cert.CertificateFactory r3 = r8.certFact     // Catch:{ Exception -> 0x05a1 }
            java.security.cert.Certificate r3 = r3.generateCertificate(r4)     // Catch:{ Exception -> 0x05a1 }
            org.spongycastle.asn1.ASN1Set r4 = r2.getBagAttributes()
            if (r4 == 0) goto L_0x0540
            org.spongycastle.asn1.ASN1Set r2 = r2.getBagAttributes()
            java.util.Enumeration r2 = r2.getObjects()
            r4 = r1
            r7 = r4
        L_0x04d3:
            boolean r5 = r2.hasMoreElements()
            if (r5 == 0) goto L_0x053d
            java.lang.Object r5 = r2.nextElement()
            org.spongycastle.asn1.ASN1Sequence r5 = org.spongycastle.asn1.ASN1Sequence.getInstance(r5)
            r6 = 0
            org.spongycastle.asn1.ASN1Encodable r9 = r5.getObjectAt(r6)
            org.spongycastle.asn1.ASN1ObjectIdentifier r9 = org.spongycastle.asn1.ASN1ObjectIdentifier.getInstance(r9)
            r10 = 1
            org.spongycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r10)
            org.spongycastle.asn1.ASN1Set r5 = org.spongycastle.asn1.ASN1Set.getInstance(r5)
            int r12 = r5.size()
            if (r12 <= 0) goto L_0x04d3
            org.spongycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r6)
            org.spongycastle.asn1.ASN1Primitive r5 = (org.spongycastle.asn1.ASN1Primitive) r5
            boolean r12 = r3 instanceof org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
            if (r12 == 0) goto L_0x0522
            r12 = r3
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r12 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r12
            org.spongycastle.asn1.ASN1Encodable r13 = r12.getBagAttribute(r9)
            if (r13 == 0) goto L_0x051f
            org.spongycastle.asn1.ASN1Primitive r12 = r13.toASN1Primitive()
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L_0x0517
            goto L_0x0522
        L_0x0517:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "attempt to add existing attribute with different value"
            r0.<init>(r1)
            throw r0
        L_0x051f:
            r12.setBagAttribute(r9, r5)
        L_0x0522:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_friendlyName
            boolean r12 = r9.equals(r12)
            if (r12 == 0) goto L_0x0531
            org.spongycastle.asn1.DERBMPString r5 = (org.spongycastle.asn1.DERBMPString) r5
            java.lang.String r4 = r5.getString()
            goto L_0x04d3
        L_0x0531:
            org.spongycastle.asn1.ASN1ObjectIdentifier r12 = pkcs_9_at_localKeyId
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x04d3
            r7 = r5
            org.spongycastle.asn1.ASN1OctetString r7 = (org.spongycastle.asn1.ASN1OctetString) r7
            goto L_0x04d3
        L_0x053d:
            r6 = 0
            r10 = 1
            goto L_0x0544
        L_0x0540:
            r6 = 0
            r10 = 1
            r4 = r1
            r7 = r4
        L_0x0544:
            java.util.Hashtable r2 = r8.chainCerts
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r5 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r9 = r3.getPublicKey()
            r5.<init>((java.security.PublicKey) r9)
            r2.put(r5, r3)
            if (r15 == 0) goto L_0x0582
            java.util.Hashtable r2 = r8.keyCerts
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x059d
            java.lang.String r2 = new java.lang.String
            java.security.PublicKey r4 = r3.getPublicKey()
            org.spongycastle.asn1.x509.SubjectKeyIdentifier r4 = r8.createSubjectKeyId(r4)
            byte[] r4 = r4.getKeyIdentifier()
            byte[] r4 = org.spongycastle.util.encoders.Hex.encode(r4)
            r2.<init>(r4)
            java.util.Hashtable r4 = r8.keyCerts
            r4.put(r2, r3)
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.keys
            java.lang.String r4 = "unmarked"
            java.lang.Object r4 = r3.remove(r4)
            r3.put(r2, r4)
            goto L_0x059d
        L_0x0582:
            if (r7 == 0) goto L_0x0596
            java.lang.String r2 = new java.lang.String
            byte[] r5 = r7.getOctets()
            byte[] r5 = org.spongycastle.util.encoders.Hex.encode(r5)
            r2.<init>(r5)
            java.util.Hashtable r5 = r8.keyCerts
            r5.put(r2, r3)
        L_0x0596:
            if (r4 == 0) goto L_0x059d
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r2 = r8.certs
            r2.put(r4, r3)
        L_0x059d:
            int r0 = r0 + 1
            goto L_0x048e
        L_0x05a1:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x05ac:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported certificate type: "
            r1.append(r2)
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r3.getCertId()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x05c7:
            return
        L_0x05c8:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "stream does not represent a PKCS12 key store"
            r0.<init>(r1)
            throw r0
        L_0x05d0:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "No password supplied for PKCS#12 KeyStore."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineLoad(java.io.InputStream, char[]):void");
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) {
        if (this.keys.get(str) == null) {
            this.certs.put(str, certificate);
            this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
            return;
        }
        throw new KeyStoreException("There is a key entry with the name " + str + ".");
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        boolean z = key instanceof PrivateKey;
        if (!z) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        } else if (!z || certificateArr != null) {
            if (this.keys.get(str) != null) {
                engineDeleteEntry(str);
            }
            this.keys.put(str, key);
            if (certificateArr != null) {
                this.certs.put(str, certificateArr[0]);
                for (int i = 0; i != certificateArr.length; i++) {
                    this.chainCerts.put(new CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
                }
            }
        } else {
            throw new KeyStoreException("no certificate chain for private key");
        }
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        throw new RuntimeException("operation not supported");
    }

    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    public void engineStore(OutputStream outputStream, char[] cArr) {
        doStore(outputStream, cArr, false);
    }

    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) {
        PKCS12StoreParameter pKCS12StoreParameter;
        char[] cArr;
        if (loadStoreParameter != null) {
            boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
            if (z || (loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
                if (z) {
                    pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
                } else {
                    JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
                    pKCS12StoreParameter = new PKCS12StoreParameter(jDKPKCS12StoreParameter.getOutputStream(), loadStoreParameter.getProtectionParameter(), jDKPKCS12StoreParameter.isUseDEREncoding());
                }
                KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
                if (protectionParameter == null) {
                    cArr = null;
                } else if (protectionParameter instanceof KeyStore.PasswordProtection) {
                    cArr = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
                } else {
                    throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
                }
                doStore(pKCS12StoreParameter.getOutputStream(), cArr, pKCS12StoreParameter.isForDEREncoding());
                return;
            }
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        throw new IllegalArgumentException("'param' arg cannot be null");
    }

    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    /* access modifiers changed from: protected */
    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        try {
            if (algorithm.mo27879on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                PKCS12PBEParams instance = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(instance.getIV(), validateIterationCount(instance.getIterations()));
                Cipher createCipher = this.helper.createCipher(algorithm.getId());
                createCipher.init(4, new PKCS12Key(cArr, z), pBEParameterSpec);
                return (PrivateKey) createCipher.unwrap(bArr, "", 2);
            } else if (algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
                return (PrivateKey) createCipher(4, cArr, algorithmIdentifier).unwrap(bArr, "", 2);
            } else {
                throw new IOException("exception unwrapping private key - cannot recognise: " + algorithm);
            }
        } catch (Exception e) {
            throw new IOException("exception unwrapping private key - " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory createSecretKeyFactory = this.helper.createSecretKeyFactory(str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher createCipher = this.helper.createCipher(str);
            createCipher.init(3, createSecretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return createCipher.wrap(key);
        } catch (Exception e) {
            throw new IOException("exception encrypting data - " + e.toString());
        }
    }
}

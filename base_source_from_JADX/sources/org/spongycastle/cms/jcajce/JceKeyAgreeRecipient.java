package org.spongycastle.cms.jcajce;

import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cms.ecc.ECCCMSSharedInfo;
import org.spongycastle.asn1.p176x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cms.KeyAgreeRecipient;
import org.spongycastle.operator.DefaultSecretKeySizeProvider;
import org.spongycastle.operator.SecretKeySizeProvider;
import org.spongycastle.util.Pack;

public abstract class JceKeyAgreeRecipient implements KeyAgreeRecipient {
    private static KeyMaterialGenerator ecc_cms_Generator = new RFC5753KeyMaterialGenerator();
    private static KeyMaterialGenerator old_ecc_cms_Generator = new KeyMaterialGenerator() {
        public byte[] generateKDFMaterial(AlgorithmIdentifier algorithmIdentifier, int i, byte[] bArr) {
            try {
                return new ECCCMSSharedInfo(new AlgorithmIdentifier(algorithmIdentifier.getAlgorithm(), DERNull.INSTANCE), bArr, Pack.intToBigEndian(i)).getEncoded(ASN1Encoding.DER);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to create KDF material: " + e);
            }
        }
    };
    private static final Set possibleOldMessages = new HashSet();
    protected EnvelopedDataHelper contentHelper = this.helper;
    protected EnvelopedDataHelper helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    private SecretKeySizeProvider keySizeProvider = new DefaultSecretKeySizeProvider();
    private PrivateKey recipientKey;

    static {
        possibleOldMessages.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
        possibleOldMessages.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
    }

    public JceKeyAgreeRecipient(PrivateKey privateKey) {
        this.recipientKey = privateKey;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.security.spec.AlgorithmParameterSpec] */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.crypto.SecretKey calculateAgreedWrapKey(org.spongycastle.asn1.x509.AlgorithmIdentifier r6, org.spongycastle.asn1.x509.AlgorithmIdentifier r7, java.security.PublicKey r8, org.spongycastle.asn1.ASN1OctetString r9, java.security.PrivateKey r10, org.spongycastle.cms.jcajce.KeyMaterialGenerator r11) {
        /*
            r5 = this;
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r6.getAlgorithm()
            boolean r0 = org.spongycastle.cms.jcajce.CMSUtils.isMQV(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x007e
            byte[] r9 = r9.getOctets()
            org.spongycastle.asn1.cms.ecc.MQVuserKeyingMaterial r9 = org.spongycastle.asn1.cms.ecc.MQVuserKeyingMaterial.getInstance(r9)
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r0 = new org.spongycastle.asn1.x509.SubjectPublicKeyInfo
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = r5.getPrivateKeyAlgorithmIdentifier()
            org.spongycastle.asn1.cms.OriginatorPublicKey r4 = r9.getEphemeralPublicKey()
            org.spongycastle.asn1.DERBitString r4 = r4.getPublicKey()
            byte[] r4 = r4.getBytes()
            r0.<init>((org.spongycastle.asn1.x509.AlgorithmIdentifier) r3, (byte[]) r4)
            java.security.spec.X509EncodedKeySpec r3 = new java.security.spec.X509EncodedKeySpec
            byte[] r0 = r0.getEncoded()
            r3.<init>(r0)
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r0 = r5.helper
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r6.getAlgorithm()
            java.security.KeyFactory r0 = r0.createKeyFactory(r4)
            java.security.PublicKey r0 = r0.generatePublic(r3)
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r3 = r5.helper
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r6.getAlgorithm()
            javax.crypto.KeyAgreement r6 = r3.createKeyAgreement(r6)
            org.spongycastle.asn1.ASN1OctetString r3 = r9.getAddedukm()
            if (r3 == 0) goto L_0x0058
            org.spongycastle.asn1.ASN1OctetString r9 = r9.getAddedukm()
            byte[] r2 = r9.getOctets()
        L_0x0058:
            org.spongycastle.cms.jcajce.KeyMaterialGenerator r9 = old_ecc_cms_Generator
            if (r11 != r9) goto L_0x0066
            org.spongycastle.operator.SecretKeySizeProvider r11 = r5.keySizeProvider
            int r11 = r11.getKeySize((org.spongycastle.asn1.x509.AlgorithmIdentifier) r7)
            byte[] r2 = r9.generateKDFMaterial(r7, r11, r2)
        L_0x0066:
            org.spongycastle.jcajce.spec.MQVParameterSpec r9 = new org.spongycastle.jcajce.spec.MQVParameterSpec
            r9.<init>((java.security.PrivateKey) r10, (java.security.PublicKey) r0, (byte[]) r2)
            r6.init(r10, r9)
            r6.doPhase(r8, r1)
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = r7.getAlgorithm()
            java.lang.String r7 = r7.getId()
            javax.crypto.SecretKey r6 = r6.generateSecret(r7)
            return r6
        L_0x007e:
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r0 = r5.helper
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r6.getAlgorithm()
            javax.crypto.KeyAgreement r0 = r0.createKeyAgreement(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r6.getAlgorithm()
            boolean r3 = org.spongycastle.cms.jcajce.CMSUtils.isEC(r3)
            if (r3 == 0) goto L_0x00b8
            if (r9 == 0) goto L_0x00a8
            org.spongycastle.operator.SecretKeySizeProvider r6 = r5.keySizeProvider
            int r6 = r6.getKeySize((org.spongycastle.asn1.x509.AlgorithmIdentifier) r7)
            byte[] r9 = r9.getOctets()
            byte[] r6 = r11.generateKDFMaterial(r7, r6, r9)
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r2 = new org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            r2.<init>(r6)
            goto L_0x00e3
        L_0x00a8:
            org.spongycastle.operator.SecretKeySizeProvider r6 = r5.keySizeProvider
            int r6 = r6.getKeySize((org.spongycastle.asn1.x509.AlgorithmIdentifier) r7)
            byte[] r6 = r11.generateKDFMaterial(r7, r6, r2)
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r2 = new org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            r2.<init>(r6)
            goto L_0x00e3
        L_0x00b8:
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r6.getAlgorithm()
            boolean r11 = org.spongycastle.cms.jcajce.CMSUtils.isRFC2631(r11)
            if (r11 == 0) goto L_0x00ce
            if (r9 == 0) goto L_0x00e3
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r2 = new org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            byte[] r6 = r9.getOctets()
            r2.<init>(r6)
            goto L_0x00e3
        L_0x00ce:
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r6.getAlgorithm()
            boolean r11 = org.spongycastle.cms.jcajce.CMSUtils.isGOST(r11)
            if (r11 == 0) goto L_0x00f6
            if (r9 == 0) goto L_0x00e3
            org.spongycastle.jcajce.spec.UserKeyingMaterialSpec r2 = new org.spongycastle.jcajce.spec.UserKeyingMaterialSpec
            byte[] r6 = r9.getOctets()
            r2.<init>(r6)
        L_0x00e3:
            r0.init(r10, r2)
            r0.doPhase(r8, r1)
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r7.getAlgorithm()
            java.lang.String r6 = r6.getId()
            javax.crypto.SecretKey r6 = r0.generateSecret(r6)
            return r6
        L_0x00f6:
            org.spongycastle.cms.CMSException r7 = new org.spongycastle.cms.CMSException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unknown key agreement algorithm: "
            r8.append(r9)
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r6.getAlgorithm()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.JceKeyAgreeRecipient.calculateAgreedWrapKey(org.spongycastle.asn1.x509.AlgorithmIdentifier, org.spongycastle.asn1.x509.AlgorithmIdentifier, java.security.PublicKey, org.spongycastle.asn1.ASN1OctetString, java.security.PrivateKey, org.spongycastle.cms.jcajce.KeyMaterialGenerator):javax.crypto.SecretKey");
    }

    private Key unwrapSessionKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey, ASN1ObjectIdentifier aSN1ObjectIdentifier2, byte[] bArr) {
        Cipher createCipher = this.helper.createCipher(aSN1ObjectIdentifier);
        createCipher.init(4, secretKey);
        return createCipher.unwrap(bArr, this.helper.getBaseCipherName(aSN1ObjectIdentifier2), 3);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c1, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c9, code lost:
        throw new org.spongycastle.cms.CMSException("originator key invalid.", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ca, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d2, code lost:
        throw new org.spongycastle.cms.CMSException("required padding not supported.", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d3, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00db, code lost:
        throw new org.spongycastle.cms.CMSException("originator key spec invalid.", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e5, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ed, code lost:
        throw new org.spongycastle.cms.CMSException("can't find algorithm.", r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c1 A[ExcHandler: Exception (r9v5 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ca A[ExcHandler: NoSuchPaddingException (r9v4 'e' javax.crypto.NoSuchPaddingException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d3 A[ExcHandler: InvalidKeySpecException (r9v3 'e' java.security.spec.InvalidKeySpecException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e5 A[ExcHandler: NoSuchAlgorithmException (r9v1 'e' java.security.NoSuchAlgorithmException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.Key extractSecretKey(org.spongycastle.asn1.x509.AlgorithmIdentifier r9, org.spongycastle.asn1.x509.AlgorithmIdentifier r10, org.spongycastle.asn1.x509.SubjectPublicKeyInfo r11, org.spongycastle.asn1.ASN1OctetString r12, byte[] r13) {
        /*
            r8 = this;
            org.spongycastle.asn1.ASN1Encodable r0 = r9.getParameters()     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = org.spongycastle.asn1.x509.AlgorithmIdentifier.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            java.security.spec.X509EncodedKeySpec r1 = new java.security.spec.X509EncodedKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            byte[] r2 = r11.getEncoded()     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            r1.<init>(r2)     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r2 = r8.helper     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r11 = r11.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r11.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            java.security.KeyFactory r11 = r2.createKeyFactory(r11)     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            java.security.PublicKey r11 = r11.generatePublic(r1)     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            java.security.PrivateKey r6 = r8.recipientKey     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.cms.jcajce.KeyMaterialGenerator r7 = ecc_cms_Generator     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            r1 = r8
            r2 = r9
            r3 = r0
            r4 = r11
            r5 = r12
            javax.crypto.SecretKey r1 = r1.calculateAgreedWrapKey(r2, r3, r4, r5, r6, r7)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r0.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            boolean r2 = r2.equals(r3)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            if (r2 != 0) goto L_0x0056
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r0.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            boolean r2 = r2.equals(r3)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            if (r2 == 0) goto L_0x0049
            goto L_0x0056
        L_0x0049:
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r0.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r10.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            java.security.Key r9 = r8.unwrapSessionKey(r2, r1, r3, r13)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            return r9
        L_0x0056:
            org.spongycastle.asn1.cryptopro.Gost2814789EncryptedKey r2 = org.spongycastle.asn1.cryptopro.Gost2814789EncryptedKey.getInstance(r13)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1Encodable r3 = r0.getParameters()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.cryptopro.Gost2814789KeyWrapParameters r3 = org.spongycastle.asn1.cryptopro.Gost2814789KeyWrapParameters.getInstance(r3)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r4 = r8.helper     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = r0.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            javax.crypto.Cipher r4 = r4.createCipher(r5)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            r5 = 4
            org.spongycastle.jcajce.spec.GOST28147WrapParameterSpec r6 = new org.spongycastle.jcajce.spec.GOST28147WrapParameterSpec     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r3.getEncryptionParamSet()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            byte[] r7 = r12.getOctets()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            r6.<init>((org.spongycastle.asn1.ASN1ObjectIdentifier) r3, (byte[]) r7)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            r4.init(r5, r1, r6)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            byte[] r1 = r2.getEncryptedKey()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            byte[] r2 = r2.getMacKey()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            byte[] r1 = org.spongycastle.util.Arrays.concatenate((byte[]) r1, (byte[]) r2)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.cms.jcajce.EnvelopedDataHelper r2 = r8.helper     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r10.getAlgorithm()     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            java.lang.String r2 = r2.getBaseCipherName(r3)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            r3 = 3
            java.security.Key r9 = r4.unwrap(r1, r2, r3)     // Catch:{ InvalidKeyException -> 0x0099, NoSuchAlgorithmException -> 0x00e5, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            return r9
        L_0x0099:
            r1 = move-exception
            java.util.Set r2 = possibleOldMessages     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r9.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            boolean r2 = r2.contains(r3)     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            if (r2 == 0) goto L_0x00c0
            java.security.PrivateKey r6 = r8.recipientKey     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.cms.jcajce.KeyMaterialGenerator r7 = old_ecc_cms_Generator     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            r1 = r8
            r2 = r9
            r3 = r0
            r4 = r11
            r5 = r12
            javax.crypto.SecretKey r9 = r1.calculateAgreedWrapKey(r2, r3, r4, r5, r6, r7)     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r0.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = r10.getAlgorithm()     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            java.security.Key r9 = r8.unwrapSessionKey(r11, r9, r10, r13)     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
            return r9
        L_0x00c0:
            throw r1     // Catch:{ NoSuchAlgorithmException -> 0x00e5, InvalidKeyException -> 0x00dc, InvalidKeySpecException -> 0x00d3, NoSuchPaddingException -> 0x00ca, Exception -> 0x00c1 }
        L_0x00c1:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "originator key invalid."
            r10.<init>(r11, r9)
            throw r10
        L_0x00ca:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "required padding not supported."
            r10.<init>(r11, r9)
            throw r10
        L_0x00d3:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "originator key spec invalid."
            r10.<init>(r11, r9)
            throw r10
        L_0x00dc:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "key invalid in message."
            r10.<init>(r11, r9)
            throw r10
        L_0x00e5:
            r9 = move-exception
            org.spongycastle.cms.CMSException r10 = new org.spongycastle.cms.CMSException
            java.lang.String r11 = "can't find algorithm."
            r10.<init>(r11, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cms.jcajce.JceKeyAgreeRecipient.extractSecretKey(org.spongycastle.asn1.x509.AlgorithmIdentifier, org.spongycastle.asn1.x509.AlgorithmIdentifier, org.spongycastle.asn1.x509.SubjectPublicKeyInfo, org.spongycastle.asn1.ASN1OctetString, byte[]):java.security.Key");
    }

    public AlgorithmIdentifier getPrivateKeyAlgorithmIdentifier() {
        return PrivateKeyInfo.getInstance(this.recipientKey.getEncoded()).getPrivateKeyAlgorithm();
    }

    public JceKeyAgreeRecipient setContentProvider(String str) {
        this.contentHelper = CMSUtils.createContentHelper(str);
        return this;
    }

    public JceKeyAgreeRecipient setContentProvider(Provider provider) {
        this.contentHelper = CMSUtils.createContentHelper(provider);
        return this;
    }

    public JceKeyAgreeRecipient setProvider(String str) {
        this.helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        this.contentHelper = this.helper;
        return this;
    }

    public JceKeyAgreeRecipient setProvider(Provider provider) {
        this.helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        this.contentHelper = this.helper;
        return this;
    }
}

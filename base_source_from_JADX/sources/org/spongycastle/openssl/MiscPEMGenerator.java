package org.spongycastle.openssl;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.p176x9.X9ObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.X509AttributeCertificateHolder;
import org.spongycastle.cert.X509CRLHolder;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.pkcs.PKCS10CertificationRequest;
import org.spongycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.spongycastle.util.Strings;
import org.spongycastle.util.p191io.pem.PemGenerationException;
import org.spongycastle.util.p191io.pem.PemHeader;
import org.spongycastle.util.p191io.pem.PemObject;
import org.spongycastle.util.p191io.pem.PemObjectGenerator;

public class MiscPEMGenerator implements PemObjectGenerator {
    private static final ASN1ObjectIdentifier[] dsaOids = {X9ObjectIdentifiers.id_dsa, OIWObjectIdentifiers.dsaWithSHA1};
    private static final byte[] hexEncodingTable = {ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SET_TYPE, 50, 51, 52, 53, 54, 55, 56, 57, 65, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 67, 68, 69, 70};
    private final PEMEncryptor encryptor;
    private final Object obj;

    public MiscPEMGenerator(Object obj2) {
        this.obj = obj2;
        this.encryptor = null;
    }

    public MiscPEMGenerator(Object obj2, PEMEncryptor pEMEncryptor) {
        this.obj = obj2;
        this.encryptor = pEMEncryptor;
    }

    private PemObject createPemObject(Object obj2) {
        byte[] bArr;
        String str;
        if (obj2 instanceof PemObject) {
            return (PemObject) obj2;
        }
        if (obj2 instanceof PemObjectGenerator) {
            return ((PemObjectGenerator) obj2).generate();
        }
        if (obj2 instanceof X509CertificateHolder) {
            str = "CERTIFICATE";
            bArr = ((X509CertificateHolder) obj2).getEncoded();
        } else if (obj2 instanceof X509CRLHolder) {
            str = "X509 CRL";
            bArr = ((X509CRLHolder) obj2).getEncoded();
        } else if (obj2 instanceof X509TrustedCertificateBlock) {
            str = "TRUSTED CERTIFICATE";
            bArr = ((X509TrustedCertificateBlock) obj2).getEncoded();
        } else if (obj2 instanceof PrivateKeyInfo) {
            PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) obj2;
            ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
            if (algorithm.equals(PKCSObjectIdentifiers.rsaEncryption)) {
                str = "RSA PRIVATE KEY";
            } else if (algorithm.equals(dsaOids[0]) || algorithm.equals(dsaOids[1])) {
                str = "DSA PRIVATE KEY";
                DSAParameter instance = DSAParameter.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.add(new ASN1Integer(0));
                aSN1EncodableVector.add(new ASN1Integer(instance.getP()));
                aSN1EncodableVector.add(new ASN1Integer(instance.getQ()));
                aSN1EncodableVector.add(new ASN1Integer(instance.getG()));
                BigInteger value = ASN1Integer.getInstance(privateKeyInfo.parsePrivateKey()).getValue();
                aSN1EncodableVector.add(new ASN1Integer(instance.getG().modPow(value, instance.getP())));
                aSN1EncodableVector.add(new ASN1Integer(value));
                bArr = new DERSequence(aSN1EncodableVector).getEncoded();
            } else if (algorithm.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
                str = "EC PRIVATE KEY";
            } else {
                throw new IOException("Cannot identify private key");
            }
            bArr = privateKeyInfo.parsePrivateKey().toASN1Primitive().getEncoded();
        } else if (obj2 instanceof SubjectPublicKeyInfo) {
            str = "PUBLIC KEY";
            bArr = ((SubjectPublicKeyInfo) obj2).getEncoded();
        } else if (obj2 instanceof X509AttributeCertificateHolder) {
            str = "ATTRIBUTE CERTIFICATE";
            bArr = ((X509AttributeCertificateHolder) obj2).getEncoded();
        } else if (obj2 instanceof PKCS10CertificationRequest) {
            str = "CERTIFICATE REQUEST";
            bArr = ((PKCS10CertificationRequest) obj2).getEncoded();
        } else if (obj2 instanceof PKCS8EncryptedPrivateKeyInfo) {
            str = "ENCRYPTED PRIVATE KEY";
            bArr = ((PKCS8EncryptedPrivateKeyInfo) obj2).getEncoded();
        } else if (obj2 instanceof ContentInfo) {
            str = "PKCS7";
            bArr = ((ContentInfo) obj2).getEncoded();
        } else {
            throw new PemGenerationException("unknown object passed - can't encode.");
        }
        PEMEncryptor pEMEncryptor = this.encryptor;
        if (pEMEncryptor == null) {
            return new PemObject(str, bArr);
        }
        String upperCase = Strings.toUpperCase(pEMEncryptor.getAlgorithm());
        if (upperCase.equals("DESEDE")) {
            upperCase = "DES-EDE3-CBC";
        }
        byte[] iv = this.encryptor.getIV();
        byte[] encrypt = this.encryptor.encrypt(bArr);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        arrayList.add(new PemHeader("DEK-Info", upperCase + "," + getHexEncoded(iv)));
        return new PemObject(str, arrayList, encrypt);
    }

    private String getHexEncoded(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i != bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            byte[] bArr2 = hexEncodingTable;
            cArr[i2] = (char) bArr2[b >>> 4];
            cArr[i2 + 1] = (char) bArr2[b & 15];
        }
        return new String(cArr);
    }

    public PemObject generate() {
        try {
            return createPemObject(this.obj);
        } catch (IOException e) {
            throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        }
    }
}

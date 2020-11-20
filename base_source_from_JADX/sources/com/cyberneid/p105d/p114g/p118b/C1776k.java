package com.cyberneid.p105d.p114g.p118b;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.C1783c;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.EncryptedContentInfo;
import org.spongycastle.asn1.cms.EnvelopedData;
import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.asn1.cms.KeyTransRecipientInfo;
import org.spongycastle.asn1.cms.OriginatorInfo;
import org.spongycastle.asn1.cms.RecipientIdentifier;
import org.spongycastle.asn1.cms.RecipientInfo;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.TBSCertificateStructure;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cms.CMSEnvelopedData;
import org.spongycastle.cms.CMSException;
import org.spongycastle.cms.KeyTransRecipientId;
import org.spongycastle.cms.RecipientId;
import org.spongycastle.cms.RecipientInformation;
import org.spongycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.cyberneid.d.g.b.k */
public final class C1776k extends C1778m {

    /* renamed from: c */
    private C1774i f5756c = null;

    /* renamed from: a */
    private ASN1Primitive m7133a(byte[] bArr, X509Certificate x509Certificate) {
        try {
            AlgorithmParameterGenerator instance = AlgorithmParameterGenerator.getInstance("1.2.840.113549.3.2");
            KeyGenerator instance2 = KeyGenerator.getInstance("1.2.840.113549.3.2", BouncyCastleProvider.PROVIDER_NAME);
            Cipher instance3 = Cipher.getInstance("1.2.840.113549.3.2", BouncyCastleProvider.PROVIDER_NAME);
            AlgorithmParameters generateParameters = instance.generateParameters();
            ASN1InputStream aSN1InputStream = new ASN1InputStream(generateParameters.getEncoded("ASN.1"));
            ASN1Primitive readObject = aSN1InputStream.readObject();
            aSN1InputStream.close();
            instance2.init(128);
            SecretKey generateKey = instance2.generateKey();
            instance3.init(1, generateKey, generateParameters);
            byte[] doFinal = instance3.doFinal(bArr);
            return new ContentInfo(PKCSObjectIdentifiers.envelopedData, new EnvelopedData((OriginatorInfo) null, (ASN1Set) new DERSet((ASN1Encodable) new RecipientInfo(m7134a(x509Certificate, generateKey.getEncoded()))), new EncryptedContentInfo(PKCSObjectIdentifiers.data, new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.2.840.113549.3.2"), readObject), new DEROctetString(doFinal)), (ASN1Set) null)).toASN1Primitive();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not find a suitable javax.crypto provider", e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException("Could not find a suitable javax.crypto provider", e2);
        }
    }

    /* renamed from: a */
    private KeyTransRecipientInfo m7134a(X509Certificate x509Certificate, byte[] bArr) {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(x509Certificate.getTBSCertificate());
        TBSCertificateStructure instance = TBSCertificateStructure.getInstance(aSN1InputStream.readObject());
        aSN1InputStream.close();
        AlgorithmIdentifier algorithm = instance.getSubjectPublicKeyInfo().getAlgorithm();
        IssuerAndSerialNumber issuerAndSerialNumber = new IssuerAndSerialNumber(instance.getIssuer(), instance.getSerialNumber().getValue());
        try {
            Cipher instance2 = Cipher.getInstance(algorithm.getAlgorithm().getId());
            instance2.init(1, x509Certificate.getPublicKey());
            return new KeyTransRecipientInfo(new RecipientIdentifier(issuerAndSerialNumber), algorithm, new DEROctetString(instance2.doFinal(bArr)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not find a suitable javax.crypto provider", e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException("Could not find a suitable javax.crypto provider", e2);
        }
    }

    /* renamed from: a */
    private void m7135a(StringBuilder sb, KeyTransRecipientId keyTransRecipientId, X509Certificate x509Certificate, X509CertificateHolder x509CertificateHolder) {
        BigInteger serialNumber = keyTransRecipientId.getSerialNumber();
        if (serialNumber != null) {
            String str = "unknown";
            BigInteger serialNumber2 = x509Certificate.getSerialNumber();
            if (serialNumber2 != null) {
                str = serialNumber2.toString(16);
            }
            sb.append("serial-#: rid ");
            sb.append(serialNumber.toString(16));
            sb.append(" vs. cert ");
            sb.append(str);
            sb.append(" issuer: rid '");
            sb.append(keyTransRecipientId.getIssuer());
            sb.append("' vs. cert '");
            sb.append(x509CertificateHolder == null ? "null" : x509CertificateHolder.getIssuer());
            sb.append("' ");
        }
    }

    /* renamed from: a */
    private byte[][] m7136a(byte[] bArr) {
        byte[][] bArr2 = new byte[this.f5756c.mo8020b()][];
        Iterator<C1775j> a = this.f5756c.mo8019a();
        int i = 0;
        while (a.hasNext()) {
            C1775j next = a.next();
            X509Certificate a2 = next.mo8021a();
            int b = next.mo8022b().mo7963b();
            byte[] bArr3 = new byte[24];
            System.arraycopy(bArr, 0, bArr3, 0, 20);
            bArr3[20] = (byte) (b >>> 24);
            bArr3[21] = (byte) (b >>> 16);
            bArr3[22] = (byte) (b >>> 8);
            bArr3[23] = (byte) b;
            ASN1Primitive a3 = m7133a(bArr3, a2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new DEROutputStream(byteArrayOutputStream).writeObject(a3);
            bArr2[i] = byteArrayOutputStream.toByteArray();
            i++;
        }
        return bArr2;
    }

    /* renamed from: a */
    public void mo8023a(C1771f fVar, C1604a aVar, C1767b bVar) {
        C1767b bVar2 = bVar;
        if (bVar2 instanceof C1773h) {
            mo8036a(fVar.mo8012l());
            if (fVar.mo8004e() != 0) {
                this.f5761a = fVar.mo8004e();
            }
            C1773h hVar = (C1773h) bVar2;
            try {
                byte[][] bArr = new byte[fVar.mo8013m()][];
                StringBuilder sb = new StringBuilder();
                int i = 0;
                boolean z = false;
                byte[] bArr2 = null;
                int i2 = 0;
                while (i < fVar.mo8013m()) {
                    byte[] c = fVar.mo8005e(i).mo7643c();
                    Iterator<RecipientInformation> it = new CMSEnvelopedData(c).getRecipientInfos().getRecipients().iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        RecipientInformation next = it.next();
                        X509Certificate a = hVar.mo8017a();
                        X509CertificateHolder x509CertificateHolder = a != null ? new X509CertificateHolder(a.getEncoded()) : null;
                        RecipientId rid = next.getRID();
                        if (rid.match(x509CertificateHolder) && !z) {
                            bArr2 = next.getContent(new JceKeyTransEnvelopedRecipient((PrivateKey) hVar.mo8018b()).setProvider(BouncyCastleProvider.PROVIDER_NAME));
                            z = true;
                            break;
                        }
                        i3++;
                        if (a != null) {
                            sb.append(10);
                            sb.append(i3);
                            sb.append(": ");
                            if (rid instanceof KeyTransRecipientId) {
                                m7135a(sb, (KeyTransRecipientId) rid, a, x509CertificateHolder);
                            }
                        }
                    }
                    bArr[i] = c;
                    i2 += c.length;
                    i++;
                }
                if (!z || bArr2 == null) {
                    throw new IOException("The certificate matches none of " + i + " recipient entries" + sb.toString());
                } else if (bArr2.length == 24) {
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArr2, 20, bArr3, 0, 4);
                    C1766a aVar2 = new C1766a(bArr3);
                    aVar2.mo7977i();
                    mo8035a(aVar2);
                    byte[] bArr4 = new byte[(i2 + 20)];
                    int i4 = 0;
                    System.arraycopy(bArr2, 0, bArr4, 0, 20);
                    int length = bArr.length;
                    int i5 = 0;
                    int i6 = 20;
                    while (i5 < length) {
                        byte[] bArr5 = bArr[i5];
                        System.arraycopy(bArr5, i4, bArr4, i6, bArr5.length);
                        i6 += bArr5.length;
                        i5++;
                        i4 = 0;
                    }
                    byte[] digest = C1769d.m7089b().digest(bArr4);
                    this.f5762b = new byte[(this.f5761a / 8)];
                    System.arraycopy(digest, 0, this.f5762b, 0, this.f5761a / 8);
                } else {
                    throw new IOException("The enveloped data does not contain 24 bytes");
                }
            } catch (CMSException e) {
                throw new IOException(e);
            } catch (KeyStoreException e2) {
                throw new IOException(e2);
            } catch (CertificateEncodingException e3) {
                throw new IOException(e3);
            }
        } else {
            throw new IOException("Provided decryption material is not compatible with the document");
        }
    }

    /* renamed from: a */
    public void mo8024a(C1783c cVar) {
        if (this.f5761a != 256) {
            try {
                Security.addProvider(new BouncyCastleProvider());
                C1771f d = cVar.mo8066d();
                if (d == null) {
                    d = new C1771f();
                }
                d.mo7989a("Adobe.PubSec");
                d.mo7993b(this.f5761a);
                d.mo7986a(2);
                d.mo8016p();
                d.mo7995b("adbe.pkcs7.s4");
                byte[] bArr = new byte[20];
                KeyGenerator instance = KeyGenerator.getInstance("AES");
                instance.init(192, new SecureRandom());
                System.arraycopy(instance.generateKey().getEncoded(), 0, bArr, 0, 20);
                d.mo7991a(m7136a(bArr));
                int length = bArr.length;
                for (int i = 0; i < d.mo8013m(); i++) {
                    length += d.mo8005e(i).mo7643c().length;
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, 20);
                int i2 = 20;
                for (int i3 = 0; i3 < d.mo8013m(); i3++) {
                    C1622p e = d.mo8005e(i3);
                    System.arraycopy(e.mo7643c(), 0, bArr2, i2, e.mo7643c().length);
                    i2 += e.mo7643c().length;
                }
                byte[] digest = C1769d.m7089b().digest(bArr2);
                this.f5762b = new byte[(this.f5761a / 8)];
                System.arraycopy(digest, 0, this.f5762b, 0, this.f5761a / 8);
                cVar.mo8056a(d);
                cVar.mo8053a().mo7566b(d.mo7992b());
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            } catch (GeneralSecurityException e3) {
                throw new IOException(e3);
            }
        } else {
            throw new IOException("256 bit key length is not supported yet for public key security");
        }
    }

    /* renamed from: a */
    public boolean mo8025a() {
        return this.f5756c != null;
    }
}

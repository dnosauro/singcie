package com.cyberneid.p087a;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.IOException;
import java.util.Date;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERUTCTime;
import org.spongycastle.asn1.cms.CMSAttributes;
import org.spongycastle.asn1.cms.CMSObjectIdentifiers;
import org.spongycastle.asn1.ess.ESSCertIDv2;
import org.spongycastle.asn1.ess.SigningCertificateV2;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.crypto.digests.SHA256Digest;

/* renamed from: com.cyberneid.a.f */
class C1457f {

    /* renamed from: a */
    public static String f4322a;

    /* renamed from: b */
    private static String f4323b;

    /* renamed from: c */
    private static final byte[] f4324c = {-105, 53, 116, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -42, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -78, 70, -102, -85, ASN1Constants.UNIVERSAL_SET_TYPE, 33, -29, -27, 28, 85};

    /* renamed from: d */
    private boolean f4325d = true;

    /* renamed from: a */
    private ASN1EncodableVector m5488a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.2.14"));
        try {
            aSN1EncodableVector2.add(new DERSet((ASN1Encodable) (ASN1Sequence) aSN1InputStream.readObject()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return aSN1EncodableVector;
    }

    /* renamed from: a */
    private ASN1EncodableVector m5489a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (z) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(CMSAttributes.contentType);
            aSN1EncodableVector3.add(CMSObjectIdentifiers.data);
            aSN1EncodableVector2.add(new DERSet(aSN1EncodableVector3));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
            aSN1EncodableVector4.add(CMSAttributes.messageDigest);
            aSN1EncodableVector5.add(new DEROctetString(bArr));
            aSN1EncodableVector4.add(new DERSet(aSN1EncodableVector5));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
            aSN1EncodableVector6.add(PKCSObjectIdentifiers.id_aa_signingCertificateV2);
            X509CertificateStructure instance = X509CertificateStructure.getInstance((ASN1Sequence) ASN1Sequence.fromByteArray(bArr2));
            SHA256Digest sHA256Digest = new SHA256Digest();
            byte[] bArr3 = new byte[sHA256Digest.getDigestSize()];
            sHA256Digest.update(bArr2, 0, bArr2.length);
            sHA256Digest.doFinal(bArr3, 0);
            aSN1EncodableVector7.add(new SigningCertificateV2(new ESSCertIDv2[]{new ESSCertIDv2(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256), bArr3, new IssuerSerial(new GeneralNames(new GeneralName(instance.getIssuer())), instance.getSerialNumber()))}));
            aSN1EncodableVector6.add(new DERSet(aSN1EncodableVector7));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector6));
        }
        if (z2) {
            Date date = new Date();
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            aSN1EncodableVector8.add(CMSAttributes.signingTime);
            aSN1EncodableVector9.add(new DERUTCTime(date));
            aSN1EncodableVector8.add(new DERSet(aSN1EncodableVector9));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector8));
        }
        return aSN1EncodableVector;
    }

    /* renamed from: a */
    public static void m5490a(String str, String str2) {
        f4322a = str;
        f4323b = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0232 A[EDGE_INSN: B:99:0x0232->B:68:0x0232 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.asn1.cms.ContentInfo mo6920a(byte[] r24, com.cyberneid.p087a.C1465m r25, boolean r26, boolean r27, boolean r28, com.cyberneid.p087a.C1468p r29) {
        /*
            r23 = this;
            r1 = r23
            r0 = r29
            r3 = 0
            if (r28 == 0) goto L_0x0039
            org.spongycastle.asn1.ASN1Primitive r4 = org.spongycastle.asn1.ASN1Primitive.fromByteArray(r24)     // Catch:{ Exception -> 0x0034 }
            org.spongycastle.asn1.cms.ContentInfo r4 = org.spongycastle.asn1.cms.ContentInfo.getInstance(r4)     // Catch:{ Exception -> 0x0034 }
            org.spongycastle.asn1.ASN1Encodable r5 = r4.getContent()     // Catch:{ Exception -> 0x0035 }
            org.spongycastle.asn1.cms.SignedData r5 = org.spongycastle.asn1.cms.SignedData.getInstance(r5)     // Catch:{ Exception -> 0x0035 }
            org.spongycastle.asn1.cms.ContentInfo r5 = r5.getEncapContentInfo()     // Catch:{ Exception -> 0x0035 }
            org.spongycastle.asn1.ASN1Encodable r5 = r5.getContent()     // Catch:{ Exception -> 0x0035 }
            org.spongycastle.asn1.ASN1Primitive r5 = r5.toASN1Primitive()     // Catch:{ Exception -> 0x0035 }
            byte[] r5 = r5.getEncoded()     // Catch:{ Exception -> 0x0035 }
            org.spongycastle.asn1.ASN1Primitive r5 = org.spongycastle.asn1.ASN1OctetString.fromByteArray(r5)     // Catch:{ Exception -> 0x0035 }
            org.spongycastle.asn1.ASN1OctetString r5 = (org.spongycastle.asn1.ASN1OctetString) r5     // Catch:{ Exception -> 0x0035 }
            byte[] r5 = r5.getOctets()     // Catch:{ Exception -> 0x0035 }
            r6 = r28
            goto L_0x003e
        L_0x0034:
            r4 = 0
        L_0x0035:
            r5 = r24
            r6 = 0
            goto L_0x003e
        L_0x0039:
            r5 = r24
            r6 = r28
            r4 = 0
        L_0x003e:
            if (r26 == 0) goto L_0x0043
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = org.spongycastle.asn1.nist.NISTObjectIdentifiers.id_sha256
            goto L_0x0045
        L_0x0043:
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = org.spongycastle.asn1.x509.X509ObjectIdentifiers.id_SHA1
        L_0x0045:
            org.spongycastle.asn1.x509.Certificate r8 = r25.mo6944d()
            org.spongycastle.asn1.x509.Time r9 = r8.getEndDate()
            java.util.Date r9 = r9.getDate()
            java.util.Date r10 = new java.util.Date
            r10.<init>()
            boolean r9 = r9.after(r10)
            if (r9 == 0) goto L_0x02e0
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r9 = r8.getSubjectPublicKeyInfo()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r9 = r9.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r9 = r9.getAlgorithm()
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = org.spongycastle.asn1.p176x9.X9ObjectIdentifiers.id_ecPublicKey
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0073
            org.spongycastle.asn1.ASN1ObjectIdentifier r9 = org.spongycastle.asn1.p176x9.X9ObjectIdentifiers.ecdsa_with_SHA256
            goto L_0x007a
        L_0x0073:
            if (r26 == 0) goto L_0x0078
            org.spongycastle.asn1.ASN1ObjectIdentifier r9 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.sha256WithRSAEncryption
            goto L_0x007a
        L_0x0078:
            org.spongycastle.asn1.ASN1ObjectIdentifier r9 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.sha1WithRSAEncryption
        L_0x007a:
            byte[] r10 = r25.mo6943c()
            r11 = 1
            if (r26 == 0) goto L_0x00cd
            org.spongycastle.crypto.digests.SHA256Digest r12 = new org.spongycastle.crypto.digests.SHA256Digest
            r12.<init>()
            int r13 = r12.getDigestSize()
            byte[] r13 = new byte[r13]
            int r14 = r5.length
            r12.update(r5, r3, r14)
            r12.doFinal(r13, r3)
            r14 = r27 ^ 1
            org.spongycastle.asn1.ASN1EncodableVector r13 = r1.m5489a(r13, r10, r11, r14)
            org.spongycastle.asn1.DERSet r14 = new org.spongycastle.asn1.DERSet
            r14.<init>((org.spongycastle.asn1.ASN1EncodableVector) r13)
            int r12 = r12.getDigestSize()
            byte[] r12 = new byte[r12]
            org.spongycastle.crypto.digests.SHA256Digest r13 = new org.spongycastle.crypto.digests.SHA256Digest
            r13.<init>()
            byte[] r15 = r14.getEncoded()
            int r11 = r15.length
            r13.update(r15, r3, r11)
            r13.doFinal(r12, r3)
            boolean r11 = r25.mo6945e()
            if (r11 == 0) goto L_0x0103
            org.spongycastle.asn1.x509.DigestInfo r11 = new org.spongycastle.asn1.x509.DigestInfo
            org.spongycastle.asn1.x509.AlgorithmIdentifier r13 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.ASN1ObjectIdentifier r15 = org.spongycastle.asn1.nist.NISTObjectIdentifiers.id_sha256
            org.spongycastle.asn1.DERNull r2 = org.spongycastle.asn1.DERNull.INSTANCE
            r13.<init>(r15, r2)
            r11.<init>(r13, r12)
            byte[] r12 = r11.getEncoded()
            goto L_0x0103
        L_0x00cd:
            org.spongycastle.asn1.DERSet r14 = new org.spongycastle.asn1.DERSet
            r2 = r27 ^ 1
            r11 = 0
            org.spongycastle.asn1.ASN1EncodableVector r2 = r1.m5489a(r11, r11, r3, r2)
            r14.<init>((org.spongycastle.asn1.ASN1EncodableVector) r2)
            org.spongycastle.crypto.digests.SHA1Digest r2 = new org.spongycastle.crypto.digests.SHA1Digest
            r2.<init>()
            int r12 = r2.getDigestSize()
            byte[] r12 = new byte[r12]
            int r13 = r5.length
            r2.update(r5, r3, r13)
            r2.doFinal(r12, r3)
            boolean r2 = r25.mo6945e()
            if (r2 == 0) goto L_0x0103
            org.spongycastle.asn1.x509.DigestInfo r2 = new org.spongycastle.asn1.x509.DigestInfo
            org.spongycastle.asn1.x509.AlgorithmIdentifier r13 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.ASN1ObjectIdentifier r15 = org.spongycastle.asn1.x509.X509ObjectIdentifiers.id_SHA1
            org.spongycastle.asn1.DERNull r11 = org.spongycastle.asn1.DERNull.INSTANCE
            r13.<init>(r15, r11)
            r2.<init>(r13, r12)
            byte[] r12 = r2.getEncoded()
        L_0x0103:
            r2 = r25
            r19 = r14
            byte[] r2 = r2.mo6942a(r12)
            org.spongycastle.asn1.ASN1Primitive r10 = org.spongycastle.asn1.ASN1Sequence.fromByteArray(r10)
            org.spongycastle.asn1.ASN1Sequence r10 = (org.spongycastle.asn1.ASN1Sequence) r10
            org.spongycastle.asn1.x500.X500Name r11 = r8.getIssuer()
            org.spongycastle.asn1.cms.SignerIdentifier r12 = new org.spongycastle.asn1.cms.SignerIdentifier
            org.spongycastle.asn1.cms.IssuerAndSerialNumber r13 = new org.spongycastle.asn1.cms.IssuerAndSerialNumber
            org.spongycastle.asn1.ASN1Integer r14 = r8.getSerialNumber()
            java.math.BigInteger r14 = r14.getPositiveValue()
            r13.<init>((org.spongycastle.asn1.x500.X500Name) r11, (java.math.BigInteger) r14)
            r12.<init>((org.spongycastle.asn1.cms.IssuerAndSerialNumber) r13)
            if (r0 == 0) goto L_0x014f
            org.spongycastle.crypto.digests.SHA256Digest r11 = new org.spongycastle.crypto.digests.SHA256Digest
            r11.<init>()
            int r13 = r11.getDigestSize()
            byte[] r13 = new byte[r13]
            int r14 = r2.length
            r11.update(r2, r3, r14)
            r11.doFinal(r13, r3)
            byte[] r0 = r0.mo6950a(r13)
            if (r0 == 0) goto L_0x014f
            org.spongycastle.asn1.ASN1EncodableVector r0 = r1.m5488a(r0)
            if (r0 == 0) goto L_0x014f
            org.spongycastle.asn1.DERSet r11 = new org.spongycastle.asn1.DERSet
            r11.<init>((org.spongycastle.asn1.ASN1EncodableVector) r0)
            r22 = r11
            goto L_0x0151
        L_0x014f:
            r22 = 0
        L_0x0151:
            org.spongycastle.asn1.cms.SignerInfo r11 = new org.spongycastle.asn1.cms.SignerInfo
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.DERNull r13 = org.spongycastle.asn1.DERNull.INSTANCE
            r0.<init>(r7, r13)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r13 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            r13.<init>((org.spongycastle.asn1.ASN1ObjectIdentifier) r9)
            org.spongycastle.asn1.DEROctetString r9 = new org.spongycastle.asn1.DEROctetString
            r9.<init>((byte[]) r2)
            r16 = r11
            r17 = r12
            r18 = r0
            r20 = r13
            r21 = r9
            r16.<init>((org.spongycastle.asn1.cms.SignerIdentifier) r17, (org.spongycastle.asn1.x509.AlgorithmIdentifier) r18, (org.spongycastle.asn1.ASN1Set) r19, (org.spongycastle.asn1.x509.AlgorithmIdentifier) r20, (org.spongycastle.asn1.ASN1OctetString) r21, (org.spongycastle.asn1.ASN1Set) r22)
            org.spongycastle.asn1.ASN1EncodableVector r2 = new org.spongycastle.asn1.ASN1EncodableVector
            r2.<init>()
            org.spongycastle.asn1.ASN1EncodableVector r9 = new org.spongycastle.asn1.ASN1EncodableVector
            r9.<init>()
            org.spongycastle.asn1.ASN1EncodableVector r12 = new org.spongycastle.asn1.ASN1EncodableVector
            r12.<init>()
            if (r6 == 0) goto L_0x01fa
            org.spongycastle.asn1.ASN1Encodable r0 = r4.getContent()
            org.spongycastle.asn1.cms.SignedData r0 = org.spongycastle.asn1.cms.SignedData.getInstance(r0)
            org.spongycastle.asn1.ASN1Set r4 = r0.getCRLs()
            if (r4 == 0) goto L_0x01ae
            org.spongycastle.asn1.ASN1EncodableVector r4 = new org.spongycastle.asn1.ASN1EncodableVector
            r4.<init>()
            r6 = 0
        L_0x0196:
            org.spongycastle.asn1.ASN1Set r13 = r0.getCRLs()
            int r13 = r13.size()
            if (r6 >= r13) goto L_0x01af
            org.spongycastle.asn1.ASN1Set r13 = r0.getCRLs()
            org.spongycastle.asn1.ASN1Encodable r13 = r13.getObjectAt(r6)
            r4.add(r13)
            int r6 = r6 + 1
            goto L_0x0196
        L_0x01ae:
            r4 = 0
        L_0x01af:
            r6 = 0
        L_0x01b0:
            org.spongycastle.asn1.ASN1Set r13 = r0.getSignerInfos()
            int r13 = r13.size()
            if (r6 >= r13) goto L_0x01c8
            org.spongycastle.asn1.ASN1Set r13 = r0.getSignerInfos()
            org.spongycastle.asn1.ASN1Encodable r13 = r13.getObjectAt(r6)
            r2.add(r13)
            int r6 = r6 + 1
            goto L_0x01b0
        L_0x01c8:
            r6 = 0
        L_0x01c9:
            org.spongycastle.asn1.ASN1Set r13 = r0.getCertificates()
            int r13 = r13.size()
            if (r6 >= r13) goto L_0x01e1
            org.spongycastle.asn1.ASN1Set r13 = r0.getCertificates()
            org.spongycastle.asn1.ASN1Encodable r13 = r13.getObjectAt(r6)
            r9.add(r13)
            int r6 = r6 + 1
            goto L_0x01c9
        L_0x01e1:
            r6 = 0
        L_0x01e2:
            org.spongycastle.asn1.ASN1Set r13 = r0.getDigestAlgorithms()
            int r13 = r13.size()
            if (r6 >= r13) goto L_0x01fb
            org.spongycastle.asn1.ASN1Set r13 = r0.getDigestAlgorithms()
            org.spongycastle.asn1.ASN1Encodable r13 = r13.getObjectAt(r6)
            r12.add(r13)
            int r6 = r6 + 1
            goto L_0x01e2
        L_0x01fa:
            r4 = 0
        L_0x01fb:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.DERNull r6 = org.spongycastle.asn1.DERNull.INSTANCE
            r0.<init>(r7, r6)
            r6 = 0
        L_0x0203:
            int r7 = r12.size()
            if (r6 >= r7) goto L_0x0232
            org.spongycastle.asn1.ASN1Encodable r7 = r12.get(r6)
            org.spongycastle.asn1.ASN1Primitive r7 = r7.toASN1Primitive()
            org.spongycastle.asn1.DERSequence r7 = (org.spongycastle.asn1.DERSequence) r7
            org.spongycastle.asn1.x509.AlgorithmIdentifier r7 = org.spongycastle.asn1.x509.AlgorithmIdentifier.getInstance(r7)
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = r7.getAlgorithm()
            java.lang.String r7 = r7.getId()
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = r0.getAlgorithm()
            java.lang.String r13 = r13.getId()
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x022f
            r3 = 1
            goto L_0x0232
        L_0x022f:
            int r6 = r6 + 1
            goto L_0x0203
        L_0x0232:
            if (r3 != 0) goto L_0x0237
            r12.add(r0)
        L_0x0237:
            r2.add(r11)
            r9.add(r10)
            boolean r0 = r1.f4325d
            if (r0 == 0) goto L_0x027e
            java.lang.String r0 = "DER"
            byte[] r0 = r8.getEncoded(r0)
        L_0x0247:
            r3 = r0
        L_0x0248:
            if (r3 == 0) goto L_0x027e
            java.lang.String r0 = "X509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ Exception -> 0x0279 }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0279 }
            r6.<init>(r3)     // Catch:{ Exception -> 0x0279 }
            java.security.cert.Certificate r0 = r0.generateCertificate(r6)     // Catch:{ Exception -> 0x0279 }
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch:{ Exception -> 0x0279 }
            com.cyberneid.a.d r6 = com.cyberneid.p087a.C1455d.m5485a()     // Catch:{ Exception -> 0x0279 }
            org.spongycastle.jce.provider.X509CertificateObject r0 = r6.mo6919b(r0)     // Catch:{ Exception -> 0x0279 }
            if (r0 == 0) goto L_0x0277
            byte[] r6 = r0.getEncoded()     // Catch:{ Exception -> 0x0279 }
            org.spongycastle.asn1.ASN1Primitive r6 = org.spongycastle.asn1.ASN1Sequence.fromByteArray(r6)     // Catch:{ Exception -> 0x0279 }
            org.spongycastle.asn1.ASN1Sequence r6 = (org.spongycastle.asn1.ASN1Sequence) r6     // Catch:{ Exception -> 0x0279 }
            r9.add(r6)     // Catch:{ Exception -> 0x0279 }
            byte[] r0 = r0.getEncoded()     // Catch:{ Exception -> 0x0279 }
            goto L_0x0247
        L_0x0277:
            r3 = 0
            goto L_0x0248
        L_0x0279:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0248
        L_0x027e:
            org.spongycastle.asn1.DERSet r0 = new org.spongycastle.asn1.DERSet
            r0.<init>((org.spongycastle.asn1.ASN1EncodableVector) r12)
            org.spongycastle.asn1.DERSet r3 = new org.spongycastle.asn1.DERSet
            r3.<init>((org.spongycastle.asn1.ASN1EncodableVector) r2)
            org.spongycastle.asn1.DERSet r2 = new org.spongycastle.asn1.DERSet
            r2.<init>((org.spongycastle.asn1.ASN1EncodableVector) r9)
            if (r4 == 0) goto L_0x0295
            org.spongycastle.asn1.DERSet r6 = new org.spongycastle.asn1.DERSet
            r6.<init>((org.spongycastle.asn1.ASN1EncodableVector) r4)
            goto L_0x0296
        L_0x0295:
            r6 = 0
        L_0x0296:
            org.spongycastle.asn1.ASN1EncodableVector r4 = new org.spongycastle.asn1.ASN1EncodableVector
            r4.<init>()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r7 = new org.spongycastle.asn1.x509.AlgorithmIdentifier
            org.spongycastle.asn1.ASN1ObjectIdentifier r8 = org.spongycastle.asn1.x509.X509ObjectIdentifiers.id_SHA1
            org.spongycastle.asn1.DERNull r9 = org.spongycastle.asn1.DERNull.INSTANCE
            r7.<init>(r8, r9)
            r4.add(r7)
            org.spongycastle.asn1.ASN1EncodableVector r4 = new org.spongycastle.asn1.ASN1EncodableVector
            r4.<init>()
            r4.add(r11)
            org.spongycastle.asn1.ASN1EncodableVector r4 = new org.spongycastle.asn1.ASN1EncodableVector
            r4.<init>()
            r4.add(r10)
            org.spongycastle.asn1.cms.SignedData r4 = new org.spongycastle.asn1.cms.SignedData
            org.spongycastle.asn1.cms.ContentInfo r7 = new org.spongycastle.asn1.cms.ContentInfo
            org.spongycastle.asn1.ASN1ObjectIdentifier r8 = org.spongycastle.asn1.cms.CMSObjectIdentifiers.data
            if (r27 == 0) goto L_0x02c1
            r9 = 0
            goto L_0x02c6
        L_0x02c1:
            org.spongycastle.asn1.DEROctetString r9 = new org.spongycastle.asn1.DEROctetString
            r9.<init>((byte[]) r5)
        L_0x02c6:
            r7.<init>(r8, r9)
            r24 = r4
            r25 = r0
            r26 = r7
            r27 = r2
            r28 = r6
            r29 = r3
            r24.<init>(r25, r26, r27, r28, r29)
            org.spongycastle.asn1.cms.ContentInfo r0 = new org.spongycastle.asn1.cms.ContentInfo
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.cms.CMSObjectIdentifiers.signedData
            r0.<init>(r2, r4)
            return r0
        L_0x02e0:
            com.cyberneid.a.g r0 = new com.cyberneid.a.g
            r2 = -2130706258(0xffffffff810000ae, double:NaN)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p087a.C1457f.mo6920a(byte[], com.cyberneid.a.m, boolean, boolean, boolean, com.cyberneid.a.p):org.spongycastle.asn1.cms.ContentInfo");
    }
}

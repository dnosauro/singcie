package com.cyberneid.p087a;

import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DLSequence;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.asn1.x509.X509Extension;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.asn1.x509.qualified.QCStatement;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.selector.X509CertificateHolderSelector;
import org.spongycastle.cms.SignerInformation;
import org.spongycastle.util.Store;

/* renamed from: com.cyberneid.a.n */
public class C1466n {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046 A[SYNTHETIC, Splitter:B:15:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m5527a(java.security.cert.X509Certificate r5, java.util.Date r6) {
        /*
            r0 = 3
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ IOException -> 0x003f }
            java.lang.String r2 = "Try OCSP"
            r1.println(r2)     // Catch:{ IOException -> 0x003f }
            java.util.List r1 = com.cyberneid.p087a.C1461j.m5502a(r5)     // Catch:{ IOException -> 0x003f }
            int r2 = r1.size()     // Catch:{ IOException -> 0x003f }
            if (r2 <= 0) goto L_0x0036
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ IOException -> 0x003f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003f }
            r3.<init>()     // Catch:{ IOException -> 0x003f }
            java.lang.String r4 = "OCSP URLs "
            r3.append(r4)     // Catch:{ IOException -> 0x003f }
            r3.append(r1)     // Catch:{ IOException -> 0x003f }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x003f }
            r2.println(r3)     // Catch:{ IOException -> 0x003f }
            int r1 = com.cyberneid.p087a.C1461j.m5501a(r1, r5, r6)     // Catch:{ IOException -> 0x003f }
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ IOException -> 0x0034 }
            java.lang.String r3 = "OCSP OK"
            r2.println(r3)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0044
        L_0x0034:
            r2 = move-exception
            goto L_0x0041
        L_0x0036:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ IOException -> 0x003f }
            java.lang.String r2 = "No OCSP present "
            r1.println(r2)     // Catch:{ IOException -> 0x003f }
            r1 = 3
            goto L_0x0044
        L_0x003f:
            r2 = move-exception
            r1 = 3
        L_0x0041:
            r2.printStackTrace()
        L_0x0044:
            if (r1 != r0) goto L_0x006c
            java.io.PrintStream r0 = java.lang.System.out     // Catch:{ Exception -> 0x0068 }
            java.lang.String r2 = "Try CRL"
            r0.println(r2)     // Catch:{ Exception -> 0x0068 }
            int r1 = com.cyberneid.p087a.C1453b.m5479a((java.security.cert.X509Certificate) r5, (java.util.Date) r6)     // Catch:{ Exception -> 0x0068 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ Exception -> 0x0068 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0068 }
            r6.<init>()     // Catch:{ Exception -> 0x0068 }
            java.lang.String r0 = "CRL OK: "
            r6.append(r0)     // Catch:{ Exception -> 0x0068 }
            r6.append(r1)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0068 }
            r5.println(r6)     // Catch:{ Exception -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r5 = move-exception
            r5.printStackTrace()
        L_0x006c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p087a.C1466n.m5527a(java.security.cert.X509Certificate, java.util.Date):int");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0028 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[SYNTHETIC, Splitter:B:19:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f3 A[Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m5528a(org.spongycastle.cms.SignerInformation r6, org.spongycastle.util.Store r7, java.util.Date r8) {
        /*
            org.spongycastle.cert.X509CertificateHolder r7 = m5529a((org.spongycastle.cms.SignerInformation) r6, (org.spongycastle.util.Store) r7)
            byte[] r7 = r7.getEncoded()
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r7)
            java.security.cert.Certificate r7 = r0.generateCertificate(r1)
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7
            r0 = 0
            if (r7 != 0) goto L_0x001d
            return r0
        L_0x001d:
            if (r8 != 0) goto L_0x0024
            java.util.Date r8 = new java.util.Date
            r8.<init>()
        L_0x0024:
            r7.checkValidity(r8)     // Catch:{ CertificateExpiredException | CertificateNotYetValidException -> 0x0028 }
            r0 = 1
        L_0x0028:
            boolean r1 = m5530a((java.security.cert.X509Certificate) r7)     // Catch:{ CertificateException -> 0x0031 }
            if (r1 == 0) goto L_0x0035
            r0 = r0 | 64
            goto L_0x0035
        L_0x0031:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0035:
            java.lang.String r1 = r6.getDigestAlgOID()
            java.lang.String r2 = "2.16.840.1.101.3.4.2.1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0043
            r0 = r0 | 32
        L_0x0043:
            com.cyberneid.a.d r1 = com.cyberneid.p087a.C1455d.m5485a()
            org.spongycastle.jce.provider.X509CertificateObject r1 = r1.mo6919b(r7)
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "VerifySignature CaCert: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            r2.println(r3)
            r2 = r7
        L_0x0062:
            if (r1 == 0) goto L_0x0077
            java.security.PublicKey r3 = r1.getPublicKey()     // Catch:{ InvalidKeyException -> 0x0095, CertificateException -> 0x0090, NoSuchAlgorithmException -> 0x008b, NoSuchProviderException -> 0x0086, SignatureException -> 0x0081 }
            r2.verify(r3)     // Catch:{ InvalidKeyException -> 0x0095, CertificateException -> 0x0090, NoSuchAlgorithmException -> 0x008b, NoSuchProviderException -> 0x0086, SignatureException -> 0x0081 }
            com.cyberneid.a.d r2 = com.cyberneid.p087a.C1455d.m5485a()     // Catch:{ InvalidKeyException -> 0x0095, CertificateException -> 0x0090, NoSuchAlgorithmException -> 0x008b, NoSuchProviderException -> 0x0086, SignatureException -> 0x0081 }
            org.spongycastle.jce.provider.X509CertificateObject r2 = r2.mo6919b(r1)     // Catch:{ InvalidKeyException -> 0x0095, CertificateException -> 0x0090, NoSuchAlgorithmException -> 0x008b, NoSuchProviderException -> 0x0086, SignatureException -> 0x0081 }
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x0062
        L_0x0077:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ InvalidKeyException -> 0x0095, CertificateException -> 0x0090, NoSuchAlgorithmException -> 0x008b, NoSuchProviderException -> 0x0086, SignatureException -> 0x0081 }
            java.lang.String r2 = "chain ok"
            r1.println(r2)     // Catch:{ InvalidKeyException -> 0x0095, CertificateException -> 0x0090, NoSuchAlgorithmException -> 0x008b, NoSuchProviderException -> 0x0086, SignatureException -> 0x0081 }
            r0 = r0 | 16
            goto L_0x0099
        L_0x0081:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0099
        L_0x0086:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0099
        L_0x008b:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0099
        L_0x0090:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0099
        L_0x0095:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0099:
            int r8 = m5527a((java.security.cert.X509Certificate) r7, (java.util.Date) r8)
            switch(r8) {
                case 0: goto L_0x00a9;
                case 1: goto L_0x00a4;
                case 2: goto L_0x00a1;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            goto L_0x00ad
        L_0x00a1:
            r8 = r0 | 512(0x200, float:7.175E-43)
            goto L_0x00ab
        L_0x00a4:
            r8 = r0 | 128(0x80, float:1.794E-43)
            r0 = r8 | 256(0x100, float:3.59E-43)
            goto L_0x00ad
        L_0x00a9:
            r8 = r0 | 4
        L_0x00ab:
            r0 = r8 | 128(0x80, float:1.794E-43)
        L_0x00ad:
            org.spongycastle.asn1.cms.AttributeTable r8 = r6.getSignedAttributes()
            if (r8 == 0) goto L_0x00e0
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = new org.spongycastle.asn1.ASN1ObjectIdentifier
            java.lang.String r2 = "1.2.840.113549.1.9.4"
            r1.<init>((java.lang.String) r2)
            org.spongycastle.asn1.cms.Attribute r1 = r8.get(r1)
            if (r1 == 0) goto L_0x00c2
            r0 = r0 | 1024(0x400, float:1.435E-42)
        L_0x00c2:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = new org.spongycastle.asn1.ASN1ObjectIdentifier
            java.lang.String r2 = "1.2.840.113549.1.9.3"
            r1.<init>((java.lang.String) r2)
            org.spongycastle.asn1.cms.Attribute r1 = r8.get(r1)
            if (r1 == 0) goto L_0x00d1
            r0 = r0 | 2
        L_0x00d1:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = new org.spongycastle.asn1.ASN1ObjectIdentifier
            java.lang.String r2 = "1.2.840.113549.1.9.16.2.47"
            r1.<init>((java.lang.String) r2)
            org.spongycastle.asn1.cms.Attribute r8 = r8.get(r1)
            if (r8 == 0) goto L_0x00e0
            r0 = r0 | 2048(0x800, float:2.87E-42)
        L_0x00e0:
            org.spongycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder r8 = new org.spongycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder     // Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }
            r8.<init>()     // Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }
            java.security.PublicKey r7 = r7.getPublicKey()     // Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }
            org.spongycastle.cms.SignerInformationVerifier r7 = r8.build((java.security.PublicKey) r7)     // Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }
            boolean r6 = r6.verify(r7)     // Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }
            if (r6 == 0) goto L_0x0107
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }
            java.lang.String r7 = "sig verified"
            r6.println(r7)     // Catch:{ CMSException -> 0x0103, OperatorCreationException -> 0x00fe }
            r6 = r0 | 8
            r0 = r6
            goto L_0x0107
        L_0x00fe:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0107
        L_0x0103:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0107:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p087a.C1466n.m5528a(org.spongycastle.cms.SignerInformation, org.spongycastle.util.Store, java.util.Date):int");
    }

    /* renamed from: a */
    static X509CertificateHolder m5529a(SignerInformation signerInformation, Store store) {
        Collection matches = store.getMatches(new X509CertificateHolderSelector(signerInformation.getSID().getIssuer(), signerInformation.getSID().getSerialNumber()));
        if (!matches.isEmpty()) {
            return (X509CertificateHolder) matches.toArray()[0];
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m5530a(X509Certificate x509Certificate) {
        return m5531a(x509Certificate.getEncoded());
    }

    /* renamed from: a */
    private static boolean m5531a(byte[] bArr) {
        try {
            X509Extension extension = X509CertificateStructure.getInstance(ASN1TaggedObject.fromByteArray(bArr)).getTBSCertificate().getExtensions().getExtension(X509Extensions.QCStatements);
            if (extension == null) {
                return false;
            }
            Enumeration objects = ((DLSequence) ASN1TaggedObject.fromByteArray(((DEROctetString) extension.getValue()).getOctets())).getObjects();
            while (objects.hasMoreElements()) {
                if (QCStatement.getInstance(objects.nextElement()).getStatementId().getId().equals("0.4.0.1862.1.1")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

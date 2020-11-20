package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.jce.X509Principal;

public class X509CRLObject extends X509CRL {

    /* renamed from: c */
    private CertificateList f7964c;
    private int hashCodeValue;
    private boolean isHashCodeSet = false;
    private boolean isIndirect;
    private String sigAlgName;
    private byte[] sigAlgParams;

    public X509CRLObject(CertificateList certificateList) {
        this.f7964c = certificateList;
        try {
            this.sigAlgName = X509SignatureUtil.getSignatureName(certificateList.getSignatureAlgorithm());
            if (certificateList.getSignatureAlgorithm().getParameters() != null) {
                this.sigAlgParams = certificateList.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded(ASN1Encoding.DER);
            } else {
                this.sigAlgParams = null;
            }
            this.isIndirect = isIndirectCRL(this);
        } catch (Exception e) {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    private void doVerify(PublicKey publicKey, Signature signature) {
        if (this.f7964c.getSignatureAlgorithm().equals(this.f7964c.getTBSCertList().getSignature())) {
            signature.initVerify(publicKey);
            signature.update(getTBSCertList());
            if (!signature.verify(getSignature())) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
            return;
        }
        throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
    }

    private Set getExtensionOIDs(boolean z) {
        Extensions extensions;
        if (getVersion() != 2 || (extensions = this.f7964c.getTBSCertList().getExtensions()) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
            if (z == extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    public static boolean isIndirectCRL(X509CRL x509crl) {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(Extension.issuingDistributionPoint.getId());
            return extensionValue != null && IssuingDistributionPoint.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).isIndirectCRL();
        } catch (Exception e) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
        }
    }

    private Set loadCRLEntries() {
        Extension extension;
        HashSet hashSet = new HashSet();
        Enumeration revokedCertificateEnumeration = this.f7964c.getRevokedCertificateEnumeration();
        X500Name x500Name = null;
        while (revokedCertificateEnumeration.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement();
            hashSet.add(new X509CRLEntryObject(cRLEntry, this.isIndirect, x500Name));
            if (this.isIndirect && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                x500Name = X500Name.getInstance(GeneralNames.getInstance(extension.getParsedValue()).getNames()[0].getName());
            }
        }
        return hashSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        if (!(obj instanceof X509CRLObject)) {
            return super.equals(obj);
        }
        X509CRLObject x509CRLObject = (X509CRLObject) obj;
        if (!this.isHashCodeSet || !x509CRLObject.isHashCodeSet || x509CRLObject.hashCodeValue == this.hashCodeValue) {
            return this.f7964c.equals(x509CRLObject.f7964c);
        }
        return false;
    }

    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    public byte[] getEncoded() {
        try {
            return this.f7964c.getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public byte[] getExtensionValue(String str) {
        Extension extension;
        Extensions extensions = this.f7964c.getTBSCertList().getExtensions();
        if (extensions == null || (extension = extensions.getExtension(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getExtnValue().getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException("error parsing " + e.toString());
        }
    }

    public Principal getIssuerDN() {
        return new X509Principal(X500Name.getInstance(this.f7964c.getIssuer().toASN1Primitive()));
    }

    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f7964c.getIssuer().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public Date getNextUpdate() {
        if (this.f7964c.getNextUpdate() != null) {
            return this.f7964c.getNextUpdate().getDate();
        }
        return null;
    }

    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        Extension extension;
        Enumeration revokedCertificateEnumeration = this.f7964c.getRevokedCertificateEnumeration();
        X500Name x500Name = null;
        while (revokedCertificateEnumeration.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement();
            if (bigInteger.equals(cRLEntry.getUserCertificate().getValue())) {
                return new X509CRLEntryObject(cRLEntry, this.isIndirect, x500Name);
            }
            if (this.isIndirect && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                x500Name = X500Name.getInstance(GeneralNames.getInstance(extension.getParsedValue()).getNames()[0].getName());
            }
        }
        return null;
    }

    public Set getRevokedCertificates() {
        Set loadCRLEntries = loadCRLEntries();
        if (!loadCRLEntries.isEmpty()) {
            return Collections.unmodifiableSet(loadCRLEntries);
        }
        return null;
    }

    public String getSigAlgName() {
        return this.sigAlgName;
    }

    public String getSigAlgOID() {
        return this.f7964c.getSignatureAlgorithm().getAlgorithm().getId();
    }

    public byte[] getSigAlgParams() {
        byte[] bArr = this.sigAlgParams;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public byte[] getSignature() {
        return this.f7964c.getSignature().getOctets();
    }

    public byte[] getTBSCertList() {
        try {
            return this.f7964c.getTBSCertList().getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public Date getThisUpdate() {
        return this.f7964c.getThisUpdate().getDate();
    }

    public int getVersion() {
        return this.f7964c.getVersionNumber();
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
        return !criticalExtensionOIDs.isEmpty();
    }

    public int hashCode() {
        if (!this.isHashCodeSet) {
            this.isHashCodeSet = true;
            this.hashCodeValue = super.hashCode();
        }
        return this.hashCodeValue;
    }

    public boolean isRevoked(Certificate certificate) {
        X500Name x500Name;
        Extension extension;
        if (certificate.getType().equals("X.509")) {
            Enumeration revokedCertificateEnumeration = this.f7964c.getRevokedCertificateEnumeration();
            X500Name issuer = this.f7964c.getIssuer();
            if (revokedCertificateEnumeration != null) {
                X509Certificate x509Certificate = (X509Certificate) certificate;
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                while (revokedCertificateEnumeration.hasMoreElements()) {
                    TBSCertList.CRLEntry instance = TBSCertList.CRLEntry.getInstance(revokedCertificateEnumeration.nextElement());
                    if (this.isIndirect && instance.hasExtensions() && (extension = instance.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                        issuer = X500Name.getInstance(GeneralNames.getInstance(extension.getParsedValue()).getNames()[0].getName());
                    }
                    if (instance.getUserCertificate().getValue().equals(serialNumber)) {
                        if (certificate instanceof X509Certificate) {
                            x500Name = X500Name.getInstance(x509Certificate.getIssuerX500Principal().getEncoded());
                        } else {
                            try {
                                x500Name = org.spongycastle.asn1.x509.Certificate.getInstance(certificate.getEncoded()).getIssuer();
                            } catch (CertificateEncodingException unused) {
                                throw new RuntimeException("Cannot process certificate");
                            }
                        }
                        return issuer.equals(x500Name);
                    }
                }
            }
            return false;
        }
        throw new RuntimeException("X.509 CRL used with non X.509 Cert");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0198 A[EDGE_INSN: B:53:0x0198->B:42:0x0198 ?: BREAK  , SYNTHETIC] */
    public java.lang.String toString() {
        /*
            r8 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = org.spongycastle.util.Strings.lineSeparator()
            java.lang.String r2 = "              Version: "
            r0.append(r2)
            int r2 = r8.getVersion()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = "             IssuerDN: "
            r0.append(r2)
            java.security.Principal r2 = r8.getIssuerDN()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = "          This update: "
            r0.append(r2)
            java.util.Date r2 = r8.getThisUpdate()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = "          Next update: "
            r0.append(r2)
            java.util.Date r2 = r8.getNextUpdate()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = "  Signature Algorithm: "
            r0.append(r2)
            java.lang.String r2 = r8.getSigAlgName()
            r0.append(r2)
            r0.append(r1)
            byte[] r2 = r8.getSignature()
            java.lang.String r3 = "            Signature: "
            r0.append(r3)
            java.lang.String r3 = new java.lang.String
            r4 = 20
            r5 = 0
            byte[] r5 = org.spongycastle.util.encoders.Hex.encode(r2, r5, r4)
            r3.<init>(r5)
            r0.append(r3)
            r0.append(r1)
            r3 = 20
        L_0x0071:
            int r5 = r2.length
            if (r3 >= r5) goto L_0x00a0
            int r5 = r2.length
            int r5 = r5 - r4
            if (r3 >= r5) goto L_0x0087
            java.lang.String r5 = "                       "
            r0.append(r5)
            java.lang.String r5 = new java.lang.String
            byte[] r6 = org.spongycastle.util.encoders.Hex.encode(r2, r3, r4)
            r5.<init>(r6)
            goto L_0x0097
        L_0x0087:
            java.lang.String r5 = "                       "
            r0.append(r5)
            java.lang.String r5 = new java.lang.String
            int r6 = r2.length
            int r6 = r6 - r3
            byte[] r6 = org.spongycastle.util.encoders.Hex.encode(r2, r3, r6)
            r5.<init>(r6)
        L_0x0097:
            r0.append(r5)
            r0.append(r1)
            int r3 = r3 + 20
            goto L_0x0071
        L_0x00a0:
            org.spongycastle.asn1.x509.CertificateList r2 = r8.f7964c
            org.spongycastle.asn1.x509.TBSCertList r2 = r2.getTBSCertList()
            org.spongycastle.asn1.x509.Extensions r2 = r2.getExtensions()
            if (r2 == 0) goto L_0x0198
            java.util.Enumeration r3 = r2.oids()
            boolean r4 = r3.hasMoreElements()
            if (r4 == 0) goto L_0x00be
            java.lang.String r4 = "           Extensions: "
        L_0x00b8:
            r0.append(r4)
        L_0x00bb:
            r0.append(r1)
        L_0x00be:
            boolean r4 = r3.hasMoreElements()
            if (r4 == 0) goto L_0x0198
            java.lang.Object r4 = r3.nextElement()
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r4
            org.spongycastle.asn1.x509.Extension r5 = r2.getExtension(r4)
            org.spongycastle.asn1.ASN1OctetString r6 = r5.getExtnValue()
            if (r6 == 0) goto L_0x00bb
            org.spongycastle.asn1.ASN1OctetString r6 = r5.getExtnValue()
            byte[] r6 = r6.getOctets()
            org.spongycastle.asn1.ASN1InputStream r7 = new org.spongycastle.asn1.ASN1InputStream
            r7.<init>((byte[]) r6)
            java.lang.String r6 = "                       critical("
            r0.append(r6)
            boolean r5 = r5.isCritical()
            r0.append(r5)
            java.lang.String r5 = ") "
            r0.append(r5)
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.x509.Extension.cRLNumber     // Catch:{ Exception -> 0x0188 }
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0188 }
            if (r5 == 0) goto L_0x0112
            org.spongycastle.asn1.x509.CRLNumber r5 = new org.spongycastle.asn1.x509.CRLNumber     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.ASN1Primitive r6 = r7.readObject()     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.ASN1Integer r6 = org.spongycastle.asn1.ASN1Integer.getInstance(r6)     // Catch:{ Exception -> 0x0188 }
            java.math.BigInteger r6 = r6.getPositiveValue()     // Catch:{ Exception -> 0x0188 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0188 }
        L_0x010b:
            r0.append(r5)     // Catch:{ Exception -> 0x0188 }
        L_0x010e:
            r0.append(r1)     // Catch:{ Exception -> 0x0188 }
            goto L_0x00be
        L_0x0112:
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.x509.Extension.deltaCRLIndicator     // Catch:{ Exception -> 0x0188 }
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0188 }
            if (r5 == 0) goto L_0x0140
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
            r5.<init>()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r6 = "Base CRL: "
            r5.append(r6)     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.x509.CRLNumber r6 = new org.spongycastle.asn1.x509.CRLNumber     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.ASN1Primitive r7 = r7.readObject()     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.ASN1Integer r7 = org.spongycastle.asn1.ASN1Integer.getInstance(r7)     // Catch:{ Exception -> 0x0188 }
            java.math.BigInteger r7 = r7.getPositiveValue()     // Catch:{ Exception -> 0x0188 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0188 }
            r5.append(r6)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0188 }
        L_0x013c:
            r0.append(r5)     // Catch:{ Exception -> 0x0188 }
            goto L_0x010e
        L_0x0140:
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.x509.Extension.issuingDistributionPoint     // Catch:{ Exception -> 0x0188 }
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0188 }
            if (r5 == 0) goto L_0x0151
            org.spongycastle.asn1.ASN1Primitive r5 = r7.readObject()     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.x509.IssuingDistributionPoint r5 = org.spongycastle.asn1.x509.IssuingDistributionPoint.getInstance(r5)     // Catch:{ Exception -> 0x0188 }
            goto L_0x010b
        L_0x0151:
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.x509.Extension.cRLDistributionPoints     // Catch:{ Exception -> 0x0188 }
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0188 }
            if (r5 == 0) goto L_0x0162
            org.spongycastle.asn1.ASN1Primitive r5 = r7.readObject()     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.x509.CRLDistPoint r5 = org.spongycastle.asn1.x509.CRLDistPoint.getInstance(r5)     // Catch:{ Exception -> 0x0188 }
            goto L_0x010b
        L_0x0162:
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.x509.Extension.freshestCRL     // Catch:{ Exception -> 0x0188 }
            boolean r5 = r4.equals(r5)     // Catch:{ Exception -> 0x0188 }
            if (r5 == 0) goto L_0x0173
            org.spongycastle.asn1.ASN1Primitive r5 = r7.readObject()     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.x509.CRLDistPoint r5 = org.spongycastle.asn1.x509.CRLDistPoint.getInstance(r5)     // Catch:{ Exception -> 0x0188 }
            goto L_0x010b
        L_0x0173:
            java.lang.String r5 = r4.getId()     // Catch:{ Exception -> 0x0188 }
            r0.append(r5)     // Catch:{ Exception -> 0x0188 }
            java.lang.String r5 = " value = "
            r0.append(r5)     // Catch:{ Exception -> 0x0188 }
            org.spongycastle.asn1.ASN1Primitive r5 = r7.readObject()     // Catch:{ Exception -> 0x0188 }
            java.lang.String r5 = org.spongycastle.asn1.util.ASN1Dump.dumpAsString(r5)     // Catch:{ Exception -> 0x0188 }
            goto L_0x013c
        L_0x0188:
            java.lang.String r4 = r4.getId()
            r0.append(r4)
            java.lang.String r4 = " value = "
            r0.append(r4)
            java.lang.String r4 = "*****"
            goto L_0x00b8
        L_0x0198:
            java.util.Set r2 = r8.getRevokedCertificates()
            if (r2 == 0) goto L_0x01b3
            java.util.Iterator r2 = r2.iterator()
        L_0x01a2:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01b3
            java.lang.Object r3 = r2.next()
            r0.append(r3)
            r0.append(r1)
            goto L_0x01a2
        L_0x01b3:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CRLObject.toString():java.lang.String");
    }

    public void verify(PublicKey publicKey) {
        Signature signature;
        try {
            signature = Signature.getInstance(getSigAlgName(), BouncyCastleProvider.PROVIDER_NAME);
        } catch (Exception unused) {
            signature = Signature.getInstance(getSigAlgName());
        }
        doVerify(publicKey, signature);
    }

    public void verify(PublicKey publicKey, String str) {
        doVerify(publicKey, str != null ? Signature.getInstance(getSigAlgName(), str) : Signature.getInstance(getSigAlgName()));
    }

    public void verify(PublicKey publicKey, Provider provider) {
        doVerify(publicKey, provider != null ? Signature.getInstance(getSigAlgName(), provider) : Signature.getInstance(getSigAlgName()));
    }
}

package org.spongycastle.cert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.operator.ContentVerifier;
import org.spongycastle.operator.ContentVerifierProvider;
import org.spongycastle.util.Encodable;

public class X509CRLHolder implements Serializable, Encodable {
    private static final long serialVersionUID = 20170722001L;
    private transient Extensions extensions;
    private transient boolean isIndirect;
    private transient GeneralNames issuerName;
    private transient CertificateList x509CRL;

    public X509CRLHolder(InputStream inputStream) {
        this(parseStream(inputStream));
    }

    public X509CRLHolder(CertificateList certificateList) {
        init(certificateList);
    }

    public X509CRLHolder(byte[] bArr) {
        this(parseStream(new ByteArrayInputStream(bArr)));
    }

    private void init(CertificateList certificateList) {
        this.x509CRL = certificateList;
        this.extensions = certificateList.getTBSCertList().getExtensions();
        this.isIndirect = isIndirectCRL(this.extensions);
        this.issuerName = new GeneralNames(new GeneralName(certificateList.getIssuer()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r2 = r2.getExtension(org.spongycastle.asn1.x509.Extension.issuingDistributionPoint);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isIndirectCRL(org.spongycastle.asn1.x509.Extensions r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = org.spongycastle.asn1.x509.Extension.issuingDistributionPoint
            org.spongycastle.asn1.x509.Extension r2 = r2.getExtension(r1)
            if (r2 == 0) goto L_0x001b
            org.spongycastle.asn1.ASN1Encodable r2 = r2.getParsedValue()
            org.spongycastle.asn1.x509.IssuingDistributionPoint r2 = org.spongycastle.asn1.x509.IssuingDistributionPoint.getInstance(r2)
            boolean r2 = r2.isIndirectCRL()
            if (r2 == 0) goto L_0x001b
            r0 = 1
        L_0x001b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.cert.X509CRLHolder.isIndirectCRL(org.spongycastle.asn1.x509.Extensions):boolean");
    }

    private static CertificateList parseStream(InputStream inputStream) {
        try {
            ASN1Primitive readObject = new ASN1InputStream(inputStream, true).readObject();
            if (readObject != null) {
                return CertificateList.getInstance(readObject);
            }
            throw new IOException("no content found");
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        init(CertificateList.getInstance(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CRLHolder)) {
            return false;
        }
        return this.x509CRL.equals(((X509CRLHolder) obj).x509CRL);
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public byte[] getEncoded() {
        return this.x509CRL.getEncoded();
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions2 = this.extensions;
        if (extensions2 != null) {
            return extensions2.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return CertUtils.getExtensionOIDs(this.extensions);
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return X500Name.getInstance(this.x509CRL.getIssuer());
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public X509CRLEntryHolder getRevokedCertificate(BigInteger bigInteger) {
        Extension extension;
        GeneralNames generalNames = this.issuerName;
        Enumeration revokedCertificateEnumeration = this.x509CRL.getRevokedCertificateEnumeration();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement();
            if (cRLEntry.getUserCertificate().getValue().equals(bigInteger)) {
                return new X509CRLEntryHolder(cRLEntry, this.isIndirect, generalNames);
            }
            if (this.isIndirect && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                generalNames = GeneralNames.getInstance(extension.getParsedValue());
            }
        }
        return null;
    }

    public Collection getRevokedCertificates() {
        ArrayList arrayList = new ArrayList(this.x509CRL.getRevokedCertificates().length);
        GeneralNames generalNames = this.issuerName;
        Enumeration revokedCertificateEnumeration = this.x509CRL.getRevokedCertificateEnumeration();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            X509CRLEntryHolder x509CRLEntryHolder = new X509CRLEntryHolder((TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement(), this.isIndirect, generalNames);
            arrayList.add(x509CRLEntryHolder);
            generalNames = x509CRLEntryHolder.getCertificateIssuer();
        }
        return arrayList;
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public int hashCode() {
        return this.x509CRL.hashCode();
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) {
        TBSCertList tBSCertList = this.x509CRL.getTBSCertList();
        if (CertUtils.isAlgIdEqual(tBSCertList.getSignature(), this.x509CRL.getSignatureAlgorithm())) {
            try {
                ContentVerifier contentVerifier = contentVerifierProvider.get(tBSCertList.getSignature());
                OutputStream outputStream = contentVerifier.getOutputStream();
                new DEROutputStream(outputStream).writeObject(tBSCertList);
                outputStream.close();
                return contentVerifier.verify(this.x509CRL.getSignature().getOctets());
            } catch (Exception e) {
                throw new CertException("unable to process signature: " + e.getMessage(), e);
            }
        } else {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
    }

    public CertificateList toASN1Structure() {
        return this.x509CRL;
    }
}

package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CRLReason;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.asn1.x509.X509Extension;
import org.spongycastle.util.Strings;

public class X509CRLEntryObject extends X509CRLEntry {

    /* renamed from: c */
    private TBSCertList.CRLEntry f7963c;
    private X500Name certificateIssuer;
    private int hashValue;
    private boolean isHashValueSet;

    public X509CRLEntryObject(TBSCertList.CRLEntry cRLEntry) {
        this.f7963c = cRLEntry;
        this.certificateIssuer = null;
    }

    public X509CRLEntryObject(TBSCertList.CRLEntry cRLEntry, boolean z, X500Name x500Name) {
        this.f7963c = cRLEntry;
        this.certificateIssuer = loadCertificateIssuer(z, x500Name);
    }

    private Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions = this.f7963c.getExtensions();
        if (extensions != null) {
            return extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    private Set getExtensionOIDs(boolean z) {
        Extensions extensions = this.f7963c.getExtensions();
        if (extensions == null) {
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

    private X500Name loadCertificateIssuer(boolean z, X500Name x500Name) {
        if (!z) {
            return null;
        }
        Extension extension = getExtension(Extension.certificateIssuer);
        if (extension == null) {
            return x500Name;
        }
        try {
            GeneralName[] names = GeneralNames.getInstance(extension.getParsedValue()).getNames();
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    return X500Name.getInstance(names[i].getName());
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof X509CRLEntryObject ? this.f7963c.equals(((X509CRLEntryObject) obj).f7963c) : super.equals(this);
    }

    public X500Principal getCertificateIssuer() {
        X500Name x500Name = this.certificateIssuer;
        if (x500Name == null) {
            return null;
        }
        try {
            return new X500Principal(x500Name.getEncoded());
        } catch (IOException unused) {
            return null;
        }
    }

    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    public byte[] getEncoded() {
        try {
            return this.f7963c.getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public byte[] getExtensionValue(String str) {
        Extension extension = getExtension(new ASN1ObjectIdentifier(str));
        if (extension == null) {
            return null;
        }
        try {
            return extension.getExtnValue().getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("error encoding " + e.toString());
        }
    }

    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public Date getRevocationDate() {
        return this.f7963c.getRevocationDate().getDate();
    }

    public BigInteger getSerialNumber() {
        return this.f7963c.getUserCertificate().getValue();
    }

    public boolean hasExtensions() {
        return this.f7963c.getExtensions() != null;
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty();
    }

    public int hashCode() {
        if (!this.isHashValueSet) {
            this.hashValue = super.hashCode();
            this.isHashValueSet = true;
        }
        return this.hashValue;
    }

    public String toString() {
        Object instance;
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("      userCertificate: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("       revocationDate: ");
        stringBuffer.append(getRevocationDate());
        stringBuffer.append(lineSeparator);
        stringBuffer.append("       certificateIssuer: ");
        stringBuffer.append(getCertificateIssuer());
        stringBuffer.append(lineSeparator);
        Extensions extensions = this.f7963c.getExtensions();
        if (extensions != null) {
            Enumeration oids = extensions.oids();
            if (oids.hasMoreElements()) {
                String str = "   crlEntryExtensions:";
                loop0:
                while (true) {
                    stringBuffer.append(str);
                    while (true) {
                        stringBuffer.append(lineSeparator);
                        while (true) {
                            if (!oids.hasMoreElements()) {
                                break loop0;
                            }
                            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) oids.nextElement();
                            Extension extension = extensions.getExtension(aSN1ObjectIdentifier);
                            if (extension.getExtnValue() != null) {
                                ASN1InputStream aSN1InputStream = new ASN1InputStream(extension.getExtnValue().getOctets());
                                stringBuffer.append("                       critical(");
                                stringBuffer.append(extension.isCritical());
                                stringBuffer.append(") ");
                                try {
                                    if (aSN1ObjectIdentifier.equals(X509Extension.reasonCode)) {
                                        instance = CRLReason.getInstance(ASN1Enumerated.getInstance(aSN1InputStream.readObject()));
                                    } else if (aSN1ObjectIdentifier.equals(X509Extension.certificateIssuer)) {
                                        stringBuffer.append("Certificate issuer: ");
                                        instance = GeneralNames.getInstance(aSN1InputStream.readObject());
                                    } else {
                                        stringBuffer.append(aSN1ObjectIdentifier.getId());
                                        stringBuffer.append(" value = ");
                                        stringBuffer.append(ASN1Dump.dumpAsString(aSN1InputStream.readObject()));
                                        stringBuffer.append(lineSeparator);
                                    }
                                    stringBuffer.append(instance);
                                    stringBuffer.append(lineSeparator);
                                } catch (Exception unused) {
                                    stringBuffer.append(aSN1ObjectIdentifier.getId());
                                    stringBuffer.append(" value = ");
                                    str = "*****";
                                }
                            }
                        }
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}

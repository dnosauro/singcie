package org.spongycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.TBSCertList;

public class X509CRLEntryHolder {

    /* renamed from: ca */
    private GeneralNames f7440ca;
    private TBSCertList.CRLEntry entry;

    X509CRLEntryHolder(TBSCertList.CRLEntry cRLEntry, boolean z, GeneralNames generalNames) {
        Extension extension;
        this.entry = cRLEntry;
        this.f7440ca = generalNames;
        if (z && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
            this.f7440ca = GeneralNames.getInstance(extension.getParsedValue());
        }
    }

    public GeneralNames getCertificateIssuer() {
        return this.f7440ca;
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.entry.getExtensions());
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions = this.entry.getExtensions();
        if (extensions != null) {
            return extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return CertUtils.getExtensionOIDs(this.entry.getExtensions());
    }

    public Extensions getExtensions() {
        return this.entry.getExtensions();
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.entry.getExtensions());
    }

    public Date getRevocationDate() {
        return this.entry.getRevocationDate().getDate();
    }

    public BigInteger getSerialNumber() {
        return this.entry.getUserCertificate().getValue();
    }

    public boolean hasExtensions() {
        return this.entry.hasExtensions();
    }
}

package org.spongycastle.cert.jcajce;

import java.security.cert.X509CRL;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.cert.X509CRLHolder;

public class JcaX509CRLHolder extends X509CRLHolder {
    public JcaX509CRLHolder(X509CRL x509crl) {
        super(CertificateList.getInstance(x509crl.getEncoded()));
    }
}

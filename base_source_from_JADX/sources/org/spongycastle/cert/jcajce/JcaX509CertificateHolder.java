package org.spongycastle.cert.jcajce;

import java.security.cert.X509Certificate;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.cert.X509CertificateHolder;

public class JcaX509CertificateHolder extends X509CertificateHolder {
    public JcaX509CertificateHolder(X509Certificate x509Certificate) {
        super(Certificate.getInstance(x509Certificate.getEncoded()));
    }
}

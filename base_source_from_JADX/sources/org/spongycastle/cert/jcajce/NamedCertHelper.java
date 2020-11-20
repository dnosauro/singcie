package org.spongycastle.cert.jcajce;

import java.security.cert.CertificateFactory;

class NamedCertHelper extends CertHelper {
    private final String providerName;

    NamedCertHelper(String str) {
        this.providerName = str;
    }

    /* access modifiers changed from: protected */
    public CertificateFactory createCertificateFactory(String str) {
        return CertificateFactory.getInstance(str, this.providerName);
    }
}

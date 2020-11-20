package org.spongycastle.cert.jcajce;

import java.security.cert.CertificateFactory;

class DefaultCertHelper extends CertHelper {
    DefaultCertHelper() {
    }

    /* access modifiers changed from: protected */
    public CertificateFactory createCertificateFactory(String str) {
        return CertificateFactory.getInstance(str);
    }
}

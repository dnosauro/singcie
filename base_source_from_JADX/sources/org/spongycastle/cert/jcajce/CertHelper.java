package org.spongycastle.cert.jcajce;

import java.security.cert.CertificateFactory;

abstract class CertHelper {
    CertHelper() {
    }

    /* access modifiers changed from: protected */
    public abstract CertificateFactory createCertificateFactory(String str);

    public CertificateFactory getCertificateFactory(String str) {
        return createCertificateFactory(str);
    }
}

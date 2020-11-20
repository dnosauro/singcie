package com.unboundid.util.ssl;

import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.net.ssl.X509TrustManager;

public final class TrustAllTrustManager implements Serializable, X509TrustManager {
    private static final long serialVersionUID = -1295254056169520318L;
    private final boolean examineValidityDates;

    public TrustAllTrustManager() {
        this.examineValidityDates = false;
    }

    public TrustAllTrustManager(boolean z) {
        this.examineValidityDates = z;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (this.examineValidityDates) {
            Date date = new Date();
            for (X509Certificate checkValidity : x509CertificateArr) {
                checkValidity.checkValidity(date);
            }
        }
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (this.examineValidityDates) {
            Date date = new Date();
            for (X509Certificate checkValidity : x509CertificateArr) {
                checkValidity.checkValidity(date);
            }
        }
    }

    public boolean examineValidityDates() {
        return this.examineValidityDates;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

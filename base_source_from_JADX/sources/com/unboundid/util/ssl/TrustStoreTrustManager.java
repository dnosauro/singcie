package com.unboundid.util.ssl;

import com.unboundid.util.Validator;
import java.io.File;
import java.io.Serializable;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class TrustStoreTrustManager implements Serializable, X509TrustManager {
    private static final long serialVersionUID = -4093869102727719415L;
    private final boolean examineValidityDates;
    private final String trustStoreFile;
    private final String trustStoreFormat;
    private final char[] trustStorePIN;

    public TrustStoreTrustManager(File file) {
        this(file.getAbsolutePath(), (char[]) null, (String) null, true);
    }

    public TrustStoreTrustManager(File file, char[] cArr, String str, boolean z) {
        this(file.getAbsolutePath(), cArr, str, z);
    }

    public TrustStoreTrustManager(String str) {
        this(str, (char[]) null, (String) null, true);
    }

    public TrustStoreTrustManager(String str, char[] cArr, String str2, boolean z) {
        Validator.ensureNotNull(str);
        this.trustStoreFile = str;
        this.trustStorePIN = cArr;
        this.examineValidityDates = z;
        if (str2 == null) {
            this.trustStoreFormat = KeyStore.getDefaultType();
        } else {
            this.trustStoreFormat = str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab A[SYNTHETIC, Splitter:B:44:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized javax.net.ssl.X509TrustManager[] getTrustManagers(java.security.cert.X509Certificate[] r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.examineValidityDates     // Catch:{ all -> 0x00dc }
            r1 = 0
            if (r0 == 0) goto L_0x0017
            java.util.Date r0 = new java.util.Date     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
            int r2 = r9.length     // Catch:{ all -> 0x00dc }
            r3 = 0
        L_0x000d:
            if (r3 >= r2) goto L_0x0017
            r4 = r9[r3]     // Catch:{ all -> 0x00dc }
            r4.checkValidity(r0)     // Catch:{ all -> 0x00dc }
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0017:
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00dc }
            java.lang.String r0 = r8.trustStoreFile     // Catch:{ all -> 0x00dc }
            r9.<init>(r0)     // Catch:{ all -> 0x00dc }
            boolean r0 = r9.exists()     // Catch:{ all -> 0x00dc }
            r2 = 1
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = r8.trustStoreFormat     // Catch:{ Exception -> 0x00b4 }
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ Exception -> 0x00b4 }
            r3 = 0
            r4 = 2
            r5 = 3
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0089 }
            r6.<init>(r9)     // Catch:{ Exception -> 0x0089 }
            char[] r9 = r8.trustStorePIN     // Catch:{ Exception -> 0x0084, all -> 0x0081 }
            r0.load(r6, r9)     // Catch:{ Exception -> 0x0084, all -> 0x0081 }
            r6.close()     // Catch:{ Exception -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r9 = move-exception
            com.unboundid.util.Debug.debugException(r9)     // Catch:{ all -> 0x00dc }
        L_0x0040:
            java.lang.String r9 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x0061 }
            javax.net.ssl.TrustManagerFactory r9 = javax.net.ssl.TrustManagerFactory.getInstance(r9)     // Catch:{ Exception -> 0x0061 }
            r9.init(r0)     // Catch:{ Exception -> 0x0061 }
            javax.net.ssl.TrustManager[] r9 = r9.getTrustManagers()     // Catch:{ Exception -> 0x0061 }
            int r0 = r9.length     // Catch:{ Exception -> 0x0061 }
            javax.net.ssl.X509TrustManager[] r0 = new javax.net.ssl.X509TrustManager[r0]     // Catch:{ Exception -> 0x0061 }
            r3 = 0
        L_0x0053:
            int r6 = r9.length     // Catch:{ Exception -> 0x0061 }
            if (r3 >= r6) goto L_0x005f
            r6 = r9[r3]     // Catch:{ Exception -> 0x0061 }
            javax.net.ssl.X509TrustManager r6 = (javax.net.ssl.X509TrustManager) r6     // Catch:{ Exception -> 0x0061 }
            r0[r3] = r6     // Catch:{ Exception -> 0x0061 }
            int r3 = r3 + 1
            goto L_0x0053
        L_0x005f:
            monitor-exit(r8)
            return r0
        L_0x0061:
            r9 = move-exception
            com.unboundid.util.Debug.debugException(r9)     // Catch:{ all -> 0x00dc }
            java.security.cert.CertificateException r0 = new java.security.cert.CertificateException     // Catch:{ all -> 0x00dc }
            com.unboundid.util.ssl.SSLMessages r3 = com.unboundid.util.ssl.SSLMessages.ERR_TRUSTSTORE_CANNOT_GET_TRUST_MANAGERS     // Catch:{ all -> 0x00dc }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00dc }
            java.lang.String r6 = r8.trustStoreFile     // Catch:{ all -> 0x00dc }
            r5[r1] = r6     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r8.trustStoreFormat     // Catch:{ all -> 0x00dc }
            r5[r2] = r1     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00dc }
            r5[r4] = r1     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r3.get(r5)     // Catch:{ all -> 0x00dc }
            r0.<init>(r1, r9)     // Catch:{ all -> 0x00dc }
            throw r0     // Catch:{ all -> 0x00dc }
        L_0x0081:
            r9 = move-exception
            r3 = r6
            goto L_0x00a9
        L_0x0084:
            r9 = move-exception
            r3 = r6
            goto L_0x008a
        L_0x0087:
            r9 = move-exception
            goto L_0x00a9
        L_0x0089:
            r9 = move-exception
        L_0x008a:
            com.unboundid.util.Debug.debugException(r9)     // Catch:{ all -> 0x0087 }
            java.security.cert.CertificateException r0 = new java.security.cert.CertificateException     // Catch:{ all -> 0x0087 }
            com.unboundid.util.ssl.SSLMessages r6 = com.unboundid.util.ssl.SSLMessages.ERR_TRUSTSTORE_CANNOT_LOAD     // Catch:{ all -> 0x0087 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r8.trustStoreFile     // Catch:{ all -> 0x0087 }
            r5[r1] = r7     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r8.trustStoreFormat     // Catch:{ all -> 0x0087 }
            r5[r2] = r1     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0087 }
            r5[r4] = r1     // Catch:{ all -> 0x0087 }
            java.lang.String r1 = r6.get(r5)     // Catch:{ all -> 0x0087 }
            r0.<init>(r1, r9)     // Catch:{ all -> 0x0087 }
            throw r0     // Catch:{ all -> 0x0087 }
        L_0x00a9:
            if (r3 == 0) goto L_0x00b3
            r3.close()     // Catch:{ Exception -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)     // Catch:{ all -> 0x00dc }
        L_0x00b3:
            throw r9     // Catch:{ all -> 0x00dc }
        L_0x00b4:
            r9 = move-exception
            com.unboundid.util.Debug.debugException(r9)     // Catch:{ all -> 0x00dc }
            java.security.cert.CertificateException r0 = new java.security.cert.CertificateException     // Catch:{ all -> 0x00dc }
            com.unboundid.util.ssl.SSLMessages r3 = com.unboundid.util.ssl.SSLMessages.ERR_TRUSTSTORE_UNSUPPORTED_FORMAT     // Catch:{ all -> 0x00dc }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = r8.trustStoreFormat     // Catch:{ all -> 0x00dc }
            r2[r1] = r4     // Catch:{ all -> 0x00dc }
            java.lang.String r1 = r3.get(r2)     // Catch:{ all -> 0x00dc }
            r0.<init>(r1, r9)     // Catch:{ all -> 0x00dc }
            throw r0     // Catch:{ all -> 0x00dc }
        L_0x00ca:
            java.security.cert.CertificateException r9 = new java.security.cert.CertificateException     // Catch:{ all -> 0x00dc }
            com.unboundid.util.ssl.SSLMessages r0 = com.unboundid.util.ssl.SSLMessages.ERR_TRUSTSTORE_NO_SUCH_FILE     // Catch:{ all -> 0x00dc }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = r8.trustStoreFile     // Catch:{ all -> 0x00dc }
            r2[r1] = r3     // Catch:{ all -> 0x00dc }
            java.lang.String r0 = r0.get(r2)     // Catch:{ all -> 0x00dc }
            r9.<init>(r0)     // Catch:{ all -> 0x00dc }
            throw r9     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.ssl.TrustStoreTrustManager.getTrustManagers(java.security.cert.X509Certificate[]):javax.net.ssl.X509TrustManager[]");
    }

    public synchronized void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        for (X509TrustManager checkClientTrusted : getTrustManagers(x509CertificateArr)) {
            checkClientTrusted.checkClientTrusted(x509CertificateArr, str);
        }
    }

    public synchronized void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        for (X509TrustManager checkServerTrusted : getTrustManagers(x509CertificateArr)) {
            checkServerTrusted.checkServerTrusted(x509CertificateArr, str);
        }
    }

    public boolean examineValidityDates() {
        return this.examineValidityDates;
    }

    public synchronized X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public String getTrustStoreFile() {
        return this.trustStoreFile;
    }

    public String getTrustStoreFormat() {
        return this.trustStoreFormat;
    }
}

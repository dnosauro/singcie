package com.unboundid.util.ssl;

import com.unboundid.util.Validator;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class SSLUtil {
    private final KeyManager[] keyManagers;
    private final TrustManager[] trustManagers;

    public SSLUtil() {
        this.keyManagers = null;
        this.trustManagers = null;
    }

    public SSLUtil(KeyManager keyManager, TrustManager trustManager) {
        if (keyManager == null) {
            this.keyManagers = null;
        } else {
            this.keyManagers = new KeyManager[]{keyManager};
        }
        if (trustManager == null) {
            this.trustManagers = null;
            return;
        }
        this.trustManagers = new TrustManager[]{trustManager};
    }

    public SSLUtil(TrustManager trustManager) {
        TrustManager[] trustManagerArr = null;
        this.keyManagers = null;
        this.trustManagers = trustManager != null ? new TrustManager[]{trustManager} : trustManagerArr;
    }

    public SSLUtil(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr) {
        if (keyManagerArr == null || keyManagerArr.length == 0) {
            this.keyManagers = null;
        } else {
            this.keyManagers = keyManagerArr;
        }
        if (trustManagerArr == null || trustManagerArr.length == 0) {
            this.trustManagers = null;
        } else {
            this.trustManagers = trustManagerArr;
        }
    }

    public SSLUtil(TrustManager[] trustManagerArr) {
        this.keyManagers = null;
        if (trustManagerArr == null || trustManagerArr.length == 0) {
            this.trustManagers = null;
        } else {
            this.trustManagers = trustManagerArr;
        }
    }

    public SSLContext createSSLContext() {
        return createSSLContext("TLSv1");
    }

    public SSLContext createSSLContext(String str) {
        Validator.ensureNotNull(str);
        SSLContext instance = SSLContext.getInstance(str);
        instance.init(this.keyManagers, this.trustManagers, (SecureRandom) null);
        return instance;
    }

    public SSLContext createSSLContext(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        SSLContext instance = SSLContext.getInstance(str, str2);
        instance.init(this.keyManagers, this.trustManagers, (SecureRandom) null);
        return instance;
    }

    public SSLServerSocketFactory createSSLServerSocketFactory() {
        return createSSLContext().getServerSocketFactory();
    }

    public SSLServerSocketFactory createSSLServerSocketFactory(String str) {
        return createSSLContext(str).getServerSocketFactory();
    }

    public SSLServerSocketFactory createSSLServerSocketFactory(String str, String str2) {
        return createSSLContext(str, str2).getServerSocketFactory();
    }

    public SSLSocketFactory createSSLSocketFactory() {
        return createSSLContext().getSocketFactory();
    }

    public SSLSocketFactory createSSLSocketFactory(String str) {
        return createSSLContext(str).getSocketFactory();
    }

    public SSLSocketFactory createSSLSocketFactory(String str, String str2) {
        return createSSLContext(str, str2).getSocketFactory();
    }

    public KeyManager[] getKeyManagers() {
        return this.keyManagers;
    }

    public TrustManager[] getTrustManagers() {
        return this.trustManagers;
    }
}

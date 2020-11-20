package org.spongycastle.est.jcajce;

import javax.net.ssl.SSLSession;

public interface JsseHostnameAuthorizer {
    boolean verified(String str, SSLSession sSLSession);
}

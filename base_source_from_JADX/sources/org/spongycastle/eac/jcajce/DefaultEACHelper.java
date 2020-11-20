package org.spongycastle.eac.jcajce;

import java.security.KeyFactory;

class DefaultEACHelper implements EACHelper {
    DefaultEACHelper() {
    }

    public KeyFactory createKeyFactory(String str) {
        return KeyFactory.getInstance(str);
    }
}

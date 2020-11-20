package org.spongycastle.eac.jcajce;

import java.security.KeyFactory;
import java.security.Provider;

class ProviderEACHelper implements EACHelper {
    private final Provider provider;

    ProviderEACHelper(Provider provider2) {
        this.provider = provider2;
    }

    public KeyFactory createKeyFactory(String str) {
        return KeyFactory.getInstance(str, this.provider);
    }
}

package com.unboundid.util.ssl;

import com.unboundid.util.Debug;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

public final class PKCS11KeyManager extends WrapperKeyManager {
    private static final String PKCS11_KEY_STORE_TYPE = "PKCS11";

    public PKCS11KeyManager(char[] cArr, String str) {
        super(getKeyManagers(cArr), str);
    }

    private static KeyManager[] getKeyManagers(char[] cArr) {
        KeyStore instance = KeyStore.getInstance(PKCS11_KEY_STORE_TYPE);
        try {
            instance.load((InputStream) null, cArr);
            try {
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, cArr);
                return instance2.getKeyManagers();
            } catch (Exception e) {
                Debug.debugException(e);
                throw new KeyStoreException(SSLMessages.ERR_PKCS11_CANNOT_GET_KEY_MANAGERS.get(String.valueOf(e)), e);
            }
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new KeyStoreException(SSLMessages.ERR_PKCS11_CANNOT_ACCESS.get(String.valueOf(e2)), e2);
        }
    }
}

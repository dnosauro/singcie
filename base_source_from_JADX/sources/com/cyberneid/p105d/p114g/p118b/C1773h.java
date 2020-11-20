package com.cyberneid.p105d.p114g.p118b;

import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/* renamed from: com.cyberneid.d.g.b.h */
public class C1773h extends C1767b {

    /* renamed from: a */
    private String f5750a = null;

    /* renamed from: b */
    private KeyStore f5751b = null;

    /* renamed from: c */
    private String f5752c = null;

    public C1773h(KeyStore keyStore, String str, String str2) {
        this.f5751b = keyStore;
        this.f5752c = str;
        this.f5750a = str2;
    }

    /* renamed from: a */
    public X509Certificate mo8017a() {
        Certificate certificate;
        if (this.f5751b.size() == 1) {
            certificate = this.f5751b.getCertificate(this.f5751b.aliases().nextElement());
        } else if (this.f5751b.containsAlias(this.f5752c)) {
            certificate = this.f5751b.getCertificate(this.f5752c);
        } else {
            throw new KeyStoreException("the keystore does not contain the given alias");
        }
        return (X509Certificate) certificate;
    }

    /* renamed from: b */
    public Key mo8018b() {
        try {
            if (this.f5751b.size() == 1) {
                return this.f5751b.getKey(this.f5751b.aliases().nextElement(), this.f5750a.toCharArray());
            } else if (this.f5751b.containsAlias(this.f5752c)) {
                return this.f5751b.getKey(this.f5752c, this.f5750a.toCharArray());
            } else {
                throw new KeyStoreException("the keystore does not contain the given alias");
            }
        } catch (UnrecoverableKeyException e) {
            throw new KeyStoreException("the private key is not recoverable", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyStoreException("the algorithm necessary to recover the key is not available", e2);
        }
    }
}

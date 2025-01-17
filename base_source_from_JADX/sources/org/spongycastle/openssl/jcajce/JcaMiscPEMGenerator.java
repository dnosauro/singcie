package org.spongycastle.openssl.jcajce;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.jcajce.JcaX509CRLHolder;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.openssl.MiscPEMGenerator;
import org.spongycastle.openssl.PEMEncryptor;

public class JcaMiscPEMGenerator extends MiscPEMGenerator {
    private String algorithm;
    private Object obj;
    private char[] password;
    private Provider provider;
    private SecureRandom random;

    public JcaMiscPEMGenerator(Object obj2) {
        super(convertObject(obj2));
    }

    public JcaMiscPEMGenerator(Object obj2, PEMEncryptor pEMEncryptor) {
        super(convertObject(obj2), pEMEncryptor);
    }

    private static Object convertObject(Object obj2) {
        if (obj2 instanceof X509Certificate) {
            try {
                return new JcaX509CertificateHolder((X509Certificate) obj2);
            } catch (CertificateEncodingException e) {
                throw new IllegalArgumentException("Cannot encode object: " + e.toString());
            }
        } else if (!(obj2 instanceof X509CRL)) {
            return obj2 instanceof KeyPair ? convertObject(((KeyPair) obj2).getPrivate()) : obj2 instanceof PrivateKey ? PrivateKeyInfo.getInstance(((Key) obj2).getEncoded()) : obj2 instanceof PublicKey ? SubjectPublicKeyInfo.getInstance(((PublicKey) obj2).getEncoded()) : obj2;
        } else {
            try {
                return new JcaX509CRLHolder((X509CRL) obj2);
            } catch (CRLException e2) {
                throw new IllegalArgumentException("Cannot encode object: " + e2.toString());
            }
        }
    }
}

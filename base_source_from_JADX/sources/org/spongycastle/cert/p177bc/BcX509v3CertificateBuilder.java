package org.spongycastle.cert.p177bc;

import java.math.BigInteger;
import java.util.Date;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.X509v3CertificateBuilder;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.util.SubjectPublicKeyInfoFactory;

/* renamed from: org.spongycastle.cert.bc.BcX509v3CertificateBuilder */
public class BcX509v3CertificateBuilder extends X509v3CertificateBuilder {
    public BcX509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, X500Name x500Name2, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(x500Name, bigInteger, date, date2, x500Name2, SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter));
    }

    public BcX509v3CertificateBuilder(X509CertificateHolder x509CertificateHolder, BigInteger bigInteger, Date date, Date date2, X500Name x500Name, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(x509CertificateHolder.getSubject(), bigInteger, date, date2, x500Name, SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter));
    }
}

package org.spongycastle.cms.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.cms.KeyTransRecipientInfoGenerator;
import org.spongycastle.operator.AsymmetricKeyWrapper;
import org.spongycastle.operator.jcajce.JceAsymmetricKeyWrapper;

public class JceKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    public JceKeyTransRecipientInfoGenerator(X509Certificate x509Certificate) {
        super(new IssuerAndSerialNumber(new JcaX509CertificateHolder(x509Certificate).toASN1Structure()), (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(x509Certificate));
    }

    public JceKeyTransRecipientInfoGenerator(X509Certificate x509Certificate, AlgorithmIdentifier algorithmIdentifier) {
        super(new IssuerAndSerialNumber(new JcaX509CertificateHolder(x509Certificate).toASN1Structure()), (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(algorithmIdentifier, x509Certificate.getPublicKey()));
    }

    public JceKeyTransRecipientInfoGenerator(byte[] bArr, PublicKey publicKey) {
        super(bArr, (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(publicKey));
    }

    public JceKeyTransRecipientInfoGenerator(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) {
        super(bArr, (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(algorithmIdentifier, publicKey));
    }

    public JceKeyTransRecipientInfoGenerator setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        ((JceAsymmetricKeyWrapper) this.wrapper).setAlgorithmMapping(aSN1ObjectIdentifier, str);
        return this;
    }

    public JceKeyTransRecipientInfoGenerator setProvider(String str) {
        ((JceAsymmetricKeyWrapper) this.wrapper).setProvider(str);
        return this;
    }

    public JceKeyTransRecipientInfoGenerator setProvider(Provider provider) {
        ((JceAsymmetricKeyWrapper) this.wrapper).setProvider(provider);
        return this;
    }
}

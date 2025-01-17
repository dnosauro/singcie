package org.spongycastle.cert.ocsp.jcajce;

import java.security.PublicKey;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.ocsp.BasicOCSPRespBuilder;
import org.spongycastle.operator.DigestCalculator;

public class JcaBasicOCSPRespBuilder extends BasicOCSPRespBuilder {
    public JcaBasicOCSPRespBuilder(PublicKey publicKey, DigestCalculator digestCalculator) {
        super(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), digestCalculator);
    }
}

package org.spongycastle.est.jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import org.spongycastle.est.HttpAuth;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class JcaHttpAuthBuilder {
    private final char[] password;
    private JcaDigestCalculatorProviderBuilder providerBuilder;
    private SecureRandom random;
    private final String realm;
    private final String username;

    public JcaHttpAuthBuilder(String str, String str2, char[] cArr) {
        this.providerBuilder = new JcaDigestCalculatorProviderBuilder();
        this.random = new SecureRandom();
        this.realm = str;
        this.username = str2;
        this.password = cArr;
    }

    public JcaHttpAuthBuilder(String str, char[] cArr) {
        this((String) null, str, cArr);
    }

    public HttpAuth build() {
        return new HttpAuth(this.realm, this.username, this.password, this.random, this.providerBuilder.build());
    }

    public JcaHttpAuthBuilder setNonceGenerator(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public JcaHttpAuthBuilder setProvider(String str) {
        this.providerBuilder.setProvider(str);
        return this;
    }

    public JcaHttpAuthBuilder setProvider(Provider provider) {
        this.providerBuilder.setProvider(provider);
        return this;
    }
}

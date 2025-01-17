package org.spongycastle.openssl.jcajce;

import java.security.Provider;
import org.spongycastle.jcajce.util.DefaultJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jcajce.util.ProviderJcaJceHelper;
import org.spongycastle.openssl.PEMDecryptor;
import org.spongycastle.openssl.PEMDecryptorProvider;
import org.spongycastle.openssl.PasswordException;

public class JcePEMDecryptorProviderBuilder {
    /* access modifiers changed from: private */
    public JcaJceHelper helper = new DefaultJcaJceHelper();

    public PEMDecryptorProvider build(final char[] cArr) {
        return new PEMDecryptorProvider() {
            public PEMDecryptor get(final String str) {
                return new PEMDecryptor() {
                    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
                        if (cArr != null) {
                            return PEMUtilities.crypt(false, JcePEMDecryptorProviderBuilder.this.helper, bArr, cArr, str, bArr2);
                        }
                        throw new PasswordException("Password is null, but a password is required");
                    }
                };
            }
        };
    }

    public JcePEMDecryptorProviderBuilder setProvider(String str) {
        this.helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePEMDecryptorProviderBuilder setProvider(Provider provider) {
        this.helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}

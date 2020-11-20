package org.spongycastle.openssl.p188bc;

import org.spongycastle.openssl.PEMDecryptor;
import org.spongycastle.openssl.PEMDecryptorProvider;
import org.spongycastle.openssl.PasswordException;

/* renamed from: org.spongycastle.openssl.bc.BcPEMDecryptorProvider */
public class BcPEMDecryptorProvider implements PEMDecryptorProvider {
    /* access modifiers changed from: private */
    public final char[] password;

    public BcPEMDecryptorProvider(char[] cArr) {
        this.password = cArr;
    }

    public PEMDecryptor get(final String str) {
        return new PEMDecryptor() {
            public byte[] decrypt(byte[] bArr, byte[] bArr2) {
                if (BcPEMDecryptorProvider.this.password != null) {
                    return PEMUtilities.crypt(false, bArr, BcPEMDecryptorProvider.this.password, str, bArr2);
                }
                throw new PasswordException("Password is null, but a password is required");
            }
        };
    }
}

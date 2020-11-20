package org.spongycastle.openssl;

public interface PEMDecryptorProvider {
    PEMDecryptor get(String str);
}

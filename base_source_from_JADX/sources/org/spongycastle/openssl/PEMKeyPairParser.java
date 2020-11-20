package org.spongycastle.openssl;

interface PEMKeyPairParser {
    PEMKeyPair parse(byte[] bArr);
}

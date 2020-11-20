package org.spongycastle.crypto.p180ec;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.math.p186ec.ECPoint;

/* renamed from: org.spongycastle.crypto.ec.ECDecryptor */
public interface ECDecryptor {
    ECPoint decrypt(ECPair eCPair);

    void init(CipherParameters cipherParameters);
}

package org.spongycastle.crypto.p180ec;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.math.p186ec.ECPoint;

/* renamed from: org.spongycastle.crypto.ec.ECEncryptor */
public interface ECEncryptor {
    ECPair encrypt(ECPoint eCPoint);

    void init(CipherParameters cipherParameters);
}

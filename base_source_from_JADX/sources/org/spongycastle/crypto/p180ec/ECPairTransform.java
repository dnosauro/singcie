package org.spongycastle.crypto.p180ec;

import org.spongycastle.crypto.CipherParameters;

/* renamed from: org.spongycastle.crypto.ec.ECPairTransform */
public interface ECPairTransform {
    void init(CipherParameters cipherParameters);

    ECPair transform(ECPair eCPair);
}

package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;

public class KDFParameters implements DerivationParameters {

    /* renamed from: iv */
    byte[] f7880iv;
    byte[] shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.shared = bArr;
        this.f7880iv = bArr2;
    }

    public byte[] getIV() {
        return this.f7880iv;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }
}

package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithIV implements CipherParameters {

    /* renamed from: iv */
    private byte[] f7884iv;
    private CipherParameters parameters;

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr, int i, int i2) {
        this.f7884iv = new byte[i2];
        this.parameters = cipherParameters;
        System.arraycopy(bArr, i, this.f7884iv, 0, i2);
    }

    public byte[] getIV() {
        return this.f7884iv;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}

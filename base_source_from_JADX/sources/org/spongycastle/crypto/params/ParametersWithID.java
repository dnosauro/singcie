package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithID implements CipherParameters {

    /* renamed from: id */
    private byte[] f7883id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f7883id = bArr;
    }

    public byte[] getID() {
        return this.f7883id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}

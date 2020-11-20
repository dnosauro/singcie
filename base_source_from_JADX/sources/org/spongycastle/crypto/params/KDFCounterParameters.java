package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.util.Arrays;

public final class KDFCounterParameters implements DerivationParameters {
    private byte[] fixedInputDataCounterPrefix;
    private byte[] fixedInputDataCounterSuffix;

    /* renamed from: ki */
    private byte[] f7873ki;

    /* renamed from: r */
    private int f7874r;

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, int i) {
        this(bArr, (byte[]) null, bArr2, i);
    }

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (bArr != null) {
            this.f7873ki = Arrays.clone(bArr);
            this.fixedInputDataCounterPrefix = bArr2 == null ? new byte[0] : Arrays.clone(bArr2);
            this.fixedInputDataCounterSuffix = bArr3 == null ? new byte[0] : Arrays.clone(bArr3);
            if (i == 8 || i == 16 || i == 24 || i == 32) {
                this.f7874r = i;
                return;
            }
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getFixedInputDataCounterPrefix() {
        return Arrays.clone(this.fixedInputDataCounterPrefix);
    }

    public byte[] getFixedInputDataCounterSuffix() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getKI() {
        return this.f7873ki;
    }

    public int getR() {
        return this.f7874r;
    }
}

package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ISO18033KDFParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;

public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    private int counterStart;
    private Digest digest;

    /* renamed from: iv */
    private byte[] f7743iv;
    private byte[] shared;

    protected BaseKDFBytesGenerator(int i, Digest digest2) {
        this.counterStart = i;
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 >= i) {
            long j = (long) i2;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = (long) digestSize;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr2 = new byte[this.digest.getDigestSize()];
                byte[] bArr3 = new byte[4];
                Pack.intToBigEndian(this.counterStart, bArr3, 0);
                int i4 = this.counterStart & -256;
                int i5 = i;
                for (int i6 = 0; i6 < i3; i6++) {
                    Digest digest2 = this.digest;
                    byte[] bArr4 = this.shared;
                    digest2.update(bArr4, 0, bArr4.length);
                    this.digest.update(bArr3, 0, bArr3.length);
                    byte[] bArr5 = this.f7743iv;
                    if (bArr5 != null) {
                        this.digest.update(bArr5, 0, bArr5.length);
                    }
                    this.digest.doFinal(bArr2, 0);
                    if (i2 > digestSize) {
                        System.arraycopy(bArr2, 0, bArr, i5, digestSize);
                        i5 += digestSize;
                        i2 -= digestSize;
                    } else {
                        System.arraycopy(bArr2, 0, bArr, i5, i2);
                    }
                    byte b = (byte) (bArr3[3] + 1);
                    bArr3[3] = b;
                    if (b == 0) {
                        i4 += 256;
                        Pack.intToBigEndian(i4, bArr3, 0);
                    }
                }
                this.digest.reset();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        byte[] bArr;
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            bArr = kDFParameters.getIV();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            bArr = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
        this.f7743iv = bArr;
    }
}

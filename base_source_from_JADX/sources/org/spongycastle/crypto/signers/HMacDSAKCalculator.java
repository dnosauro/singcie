package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class HMacDSAKCalculator implements DSAKCalculator {
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: K */
    private final byte[] f7909K = new byte[this.hMac.getMacSize()];

    /* renamed from: V */
    private final byte[] f7910V = new byte[this.hMac.getMacSize()];
    private final HMac hMac;

    /* renamed from: n */
    private BigInteger f7911n;

    public HMacDSAKCalculator(Digest digest) {
        this.hMac = new HMac(digest);
    }

    private BigInteger bitsToInt(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return bArr.length * 8 > this.f7911n.bitLength() ? bigInteger.shiftRight((bArr.length * 8) - this.f7911n.bitLength()) : bigInteger;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f7911n = bigInteger;
        Arrays.fill(this.f7910V, (byte) 1);
        Arrays.fill(this.f7909K, (byte) 0);
        byte[] bArr2 = new byte[((bigInteger.bitLength() + 7) / 8)];
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger2);
        System.arraycopy(asUnsignedByteArray, 0, bArr2, bArr2.length - asUnsignedByteArray.length, asUnsignedByteArray.length);
        byte[] bArr3 = new byte[((bigInteger.bitLength() + 7) / 8)];
        BigInteger bitsToInt = bitsToInt(bArr);
        if (bitsToInt.compareTo(bigInteger) >= 0) {
            bitsToInt = bitsToInt.subtract(bigInteger);
        }
        byte[] asUnsignedByteArray2 = BigIntegers.asUnsignedByteArray(bitsToInt);
        System.arraycopy(asUnsignedByteArray2, 0, bArr3, bArr3.length - asUnsignedByteArray2.length, asUnsignedByteArray2.length);
        this.hMac.init(new KeyParameter(this.f7909K));
        HMac hMac2 = this.hMac;
        byte[] bArr4 = this.f7910V;
        hMac2.update(bArr4, 0, bArr4.length);
        this.hMac.update((byte) 0);
        this.hMac.update(bArr2, 0, bArr2.length);
        this.hMac.update(bArr3, 0, bArr3.length);
        this.hMac.doFinal(this.f7909K, 0);
        this.hMac.init(new KeyParameter(this.f7909K));
        HMac hMac3 = this.hMac;
        byte[] bArr5 = this.f7910V;
        hMac3.update(bArr5, 0, bArr5.length);
        this.hMac.doFinal(this.f7910V, 0);
        HMac hMac4 = this.hMac;
        byte[] bArr6 = this.f7910V;
        hMac4.update(bArr6, 0, bArr6.length);
        this.hMac.update((byte) 1);
        this.hMac.update(bArr2, 0, bArr2.length);
        this.hMac.update(bArr3, 0, bArr3.length);
        this.hMac.doFinal(this.f7909K, 0);
        this.hMac.init(new KeyParameter(this.f7909K));
        HMac hMac5 = this.hMac;
        byte[] bArr7 = this.f7910V;
        hMac5.update(bArr7, 0, bArr7.length);
        this.hMac.doFinal(this.f7910V, 0);
    }

    public void init(BigInteger bigInteger, SecureRandom secureRandom) {
        throw new IllegalStateException("Operation not supported");
    }

    public boolean isDeterministic() {
        return true;
    }

    public BigInteger nextK() {
        byte[] bArr = new byte[((this.f7911n.bitLength() + 7) / 8)];
        while (true) {
            int i = 0;
            while (i < bArr.length) {
                HMac hMac2 = this.hMac;
                byte[] bArr2 = this.f7910V;
                hMac2.update(bArr2, 0, bArr2.length);
                this.hMac.doFinal(this.f7910V, 0);
                int min = Math.min(bArr.length - i, this.f7910V.length);
                System.arraycopy(this.f7910V, 0, bArr, i, min);
                i += min;
            }
            BigInteger bitsToInt = bitsToInt(bArr);
            if (bitsToInt.compareTo(ZERO) > 0 && bitsToInt.compareTo(this.f7911n) < 0) {
                return bitsToInt;
            }
            HMac hMac3 = this.hMac;
            byte[] bArr3 = this.f7910V;
            hMac3.update(bArr3, 0, bArr3.length);
            this.hMac.update((byte) 0);
            this.hMac.doFinal(this.f7909K, 0);
            this.hMac.init(new KeyParameter(this.f7909K));
            HMac hMac4 = this.hMac;
            byte[] bArr4 = this.f7910V;
            hMac4.update(bArr4, 0, bArr4.length);
            this.hMac.doFinal(this.f7910V, 0);
        }
    }
}

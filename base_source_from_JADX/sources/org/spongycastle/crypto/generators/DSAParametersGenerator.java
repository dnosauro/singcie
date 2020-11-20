package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAValidationParameters;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.encoders.Hex;

public class DSAParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: L */
    private int f7744L;

    /* renamed from: N */
    private int f7745N;
    private int certainty;
    private Digest digest;
    private int iterations;
    private SecureRandom random;
    private int usageIndex;
    private boolean use186_3;

    public DSAParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public DSAParametersGenerator(Digest digest2) {
        this.digest = digest2;
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger divide = bigInteger.subtract(ONE).divide(bigInteger2);
        BigInteger subtract = bigInteger.subtract(TWO);
        do {
            modPow = BigIntegers.createRandomInRange(TWO, subtract, secureRandom).modPow(divide, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Verifiable(Digest digest2, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i) {
        BigInteger divide = bigInteger.subtract(ONE).divide(bigInteger2);
        byte[] decode = Hex.decode("6767656E");
        byte[] bArr2 = new byte[(bArr.length + decode.length + 1 + 2)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(decode, 0, bArr2, bArr.length, decode.length);
        bArr2[bArr2.length - 3] = (byte) i;
        byte[] bArr3 = new byte[digest2.getDigestSize()];
        for (int i2 = 1; i2 < 65536; i2++) {
            inc(bArr2);
            hash(digest2, bArr2, bArr3, 0);
            BigInteger modPow = new BigInteger(1, bArr3).modPow(divide, bigInteger);
            if (modPow.compareTo(TWO) >= 0) {
                return modPow;
            }
        }
        return null;
    }

    private DSAParameters generateParameters_FIPS186_2() {
        byte[] bArr = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        byte[] bArr4 = new byte[20];
        int i = this.f7744L;
        int i2 = (i - 1) / 160;
        byte[] bArr5 = new byte[(i / 8)];
        if (this.digest instanceof SHA1Digest) {
            while (true) {
                this.random.nextBytes(bArr);
                hash(this.digest, bArr, bArr2, 0);
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                inc(bArr3);
                hash(this.digest, bArr3, bArr3, 0);
                for (int i3 = 0; i3 != bArr4.length; i3++) {
                    bArr4[i3] = (byte) (bArr2[i3] ^ bArr3[i3]);
                }
                bArr4[0] = (byte) (bArr4[0] | Byte.MIN_VALUE);
                bArr4[19] = (byte) (bArr4[19] | 1);
                BigInteger bigInteger = new BigInteger(1, bArr4);
                if (isProbablePrime(bigInteger)) {
                    byte[] clone = Arrays.clone(bArr);
                    inc(clone);
                    for (int i4 = 0; i4 < 4096; i4++) {
                        for (int i5 = 1; i5 <= i2; i5++) {
                            inc(clone);
                            hash(this.digest, clone, bArr5, bArr5.length - (bArr2.length * i5));
                        }
                        int length = bArr5.length - (bArr2.length * i2);
                        inc(clone);
                        hash(this.digest, clone, bArr2, 0);
                        System.arraycopy(bArr2, bArr2.length - length, bArr5, 0, length);
                        bArr5[0] = (byte) (bArr5[0] | Byte.MIN_VALUE);
                        BigInteger bigInteger2 = new BigInteger(1, bArr5);
                        BigInteger subtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(ONE));
                        if (subtract.bitLength() == this.f7744L && isProbablePrime(subtract)) {
                            return new DSAParameters(subtract, bigInteger, calculateGenerator_FIPS186_2(subtract, bigInteger, this.random), new DSAValidationParameters(bArr, i4));
                        }
                    }
                    continue;
                }
            }
        } else {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ab, code lost:
        r0 = calculateGenerator_FIPS186_3_Verifiable(r0, r11, r6, r2, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.spongycastle.crypto.params.DSAParameters generateParameters_FIPS186_3() {
        /*
            r14 = this;
            org.spongycastle.crypto.Digest r0 = r14.digest
            int r1 = r0.getDigestSize()
            int r1 = r1 * 8
            int r2 = r14.f7745N
            int r2 = r2 / 8
            byte[] r2 = new byte[r2]
            int r3 = r14.f7744L
            int r4 = r3 + -1
            int r4 = r4 / r1
            int r5 = r3 + -1
            int r5 = r5 % r1
            int r3 = r3 / 8
            byte[] r1 = new byte[r3]
            int r3 = r0.getDigestSize()
            byte[] r3 = new byte[r3]
        L_0x0020:
            java.security.SecureRandom r5 = r14.random
            r5.nextBytes(r2)
            r5 = 0
            hash(r0, r2, r3, r5)
            java.math.BigInteger r6 = new java.math.BigInteger
            r7 = 1
            r6.<init>(r7, r3)
            java.math.BigInteger r8 = ONE
            int r9 = r14.f7745N
            int r9 = r9 - r7
            java.math.BigInteger r8 = r8.shiftLeft(r9)
            java.math.BigInteger r6 = r6.mod(r8)
            java.math.BigInteger r6 = r6.setBit(r5)
            int r8 = r14.f7745N
            int r8 = r8 - r7
            java.math.BigInteger r6 = r6.setBit(r8)
            boolean r8 = r14.isProbablePrime(r6)
            if (r8 != 0) goto L_0x004e
            goto L_0x0020
        L_0x004e:
            byte[] r8 = org.spongycastle.util.Arrays.clone((byte[]) r2)
            int r9 = r14.f7744L
            int r9 = r9 * 4
            r10 = 0
        L_0x0057:
            if (r10 >= r9) goto L_0x0020
            r11 = 1
        L_0x005a:
            if (r11 > r4) goto L_0x006a
            inc(r8)
            int r12 = r1.length
            int r13 = r3.length
            int r13 = r13 * r11
            int r12 = r12 - r13
            hash(r0, r8, r1, r12)
            int r11 = r11 + 1
            goto L_0x005a
        L_0x006a:
            int r11 = r1.length
            int r12 = r3.length
            int r12 = r12 * r4
            int r11 = r11 - r12
            inc(r8)
            hash(r0, r8, r3, r5)
            int r12 = r3.length
            int r12 = r12 - r11
            java.lang.System.arraycopy(r3, r12, r1, r5, r11)
            byte r11 = r1[r5]
            r11 = r11 | -128(0xffffffffffffff80, float:NaN)
            byte r11 = (byte) r11
            r1[r5] = r11
            java.math.BigInteger r11 = new java.math.BigInteger
            r11.<init>(r7, r1)
            java.math.BigInteger r12 = r6.shiftLeft(r7)
            java.math.BigInteger r12 = r11.mod(r12)
            java.math.BigInteger r13 = ONE
            java.math.BigInteger r12 = r12.subtract(r13)
            java.math.BigInteger r11 = r11.subtract(r12)
            int r12 = r11.bitLength()
            int r13 = r14.f7744L
            if (r12 == r13) goto L_0x00a1
            goto L_0x00cf
        L_0x00a1:
            boolean r12 = r14.isProbablePrime(r11)
            if (r12 == 0) goto L_0x00cf
            int r1 = r14.usageIndex
            if (r1 < 0) goto L_0x00be
            java.math.BigInteger r0 = calculateGenerator_FIPS186_3_Verifiable(r0, r11, r6, r2, r1)
            if (r0 == 0) goto L_0x00be
            org.spongycastle.crypto.params.DSAParameters r1 = new org.spongycastle.crypto.params.DSAParameters
            org.spongycastle.crypto.params.DSAValidationParameters r3 = new org.spongycastle.crypto.params.DSAValidationParameters
            int r4 = r14.usageIndex
            r3.<init>(r2, r10, r4)
            r1.<init>(r11, r6, r0, r3)
            return r1
        L_0x00be:
            java.security.SecureRandom r0 = r14.random
            java.math.BigInteger r0 = calculateGenerator_FIPS186_3_Unverifiable(r11, r6, r0)
            org.spongycastle.crypto.params.DSAParameters r1 = new org.spongycastle.crypto.params.DSAParameters
            org.spongycastle.crypto.params.DSAValidationParameters r3 = new org.spongycastle.crypto.params.DSAValidationParameters
            r3.<init>(r2, r10)
            r1.<init>(r11, r6, r0, r3)
            return r1
        L_0x00cf:
            int r10 = r10 + 1
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.generators.DSAParametersGenerator.generateParameters_FIPS186_3():org.spongycastle.crypto.params.DSAParameters");
    }

    private static int getDefaultN(int i) {
        return i > 1024 ? 256 : 160;
    }

    private static int getMinimumIterations(int i) {
        if (i <= 1024) {
            return 40;
        }
        return (((i - 1) / 1024) * 8) + 48;
    }

    private static void hash(Digest digest2, byte[] bArr, byte[] bArr2, int i) {
        digest2.update(bArr, 0, bArr.length);
        digest2.doFinal(bArr2, i);
    }

    private static void inc(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0) {
            byte b = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b;
            if (b == 0) {
                length--;
            } else {
                return;
            }
        }
    }

    private boolean isProbablePrime(BigInteger bigInteger) {
        return bigInteger.isProbablePrime(this.certainty);
    }

    public DSAParameters generateParameters() {
        return this.use186_3 ? generateParameters_FIPS186_3() : generateParameters_FIPS186_2();
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.f7744L = i;
        this.f7745N = getDefaultN(i);
        this.certainty = i2;
        this.iterations = Math.max(getMinimumIterations(this.f7744L), (i2 + 1) / 2);
        this.random = secureRandom;
        this.use186_3 = false;
        this.usageIndex = -1;
    }

    public void init(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int l = dSAParameterGenerationParameters.getL();
        int n = dSAParameterGenerationParameters.getN();
        if (l < 1024 || l > 3072 || l % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        } else if (l == 1024 && n != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        } else if (l == 2048 && n != 224 && n != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        } else if (l == 3072 && n != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        } else if (this.digest.getDigestSize() * 8 >= n) {
            this.f7744L = l;
            this.f7745N = n;
            this.certainty = dSAParameterGenerationParameters.getCertainty();
            this.iterations = Math.max(getMinimumIterations(l), (this.certainty + 1) / 2);
            this.random = dSAParameterGenerationParameters.getRandom();
            this.use186_3 = true;
            this.usageIndex = dSAParameterGenerationParameters.getUsageIndex();
        } else {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
    }
}

package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class KGCMBlockCipher implements AEADBlockCipher {
    private static final int BITS_IN_BYTE = 8;
    private static final BigInteger MASK_1_128 = new BigInteger("340282366920938463463374607431768211456", 10);
    private static final BigInteger MASK_1_256 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639936", 10);
    private static final BigInteger MASK_1_512 = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084096", 10);
    private static final BigInteger MASK_2_128 = new BigInteger("340282366920938463463374607431768211455", 10);
    private static final BigInteger MASK_2_256 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639935", 10);
    private static final BigInteger MASK_2_512 = new BigInteger("13407807929942597099574024998205846127479365820592393377723561443721764030073546976801874298166903427690031858186486050853753882811946569946433649006084095", 10);
    private static final int MIN_MAC_BITS = 64;
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger POLYRED_128 = new BigInteger("135", 10);
    private static final BigInteger POLYRED_256 = new BigInteger("1061", 10);
    private static final BigInteger POLYRED_512 = new BigInteger("293", 10);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    /* renamed from: H */
    private byte[] f7810H;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();

    /* renamed from: b */
    private byte[] f7811b;
    private BufferedBlockCipher ctrEngine;
    private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* renamed from: iv */
    private byte[] f7812iv;
    private int lambda_c;
    private int lambda_o;
    private byte[] macBlock;
    private int macSize;
    private byte[] temp;

    private class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }

    public KGCMBlockCipher(BlockCipher blockCipher) {
        this.engine = blockCipher;
        this.ctrEngine = new BufferedBlockCipher(new KCTRBlockCipher(this.engine));
        this.macSize = 0;
        this.initialAssociatedText = new byte[this.engine.getBlockSize()];
        this.f7812iv = new byte[this.engine.getBlockSize()];
        this.f7810H = new byte[this.engine.getBlockSize()];
        this.f7811b = new byte[this.engine.getBlockSize()];
        this.temp = new byte[this.engine.getBlockSize()];
        this.lambda_c = 0;
        this.lambda_o = 0;
        this.macBlock = null;
    }

    private void calculateMac(byte[] bArr, int i, int i2) {
        this.macBlock = new byte[this.engine.getBlockSize()];
        while (i2 > 0) {
            for (int i3 = 0; i3 < this.engine.getBlockSize(); i3++) {
                byte[] bArr2 = this.f7811b;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i3 + i]);
            }
            multiplyOverField(this.engine.getBlockSize() * 8, this.f7811b, this.f7810H, this.temp);
            this.temp = Arrays.reverse(this.temp);
            System.arraycopy(this.temp, 0, this.f7811b, 0, this.engine.getBlockSize());
            i2 -= this.engine.getBlockSize();
            i += this.engine.getBlockSize();
        }
        Arrays.fill(this.temp, (byte) 0);
        intToBytes(this.lambda_o, this.temp, 0);
        intToBytes(this.lambda_c, this.temp, this.engine.getBlockSize() / 2);
        for (int i4 = 0; i4 < this.engine.getBlockSize(); i4++) {
            byte[] bArr3 = this.f7811b;
            bArr3[i4] = (byte) (bArr3[i4] ^ this.temp[i4]);
        }
        this.engine.processBlock(this.f7811b, 0, this.macBlock, 0);
    }

    private void intToBytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >> 24);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2] = (byte) i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void multiplyOverField(int r8, byte[] r9, byte[] r10, byte[] r11) {
        /*
            r7 = this;
            org.spongycastle.crypto.BlockCipher r0 = r7.engine
            int r0 = r0.getBlockSize()
            byte[] r0 = new byte[r0]
            org.spongycastle.crypto.BlockCipher r1 = r7.engine
            int r1 = r1.getBlockSize()
            byte[] r1 = new byte[r1]
            org.spongycastle.crypto.BlockCipher r2 = r7.engine
            int r2 = r2.getBlockSize()
            r3 = 0
            java.lang.System.arraycopy(r9, r3, r0, r3, r2)
            org.spongycastle.crypto.BlockCipher r9 = r7.engine
            int r9 = r9.getBlockSize()
            java.lang.System.arraycopy(r10, r3, r1, r3, r9)
            byte[] r9 = org.spongycastle.util.Arrays.reverse((byte[]) r0)
            byte[] r10 = org.spongycastle.util.Arrays.reverse((byte[]) r1)
            r0 = 128(0x80, float:1.794E-43)
            if (r8 == r0) goto L_0x0037
            r0 = 256(0x100, float:3.59E-43)
            if (r8 == r0) goto L_0x0045
            r0 = 512(0x200, float:7.175E-43)
            if (r8 == r0) goto L_0x003e
        L_0x0037:
            java.math.BigInteger r8 = MASK_1_128
            java.math.BigInteger r0 = MASK_2_128
            java.math.BigInteger r1 = POLYRED_128
            goto L_0x004b
        L_0x003e:
            java.math.BigInteger r8 = MASK_1_512
            java.math.BigInteger r0 = MASK_2_512
            java.math.BigInteger r1 = POLYRED_512
            goto L_0x004b
        L_0x0045:
            java.math.BigInteger r8 = MASK_1_256
            java.math.BigInteger r0 = MASK_2_256
            java.math.BigInteger r1 = POLYRED_256
        L_0x004b:
            java.math.BigInteger r2 = ZERO
            java.math.BigInteger r4 = new java.math.BigInteger
            r5 = 1
            r4.<init>(r5, r9)
            java.math.BigInteger r9 = new java.math.BigInteger
            r9.<init>(r5, r10)
        L_0x0058:
            java.math.BigInteger r10 = ZERO
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x008d
            java.math.BigInteger r10 = ONE
            java.math.BigInteger r10 = r9.and(r10)
            java.math.BigInteger r6 = ONE
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0073
            java.math.BigInteger r10 = r2.xor(r4)
            r2 = r10
        L_0x0073:
            java.math.BigInteger r10 = r4.shiftLeft(r5)
            java.math.BigInteger r4 = r10.and(r8)
            java.math.BigInteger r6 = ZERO
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0087
            java.math.BigInteger r10 = r10.xor(r1)
        L_0x0087:
            r4 = r10
            java.math.BigInteger r9 = r9.shiftRight(r5)
            goto L_0x0058
        L_0x008d:
            java.math.BigInteger r8 = r2.and(r0)
            byte[] r8 = org.spongycastle.util.BigIntegers.asUnsignedByteArray(r8)
            org.spongycastle.util.Arrays.fill((byte[]) r11, (byte) r3)
            int r9 = r8.length
            java.lang.System.arraycopy(r8, r3, r11, r3, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.modes.KGCMBlockCipher.multiplyOverField(int, byte[], byte[], byte[]):void");
    }

    private void processAAD(byte[] bArr, int i, int i2) {
        this.lambda_o = i2 * 8;
        BlockCipher blockCipher = this.engine;
        byte[] bArr2 = this.f7810H;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        while (i2 > 0) {
            for (int i3 = 0; i3 < this.engine.getBlockSize(); i3++) {
                byte[] bArr3 = this.f7811b;
                bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
            }
            multiplyOverField(this.engine.getBlockSize() * 8, this.f7811b, this.f7810H, this.temp);
            this.temp = Arrays.reverse(this.temp);
            System.arraycopy(this.temp, 0, this.f7811b, 0, this.engine.getBlockSize());
            i2 -= this.engine.getBlockSize();
            i += this.engine.getBlockSize();
        }
    }

    public int doFinal(byte[] bArr, int i) {
        int i2;
        int size = this.data.size();
        if (this.associatedText.size() > 0) {
            processAAD(this.associatedText.getBuffer(), 0, this.associatedText.size());
        }
        if (!this.forEncryption) {
            this.lambda_c = (size - this.macSize) * 8;
            calculateMac(this.data.getBuffer(), 0, size - this.macSize);
            int processBytes = this.ctrEngine.processBytes(this.data.getBuffer(), 0, size - this.macSize, bArr, i);
            i2 = processBytes + this.ctrEngine.doFinal(bArr, i + processBytes);
        } else if (bArr.length - i >= this.macSize + size) {
            this.lambda_c = size * 8;
            int processBytes2 = this.ctrEngine.processBytes(this.data.getBuffer(), 0, size, bArr, i);
            i2 = processBytes2 + this.ctrEngine.doFinal(bArr, i + processBytes2);
            calculateMac(bArr, i, size);
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
        int i3 = i + i2;
        byte[] bArr2 = this.macBlock;
        if (bArr2 == null) {
            throw new IllegalStateException("mac is not calculated");
        } else if (this.forEncryption) {
            System.arraycopy(bArr2, 0, bArr, i3, this.macSize);
            reset();
            return i2 + this.macSize;
        } else {
            byte[] bArr3 = new byte[this.macSize];
            System.arraycopy(this.data.getBuffer(), i2, bArr3, 0, this.macSize);
            int i4 = this.macSize;
            byte[] bArr4 = new byte[i4];
            System.arraycopy(this.macBlock, 0, bArr4, 0, i4);
            if (Arrays.constantTimeAreEqual(bArr3, bArr4)) {
                reset();
                return i2;
            }
            throw new InvalidCipherTextException("mac verification failed");
        }
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KGCM";
    }

    public byte[] getMac() {
        int i = this.macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
    }

    public int getOutputSize(int i) {
        return this.forEncryption ? i : i + this.macSize;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public int getUpdateOutputSize(int i) {
        return i;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            byte[] nonce = aEADParameters.getNonce();
            byte[] bArr = this.f7812iv;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(nonce, 0, this.f7812iv, bArr.length - nonce.length, nonce.length);
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize2 = aEADParameters.getMacSize();
            if (macSize2 < 64 || macSize2 > this.engine.getBlockSize() * 8 || macSize2 % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize2);
            }
            this.macSize = macSize2 / 8;
            keyParameter = aEADParameters.getKey();
            byte[] bArr2 = this.initialAssociatedText;
            if (bArr2 != null) {
                processAADBytes(bArr2, 0, bArr2.length);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr3 = this.f7812iv;
            Arrays.fill(bArr3, (byte) 0);
            System.arraycopy(iv, 0, this.f7812iv, bArr3.length - iv.length, iv.length);
            this.initialAssociatedText = null;
            this.macSize = this.engine.getBlockSize();
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameter passed");
        }
        this.macBlock = new byte[this.engine.getBlockSize()];
        this.ctrEngine.init(true, new ParametersWithIV(keyParameter, this.f7812iv));
        this.engine.init(true, keyParameter);
    }

    public void processAADByte(byte b) {
        this.associatedText.write(b);
    }

    public void processAADBytes(byte[] bArr, int i, int i2) {
        this.associatedText.write(bArr, i, i2);
    }

    public int processByte(byte b, byte[] bArr, int i) {
        this.data.write(b);
        return 0;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length >= i + i2) {
            this.data.write(bArr, i, i2);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    public void reset() {
        this.f7810H = new byte[this.engine.getBlockSize()];
        this.f7811b = new byte[this.engine.getBlockSize()];
        this.temp = new byte[this.engine.getBlockSize()];
        this.lambda_c = 0;
        this.lambda_o = 0;
        this.engine.reset();
        this.data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}

package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class KCCMBlockCipher implements AEADBlockCipher {
    private static final int BITS_IN_BYTE = 8;
    private static final int BYTES_IN_INT = 4;
    private static final int MAX_MAC_BIT_LENGTH = 512;
    private static final int MIN_MAC_BIT_LENGTH = 64;

    /* renamed from: G1 */
    private byte[] f7807G1;
    private int Nb_;
    private ExposedByteArrayOutputStream associatedText;
    private byte[] buffer;
    private byte[] counter;
    private ExposedByteArrayOutputStream data;
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private byte[] mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    /* renamed from: s */
    private byte[] f7808s;

    private class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, 4);
    }

    public KCCMBlockCipher(BlockCipher blockCipher, int i) {
        this.associatedText = new ExposedByteArrayOutputStream();
        this.data = new ExposedByteArrayOutputStream();
        this.Nb_ = 4;
        this.engine = blockCipher;
        this.macSize = blockCipher.getBlockSize();
        this.nonce = new byte[blockCipher.getBlockSize()];
        this.initialAssociatedText = new byte[blockCipher.getBlockSize()];
        this.mac = new byte[blockCipher.getBlockSize()];
        this.macBlock = new byte[blockCipher.getBlockSize()];
        this.f7807G1 = new byte[blockCipher.getBlockSize()];
        this.buffer = new byte[blockCipher.getBlockSize()];
        this.f7808s = new byte[blockCipher.getBlockSize()];
        this.counter = new byte[blockCipher.getBlockSize()];
        setNb(i);
    }

    private void CalculateMac(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            for (int i3 = 0; i3 < this.engine.getBlockSize(); i3++) {
                byte[] bArr2 = this.macBlock;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i + i3]);
            }
            BlockCipher blockCipher = this.engine;
            byte[] bArr3 = this.macBlock;
            blockCipher.processBlock(bArr3, 0, bArr3, 0);
            i2 -= this.engine.getBlockSize();
            i += this.engine.getBlockSize();
        }
    }

    private void ProcessBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        while (true) {
            byte[] bArr3 = this.counter;
            if (i4 >= bArr3.length) {
                break;
            }
            byte[] bArr4 = this.f7808s;
            bArr4[i4] = (byte) (bArr4[i4] + bArr3[i4]);
            i4++;
        }
        this.engine.processBlock(this.f7808s, 0, this.buffer, 0);
        for (int i5 = 0; i5 < this.engine.getBlockSize(); i5++) {
            bArr2[i3 + i5] = (byte) (this.buffer[i5] ^ bArr[i + i5]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[LOOP:0: B:21:0x003d->B:23:0x0044, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte getFlag(boolean r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            if (r3 == 0) goto L_0x000a
            java.lang.String r3 = "1"
            goto L_0x000c
        L_0x000a:
            java.lang.String r3 = "0"
        L_0x000c:
            r0.append(r3)
            r3 = 8
            if (r4 == r3) goto L_0x0030
            r3 = 16
            if (r4 == r3) goto L_0x002d
            r3 = 32
            if (r4 == r3) goto L_0x002a
            r3 = 48
            if (r4 == r3) goto L_0x0027
            r3 = 64
            if (r4 == r3) goto L_0x0024
            goto L_0x0035
        L_0x0024:
            java.lang.String r3 = "110"
            goto L_0x0032
        L_0x0027:
            java.lang.String r3 = "101"
            goto L_0x0032
        L_0x002a:
            java.lang.String r3 = "100"
            goto L_0x0032
        L_0x002d:
            java.lang.String r3 = "011"
            goto L_0x0032
        L_0x0030:
            java.lang.String r3 = "010"
        L_0x0032:
            r0.append(r3)
        L_0x0035:
            int r3 = r2.Nb_
            int r3 = r3 + -1
            java.lang.String r3 = java.lang.Integer.toBinaryString(r3)
        L_0x003d:
            int r4 = r3.length()
            r1 = 4
            if (r4 >= r1) goto L_0x0055
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>(r3)
            r3 = 0
            java.lang.String r1 = "0"
            java.lang.StringBuffer r3 = r4.insert(r3, r1)
            java.lang.String r3 = r3.toString()
            goto L_0x003d
        L_0x0055:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4 = 2
            int r3 = java.lang.Integer.parseInt(r3, r4)
            byte r3 = (byte) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.modes.KCCMBlockCipher.getFlag(boolean, int):byte");
    }

    private void intToBytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >> 24);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2] = (byte) i;
    }

    private void processAAD(byte[] bArr, int i, int i2, int i3) {
        if (i2 - i < this.engine.getBlockSize()) {
            throw new IllegalArgumentException("authText buffer too short");
        } else if (i2 % this.engine.getBlockSize() == 0) {
            byte[] bArr2 = this.nonce;
            System.arraycopy(bArr2, 0, this.f7807G1, 0, (bArr2.length - this.Nb_) - 1);
            intToBytes(i3, this.buffer, 0);
            System.arraycopy(this.buffer, 0, this.f7807G1, (this.nonce.length - this.Nb_) - 1, 4);
            byte[] bArr3 = this.f7807G1;
            bArr3[bArr3.length - 1] = getFlag(true, this.macSize);
            this.engine.processBlock(this.f7807G1, 0, this.macBlock, 0);
            intToBytes(i2, this.buffer, 0);
            if (i2 <= this.engine.getBlockSize() - this.Nb_) {
                for (int i4 = 0; i4 < i2; i4++) {
                    byte[] bArr4 = this.buffer;
                    int i5 = this.Nb_ + i4;
                    bArr4[i5] = (byte) (bArr4[i5] ^ bArr[i + i4]);
                }
                for (int i6 = 0; i6 < this.engine.getBlockSize(); i6++) {
                    byte[] bArr5 = this.macBlock;
                    bArr5[i6] = (byte) (bArr5[i6] ^ this.buffer[i6]);
                }
                BlockCipher blockCipher = this.engine;
                byte[] bArr6 = this.macBlock;
                blockCipher.processBlock(bArr6, 0, bArr6, 0);
                return;
            }
            for (int i7 = 0; i7 < this.engine.getBlockSize(); i7++) {
                byte[] bArr7 = this.macBlock;
                bArr7[i7] = (byte) (bArr7[i7] ^ this.buffer[i7]);
            }
            BlockCipher blockCipher2 = this.engine;
            byte[] bArr8 = this.macBlock;
            blockCipher2.processBlock(bArr8, 0, bArr8, 0);
            while (i2 != 0) {
                for (int i8 = 0; i8 < this.engine.getBlockSize(); i8++) {
                    byte[] bArr9 = this.macBlock;
                    bArr9[i8] = (byte) (bArr9[i8] ^ bArr[i8 + i]);
                }
                BlockCipher blockCipher3 = this.engine;
                byte[] bArr10 = this.macBlock;
                blockCipher3.processBlock(bArr10, 0, bArr10, 0);
                i += this.engine.getBlockSize();
                i2 -= this.engine.getBlockSize();
            }
        } else {
            throw new IllegalArgumentException("padding not supported");
        }
    }

    private void setNb(int i) {
        if (i == 4 || i == 6 || i == 8) {
            this.Nb_ = i;
            return;
        }
        throw new IllegalArgumentException("Nb = 4 is recommended by DSTU7624 but can be changed to only 6 or 8 in this implementation");
    }

    public int doFinal(byte[] bArr, int i) {
        int processPacket = processPacket(this.data.getBuffer(), 0, this.data.size(), bArr, i);
        reset();
        return processPacket;
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KCCM";
    }

    public byte[] getMac() {
        return Arrays.clone(this.mac);
    }

    public int getOutputSize(int i) {
        return i + this.macSize;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public int getUpdateOutputSize(int i) {
        return i;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            if (aEADParameters.getMacSize() > 512 || aEADParameters.getMacSize() < 64 || aEADParameters.getMacSize() % 8 != 0) {
                throw new IllegalArgumentException("Invalid mac size specified");
            }
            this.nonce = aEADParameters.getNonce();
            this.macSize = aEADParameters.getMacSize() / 8;
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.macSize = this.engine.getBlockSize();
            this.initialAssociatedText = null;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameters specified");
        }
        this.mac = new byte[this.macSize];
        this.forEncryption = z;
        this.engine.init(true, cipherParameters2);
        this.counter[0] = 1;
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
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

    public int processPacket(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5;
        int i6;
        byte[] bArr3;
        if (bArr.length - i < i2) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr2.length - i3 >= i2) {
            if (this.associatedText.size() > 0) {
                if (this.forEncryption) {
                    bArr3 = this.associatedText.getBuffer();
                    i6 = this.associatedText.size();
                    i5 = this.data.size();
                } else {
                    bArr3 = this.associatedText.getBuffer();
                    i6 = this.associatedText.size();
                    i5 = this.data.size() - this.macSize;
                }
                processAAD(bArr3, 0, i6, i5);
            }
            if (this.forEncryption) {
                if (i2 % this.engine.getBlockSize() == 0) {
                    CalculateMac(bArr, i, i2);
                    this.engine.processBlock(this.nonce, 0, this.f7808s, 0);
                    int i7 = i3;
                    int i8 = i;
                    int i9 = i2;
                    while (i9 > 0) {
                        ProcessBlock(bArr, i8, i2, bArr2, i7);
                        i9 -= this.engine.getBlockSize();
                        i8 += this.engine.getBlockSize();
                        i7 += this.engine.getBlockSize();
                    }
                    int i10 = 0;
                    while (true) {
                        byte[] bArr4 = this.counter;
                        if (i10 >= bArr4.length) {
                            break;
                        }
                        byte[] bArr5 = this.f7808s;
                        bArr5[i10] = (byte) (bArr5[i10] + bArr4[i10]);
                        i10++;
                    }
                    this.engine.processBlock(this.f7808s, 0, this.buffer, 0);
                    int i11 = 0;
                    while (true) {
                        int i12 = this.macSize;
                        if (i11 < i12) {
                            bArr2[i7 + i11] = (byte) (this.buffer[i11] ^ this.macBlock[i11]);
                            i11++;
                        } else {
                            System.arraycopy(this.macBlock, 0, this.mac, 0, i12);
                            reset();
                            return i2 + this.macSize;
                        }
                    }
                } else {
                    throw new DataLengthException("partial blocks not supported");
                }
            } else if ((i2 - this.macSize) % this.engine.getBlockSize() == 0) {
                this.engine.processBlock(this.nonce, 0, this.f7808s, 0);
                int blockSize = i2 / this.engine.getBlockSize();
                int i13 = i3;
                int i14 = i;
                for (int i15 = 0; i15 < blockSize; i15++) {
                    ProcessBlock(bArr, i14, i2, bArr2, i13);
                    i14 += this.engine.getBlockSize();
                    i13 += this.engine.getBlockSize();
                }
                if (i2 > i14) {
                    int i16 = 0;
                    while (true) {
                        byte[] bArr6 = this.counter;
                        if (i16 >= bArr6.length) {
                            break;
                        }
                        byte[] bArr7 = this.f7808s;
                        bArr7[i16] = (byte) (bArr7[i16] + bArr6[i16]);
                        i16++;
                    }
                    this.engine.processBlock(this.f7808s, 0, this.buffer, 0);
                    int i17 = 0;
                    while (true) {
                        i4 = this.macSize;
                        if (i17 >= i4) {
                            break;
                        }
                        bArr2[i13 + i17] = (byte) (this.buffer[i17] ^ bArr[i14 + i17]);
                        i17++;
                    }
                    i13 += i4;
                }
                int i18 = 0;
                while (true) {
                    byte[] bArr8 = this.counter;
                    if (i18 >= bArr8.length) {
                        break;
                    }
                    byte[] bArr9 = this.f7808s;
                    bArr9[i18] = (byte) (bArr9[i18] + bArr8[i18]);
                    i18++;
                }
                this.engine.processBlock(this.f7808s, 0, this.buffer, 0);
                int i19 = this.macSize;
                System.arraycopy(bArr2, i13 - i19, this.buffer, 0, i19);
                CalculateMac(bArr2, 0, i13 - this.macSize);
                System.arraycopy(this.macBlock, 0, this.mac, 0, this.macSize);
                int i20 = this.macSize;
                byte[] bArr10 = new byte[i20];
                System.arraycopy(this.buffer, 0, bArr10, 0, i20);
                if (Arrays.constantTimeAreEqual(this.mac, bArr10)) {
                    reset();
                    return i2 - this.macSize;
                }
                throw new InvalidCipherTextException("mac check failed");
            } else {
                throw new DataLengthException("partial blocks not supported");
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        Arrays.fill(this.f7807G1, (byte) 0);
        Arrays.fill(this.buffer, (byte) 0);
        Arrays.fill(this.counter, (byte) 0);
        Arrays.fill(this.macBlock, (byte) 0);
        this.counter[0] = 1;
        this.data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}

package org.spongycastle.crypto.macs;

import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* renamed from: h0 */
    private int f7760h0;

    /* renamed from: h1 */
    private int f7761h1;

    /* renamed from: h2 */
    private int f7762h2;

    /* renamed from: h3 */
    private int f7763h3;

    /* renamed from: h4 */
    private int f7764h4;

    /* renamed from: k0 */
    private int f7765k0;

    /* renamed from: k1 */
    private int f7766k1;

    /* renamed from: k2 */
    private int f7767k2;

    /* renamed from: k3 */
    private int f7768k3;

    /* renamed from: r0 */
    private int f7769r0;

    /* renamed from: r1 */
    private int f7770r1;

    /* renamed from: r2 */
    private int f7771r2;

    /* renamed from: r3 */
    private int f7772r3;

    /* renamed from: r4 */
    private int f7773r4;

    /* renamed from: s1 */
    private int f7774s1;

    /* renamed from: s2 */
    private int f7775s2;

    /* renamed from: s3 */
    private int f7776s3;

    /* renamed from: s4 */
    private int f7777s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() == 16) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }

    private static final long mul32x32_64(int i, int i2) {
        return (((long) i) & BodyPartID.bodyIdMax) * ((long) i2);
    }

    private void processBlock() {
        int i = this.currentBlockOffset;
        if (i < 16) {
            this.currentBlock[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.currentBlock[i2] = 0;
            }
        }
        long littleEndianToInt = ((long) Pack.littleEndianToInt(this.currentBlock, 0)) & BodyPartID.bodyIdMax;
        long littleEndianToInt2 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & BodyPartID.bodyIdMax;
        long littleEndianToInt3 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & BodyPartID.bodyIdMax;
        long littleEndianToInt4 = BodyPartID.bodyIdMax & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        this.f7760h0 = (int) (((long) this.f7760h0) + (littleEndianToInt & 67108863));
        this.f7761h1 = (int) (((long) this.f7761h1) + ((((littleEndianToInt2 << 32) | littleEndianToInt) >>> 26) & 67108863));
        this.f7762h2 = (int) (((long) this.f7762h2) + (((littleEndianToInt2 | (littleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.f7763h3 = (int) (((long) this.f7763h3) + ((((littleEndianToInt4 << 32) | littleEndianToInt3) >>> 14) & 67108863));
        this.f7764h4 = (int) (((long) this.f7764h4) + (littleEndianToInt4 >>> 8));
        if (this.currentBlockOffset == 16) {
            this.f7764h4 += 16777216;
        }
        long mul32x32_64 = mul32x32_64(this.f7760h0, this.f7769r0) + mul32x32_64(this.f7761h1, this.f7777s4) + mul32x32_64(this.f7762h2, this.f7776s3) + mul32x32_64(this.f7763h3, this.f7775s2) + mul32x32_64(this.f7764h4, this.f7774s1);
        long mul32x32_642 = mul32x32_64(this.f7760h0, this.f7770r1) + mul32x32_64(this.f7761h1, this.f7769r0) + mul32x32_64(this.f7762h2, this.f7777s4) + mul32x32_64(this.f7763h3, this.f7776s3) + mul32x32_64(this.f7764h4, this.f7775s2);
        long mul32x32_643 = mul32x32_64(this.f7760h0, this.f7771r2) + mul32x32_64(this.f7761h1, this.f7770r1) + mul32x32_64(this.f7762h2, this.f7769r0) + mul32x32_64(this.f7763h3, this.f7777s4) + mul32x32_64(this.f7764h4, this.f7776s3);
        long mul32x32_644 = mul32x32_64(this.f7760h0, this.f7772r3) + mul32x32_64(this.f7761h1, this.f7771r2) + mul32x32_64(this.f7762h2, this.f7770r1) + mul32x32_64(this.f7763h3, this.f7769r0) + mul32x32_64(this.f7764h4, this.f7777s4);
        long mul32x32_645 = mul32x32_64(this.f7760h0, this.f7773r4) + mul32x32_64(this.f7761h1, this.f7772r3) + mul32x32_64(this.f7762h2, this.f7771r2) + mul32x32_64(this.f7763h3, this.f7770r1) + mul32x32_64(this.f7764h4, this.f7769r0);
        this.f7760h0 = ((int) mul32x32_64) & 67108863;
        long j = mul32x32_642 + (mul32x32_64 >>> 26);
        this.f7761h1 = ((int) j) & 67108863;
        long j2 = mul32x32_643 + (j >>> 26);
        this.f7762h2 = ((int) j2) & 67108863;
        long j3 = mul32x32_644 + (j2 >>> 26);
        this.f7763h3 = ((int) j3) & 67108863;
        long j4 = mul32x32_645 + (j3 >>> 26);
        this.f7764h4 = ((int) j4) & 67108863;
        this.f7760h0 += ((int) (j4 >>> 26)) * 5;
        int i3 = this.f7761h1;
        int i4 = this.f7760h0;
        this.f7761h1 = i3 + (i4 >>> 26);
        this.f7760h0 = i4 & 67108863;
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        } else if (this.cipher == null || (bArr2 != null && bArr2.length == 16)) {
            int i = 0;
            int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
            this.f7769r0 = 67108863 & littleEndianToInt;
            this.f7770r1 = ((littleEndianToInt >>> 26) | (littleEndianToInt2 << 6)) & 67108611;
            this.f7771r2 = ((littleEndianToInt2 >>> 20) | (littleEndianToInt3 << 12)) & 67092735;
            this.f7772r3 = ((littleEndianToInt3 >>> 14) | (littleEndianToInt4 << 18)) & 66076671;
            this.f7773r4 = (littleEndianToInt4 >>> 8) & 1048575;
            this.f7774s1 = this.f7770r1 * 5;
            this.f7775s2 = this.f7771r2 * 5;
            this.f7776s3 = this.f7772r3 * 5;
            this.f7777s4 = this.f7773r4 * 5;
            BlockCipher blockCipher = this.cipher;
            if (blockCipher == null) {
                i = 16;
            } else {
                byte[] bArr3 = new byte[16];
                blockCipher.init(true, new KeyParameter(bArr, 16, 16));
                this.cipher.processBlock(bArr2, 0, bArr3, 0);
                bArr = bArr3;
            }
            this.f7765k0 = Pack.littleEndianToInt(bArr, i + 0);
            this.f7766k1 = Pack.littleEndianToInt(bArr, i + 4);
            this.f7767k2 = Pack.littleEndianToInt(bArr, i + 8);
            this.f7768k3 = Pack.littleEndianToInt(bArr, i + 12);
        } else {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
    }

    public int doFinal(byte[] bArr, int i) {
        if (i + 16 <= bArr.length) {
            if (this.currentBlockOffset > 0) {
                processBlock();
            }
            int i2 = this.f7761h1;
            int i3 = this.f7760h0;
            this.f7761h1 = i2 + (i3 >>> 26);
            this.f7760h0 = i3 & 67108863;
            int i4 = this.f7762h2;
            int i5 = this.f7761h1;
            this.f7762h2 = i4 + (i5 >>> 26);
            this.f7761h1 = i5 & 67108863;
            int i6 = this.f7763h3;
            int i7 = this.f7762h2;
            this.f7763h3 = i6 + (i7 >>> 26);
            this.f7762h2 = i7 & 67108863;
            int i8 = this.f7764h4;
            int i9 = this.f7763h3;
            this.f7764h4 = i8 + (i9 >>> 26);
            this.f7763h3 = i9 & 67108863;
            int i10 = this.f7760h0;
            int i11 = this.f7764h4;
            this.f7760h0 = i10 + ((i11 >>> 26) * 5);
            this.f7764h4 = i11 & 67108863;
            int i12 = this.f7761h1;
            int i13 = this.f7760h0;
            this.f7761h1 = i12 + (i13 >>> 26);
            this.f7760h0 = i13 & 67108863;
            int i14 = this.f7760h0;
            int i15 = i14 + 5;
            int i16 = this.f7761h1;
            int i17 = (i15 >>> 26) + i16;
            int i18 = this.f7762h2;
            int i19 = (i17 >>> 26) + i18;
            int i20 = this.f7763h3;
            int i21 = (i19 >>> 26) + i20;
            int i22 = i21 >>> 26;
            int i23 = 67108863 & i21;
            int i24 = this.f7764h4;
            int i25 = (i22 + i24) - 67108864;
            int i26 = (i25 >>> 31) - 1;
            int i27 = ~i26;
            this.f7760h0 = (i14 & i27) | (i15 & 67108863 & i26);
            this.f7761h1 = (i16 & i27) | (i17 & 67108863 & i26);
            this.f7762h2 = (i18 & i27) | (i19 & 67108863 & i26);
            this.f7763h3 = (i23 & i26) | (i20 & i27);
            this.f7764h4 = (i24 & i27) | (i25 & i26);
            int i28 = this.f7760h0;
            int i29 = this.f7761h1;
            long j = (((long) (i28 | (i29 << 26))) & BodyPartID.bodyIdMax) + (((long) this.f7765k0) & BodyPartID.bodyIdMax);
            int i30 = i29 >>> 6;
            int i31 = this.f7762h2;
            long j2 = (((long) (i30 | (i31 << 20))) & BodyPartID.bodyIdMax) + (((long) this.f7766k1) & BodyPartID.bodyIdMax);
            int i32 = i31 >>> 12;
            int i33 = this.f7763h3;
            long j3 = (((long) (i32 | (i33 << 14))) & BodyPartID.bodyIdMax) + (((long) this.f7767k2) & BodyPartID.bodyIdMax);
            long j4 = (((long) ((i33 >>> 18) | (this.f7764h4 << 8))) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) this.f7768k3));
            Pack.intToLittleEndian((int) j, bArr, i);
            long j5 = j2 + (j >>> 32);
            Pack.intToLittleEndian((int) j5, bArr, i + 4);
            long j6 = j3 + (j5 >>> 32);
            Pack.intToLittleEndian((int) j6, bArr, i + 8);
            Pack.intToLittleEndian((int) (j4 + (j6 >>> 32)), bArr, i + 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    public int getMacSize() {
        return 16;
    }

    public void init(CipherParameters cipherParameters) {
        byte[] bArr;
        if (this.cipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey(), bArr);
            reset();
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    public void reset() {
        this.currentBlockOffset = 0;
        this.f7764h4 = 0;
        this.f7763h3 = 0;
        this.f7762h2 = 0;
        this.f7761h1 = 0;
        this.f7760h0 = 0;
    }

    public void update(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        update(bArr, 0, 1);
    }

    public void update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i2 > i3) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int min = Math.min(i2 - i3, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i3 + i, this.currentBlock, this.currentBlockOffset, min);
            i3 += min;
            this.currentBlockOffset += min;
        }
    }
}

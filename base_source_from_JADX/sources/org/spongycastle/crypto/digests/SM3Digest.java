package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SM3Digest extends GeneralDigest {
    private static final int BLOCK_SIZE = 16;
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: T */
    private static final int[] f7602T = new int[64];

    /* renamed from: V */
    private int[] f7603V = new int[8];

    /* renamed from: W */
    private int[] f7604W = new int[68];

    /* renamed from: W1 */
    private int[] f7605W1 = new int[64];
    private int[] inwords = new int[16];
    private int xOff;

    static {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= 16) {
                break;
            }
            f7602T[i2] = (2043430169 >>> (32 - i2)) | (2043430169 << i2);
            i2++;
        }
        for (i = 16; i < 64; i++) {
            int i3 = i % 32;
            f7602T[i] = (2055708042 >>> (32 - i3)) | (2055708042 << i3);
        }
    }

    public SM3Digest() {
        reset();
    }

    public SM3Digest(SM3Digest sM3Digest) {
        super((GeneralDigest) sM3Digest);
        copyIn(sM3Digest);
    }

    private int FF0(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int FF1(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    private int GG0(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int GG1(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: P0 */
    private int m9189P0(int i) {
        return (i ^ ((i << 9) | (i >>> 23))) ^ ((i << 17) | (i >>> 15));
    }

    /* renamed from: P1 */
    private int m9190P1(int i) {
        return (i ^ ((i << 15) | (i >>> 17))) ^ ((i << 23) | (i >>> 9));
    }

    private void copyIn(SM3Digest sM3Digest) {
        int[] iArr = sM3Digest.f7603V;
        int[] iArr2 = this.f7603V;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = sM3Digest.inwords;
        int[] iArr4 = this.inwords;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        this.xOff = sM3Digest.xOff;
    }

    public Memoable copy() {
        return new SM3Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f7603V[0], bArr, i + 0);
        Pack.intToBigEndian(this.f7603V[1], bArr, i + 4);
        Pack.intToBigEndian(this.f7603V[2], bArr, i + 8);
        Pack.intToBigEndian(this.f7603V[3], bArr, i + 12);
        Pack.intToBigEndian(this.f7603V[4], bArr, i + 16);
        Pack.intToBigEndian(this.f7603V[5], bArr, i + 20);
        Pack.intToBigEndian(this.f7603V[6], bArr, i + 24);
        Pack.intToBigEndian(this.f7603V[7], bArr, i + 28);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "SM3";
    }

    public int getDigestSize() {
        return 32;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i;
        int i2;
        int i3 = 0;
        while (true) {
            i = 16;
            if (i3 >= 16) {
                break;
            }
            this.f7604W[i3] = this.inwords[i3];
            i3++;
        }
        for (int i4 = 16; i4 < 68; i4++) {
            int[] iArr = this.f7604W;
            int i5 = iArr[i4 - 3];
            int i6 = (i5 >>> 17) | (i5 << 15);
            int i7 = iArr[i4 - 13];
            iArr[i4] = (m9190P1(i6 ^ (iArr[i4 - 16] ^ iArr[i4 - 9])) ^ ((i7 >>> 25) | (i7 << 7))) ^ this.f7604W[i4 - 6];
        }
        int i8 = 0;
        while (true) {
            i2 = 64;
            if (i8 >= 64) {
                break;
            }
            int[] iArr2 = this.f7605W1;
            int[] iArr3 = this.f7604W;
            iArr2[i8] = iArr3[i8 + 4] ^ iArr3[i8];
            i8++;
        }
        int[] iArr4 = this.f7603V;
        int i9 = iArr4[0];
        int i10 = iArr4[1];
        int i11 = iArr4[2];
        int i12 = iArr4[3];
        int i13 = iArr4[4];
        int i14 = iArr4[5];
        int i15 = iArr4[6];
        int i16 = iArr4[7];
        int i17 = i15;
        int i18 = 0;
        int i19 = i10;
        int i20 = i9;
        int i21 = i19;
        int i22 = i12;
        int i23 = i11;
        int i24 = i22;
        int i25 = i14;
        int i26 = i13;
        int i27 = i25;
        while (i18 < i) {
            int i28 = (i20 << 12) | (i20 >>> 20);
            int i29 = i28 + i26 + f7602T[i18];
            int i30 = (i29 << 7) | (i29 >>> 25);
            int FF0 = FF0(i20, i21, i23) + i24;
            i18++;
            i16 = i17;
            i17 = (i27 << 19) | (i27 >>> 13);
            i27 = i26;
            i26 = m9189P0(GG0(i26, i27, i17) + i16 + i30 + this.f7604W[i18]);
            i = 16;
            int i31 = i23;
            i23 = (i21 << 9) | (i21 >>> 23);
            i21 = i20;
            i20 = FF0 + (i30 ^ i28) + this.f7605W1[i18];
            i24 = i31;
        }
        int i32 = i21;
        int i33 = i20;
        int i34 = i24;
        int i35 = i23;
        int i36 = i27;
        int i37 = i26;
        int i38 = 16;
        while (i38 < i2) {
            int i39 = (i33 << 12) | (i33 >>> 20);
            int i40 = i39 + i37 + f7602T[i38];
            int i41 = (i40 << 7) | (i40 >>> 25);
            int FF1 = FF1(i33, i32, i35) + i34;
            int GG1 = GG1(i37, i36, i17) + i16 + i41 + this.f7604W[i38];
            int i42 = (i32 >>> 23) | (i32 << 9);
            i38++;
            i16 = i17;
            i17 = (i36 << 19) | (i36 >>> 13);
            i2 = 64;
            int i43 = i35;
            i35 = i42;
            i32 = i33;
            i33 = FF1 + (i41 ^ i39) + this.f7605W1[i38];
            i34 = i43;
            int i44 = i37;
            i37 = m9189P0(GG1);
            i36 = i44;
        }
        int[] iArr5 = this.f7603V;
        iArr5[0] = iArr5[0] ^ i33;
        iArr5[1] = i32 ^ iArr5[1];
        iArr5[2] = iArr5[2] ^ i35;
        iArr5[3] = iArr5[3] ^ i34;
        iArr5[4] = iArr5[4] ^ i37;
        iArr5[5] = iArr5[5] ^ i36;
        iArr5[6] = iArr5[6] ^ i17;
        iArr5[7] = iArr5[7] ^ i16;
        this.xOff = 0;
    }

    /* access modifiers changed from: protected */
    public void processLength(long j) {
        int i = this.xOff;
        if (i > 14) {
            this.inwords[i] = 0;
            this.xOff = i + 1;
            processBlock();
        }
        while (true) {
            int i2 = this.xOff;
            if (i2 < 14) {
                this.inwords[i2] = 0;
                this.xOff = i2 + 1;
            } else {
                int[] iArr = this.inwords;
                this.xOff = i2 + 1;
                iArr[i2] = (int) (j >>> 32);
                int i3 = this.xOff;
                this.xOff = i3 + 1;
                iArr[i3] = (int) j;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i2] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.inwords;
        int i5 = this.xOff;
        iArr[i5] = i4;
        this.xOff = i5 + 1;
        if (this.xOff >= 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        int[] iArr = this.f7603V;
        iArr[0] = 1937774191;
        iArr[1] = 1226093241;
        iArr[2] = 388252375;
        iArr[3] = -628488704;
        iArr[4] = -1452330820;
        iArr[5] = 372324522;
        iArr[6] = -477237683;
        iArr[7] = -1325724082;
        this.xOff = 0;
    }

    public void reset(Memoable memoable) {
        SM3Digest sM3Digest = (SM3Digest) memoable;
        super.copyIn(sM3Digest);
        copyIn(sM3Digest);
    }
}

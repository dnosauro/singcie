package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

public class MD4Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 16;
    private static final int S11 = 3;
    private static final int S12 = 7;
    private static final int S13 = 11;
    private static final int S14 = 19;
    private static final int S21 = 3;
    private static final int S22 = 5;
    private static final int S23 = 9;
    private static final int S24 = 13;
    private static final int S31 = 3;
    private static final int S32 = 9;
    private static final int S33 = 11;
    private static final int S34 = 15;

    /* renamed from: H1 */
    private int f7531H1;

    /* renamed from: H2 */
    private int f7532H2;

    /* renamed from: H3 */
    private int f7533H3;

    /* renamed from: H4 */
    private int f7534H4;

    /* renamed from: X */
    private int[] f7535X = new int[16];
    private int xOff;

    public MD4Digest() {
        reset();
    }

    public MD4Digest(MD4Digest mD4Digest) {
        super((GeneralDigest) mD4Digest);
        copyIn(mD4Digest);
    }

    /* renamed from: F */
    private int m9147F(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: G */
    private int m9148G(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    /* renamed from: H */
    private int m9149H(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private void copyIn(MD4Digest mD4Digest) {
        super.copyIn(mD4Digest);
        this.f7531H1 = mD4Digest.f7531H1;
        this.f7532H2 = mD4Digest.f7532H2;
        this.f7533H3 = mD4Digest.f7533H3;
        this.f7534H4 = mD4Digest.f7534H4;
        int[] iArr = mD4Digest.f7535X;
        System.arraycopy(iArr, 0, this.f7535X, 0, iArr.length);
        this.xOff = mD4Digest.xOff;
    }

    private int rotateLeft(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public Memoable copy() {
        return new MD4Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.f7531H1, bArr, i);
        unpackWord(this.f7532H2, bArr, i + 4);
        unpackWord(this.f7533H3, bArr, i + 8);
        unpackWord(this.f7534H4, bArr, i + 12);
        reset();
        return 16;
    }

    public String getAlgorithmName() {
        return "MD4";
    }

    public int getDigestSize() {
        return 16;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i = this.f7531H1;
        int i2 = this.f7532H2;
        int i3 = this.f7533H3;
        int i4 = this.f7534H4;
        int rotateLeft = rotateLeft(i + m9147F(i2, i3, i4) + this.f7535X[0], 3);
        int rotateLeft2 = rotateLeft(i4 + m9147F(rotateLeft, i2, i3) + this.f7535X[1], 7);
        int rotateLeft3 = rotateLeft(i3 + m9147F(rotateLeft2, rotateLeft, i2) + this.f7535X[2], 11);
        int rotateLeft4 = rotateLeft(i2 + m9147F(rotateLeft3, rotateLeft2, rotateLeft) + this.f7535X[3], 19);
        int rotateLeft5 = rotateLeft(rotateLeft + m9147F(rotateLeft4, rotateLeft3, rotateLeft2) + this.f7535X[4], 3);
        int rotateLeft6 = rotateLeft(rotateLeft2 + m9147F(rotateLeft5, rotateLeft4, rotateLeft3) + this.f7535X[5], 7);
        int rotateLeft7 = rotateLeft(rotateLeft3 + m9147F(rotateLeft6, rotateLeft5, rotateLeft4) + this.f7535X[6], 11);
        int rotateLeft8 = rotateLeft(rotateLeft4 + m9147F(rotateLeft7, rotateLeft6, rotateLeft5) + this.f7535X[7], 19);
        int rotateLeft9 = rotateLeft(rotateLeft5 + m9147F(rotateLeft8, rotateLeft7, rotateLeft6) + this.f7535X[8], 3);
        int rotateLeft10 = rotateLeft(rotateLeft6 + m9147F(rotateLeft9, rotateLeft8, rotateLeft7) + this.f7535X[9], 7);
        int rotateLeft11 = rotateLeft(rotateLeft7 + m9147F(rotateLeft10, rotateLeft9, rotateLeft8) + this.f7535X[10], 11);
        int rotateLeft12 = rotateLeft(rotateLeft8 + m9147F(rotateLeft11, rotateLeft10, rotateLeft9) + this.f7535X[11], 19);
        int rotateLeft13 = rotateLeft(rotateLeft9 + m9147F(rotateLeft12, rotateLeft11, rotateLeft10) + this.f7535X[12], 3);
        int rotateLeft14 = rotateLeft(rotateLeft10 + m9147F(rotateLeft13, rotateLeft12, rotateLeft11) + this.f7535X[13], 7);
        int rotateLeft15 = rotateLeft(rotateLeft11 + m9147F(rotateLeft14, rotateLeft13, rotateLeft12) + this.f7535X[14], 11);
        int rotateLeft16 = rotateLeft(rotateLeft12 + m9147F(rotateLeft15, rotateLeft14, rotateLeft13) + this.f7535X[15], 19);
        int rotateLeft17 = rotateLeft(rotateLeft13 + m9148G(rotateLeft16, rotateLeft15, rotateLeft14) + this.f7535X[0] + 1518500249, 3);
        int rotateLeft18 = rotateLeft(rotateLeft14 + m9148G(rotateLeft17, rotateLeft16, rotateLeft15) + this.f7535X[4] + 1518500249, 5);
        int rotateLeft19 = rotateLeft(rotateLeft15 + m9148G(rotateLeft18, rotateLeft17, rotateLeft16) + this.f7535X[8] + 1518500249, 9);
        int rotateLeft20 = rotateLeft(rotateLeft16 + m9148G(rotateLeft19, rotateLeft18, rotateLeft17) + this.f7535X[12] + 1518500249, 13);
        int rotateLeft21 = rotateLeft(rotateLeft17 + m9148G(rotateLeft20, rotateLeft19, rotateLeft18) + this.f7535X[1] + 1518500249, 3);
        int rotateLeft22 = rotateLeft(rotateLeft18 + m9148G(rotateLeft21, rotateLeft20, rotateLeft19) + this.f7535X[5] + 1518500249, 5);
        int rotateLeft23 = rotateLeft(rotateLeft19 + m9148G(rotateLeft22, rotateLeft21, rotateLeft20) + this.f7535X[9] + 1518500249, 9);
        int rotateLeft24 = rotateLeft(rotateLeft20 + m9148G(rotateLeft23, rotateLeft22, rotateLeft21) + this.f7535X[13] + 1518500249, 13);
        int rotateLeft25 = rotateLeft(rotateLeft21 + m9148G(rotateLeft24, rotateLeft23, rotateLeft22) + this.f7535X[2] + 1518500249, 3);
        int rotateLeft26 = rotateLeft(rotateLeft22 + m9148G(rotateLeft25, rotateLeft24, rotateLeft23) + this.f7535X[6] + 1518500249, 5);
        int rotateLeft27 = rotateLeft(rotateLeft23 + m9148G(rotateLeft26, rotateLeft25, rotateLeft24) + this.f7535X[10] + 1518500249, 9);
        int rotateLeft28 = rotateLeft(rotateLeft24 + m9148G(rotateLeft27, rotateLeft26, rotateLeft25) + this.f7535X[14] + 1518500249, 13);
        int rotateLeft29 = rotateLeft(rotateLeft25 + m9148G(rotateLeft28, rotateLeft27, rotateLeft26) + this.f7535X[3] + 1518500249, 3);
        int rotateLeft30 = rotateLeft(rotateLeft26 + m9148G(rotateLeft29, rotateLeft28, rotateLeft27) + this.f7535X[7] + 1518500249, 5);
        int rotateLeft31 = rotateLeft(rotateLeft27 + m9148G(rotateLeft30, rotateLeft29, rotateLeft28) + this.f7535X[11] + 1518500249, 9);
        int rotateLeft32 = rotateLeft(rotateLeft28 + m9148G(rotateLeft31, rotateLeft30, rotateLeft29) + this.f7535X[15] + 1518500249, 13);
        int rotateLeft33 = rotateLeft(rotateLeft29 + m9149H(rotateLeft32, rotateLeft31, rotateLeft30) + this.f7535X[0] + 1859775393, 3);
        int rotateLeft34 = rotateLeft(rotateLeft30 + m9149H(rotateLeft33, rotateLeft32, rotateLeft31) + this.f7535X[8] + 1859775393, 9);
        int rotateLeft35 = rotateLeft(rotateLeft31 + m9149H(rotateLeft34, rotateLeft33, rotateLeft32) + this.f7535X[4] + 1859775393, 11);
        int rotateLeft36 = rotateLeft(rotateLeft32 + m9149H(rotateLeft35, rotateLeft34, rotateLeft33) + this.f7535X[12] + 1859775393, 15);
        int rotateLeft37 = rotateLeft(rotateLeft33 + m9149H(rotateLeft36, rotateLeft35, rotateLeft34) + this.f7535X[2] + 1859775393, 3);
        int rotateLeft38 = rotateLeft(rotateLeft34 + m9149H(rotateLeft37, rotateLeft36, rotateLeft35) + this.f7535X[10] + 1859775393, 9);
        int rotateLeft39 = rotateLeft(rotateLeft35 + m9149H(rotateLeft38, rotateLeft37, rotateLeft36) + this.f7535X[6] + 1859775393, 11);
        int rotateLeft40 = rotateLeft(rotateLeft36 + m9149H(rotateLeft39, rotateLeft38, rotateLeft37) + this.f7535X[14] + 1859775393, 15);
        int rotateLeft41 = rotateLeft(rotateLeft37 + m9149H(rotateLeft40, rotateLeft39, rotateLeft38) + this.f7535X[1] + 1859775393, 3);
        int rotateLeft42 = rotateLeft(rotateLeft38 + m9149H(rotateLeft41, rotateLeft40, rotateLeft39) + this.f7535X[9] + 1859775393, 9);
        int rotateLeft43 = rotateLeft(rotateLeft39 + m9149H(rotateLeft42, rotateLeft41, rotateLeft40) + this.f7535X[5] + 1859775393, 11);
        int rotateLeft44 = rotateLeft(rotateLeft40 + m9149H(rotateLeft43, rotateLeft42, rotateLeft41) + this.f7535X[13] + 1859775393, 15);
        int rotateLeft45 = rotateLeft(rotateLeft41 + m9149H(rotateLeft44, rotateLeft43, rotateLeft42) + this.f7535X[3] + 1859775393, 3);
        int rotateLeft46 = rotateLeft(rotateLeft42 + m9149H(rotateLeft45, rotateLeft44, rotateLeft43) + this.f7535X[11] + 1859775393, 9);
        int rotateLeft47 = rotateLeft(rotateLeft43 + m9149H(rotateLeft46, rotateLeft45, rotateLeft44) + this.f7535X[7] + 1859775393, 11);
        int rotateLeft48 = rotateLeft(rotateLeft44 + m9149H(rotateLeft47, rotateLeft46, rotateLeft45) + this.f7535X[15] + 1859775393, 15);
        this.f7531H1 += rotateLeft45;
        this.f7532H2 += rotateLeft48;
        this.f7533H3 += rotateLeft47;
        this.f7534H4 += rotateLeft46;
        this.xOff = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f7535X;
            if (i5 != iArr.length) {
                iArr[i5] = 0;
                i5++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f7535X;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f7535X;
        int i2 = this.xOff;
        this.xOff = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Tnaf.POW_2_WIDTH);
        if (this.xOff == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.f7531H1 = 1732584193;
        this.f7532H2 = -271733879;
        this.f7533H3 = -1732584194;
        this.f7534H4 = 271733878;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f7535X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        copyIn((MD4Digest) memoable);
    }
}

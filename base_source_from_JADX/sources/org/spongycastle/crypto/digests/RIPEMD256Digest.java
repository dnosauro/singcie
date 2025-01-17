package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

public class RIPEMD256Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: H0 */
    private int f7552H0;

    /* renamed from: H1 */
    private int f7553H1;

    /* renamed from: H2 */
    private int f7554H2;

    /* renamed from: H3 */
    private int f7555H3;

    /* renamed from: H4 */
    private int f7556H4;

    /* renamed from: H5 */
    private int f7557H5;

    /* renamed from: H6 */
    private int f7558H6;

    /* renamed from: H7 */
    private int f7559H7;

    /* renamed from: X */
    private int[] f7560X = new int[16];
    private int xOff;

    public RIPEMD256Digest() {
        reset();
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super((GeneralDigest) rIPEMD256Digest);
        copyIn(rIPEMD256Digest);
    }

    /* renamed from: F1 */
    private int m9169F1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(i + m9174f1(i2, i3, i4) + i5, i6);
    }

    /* renamed from: F2 */
    private int m9170F2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(i + m9175f2(i2, i3, i4) + i5 + 1518500249, i6);
    }

    /* renamed from: F3 */
    private int m9171F3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(i + m9176f3(i2, i3, i4) + i5 + 1859775393, i6);
    }

    /* renamed from: F4 */
    private int m9172F4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(((i + m9177f4(i2, i3, i4)) + i5) - 1894007588, i6);
    }

    private int FF1(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(i + m9174f1(i2, i3, i4) + i5, i6);
    }

    private int FF2(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(i + m9175f2(i2, i3, i4) + i5 + 1836072691, i6);
    }

    private int FF3(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(i + m9176f3(i2, i3, i4) + i5 + 1548603684, i6);
    }

    private int FF4(int i, int i2, int i3, int i4, int i5, int i6) {
        return m9173RL(i + m9177f4(i2, i3, i4) + i5 + 1352829926, i6);
    }

    /* renamed from: RL */
    private int m9173RL(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private void copyIn(RIPEMD256Digest rIPEMD256Digest) {
        super.copyIn(rIPEMD256Digest);
        this.f7552H0 = rIPEMD256Digest.f7552H0;
        this.f7553H1 = rIPEMD256Digest.f7553H1;
        this.f7554H2 = rIPEMD256Digest.f7554H2;
        this.f7555H3 = rIPEMD256Digest.f7555H3;
        this.f7556H4 = rIPEMD256Digest.f7556H4;
        this.f7557H5 = rIPEMD256Digest.f7557H5;
        this.f7558H6 = rIPEMD256Digest.f7558H6;
        this.f7559H7 = rIPEMD256Digest.f7559H7;
        int[] iArr = rIPEMD256Digest.f7560X;
        System.arraycopy(iArr, 0, this.f7560X, 0, iArr.length);
        this.xOff = rIPEMD256Digest.xOff;
    }

    /* renamed from: f1 */
    private int m9174f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m9175f2(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: f3 */
    private int m9176f3(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: f4 */
    private int m9177f4(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public Memoable copy() {
        return new RIPEMD256Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.f7552H0, bArr, i);
        unpackWord(this.f7553H1, bArr, i + 4);
        unpackWord(this.f7554H2, bArr, i + 8);
        unpackWord(this.f7555H3, bArr, i + 12);
        unpackWord(this.f7556H4, bArr, i + 16);
        unpackWord(this.f7557H5, bArr, i + 20);
        unpackWord(this.f7558H6, bArr, i + 24);
        unpackWord(this.f7559H7, bArr, i + 28);
        reset();
        return 32;
    }

    public String getAlgorithmName() {
        return "RIPEMD256";
    }

    public int getDigestSize() {
        return 32;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i = this.f7552H0;
        int i2 = this.f7553H1;
        int i3 = this.f7554H2;
        int i4 = this.f7555H3;
        int i5 = this.f7556H4;
        int i6 = this.f7557H5;
        int i7 = this.f7558H6;
        int i8 = this.f7559H7;
        int F1 = m9169F1(i, i2, i3, i4, this.f7560X[0], 11);
        int F12 = m9169F1(i4, F1, i2, i3, this.f7560X[1], 14);
        int F13 = m9169F1(i3, F12, F1, i2, this.f7560X[2], 15);
        int F14 = m9169F1(i2, F13, F12, F1, this.f7560X[3], 12);
        int F15 = m9169F1(F1, F14, F13, F12, this.f7560X[4], 5);
        int F16 = m9169F1(F12, F15, F14, F13, this.f7560X[5], 8);
        int F17 = m9169F1(F13, F16, F15, F14, this.f7560X[6], 7);
        int F18 = m9169F1(F14, F17, F16, F15, this.f7560X[7], 9);
        int F19 = m9169F1(F15, F18, F17, F16, this.f7560X[8], 11);
        int F110 = m9169F1(F16, F19, F18, F17, this.f7560X[9], 13);
        int F111 = m9169F1(F17, F110, F19, F18, this.f7560X[10], 14);
        int F112 = m9169F1(F18, F111, F110, F19, this.f7560X[11], 15);
        int F113 = m9169F1(F19, F112, F111, F110, this.f7560X[12], 6);
        int F114 = m9169F1(F110, F113, F112, F111, this.f7560X[13], 7);
        int F115 = m9169F1(F111, F114, F113, F112, this.f7560X[14], 9);
        int F116 = m9169F1(F112, F115, F114, F113, this.f7560X[15], 8);
        int FF4 = FF4(i5, i6, i7, i8, this.f7560X[5], 8);
        int FF42 = FF4(i8, FF4, i6, i7, this.f7560X[14], 9);
        int FF43 = FF4(i7, FF42, FF4, i6, this.f7560X[7], 9);
        int FF44 = FF4(i6, FF43, FF42, FF4, this.f7560X[0], 11);
        int FF45 = FF4(FF4, FF44, FF43, FF42, this.f7560X[9], 13);
        int FF46 = FF4(FF42, FF45, FF44, FF43, this.f7560X[2], 15);
        int FF47 = FF4(FF43, FF46, FF45, FF44, this.f7560X[11], 15);
        int FF48 = FF4(FF44, FF47, FF46, FF45, this.f7560X[4], 5);
        int FF49 = FF4(FF45, FF48, FF47, FF46, this.f7560X[13], 7);
        int FF410 = FF4(FF46, FF49, FF48, FF47, this.f7560X[6], 7);
        int FF411 = FF4(FF47, FF410, FF49, FF48, this.f7560X[15], 8);
        int FF412 = FF4(FF48, FF411, FF410, FF49, this.f7560X[8], 11);
        int FF413 = FF4(FF49, FF412, FF411, FF410, this.f7560X[1], 14);
        int FF414 = FF4(FF410, FF413, FF412, FF411, this.f7560X[10], 14);
        int FF415 = FF4(FF411, FF414, FF413, FF412, this.f7560X[3], 12);
        int FF416 = FF4(FF412, FF415, FF414, FF413, this.f7560X[12], 6);
        int F2 = m9170F2(FF413, F116, F115, F114, this.f7560X[7], 7);
        int F22 = m9170F2(F114, F2, F116, F115, this.f7560X[4], 6);
        int F23 = m9170F2(F115, F22, F2, F116, this.f7560X[13], 8);
        int F24 = m9170F2(F116, F23, F22, F2, this.f7560X[1], 13);
        int F25 = m9170F2(F2, F24, F23, F22, this.f7560X[10], 11);
        int F26 = m9170F2(F22, F25, F24, F23, this.f7560X[6], 9);
        int F27 = m9170F2(F23, F26, F25, F24, this.f7560X[15], 7);
        int F28 = m9170F2(F24, F27, F26, F25, this.f7560X[3], 15);
        int F29 = m9170F2(F25, F28, F27, F26, this.f7560X[12], 7);
        int F210 = m9170F2(F26, F29, F28, F27, this.f7560X[0], 12);
        int F211 = m9170F2(F27, F210, F29, F28, this.f7560X[9], 15);
        int F212 = m9170F2(F28, F211, F210, F29, this.f7560X[5], 9);
        int F213 = m9170F2(F29, F212, F211, F210, this.f7560X[2], 11);
        int F214 = m9170F2(F210, F213, F212, F211, this.f7560X[14], 7);
        int F215 = m9170F2(F211, F214, F213, F212, this.f7560X[11], 13);
        int F216 = m9170F2(F212, F215, F214, F213, this.f7560X[8], 12);
        int FF3 = FF3(F113, FF416, FF415, FF414, this.f7560X[6], 9);
        int FF32 = FF3(FF414, FF3, FF416, FF415, this.f7560X[11], 13);
        int FF33 = FF3(FF415, FF32, FF3, FF416, this.f7560X[3], 15);
        int FF34 = FF3(FF416, FF33, FF32, FF3, this.f7560X[7], 7);
        int FF35 = FF3(FF3, FF34, FF33, FF32, this.f7560X[0], 12);
        int FF36 = FF3(FF32, FF35, FF34, FF33, this.f7560X[13], 8);
        int FF37 = FF3(FF33, FF36, FF35, FF34, this.f7560X[5], 9);
        int FF38 = FF3(FF34, FF37, FF36, FF35, this.f7560X[10], 11);
        int FF39 = FF3(FF35, FF38, FF37, FF36, this.f7560X[14], 7);
        int FF310 = FF3(FF36, FF39, FF38, FF37, this.f7560X[15], 7);
        int FF311 = FF3(FF37, FF310, FF39, FF38, this.f7560X[8], 12);
        int FF312 = FF3(FF38, FF311, FF310, FF39, this.f7560X[12], 7);
        int FF313 = FF3(FF39, FF312, FF311, FF310, this.f7560X[4], 6);
        int FF314 = FF3(FF310, FF313, FF312, FF311, this.f7560X[9], 15);
        int FF315 = FF3(FF311, FF314, FF313, FF312, this.f7560X[1], 13);
        int FF316 = FF3(FF312, FF315, FF314, FF313, this.f7560X[2], 11);
        int F3 = m9171F3(F213, FF316, F215, F214, this.f7560X[3], 11);
        int F32 = m9171F3(F214, F3, FF316, F215, this.f7560X[10], 13);
        int F33 = m9171F3(F215, F32, F3, FF316, this.f7560X[14], 6);
        int F34 = m9171F3(FF316, F33, F32, F3, this.f7560X[4], 7);
        int F35 = m9171F3(F3, F34, F33, F32, this.f7560X[9], 14);
        int F36 = m9171F3(F32, F35, F34, F33, this.f7560X[15], 9);
        int F37 = m9171F3(F33, F36, F35, F34, this.f7560X[8], 13);
        int F38 = m9171F3(F34, F37, F36, F35, this.f7560X[1], 15);
        int F39 = m9171F3(F35, F38, F37, F36, this.f7560X[2], 14);
        int F310 = m9171F3(F36, F39, F38, F37, this.f7560X[7], 8);
        int F311 = m9171F3(F37, F310, F39, F38, this.f7560X[0], 13);
        int F312 = m9171F3(F38, F311, F310, F39, this.f7560X[6], 6);
        int F313 = m9171F3(F39, F312, F311, F310, this.f7560X[13], 5);
        int F314 = m9171F3(F310, F313, F312, F311, this.f7560X[11], 12);
        int F315 = m9171F3(F311, F314, F313, F312, this.f7560X[5], 7);
        int F316 = m9171F3(F312, F315, F314, F313, this.f7560X[12], 5);
        int FF2 = FF2(FF313, F216, FF315, FF314, this.f7560X[15], 9);
        int FF22 = FF2(FF314, FF2, F216, FF315, this.f7560X[5], 7);
        int FF23 = FF2(FF315, FF22, FF2, F216, this.f7560X[1], 15);
        int FF24 = FF2(F216, FF23, FF22, FF2, this.f7560X[3], 11);
        int FF25 = FF2(FF2, FF24, FF23, FF22, this.f7560X[7], 8);
        int FF26 = FF2(FF22, FF25, FF24, FF23, this.f7560X[14], 6);
        int FF27 = FF2(FF23, FF26, FF25, FF24, this.f7560X[6], 6);
        int FF28 = FF2(FF24, FF27, FF26, FF25, this.f7560X[9], 14);
        int FF29 = FF2(FF25, FF28, FF27, FF26, this.f7560X[11], 12);
        int FF210 = FF2(FF26, FF29, FF28, FF27, this.f7560X[8], 13);
        int FF211 = FF2(FF27, FF210, FF29, FF28, this.f7560X[12], 5);
        int FF212 = FF2(FF28, FF211, FF210, FF29, this.f7560X[2], 14);
        int FF213 = FF2(FF29, FF212, FF211, FF210, this.f7560X[10], 13);
        int FF214 = FF2(FF210, FF213, FF212, FF211, this.f7560X[0], 13);
        int FF215 = FF2(FF211, FF214, FF213, FF212, this.f7560X[4], 7);
        int FF216 = FF2(FF212, FF215, FF214, FF213, this.f7560X[13], 5);
        int F4 = m9172F4(F313, F316, FF215, F314, this.f7560X[1], 11);
        int F42 = m9172F4(F314, F4, F316, FF215, this.f7560X[9], 12);
        int F43 = m9172F4(FF215, F42, F4, F316, this.f7560X[11], 14);
        int F44 = m9172F4(F316, F43, F42, F4, this.f7560X[10], 15);
        int F45 = m9172F4(F4, F44, F43, F42, this.f7560X[0], 14);
        int F46 = m9172F4(F42, F45, F44, F43, this.f7560X[8], 15);
        int F47 = m9172F4(F43, F46, F45, F44, this.f7560X[12], 9);
        int F48 = m9172F4(F44, F47, F46, F45, this.f7560X[4], 8);
        int F49 = m9172F4(F45, F48, F47, F46, this.f7560X[13], 9);
        int F410 = m9172F4(F46, F49, F48, F47, this.f7560X[3], 14);
        int F411 = m9172F4(F47, F410, F49, F48, this.f7560X[7], 5);
        int F412 = m9172F4(F48, F411, F410, F49, this.f7560X[15], 6);
        int F413 = m9172F4(F49, F412, F411, F410, this.f7560X[14], 8);
        int F414 = m9172F4(F410, F413, F412, F411, this.f7560X[5], 6);
        int F415 = m9172F4(F411, F414, F413, F412, this.f7560X[6], 5);
        int F416 = m9172F4(F412, F415, F414, F413, this.f7560X[2], 12);
        int FF1 = FF1(FF213, FF216, F315, FF214, this.f7560X[8], 15);
        int FF12 = FF1(FF214, FF1, FF216, F315, this.f7560X[6], 5);
        int FF13 = FF1(F315, FF12, FF1, FF216, this.f7560X[4], 8);
        int FF14 = FF1(FF216, FF13, FF12, FF1, this.f7560X[1], 11);
        int FF15 = FF1(FF1, FF14, FF13, FF12, this.f7560X[3], 14);
        int FF16 = FF1(FF12, FF15, FF14, FF13, this.f7560X[11], 14);
        int FF17 = FF1(FF13, FF16, FF15, FF14, this.f7560X[15], 6);
        int FF18 = FF1(FF14, FF17, FF16, FF15, this.f7560X[0], 14);
        int FF19 = FF1(FF15, FF18, FF17, FF16, this.f7560X[5], 6);
        int FF110 = FF1(FF16, FF19, FF18, FF17, this.f7560X[12], 9);
        int FF111 = FF1(FF17, FF110, FF19, FF18, this.f7560X[2], 12);
        int FF112 = FF1(FF18, FF111, FF110, FF19, this.f7560X[13], 9);
        int FF113 = FF1(FF19, FF112, FF111, FF110, this.f7560X[9], 12);
        int FF114 = FF1(FF110, FF113, FF112, FF111, this.f7560X[7], 5);
        int FF115 = FF1(FF111, FF114, FF113, FF112, this.f7560X[10], 15);
        int FF116 = FF1(FF112, FF115, FF114, FF113, this.f7560X[14], 8);
        this.f7552H0 += F413;
        this.f7553H1 += F416;
        this.f7554H2 += F415;
        this.f7555H3 += FF114;
        this.f7556H4 += FF113;
        this.f7557H5 += FF116;
        this.f7558H6 += FF115;
        this.f7559H7 += F414;
        this.xOff = 0;
        int i9 = 0;
        while (true) {
            int[] iArr = this.f7560X;
            if (i9 != iArr.length) {
                iArr[i9] = 0;
                i9++;
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
        int[] iArr = this.f7560X;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f7560X;
        int i2 = this.xOff;
        this.xOff = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Tnaf.POW_2_WIDTH);
        if (this.xOff == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.f7552H0 = 1732584193;
        this.f7553H1 = -271733879;
        this.f7554H2 = -1732584194;
        this.f7555H3 = 271733878;
        this.f7556H4 = 1985229328;
        this.f7557H5 = -19088744;
        this.f7558H6 = -1985229329;
        this.f7559H7 = 19088743;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f7560X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        copyIn((RIPEMD256Digest) memoable);
    }
}

package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public abstract class LongDigest implements ExtendedDigest, EncodableDigest, Memoable {
    private static final int BYTE_LENGTH = 128;

    /* renamed from: K */
    static final long[] f7517K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* renamed from: H1 */
    protected long f7518H1;

    /* renamed from: H2 */
    protected long f7519H2;

    /* renamed from: H3 */
    protected long f7520H3;

    /* renamed from: H4 */
    protected long f7521H4;

    /* renamed from: H5 */
    protected long f7522H5;

    /* renamed from: H6 */
    protected long f7523H6;

    /* renamed from: H7 */
    protected long f7524H7;

    /* renamed from: H8 */
    protected long f7525H8;

    /* renamed from: W */
    private long[] f7526W;
    private long byteCount1;
    private long byteCount2;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    protected LongDigest() {
        this.xBuf = new byte[8];
        this.f7526W = new long[80];
        this.xBufOff = 0;
        reset();
    }

    protected LongDigest(LongDigest longDigest) {
        this.xBuf = new byte[8];
        this.f7526W = new long[80];
        copyIn(longDigest);
    }

    /* renamed from: Ch */
    private long m9146Ch(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    private long Maj(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    private long Sigma0(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    private long Sigma1(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    private long Sum0(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    private long Sum1(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    private void adjustByteCounts() {
        long j = this.byteCount1;
        if (j > 2305843009213693951L) {
            this.byteCount2 += j >>> 61;
            this.byteCount1 = j & 2305843009213693951L;
        }
    }

    /* access modifiers changed from: protected */
    public void copyIn(LongDigest longDigest) {
        byte[] bArr = longDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = longDigest.xBufOff;
        this.byteCount1 = longDigest.byteCount1;
        this.byteCount2 = longDigest.byteCount2;
        this.f7518H1 = longDigest.f7518H1;
        this.f7519H2 = longDigest.f7519H2;
        this.f7520H3 = longDigest.f7520H3;
        this.f7521H4 = longDigest.f7521H4;
        this.f7522H5 = longDigest.f7522H5;
        this.f7523H6 = longDigest.f7523H6;
        this.f7524H7 = longDigest.f7524H7;
        this.f7525H8 = longDigest.f7525H8;
        long[] jArr = longDigest.f7526W;
        System.arraycopy(jArr, 0, this.f7526W, 0, jArr.length);
        this.wOff = longDigest.wOff;
    }

    public void finish() {
        adjustByteCounts();
        long j = this.byteCount1 << 3;
        long j2 = this.byteCount2;
        byte b = Byte.MIN_VALUE;
        while (true) {
            update(b);
            if (this.xBufOff != 0) {
                b = 0;
            } else {
                processLength(j, j2);
                processBlock();
                return;
            }
        }
    }

    public int getByteLength() {
        return 128;
    }

    /* access modifiers changed from: protected */
    public int getEncodedStateSize() {
        return (this.wOff * 8) + 96;
    }

    /* access modifiers changed from: protected */
    public void populateState(byte[] bArr) {
        System.arraycopy(this.xBuf, 0, bArr, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, bArr, 8);
        Pack.longToBigEndian(this.byteCount1, bArr, 12);
        Pack.longToBigEndian(this.byteCount2, bArr, 20);
        Pack.longToBigEndian(this.f7518H1, bArr, 28);
        Pack.longToBigEndian(this.f7519H2, bArr, 36);
        Pack.longToBigEndian(this.f7520H3, bArr, 44);
        Pack.longToBigEndian(this.f7521H4, bArr, 52);
        Pack.longToBigEndian(this.f7522H5, bArr, 60);
        Pack.longToBigEndian(this.f7523H6, bArr, 68);
        Pack.longToBigEndian(this.f7524H7, bArr, 76);
        Pack.longToBigEndian(this.f7525H8, bArr, 84);
        Pack.intToBigEndian(this.wOff, bArr, 92);
        for (int i = 0; i < this.wOff; i++) {
            Pack.longToBigEndian(this.f7526W[i], bArr, (i * 8) + 96);
        }
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        adjustByteCounts();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.f7526W;
            long Sigma1 = Sigma1(jArr[i - 2]);
            long[] jArr2 = this.f7526W;
            jArr[i] = Sigma1 + jArr2[i - 7] + Sigma0(jArr2[i - 15]) + this.f7526W[i - 16];
        }
        long j = this.f7518H1;
        long j2 = this.f7519H2;
        long j3 = this.f7520H3;
        long j4 = this.f7521H4;
        long j5 = this.f7522H5;
        long j6 = this.f7523H6;
        long j7 = j4;
        long j8 = this.f7524H7;
        long j9 = this.f7525H8;
        long j10 = j8;
        long j11 = j6;
        int i2 = 0;
        int i3 = 0;
        long j12 = j2;
        long j13 = j5;
        long j14 = j;
        long j15 = j7;
        long j16 = j3;
        long j17 = j13;
        while (i2 < 10) {
            long j18 = j17;
            int i4 = i3 + 1;
            long Sum1 = j9 + Sum1(j17) + m9146Ch(j17, j11, j10) + f7517K[i3] + this.f7526W[i3];
            long j19 = j14;
            long j20 = j15 + Sum1;
            long Sum0 = Sum1 + Sum0(j14) + Maj(j14, j12, j16);
            long j21 = j20;
            long j22 = Sum0;
            int i5 = i4 + 1;
            long Sum12 = j10 + Sum1(j20) + m9146Ch(j20, j18, j11) + f7517K[i4] + this.f7526W[i4];
            int i6 = i2;
            long j23 = j22;
            long j24 = j16 + Sum12;
            int i7 = i5 + 1;
            long Sum13 = j11 + Sum1(j24) + m9146Ch(j24, j21, j18) + f7517K[i5] + this.f7526W[i5];
            long j25 = j12 + Sum13;
            long Sum02 = Sum12 + Sum0(j22) + Maj(j22, j19, j12);
            long j26 = Sum02;
            long Sum03 = Sum13 + Sum0(Sum02) + Maj(Sum02, j23, j19);
            long j27 = j25;
            long j28 = Sum03;
            int i8 = i7 + 1;
            long Sum14 = j18 + Sum1(j25) + m9146Ch(j25, j24, j21) + f7517K[i7] + this.f7526W[i7];
            long j29 = j28;
            long j30 = j19 + Sum14;
            long j31 = j30;
            long Sum04 = Sum14 + Sum0(j28) + Maj(j28, j26, j23);
            int i9 = i8 + 1;
            long Sum15 = j21 + Sum1(j30) + m9146Ch(j30, j27, j24) + f7517K[i8] + this.f7526W[i8];
            long j32 = j23 + Sum15;
            long Sum05 = Sum0(Sum04);
            long j33 = Sum04;
            long j34 = j32;
            long Maj = Sum15 + Sum05 + Maj(Sum04, j29, j26);
            int i10 = i9 + 1;
            long Sum16 = j24 + Sum1(j34) + m9146Ch(j34, j31, j27) + f7517K[i9] + this.f7526W[i9];
            long j35 = j26 + Sum16;
            long j36 = Maj;
            long j37 = j35;
            long Sum06 = Sum16 + Sum0(Maj) + Maj(Maj, j33, j29);
            int i11 = i10 + 1;
            long Sum17 = j27 + Sum1(j37) + m9146Ch(j37, j34, j31) + f7517K[i10] + this.f7526W[i10];
            long Sum07 = Sum0(Sum06);
            long j38 = Sum06;
            long j39 = j29 + Sum17;
            long Maj2 = Sum17 + Sum07 + Maj(Sum06, j36, j33);
            long Sum18 = Sum1(j39);
            j11 = j39;
            long j40 = Maj2;
            long Ch = j31 + Sum18 + m9146Ch(j39, j37, j34) + f7517K[i11] + this.f7526W[i11];
            long Sum08 = Ch + Sum0(j40) + Maj(j40, j38, j36);
            j17 = j33 + Ch;
            j15 = j36;
            j16 = j38;
            j9 = j34;
            j10 = j37;
            j14 = Sum08;
            j12 = j40;
            i3 = i11 + 1;
            i2 = i6 + 1;
        }
        this.f7518H1 += j14;
        this.f7519H2 += j12;
        this.f7520H3 += j16;
        this.f7521H4 += j15;
        this.f7522H5 += j17;
        this.f7523H6 += j11;
        this.f7524H7 += j10;
        this.f7525H8 += j9;
        this.wOff = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            this.f7526W[i12] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j, long j2) {
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.f7526W;
        jArr[14] = j2;
        jArr[15] = j;
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        this.f7526W[this.wOff] = Pack.bigEndianToLong(bArr, i);
        int i2 = this.wOff + 1;
        this.wOff = i2;
        if (i2 == 16) {
            processBlock();
        }
    }

    public void reset() {
        this.byteCount1 = 0;
        this.byteCount2 = 0;
        int i = 0;
        this.xBufOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.wOff = 0;
        while (true) {
            long[] jArr = this.f7526W;
            if (i != jArr.length) {
                jArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void restoreState(byte[] bArr) {
        this.xBufOff = Pack.bigEndianToInt(bArr, 8);
        System.arraycopy(bArr, 0, this.xBuf, 0, this.xBufOff);
        this.byteCount1 = Pack.bigEndianToLong(bArr, 12);
        this.byteCount2 = Pack.bigEndianToLong(bArr, 20);
        this.f7518H1 = Pack.bigEndianToLong(bArr, 28);
        this.f7519H2 = Pack.bigEndianToLong(bArr, 36);
        this.f7520H3 = Pack.bigEndianToLong(bArr, 44);
        this.f7521H4 = Pack.bigEndianToLong(bArr, 52);
        this.f7522H5 = Pack.bigEndianToLong(bArr, 60);
        this.f7523H6 = Pack.bigEndianToLong(bArr, 68);
        this.f7524H7 = Pack.bigEndianToLong(bArr, 76);
        this.f7525H8 = Pack.bigEndianToLong(bArr, 84);
        this.wOff = Pack.bigEndianToInt(bArr, 92);
        for (int i = 0; i < this.wOff; i++) {
            this.f7526W[i] = Pack.bigEndianToLong(bArr, (i * 8) + 96);
        }
    }

    public void update(byte b) {
        byte[] bArr = this.xBuf;
        int i = this.xBufOff;
        this.xBufOff = i + 1;
        bArr[i] = b;
        if (this.xBufOff == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.xBufOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.xBuf.length) {
            processWord(bArr, i);
            byte[] bArr2 = this.xBuf;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.byteCount1 += (long) bArr2.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}

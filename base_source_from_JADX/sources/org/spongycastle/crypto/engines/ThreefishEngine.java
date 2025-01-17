package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.TweakableBlockCipherParameters;

public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static final long C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;
    /* access modifiers changed from: private */
    public static int[] MOD17 = null;
    /* access modifiers changed from: private */
    public static int[] MOD3 = null;
    /* access modifiers changed from: private */
    public static int[] MOD5 = null;
    /* access modifiers changed from: private */
    public static int[] MOD9 = new int[80];
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;

    /* renamed from: kw */
    private long[] f7730kw;

    /* renamed from: t */
    private long[] f7731t = new long[5];

    private static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* JADX WARNING: type inference failed for: r75v0, types: [long[]] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void decryptBlock(long[] r74, long[] r75) {
            /*
                r73 = this;
                r0 = r73
                long[] r1 = r0.f7732kw
                long[] r2 = r0.f7733t
                int[] r3 = org.spongycastle.crypto.engines.ThreefishEngine.MOD17
                int[] r4 = org.spongycastle.crypto.engines.ThreefishEngine.MOD3
                int r5 = r1.length
                r6 = 33
                if (r5 != r6) goto L_0x052a
                int r5 = r2.length
                r6 = 5
                if (r5 != r6) goto L_0x0524
                r5 = 0
                r7 = r74[r5]
                r9 = 1
                r10 = r74[r9]
                r12 = 2
                r13 = r74[r12]
                r15 = 3
                r16 = r74[r15]
                r15 = 4
                r18 = r74[r15]
                r20 = r74[r6]
                r22 = 6
                r23 = r74[r22]
                r25 = 7
                r26 = r74[r25]
                r12 = 8
                r28 = r74[r12]
                r5 = 9
                r30 = r74[r5]
                r12 = 10
                r32 = r74[r12]
                r34 = 11
                r35 = r74[r34]
                r12 = 12
                r37 = r74[r12]
                r6 = 13
                r39 = r74[r6]
                r41 = 14
                r42 = r74[r41]
                r44 = 15
                r44 = r74[r44]
                r46 = 19
                r46 = r44
                r44 = r42
                r42 = r39
                r39 = r37
                r37 = r35
                r35 = r32
                r32 = r30
                r30 = r28
                r28 = r26
                r26 = r23
                r23 = r20
                r20 = r18
                r18 = r16
                r16 = r13
                r13 = r10
                r10 = r7
                r7 = 19
            L_0x0072:
                if (r7 < r9) goto L_0x0497
                r8 = r3[r7]
                r48 = r4[r7]
                int r49 = r8 + 1
                r50 = r1[r49]
                long r10 = r10 - r50
                int r50 = r8 + 2
                r51 = r1[r50]
                long r13 = r13 - r51
                int r51 = r8 + 3
                r52 = r1[r51]
                r54 = r13
                long r12 = r16 - r52
                int r14 = r8 + 4
                r16 = r1[r14]
                long r5 = r18 - r16
                int r16 = r8 + 5
                r18 = r1[r16]
                r56 = r10
                long r9 = r20 - r18
                int r11 = r8 + 6
                r18 = r1[r11]
                r58 = r3
                r59 = r4
                long r3 = r23 - r18
                int r17 = r8 + 7
                r18 = r1[r17]
                r74 = r14
                long r14 = r26 - r18
                int r18 = r8 + 8
                r19 = r1[r18]
                r60 = r5
                long r5 = r28 - r19
                int r19 = r8 + 9
                r20 = r1[r19]
                r23 = r5
                long r5 = r30 - r20
                int r20 = r8 + 10
                r26 = r1[r20]
                r62 = r3
                long r3 = r32 - r26
                int r21 = r8 + 11
                r26 = r1[r21]
                r28 = r5
                long r5 = r35 - r26
                int r26 = r8 + 12
                r30 = r1[r26]
                r32 = r5
                long r5 = r37 - r30
                int r27 = r8 + 13
                r30 = r1[r27]
                r64 = r3
                long r3 = r39 - r30
                int r30 = r8 + 14
                r35 = r1[r30]
                int r31 = r48 + 1
                r37 = r2[r31]
                long r35 = r35 + r37
                r37 = r3
                long r3 = r42 - r35
                int r35 = r8 + 15
                r39 = r1[r35]
                int r36 = r48 + 2
                r42 = r2[r36]
                long r39 = r39 + r42
                r66 = r9
                long r9 = r44 - r39
                int r36 = r8 + 16
                r39 = r1[r36]
                r68 = r1
                long r0 = (long) r7
                long r39 = r39 + r0
                r42 = 1
                long r39 = r39 + r42
                r42 = r0
                long r0 = r46 - r39
                r69 = r7
                r70 = r8
                r7 = r56
                r56 = r2
                r2 = 9
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r2, r7)
                long r7 = r7 - r0
                r2 = 48
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r5, r2, r12)
                long r12 = r12 - r5
                r2 = 35
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r3, r2, r14)
                long r14 = r14 - r2
                r4 = 52
                r44 = r2
                r39 = r5
                r2 = r64
                r5 = r66
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r4, r5)
                long r4 = r5 - r2
                r6 = 23
                r46 = r2
                r2 = r54
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r9)
                long r9 = r9 - r2
                r6 = 31
                r54 = r9
                r9 = r62
                r71 = r0
                r0 = r28
                r28 = r71
                long r9 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r0)
                long r0 = r0 - r9
                r6 = 37
                r62 = r0
                r0 = r60
                r71 = r2
                r2 = r32
                r32 = r71
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r2)
                long r2 = r2 - r0
                r6 = 20
                r60 = r2
                r2 = r23
                r23 = r14
                r14 = r37
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r14)
                long r14 = r14 - r2
                r6 = 31
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 44
                long r9 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r12)
                long r12 = r12 - r9
                r6 = 47
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r4)
                long r4 = r4 - r0
                r6 = 46
                r37 = r9
                r9 = r23
                r23 = r0
                r0 = r32
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r9)
                long r9 = r9 - r0
                r6 = 19
                r32 = r0
                r0 = r28
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r14)
                long r14 = r14 - r0
                r6 = 42
                r28 = r14
                r14 = r44
                r44 = r2
                r2 = r54
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r2)
                long r2 = r2 - r14
                r6 = 44
                r54 = r2
                r2 = r39
                r39 = r0
                r0 = r62
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r0)
                long r0 = r0 - r2
                r6 = 25
                r62 = r0
                r0 = r46
                r46 = r4
                r4 = r60
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r4)
                long r4 = r4 - r0
                r6 = 16
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 34
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r12)
                long r12 = r12 - r14
                r6 = 56
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r9)
                long r9 = r9 - r2
                r6 = 51
                r60 = r14
                r14 = r46
                r71 = r2
                r2 = r39
                r39 = r71
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r14)
                long r14 = r14 - r2
                r46 = r2
                r2 = r44
                r6 = 4
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r4)
                long r4 = r4 - r2
                r6 = 53
                r44 = r4
                r4 = r23
                r23 = r0
                r0 = r28
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r0)
                long r0 = r0 - r4
                r6 = 42
                r28 = r0
                r0 = r37
                r37 = r2
                r2 = r54
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r2)
                long r2 = r2 - r0
                r6 = 41
                r54 = r2
                r2 = r32
                r32 = r9
                r9 = r62
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r9)
                long r9 = r9 - r2
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 9
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r12)
                long r12 = r12 - r4
                r6 = 37
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r14)
                long r14 = r14 - r0
                r6 = 31
                r62 = r0
                r0 = r32
                r32 = r14
                r14 = r37
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r0)
                long r0 = r0 - r14
                r37 = r14
                r14 = r23
                r6 = 12
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r9)
                long r9 = r9 - r14
                r6 = 47
                r23 = r14
                r14 = r39
                r39 = r9
                r9 = r44
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r9)
                long r9 = r9 - r14
                r6 = 44
                r44 = r14
                r14 = r60
                r71 = r9
                r9 = r28
                r28 = r71
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r9)
                long r9 = r9 - r14
                r6 = 30
                r60 = r14
                r14 = r46
                r46 = r9
                r9 = r54
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r9)
                long r9 = r9 - r14
                r54 = r68[r70]
                long r7 = r7 - r54
                r54 = r68[r49]
                long r2 = r2 - r54
                r49 = r68[r50]
                long r12 = r12 - r49
                r49 = r68[r51]
                long r4 = r4 - r49
                r49 = r68[r74]
                r54 = r4
                long r4 = r32 - r49
                r32 = r68[r16]
                r49 = r2
                long r2 = r62 - r32
                r32 = r68[r11]
                long r0 = r0 - r32
                r16 = r68[r17]
                r32 = r2
                long r2 = r37 - r16
                r16 = r68[r18]
                r37 = r2
                long r2 = r39 - r16
                r16 = r68[r19]
                r18 = r2
                long r2 = r23 - r16
                r16 = r68[r20]
                r23 = r2
                long r2 = r28 - r16
                r16 = r68[r21]
                r20 = r2
                long r2 = r44 - r16
                r16 = r68[r26]
                r28 = r4
                long r4 = r46 - r16
                r16 = r68[r27]
                r26 = r56[r48]
                long r16 = r16 + r26
                r26 = r4
                long r4 = r60 - r16
                r16 = r68[r30]
                r30 = r56[r31]
                long r16 = r16 + r30
                long r9 = r9 - r16
                r16 = r68[r35]
                long r16 = r16 + r42
                long r14 = r14 - r16
                r6 = 5
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r7)
                long r7 = r7 - r14
                r6 = 20
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r12)
                long r12 = r12 - r2
                r6 = 48
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r0)
                long r0 = r0 - r4
                r6 = 41
                r16 = r2
                r2 = r28
                r71 = r4
                r4 = r23
                r23 = r71
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r2)
                long r2 = r2 - r4
                r6 = 47
                r28 = r4
                r4 = r49
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r9)
                long r9 = r9 - r4
                r6 = 28
                r30 = r9
                r9 = r32
                r71 = r14
                r14 = r18
                r18 = r71
                long r9 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r14)
                long r14 = r14 - r9
                r6 = 16
                r32 = r14
                r14 = r54
                r71 = r0
                r0 = r20
                r20 = r71
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r0)
                long r0 = r0 - r14
                r6 = 25
                r35 = r0
                r0 = r37
                r71 = r4
                r4 = r26
                r26 = r71
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r4)
                long r4 = r4 - r0
                r6 = 33
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r7 = r7 - r0
                r6 = 4
                long r9 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r9, r6, r12)
                long r12 = r12 - r9
                r6 = 51
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r2)
                long r2 = r2 - r14
                r37 = r9
                r9 = r20
                r6 = 13
                r20 = r14
                r14 = r26
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r9)
                long r9 = r9 - r14
                r6 = 34
                r26 = r14
                r14 = r18
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r4)
                long r4 = r4 - r14
                r6 = 41
                r18 = r4
                r4 = r23
                r23 = r0
                r0 = r30
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r0)
                long r0 = r0 - r4
                r6 = 59
                r30 = r0
                r0 = r16
                r16 = r2
                r2 = r32
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r2)
                long r2 = r2 - r0
                r6 = 17
                r32 = r2
                r2 = r28
                r28 = r14
                r14 = r35
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r14)
                long r14 = r14 - r2
                r6 = 38
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r7)
                long r7 = r7 - r2
                r6 = 19
                long r4 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r4, r6, r12)
                long r12 = r12 - r4
                r6 = 10
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r9)
                long r9 = r9 - r0
                r6 = 55
                r35 = r4
                r4 = r16
                r16 = r0
                r0 = r28
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r4)
                long r4 = r4 - r0
                r6 = 49
                r28 = r0
                r0 = r23
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r14)
                long r14 = r14 - r0
                r6 = 18
                r23 = r14
                r14 = r20
                r71 = r2
                r2 = r18
                r18 = r71
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r6, r2)
                long r2 = r2 - r14
                r6 = 23
                r20 = r2
                r2 = r37
                r71 = r0
                r0 = r30
                r30 = r71
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r6, r0)
                long r0 = r0 - r2
                r6 = 52
                r37 = r0
                r0 = r26
                r26 = r9
                r9 = r32
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r9)
                long r9 = r9 - r0
                r6 = 24
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r6, r7)
                long r6 = r7 - r0
                r8 = 13
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r14, r8, r12)
                long r11 = r12 - r14
                r8 = 8
                long r2 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r2, r8, r4)
                long r4 = r4 - r2
                r13 = 47
                r32 = r9
                r8 = r26
                r26 = r0
                r0 = r30
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r13, r8)
                long r8 = r8 - r0
                r30 = r0
                r0 = r18
                r10 = 8
                r18 = r2
                r2 = r32
                long r32 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r10, r2)
                long r0 = r2 - r32
                r2 = 17
                r39 = r0
                r0 = r16
                r16 = r4
                r3 = r23
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r2, r3)
                long r2 = r3 - r0
                r4 = 22
                r23 = r0
                r0 = r35
                r71 = r2
                r2 = r20
                r20 = r71
                long r42 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r0, r4, r2)
                long r0 = r2 - r42
                r2 = 37
                r3 = r28
                r28 = r0
                r0 = r37
                long r46 = org.spongycastle.crypto.engines.ThreefishEngine.xorRotr(r3, r2, r0)
                long r44 = r0 - r46
                int r0 = r69 + -2
                r35 = r20
                r37 = r23
                r2 = r56
                r3 = r58
                r4 = r59
                r1 = r68
                r5 = 9
                r20 = r16
                r23 = r18
                r16 = r11
                r18 = r14
                r13 = r26
                r12 = 12
                r15 = 4
                r10 = r6
                r26 = r8
                r6 = 13
                r9 = 1
                r7 = r0
                r0 = r73
                r71 = r30
                r30 = r39
                r39 = r28
                r28 = r71
                goto L_0x0072
            L_0x0497:
                r68 = r1
                r56 = r2
                r0 = 0
                r1 = r68[r0]
                long r10 = r10 - r1
                r0 = 1
                r1 = r68[r0]
                long r13 = r13 - r1
                r0 = 2
                r1 = r68[r0]
                long r16 = r16 - r1
                r0 = 3
                r1 = r68[r0]
                long r18 = r18 - r1
                r0 = 4
                r1 = r68[r0]
                long r20 = r20 - r1
                r0 = 5
                r1 = r68[r0]
                long r23 = r23 - r1
                r0 = r68[r22]
                long r26 = r26 - r0
                r0 = r68[r25]
                long r28 = r28 - r0
                r0 = 8
                r1 = r68[r0]
                long r30 = r30 - r1
                r0 = 9
                r1 = r68[r0]
                long r32 = r32 - r1
                r0 = 10
                r1 = r68[r0]
                long r35 = r35 - r1
                r0 = r68[r34]
                long r37 = r37 - r0
                r0 = 12
                r1 = r68[r0]
                long r39 = r39 - r1
                r0 = 13
                r1 = r68[r0]
                r0 = 0
                r3 = r56[r0]
                long r1 = r1 + r3
                long r42 = r42 - r1
                r1 = r68[r41]
                r3 = 1
                r4 = r56[r3]
                long r1 = r1 + r4
                long r44 = r44 - r1
                r1 = 15
                r1 = r68[r1]
                long r46 = r46 - r1
                r75[r0] = r10
                r75[r3] = r13
                r0 = 2
                r75[r0] = r16
                r0 = 3
                r75[r0] = r18
                r0 = 4
                r75[r0] = r20
                r0 = 5
                r75[r0] = r23
                r75[r22] = r26
                r75[r25] = r28
                r0 = 8
                r75[r0] = r30
                r0 = 9
                r75[r0] = r32
                r0 = 10
                r75[r0] = r35
                r75[r34] = r37
                r0 = 12
                r75[r0] = r39
                r0 = 13
                r75[r0] = r42
                r75[r41] = r44
                r0 = 15
                r75[r0] = r46
                return
            L_0x0524:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x052a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.decryptBlock(long[], long[]):void");
        }

        /* JADX WARNING: type inference failed for: r82v0, types: [long[]] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void encryptBlock(long[] r81, long[] r82) {
            /*
                r80 = this;
                r0 = r80
                long[] r1 = r0.f7732kw
                long[] r2 = r0.f7733t
                int[] r3 = org.spongycastle.crypto.engines.ThreefishEngine.MOD17
                int[] r4 = org.spongycastle.crypto.engines.ThreefishEngine.MOD3
                int r5 = r1.length
                r6 = 33
                if (r5 != r6) goto L_0x04d1
                int r5 = r2.length
                r6 = 5
                if (r5 != r6) goto L_0x04cb
                r5 = 0
                r7 = r81[r5]
                r9 = 1
                r10 = r81[r9]
                r12 = 2
                r13 = r81[r12]
                r15 = 3
                r16 = r81[r15]
                r15 = 4
                r19 = r81[r15]
                r21 = r81[r6]
                r23 = 6
                r24 = r81[r23]
                r26 = 7
                r27 = r81[r26]
                r6 = 8
                r30 = r81[r6]
                r6 = 9
                r33 = r81[r6]
                r6 = 10
                r36 = r81[r6]
                r38 = 11
                r39 = r81[r38]
                r6 = 12
                r42 = r81[r6]
                r6 = 13
                r45 = r81[r6]
                r47 = 14
                r48 = r81[r47]
                r50 = 15
                r50 = r81[r50]
                r52 = r1[r5]
                long r7 = r7 + r52
                r52 = r1[r9]
                long r10 = r10 + r52
                r52 = r1[r12]
                long r13 = r13 + r52
                r18 = 3
                r52 = r1[r18]
                long r16 = r16 + r52
                r52 = r1[r15]
                long r19 = r19 + r52
                r29 = 5
                r52 = r1[r29]
                long r21 = r21 + r52
                r52 = r1[r23]
                long r24 = r24 + r52
                r52 = r1[r26]
                long r27 = r27 + r52
                r32 = 8
                r52 = r1[r32]
                long r30 = r30 + r52
                r35 = 9
                r52 = r1[r35]
                long r33 = r33 + r52
                r41 = 10
                r52 = r1[r41]
                long r36 = r36 + r52
                r52 = r1[r38]
                long r39 = r39 + r52
                r44 = 12
                r52 = r1[r44]
                long r42 = r42 + r52
                r52 = r1[r6]
                r54 = r2[r5]
                long r52 = r52 + r54
                long r45 = r45 + r52
                r52 = r1[r47]
                r54 = r2[r9]
                long r52 = r52 + r54
                long r48 = r48 + r52
                r52 = 15
                r52 = r1[r52]
                long r50 = r50 + r52
                r5 = r16
                r56 = r27
                r58 = r33
                r60 = r39
                r62 = r45
                r64 = r50
                r16 = r13
                r13 = r10
                r10 = r7
                r8 = r21
                r7 = 1
                r20 = r19
            L_0x00bb:
                r12 = 20
                if (r7 >= r12) goto L_0x048b
                r12 = r3[r7]
                r28 = r4[r7]
                r15 = 24
                long r10 = r10 + r13
                long r13 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r13, r15, r10)
                r15 = r3
                r34 = r4
                long r3 = r16 + r5
                r0 = 13
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r0, r3)
                r39 = r1
                long r0 = r20 + r8
                r40 = r15
                r15 = 8
                long r8 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r8, r15, r0)
                r15 = 47
                r16 = r8
                r45 = r12
                r50 = r13
                r12 = r56
                r14 = r7
                long r7 = r24 + r12
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r15, r7)
                r52 = r5
                r9 = r14
                r14 = r58
                long r5 = r30 + r14
                r20 = r9
                r9 = 8
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r9, r5)
                r9 = 17
                r24 = r5
                r54 = r12
                r5 = r60
                long r12 = r36 + r5
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r9, r12)
                r9 = 22
                r56 = r0
                r30 = r12
                r12 = r62
                long r0 = r42 + r12
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r9, r0)
                r9 = 37
                r36 = r0
                r58 = r5
                r0 = r64
                long r5 = r48 + r0
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r5)
                r9 = 38
                long r10 = r10 + r14
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r9, r10)
                r9 = 19
                long r3 = r3 + r12
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r9, r3)
                long r7 = r7 + r58
                r42 = r14
                r14 = r58
                r9 = 10
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r9, r7)
                r9 = 55
                r48 = r14
                long r14 = r56 + r0
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r14)
                r9 = 49
                r56 = r12
                long r12 = r30 + r54
                r30 = r0
                r0 = r54
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r12)
                r9 = 18
                r54 = r12
                long r12 = r36 + r52
                r36 = r7
                r7 = r52
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r9, r12)
                r9 = 23
                long r5 = r5 + r16
                r52 = r12
                r12 = r16
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r9, r5)
                r9 = 52
                r16 = r5
                long r5 = r24 + r50
                r24 = r7
                r7 = r50
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r9, r5)
                r9 = 33
                long r10 = r10 + r0
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r10)
                long r3 = r3 + r12
                r9 = 4
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r9, r3)
                r9 = 51
                long r14 = r14 + r24
                r50 = r0
                r0 = r24
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r14)
                r24 = r0
                long r0 = r36 + r7
                r9 = 13
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r9, r0)
                r9 = 34
                r36 = r12
                long r12 = r52 + r30
                r52 = r7
                r7 = r30
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r9, r12)
                r9 = 41
                r30 = r12
                long r12 = r16 + r56
                r16 = r14
                r14 = r56
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r9, r12)
                r9 = 59
                long r5 = r5 + r48
                r56 = r12
                r12 = r48
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r9, r5)
                r9 = 17
                r48 = r5
                long r5 = r54 + r42
                r54 = r0
                r0 = r42
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r5)
                long r10 = r10 + r7
                r9 = 5
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r9, r10)
                r9 = 20
                long r3 = r3 + r12
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r9, r3)
                r9 = 48
                r42 = r7
                long r7 = r54 + r14
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r9, r7)
                r9 = 41
                r54 = r14
                long r14 = r16 + r0
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r14)
                r9 = 47
                r16 = r12
                long r12 = r56 + r52
                r56 = r0
                r0 = r52
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r9, r12)
                r9 = 28
                r52 = r12
                long r12 = r48 + r36
                r48 = r7
                r7 = r36
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r9, r12)
                r9 = 16
                long r5 = r5 + r24
                r36 = r12
                r12 = r24
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r9, r5)
                r9 = 25
                r24 = r5
                long r5 = r30 + r50
                r30 = r7
                r7 = r50
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r9, r5)
                r50 = r39[r45]
                long r10 = r10 + r50
                int r9 = r45 + 1
                r50 = r39[r9]
                long r0 = r0 + r50
                int r21 = r45 + 2
                r50 = r39[r21]
                long r3 = r3 + r50
                int r46 = r45 + 3
                r50 = r39[r46]
                long r12 = r12 + r50
                int r50 = r45 + 4
                r58 = r39[r50]
                long r14 = r14 + r58
                int r51 = r45 + 5
                r58 = r39[r51]
                r60 = r14
                long r14 = r30 + r58
                int r30 = r45 + 6
                r58 = r39[r30]
                long r48 = r48 + r58
                int r31 = r45 + 7
                r58 = r39[r31]
                long r7 = r7 + r58
                int r58 = r45 + 8
                r62 = r39[r58]
                long r36 = r36 + r62
                int r59 = r45 + 9
                r62 = r39[r59]
                r64 = r7
                long r7 = r56 + r62
                int r56 = r45 + 10
                r62 = r39[r56]
                long r24 = r24 + r62
                int r57 = r45 + 11
                r62 = r39[r57]
                r66 = r7
                long r7 = r16 + r62
                int r16 = r45 + 12
                r62 = r39[r16]
                long r5 = r5 + r62
                int r17 = r45 + 13
                r62 = r39[r17]
                r68 = r2[r28]
                long r62 = r62 + r68
                r68 = r5
                long r5 = r54 + r62
                int r54 = r45 + 14
                r62 = r39[r54]
                int r55 = r28 + 1
                r70 = r2[r55]
                long r62 = r62 + r70
                long r52 = r52 + r62
                int r62 = r45 + 15
                r70 = r39[r62]
                r63 = r2
                r72 = r5
                r2 = r20
                long r5 = (long) r2
                long r70 = r70 + r5
                r74 = r5
                long r5 = r42 + r70
                r2 = 41
                long r10 = r10 + r0
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r10)
                long r3 = r3 + r12
                r2 = 9
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r2, r3)
                r2 = 37
                r42 = r0
                long r0 = r60 + r14
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r2, r0)
                r2 = 31
                r60 = r14
                long r14 = r48 + r64
                r48 = r12
                r12 = r64
                long r12 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r12, r2, r14)
                r64 = r12
                long r12 = r36 + r66
                r36 = r0
                r0 = r66
                r2 = 12
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r12)
                r2 = 47
                r66 = r12
                long r12 = r24 + r7
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r12)
                r2 = 44
                r24 = r12
                long r12 = r68 + r72
                r68 = r7
                r7 = r72
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r12)
                r2 = 30
                r70 = r12
                long r12 = r52 + r5
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r12)
                r2 = 16
                long r10 = r10 + r0
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r10)
                r2 = 34
                long r3 = r3 + r7
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r3)
                r2 = 56
                long r14 = r14 + r68
                r52 = r0
                r0 = r68
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r14)
                r2 = 51
                r68 = r0
                long r0 = r36 + r5
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r0)
                r36 = r7
                long r7 = r24 + r64
                r24 = r5
                r5 = r64
                r2 = 4
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r7)
                r2 = 53
                r64 = r7
                long r7 = r70 + r48
                r70 = r14
                r14 = r48
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r2, r7)
                r2 = 42
                long r12 = r12 + r60
                r48 = r7
                r7 = r60
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r12)
                r2 = 41
                r60 = r12
                long r12 = r66 + r42
                r66 = r0
                r0 = r42
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r12)
                r2 = 31
                long r10 = r10 + r5
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r10)
                r2 = 44
                long r3 = r3 + r7
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r3)
                r2 = 47
                r42 = r5
                long r5 = r66 + r14
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r2, r5)
                r2 = 46
                r66 = r14
                long r14 = r70 + r0
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r14)
                r2 = 19
                r70 = r7
                long r7 = r48 + r24
                r48 = r0
                r0 = r24
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r7)
                r2 = 42
                r24 = r7
                long r7 = r60 + r36
                r60 = r5
                r5 = r36
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r7)
                r2 = 44
                long r12 = r12 + r68
                r36 = r7
                r7 = r68
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r12)
                r2 = 25
                r68 = r12
                long r12 = r64 + r52
                r64 = r5
                r5 = r52
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r12)
                long r10 = r10 + r0
                r2 = 9
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r10)
                r2 = 48
                long r3 = r3 + r7
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r3)
                r2 = 35
                long r14 = r14 + r64
                r52 = r0
                r0 = r64
                long r0 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r0, r2, r14)
                r2 = 52
                r64 = r0
                long r0 = r60 + r5
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r0)
                r2 = 23
                r60 = r7
                long r7 = r36 + r48
                r36 = r5
                r5 = r48
                long r5 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r5, r2, r7)
                r2 = 31
                r48 = r7
                long r7 = r68 + r70
                r68 = r14
                r14 = r70
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r2, r7)
                r2 = 37
                long r12 = r12 + r66
                r70 = r7
                r7 = r66
                long r7 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r7, r2, r12)
                r2 = 20
                r66 = r12
                long r12 = r24 + r42
                r24 = r14
                r14 = r42
                long r14 = org.spongycastle.crypto.engines.ThreefishEngine.rotlXor(r14, r2, r12)
                r42 = r39[r9]
                long r10 = r10 + r42
                r42 = r39[r21]
                long r5 = r5 + r42
                r42 = r39[r46]
                long r2 = r3 + r42
                r42 = r39[r50]
                long r7 = r7 + r42
                r42 = r39[r51]
                long r0 = r0 + r42
                r42 = r39[r30]
                long r24 = r24 + r42
                r30 = r39[r31]
                long r30 = r68 + r30
                r42 = r39[r58]
                long r14 = r14 + r42
                r42 = r39[r59]
                long r42 = r70 + r42
                r50 = r39[r56]
                long r58 = r36 + r50
                r36 = r39[r57]
                long r36 = r66 + r36
                r50 = r39[r16]
                long r60 = r60 + r50
                r16 = r39[r17]
                long r12 = r12 + r16
                r16 = r39[r54]
                r50 = r63[r55]
                long r16 = r16 + r50
                long r16 = r64 + r16
                r50 = r39[r62]
                r4 = 2
                int r28 = r28 + 2
                r54 = r63[r28]
                long r50 = r50 + r54
                long r48 = r48 + r50
                int r4 = r45 + 16
                r45 = r39[r4]
                long r45 = r45 + r74
                r50 = 1
                long r45 = r45 + r50
                long r64 = r52 + r45
                int r4 = r20 + 2
                r20 = r0
                r56 = r14
                r1 = r39
                r0 = r80
                r15 = 4
                r76 = r7
                r7 = r4
                r8 = r24
                r24 = r30
                r4 = r34
                r30 = r42
                r42 = r12
                r13 = r5
                r5 = r76
                r78 = r2
                r3 = r40
                r2 = r63
                r62 = r16
                r16 = r78
                goto L_0x00bb
            L_0x048b:
                r45 = r5
                r2 = r13
                r50 = r56
                r14 = r58
                r5 = r60
                r12 = r62
                r0 = r64
                r4 = 0
                r82[r4] = r10
                r4 = 1
                r82[r4] = r2
                r2 = 2
                r82[r2] = r16
                r2 = 3
                r82[r2] = r45
                r2 = 4
                r82[r2] = r20
                r2 = 5
                r82[r2] = r8
                r82[r23] = r24
                r82[r26] = r50
                r2 = 8
                r82[r2] = r30
                r2 = 9
                r82[r2] = r14
                r2 = 10
                r82[r2] = r36
                r82[r38] = r5
                r2 = 12
                r82[r2] = r42
                r2 = 13
                r82[r2] = r12
                r82[r47] = r48
                r2 = 15
                r82[r2] = r0
                return
            L_0x04cb:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            L_0x04d1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.engines.ThreefishEngine.Threefish1024Cipher.encryptBlock(long[], long[]):void");
        }
    }

    private static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        /* access modifiers changed from: package-private */
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f7732kw;
            long[] jArr4 = this.f7733t;
            int[] access$000 = ThreefishEngine.MOD5;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = j3;
                long j6 = j2;
                long j7 = j;
                int i = 17;
                for (int i2 = 1; i >= i2; i2 = 1) {
                    int i3 = access$000[i];
                    int i4 = access$100[i];
                    int i5 = i3 + 1;
                    long j8 = j7 - jArr3[i5];
                    int i6 = i3 + 2;
                    int i7 = i4 + 1;
                    long j9 = j6 - (jArr3[i6] + jArr4[i7]);
                    int i8 = i3 + 3;
                    long j10 = j5 - (jArr3[i8] + jArr4[i4 + 2]);
                    long j11 = (long) i;
                    int[] iArr = access$000;
                    long xorRotr = ThreefishEngine.xorRotr(j4 - ((jArr3[i3 + 4] + j11) + 1), 32, j8);
                    long xorRotr2 = ThreefishEngine.xorRotr(j9, 32, j10);
                    long j12 = j10 - xorRotr2;
                    long j13 = j8 - xorRotr;
                    long xorRotr3 = ThreefishEngine.xorRotr(xorRotr2, 58, j13);
                    long j14 = j13 - xorRotr3;
                    long xorRotr4 = ThreefishEngine.xorRotr(xorRotr, 22, j12);
                    long j15 = j12 - xorRotr4;
                    long xorRotr5 = ThreefishEngine.xorRotr(xorRotr4, 46, j14);
                    long j16 = j14 - xorRotr5;
                    long xorRotr6 = ThreefishEngine.xorRotr(xorRotr3, 12, j15);
                    long j17 = j15 - xorRotr6;
                    long xorRotr7 = ThreefishEngine.xorRotr(xorRotr6, 25, j16);
                    long xorRotr8 = ThreefishEngine.xorRotr(xorRotr5, 33, j17);
                    long j18 = (j16 - xorRotr7) - jArr3[i3];
                    long j19 = xorRotr7 - (jArr3[i5] + jArr4[i4]);
                    long j20 = (j17 - xorRotr8) - (jArr3[i6] + jArr4[i7]);
                    long xorRotr9 = ThreefishEngine.xorRotr(xorRotr8 - (jArr3[i8] + j11), 5, j18);
                    long j21 = j18 - xorRotr9;
                    long xorRotr10 = ThreefishEngine.xorRotr(j19, 37, j20);
                    long j22 = j20 - xorRotr10;
                    long xorRotr11 = ThreefishEngine.xorRotr(xorRotr10, 23, j21);
                    long j23 = j21 - xorRotr11;
                    long xorRotr12 = ThreefishEngine.xorRotr(xorRotr9, 40, j22);
                    long j24 = j22 - xorRotr12;
                    long xorRotr13 = ThreefishEngine.xorRotr(xorRotr12, 52, j23);
                    long j25 = j23 - xorRotr13;
                    long xorRotr14 = ThreefishEngine.xorRotr(xorRotr11, 57, j24);
                    long j26 = j24 - xorRotr14;
                    long xorRotr15 = ThreefishEngine.xorRotr(xorRotr14, 14, j25);
                    j4 = ThreefishEngine.xorRotr(xorRotr13, 16, j26);
                    j5 = j26 - j4;
                    i -= 2;
                    j6 = xorRotr15;
                    j7 = j25 - xorRotr15;
                    access$000 = iArr;
                    access$100 = access$100;
                }
                long j27 = j5 - (jArr3[2] + jArr4[1]);
                jArr2[0] = j7 - jArr3[0];
                jArr2[1] = j6 - (jArr3[1] + jArr4[0]);
                jArr2[2] = j27;
                jArr2[3] = j4 - jArr3[3];
            } else {
                throw new IllegalArgumentException();
            }
        }

        /* access modifiers changed from: package-private */
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f7732kw;
            long[] jArr4 = this.f7733t;
            int[] access$000 = ThreefishEngine.MOD5;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = j + jArr3[0];
                long j6 = j2 + jArr3[1] + jArr4[0];
                long j7 = j3 + jArr3[2] + jArr4[1];
                long j8 = j4 + jArr3[3];
                long j9 = j7;
                long j10 = j6;
                long j11 = j5;
                int i = 1;
                while (i < 18) {
                    int i2 = access$000[i];
                    int i3 = access$100[i];
                    long j12 = j11 + j10;
                    long rotlXor = ThreefishEngine.rotlXor(j10, 14, j12);
                    long j13 = j9 + j8;
                    long rotlXor2 = ThreefishEngine.rotlXor(j8, 16, j13);
                    long j14 = j12 + rotlXor2;
                    long rotlXor3 = ThreefishEngine.rotlXor(rotlXor2, 52, j14);
                    long j15 = j13 + rotlXor;
                    long rotlXor4 = ThreefishEngine.rotlXor(rotlXor, 57, j15);
                    int[] iArr = access$000;
                    long j16 = j14 + rotlXor4;
                    long rotlXor5 = ThreefishEngine.rotlXor(rotlXor4, 23, j16);
                    long j17 = j15 + rotlXor3;
                    long rotlXor6 = ThreefishEngine.rotlXor(rotlXor3, 40, j17);
                    long j18 = j16 + rotlXor6;
                    long rotlXor7 = ThreefishEngine.rotlXor(rotlXor6, 5, j18);
                    long j19 = j17 + rotlXor5;
                    long rotlXor8 = ThreefishEngine.rotlXor(rotlXor5, 37, j19);
                    long j20 = j18 + jArr3[i2];
                    int i4 = i2 + 1;
                    long j21 = rotlXor8 + jArr3[i4] + jArr4[i3];
                    int i5 = i2 + 2;
                    int i6 = i3 + 1;
                    long j22 = j19 + jArr3[i5] + jArr4[i6];
                    int i7 = i2 + 3;
                    long j23 = (long) i;
                    long j24 = rotlXor7 + jArr3[i7] + j23;
                    long j25 = j20 + j21;
                    long rotlXor9 = ThreefishEngine.rotlXor(j21, 25, j25);
                    long j26 = j23;
                    long j27 = j22 + j24;
                    long rotlXor10 = ThreefishEngine.rotlXor(j24, 33, j27);
                    long j28 = j25 + rotlXor10;
                    long rotlXor11 = ThreefishEngine.rotlXor(rotlXor10, 46, j28);
                    long j29 = j27 + rotlXor9;
                    long rotlXor12 = ThreefishEngine.rotlXor(rotlXor9, 12, j29);
                    long j30 = j28 + rotlXor12;
                    long rotlXor13 = ThreefishEngine.rotlXor(rotlXor12, 58, j30);
                    long j31 = j29 + rotlXor11;
                    long rotlXor14 = ThreefishEngine.rotlXor(rotlXor11, 22, j31);
                    long j32 = j30 + rotlXor14;
                    long rotlXor15 = ThreefishEngine.rotlXor(rotlXor14, 32, j32);
                    long j33 = j31 + rotlXor13;
                    long rotlXor16 = ThreefishEngine.rotlXor(rotlXor13, 32, j33);
                    long j34 = j32 + jArr3[i4];
                    j10 = jArr3[i5] + jArr4[i6] + rotlXor16;
                    j9 = j33 + jArr3[i7] + jArr4[i3 + 2];
                    j8 = rotlXor15 + jArr3[i2 + 4] + j26 + 1;
                    i += 2;
                    j11 = j34;
                    access$000 = iArr;
                    access$100 = access$100;
                }
                jArr2[0] = j11;
                jArr2[1] = j10;
                jArr2[2] = j9;
                jArr2[3] = j8;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        protected Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f7732kw;
            long[] jArr4 = this.f7733t;
            int[] access$200 = ThreefishEngine.MOD9;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                long j9 = j7;
                long j10 = j6;
                long j11 = j5;
                long j12 = j4;
                long j13 = j3;
                long j14 = j2;
                long j15 = j;
                int i = 17;
                for (int i2 = 1; i >= i2; i2 = 1) {
                    int i3 = access$200[i];
                    int i4 = access$100[i];
                    int i5 = i3 + 1;
                    long j16 = j15 - jArr3[i5];
                    int i6 = i3 + 2;
                    long j17 = j14 - jArr3[i6];
                    int i7 = i3 + 3;
                    long j18 = j13 - jArr3[i7];
                    int i8 = i3 + 4;
                    long j19 = j12 - jArr3[i8];
                    int i9 = i3 + 5;
                    long j20 = j11 - jArr3[i9];
                    int i10 = i3 + 6;
                    int i11 = i4 + 1;
                    int i12 = i;
                    long j21 = j10 - (jArr3[i10] + jArr4[i11]);
                    int i13 = i3 + 7;
                    int[] iArr = access$200;
                    int[] iArr2 = access$100;
                    long j22 = j9 - (jArr3[i13] + jArr4[i4 + 2]);
                    long j23 = jArr3[i3 + 8];
                    long[] jArr5 = jArr3;
                    long[] jArr6 = jArr4;
                    long j24 = (long) i12;
                    int i14 = i3;
                    long xorRotr = ThreefishEngine.xorRotr(j17, 8, j22);
                    long j25 = j22 - xorRotr;
                    long j26 = j16;
                    long xorRotr2 = ThreefishEngine.xorRotr(j8 - ((j23 + j24) + 1), 35, j26);
                    long j27 = j26 - xorRotr2;
                    long xorRotr3 = ThreefishEngine.xorRotr(j21, 56, j18);
                    long j28 = j18 - xorRotr3;
                    long j29 = xorRotr2;
                    long xorRotr4 = ThreefishEngine.xorRotr(j19, 22, j20);
                    long j30 = j20 - xorRotr4;
                    long xorRotr5 = ThreefishEngine.xorRotr(xorRotr, 25, j30);
                    long j31 = j30 - xorRotr5;
                    long xorRotr6 = ThreefishEngine.xorRotr(xorRotr4, 29, j25);
                    long j32 = j25 - xorRotr6;
                    long xorRotr7 = ThreefishEngine.xorRotr(xorRotr3, 39, j27);
                    long j33 = j27 - xorRotr7;
                    long j34 = xorRotr6;
                    long xorRotr8 = ThreefishEngine.xorRotr(j29, 43, j28);
                    long j35 = j28 - xorRotr8;
                    long xorRotr9 = ThreefishEngine.xorRotr(xorRotr5, 13, j35);
                    long j36 = j35 - xorRotr9;
                    long xorRotr10 = ThreefishEngine.xorRotr(xorRotr8, 50, j31);
                    long j37 = j31 - xorRotr10;
                    long xorRotr11 = ThreefishEngine.xorRotr(xorRotr7, 10, j32);
                    long j38 = j32 - xorRotr11;
                    long j39 = xorRotr10;
                    long xorRotr12 = ThreefishEngine.xorRotr(j34, 17, j33);
                    long j40 = j33 - xorRotr12;
                    long xorRotr13 = ThreefishEngine.xorRotr(xorRotr9, 39, j40);
                    long xorRotr14 = ThreefishEngine.xorRotr(xorRotr12, 30, j36);
                    long xorRotr15 = ThreefishEngine.xorRotr(xorRotr11, 34, j37);
                    long j41 = j37 - xorRotr15;
                    long j42 = xorRotr15;
                    long xorRotr16 = ThreefishEngine.xorRotr(j39, 24, j38);
                    long j43 = (j40 - xorRotr13) - jArr5[i14];
                    long j44 = xorRotr13 - jArr5[i5];
                    long j45 = (j36 - xorRotr14) - jArr5[i6];
                    long j46 = xorRotr14 - jArr5[i7];
                    long j47 = j41 - jArr5[i8];
                    long j48 = jArr5[i9] + jArr6[i4];
                    long j49 = j46;
                    long j50 = (j38 - xorRotr16) - (jArr5[i10] + jArr6[i11]);
                    long j51 = jArr5[i13];
                    long xorRotr17 = ThreefishEngine.xorRotr(j44, 44, j50);
                    long j52 = j50 - xorRotr17;
                    long xorRotr18 = ThreefishEngine.xorRotr(xorRotr16 - (j51 + j24), 9, j43);
                    long j53 = j43 - xorRotr18;
                    long xorRotr19 = ThreefishEngine.xorRotr(j42 - j48, 54, j45);
                    long j54 = j45 - xorRotr19;
                    long xorRotr20 = ThreefishEngine.xorRotr(j49, 56, j47);
                    long j55 = j47 - xorRotr20;
                    long xorRotr21 = ThreefishEngine.xorRotr(xorRotr17, 17, j55);
                    long j56 = j55 - xorRotr21;
                    long xorRotr22 = ThreefishEngine.xorRotr(xorRotr20, 49, j52);
                    long xorRotr23 = ThreefishEngine.xorRotr(xorRotr19, 36, j53);
                    long j57 = j53 - xorRotr23;
                    long j58 = j54;
                    long xorRotr24 = ThreefishEngine.xorRotr(xorRotr18, 39, j58);
                    long j59 = j58 - xorRotr24;
                    long xorRotr25 = ThreefishEngine.xorRotr(xorRotr21, 33, j59);
                    long j60 = j59 - xorRotr25;
                    long xorRotr26 = ThreefishEngine.xorRotr(xorRotr24, 27, j56);
                    long j61 = j56 - xorRotr26;
                    long j62 = xorRotr26;
                    long j63 = j52 - xorRotr22;
                    long xorRotr27 = ThreefishEngine.xorRotr(xorRotr23, 14, j63);
                    long j64 = j63 - xorRotr27;
                    long xorRotr28 = ThreefishEngine.xorRotr(xorRotr22, 42, j57);
                    long j65 = j57 - xorRotr28;
                    long xorRotr29 = ThreefishEngine.xorRotr(xorRotr25, 46, j65);
                    j15 = j65 - xorRotr29;
                    j12 = ThreefishEngine.xorRotr(xorRotr28, 36, j60);
                    j10 = ThreefishEngine.xorRotr(xorRotr27, 19, j61);
                    j11 = j61 - j10;
                    j8 = ThreefishEngine.xorRotr(j62, 37, j64);
                    j9 = j64 - j8;
                    i = i12 - 2;
                    j13 = j60 - j12;
                    j14 = xorRotr29;
                    access$200 = iArr;
                    access$100 = iArr2;
                    jArr3 = jArr5;
                    jArr4 = jArr6;
                }
                long[] jArr7 = jArr3;
                long[] jArr8 = jArr4;
                long j66 = j15 - jArr7[0];
                long j67 = j14 - jArr7[1];
                long j68 = j13 - jArr7[2];
                long j69 = j12 - jArr7[3];
                long j70 = j11 - jArr7[4];
                long j71 = j9 - (jArr7[6] + jArr8[1]);
                jArr2[0] = j66;
                jArr2[1] = j67;
                jArr2[2] = j68;
                jArr2[3] = j69;
                jArr2[4] = j70;
                jArr2[5] = j10 - (jArr7[5] + jArr8[0]);
                jArr2[6] = j71;
                jArr2[7] = j8 - jArr7[7];
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f7732kw;
            long[] jArr4 = this.f7733t;
            int[] access$200 = ThreefishEngine.MOD9;
            int[] access$100 = ThreefishEngine.MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            } else if (jArr4.length == 5) {
                long j = jArr[0];
                long j2 = jArr[1];
                long j3 = jArr[2];
                long j4 = jArr[3];
                long j5 = jArr[4];
                long j6 = jArr[5];
                long j7 = jArr[6];
                long j8 = jArr[7];
                long j9 = j + jArr3[0];
                long j10 = j2 + jArr3[1];
                long j11 = j3 + jArr3[2];
                long j12 = j4 + jArr3[3];
                long j13 = j5 + jArr3[4];
                long j14 = j6 + jArr3[5] + jArr4[0];
                long j15 = j7 + jArr3[6] + jArr4[1];
                long j16 = j12;
                long j17 = j8 + jArr3[7];
                long j18 = j11;
                long j19 = j10;
                long j20 = j9;
                long j21 = j14;
                int i = 1;
                long j22 = j13;
                while (i < 18) {
                    int i2 = access$200[i];
                    int i3 = access$100[i];
                    long j23 = j20 + j19;
                    long rotlXor = ThreefishEngine.rotlXor(j19, 46, j23);
                    int[] iArr = access$200;
                    int[] iArr2 = access$100;
                    long j24 = j18 + j16;
                    long rotlXor2 = ThreefishEngine.rotlXor(j16, 36, j24);
                    long[] jArr5 = jArr3;
                    long j25 = j22 + j21;
                    long rotlXor3 = ThreefishEngine.rotlXor(j21, 19, j25);
                    int i4 = i2;
                    int i5 = i;
                    long j26 = j17;
                    long j27 = rotlXor2;
                    long j28 = j15 + j26;
                    long rotlXor4 = ThreefishEngine.rotlXor(j26, 37, j28);
                    long j29 = j24 + rotlXor;
                    long rotlXor5 = ThreefishEngine.rotlXor(rotlXor, 33, j29);
                    long j30 = j25 + rotlXor4;
                    long rotlXor6 = ThreefishEngine.rotlXor(rotlXor4, 27, j30);
                    long j31 = j28 + rotlXor3;
                    long j32 = j23 + j27;
                    long rotlXor7 = ThreefishEngine.rotlXor(rotlXor3, 14, j31);
                    long rotlXor8 = ThreefishEngine.rotlXor(j27, 42, j32);
                    long j33 = j30 + rotlXor5;
                    long rotlXor9 = ThreefishEngine.rotlXor(rotlXor5, 17, j33);
                    long j34 = rotlXor8;
                    long j35 = rotlXor7;
                    long j36 = j33;
                    long j37 = j34;
                    long j38 = j31 + j37;
                    long rotlXor10 = ThreefishEngine.rotlXor(j37, 49, j38);
                    long j39 = j32 + j35;
                    long rotlXor11 = ThreefishEngine.rotlXor(j35, 36, j39);
                    long j40 = j29 + rotlXor6;
                    long rotlXor12 = ThreefishEngine.rotlXor(rotlXor6, 39, j40);
                    long j41 = j38 + rotlXor9;
                    long rotlXor13 = ThreefishEngine.rotlXor(rotlXor9, 44, j41);
                    long j42 = j39 + rotlXor12;
                    long rotlXor14 = ThreefishEngine.rotlXor(rotlXor12, 9, j42);
                    long j43 = j40 + rotlXor11;
                    long rotlXor15 = ThreefishEngine.rotlXor(rotlXor11, 54, j43);
                    long j44 = rotlXor14;
                    long j45 = j36 + rotlXor10;
                    long rotlXor16 = ThreefishEngine.rotlXor(rotlXor10, 56, j45);
                    long j46 = j42 + jArr5[i4];
                    int i6 = i4 + 1;
                    long j47 = rotlXor13 + jArr5[i6];
                    int i7 = i4 + 2;
                    long j48 = j43 + jArr5[i7];
                    int i8 = i4 + 3;
                    long j49 = rotlXor16 + jArr5[i8];
                    int i9 = i4 + 4;
                    long j50 = j45 + jArr5[i9];
                    int i10 = i4 + 5;
                    long j51 = rotlXor15 + jArr5[i10] + jArr4[i3];
                    int i11 = i4 + 6;
                    int i12 = i3 + 1;
                    int i13 = i4 + 7;
                    long j52 = j41 + jArr5[i11] + jArr4[i12];
                    long j53 = (long) i5;
                    long j54 = j53;
                    long j55 = j44 + jArr5[i13] + j53;
                    long j56 = j46 + j47;
                    long rotlXor17 = ThreefishEngine.rotlXor(j47, 39, j56);
                    long j57 = j48 + j49;
                    long rotlXor18 = ThreefishEngine.rotlXor(j49, 30, j57);
                    long j58 = j50 + j51;
                    long rotlXor19 = ThreefishEngine.rotlXor(j51, 34, j58);
                    long j59 = rotlXor18;
                    long j60 = j52 + j55;
                    long rotlXor20 = ThreefishEngine.rotlXor(j55, 24, j60);
                    long j61 = j57 + rotlXor17;
                    long rotlXor21 = ThreefishEngine.rotlXor(rotlXor17, 13, j61);
                    long j62 = j58 + rotlXor20;
                    long rotlXor22 = ThreefishEngine.rotlXor(rotlXor20, 50, j62);
                    long j63 = j60 + rotlXor19;
                    long rotlXor23 = ThreefishEngine.rotlXor(rotlXor19, 10, j63);
                    long j64 = j56 + j59;
                    long[] jArr6 = jArr4;
                    long rotlXor24 = ThreefishEngine.rotlXor(j59, 17, j64);
                    long j65 = j62 + rotlXor21;
                    long rotlXor25 = ThreefishEngine.rotlXor(rotlXor21, 25, j65);
                    long j66 = j63 + rotlXor24;
                    long rotlXor26 = ThreefishEngine.rotlXor(rotlXor24, 29, j66);
                    long j67 = j64 + rotlXor23;
                    long rotlXor27 = ThreefishEngine.rotlXor(rotlXor23, 39, j67);
                    long j68 = rotlXor26;
                    long j69 = j61 + rotlXor22;
                    long rotlXor28 = ThreefishEngine.rotlXor(rotlXor22, 43, j69);
                    long j70 = j66 + rotlXor25;
                    long rotlXor29 = ThreefishEngine.rotlXor(rotlXor25, 8, j70);
                    long j71 = j67 + rotlXor28;
                    long rotlXor30 = ThreefishEngine.rotlXor(rotlXor28, 35, j71);
                    long j72 = j69 + rotlXor27;
                    long rotlXor31 = ThreefishEngine.rotlXor(rotlXor27, 56, j72);
                    long j73 = j65 + j68;
                    long j74 = rotlXor30;
                    long rotlXor32 = ThreefishEngine.rotlXor(j68, 22, j73);
                    j20 = j71 + jArr5[i6];
                    long j75 = rotlXor29 + jArr5[i7];
                    j18 = j72 + jArr5[i8];
                    j16 = rotlXor32 + jArr5[i9];
                    j22 = j73 + jArr5[i10];
                    j21 = rotlXor31 + jArr5[i11] + jArr6[i12];
                    j15 = j70 + jArr5[i13] + jArr6[i3 + 2];
                    j17 = j74 + jArr5[i4 + 8] + j54 + 1;
                    i = i5 + 2;
                    j19 = j75;
                    access$200 = iArr;
                    access$100 = iArr2;
                    jArr3 = jArr5;
                    jArr4 = jArr6;
                }
                jArr2[0] = j20;
                jArr2[1] = j19;
                jArr2[2] = j18;
                jArr2[3] = j16;
                jArr2[4] = j22;
                jArr2[5] = j21;
                jArr2[6] = j15;
                jArr2[7] = j17;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static abstract class ThreefishCipher {

        /* renamed from: kw */
        protected final long[] f7732kw;

        /* renamed from: t */
        protected final long[] f7733t;

        protected ThreefishCipher(long[] jArr, long[] jArr2) {
            this.f7732kw = jArr;
            this.f7733t = jArr2;
        }

        /* access modifiers changed from: package-private */
        public abstract void decryptBlock(long[] jArr, long[] jArr2);

        /* access modifiers changed from: package-private */
        public abstract void encryptBlock(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = MOD9;
        MOD17 = new int[iArr.length];
        MOD5 = new int[iArr.length];
        MOD3 = new int[iArr.length];
        int i = 0;
        while (true) {
            int[] iArr2 = MOD9;
            if (i < iArr2.length) {
                MOD17[i] = i % 17;
                iArr2[i] = i % 9;
                MOD5[i] = i % 5;
                MOD3[i] = i % 3;
                i++;
            } else {
                return;
            }
        }
    }

    public ThreefishEngine(int i) {
        ThreefishCipher threefishCipher;
        this.blocksizeBytes = i / 8;
        this.blocksizeWords = this.blocksizeBytes / 8;
        int i2 = this.blocksizeWords;
        this.currentBlock = new long[i2];
        this.f7730kw = new long[((i2 * 2) + 1)];
        if (i == 256) {
            threefishCipher = new Threefish256Cipher(this.f7730kw, this.f7731t);
        } else if (i == 512) {
            threefishCipher = new Threefish512Cipher(this.f7730kw, this.f7731t);
        } else if (i == 1024) {
            threefishCipher = new Threefish1024Cipher(this.f7730kw, this.f7731t);
        } else {
            throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
        }
        this.cipher = threefishCipher;
    }

    public static long bytesToWord(byte[] bArr, int i) {
        if (i + 8 <= bArr.length) {
            int i2 = i + 1;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            return ((((long) bArr[i7 + 1]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i2]) & 255) << 8) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 24) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 40) | ((((long) bArr[i7]) & 255) << 48);
        }
        throw new IllegalArgumentException();
    }

    static long rotlXor(long j, int i, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    private void setKey(long[] jArr) {
        if (jArr.length == this.blocksizeWords) {
            long j = 2004413935125273122L;
            int i = 0;
            while (true) {
                int i2 = this.blocksizeWords;
                if (i < i2) {
                    long[] jArr2 = this.f7730kw;
                    jArr2[i] = jArr[i];
                    j ^= jArr2[i];
                    i++;
                } else {
                    long[] jArr3 = this.f7730kw;
                    jArr3[i2] = j;
                    System.arraycopy(jArr3, 0, jArr3, i2 + 1, i2);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length == 2) {
            long[] jArr2 = this.f7731t;
            jArr2[0] = jArr[0];
            jArr2[1] = jArr[1];
            jArr2[2] = jArr2[0] ^ jArr2[1];
            jArr2[3] = jArr2[0];
            jArr2[4] = jArr2[1];
            return;
        }
        throw new IllegalArgumentException("Tweak must be 2 words.");
    }

    public static void wordToBytes(long j, byte[] bArr, int i) {
        if (i + 8 <= bArr.length) {
            int i2 = i + 1;
            bArr[i] = (byte) ((int) j);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((int) (j >> 8));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) (j >> 16));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (j >> 24));
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((int) (j >> 32));
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((int) (j >> 40));
            bArr[i7] = (byte) ((int) (j >> 48));
            bArr[i7 + 1] = (byte) ((int) (j >> 56));
            return;
        }
        throw new IllegalArgumentException();
    }

    static long xorRotr(long j, int i, long j2) {
        long j3 = j ^ j2;
        return (j3 << (-i)) | (j3 >>> i);
    }

    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] bArr;
        byte[] bArr2;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            bArr2 = tweakableBlockCipherParameters.getKey().getKey();
            bArr = tweakableBlockCipherParameters.getTweak();
        } else if (cipherParameters instanceof KeyParameter) {
            bArr2 = ((KeyParameter) cipherParameters).getKey();
            bArr = null;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + cipherParameters.getClass().getName());
        }
        if (bArr2 == null) {
            jArr = null;
        } else if (bArr2.length == this.blocksizeBytes) {
            jArr = new long[this.blocksizeWords];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = bytesToWord(bArr2, i * 8);
            }
        } else {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
        }
        if (bArr != null) {
            if (bArr.length == 16) {
                jArr2 = new long[]{bytesToWord(bArr, 0), bytesToWord(bArr, 8)};
            } else {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
        }
        init(z, jArr, jArr2);
    }

    public void init(boolean z, long[] jArr, long[] jArr2) {
        this.forEncryption = z;
        if (jArr != null) {
            setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blocksizeBytes;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.blocksizeBytes; i5 += 8) {
                this.currentBlock[i5 >> 3] = bytesToWord(bArr, i + i5);
            }
            long[] jArr = this.currentBlock;
            processBlock(jArr, jArr);
            while (true) {
                int i6 = this.blocksizeBytes;
                if (i4 >= i6) {
                    return i6;
                }
                wordToBytes(this.currentBlock[i4 >> 3], bArr2, i2 + i4);
                i4 += 8;
            }
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public int processBlock(long[] jArr, long[] jArr2) {
        long[] jArr3 = this.f7730kw;
        int i = this.blocksizeWords;
        if (jArr3[i] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        } else if (jArr.length != i) {
            throw new DataLengthException("Input buffer too short");
        } else if (jArr2.length == i) {
            if (this.forEncryption) {
                this.cipher.encryptBlock(jArr, jArr2);
            } else {
                this.cipher.decryptBlock(jArr, jArr2);
            }
            return this.blocksizeWords;
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public void reset() {
    }
}

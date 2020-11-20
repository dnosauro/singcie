package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

public class RIPEMD160Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 20;

    /* renamed from: H0 */
    private int f7546H0;

    /* renamed from: H1 */
    private int f7547H1;

    /* renamed from: H2 */
    private int f7548H2;

    /* renamed from: H3 */
    private int f7549H3;

    /* renamed from: H4 */
    private int f7550H4;

    /* renamed from: X */
    private int[] f7551X = new int[16];
    private int xOff;

    public RIPEMD160Digest() {
        reset();
    }

    public RIPEMD160Digest(RIPEMD160Digest rIPEMD160Digest) {
        super((GeneralDigest) rIPEMD160Digest);
        copyIn(rIPEMD160Digest);
    }

    /* renamed from: RL */
    private int m9163RL(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private void copyIn(RIPEMD160Digest rIPEMD160Digest) {
        super.copyIn(rIPEMD160Digest);
        this.f7546H0 = rIPEMD160Digest.f7546H0;
        this.f7547H1 = rIPEMD160Digest.f7547H1;
        this.f7548H2 = rIPEMD160Digest.f7548H2;
        this.f7549H3 = rIPEMD160Digest.f7549H3;
        this.f7550H4 = rIPEMD160Digest.f7550H4;
        int[] iArr = rIPEMD160Digest.f7551X;
        System.arraycopy(iArr, 0, this.f7551X, 0, iArr.length);
        this.xOff = rIPEMD160Digest.xOff;
    }

    /* renamed from: f1 */
    private int m9164f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m9165f2(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: f3 */
    private int m9166f3(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: f4 */
    private int m9167f4(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: f5 */
    private int m9168f5(int i, int i2, int i3) {
        return i ^ (i2 | (~i3));
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public Memoable copy() {
        return new RIPEMD160Digest(this);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.f7546H0, bArr, i);
        unpackWord(this.f7547H1, bArr, i + 4);
        unpackWord(this.f7548H2, bArr, i + 8);
        unpackWord(this.f7549H3, bArr, i + 12);
        unpackWord(this.f7550H4, bArr, i + 16);
        reset();
        return 20;
    }

    public String getAlgorithmName() {
        return "RIPEMD160";
    }

    public int getDigestSize() {
        return 20;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        int i = this.f7546H0;
        int i2 = this.f7547H1;
        int i3 = this.f7548H2;
        int i4 = this.f7549H3;
        int i5 = this.f7550H4;
        int RL = m9163RL(m9164f1(i2, i3, i4) + i + this.f7551X[0], 11) + i5;
        int RL2 = m9163RL(i3, 10);
        int RL3 = m9163RL(m9164f1(RL, i2, RL2) + i5 + this.f7551X[1], 14) + i4;
        int RL4 = m9163RL(i2, 10);
        int RL5 = m9163RL(m9164f1(RL3, RL, RL4) + i4 + this.f7551X[2], 15) + RL2;
        int RL6 = m9163RL(RL, 10);
        int RL7 = m9163RL(RL2 + m9164f1(RL5, RL3, RL6) + this.f7551X[3], 12) + RL4;
        int RL8 = m9163RL(RL3, 10);
        int RL9 = m9163RL(RL4 + m9164f1(RL7, RL5, RL8) + this.f7551X[4], 5) + RL6;
        int RL10 = m9163RL(RL5, 10);
        int RL11 = m9163RL(RL6 + m9164f1(RL9, RL7, RL10) + this.f7551X[5], 8) + RL8;
        int RL12 = m9163RL(RL7, 10);
        int RL13 = m9163RL(RL8 + m9164f1(RL11, RL9, RL12) + this.f7551X[6], 7) + RL10;
        int RL14 = m9163RL(RL9, 10);
        int RL15 = m9163RL(RL10 + m9164f1(RL13, RL11, RL14) + this.f7551X[7], 9) + RL12;
        int RL16 = m9163RL(RL11, 10);
        int RL17 = m9163RL(RL12 + m9164f1(RL15, RL13, RL16) + this.f7551X[8], 11) + RL14;
        int RL18 = m9163RL(RL13, 10);
        int RL19 = m9163RL(RL14 + m9164f1(RL17, RL15, RL18) + this.f7551X[9], 13) + RL16;
        int RL20 = m9163RL(RL15, 10);
        int RL21 = m9163RL(RL16 + m9164f1(RL19, RL17, RL20) + this.f7551X[10], 14) + RL18;
        int RL22 = m9163RL(RL17, 10);
        int RL23 = m9163RL(RL18 + m9164f1(RL21, RL19, RL22) + this.f7551X[11], 15) + RL20;
        int RL24 = m9163RL(RL19, 10);
        int RL25 = m9163RL(RL20 + m9164f1(RL23, RL21, RL24) + this.f7551X[12], 6) + RL22;
        int RL26 = m9163RL(RL21, 10);
        int RL27 = m9163RL(RL22 + m9164f1(RL25, RL23, RL26) + this.f7551X[13], 7) + RL24;
        int RL28 = m9163RL(RL23, 10);
        int RL29 = m9163RL(RL24 + m9164f1(RL27, RL25, RL28) + this.f7551X[14], 9) + RL26;
        int RL30 = m9163RL(RL25, 10);
        int RL31 = m9163RL(RL26 + m9164f1(RL29, RL27, RL30) + this.f7551X[15], 8) + RL28;
        int RL32 = m9163RL(RL27, 10);
        int RL33 = m9163RL(i + m9168f5(i2, i3, i4) + this.f7551X[5] + 1352829926, 8) + i5;
        int RL34 = m9163RL(i3, 10);
        int RL35 = m9163RL(i5 + m9168f5(RL33, i2, RL34) + this.f7551X[14] + 1352829926, 9) + i4;
        int RL36 = m9163RL(i2, 10);
        int RL37 = m9163RL(i4 + m9168f5(RL35, RL33, RL36) + this.f7551X[7] + 1352829926, 9) + RL34;
        int RL38 = m9163RL(RL33, 10);
        int RL39 = m9163RL(RL34 + m9168f5(RL37, RL35, RL38) + this.f7551X[0] + 1352829926, 11) + RL36;
        int RL40 = m9163RL(RL35, 10);
        int RL41 = m9163RL(RL36 + m9168f5(RL39, RL37, RL40) + this.f7551X[9] + 1352829926, 13) + RL38;
        int RL42 = m9163RL(RL37, 10);
        int RL43 = m9163RL(RL38 + m9168f5(RL41, RL39, RL42) + this.f7551X[2] + 1352829926, 15) + RL40;
        int RL44 = m9163RL(RL39, 10);
        int RL45 = m9163RL(RL40 + m9168f5(RL43, RL41, RL44) + this.f7551X[11] + 1352829926, 15) + RL42;
        int RL46 = m9163RL(RL41, 10);
        int RL47 = m9163RL(RL42 + m9168f5(RL45, RL43, RL46) + this.f7551X[4] + 1352829926, 5) + RL44;
        int RL48 = m9163RL(RL43, 10);
        int RL49 = m9163RL(RL44 + m9168f5(RL47, RL45, RL48) + this.f7551X[13] + 1352829926, 7) + RL46;
        int RL50 = m9163RL(RL45, 10);
        int RL51 = m9163RL(RL46 + m9168f5(RL49, RL47, RL50) + this.f7551X[6] + 1352829926, 7) + RL48;
        int RL52 = m9163RL(RL47, 10);
        int RL53 = m9163RL(RL48 + m9168f5(RL51, RL49, RL52) + this.f7551X[15] + 1352829926, 8) + RL50;
        int RL54 = m9163RL(RL49, 10);
        int RL55 = m9163RL(RL50 + m9168f5(RL53, RL51, RL54) + this.f7551X[8] + 1352829926, 11) + RL52;
        int RL56 = m9163RL(RL51, 10);
        int RL57 = m9163RL(RL52 + m9168f5(RL55, RL53, RL56) + this.f7551X[1] + 1352829926, 14) + RL54;
        int RL58 = m9163RL(RL53, 10);
        int RL59 = m9163RL(RL54 + m9168f5(RL57, RL55, RL58) + this.f7551X[10] + 1352829926, 14) + RL56;
        int RL60 = m9163RL(RL55, 10);
        int RL61 = m9163RL(RL56 + m9168f5(RL59, RL57, RL60) + this.f7551X[3] + 1352829926, 12) + RL58;
        int RL62 = m9163RL(RL57, 10);
        int RL63 = m9163RL(RL58 + m9168f5(RL61, RL59, RL62) + this.f7551X[12] + 1352829926, 6) + RL60;
        int RL64 = m9163RL(RL59, 10);
        int RL65 = m9163RL(RL28 + m9165f2(RL31, RL29, RL32) + this.f7551X[7] + 1518500249, 7) + RL30;
        int RL66 = m9163RL(RL29, 10);
        int RL67 = m9163RL(RL30 + m9165f2(RL65, RL31, RL66) + this.f7551X[4] + 1518500249, 6) + RL32;
        int RL68 = m9163RL(RL31, 10);
        int RL69 = m9163RL(RL32 + m9165f2(RL67, RL65, RL68) + this.f7551X[13] + 1518500249, 8) + RL66;
        int RL70 = m9163RL(RL65, 10);
        int RL71 = m9163RL(RL66 + m9165f2(RL69, RL67, RL70) + this.f7551X[1] + 1518500249, 13) + RL68;
        int RL72 = m9163RL(RL67, 10);
        int RL73 = m9163RL(RL68 + m9165f2(RL71, RL69, RL72) + this.f7551X[10] + 1518500249, 11) + RL70;
        int RL74 = m9163RL(RL69, 10);
        int RL75 = m9163RL(RL70 + m9165f2(RL73, RL71, RL74) + this.f7551X[6] + 1518500249, 9) + RL72;
        int RL76 = m9163RL(RL71, 10);
        int RL77 = m9163RL(RL72 + m9165f2(RL75, RL73, RL76) + this.f7551X[15] + 1518500249, 7) + RL74;
        int RL78 = m9163RL(RL73, 10);
        int RL79 = m9163RL(RL74 + m9165f2(RL77, RL75, RL78) + this.f7551X[3] + 1518500249, 15) + RL76;
        int RL80 = m9163RL(RL75, 10);
        int RL81 = m9163RL(RL76 + m9165f2(RL79, RL77, RL80) + this.f7551X[12] + 1518500249, 7) + RL78;
        int RL82 = m9163RL(RL77, 10);
        int RL83 = m9163RL(RL78 + m9165f2(RL81, RL79, RL82) + this.f7551X[0] + 1518500249, 12) + RL80;
        int RL84 = m9163RL(RL79, 10);
        int RL85 = m9163RL(RL80 + m9165f2(RL83, RL81, RL84) + this.f7551X[9] + 1518500249, 15) + RL82;
        int RL86 = m9163RL(RL81, 10);
        int RL87 = m9163RL(RL82 + m9165f2(RL85, RL83, RL86) + this.f7551X[5] + 1518500249, 9) + RL84;
        int RL88 = m9163RL(RL83, 10);
        int RL89 = m9163RL(RL84 + m9165f2(RL87, RL85, RL88) + this.f7551X[2] + 1518500249, 11) + RL86;
        int RL90 = m9163RL(RL85, 10);
        int RL91 = m9163RL(RL86 + m9165f2(RL89, RL87, RL90) + this.f7551X[14] + 1518500249, 7) + RL88;
        int RL92 = m9163RL(RL87, 10);
        int RL93 = m9163RL(RL88 + m9165f2(RL91, RL89, RL92) + this.f7551X[11] + 1518500249, 13) + RL90;
        int RL94 = m9163RL(RL89, 10);
        int RL95 = m9163RL(RL90 + m9165f2(RL93, RL91, RL94) + this.f7551X[8] + 1518500249, 12) + RL92;
        int RL96 = m9163RL(RL91, 10);
        int RL97 = m9163RL(RL60 + m9167f4(RL63, RL61, RL64) + this.f7551X[6] + 1548603684, 9) + RL62;
        int RL98 = m9163RL(RL61, 10);
        int RL99 = m9163RL(RL62 + m9167f4(RL97, RL63, RL98) + this.f7551X[11] + 1548603684, 13) + RL64;
        int RL100 = m9163RL(RL63, 10);
        int RL101 = m9163RL(RL64 + m9167f4(RL99, RL97, RL100) + this.f7551X[3] + 1548603684, 15) + RL98;
        int RL102 = m9163RL(RL97, 10);
        int RL103 = m9163RL(RL98 + m9167f4(RL101, RL99, RL102) + this.f7551X[7] + 1548603684, 7) + RL100;
        int RL104 = m9163RL(RL99, 10);
        int RL105 = m9163RL(RL100 + m9167f4(RL103, RL101, RL104) + this.f7551X[0] + 1548603684, 12) + RL102;
        int RL106 = m9163RL(RL101, 10);
        int RL107 = m9163RL(RL102 + m9167f4(RL105, RL103, RL106) + this.f7551X[13] + 1548603684, 8) + RL104;
        int RL108 = m9163RL(RL103, 10);
        int RL109 = m9163RL(RL104 + m9167f4(RL107, RL105, RL108) + this.f7551X[5] + 1548603684, 9) + RL106;
        int RL110 = m9163RL(RL105, 10);
        int RL111 = m9163RL(RL106 + m9167f4(RL109, RL107, RL110) + this.f7551X[10] + 1548603684, 11) + RL108;
        int RL112 = m9163RL(RL107, 10);
        int RL113 = m9163RL(RL108 + m9167f4(RL111, RL109, RL112) + this.f7551X[14] + 1548603684, 7) + RL110;
        int RL114 = m9163RL(RL109, 10);
        int RL115 = m9163RL(RL110 + m9167f4(RL113, RL111, RL114) + this.f7551X[15] + 1548603684, 7) + RL112;
        int RL116 = m9163RL(RL111, 10);
        int RL117 = m9163RL(RL112 + m9167f4(RL115, RL113, RL116) + this.f7551X[8] + 1548603684, 12) + RL114;
        int RL118 = m9163RL(RL113, 10);
        int RL119 = m9163RL(RL114 + m9167f4(RL117, RL115, RL118) + this.f7551X[12] + 1548603684, 7) + RL116;
        int RL120 = m9163RL(RL115, 10);
        int RL121 = m9163RL(RL116 + m9167f4(RL119, RL117, RL120) + this.f7551X[4] + 1548603684, 6) + RL118;
        int RL122 = m9163RL(RL117, 10);
        int RL123 = m9163RL(RL118 + m9167f4(RL121, RL119, RL122) + this.f7551X[9] + 1548603684, 15) + RL120;
        int RL124 = m9163RL(RL119, 10);
        int RL125 = m9163RL(RL120 + m9167f4(RL123, RL121, RL124) + this.f7551X[1] + 1548603684, 13) + RL122;
        int RL126 = m9163RL(RL121, 10);
        int RL127 = m9163RL(RL122 + m9167f4(RL125, RL123, RL126) + this.f7551X[2] + 1548603684, 11) + RL124;
        int RL128 = m9163RL(RL123, 10);
        int RL129 = m9163RL(RL92 + m9166f3(RL95, RL93, RL96) + this.f7551X[3] + 1859775393, 11) + RL94;
        int RL130 = m9163RL(RL93, 10);
        int RL131 = m9163RL(RL94 + m9166f3(RL129, RL95, RL130) + this.f7551X[10] + 1859775393, 13) + RL96;
        int RL132 = m9163RL(RL95, 10);
        int RL133 = m9163RL(RL96 + m9166f3(RL131, RL129, RL132) + this.f7551X[14] + 1859775393, 6) + RL130;
        int RL134 = m9163RL(RL129, 10);
        int RL135 = m9163RL(RL130 + m9166f3(RL133, RL131, RL134) + this.f7551X[4] + 1859775393, 7) + RL132;
        int RL136 = m9163RL(RL131, 10);
        int RL137 = m9163RL(RL132 + m9166f3(RL135, RL133, RL136) + this.f7551X[9] + 1859775393, 14) + RL134;
        int RL138 = m9163RL(RL133, 10);
        int RL139 = m9163RL(RL134 + m9166f3(RL137, RL135, RL138) + this.f7551X[15] + 1859775393, 9) + RL136;
        int RL140 = m9163RL(RL135, 10);
        int RL141 = m9163RL(RL136 + m9166f3(RL139, RL137, RL140) + this.f7551X[8] + 1859775393, 13) + RL138;
        int RL142 = m9163RL(RL137, 10);
        int RL143 = m9163RL(RL138 + m9166f3(RL141, RL139, RL142) + this.f7551X[1] + 1859775393, 15) + RL140;
        int RL144 = m9163RL(RL139, 10);
        int RL145 = m9163RL(RL140 + m9166f3(RL143, RL141, RL144) + this.f7551X[2] + 1859775393, 14) + RL142;
        int RL146 = m9163RL(RL141, 10);
        int RL147 = m9163RL(RL142 + m9166f3(RL145, RL143, RL146) + this.f7551X[7] + 1859775393, 8) + RL144;
        int RL148 = m9163RL(RL143, 10);
        int RL149 = m9163RL(RL144 + m9166f3(RL147, RL145, RL148) + this.f7551X[0] + 1859775393, 13) + RL146;
        int RL150 = m9163RL(RL145, 10);
        int RL151 = m9163RL(RL146 + m9166f3(RL149, RL147, RL150) + this.f7551X[6] + 1859775393, 6) + RL148;
        int RL152 = m9163RL(RL147, 10);
        int RL153 = m9163RL(RL148 + m9166f3(RL151, RL149, RL152) + this.f7551X[13] + 1859775393, 5) + RL150;
        int RL154 = m9163RL(RL149, 10);
        int RL155 = m9163RL(RL150 + m9166f3(RL153, RL151, RL154) + this.f7551X[11] + 1859775393, 12) + RL152;
        int RL156 = m9163RL(RL151, 10);
        int RL157 = m9163RL(RL152 + m9166f3(RL155, RL153, RL156) + this.f7551X[5] + 1859775393, 7) + RL154;
        int RL158 = m9163RL(RL153, 10);
        int RL159 = m9163RL(RL154 + m9166f3(RL157, RL155, RL158) + this.f7551X[12] + 1859775393, 5) + RL156;
        int RL160 = m9163RL(RL155, 10);
        int RL161 = m9163RL(RL124 + m9166f3(RL127, RL125, RL128) + this.f7551X[15] + 1836072691, 9) + RL126;
        int RL162 = m9163RL(RL125, 10);
        int RL163 = m9163RL(RL126 + m9166f3(RL161, RL127, RL162) + this.f7551X[5] + 1836072691, 7) + RL128;
        int RL164 = m9163RL(RL127, 10);
        int RL165 = m9163RL(RL128 + m9166f3(RL163, RL161, RL164) + this.f7551X[1] + 1836072691, 15) + RL162;
        int RL166 = m9163RL(RL161, 10);
        int RL167 = m9163RL(RL162 + m9166f3(RL165, RL163, RL166) + this.f7551X[3] + 1836072691, 11) + RL164;
        int RL168 = m9163RL(RL163, 10);
        int RL169 = m9163RL(RL164 + m9166f3(RL167, RL165, RL168) + this.f7551X[7] + 1836072691, 8) + RL166;
        int RL170 = m9163RL(RL165, 10);
        int RL171 = m9163RL(RL166 + m9166f3(RL169, RL167, RL170) + this.f7551X[14] + 1836072691, 6) + RL168;
        int RL172 = m9163RL(RL167, 10);
        int RL173 = m9163RL(RL168 + m9166f3(RL171, RL169, RL172) + this.f7551X[6] + 1836072691, 6) + RL170;
        int RL174 = m9163RL(RL169, 10);
        int RL175 = m9163RL(RL170 + m9166f3(RL173, RL171, RL174) + this.f7551X[9] + 1836072691, 14) + RL172;
        int RL176 = m9163RL(RL171, 10);
        int RL177 = m9163RL(RL172 + m9166f3(RL175, RL173, RL176) + this.f7551X[11] + 1836072691, 12) + RL174;
        int RL178 = m9163RL(RL173, 10);
        int RL179 = m9163RL(RL174 + m9166f3(RL177, RL175, RL178) + this.f7551X[8] + 1836072691, 13) + RL176;
        int RL180 = m9163RL(RL175, 10);
        int RL181 = m9163RL(RL176 + m9166f3(RL179, RL177, RL180) + this.f7551X[12] + 1836072691, 5) + RL178;
        int RL182 = m9163RL(RL177, 10);
        int RL183 = m9163RL(RL178 + m9166f3(RL181, RL179, RL182) + this.f7551X[2] + 1836072691, 14) + RL180;
        int RL184 = m9163RL(RL179, 10);
        int RL185 = m9163RL(RL180 + m9166f3(RL183, RL181, RL184) + this.f7551X[10] + 1836072691, 13) + RL182;
        int RL186 = m9163RL(RL181, 10);
        int RL187 = m9163RL(RL182 + m9166f3(RL185, RL183, RL186) + this.f7551X[0] + 1836072691, 13) + RL184;
        int RL188 = m9163RL(RL183, 10);
        int RL189 = m9163RL(RL184 + m9166f3(RL187, RL185, RL188) + this.f7551X[4] + 1836072691, 7) + RL186;
        int RL190 = m9163RL(RL185, 10);
        int RL191 = m9163RL(RL186 + m9166f3(RL189, RL187, RL190) + this.f7551X[13] + 1836072691, 5) + RL188;
        int RL192 = m9163RL(RL187, 10);
        int RL193 = m9163RL(((RL156 + m9167f4(RL159, RL157, RL160)) + this.f7551X[1]) - 1894007588, 11) + RL158;
        int RL194 = m9163RL(RL157, 10);
        int RL195 = m9163RL(((RL158 + m9167f4(RL193, RL159, RL194)) + this.f7551X[9]) - 1894007588, 12) + RL160;
        int RL196 = m9163RL(RL159, 10);
        int RL197 = m9163RL(((RL160 + m9167f4(RL195, RL193, RL196)) + this.f7551X[11]) - 1894007588, 14) + RL194;
        int RL198 = m9163RL(RL193, 10);
        int RL199 = m9163RL(((RL194 + m9167f4(RL197, RL195, RL198)) + this.f7551X[10]) - 1894007588, 15) + RL196;
        int RL200 = m9163RL(RL195, 10);
        int RL201 = m9163RL(((RL196 + m9167f4(RL199, RL197, RL200)) + this.f7551X[0]) - 1894007588, 14) + RL198;
        int RL202 = m9163RL(RL197, 10);
        int RL203 = m9163RL(((RL198 + m9167f4(RL201, RL199, RL202)) + this.f7551X[8]) - 1894007588, 15) + RL200;
        int RL204 = m9163RL(RL199, 10);
        int RL205 = m9163RL(((RL200 + m9167f4(RL203, RL201, RL204)) + this.f7551X[12]) - 1894007588, 9) + RL202;
        int RL206 = m9163RL(RL201, 10);
        int RL207 = m9163RL(((RL202 + m9167f4(RL205, RL203, RL206)) + this.f7551X[4]) - 1894007588, 8) + RL204;
        int RL208 = m9163RL(RL203, 10);
        int RL209 = m9163RL(((RL204 + m9167f4(RL207, RL205, RL208)) + this.f7551X[13]) - 1894007588, 9) + RL206;
        int RL210 = m9163RL(RL205, 10);
        int RL211 = m9163RL(((RL206 + m9167f4(RL209, RL207, RL210)) + this.f7551X[3]) - 1894007588, 14) + RL208;
        int RL212 = m9163RL(RL207, 10);
        int RL213 = m9163RL(((RL208 + m9167f4(RL211, RL209, RL212)) + this.f7551X[7]) - 1894007588, 5) + RL210;
        int RL214 = m9163RL(RL209, 10);
        int RL215 = m9163RL(((RL210 + m9167f4(RL213, RL211, RL214)) + this.f7551X[15]) - 1894007588, 6) + RL212;
        int RL216 = m9163RL(RL211, 10);
        int RL217 = m9163RL(((RL212 + m9167f4(RL215, RL213, RL216)) + this.f7551X[14]) - 1894007588, 8) + RL214;
        int RL218 = m9163RL(RL213, 10);
        int RL219 = m9163RL(((RL214 + m9167f4(RL217, RL215, RL218)) + this.f7551X[5]) - 1894007588, 6) + RL216;
        int RL220 = m9163RL(RL215, 10);
        int RL221 = m9163RL(((RL216 + m9167f4(RL219, RL217, RL220)) + this.f7551X[6]) - 1894007588, 5) + RL218;
        int RL222 = m9163RL(RL217, 10);
        int RL223 = m9163RL(((RL218 + m9167f4(RL221, RL219, RL222)) + this.f7551X[2]) - 1894007588, 12) + RL220;
        int RL224 = m9163RL(RL219, 10);
        int RL225 = m9163RL(RL188 + m9165f2(RL191, RL189, RL192) + this.f7551X[8] + 2053994217, 15) + RL190;
        int RL226 = m9163RL(RL189, 10);
        int RL227 = m9163RL(RL190 + m9165f2(RL225, RL191, RL226) + this.f7551X[6] + 2053994217, 5) + RL192;
        int RL228 = m9163RL(RL191, 10);
        int RL229 = m9163RL(RL192 + m9165f2(RL227, RL225, RL228) + this.f7551X[4] + 2053994217, 8) + RL226;
        int RL230 = m9163RL(RL225, 10);
        int RL231 = m9163RL(RL226 + m9165f2(RL229, RL227, RL230) + this.f7551X[1] + 2053994217, 11) + RL228;
        int RL232 = m9163RL(RL227, 10);
        int RL233 = m9163RL(RL228 + m9165f2(RL231, RL229, RL232) + this.f7551X[3] + 2053994217, 14) + RL230;
        int RL234 = m9163RL(RL229, 10);
        int RL235 = m9163RL(RL230 + m9165f2(RL233, RL231, RL234) + this.f7551X[11] + 2053994217, 14) + RL232;
        int RL236 = m9163RL(RL231, 10);
        int RL237 = m9163RL(RL232 + m9165f2(RL235, RL233, RL236) + this.f7551X[15] + 2053994217, 6) + RL234;
        int RL238 = m9163RL(RL233, 10);
        int RL239 = m9163RL(RL234 + m9165f2(RL237, RL235, RL238) + this.f7551X[0] + 2053994217, 14) + RL236;
        int RL240 = m9163RL(RL235, 10);
        int RL241 = m9163RL(RL236 + m9165f2(RL239, RL237, RL240) + this.f7551X[5] + 2053994217, 6) + RL238;
        int RL242 = m9163RL(RL237, 10);
        int RL243 = m9163RL(RL238 + m9165f2(RL241, RL239, RL242) + this.f7551X[12] + 2053994217, 9) + RL240;
        int RL244 = m9163RL(RL239, 10);
        int RL245 = m9163RL(RL240 + m9165f2(RL243, RL241, RL244) + this.f7551X[2] + 2053994217, 12) + RL242;
        int RL246 = m9163RL(RL241, 10);
        int RL247 = m9163RL(RL242 + m9165f2(RL245, RL243, RL246) + this.f7551X[13] + 2053994217, 9) + RL244;
        int RL248 = m9163RL(RL243, 10);
        int RL249 = m9163RL(RL244 + m9165f2(RL247, RL245, RL248) + this.f7551X[9] + 2053994217, 12) + RL246;
        int RL250 = m9163RL(RL245, 10);
        int RL251 = m9163RL(RL246 + m9165f2(RL249, RL247, RL250) + this.f7551X[7] + 2053994217, 5) + RL248;
        int RL252 = m9163RL(RL247, 10);
        int RL253 = m9163RL(RL248 + m9165f2(RL251, RL249, RL252) + this.f7551X[10] + 2053994217, 15) + RL250;
        int RL254 = m9163RL(RL249, 10);
        int RL255 = m9163RL(RL250 + m9165f2(RL253, RL251, RL254) + this.f7551X[14] + 2053994217, 8) + RL252;
        int RL256 = m9163RL(RL251, 10);
        int RL257 = m9163RL(((RL220 + m9168f5(RL223, RL221, RL224)) + this.f7551X[4]) - 1454113458, 9) + RL222;
        int RL258 = m9163RL(RL221, 10);
        int RL259 = m9163RL(((RL222 + m9168f5(RL257, RL223, RL258)) + this.f7551X[0]) - 1454113458, 15) + RL224;
        int RL260 = m9163RL(RL223, 10);
        int RL261 = m9163RL(((RL224 + m9168f5(RL259, RL257, RL260)) + this.f7551X[5]) - 1454113458, 5) + RL258;
        int RL262 = m9163RL(RL257, 10);
        int RL263 = m9163RL(((RL258 + m9168f5(RL261, RL259, RL262)) + this.f7551X[9]) - 1454113458, 11) + RL260;
        int RL264 = m9163RL(RL259, 10);
        int RL265 = m9163RL(((RL260 + m9168f5(RL263, RL261, RL264)) + this.f7551X[7]) - 1454113458, 6) + RL262;
        int RL266 = m9163RL(RL261, 10);
        int RL267 = m9163RL(((RL262 + m9168f5(RL265, RL263, RL266)) + this.f7551X[12]) - 1454113458, 8) + RL264;
        int RL268 = m9163RL(RL263, 10);
        int RL269 = m9163RL(((RL264 + m9168f5(RL267, RL265, RL268)) + this.f7551X[2]) - 1454113458, 13) + RL266;
        int RL270 = m9163RL(RL265, 10);
        int RL271 = m9163RL(((RL266 + m9168f5(RL269, RL267, RL270)) + this.f7551X[10]) - 1454113458, 12) + RL268;
        int RL272 = m9163RL(RL267, 10);
        int RL273 = m9163RL(((RL268 + m9168f5(RL271, RL269, RL272)) + this.f7551X[14]) - 1454113458, 5) + RL270;
        int RL274 = m9163RL(RL269, 10);
        int RL275 = m9163RL(((RL270 + m9168f5(RL273, RL271, RL274)) + this.f7551X[1]) - 1454113458, 12) + RL272;
        int RL276 = m9163RL(RL271, 10);
        int RL277 = m9163RL(((RL272 + m9168f5(RL275, RL273, RL276)) + this.f7551X[3]) - 1454113458, 13) + RL274;
        int RL278 = m9163RL(RL273, 10);
        int RL279 = m9163RL(((RL274 + m9168f5(RL277, RL275, RL278)) + this.f7551X[8]) - 1454113458, 14) + RL276;
        int RL280 = m9163RL(RL275, 10);
        int RL281 = m9163RL(((RL276 + m9168f5(RL279, RL277, RL280)) + this.f7551X[11]) - 1454113458, 11) + RL278;
        int RL282 = m9163RL(RL277, 10);
        int RL283 = m9163RL(((RL278 + m9168f5(RL281, RL279, RL282)) + this.f7551X[6]) - 1454113458, 8) + RL280;
        int RL284 = m9163RL(RL279, 10);
        int RL285 = m9163RL(((RL280 + m9168f5(RL283, RL281, RL284)) + this.f7551X[15]) - 1454113458, 5) + RL282;
        int RL286 = m9163RL(RL281, 10);
        int RL287 = m9163RL(RL283, 10);
        int RL288 = m9163RL(RL252 + m9164f1(RL255, RL253, RL256) + this.f7551X[12], 8) + RL254;
        int RL289 = m9163RL(RL253, 10);
        int RL290 = m9163RL(RL254 + m9164f1(RL288, RL255, RL289) + this.f7551X[15], 5) + RL256;
        int RL291 = m9163RL(RL255, 10);
        int RL292 = m9163RL(RL256 + m9164f1(RL290, RL288, RL291) + this.f7551X[10], 12) + RL289;
        int RL293 = m9163RL(RL288, 10);
        int RL294 = m9163RL(RL289 + m9164f1(RL292, RL290, RL293) + this.f7551X[4], 9) + RL291;
        int RL295 = m9163RL(RL290, 10);
        int RL296 = m9163RL(RL291 + m9164f1(RL294, RL292, RL295) + this.f7551X[1], 12) + RL293;
        int RL297 = m9163RL(RL292, 10);
        int RL298 = m9163RL(RL293 + m9164f1(RL296, RL294, RL297) + this.f7551X[5], 5) + RL295;
        int RL299 = m9163RL(RL294, 10);
        int RL300 = m9163RL(RL295 + m9164f1(RL298, RL296, RL299) + this.f7551X[8], 14) + RL297;
        int RL301 = m9163RL(RL296, 10);
        int RL302 = m9163RL(RL297 + m9164f1(RL300, RL298, RL301) + this.f7551X[7], 6) + RL299;
        int RL303 = m9163RL(RL298, 10);
        int RL304 = m9163RL(RL299 + m9164f1(RL302, RL300, RL303) + this.f7551X[6], 8) + RL301;
        int RL305 = m9163RL(RL300, 10);
        int RL306 = m9163RL(RL301 + m9164f1(RL304, RL302, RL305) + this.f7551X[2], 13) + RL303;
        int RL307 = m9163RL(RL302, 10);
        int RL308 = m9163RL(RL303 + m9164f1(RL306, RL304, RL307) + this.f7551X[13], 6) + RL305;
        int RL309 = m9163RL(RL304, 10);
        int RL310 = m9163RL(RL305 + m9164f1(RL308, RL306, RL309) + this.f7551X[14], 5) + RL307;
        int RL311 = m9163RL(RL306, 10);
        int RL312 = m9163RL(RL307 + m9164f1(RL310, RL308, RL311) + this.f7551X[0], 15) + RL309;
        int RL313 = m9163RL(RL308, 10);
        int RL314 = m9163RL(RL309 + m9164f1(RL312, RL310, RL313) + this.f7551X[3], 13) + RL311;
        int RL315 = m9163RL(RL310, 10);
        int RL316 = m9163RL(RL311 + m9164f1(RL314, RL312, RL315) + this.f7551X[9], 11) + RL313;
        int RL317 = m9163RL(RL312, 10);
        int RL318 = m9163RL(RL313 + m9164f1(RL316, RL314, RL317) + this.f7551X[11], 11) + RL315;
        this.f7547H1 = this.f7548H2 + RL287 + RL317;
        this.f7548H2 = this.f7549H3 + RL286 + RL315;
        this.f7549H3 = this.f7550H4 + RL284 + RL318;
        this.f7550H4 = this.f7546H0 + m9163RL(((RL282 + m9168f5(RL285, RL283, RL286)) + this.f7551X[13]) - 1454113458, 6) + RL284 + RL316;
        this.f7546H0 = m9163RL(RL314, 10) + RL285 + this.f7547H1;
        int i6 = 0;
        this.xOff = 0;
        while (true) {
            int[] iArr = this.f7551X;
            if (i6 != iArr.length) {
                iArr[i6] = 0;
                i6++;
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
        int[] iArr = this.f7551X;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f7551X;
        int i2 = this.xOff;
        this.xOff = i2 + 1;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Tnaf.POW_2_WIDTH);
        if (this.xOff == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.f7546H0 = 1732584193;
        this.f7547H1 = -271733879;
        this.f7548H2 = -1732584194;
        this.f7549H3 = 271733878;
        this.f7550H4 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f7551X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        copyIn((RIPEMD160Digest) memoable);
    }
}

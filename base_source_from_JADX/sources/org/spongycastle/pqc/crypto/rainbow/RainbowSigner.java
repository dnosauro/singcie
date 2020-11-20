package org.spongycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowSigner implements MessageSigner {
    private static final int MAXITS = 65536;

    /* renamed from: cf */
    private ComputeInField f8220cf = new ComputeInField();
    RainbowKeyParameters key;
    private SecureRandom random;
    int signableDocumentLength;

    /* renamed from: x */
    private short[] f8221x;

    private short[] initSign(Layer[] layerArr, short[] sArr) {
        short[] sArr2 = new short[sArr.length];
        short[] multiplyMatrix = this.f8220cf.multiplyMatrix(((RainbowPrivateKeyParameters) this.key).getInvA1(), this.f8220cf.addVect(((RainbowPrivateKeyParameters) this.key).getB1(), sArr));
        for (int i = 0; i < layerArr[0].getVi(); i++) {
            this.f8221x[i] = (short) this.random.nextInt();
            short[] sArr3 = this.f8221x;
            sArr3[i] = (short) (sArr3[i] & 255);
        }
        return multiplyMatrix;
    }

    private short[] makeMessageRepresentative(byte[] bArr) {
        short[] sArr = new short[this.signableDocumentLength];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            sArr[i] = (short) bArr[i2];
            sArr[i] = (short) (sArr[i] & 255);
            i2++;
            i++;
            if (i >= sArr.length) {
                break;
            }
        }
        return sArr;
    }

    private short[] verifySignatureIntern(short[] sArr) {
        short[][] coeffQuadratic = ((RainbowPublicKeyParameters) this.key).getCoeffQuadratic();
        short[][] coeffSingular = ((RainbowPublicKeyParameters) this.key).getCoeffSingular();
        short[] coeffScalar = ((RainbowPublicKeyParameters) this.key).getCoeffScalar();
        short[] sArr2 = new short[coeffQuadratic.length];
        int length = coeffSingular[0].length;
        for (int i = 0; i < coeffQuadratic.length; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3;
                for (int i5 = i2; i5 < length; i5++) {
                    sArr2[i] = GF2Field.addElem(sArr2[i], GF2Field.multElem(coeffQuadratic[i][i4], GF2Field.multElem(sArr[i2], sArr[i5])));
                    i4++;
                }
                sArr2[i] = GF2Field.addElem(sArr2[i], GF2Field.multElem(coeffSingular[i][i2], sArr[i2]));
                i2++;
                i3 = i4;
            }
            sArr2[i] = GF2Field.addElem(sArr2[i], coeffScalar[i]);
        }
        return sArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a3 A[Catch:{ Exception -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x002e A[Catch:{ Exception -> 0x00ad }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] generateSignature(byte[] r14) {
        /*
            r13 = this;
            org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters r0 = r13.key
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r0 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r0
            org.spongycastle.pqc.crypto.rainbow.Layer[] r0 = r0.getLayers()
            int r1 = r0.length
            org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters r2 = r13.key
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r2 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r2
            short[][] r2 = r2.getInvA2()
            int r2 = r2.length
            short[] r2 = new short[r2]
            r13.f8221x = r2
            int r2 = r1 + -1
            r2 = r0[r2]
            int r2 = r2.getViNext()
            byte[] r2 = new byte[r2]
            short[] r14 = r13.makeMessageRepresentative(r14)
            r3 = 0
            r4 = 0
        L_0x0026:
            short[] r5 = r13.initSign(r0, r14)     // Catch:{ Exception -> 0x00ad }
            r6 = 0
            r7 = 0
        L_0x002c:
            if (r6 >= r1) goto L_0x0081
            r8 = r0[r6]     // Catch:{ Exception -> 0x00ad }
            int r8 = r8.getOi()     // Catch:{ Exception -> 0x00ad }
            short[] r8 = new short[r8]     // Catch:{ Exception -> 0x00ad }
            r9 = r0[r6]     // Catch:{ Exception -> 0x00ad }
            int r9 = r9.getOi()     // Catch:{ Exception -> 0x00ad }
            short[] r9 = new short[r9]     // Catch:{ Exception -> 0x00ad }
            r9 = r7
            r7 = 0
        L_0x0040:
            r10 = r0[r6]     // Catch:{ Exception -> 0x00ad }
            int r10 = r10.getOi()     // Catch:{ Exception -> 0x00ad }
            if (r7 >= r10) goto L_0x0051
            short r10 = r5[r9]     // Catch:{ Exception -> 0x00ad }
            r8[r7] = r10     // Catch:{ Exception -> 0x00ad }
            int r9 = r9 + 1
            int r7 = r7 + 1
            goto L_0x0040
        L_0x0051:
            org.spongycastle.pqc.crypto.rainbow.util.ComputeInField r7 = r13.f8220cf     // Catch:{ Exception -> 0x00ad }
            r10 = r0[r6]     // Catch:{ Exception -> 0x00ad }
            short[] r11 = r13.f8221x     // Catch:{ Exception -> 0x00ad }
            short[][] r10 = r10.plugInVinegars(r11)     // Catch:{ Exception -> 0x00ad }
            short[] r7 = r7.solveEquation(r10, r8)     // Catch:{ Exception -> 0x00ad }
            if (r7 == 0) goto L_0x0079
            r8 = 0
        L_0x0062:
            int r10 = r7.length     // Catch:{ Exception -> 0x00ad }
            if (r8 >= r10) goto L_0x0075
            short[] r10 = r13.f8221x     // Catch:{ Exception -> 0x00ad }
            r11 = r0[r6]     // Catch:{ Exception -> 0x00ad }
            int r11 = r11.getVi()     // Catch:{ Exception -> 0x00ad }
            int r11 = r11 + r8
            short r12 = r7[r8]     // Catch:{ Exception -> 0x00ad }
            r10[r11] = r12     // Catch:{ Exception -> 0x00ad }
            int r8 = r8 + 1
            goto L_0x0062
        L_0x0075:
            int r6 = r6 + 1
            r7 = r9
            goto L_0x002c
        L_0x0079:
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x00ad }
            java.lang.String r6 = "LES is not solveable!"
            r5.<init>(r6)     // Catch:{ Exception -> 0x00ad }
            throw r5     // Catch:{ Exception -> 0x00ad }
        L_0x0081:
            org.spongycastle.pqc.crypto.rainbow.util.ComputeInField r5 = r13.f8220cf     // Catch:{ Exception -> 0x00ad }
            org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters r6 = r13.key     // Catch:{ Exception -> 0x00ad }
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r6 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r6     // Catch:{ Exception -> 0x00ad }
            short[] r6 = r6.getB2()     // Catch:{ Exception -> 0x00ad }
            short[] r7 = r13.f8221x     // Catch:{ Exception -> 0x00ad }
            short[] r5 = r5.addVect(r6, r7)     // Catch:{ Exception -> 0x00ad }
            org.spongycastle.pqc.crypto.rainbow.util.ComputeInField r6 = r13.f8220cf     // Catch:{ Exception -> 0x00ad }
            org.spongycastle.pqc.crypto.rainbow.RainbowKeyParameters r7 = r13.key     // Catch:{ Exception -> 0x00ad }
            org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters r7 = (org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters) r7     // Catch:{ Exception -> 0x00ad }
            short[][] r7 = r7.getInvA2()     // Catch:{ Exception -> 0x00ad }
            short[] r5 = r6.multiplyMatrix((short[][]) r7, (short[]) r5)     // Catch:{ Exception -> 0x00ad }
            r6 = 0
        L_0x00a0:
            int r7 = r2.length     // Catch:{ Exception -> 0x00ad }
            if (r6 >= r7) goto L_0x00ab
            short r7 = r5[r6]     // Catch:{ Exception -> 0x00ad }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x00ad }
            r2[r6] = r7     // Catch:{ Exception -> 0x00ad }
            int r6 = r6 + 1
            goto L_0x00a0
        L_0x00ab:
            r5 = 1
            goto L_0x00ae
        L_0x00ad:
            r5 = 0
        L_0x00ae:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r5 != 0) goto L_0x00b6
            int r4 = r4 + 1
            if (r4 < r6) goto L_0x0026
        L_0x00b6:
            if (r4 == r6) goto L_0x00b9
            return r2
        L_0x00b9:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "unable to generate signature - LES not solvable"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.rainbow.RainbowSigner.generateSignature(byte[]):byte[]");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        RainbowKeyParameters rainbowKeyParameters;
        if (!z) {
            rainbowKeyParameters = (RainbowPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            this.key = (RainbowPrivateKeyParameters) parametersWithRandom.getParameters();
            this.signableDocumentLength = this.key.getDocLength();
        } else {
            this.random = new SecureRandom();
            rainbowKeyParameters = (RainbowPrivateKeyParameters) cipherParameters;
        }
        this.key = rainbowKeyParameters;
        this.signableDocumentLength = this.key.getDocLength();
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        short[] sArr = new short[bArr2.length];
        for (int i = 0; i < bArr2.length; i++) {
            sArr[i] = (short) (((short) bArr2[i]) & 255);
        }
        short[] makeMessageRepresentative = makeMessageRepresentative(bArr);
        short[] verifySignatureIntern = verifySignatureIntern(sArr);
        if (makeMessageRepresentative.length != verifySignatureIntern.length) {
            return false;
        }
        boolean z = true;
        for (int i2 = 0; i2 < makeMessageRepresentative.length; i2++) {
            z = z && makeMessageRepresentative[i2] == verifySignatureIntern[i2];
        }
        return z;
    }
}

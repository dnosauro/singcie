package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFFeedbackParameters;
import org.spongycastle.crypto.params.KeyParameter;

public class KDFFeedbackBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h */
    private final int f7751h;
    private byte[] ios;

    /* renamed from: iv */
    private byte[] f7752iv;

    /* renamed from: k */
    private byte[] f7753k = new byte[this.f7751h];
    private int maxSizeExcl;
    private final Mac prf;
    private boolean useCounter;

    public KDFFeedbackBytesGenerator(Mac mac) {
        this.prf = mac;
        this.f7751h = mac.getMacSize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        r2 = r5.ios;
        r2[r2.length - 3] = (byte) (r0 >>> 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r2 = r5.ios;
        r2[r2.length - 2] = (byte) (r0 >>> 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r2 = r5.ios;
        r2[r2.length - 1] = (byte) r0;
        r5.prf.update(r2, 0, r2.length);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateNext() {
        /*
            r5 = this;
            int r0 = r5.generatedBytes
            r1 = 0
            if (r0 != 0) goto L_0x000b
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r2 = r5.f7752iv
            int r3 = r2.length
            goto L_0x0010
        L_0x000b:
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r2 = r5.f7753k
            int r3 = r2.length
        L_0x0010:
            r0.update(r2, r1, r3)
            boolean r0 = r5.useCounter
            if (r0 == 0) goto L_0x0053
            int r0 = r5.generatedBytes
            int r2 = r5.f7751h
            int r0 = r0 / r2
            int r0 = r0 + 1
            byte[] r2 = r5.ios
            int r3 = r2.length
            switch(r3) {
                case 1: goto L_0x0045;
                case 2: goto L_0x003b;
                case 3: goto L_0x0031;
                case 4: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unsupported size of counter i"
            r0.<init>(r1)
            throw r0
        L_0x002c:
            int r3 = r0 >>> 24
            byte r3 = (byte) r3
            r2[r1] = r3
        L_0x0031:
            byte[] r2 = r5.ios
            int r3 = r2.length
            int r3 = r3 + -3
            int r4 = r0 >>> 16
            byte r4 = (byte) r4
            r2[r3] = r4
        L_0x003b:
            byte[] r2 = r5.ios
            int r3 = r2.length
            int r3 = r3 + -2
            int r4 = r0 >>> 8
            byte r4 = (byte) r4
            r2[r3] = r4
        L_0x0045:
            byte[] r2 = r5.ios
            int r3 = r2.length
            int r3 = r3 + -1
            byte r0 = (byte) r0
            r2[r3] = r0
            org.spongycastle.crypto.Mac r0 = r5.prf
            int r3 = r2.length
            r0.update(r2, r1, r3)
        L_0x0053:
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r2 = r5.fixedInputData
            int r3 = r2.length
            r0.update(r2, r1, r3)
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r2 = r5.f7753k
            r0.doFinal(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.generators.KDFFeedbackBytesGenerator.generateNext():void");
    }

    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3 = this.generatedBytes;
        int i4 = i3 + i2;
        if (i4 < 0 || i4 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i3 % this.f7751h == 0) {
            generateNext();
        }
        int i5 = this.generatedBytes;
        int i6 = this.f7751h;
        int i7 = i5 % i6;
        int min = Math.min(i6 - (i5 % i6), i2);
        System.arraycopy(this.f7753k, i7, bArr, i, min);
        this.generatedBytes += min;
        int i8 = i2 - min;
        while (true) {
            i += min;
            if (i8 <= 0) {
                return i2;
            }
            generateNext();
            min = Math.min(this.f7751h, i8);
            System.arraycopy(this.f7753k, 0, bArr, i, min);
            this.generatedBytes += min;
            i8 -= min;
        }
    }

    public Mac getMac() {
        return this.prf;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFFeedbackParameters) {
            KDFFeedbackParameters kDFFeedbackParameters = (KDFFeedbackParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFFeedbackParameters.getKI()));
            this.fixedInputData = kDFFeedbackParameters.getFixedInputData();
            int r = kDFFeedbackParameters.getR();
            this.ios = new byte[(r / 8)];
            int i = Integer.MAX_VALUE;
            if (kDFFeedbackParameters.useCounter()) {
                BigInteger multiply = TWO.pow(r).multiply(BigInteger.valueOf((long) this.f7751h));
                if (multiply.compareTo(INTEGER_MAX) != 1) {
                    i = multiply.intValue();
                }
            }
            this.maxSizeExcl = i;
            this.f7752iv = kDFFeedbackParameters.getIV();
            this.useCounter = kDFFeedbackParameters.useCounter();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}

package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFCounterParameters;
import org.spongycastle.crypto.params.KeyParameter;

public class KDFCounterBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private byte[] fixedInputDataCtrPrefix;
    private byte[] fixedInputData_afterCtr;
    private int generatedBytes;

    /* renamed from: h */
    private final int f7746h;
    private byte[] ios;

    /* renamed from: k */
    private byte[] f7747k = new byte[this.f7746h];
    private int maxSizeExcl;
    private final Mac prf;

    public KDFCounterBytesGenerator(Mac mac) {
        this.prf = mac;
        this.f7746h = mac.getMacSize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        r1 = r5.ios;
        r1[r1.length - 3] = (byte) (r0 >>> 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        r1 = r5.ios;
        r1[r1.length - 2] = (byte) (r0 >>> 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r1 = r5.ios;
        r1[r1.length - 1] = (byte) r0;
        r0 = r5.prf;
        r1 = r5.fixedInputDataCtrPrefix;
        r0.update(r1, 0, r1.length);
        r0 = r5.prf;
        r1 = r5.ios;
        r0.update(r1, 0, r1.length);
        r0 = r5.prf;
        r1 = r5.fixedInputData_afterCtr;
        r0.update(r1, 0, r1.length);
        r5.prf.doFinal(r5.f7747k, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateNext() {
        /*
            r5 = this;
            int r0 = r5.generatedBytes
            int r1 = r5.f7746h
            int r0 = r0 / r1
            int r0 = r0 + 1
            byte[] r1 = r5.ios
            int r2 = r1.length
            r3 = 0
            switch(r2) {
                case 1: goto L_0x002f;
                case 2: goto L_0x0025;
                case 3: goto L_0x001b;
                case 4: goto L_0x0016;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unsupported size of counter i"
            r0.<init>(r1)
            throw r0
        L_0x0016:
            int r2 = r0 >>> 24
            byte r2 = (byte) r2
            r1[r3] = r2
        L_0x001b:
            byte[] r1 = r5.ios
            int r2 = r1.length
            int r2 = r2 + -3
            int r4 = r0 >>> 16
            byte r4 = (byte) r4
            r1[r2] = r4
        L_0x0025:
            byte[] r1 = r5.ios
            int r2 = r1.length
            int r2 = r2 + -2
            int r4 = r0 >>> 8
            byte r4 = (byte) r4
            r1[r2] = r4
        L_0x002f:
            byte[] r1 = r5.ios
            int r2 = r1.length
            int r2 = r2 + -1
            byte r0 = (byte) r0
            r1[r2] = r0
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r1 = r5.fixedInputDataCtrPrefix
            int r2 = r1.length
            r0.update(r1, r3, r2)
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r1 = r5.ios
            int r2 = r1.length
            r0.update(r1, r3, r2)
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r1 = r5.fixedInputData_afterCtr
            int r2 = r1.length
            r0.update(r1, r3, r2)
            org.spongycastle.crypto.Mac r0 = r5.prf
            byte[] r1 = r5.f7747k
            r0.doFinal(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.generators.KDFCounterBytesGenerator.generateNext():void");
    }

    public int generateBytes(byte[] bArr, int i, int i2) {
        int i3 = this.generatedBytes;
        int i4 = i3 + i2;
        if (i4 < 0 || i4 >= this.maxSizeExcl) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
        if (i3 % this.f7746h == 0) {
            generateNext();
        }
        int i5 = this.generatedBytes;
        int i6 = this.f7746h;
        int i7 = i5 % i6;
        int min = Math.min(i6 - (i5 % i6), i2);
        System.arraycopy(this.f7747k, i7, bArr, i, min);
        this.generatedBytes += min;
        int i8 = i2 - min;
        while (true) {
            i += min;
            if (i8 <= 0) {
                return i2;
            }
            generateNext();
            min = Math.min(this.f7746h, i8);
            System.arraycopy(this.f7747k, 0, bArr, i, min);
            this.generatedBytes += min;
            i8 -= min;
        }
    }

    public Mac getMac() {
        return this.prf;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFCounterParameters) {
            KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFCounterParameters.getKI()));
            this.fixedInputDataCtrPrefix = kDFCounterParameters.getFixedInputDataCounterPrefix();
            this.fixedInputData_afterCtr = kDFCounterParameters.getFixedInputDataCounterSuffix();
            int r = kDFCounterParameters.getR();
            this.ios = new byte[(r / 8)];
            BigInteger multiply = TWO.pow(r).multiply(BigInteger.valueOf((long) this.f7746h));
            this.maxSizeExcl = multiply.compareTo(INTEGER_MAX) == 1 ? Integer.MAX_VALUE : multiply.intValue();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}

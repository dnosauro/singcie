package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class VMPCMac implements Mac {

    /* renamed from: P */
    private byte[] f7787P = null;

    /* renamed from: T */
    private byte[] f7788T;

    /* renamed from: g */
    private byte f7789g;

    /* renamed from: n */
    private byte f7790n = 0;

    /* renamed from: s */
    private byte f7791s = 0;
    private byte[] workingIV;
    private byte[] workingKey;

    /* renamed from: x1 */
    private byte f7792x1;

    /* renamed from: x2 */
    private byte f7793x2;

    /* renamed from: x3 */
    private byte f7794x3;

    /* renamed from: x4 */
    private byte f7795x4;

    private void initKey(byte[] bArr, byte[] bArr2) {
        this.f7791s = 0;
        this.f7787P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f7787P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f7787P;
            int i3 = i2 & 255;
            this.f7791s = bArr3[(this.f7791s + bArr3[i3] + bArr[i2 % bArr.length]) & 255];
            byte b = bArr3[i3];
            byte b2 = this.f7791s;
            bArr3[i3] = bArr3[b2 & 255];
            bArr3[b2 & 255] = b;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f7787P;
            int i5 = i4 & 255;
            this.f7791s = bArr4[(this.f7791s + bArr4[i5] + bArr2[i4 % bArr2.length]) & 255];
            byte b3 = bArr4[i5];
            byte b4 = this.f7791s;
            bArr4[i5] = bArr4[b4 & 255];
            bArr4[b4 & 255] = b3;
        }
        this.f7790n = 0;
    }

    public int doFinal(byte[] bArr, int i) {
        for (int i2 = 1; i2 < 25; i2++) {
            byte[] bArr2 = this.f7787P;
            byte b = this.f7791s;
            byte b2 = this.f7790n;
            this.f7791s = bArr2[(b + bArr2[b2 & 255]) & 255];
            byte b3 = this.f7795x4;
            byte b4 = this.f7794x3;
            this.f7795x4 = bArr2[(b3 + b4 + i2) & 255];
            byte b5 = this.f7793x2;
            this.f7794x3 = bArr2[(b4 + b5 + i2) & 255];
            byte b6 = this.f7792x1;
            this.f7793x2 = bArr2[(b5 + b6 + i2) & 255];
            byte b7 = this.f7791s;
            this.f7792x1 = bArr2[(b6 + b7 + i2) & 255];
            byte[] bArr3 = this.f7788T;
            byte b8 = this.f7789g;
            bArr3[b8 & 31] = (byte) (bArr3[b8 & 31] ^ this.f7792x1);
            bArr3[(b8 + 1) & 31] = (byte) (bArr3[(b8 + 1) & 31] ^ this.f7793x2);
            bArr3[(b8 + 2) & 31] = (byte) (bArr3[(b8 + 2) & 31] ^ this.f7794x3);
            bArr3[(b8 + 3) & 31] = (byte) (bArr3[(b8 + 3) & 31] ^ this.f7795x4);
            this.f7789g = (byte) ((b8 + 4) & 31);
            byte b9 = bArr2[b2 & 255];
            bArr2[b2 & 255] = bArr2[b7 & 255];
            bArr2[b7 & 255] = b9;
            this.f7790n = (byte) ((b2 + 1) & 255);
        }
        for (int i3 = 0; i3 < 768; i3++) {
            byte[] bArr4 = this.f7787P;
            int i4 = i3 & 255;
            this.f7791s = bArr4[(this.f7791s + bArr4[i4] + this.f7788T[i3 & 31]) & 255];
            byte b10 = bArr4[i4];
            byte b11 = this.f7791s;
            bArr4[i4] = bArr4[b11 & 255];
            bArr4[b11 & 255] = b10;
        }
        byte[] bArr5 = new byte[20];
        for (int i5 = 0; i5 < 20; i5++) {
            byte[] bArr6 = this.f7787P;
            int i6 = i5 & 255;
            this.f7791s = bArr6[(this.f7791s + bArr6[i6]) & 255];
            byte b12 = this.f7791s;
            bArr5[i5] = bArr6[(bArr6[bArr6[b12 & 255] & 255] + 1) & 255];
            byte b13 = bArr6[i6];
            bArr6[i6] = bArr6[b12 & 255];
            bArr6[b12 & 255] = b13;
        }
        System.arraycopy(bArr5, 0, bArr, i, bArr5.length);
        reset();
        return bArr5.length;
    }

    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    public int getMacSize() {
        return 20;
    }

    public void init(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                this.workingIV = parametersWithIV.getIV();
                byte[] bArr = this.workingIV;
                if (bArr == null || bArr.length < 1 || bArr.length > 768) {
                    throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
                }
                this.workingKey = keyParameter.getKey();
                reset();
                return;
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    public void reset() {
        initKey(this.workingKey, this.workingIV);
        this.f7790n = 0;
        this.f7795x4 = 0;
        this.f7794x3 = 0;
        this.f7793x2 = 0;
        this.f7792x1 = 0;
        this.f7789g = 0;
        this.f7788T = new byte[32];
        for (int i = 0; i < 32; i++) {
            this.f7788T[i] = 0;
        }
    }

    public void update(byte b) {
        byte[] bArr = this.f7787P;
        byte b2 = this.f7791s;
        byte b3 = this.f7790n;
        this.f7791s = bArr[(b2 + bArr[b3 & 255]) & 255];
        byte b4 = this.f7791s;
        byte b5 = this.f7795x4;
        byte b6 = this.f7794x3;
        this.f7795x4 = bArr[(b5 + b6) & 255];
        byte b7 = this.f7793x2;
        this.f7794x3 = bArr[(b6 + b7) & 255];
        byte b8 = this.f7792x1;
        this.f7793x2 = bArr[(b7 + b8) & 255];
        this.f7792x1 = bArr[(b8 + b4 + ((byte) (b ^ bArr[(bArr[bArr[b4 & 255] & 255] + 1) & 255]))) & 255];
        byte[] bArr2 = this.f7788T;
        byte b9 = this.f7789g;
        bArr2[b9 & 31] = (byte) (bArr2[b9 & 31] ^ this.f7792x1);
        bArr2[(b9 + 1) & 31] = (byte) (bArr2[(b9 + 1) & 31] ^ this.f7793x2);
        bArr2[(b9 + 2) & 31] = (byte) (bArr2[(b9 + 2) & 31] ^ this.f7794x3);
        bArr2[(b9 + 3) & 31] = (byte) (bArr2[(b9 + 3) & 31] ^ this.f7795x4);
        this.f7789g = (byte) ((b9 + 4) & 31);
        byte b10 = bArr[b3 & 255];
        bArr[b3 & 255] = bArr[b4 & 255];
        bArr[b4 & 255] = b10;
        this.f7790n = (byte) ((b3 + 1) & 255);
    }

    public void update(byte[] bArr, int i, int i2) {
        if (i + i2 <= bArr.length) {
            for (int i3 = 0; i3 < i2; i3++) {
                update(bArr[i + i3]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }
}
